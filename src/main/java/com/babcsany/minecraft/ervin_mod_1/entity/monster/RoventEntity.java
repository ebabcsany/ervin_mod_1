package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;
import java.util.UUID;

public class RoventEntity extends MonsterEntity {
   private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
   private static final AttributeModifier BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);
   private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.createKey(RoventEntity.class, DataSerializers.BOOLEAN);
   public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;

   public RoventEntity(EntityType<? extends RoventEntity> type, World worldIn) {
      super(type, worldIn);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
      this.applyEntityAI();
   }

   protected void applyEntityAI() {
      this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(ZombifiedPiglinEntity.class));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(AbstractFishEntity.class));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PatrollerEntity.class, true));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TurtleEntity.class, 10, true, false, TurtleEntity.TARGET_DRY_BABY));
   }

   public static AttributeModifierMap.MutableAttribute func_234342_eQ_() {
      return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.23F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D).createMutableAttribute(Attributes.ARMOR, 2.0D).createMutableAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS);
   }

   /**
    * If Animal, checks if the age timer is negative
    */
   public boolean isChild() {
      return this.getDataManager().get(IS_CHILD);
   }

   /**
    * Get the experience points the entity currently has.
    */
   protected int getExperiencePoints(PlayerEntity player) {
      if (this.isChild()) {
         this.experienceValue = (int)((float)this.experienceValue * 2.5F);
      }

      return super.getExperiencePoints(player);
   }

   /**
    * Set whether this zombie is a child.
    */
   public void setChild(boolean childZombie) {
      this.getDataManager().set(IS_CHILD, childZombie);
      if (this.world != null && !this.world.isRemote) {
         ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
         modifiableattributeinstance.removeModifier(BABY_SPEED_BOOST);
         if (childZombie) {
            modifiableattributeinstance.applyNonPersistentModifier(BABY_SPEED_BOOST);
         }
      }

   }

   public void notifyDataManagerChange(DataParameter<?> key) {
      if (IS_CHILD.equals(key)) {
         this.recalculateSize();
      }

      super.notifyDataManagerChange(key);
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      if (this.isAlive()) {
         boolean flag = this.shouldBurnInDay() && this.isInDaylight();
         if (flag) {
            ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (!itemstack.isEmpty()) {
               if (itemstack.isDamageable()) {
                  itemstack.setDamage(itemstack.getDamage() + this.rand.nextInt(2));
                  if (itemstack.getDamage() >= itemstack.getMaxDamage()) {
                     this.sendBreakAnimation(EquipmentSlotType.HEAD);
                     this.setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                  }
               }

               flag = false;
            }

            if (flag) {
               this.setFire(8);
            }
         }
      }

      super.livingTick();

      Vector3d vector3d = this.getMotion();
      if (!this.onGround && vector3d.y < 0.0D) {
         this.setMotion(vector3d.mul(1.0D, 0.6D, 1.0D));
      }

      if (!this.world.isRemote && this.isAlive() && !this.isChild() && --this.timeUntilNextItem <= 0) {
         this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
         this.entityDropItem(ItemInit.KIRT.get());
         this.timeUntilNextItem = this.rand.nextInt(6000) + 6000;
      }

      if (!this.world.isRemote && this.isAlive() && !this.isChild() && --this.timeUntilNextItem <= 0) {
         this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
         this.entityDropItem(isBurnableItemInit.LEAT.get());
         this.timeUntilNextItem = this.rand.nextInt(6000) + 6000;
      }
   }

   protected boolean shouldBurnInDay() {
      return true;
   }

   public boolean attackEntityAsMob(Entity entityIn) {
      boolean flag = super.attackEntityAsMob(entityIn);
      if (flag) {
         float f = this.world.getDifficultyForLocation(this.getPosition()).getAdditionalDifficulty();
         if (this.getHeldItemMainhand().isEmpty() && this.isBurning() && this.rand.nextFloat() < f * 0.3F) {
            entityIn.setFire(2 * (int)f);
         }
      }

      return flag;
   }

   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_ZOMBIE_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_ZOMBIE_DEATH;
   }

   protected SoundEvent getStepSound() {
      return SoundEvents.ENTITY_ZOMBIE_STEP;
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(this.getStepSound(), 0.15F, 1.0F);
   }

   public CreatureAttribute getCreatureAttribute() {
      return CreatureAttribute.UNDEAD;
   }

   /**
    * Gives armor or weapon for entity based on given DifficultyInstance
    */
   protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
      super.setEquipmentBasedOnDifficulty(difficulty);
      if (this.rand.nextFloat() < (this.world.getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
         int i = this.rand.nextInt(3);
         if (i == 0) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SWORD));
         } else {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
         }
      }

   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      if (this.isChild()) {
         compound.putBoolean("IsBaby", true);
      }

   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      if (compound.getBoolean("IsBaby")) {
         this.setChild(true);
      }

   }

   /**
    * This method gets called when the entity kills another one.
    */
   public void onKillEntity(LivingEntity entityLivingIn) {
      super.onKillEntity(entityLivingIn);
      if ((this.world.getDifficulty() == Difficulty.NORMAL || this.world.getDifficulty() == Difficulty.HARD) && entityLivingIn instanceof VillagerEntity) {
         if (this.world.getDifficulty() != Difficulty.HARD && this.rand.nextBoolean()) {
            return;
         }

         VillagerEntity villagerentity = (VillagerEntity)entityLivingIn;
         ZombieVillagerEntity zombievillagerentity = EntityType.ZOMBIE_VILLAGER.create(this.world);
         zombievillagerentity.copyLocationAndAnglesFrom(villagerentity);
         villagerentity.remove();
         zombievillagerentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(zombievillagerentity.getPosition()), SpawnReason.CONVERSION, new net.minecraft.entity.monster.ZombieEntity.GroupData(false, true), (CompoundNBT)null);
         zombievillagerentity.setVillagerData(villagerentity.getVillagerData());
         zombievillagerentity.setGossips(villagerentity.getGossip().func_234058_a_(NBTDynamicOps.INSTANCE).getValue());
         zombievillagerentity.setOffers(villagerentity.getOffers().write());
         zombievillagerentity.setEXP(villagerentity.getXp());
         zombievillagerentity.setChild(villagerentity.isChild());
         zombievillagerentity.setNoAI(villagerentity.isAIDisabled());
         if (villagerentity.hasCustomName()) {
            zombievillagerentity.setCustomName(villagerentity.getCustomName());
            zombievillagerentity.setCustomNameVisible(villagerentity.isCustomNameVisible());
         }

         if (villagerentity.isNoDespawnRequired()) {
            zombievillagerentity.enablePersistence();
         }

         zombievillagerentity.setInvulnerable(this.isInvulnerable());
         this.world.addEntity(zombievillagerentity);
         if (!this.isSilent()) {
            this.world.playEvent((PlayerEntity)null, 1026, this.getPosition(), 0);
         }
      }

   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return this.isChild() ? 0.93F : 1.74F;
   }

   public boolean canEquipItem(ItemStack stack) {
      return stack.getItem() == Items.EGG && this.isChild() && this.isPassenger() ? false : super.canEquipItem(stack);
   }

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
      float f = difficultyIn.getClampedAdditionalDifficulty();
      this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
      if (spawnDataIn == null) {
         spawnDataIn = new net.minecraft.entity.monster.ZombieEntity.GroupData(func_241399_a_(worldIn.getRandom()), true);
      }

      if (this.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty()) {
         LocalDate localdate = LocalDate.now();
         int i = localdate.get(ChronoField.DAY_OF_MONTH);
         int j = localdate.get(ChronoField.MONTH_OF_YEAR);
         if (j == 10 && i == 31 && this.rand.nextFloat() < 0.25F) {
            this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
            this.inventoryArmorDropChances[EquipmentSlotType.HEAD.getIndex()] = 0.0F;
         }
      }

      this.applyAttributeBonuses(f);
      return spawnDataIn;
   }

   public static boolean func_241399_a_(Random p_241399_0_) {
      return p_241399_0_.nextFloat() < net.minecraftforge.common.ForgeConfig.SERVER.zombieBabyChance.get();
   }

   public void applyAttributeBonuses(float difficulty) {
      this.func_230291_eT_();
      this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).applyPersistentModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * (double)0.05F, AttributeModifier.Operation.ADDITION));
      double d0 = this.rand.nextDouble() * 1.5D * (double)difficulty;
      if (d0 > 1.0D) {
         this.getAttribute(Attributes.FOLLOW_RANGE).applyPersistentModifier(new AttributeModifier("Random zombie-spawn bonus", d0, AttributeModifier.Operation.MULTIPLY_TOTAL));
      }

      if (this.rand.nextFloat() < difficulty * 0.05F) {
         this.getAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS).applyPersistentModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25D + 0.5D, AttributeModifier.Operation.ADDITION));
         this.getAttribute(Attributes.MAX_HEALTH).applyPersistentModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, AttributeModifier.Operation.MULTIPLY_TOTAL));
      }

   }

   protected void func_230291_eT_() {
      this.getAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS).setBaseValue(this.rand.nextDouble() * net.minecraftforge.common.ForgeConfig.SERVER.zombieBaseSummonChance.get());
   }

   /**
    * Returns the Y Offset of this entity.
    */
   public double getYOffset() {
      return this.isChild() ? 0.0D : -0.45D;
   }

   protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
      super.dropSpecialItems(source, looting, recentlyHitIn);
      Entity entity = source.getTrueSource();
      if (entity instanceof CreeperEntity) {
         CreeperEntity creeperentity = (CreeperEntity)entity;
         if (creeperentity.ableToCauseSkullDrop()) {
            creeperentity.incrementDroppedSkulls();
            ItemStack itemstack = this.getSkullDrop();
            if (!itemstack.isEmpty()) {
               this.entityDropItem(itemstack);
            }
         }
      }

   }

   protected ItemStack getSkullDrop() {
      return new ItemStack(ItemInit.THUNM.get());
   }
}
