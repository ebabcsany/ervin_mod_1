package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.BegGoal1;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.WolfEntity1TradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.passive.horse.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.function.Predicate;

public class WolfEntity1 extends TameableEntity implements IAngerable {
   private static final DataParameter<Boolean> BEGGING = EntityDataManager.createKey(WolfEntity1.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Integer> COLLAR_COLOR = EntityDataManager.createKey(WolfEntity1.class, DataSerializers.VARINT);
   private static final DataParameter<Integer> field_234232_bz_ = EntityDataManager.createKey(WolfEntity1.class, DataSerializers.VARINT);
   public static final Predicate<LivingEntity> TARGET_ENTITIES = (p_213440_0_) -> {
      EntityType<?> entitytype = p_213440_0_.getType();
      return entitytype == EntityInit.VILT_ENTITY.get() || entitytype == EntityType.RABBIT || entitytype == EntityType.FOX;
   };
   private float headRotationCourse;
   private float headRotationCourseOld;
   private boolean isWet;
   private boolean isShaking;
   private float timeWolfIsShaking;
   private float prevTimeWolfIsShaking;
   private static final RangedInteger field_234230_bG_ = TickRangeConverter.convertRange(20, 39);
   private UUID field_234231_bH_;

   public WolfEntity1(EntityType<? extends WolfEntity1> type, World worldIn) {
      super(type, worldIn);
      this.setTamed(false);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(1, new SwimGoal(this));
      this.goalSelector.addGoal(2, new SitGoal(this));
      this.goalSelector.addGoal(3, new WolfEntity1.AvoidEntityGoal(this, LlamaEntity.class, 24.0F, 1.5D, 1.5D));
      this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
      this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
      this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(9, new BegGoal1(this, 8.0F));
      this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
      this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
      this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, this::func_233680_b_));
      this.targetSelector.addGoal(5, new NonTamedTargetGoal<>(this, AnimalEntity.class, false, TARGET_ENTITIES));
      this.targetSelector.addGoal(6, new NonTamedTargetGoal<>(this, TurtleEntity.class, false, TurtleEntity.TARGET_DRY_BABY));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, ViltEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SrachEntity.class, false));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ShertEntity.class, false));
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SheepEntity.class, false));
      this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, CowEntity.class, false));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, RabbitEntity.class, false));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, RavagerEntity.class, false));
      this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, EnderDragonEntity.class, false));
      this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, EndermanEntity.class, false));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, FoxEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, MooshroomEntity.class, false));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, OcelotEntity.class, false));
      this.targetSelector.addGoal(11, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, false));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, LlamaEntity.class, false));
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, BatEntity.class, false));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, false));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, IllusionerEntity.class, false));
      this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, WitherEntity.class, false));
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, WolfEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SquidEntity.class, false));
      this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, CodEntity.class, false));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PufferfishEntity.class, false));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, PigEntity.class, false));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, StriderEntity.class, false));
      this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, TraderLlamaEntity.class, false));
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SalmonEntity.class, false));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PolarBearEntity.class, false));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, false));
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ParrotEntity.class, false));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, PandaEntity.class, false));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, HorseEntity.class, false));
      this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, DolphinEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, DonkeyEntity.class, false));
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, CatEntity.class, false));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, BeeEntity.class, false));
      this.targetSelector.addGoal(12, new NearestAttackableTargetGoal<>(this, SkeletonHorseEntity.class, false));
      this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, ZombieHorseEntity.class, false));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, false));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, WanderingTraderEntity.class, false));
      this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, ZombieVillagerEntity.class, false));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PiglinEntity.class, false));
      this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, WaterMobEntity.class, false));
      this.targetSelector.addGoal(8, new ResetAngerGoal<>(this, true));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.3F).createMutableAttribute(Attributes.MAX_HEALTH, 20000.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 5000.0D);
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(BEGGING, false);
      this.dataManager.register(COLLAR_COLOR, DyeColor.RED.getId());
      this.dataManager.register(field_234232_bz_, 0);
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putByte("CollarColor", (byte)this.getCollarColor().getId());
      this.writeAngerNBT(compound);
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      if (compound.contains("CollarColor", 99)) {
         this.setCollarColor(DyeColor.byId(compound.getInt("CollarColor")));
      }

      this.readAngerNBT((ServerWorld)this.world, compound);
   }

   protected SoundEvent getAmbientSound() {
      if (this.func_233678_J__()) {
         return SoundEvents.ENTITY_WOLF_GROWL;
      } else if (this.rand.nextInt(3) == 0) {
         return this.isTamed() && this.getHealth() < 10.0F ? SoundEvents.ENTITY_WOLF_WHINE : SoundEvents.ENTITY_WOLF_PANT;
      } else {
         return SoundEvents.ENTITY_WOLF_AMBIENT;
      }
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_WOLF_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_WOLF_DEATH;
   }

   /**
    * Returns the volume for the sounds this mob makes.
    */
   protected float getSoundVolume() {
      return 0.4F;
   }

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      super.livingTick();
      if (!this.world.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround) {
         this.isShaking = true;
         this.timeWolfIsShaking = 0.0F;
         this.prevTimeWolfIsShaking = 0.0F;
         this.world.setEntityState(this, (byte)8);
      }

      if (!this.world.isRemote) {
         this.func_241359_a_((ServerWorld)this.world, true);
      }

   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      super.tick();
      if (this.isAlive()) {
         this.headRotationCourseOld = this.headRotationCourse;
         if (this.isBegging()) {
            this.headRotationCourse += (1.0F - this.headRotationCourse) * 0.4F;
         } else {
            this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;
         }

         if (this.isInWaterRainOrBubbleColumn()) {
            this.isWet = true;
            this.isShaking = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
         } else if ((this.isWet || this.isShaking) && this.isShaking) {
            if (this.timeWolfIsShaking == 0.0F) {
               this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05F;
            if (this.prevTimeWolfIsShaking >= 2.0F) {
               this.isWet = false;
               this.isShaking = false;
               this.prevTimeWolfIsShaking = 0.0F;
               this.timeWolfIsShaking = 0.0F;
            }

            if (this.timeWolfIsShaking > 0.4F) {
               float f = (float)this.getPosY();
               int i = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);
               Vector3d vector3d = this.getMotion();

               for(int j = 0; j < i; ++j) {
                  float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
                  float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
                  this.world.addParticle(ParticleTypes.SPLASH, this.getPosX() + (double)f1, (double)(f + 0.8F), this.getPosZ() + (double)f2, vector3d.x, vector3d.y, vector3d.z);
               }
            }
         }

      }
   }

   /**
    * Called when the mob's health reaches 0.
    */
   public void onDeath(DamageSource cause) {
      this.isWet = false;
      this.isShaking = false;
      this.prevTimeWolfIsShaking = 0.0F;
      this.timeWolfIsShaking = 0.0F;
      super.onDeath(cause);
   }

   /**
    * True if the wolf is wet
    */
   @OnlyIn(Dist.CLIENT)
   public boolean isWolfWet() {
      return this.isWet;
   }

   /**
    * Used when calculating the amount of shading to apply while the wolf is wet.
    */
   @OnlyIn(Dist.CLIENT)
   public float getShadingWhileWet(float partialTicks) {
      return 0.75F + MathHelper.lerp(partialTicks, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) / 2.0F * 0.25F;
   }

   @OnlyIn(Dist.CLIENT)
   public float getShakeAngle(float partialTicks, float offset) {
      float f = (MathHelper.lerp(partialTicks, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) + offset) / 1.8F;
      if (f < 0.0F) {
         f = 0.0F;
      } else if (f > 1.0F) {
         f = 1.0F;
      }

      return MathHelper.sin(f * (float)Math.PI) * MathHelper.sin(f * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
   }

   @OnlyIn(Dist.CLIENT)
   public float getInterestedAngle(float partialTicks) {
      return MathHelper.lerp(partialTicks, this.headRotationCourseOld, this.headRotationCourse) * 0.15F * (float)Math.PI;
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return sizeIn.height * 0.8F;
   }

   /**
    * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
    * use in wolves.
    */
   public int getVerticalFaceSpeed() {
      return this.func_233684_eK_() ? 20 : super.getVerticalFaceSpeed();
   }

   /**
    * Called when the entity is attacked.
    */
   public boolean attackEntityFrom(DamageSource source, float amount) {
      if (this.isInvulnerableTo(source)) {
         return false;
      } else {
         Entity entity = source.getTrueSource();
         this.func_233687_w_(false);
         if (entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof AbstractArrowEntity)) {
            amount = (amount + 1.0F) / 2.0F;
         }

         return super.attackEntityFrom(source, amount);
      }
   }

   public boolean attackEntityAsMob(Entity entityIn) {
      boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
      if (flag) {
         this.applyEnchantments(this, entityIn);
      }

      return flag;
   }

   public void setTamed(boolean tamed) {
      super.setTamed(tamed);
      if (tamed) {
         this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20000.0D);
         this.setHealth(20.0F);
      } else {
         this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8000.0D);
      }

      this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(5000.0D);
   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      Item item = itemstack.getItem();
      if (this.world.isRemote) {
         boolean flag = this.isOwner(p_230254_1_) || this.isTamed() || item == Items.BONE && !this.isTamed() && !this.func_233678_J__();
         return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
      } else {
         if (this.isTamed()) {
            if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
               if (!p_230254_1_.abilities.isCreativeMode) {
                  itemstack.shrink(1000);
               }

               this.heal((float)item.getFood().getHealing());
               return ActionResultType.SUCCESS;
            }

            if (!(item instanceof DyeItem)) {
               ActionResultType actionresulttype = super.func_230254_b_(p_230254_1_, p_230254_2_);
               if ((!actionresulttype.isSuccessOrConsume() || this.isChild()) && this.isOwner(p_230254_1_)) {
                  this.func_233687_w_(!this.func_233685_eM_());
                  this.isJumping = false;
                  this.navigator.clearPath();
                  this.setAttackTarget((LivingEntity)null);
                  return ActionResultType.SUCCESS;
               }

               return actionresulttype;
            }

            DyeColor dyecolor = ((DyeItem)item).getDyeColor();
            if (dyecolor != this.getCollarColor()) {
               this.setCollarColor(dyecolor);
               if (!p_230254_1_.abilities.isCreativeMode) {
                  itemstack.shrink(1000);
               }

               return ActionResultType.SUCCESS;
            }
         } else if (item == Items.BONE && !this.func_233678_J__()) {
            if (!p_230254_1_.abilities.isCreativeMode) {
               itemstack.shrink(1000);
            }

            if (this.rand.nextInt(3) == 1 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_230254_1_)) {
               this.setTamedBy(p_230254_1_);
               this.navigator.clearPath();
               this.setAttackTarget((LivingEntity)null);
               this.func_233687_w_(true);
               this.world.setEntityState(this, (byte)7);
            } else {
               this.world.setEntityState(this, (byte)6);
            }

            return ActionResultType.SUCCESS;
         }

         return super.func_230254_b_(p_230254_1_, p_230254_2_);
      }
   }

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 8) {
         this.isShaking = true;
         this.timeWolfIsShaking = 100.0F;
         this.prevTimeWolfIsShaking = 100.0F;
      } else {
         super.handleStatusUpdate(id);
      }

   }

   @OnlyIn(Dist.CLIENT)
   public float getTailRotation() {
      if (this.func_233678_J__()) {
         return 1.5393804F;
      } else {
         return this.isTamed() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 20.0F) * (float)Math.PI : ((float)Math.PI / 5F);
      }
   }

   /**
    * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
    * the animal type)
    */
   public boolean isBreedingItem(ItemStack stack) {
      Item item = stack.getItem();
      return item.isFood() && item.getFood().isMeat();
   }

   /**
    * Will return how many at most can spawn in a chunk at once.
    */
   public int getMaxSpawnedInChunk() {
      return 4;
   }

   public int getAngerTime() {
      return this.dataManager.get(field_234232_bz_);
   }

   public void setAngerTime(int time) {
      this.dataManager.set(field_234232_bz_, time);
   }

   public void func_230258_H__() {
      this.setAngerTime(field_234230_bG_.func_233018_a_(this.rand));
   }

   @Nullable
   public UUID getAngerTarget() {
      return this.field_234231_bH_;
   }

   public void setAngerTarget(@Nullable UUID target) {
      this.field_234231_bH_ = target;
   }

   public DyeColor getCollarColor() {
      return DyeColor.byId(this.dataManager.get(COLLAR_COLOR));
   }

   public void setCollarColor(DyeColor collarcolor) {
      this.dataManager.set(COLLAR_COLOR, collarcolor.getId());
   }

   public WolfEntity1 createChild(AgeableEntity ageable) {
      WolfEntity1 wolfentity = EntityInit.HHIJ_ENTITY.get().create(this.world);
      UUID uuid = this.getOwnerId();
      if (uuid != null) {
         wolfentity.setOwnerId(uuid);
         wolfentity.setTamed(true);
      }

      return wolfentity;
   }

   public void setBegging(boolean beg) {
      this.dataManager.set(BEGGING, beg);
   }

   /**
    * Returns true if the mob is currently able to mate with the specified mob.
    */
   public boolean canMateWith(AnimalEntity otherAnimal) {
      if (otherAnimal == this) {
         return false;
      } else if (!this.isTamed()) {
         return false;
      } else if (!(otherAnimal instanceof WolfEntity1)) {
         return false;
      } else {
         WolfEntity1 wolfentity = (WolfEntity1)otherAnimal;
         if (!wolfentity.isTamed()) {
            return false;
         } else if (wolfentity.func_233684_eK_()) {
            return false;
         } else {
            return this.isInLove() && wolfentity.isInLove();
         }
      }
   }

   public boolean isBegging() {
      return this.dataManager.get(BEGGING);
   }

   public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
      if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
         if (target instanceof WolfEntity1) {
            WolfEntity1 wolfentity = (WolfEntity1)target;
            return !wolfentity.isTamed() || wolfentity.getOwner() != owner;
         } else if (target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity)owner).canAttackPlayer((PlayerEntity)target)) {
            return false;
         } else if (target instanceof AbstractHorseEntity && ((AbstractHorseEntity)target).isTame()) {
            return false;
         } else {
            return !(target instanceof TameableEntity) || !((TameableEntity)target).isTamed();
         }
      } else {
         return false;
      }
   }

   public boolean canBeLeashedTo(PlayerEntity player) {
      return !this.func_233678_J__() && super.canBeLeashedTo(player);
   }

   @OnlyIn(Dist.CLIENT)
   public Vector3d func_241205_ce_() {
      return new Vector3d(0.0D, (double)(0.6F * this.getEyeHeight()), (double)(this.getWidth() * 0.4F));
   }

   class AvoidEntityGoal<T extends LivingEntity> extends net.minecraft.entity.ai.goal.AvoidEntityGoal<T> {
      private final WolfEntity1 wolf;

      public AvoidEntityGoal(WolfEntity1 wolfIn, Class<T> entityClassToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn) {
         super(wolfIn, entityClassToAvoidIn, avoidDistanceIn, farSpeedIn, nearSpeedIn);
         this.wolf = wolfIn;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (super.shouldExecute() && this.avoidTarget instanceof LlamaEntity) {
            return !this.wolf.isTamed() && this.avoidLlama((LlamaEntity)this.avoidTarget);
         } else {
            return false;
         }
      }

      private boolean avoidLlama(LlamaEntity llamaIn) {
         return llamaIn.getStrength() >= WolfEntity1.this.rand.nextInt(5);
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         WolfEntity1.this.setAttackTarget((LivingEntity)null);
         super.startExecuting();
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         WolfEntity1.this.setAttackTarget((LivingEntity)null);
         super.tick();
      }
   }
}