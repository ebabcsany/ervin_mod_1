package com.babcsany.minecraft.ervin_mod_1.entity.fish;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.RandomPositionGenerator;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.controller.dgrurb.DgrurbMovementController;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.controller.dgrurb.fish.DrurbFishLookController;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.*;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.BreatheAirGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.FindWaterGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.FollowBoatGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.HurtByTargetGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.RandomSwimmingGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk.fish.DrurbFishJumpGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.fish.drurgbk.WaterDrurgbkMobEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.Dgrurb;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk.Dgrurbk;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk.MeleeDgrurbkAttackGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.pathfinding.dgrurb.DgrurbPathNavigator;
import com.babcsany.minecraft.ervin_mod_1.entity.pathfinding.dgrurb.SwimmerDgrurbPathNavigator;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DrurbFishEntity extends WaterDrurgbkMobEntity {
   private static final DataParameter<BlockPos> TREASURE_POS = EntityDataManager.createKey(DrurbFishEntity.class, DataSerializers.BLOCK_POS);
   private static final DataParameter<Boolean> GOT_FISH = EntityDataManager.createKey(DrurbFishEntity.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Integer> MOISTNESS = EntityDataManager.createKey(DrurbFishEntity.class, DataSerializers.VARINT);
   private static final EntityPredicate field_213810_bA = (new EntityPredicate()).setDistance(10.0D).allowFriendlyFire().allowInvulnerable().setLineOfSiteRequired();
   public static final Predicate<ItemEntity> ITEM_SELECTOR = (p_205023_0_) -> !p_205023_0_.cannotPickup() && p_205023_0_.isAlive() && p_205023_0_.isInWater();

   public DrurbFishEntity(EntityType<? extends DrurbFishEntity> type, World worldIN) {
      super(type, worldIN);
      this.moveController = new DrurbFishEntity.MoveHelperController(this);
      this.lookController = new DrurbFishLookController(this, 10);
      this.setCanPickUpLoot(true);
   }

   @Nullable
   public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
      this.setAir(this.getMaxAir());
      this.rotationPitch = 0.0F;
      return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
   }

   public boolean canBreatheUnderwater() {
      return false;
   }

   protected void updateAir(int p_209207_1_) {
   }

   public void setTreasurePos(BlockPos posIn) {
      this.dataManager.set(TREASURE_POS, posIn);
   }

   public BlockPos getTreasurePos() {
      return this.dataManager.get(TREASURE_POS);
   }

   public boolean hasGotFish() {
      return this.dataManager.get(GOT_FISH);
   }

   public void setGotFish(boolean p_208008_1_) {
      this.dataManager.set(GOT_FISH, p_208008_1_);
   }

   public int getMoistness() {
      return this.dataManager.get(MOISTNESS);
   }

   public void setMoistness(int p_211137_1_) {
      this.dataManager.set(MOISTNESS, p_211137_1_);
   }

   protected void registerData() {
      super.registerData();
      this.dataManager.register(TREASURE_POS, BlockPos.ZERO);
      this.dataManager.register(GOT_FISH, false);
      this.dataManager.register(MOISTNESS, 2400);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("TreasurePosX", this.getTreasurePos().getX());
      compound.putInt("TreasurePosY", this.getTreasurePos().getY());
      compound.putInt("TreasurePosZ", this.getTreasurePos().getZ());
      compound.putBoolean("GotFish", this.hasGotFish());
      compound.putInt("Moistness", this.getMoistness());
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      int i = compound.getInt("TreasurePosX");
      int j = compound.getInt("TreasurePosY");
      int k = compound.getInt("TreasurePosZ");
      this.setTreasurePos(new BlockPos(i, j, k));
      super.readAdditional(compound);
      this.setGotFish(compound.getBoolean("GotFish"));
      this.setMoistness(compound.getInt("Moistness"));
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(0, new BreatheAirGoal(this));
      this.goalSelector.addGoal(0, new FindWaterGoal(this));
      this.goalSelector.addGoal(1, new DrurbFishEntity.SwimToTreasureGoal(this));
      this.goalSelector.addGoal(2, new DrurbFishEntity.SwimWithPlayerGoal(this, 4.0D));
      this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
      this.goalSelector.addGoal(4, new LookDgrurbkRandomlyGoal(this));
      this.goalSelector.addGoal(5, new DgrurbkLookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(5, new DrurbFishJumpGoal(this, 10));
      this.goalSelector.addGoal(6, new MeleeDgrurbkAttackGoal(this, 1.2F, true));
      this.goalSelector.addGoal(8, new DrurbFishEntity.PlayWithItemsGoal());
      this.goalSelector.addGoal(8, new FollowBoatGoal(this));
      this.goalSelector.addGoal(9, new AvoidDgrurbkEntityGoal<>(this, Dgrurbk.class, 8.0F, 1.0D, 1.0D));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, Dgrurb.class)).setCallsForHelp());
      this.targetSelector.addGoal(3, new NearestAttackableDgrurbkTargetGoal<>(this, LivingEntity.class, false));
   }

   public static AttributeModifierMap.MutableAttribute func_234190_eK_() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)1.2F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D);
   }

   /**
    * Returns new PathNavigateGround instance
    */
   protected DgrurbPathNavigator createNavigator(World worldIn) {
      return new SwimmerDgrurbPathNavigator(this, worldIn);
   }

   public boolean attackEntityAsMob(Entity entityIn) {
      boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
      if (flag) {
         this.applyEnchantments(this, entityIn);
         this.playSound(SoundEvents.ENTITY_DOLPHIN_ATTACK, 1.0F, 1.0F);
      }

      return flag;
   }

   public int getMaxAir() {
      return 4800;
   }

   protected int determineNextAir(int currentAir) {
      return this.getMaxAir();
   }

   protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
      return 0.3F;
   }

   /**
    * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
    * use in wolves.
    */
   public int getVerticalFaceSpeed() {
      return 1;
   }

   public int getHorizontalFaceSpeed() {
      return 1;
   }

   protected boolean canBeRidden(Entity entityIn) {
      return true;
   }

   public boolean canPickUpItem(ItemStack itemstackIn) {
      EquipmentSlotType equipmentslottype = MobEntity.getSlotForItemStack(itemstackIn);
      if (!this.getItemStackFromSlot(equipmentslottype).isEmpty()) {
         return false;
      } else {
         return equipmentslottype == EquipmentSlotType.MAINHAND && super.canPickUpItem(itemstackIn);
      }
   }

   /**
    * Tests if this entity should pickup a weapon or an armor. Entity drops current weapon or armor if the new one is
    * better.
    */
   protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
      if (this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
         ItemStack itemstack = itemEntity.getItem();
         if (this.canEquipItem(itemstack)) {
            this.triggerItemPickupTrigger(itemEntity);
            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack);
            this.inventoryHandsDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
            this.onItemPickup(itemEntity, itemstack.getCount());
            itemEntity.remove();
         }
      }

   }

   /**
    * Called to update the entity's position/logic.
    */
   public void tick() {
      super.tick();
      if (this.isAIDisabled()) {
         this.setAir(this.getMaxAir());
      } else {
         if (this.isInWaterRainOrBubbleColumn()) {
            this.setMoistness(2400);
         } else {
            this.setMoistness(this.getMoistness() - 1);
            if (this.getMoistness() <= 0) {
               this.attackEntityFrom(DamageSource.DRYOUT, 1.0F);
            }

            if (this.onGround) {
               this.setMotion(this.getMotion().add((double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5D, (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F)));
               this.rotationYaw = this.rand.nextFloat() * 360.0F;
               this.onGround = false;
               this.isAirBorne = true;
            }
         }

         if (this.world.isRemote && this.isInWater() && this.getMotion().lengthSquared() > 0.03D) {
            Vector3d vector3d = this.getLook(0.0F);
            float f = MathHelper.cos(this.rotationYaw * ((float)Math.PI / 180F)) * 0.3F;
            float f1 = MathHelper.sin(this.rotationYaw * ((float)Math.PI / 180F)) * 0.3F;
            float f2 = 1.2F - this.rand.nextFloat() * 0.7F;

            for(int i = 0; i < 2; ++i) {
               this.world.addParticle(ParticleTypes.DOLPHIN, this.getPosX() - vector3d.x * (double)f2 + (double)f, this.getPosY() - vector3d.y, this.getPosZ() - vector3d.z * (double)f2 + (double)f1, 0.0D, 0.0D, 0.0D);
               this.world.addParticle(ParticleTypes.DOLPHIN, this.getPosX() - vector3d.x * (double)f2 - (double)f, this.getPosY() - vector3d.y, this.getPosZ() - vector3d.z * (double)f2 - (double)f1, 0.0D, 0.0D, 0.0D);
            }
         }

      }
   }

   /**
    * Handler for {@link World#setEntityState}
    */
   @OnlyIn(Dist.CLIENT)
   public void handleStatusUpdate(byte id) {
      if (id == 38) {
         this.func_208401_a(ParticleTypes.HAPPY_VILLAGER);
      } else {
         super.handleStatusUpdate(id);
      }

   }

   @OnlyIn(Dist.CLIENT)
   private void func_208401_a(IParticleData p_208401_1_) {
      for(int i = 0; i < 7; ++i) {
         double d0 = this.rand.nextGaussian() * 0.01D;
         double d1 = this.rand.nextGaussian() * 0.01D;
         double d2 = this.rand.nextGaussian() * 0.01D;
         this.world.addParticle(p_208401_1_, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.2D, this.getPosZRandom(1.0D), d0, d1, d2);
      }

   }

   protected ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (!itemstack.isEmpty() && itemstack.getItem().isIn(ItemTags.FISHES)) {
         if (!this.world.isRemote) {
            this.playSound(SoundEvents.ENTITY_DOLPHIN_EAT, 1.0F, 1.0F);
         }

         this.setGotFish(true);
         if (!p_230254_1_.abilities.isCreativeMode) {
            itemstack.shrink(1);
         }

         return ActionResultType.func_233537_a_(this.world.isRemote);
      } else {
         return super.func_230254_b_(p_230254_1_, p_230254_2_);
      }
   }

   public static boolean func_223364_b(EntityType<DrurbFishEntity> p_223364_0_, IWorld p_223364_1_, SpawnReason reason, BlockPos p_223364_3_, Random p_223364_4_) {
      return p_223364_3_.getY() > 45 && p_223364_3_.getY() < p_223364_1_.getSeaLevel() && (p_223364_1_.getBiome(p_223364_3_) != Biomes.OCEAN || p_223364_1_.getBiome(p_223364_3_) != Biomes.DEEP_OCEAN) && p_223364_1_.getFluidState(p_223364_3_).isTagged(FluidTags.WATER);
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_DOLPHIN_HURT;
   }

   @Nullable
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_DOLPHIN_DEATH;
   }

   @Nullable
   protected SoundEvent getAmbientSound() {
      return this.isInWater() ? SoundEvents.ENTITY_DOLPHIN_AMBIENT_WATER : SoundEvents.ENTITY_DOLPHIN_AMBIENT;
   }

   protected SoundEvent getSplashSound() {
      return SoundEvents.ENTITY_DOLPHIN_SPLASH;
   }

   protected SoundEvent getSwimSound() {
      return SoundEvents.ENTITY_DOLPHIN_SWIM;
   }

   protected boolean closeToTarget() {
      BlockPos blockpos = this.getNavigator().getTargetPos();
      return blockpos != null ? blockpos.withinDistance(this.getPositionVec(), 12.0D) : false;
   }

   public void travel(Vector3d travelVector) {
      if (this.isServerWorld() && this.isInWater()) {
         this.moveRelative(this.getAIMoveSpeed(), travelVector);
         this.move(MoverType.SELF, this.getMotion());
         this.setMotion(this.getMotion().scale(0.9D));
         if (this.getAttackTarget() == null) {
            this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
         }
      } else {
         super.travel(travelVector);
      }

   }

   public boolean canBeLeashedTo(PlayerEntity player) {
      return true;
   }

   static class MoveHelperController extends DgrurbMovementController {
      private final DrurbFishEntity dolphin;

      public MoveHelperController(DrurbFishEntity dolphinIn) {
         super(dolphinIn);
         this.dolphin = dolphinIn;
      }

      public void tick() {
         if (this.dolphin.isInWater()) {
            this.dolphin.setMotion(this.dolphin.getMotion().add(0.0D, 0.005D, 0.0D));
         }

         if (this.action == Action.MOVE_TO && !this.dolphin.getNavigator().noPath()) {
            double d0 = this.posX - this.dolphin.getPosX();
            double d1 = this.posY - this.dolphin.getPosY();
            double d2 = this.posZ - this.dolphin.getPosZ();
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d3 < (double)2.5000003E-7F) {
               this.mob.setMoveForward(0.0F);
            } else {
               float f = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
               this.dolphin.rotationYaw = this.limitAngle(this.dolphin.rotationYaw, f, 10.0F);
               this.dolphin.renderYawOffset = this.dolphin.rotationYaw;
               this.dolphin.rotationYawHead = this.dolphin.rotationYaw;
               float f1 = (float)(this.speed * this.dolphin.getAttributeValue(Attributes.MOVEMENT_SPEED));
               if (this.dolphin.isInWater()) {
                  this.dolphin.setAIMoveSpeed(f1 * 0.02F);
                  float f2 = -((float)(MathHelper.atan2(d1, (double)MathHelper.sqrt(d0 * d0 + d2 * d2)) * (double)(180F / (float)Math.PI)));
                  f2 = MathHelper.clamp(MathHelper.wrapDegrees(f2), -85.0F, 85.0F);
                  this.dolphin.rotationPitch = this.limitAngle(this.dolphin.rotationPitch, f2, 5.0F);
                  float f3 = MathHelper.cos(this.dolphin.rotationPitch * ((float)Math.PI / 180F));
                  float f4 = MathHelper.sin(this.dolphin.rotationPitch * ((float)Math.PI / 180F));
                  this.dolphin.moveForward = f3 * f1;
                  this.dolphin.moveVertical = -f4 * f1;
               } else {
                  this.dolphin.setAIMoveSpeed(f1 * 0.1F);
               }

            }
         } else {
            this.dolphin.setAIMoveSpeed(0.0F);
            this.dolphin.setMoveStrafing(0.0F);
            this.dolphin.setMoveVertical(0.0F);
            this.dolphin.setMoveForward(0.0F);
         }
      }
   }

   class PlayWithItemsGoal extends Goal {
      private int field_205154_b;

      private PlayWithItemsGoal() {
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         if (this.field_205154_b > DrurbFishEntity.this.ticksExisted) {
            return false;
         } else {
            List<ItemEntity> list = DrurbFishEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, DrurbFishEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), DrurbFishEntity.ITEM_SELECTOR);
            return !list.isEmpty() || !DrurbFishEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty();
         }
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         List<ItemEntity> list = DrurbFishEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, DrurbFishEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), DrurbFishEntity.ITEM_SELECTOR);
         if (!list.isEmpty()) {
            DrurbFishEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
            DrurbFishEntity.this.playSound(SoundEvents.ENTITY_DOLPHIN_PLAY, 1.0F, 1.0F);
         }

         this.field_205154_b = 0;
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         ItemStack itemstack = DrurbFishEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (!itemstack.isEmpty()) {
            this.func_220810_a(itemstack);
            DrurbFishEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
            this.field_205154_b = DrurbFishEntity.this.ticksExisted + DrurbFishEntity.this.rand.nextInt(100);
         }

      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         List<ItemEntity> list = DrurbFishEntity.this.world.getEntitiesWithinAABB(ItemEntity.class, DrurbFishEntity.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), DrurbFishEntity.ITEM_SELECTOR);
         ItemStack itemstack = DrurbFishEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (!itemstack.isEmpty()) {
            this.func_220810_a(itemstack);
            DrurbFishEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
         } else if (!list.isEmpty()) {
            DrurbFishEntity.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double)1.2F);
         }

      }

      private void func_220810_a(ItemStack p_220810_1_) {
         if (!p_220810_1_.isEmpty()) {
            double d0 = DrurbFishEntity.this.getPosYEye() - (double)0.3F;
            ItemEntity itementity = new ItemEntity(DrurbFishEntity.this.world, DrurbFishEntity.this.getPosX(), d0, DrurbFishEntity.this.getPosZ(), p_220810_1_);
            itementity.setPickupDelay(40);
            itementity.setThrowerId(DrurbFishEntity.this.getUniqueID());
            float f = 0.3F;
            float f1 = DrurbFishEntity.this.rand.nextFloat() * ((float)Math.PI * 2F);
            float f2 = 0.02F * DrurbFishEntity.this.rand.nextFloat();
            itementity.setMotion((double)(0.3F * -MathHelper.sin(DrurbFishEntity.this.rotationYaw * ((float)Math.PI / 180F)) * MathHelper.cos(DrurbFishEntity.this.rotationPitch * ((float)Math.PI / 180F)) + MathHelper.cos(f1) * f2), (double)(0.3F * MathHelper.sin(DrurbFishEntity.this.rotationPitch * ((float)Math.PI / 180F)) * 1.5F), (double)(0.3F * MathHelper.cos(DrurbFishEntity.this.rotationYaw * ((float)Math.PI / 180F)) * MathHelper.cos(DrurbFishEntity.this.rotationPitch * ((float)Math.PI / 180F)) + MathHelper.sin(f1) * f2));
            DrurbFishEntity.this.world.addEntity(itementity);
         }
      }
   }

   static class SwimToTreasureGoal extends Goal {
      private final DrurbFishEntity dolphin;
      private boolean field_208058_b;

      SwimToTreasureGoal(DrurbFishEntity dolphinIn) {
         this.dolphin = dolphinIn;
         this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
      }

      public boolean isPreemptible() {
         return false;
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         return this.dolphin.hasGotFish() && this.dolphin.getAir() >= 100;
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         BlockPos blockpos = this.dolphin.getTreasurePos();
         return !(new BlockPos((double)blockpos.getX(), this.dolphin.getPosY(), (double)blockpos.getZ())).withinDistance(this.dolphin.getPositionVec(), 4.0D) && !this.field_208058_b && this.dolphin.getAir() >= 100;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         if (this.dolphin.world instanceof ServerWorld) {
            ServerWorld serverworld = (ServerWorld)this.dolphin.world;
            this.field_208058_b = false;
            this.dolphin.getNavigator().clearPath();
            BlockPos blockpos = this.dolphin.getPosition();
            Structure<?> structure = (double)serverworld.rand.nextFloat() >= 0.5D ? Structure.field_236377_m_ : Structure.field_236373_i_;
            BlockPos blockpos1 = serverworld.func_241117_a_(structure, blockpos, 50, false);
            if (blockpos1 == null) {
               Structure<?> structure1 = structure.equals(Structure.field_236377_m_) ? Structure.field_236373_i_ : Structure.field_236377_m_;
               BlockPos blockpos2 = serverworld.func_241117_a_(structure1, blockpos, 50, false);
               if (blockpos2 == null) {
                  this.field_208058_b = true;
                  return;
               }

               this.dolphin.setTreasurePos(blockpos2);
            } else {
               this.dolphin.setTreasurePos(blockpos1);
            }

            serverworld.setEntityState(this.dolphin, (byte)38);
         }
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         BlockPos blockpos = this.dolphin.getTreasurePos();
         if ((new BlockPos((double)blockpos.getX(), this.dolphin.getPosY(), (double)blockpos.getZ())).withinDistance(this.dolphin.getPositionVec(), 4.0D) || this.field_208058_b) {
            this.dolphin.setGotFish(false);
         }

      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         World world = this.dolphin.world;
         if (this.dolphin.closeToTarget() || this.dolphin.getNavigator().noPath()) {
            Vector3d vector3d = Vector3d.copyCentered(this.dolphin.getTreasurePos());
            Vector3d vector3d1 = RandomPositionGenerator.findRandomTargetTowardsScaled(this.dolphin, 16, 1, vector3d, (double)((float)Math.PI / 8F));
            if (vector3d1 == null) {
               vector3d1 = RandomPositionGenerator.findRandomTargetBlockTowards(this.dolphin, 8, 4, vector3d);
            }

            if (vector3d1 != null) {
               BlockPos blockpos = new BlockPos(vector3d1);
               if (!world.getFluidState(blockpos).isTagged(FluidTags.WATER) || !world.getBlockState(blockpos).allowsMovement(world, blockpos, PathType.WATER)) {
                  vector3d1 = RandomPositionGenerator.findRandomTargetBlockTowards(this.dolphin, 8, 5, vector3d);
               }
            }

            if (vector3d1 == null) {
               this.field_208058_b = true;
               return;
            }

            this.dolphin.getLookController().setLookPosition(vector3d1.x, vector3d1.y, vector3d1.z, (float)(this.dolphin.getHorizontalFaceSpeed() + 20), (float)this.dolphin.getVerticalFaceSpeed());
            this.dolphin.getNavigator().tryMoveToXYZ(vector3d1.x, vector3d1.y, vector3d1.z, 1.3D);
            if (world.rand.nextInt(80) == 0) {
               world.setEntityState(this.dolphin, (byte)38);
            }
         }

      }
   }

   static class SwimWithPlayerGoal extends Goal {
      private final DrurbFishEntity dolphin;
      private final double speed;
      private PlayerEntity targetPlayer;

      SwimWithPlayerGoal(DrurbFishEntity dolphinIn, double speedIn) {
         this.dolphin = dolphinIn;
         this.speed = speedIn;
         this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         this.targetPlayer = this.dolphin.world.getClosestPlayer(DrurbFishEntity.field_213810_bA, this.dolphin);
         if (this.targetPlayer == null) {
            return false;
         } else {
            return this.targetPlayer.isSwimming() && this.dolphin.getAttackTarget() != this.targetPlayer;
         }
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         return this.targetPlayer != null && this.targetPlayer.isSwimming() && this.dolphin.getDistanceSq(this.targetPlayer) < 256.0D;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         this.targetPlayer.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 100));
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         this.targetPlayer = null;
         this.dolphin.getNavigator().clearPath();
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         this.dolphin.getLookController().setLookPositionWithEntity(this.targetPlayer, (float)(this.dolphin.getHorizontalFaceSpeed() + 20), (float)this.dolphin.getVerticalFaceSpeed());
         if (this.dolphin.getDistanceSq(this.targetPlayer) < 6.25D) {
            this.dolphin.getNavigator().clearPath();
         } else {
            this.dolphin.getNavigator().tryMoveToEntityLiving(this.targetPlayer, this.speed);
         }

         if (this.targetPlayer.isSwimming() && this.targetPlayer.world.rand.nextInt(6) == 0) {
            this.targetPlayer.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 100));
         }

      }
   }
}
