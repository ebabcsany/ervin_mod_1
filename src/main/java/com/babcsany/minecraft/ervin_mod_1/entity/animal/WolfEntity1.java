package com.babcsany.minecraft.ervin_mod_1.entity.animal;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.BegGoal1;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.UUID;
import java.util.function.Predicate;

public class WolfEntity1 extends TameableEntity {
   private static final DataParameter<Boolean> BEGGING = EntityDataManager.createKey(WolfEntity1.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Integer> COLLAR_COLOR = EntityDataManager.createKey(WolfEntity1.class, DataSerializers.VARINT);
   public static final Predicate<LivingEntity> TARGET_ENTITIES = (p_213440_0_) -> {
      EntityType<?> entitytype = p_213440_0_.getType();
      return entitytype == EntityType.SHEEP || entitytype == EntityType.RABBIT || entitytype == EntityType.FOX;
   };
   private float headRotationCourse;
   private float headRotationCourseOld;
   private boolean isWet;
   private boolean isShaking;
   private float timeWolfIsShaking;
   private float prevTimeWolfIsShaking;

   public WolfEntity1(EntityType<? extends WolfEntity1> type, World worldIn) {
      super(type, worldIn);
      this.setTamed(false);
   }

   protected void registerGoals() {
      this.sitGoal = new SitGoal(this);
      this.goalSelector.addGoal(1, new SwimGoal(this));
      this.goalSelector.addGoal(2, this.sitGoal);
      this.goalSelector.addGoal(3, new WolfEntity1.AvoidEntityGoal(this, LlamaEntity.class, 4000.0F, 10.0D, 10.0D));
      this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 400.0F));
      this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 10.0D, true));
      this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 10.0D, 50.0F, 20.0F, false));
      this.goalSelector.addGoal(7, new BreedGoal(this, 2.0D));
      this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 12.0D));
      this.goalSelector.addGoal(9, new BegGoal1(this, 50.0F));
      this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 40.0F));
      this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
      this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
      this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
      this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
      this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, MonsterEntity.class, false, TARGET_ENTITIES));
      this.targetSelector.addGoal(4, new NonTamedTargetGoal<>(this, TurtleEntity.class, false, TurtleEntity.TARGET_DRY_BABY));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SheepEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CowEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ChickenEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, WolfEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, WanderingTraderEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, RabbitEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CatEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PandaEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, HorseEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, BeeEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, CodEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, OcelotEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SalmonEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PigEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SnowGolemEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PolarBearEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ParrotEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, MooshroomEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, LlamaEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TropicalFishEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ViltEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ZurEntity1.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SrachEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ShertEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, FoxEntity.class, false));
      this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EnderDragonEntity.class, false));
   }

   protected void registerAttributes() {
      super.registerAttributes();
      this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)3.0F);
      if (this.isTamed()) {
         this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20000.0D);
      } else {
         this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50000.0D);
      }

      this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20000.0D);
   }

   /**
    * Sets the active target the Task system uses for tracking
    */
   public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
      super.setAttackTarget(entitylivingbaseIn);
      if (entitylivingbaseIn == null) {
         this.setAngry(false);
      } else if (!this.isTamed()) {
         this.setAngry(true);
      }

   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(BEGGING, false);
      this.dataManager.register(COLLAR_COLOR, DyeColor.RED.getId());
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.ENTITY_WOLF_STEP, 15.0F, 10.0F);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putBoolean("Angry", this.isAngry());
      compound.putByte("CollarColor", (byte)this.getCollarColor().getId());
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      this.setAngry(compound.getBoolean("Angry"));
      if (compound.contains("CollarColor", 99)) {
         this.setCollarColor(DyeColor.byId(compound.getInt("CollarColor")));
      }

   }

   protected SoundEvent getAmbientSound() {
      if (this.isAngry()) {
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

      if (!this.world.isRemote && this.getAttackTarget() == null && this.isAngry()) {
         this.setAngry(false);
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
               Vec3d vec3d = this.getMotion();

               for(int j = 0; j < i; ++j) {
                  float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
                  float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.getWidth() * 0.5F;
                  this.world.addParticle(ParticleTypes.SPLASH, this.getPosX() + (double)f1, (double)(f + 0.8F), this.getPosZ() + (double)f2, vec3d.x, vec3d.y, vec3d.z);
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
   public float getShadingWhileWet(float p_70915_1_) {
      return 0.75F + MathHelper.lerp(p_70915_1_, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) / 2.0F * 0.25F;
   }

   @OnlyIn(Dist.CLIENT)
   public float getShakeAngle(float p_70923_1_, float p_70923_2_) {
      float f = (MathHelper.lerp(p_70923_1_, this.prevTimeWolfIsShaking, this.timeWolfIsShaking) + p_70923_2_) / 1.8F;
      if (f < 0.0F) {
         f = 0.0F;
      } else if (f > 1.0F) {
         f = 1.0F;
      }

      return MathHelper.sin(f * (float)Math.PI) * MathHelper.sin(f * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
   }

   @OnlyIn(Dist.CLIENT)
   public float getInterestedAngle(float p_70917_1_) {
      return MathHelper.lerp(p_70917_1_, this.headRotationCourseOld, this.headRotationCourse) * 0.15F * (float)Math.PI;
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return sizeIn.height * 0.8F;
   }

   /**
    * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
    * use in wolves.
    */
   public int getVerticalFaceSpeed() {
      return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
   }

   /**
    * Called when the entity is attacked.
    */
   public boolean attackEntityFrom(DamageSource source, float amount) {
      if (this.isInvulnerableTo(source)) {
         return false;
      } else {
         Entity entity = source.getTrueSource();
         if (this.sitGoal != null) {
            this.sitGoal.setSitting(false);
         }

         if (entity != null && !(entity instanceof PlayerEntity) && !(entity instanceof AbstractArrowEntity)) {
            amount = (amount + 1.0F) / 2.0F;
         }

         return super.attackEntityFrom(source, amount);
      }
   }

   public boolean attackEntityAsMob(Entity entityIn) {
      boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
      if (flag) {
         this.applyEnchantments(this, entityIn);
      }

      return flag;
   }

   public void setTamed(boolean tamed) {
      super.setTamed(tamed);
      if (tamed) {
         this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20000.0D);
         this.setHealth(20000.0F);
      } else {
         this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20000.0D);
      }

      this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5000.0D);
   }

   public boolean processInteract(PlayerEntity player, Hand hand) {
      ItemStack itemstack = player.getHeldItem(hand);
      Item item = itemstack.getItem();
      if (itemstack.getItem() instanceof SpawnEggItem) {
         return super.processInteract(player, hand);
      } else if (this.world.isRemote) {
         return this.isOwner(player) || item == Items.BONE && !this.isAngry();
      } else {
         if (this.isTamed()) {
            if (item.isFood() && item.getFood().isMeat() && this.getHealth() < this.getMaxHealth()) {
               if (!player.abilities.isCreativeMode) {
                  itemstack.shrink(1);
               }

               this.heal((float)item.getFood().getHealing());
               return true;
            }

            if (!(item instanceof DyeItem)) {
               boolean flag = super.processInteract(player, hand);
               if (!flag || this.isChild()) {
                  this.sitGoal.setSitting(!this.isSitting());
               }

               return flag;
            }

            DyeColor dyecolor = ((DyeItem)item).getDyeColor();
            if (dyecolor != this.getCollarColor()) {
               this.setCollarColor(dyecolor);
               if (!player.abilities.isCreativeMode) {
                  itemstack.shrink(1);
               }

               return true;
            }

            if (this.isOwner(player) && !this.isBreedingItem(itemstack)) {
               this.sitGoal.setSitting(!this.isSitting());
               this.isJumping = false;
               this.navigator.clearPath();
               this.setAttackTarget((LivingEntity)null);
            }
         } else if (item == Items.BONE && !this.isAngry()) {
            if (!player.abilities.isCreativeMode) {
               itemstack.shrink(1);
            }

            if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
               this.setTamedBy(player);
               this.navigator.clearPath();
               this.setAttackTarget((LivingEntity)null);
               this.sitGoal.setSitting(true);
               this.world.setEntityState(this, (byte)7);
            } else {
               this.world.setEntityState(this, (byte)6);
            }

            return true;
         }

         return super.processInteract(player, hand);
      }
   }

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 8) {
         this.isShaking = true;
         this.timeWolfIsShaking = 0.0F;
         this.prevTimeWolfIsShaking = 0.0F;
      } else {
         super.handleStatusUpdate(id);
      }

   }

   @OnlyIn(Dist.CLIENT)
   public float getTailRotation() {
      if (this.isAngry()) {
         return 1.5393804F;
      } else {
         return this.isTamed() ? (0.55F - (this.getMaxHealth() - this.getHealth()) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F);
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
      return 8;
   }

   /**
    * Determines whether this wolf is angry or not.
    */
   public boolean isAngry() {
      return (this.dataManager.get(TAMED) & 2) != 0;
   }

   /**
    * Sets whether this wolf is angry or not.
    */
   public void setAngry(boolean angry) {
      byte b0 = this.dataManager.get(TAMED);
      if (angry) {
         this.dataManager.set(TAMED, (byte)(b0 | 2));
      } else {
         this.dataManager.set(TAMED, (byte)(b0 & -3));
      }

   }

   public DyeColor getCollarColor() {
      return DyeColor.byId(this.dataManager.get(COLLAR_COLOR));
   }

   public void setCollarColor(DyeColor collarcolor) {
      this.dataManager.set(COLLAR_COLOR, collarcolor.getId());
   }

   public WolfEntity1 createChild(AgeableEntity ageable) {
      WolfEntity1 wolfentity1 = EntityInit.HHIJ_ENTITY.get().create(this.world);
      UUID uuid = this.getOwnerId();
      if (uuid != null) {
         wolfentity1.setOwnerId(uuid);
         wolfentity1.setTamed(true);
      }

      return wolfentity1;
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
         WolfEntity1 wolfentity1 = (WolfEntity1)otherAnimal;
         if (!wolfentity1.isTamed()) {
            return false;
         } else if (wolfentity1.isSitting()) {
            return false;
         } else {
            return this.isInLove() && wolfentity1.isInLove();
         }
      }
   }

   public boolean isBegging() {
      return this.dataManager.get(BEGGING);
   }

   public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
      if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
         if (target instanceof WolfEntity1) {
            WolfEntity1 wolfentity1 = (WolfEntity1)target;
            return !wolfentity1.isTamed() || wolfentity1.getOwner() != owner;
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
      return !this.isAngry() && super.canBeLeashedTo(player);
   }

   class AvoidEntityGoal<T extends LivingEntity> extends com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.AvoidEntityGoal1<T> {
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