package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.potion.*;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import static net.minecraft.entity.monster.MonsterEntity.isValidLightLevel;

public class RoventEntity extends ZurEntity implements IRangedAttackMob {
   private boolean swimmingUp;
   protected final SwimmerPathNavigator waterNavigator;
   protected final GroundPathNavigator groundNavigator;

   public RoventEntity(EntityType<? extends RoventEntity> type, World worldIn) {
      super(type, worldIn);
      this.stepHeight = 1.0F;
      this.moveController = new RoventEntity.MoveHelperController(this);
      this.setPathPriority(PathNodeType.LAVA, 1.0F);
      this.waterNavigator = new SwimmerPathNavigator(this, worldIn);
      this.groundNavigator = new GroundPathNavigator(this, worldIn);
   }

   protected void applyEntityAI() {
      this.goalSelector.addGoal(1, new RoventEntity.GoToWaterGoal(this, 1.0D));
      this.goalSelector.addGoal(2, new RoventEntity.TridentAttackGoal(this, 1.0D, 40, 10.0F));
      this.goalSelector.addGoal(2, new RoventEntity.AttackGoal(this, 1.0D, false));
      this.goalSelector.addGoal(5, new RoventEntity.GoToBeachGoal(this, 1.0D));
      this.goalSelector.addGoal(6, new RoventEntity.SwimUpGoal(this, 1.0D, this.world.getSeaLevel()));
      this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 1.0D));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, RoventEntity.class)).setCallsForHelp(ZombifiedPiglinEntity.class));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::shouldAttack));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.FOLLOW_RANGE, 100.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 40.0D).createMutableAttribute(Attributes.ARMOR, 20.0D).createMutableAttribute(Attributes.MAX_HEALTH, 260).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 5.0D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 15.0D);
   }

   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
      if (this.getItemStackFromSlot(EquipmentSlotType.OFFHAND).isEmpty() && this.rand.nextFloat() < 0.03F) {
         this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.NAUTILUS_SHELL));
         this.inventoryHandsDropChances[EquipmentSlotType.OFFHAND.getIndex()] = 2.0F;
      }

      return spawnDataIn;
   }

   public static boolean canRoventSpawn(EntityType<RoventEntity> p_223332_0_, IWorld p_223332_1_, SpawnReason reason, BlockPos p_223332_3_, Random p_223332_4_) {
      Biome biome = p_223332_1_.getBiome(p_223332_3_);
      boolean flag = p_223332_1_.getDifficulty() != Difficulty.HARD && isValidLightLevel(p_223332_1_, p_223332_3_, p_223332_4_) && (reason == SpawnReason.SPAWNER || p_223332_1_.getFluidState(p_223332_3_).isTagged(FluidTags.WATER));
      if (biome != BiomeInit.EXAMPLE_BIOME.get() && biome != BiomeInit.EXAMPLE_BIOME2.get()) {
         return p_223332_4_.nextInt(40) == 0 && func_223333_a(p_223332_1_, p_223332_3_) && flag;
      } else {
         return p_223332_4_.nextInt(15) == 0 && flag;
      }
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zurs and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick(ZurEntity zur) {
      super.livingTick();
      boolean flag = this.isInDaylight();
      this.updateArmSwingProgress();
      this.wingRotation += this.wingRotDelta * 2.0F;
      if (!this.world.isRemote) {
         zur.handleDespawn();
      }
      if (!this.world.isRemote && this.isAlive()) {
         if (this.isDrinkingPotion()) {
            if (zur.potionUseTimer-- <= 0) {
               this.setDrinkingPotion(false);
               ItemStack itemstack = this.getHeldItemMainhand();
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
               if (itemstack.getItem() == Items.POTION) {
                  List<EffectInstance> list = PotionUtils.getEffectsFromStack(itemstack);
                  for(EffectInstance effectinstance : list) {
                     this.addPotionEffect(new EffectInstance(effectinstance));
                  }
               }

               this.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(MODIFIER);
            }
         } else {
            Potion potion = null;
            if (this.rand.nextFloat() < 0.15F && this.areEyesInFluid(FluidTags.WATER) && !this.isPotionActive(Effects.WATER_BREATHING)) {
               potion = Potions.WATER_BREATHING;
            } else if (this.rand.nextFloat() < 0.15F && (this.isBurning() || this.getLastDamageSource() != null && this.getLastDamageSource().isFireDamage()) && !this.isPotionActive(Effects.FIRE_RESISTANCE)) {
               potion = Potions.FIRE_RESISTANCE;
            } else if (this.rand.nextFloat() < 0.05F && this.getHealth() < this.getMaxHealth()) {
               potion = Potions.HEALING;
            } else if (this.rand.nextFloat() < 0.5F && this.getAttackTarget() != null && !this.isPotionActive(Effects.SPEED) && !this.isPotionActive(Effects.JUMP_BOOST) && !this.isPotionActive(Effects.STRENGTH) && this.getAttackTarget().getDistanceSq(this) > 4.0D) {
               potion = Potions.SWIFTNESS;
            }

            if (potion != null) {
               this.setItemStackToSlot(EquipmentSlotType.MAINHAND, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potion));
               this.potionUseTimer = this.getHeldItemMainhand().getUseDuration();
               this.setDrinkingPotion(true);
               if (!this.isSilent()) {
                  this.world.playSound(null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_WITCH_DRINK, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
               }

               ModifiableAttributeInstance modifiableattributeinstance = this.getAttribute(Attributes.MOVEMENT_SPEED);
               modifiableattributeinstance.removeModifier(MODIFIER);
               modifiableattributeinstance.applyNonPersistentModifier(MODIFIER);
            }
         }

         if (this.rand.nextFloat() < 7.5E-4F) {
            this.world.setEntityState(this, (byte)15);
         }
      }
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
         }
      }
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && this.isZurDropItem() && --this.timeUntilNextItem <= 0) {
         this.entityDropItem(isBurnableItemInit.LEAT.get());
         this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
      }
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      MerchantOffers merchantoffers = this.getOffers();
      if (this.zurTarget != null) {
         compound.put("ZurTarget", NBTUtil.writeBlockPos(this.zurTarget));
      }

      if (this.isChild()) {
         compound.putBoolean("IsBaby", true);
      }

      if (!merchantoffers.isEmpty()) {
         compound.put("Offers", merchantoffers.write());
      }

      compound.put("Inventory", this.zurInventory.write());
   }

   private static boolean func_223333_a(IWorld p_223333_0_, BlockPos p_223333_1_) {
      return p_223333_1_.getY() < p_223333_0_.getSeaLevel() - 5;
   }

   protected boolean canBreakDoors() {
      return false;
   }

   protected SoundEvent getAmbientSound() {
      return this.isInWater() ? SoundEvents.ENTITY_DROWNED_AMBIENT_WATER : SoundEvents.ENTITY_DROWNED_AMBIENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return this.isInWater() ? SoundEvents.ENTITY_DROWNED_HURT_WATER : SoundEvents.ENTITY_DROWNED_HURT;
   }

   protected SoundEvent getDeathSound() {
      return this.isInWater() ? SoundEvents.ENTITY_DROWNED_DEATH_WATER : SoundEvents.ENTITY_DROWNED_DEATH;
   }

   protected SoundEvent getStepSound() {
      return SoundEvents.ENTITY_ZOMBIE_STEP;
   }

   protected SoundEvent getSwimSound() {
      return SoundEvents.ENTITY_PLAYER_SWIM;
   }

   protected ItemStack getSkullDrop() {
      return ItemStack.EMPTY;
   }

   /**
    * Gives armor or weapon for entity based on given DifficultyInstance
    */
   protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
      if ((double)this.rand.nextFloat() > 0.9D) {
         int i = this.rand.nextInt(16);
         if (i < 10) {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.TRIDENT));
         } else {
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.FISHING_ROD));
         }
      }

   }

   protected boolean shouldExchangeEquipment(ItemStack candidate, ItemStack existing) {
      if (existing.getItem() == SpecialToolItemInit.CRAINT.get()) {
         return false;
      } else if (existing.getItem() == Items.TRIDENT) {
         if (candidate.getItem() == Items.TRIDENT) {
            return candidate.getDamage() < existing.getDamage();
         } else {
            return false;
         }
      } else {
         return candidate.getItem() == Items.TRIDENT ? true : super.shouldExchangeEquipment(candidate, existing);
      }
   }

   protected boolean shouldExchangeEquipment1(ItemStack candidate, ItemStack existing) {
      if (existing.getItem() == isBurnableFoodItemInit.TIRKS.get()) {
         return false;
      } else if (existing.getItem() == Items.TRIDENT) {
         if (candidate.getItem() == Items.TRIDENT) {
            return candidate.getDamage() < existing.getDamage();
         } else {
            return false;
         }
      } else {
         return candidate.getItem() == Items.TRIDENT ? true : super.shouldExchangeEquipment(candidate, existing);
      }
   }

   protected boolean shouldDrown() {
      return false;
   }

   public boolean isNotColliding(IWorldReader worldIn) {
      return worldIn.checkNoEntityCollision(this);
   }

   public boolean shouldAttack(@Nullable LivingEntity p_204714_1_) {
      if (p_204714_1_ != null) {
         return !this.world.isDaytime() || p_204714_1_.isInWater();
      } else {
         return false;
      }
   }

   public boolean isPushedByWater() {
      return !this.isSwimming();
   }

   private boolean func_204715_dF() {
      if (this.swimmingUp) {
         return true;
      } else {
         LivingEntity livingentity = this.getAttackTarget();
         return livingentity != null && livingentity.isInWater();
      }
   }

   public void travel(Vector3d travelVector) {
      if (this.isServerWorld() && this.isInWater() && this.func_204715_dF()) {
         this.moveRelative(0.01F, travelVector);
         this.move(MoverType.SELF, this.getMotion());
         this.setMotion(this.getMotion().scale(0.9D));
      } else {
         super.travel(travelVector);
      }

   }

   public void updateSwimming() {
      if (!this.world.isRemote) {
         if (this.isServerWorld() && this.isInWater() && this.func_204715_dF()) {
            this.navigator = this.waterNavigator;
            this.setSwimming(true);
         } else {
            this.navigator = this.groundNavigator;
            this.setSwimming(false);
         }
      }

   }

   protected boolean isCloseToPathTarget() {
      Path path = this.getNavigator().getPath();
      if (path != null) {
         BlockPos blockpos = path.getTarget();
         double d0 = this.getDistanceSq(blockpos.getX(), blockpos.getY(), blockpos.getZ());
         return d0 < 4.0D;
      }

      return false;
   }

   /**
    * Attack the specified entity using a ranged attack.
    */
   public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
      TridentEntity tridententity = new TridentEntity(this.world, this, new ItemStack(Items.TRIDENT));
      double d0 = target.getPosX() - this.getPosX();
      double d1 = target.getPosYHeight(0.3333333333333333D) - tridententity.getPosY();
      double d2 = target.getPosZ() - this.getPosZ();
      double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
      tridententity.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.world.getDifficulty().getId() * 4));
      this.playSound(SoundEvents.ENTITY_DROWNED_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
      this.world.addEntity(tridententity);
   }

   public void setSwimmingUp(boolean p_204713_1_) {
      this.swimmingUp = p_204713_1_;
   }

   static class AttackGoal extends ZurAttackGoal {
      private final RoventEntity field_204726_g;

      public AttackGoal(RoventEntity p_i48913_1_, double p_i48913_2_, boolean p_i48913_4_) {
         super(p_i48913_1_, p_i48913_2_, p_i48913_4_);
         this.field_204726_g = p_i48913_1_;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return super.shouldExecute() && this.field_204726_g.shouldAttack(this.field_204726_g.getAttackTarget());
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return super.shouldContinueExecuting() && this.field_204726_g.shouldAttack(this.field_204726_g.getAttackTarget());
      }
   }

   static class GoToBeachGoal extends MoveToBlockGoal {
      private final RoventEntity drowned;

      public GoToBeachGoal(RoventEntity p_i48911_1_, double p_i48911_2_) {
         super(p_i48911_1_, p_i48911_2_, 8, 2);
         this.drowned = p_i48911_1_;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return super.shouldExecute() && !this.drowned.world.isDaytime() && this.drowned.isInWater() && this.drowned.getPosY() >= (double)(this.drowned.world.getSeaLevel() - 3);
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return super.shouldContinueExecuting();
      }

      /**
       * Return true to set given position as destination
       */
      protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
         BlockPos blockpos = pos.up();
         return worldIn.isAirBlock(blockpos) && worldIn.isAirBlock(blockpos.up()) ? worldIn.getBlockState(pos).canSpawnMobs(worldIn, pos, this.drowned) : false;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         this.drowned.setSwimmingUp(false);
         this.drowned.navigator = this.drowned.groundNavigator;
         super.startExecuting();
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         super.resetTask();
      }
   }

   static class GoToWaterGoal extends Goal {
      private final CreatureEntity field_204730_a;
      private double field_204731_b;
      private double field_204732_c;
      private double field_204733_d;
      private final double field_204734_e;
      private final World field_204735_f;

      public GoToWaterGoal(CreatureEntity p_i48910_1_, double p_i48910_2_) {
         this.field_204730_a = p_i48910_1_;
         this.field_204734_e = p_i48910_2_;
         this.field_204735_f = p_i48910_1_.world;
         this.setMutexFlags(EnumSet.of(Flag.MOVE));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (!this.field_204735_f.isDaytime()) {
            return false;
         } else if (this.field_204730_a.isInWater()) {
            return false;
         } else {
            Vector3d vector3d = this.func_204729_f();
            if (vector3d == null) {
               return false;
            } else {
               this.field_204731_b = vector3d.x;
               this.field_204732_c = vector3d.y;
               this.field_204733_d = vector3d.z;
               return true;
            }
         }
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return !this.field_204730_a.getNavigator().noPath();
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         this.field_204730_a.getNavigator().tryMoveToXYZ(this.field_204731_b, this.field_204732_c, this.field_204733_d, this.field_204734_e);
      }

      @Nullable
      private Vector3d func_204729_f() {
         Random random = this.field_204730_a.getRNG();
         BlockPos blockpos = this.field_204730_a.getPosition();

         for(int i = 0; i < 10; ++i) {
            BlockPos blockpos1 = blockpos.add(random.nextInt(20) - 10, 2 - random.nextInt(8), random.nextInt(20) - 10);
            if (this.field_204735_f.getBlockState(blockpos1).isIn(Blocks.WATER)) {
               return Vector3d.copyCenteredHorizontally(blockpos1);
            }
         }

         return null;
      }
   }

   static class MoveHelperController extends MovementController {
      private final RoventEntity drowned;

      public MoveHelperController(RoventEntity p_i48909_1_) {
         super(p_i48909_1_);
         this.drowned = p_i48909_1_;
      }

      public void tick() {
         LivingEntity livingentity = this.drowned.getAttackTarget();
         if (this.drowned.func_204715_dF() && this.drowned.isInWater()) {
            if (livingentity != null && livingentity.getPosY() > this.drowned.getPosY() || this.drowned.swimmingUp) {
               this.drowned.setMotion(this.drowned.getMotion().add(0.0D, 0.002D, 0.0D));
            }

            if (this.action != Action.MOVE_TO || this.drowned.getNavigator().noPath()) {
               this.drowned.setAIMoveSpeed(0.0F);
               return;
            }

            double d0 = this.posX - this.drowned.getPosX();
            double d1 = this.posY - this.drowned.getPosY();
            double d2 = this.posZ - this.drowned.getPosZ();
            double d3 = MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
            d1 = d1 / d3;
            float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
            this.drowned.rotationYaw = this.limitAngle(this.drowned.rotationYaw, f, 90.0F);
            this.drowned.renderYawOffset = this.drowned.rotationYaw;
            float f1 = (float)(this.speed * this.drowned.getAttributeValue(Attributes.MOVEMENT_SPEED));
            float f2 = MathHelper.lerp(0.125F, this.drowned.getAIMoveSpeed(), f1);
            this.drowned.setAIMoveSpeed(f2);
            this.drowned.setMotion(this.drowned.getMotion().add((double)f2 * d0 * 0.005D, (double)f2 * d1 * 0.1D, (double)f2 * d2 * 0.005D));
         } else {
            if (!this.drowned.onGround) {
               this.drowned.setMotion(this.drowned.getMotion().add(0.0D, -0.008D, 0.0D));
            }

            super.tick();
         }

      }
   }

   static class SwimUpGoal extends Goal {
      private final RoventEntity field_204736_a;
      private final double field_204737_b;
      private final int targetY;
      private boolean obstructed;

      public SwimUpGoal(RoventEntity p_i48908_1_, double p_i48908_2_, int p_i48908_4_) {
         this.field_204736_a = p_i48908_1_;
         this.field_204737_b = p_i48908_2_;
         this.targetY = p_i48908_4_;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return !this.field_204736_a.world.isDaytime() && this.field_204736_a.isInWater() && this.field_204736_a.getPosY() < (double)(this.targetY - 2);
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return this.shouldExecute() && !this.obstructed;
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         if (this.field_204736_a.getPosY() < (double)(this.targetY - 1) && (this.field_204736_a.getNavigator().noPath() || this.field_204736_a.isCloseToPathTarget())) {
            Vector3d vector3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.field_204736_a, 4, 8, new Vector3d(this.field_204736_a.getPosX(), (double)(this.targetY - 1), this.field_204736_a.getPosZ()));
            if (vector3d == null) {
               this.obstructed = true;
               return;
            }

            this.field_204736_a.getNavigator().tryMoveToXYZ(vector3d.x, vector3d.y, vector3d.z, this.field_204737_b);
         }

      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         this.field_204736_a.setSwimmingUp(true);
         this.obstructed = false;
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         this.field_204736_a.setSwimmingUp(false);
      }
   }

   static class TridentAttackGoal extends RangedAttackGoal {
      private final RoventEntity field_204728_a;

      public TridentAttackGoal(IRangedAttackMob p_i48907_1_, double p_i48907_2_, int p_i48907_4_, float p_i48907_5_) {
         super(p_i48907_1_, p_i48907_2_, p_i48907_4_, p_i48907_5_);
         this.field_204728_a = (RoventEntity)p_i48907_1_;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return super.shouldExecute() && this.field_204728_a.getHeldItemMainhand().getItem() == Items.TRIDENT;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         super.startExecuting();
         this.field_204728_a.setAggroed(true);
         this.field_204728_a.setActiveHand(Hand.MAIN_HAND);
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         super.resetTask();
         this.field_204728_a.resetActiveHand();
         this.field_204728_a.setAggroed(false);
      }
   }
}