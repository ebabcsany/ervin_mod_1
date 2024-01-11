package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.EatPumpkinGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AgeableZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.schedule.Schedule;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ZurEntity_ extends MonsterEntity {
   private static final DataParameter<Boolean> field_234408_bu_ = EntityDataManager.createKey(ZurEntity_.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> field_213428_bH = EntityDataManager.createKey(ZurEntity_.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> field_213428_bG = EntityDataManager.createKey(ZurEntity_.class, DataSerializers.BOOLEAN);
   private static final DataParameter<Boolean> field_213429_bH = EntityDataManager.createKey(ZurEntity_.class, DataSerializers.BOOLEAN);
   protected static final DataParameter<Byte> TAMED = EntityDataManager.createKey(ZurEntity_.class, DataSerializers.BYTE);
   protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.createKey(ZurEntity_.class, DataSerializers.OPTIONAL_UNIQUE_ID);
   public static final Map<Item, Integer> FOOD_VALUES = ImmutableMap.of(isBurnableItemInit.LEAT.get(), 4, ItemInit.MLONK.get(), 1, Items.CARROT, 1, Items.BEETROOT, 1);
   private static final DataParameter<Boolean> field_234409_bv_ = EntityDataManager.createKey(ZurEntity_.class, DataSerializers.BOOLEAN);
   public ServerPlayNetHandler connection;
   private byte foodLevel;
   private long field_213783_bN;
   private UUID field_234609_b_;
   private int field_234610_c_;
   protected int growingAge;
   public float destPos;
   private static final Predicate<ItemEntity> ITEMS = (p_213575_0_) -> {
      Item item = p_213575_0_.getItem().getItem();
      return (item == com.babcsany.minecraft.init.BlockItemInit.JURKF.asItem() || item == Blocks.CAKE.asItem()) && p_213575_0_.isAlive() && !p_213575_0_.cannotPickup();
   };
   private NearestAttackableTargetExpiringGoal<AbstractZurEntity> field_213694_bC;
   private int inWaterTime;
   private float crouchAmount;
   private float crouchAmountO;
   private int drownedConversionTime;

   public ZurEntity_(EntityType<ZurEntity_> type, World worldIn) {
      super(type, worldIn);
      this.setCanPickUpLoot(true);
      this.experienceValue = 5;
      ((GroundPathNavigator)this.getNavigator()).setBreakDoors(true);
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
      this.goalSelector.addGoal(15, new UseItemGoal<>(this, new ItemStack(SpecialBlockFoodItemInit.FIRG.get()), SoundEvents.AMBIENT_UNDERWATER_LOOP, (zur) -> this.world.isDaytime() && zur.isInvisible()));
      this.goalSelector.addGoal(15, new UseItemGoal<>(this, new ItemStack(isBurnableFoodItemInit.TIRKS.get()), SoundEvents.AMBIENT_UNDERWATER_LOOP, (zur) -> this.world.isDaytime() && zur.isInvisible()));
      this.goalSelector.addGoal(7, new ZurEntity_.SitGoal());
      this.applyEntityAI();
   }

   private void applyEntityAI() {
      EatGrassGoal eatGrassGoal = new EatGrassGoal(this);
      EatPumpkinGoal eatPumpkinGoal = new EatPumpkinGoal(this);
      //this.goalSelector.addGoal(6, new MorningGiftGoal(this));
      this.goalSelector.addGoal(4, new ZurEntity_.PounceGoal(this));
      this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
      this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
      this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, 1.0F));
      this.goalSelector.addGoal(3, new OpenDoorGoal(this, false));
      this.goalSelector.addGoal(4, new SwimGoal(this));
      this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp(TraderNirtreEntity.class));
      this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
      this.goalSelector.addGoal(5, eatGrassGoal);
      this.goalSelector.addGoal(5, eatPumpkinGoal);
      this.goalSelector.addGoal(5, eatPumpkinGoal);
      this.goalSelector.addGoal(5, eatGrassGoal);
      this.breakBlockGoals();
   }

   private void breakBlockGoals() {
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COBBLESTONE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COBBLESTONE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COBBLESTONE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COBBLESTONE_WALL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_BRICKS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_BRICK_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_BRICK_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.STONE_BRICK_WALL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIRT, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(BlockItemInit.DIRT_SLAB.get(), this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(MinecraftBlocks.DIRT_STAIRS.get(), this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRASS_BLOCK, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRASS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.PODZOL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRASS_PATH, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.FARMLAND, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.BEDROCK, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.ANDESITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.ANDESITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.ANDESITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.ANDESITE_WALL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_ANDESITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_ANDESITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_ANDESITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRANITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRANITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRANITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GRANITE_WALL, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_GRANITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_GRANITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_GRANITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIORITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIORITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIORITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_DIORITE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_DIORITE_SLAB, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.POLISHED_DIORITE_STAIRS, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.IRON_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.COAL_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.GOLD_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.REDSTONE_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.DIAMOND_ORE, this, 4, 6));
      this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.EMERALD_ORE, this, 4, 6));
   }

   public void applyWaveBonus(int p_213660_1_, boolean p_213660_2_) {
   }

   public boolean canBeLeader() {
      return false;
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_().createMutableAttribute(Attributes.FOLLOW_RANGE, 100.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 40.0D).createMutableAttribute(Attributes.ARMOR, 20.0D).createMutableAttribute(Attributes.MAX_HEALTH, 260).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 5.0D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 15.0D);
   }

//   @Nullable
//   public AgeableEntity createChild(AgeableEntity ageable) {
//      return EntityInit.ZUR_ENTITY.get().create(this.world);
//   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return !this.isNoDespawnRequired();
   }

   public SoundEvent getRaidLossSound() {
      return SoundEvents.ENTITY_BAT_DEATH;
   }

   /**
    * Fires an arrow
    */
   protected AbstractArrowEntity fireArrow(ItemStack arrowStack, float distanceFactor) {
      return ProjectileHelper.fireArrow(this, arrowStack, distanceFactor);
   }

   public void setShooter(@Nullable Entity entityIn) {
      if (entityIn != null) {
         this.field_234609_b_ = entityIn.getUniqueID();
         this.field_234610_c_ = entityIn.getEntityId();
      }

   }

   private boolean hasSeenGolemRecently(long gameTime) {
      Optional<Long> optional = this.brain.getMemory(MemoryModuleType.GOLEM_LAST_SEEN_TIME);
      if (!optional.isPresent()) {
         return false;
      } else {
         Long olong = optional.get();
         return gameTime - olong <= 600L;
      }
   }

   public boolean canSpawnGolems(long gameTime) {
      if (!this.hasSleptAndWorkedRecently(this.world.getGameTime())) {
         return false;
      } else {
         return !this.hasSeenGolemRecently(gameTime);
      }
   }

   @Nullable
   private WanderingTraderNirtreEntity trySpawnWanderingTraderNirtre() {
      BlockPos blockpos = this.getPosition();

      for(int i = 0; i < 10; ++i) {
         double d0 = this.world.rand.nextInt(16) - 8;
         double d1 = this.world.rand.nextInt(16) - 8;
         BlockPos blockpos1 = this.func_241433_a_(blockpos, d0, d1);
         if (blockpos1 != null) {
            WanderingTraderNirtreEntity wanderingTraderNirtreEntity = EntityInit.WANDERING_TRADER_NIRTRE_ENTITY.get().create(this.world, null, null, null, blockpos1, SpawnReason.MOB_SUMMONED, false, false);
            if (wanderingTraderNirtreEntity != null) {
               if (wanderingTraderNirtreEntity.canSpawn(this.world, SpawnReason.MOB_SUMMONED) && wanderingTraderNirtreEntity.isNotColliding(this.world)) {
                  this.world.addEntity(wanderingTraderNirtreEntity);
                  return wanderingTraderNirtreEntity;
               }

               wanderingTraderNirtreEntity.remove();
            }
         }
      }

      return null;
   }

   @Nullable
   private BlockPos func_241433_a_(BlockPos p_241433_1_, double p_241433_2_, double p_241433_4_) {
      int i = 6;
      BlockPos blockpos = p_241433_1_.add(p_241433_2_, 6.0D, p_241433_4_);
      BlockState blockstate = this.world.getBlockState(blockpos);

      for(int j = 6; j >= -6; --j) {
         BlockPos blockpos1 = blockpos;
         BlockState blockstate1 = blockstate;
         blockpos = blockpos.down();
         blockstate = this.world.getBlockState(blockpos);
         if ((blockstate1.isAir() || blockstate1.getMaterial().isLiquid()) && blockstate.getMaterial().isOpaque()) {
            return blockpos1;
         }
      }

      return null;
   }

   public class PounceGoal extends net.minecraft.entity.ai.goal.JumpGoal {
      public PounceGoal(ZurEntity_ zurEntity) {
         super();
      }

      @Override
      public boolean shouldExecute() {
         return false;
      }

      /**
       * Returns whether an in-progress EntityAIBase should continue executing
       */
      public boolean shouldContinueExecuting() {
         LivingEntity livingentity = ZurEntity_.this.getAttackTarget();
         if (livingentity != null && livingentity.isAlive()) {
            double d0 = ZurEntity_.this.getMotion().y;
            return (!(d0 * d0 < (double)0.05F) || !(Math.abs(ZurEntity_.this.rotationPitch) < 15.0F) || !ZurEntity_.this.onGround);
         } else {
            return false;
         }
      }

      public boolean isPreemptible() {
         return false;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         ZurEntity_.this.setJumping(true);
         LivingEntity livingentity = ZurEntity_.this.getAttackTarget();
         ZurEntity_.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
         Vector3d vector3d = (new Vector3d(livingentity.getPosX() - ZurEntity_.this.getPosX(), livingentity.getPosY() - ZurEntity_.this.getPosY(), livingentity.getPosZ() - ZurEntity_.this.getPosZ())).normalize();
         ZurEntity_.this.setMotion(ZurEntity_.this.getMotion().add(vector3d.x * 0.8D, 0.9D, vector3d.z * 0.8D));
         ZurEntity_.this.getNavigator().clearPath();
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         ZurEntity_.this.crouchAmount = 0.0F;
         ZurEntity_.this.crouchAmountO = 0.0F;
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick(ZurEntity_ zur) {
         LivingEntity livingentity = ZurEntity_.this.getAttackTarget();
         Vector3d vector3d = ZurEntity_.this.getMotion();
         if (livingentity != null) {
            ZurEntity_.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
         }

         if (vector3d.y * vector3d.y < (double)0.03F && ZurEntity_.this.rotationPitch != 0.0F) {
            ZurEntity_.this.rotationPitch = MathHelper.rotLerp(ZurEntity_.this.rotationPitch, 0.0F, 0.2F);
         } else {
            double d0 = Math.sqrt(Entity.horizontalMag(vector3d));
            double d1 = Math.signum(-vector3d.y) * Math.acos(d0 / vector3d.length()) * (double)(180F / (float)Math.PI);
            ZurEntity_.this.rotationPitch = (float)d1;
         }

         if (livingentity != null && ZurEntity_.this.getDistance(livingentity) <= 2.0F) {
            ZurEntity_.this.attackEntityAsMob(livingentity);
         } else if (ZurEntity_.this.rotationPitch > 0.0F && ZurEntity_.this.onGround) {
            ZurEntity_.this.rotationPitch = 60.0F;
            ZurEntity_.this.setAttackTarget(null);
         }

      }
   }

   public void startSleeping(BlockPos pos) {
      super.startSleeping(pos);
      this.brain.setMemory(MemoryModuleType.LAST_SLEPT, this.world.getGameTime());
      this.brain.removeMemory(MemoryModuleType.WALK_TARGET);
      this.brain.removeMemory(MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE);
   }

   public void wakeUp() {
      super.wakeUp();
      this.brain.setMemory(MemoryModuleType.LAST_WOKEN, this.world.getGameTime());
   }

   private boolean hasSleptAndWorkedRecently(long gameTime) {
      Optional<Long> optional = this.brain.getMemory(MemoryModuleType.LAST_SLEPT);
      return optional.filter(aLong -> gameTime - aLong < 24000L).isPresent();
   }

   @Nullable
   public LivingEntity getOwner() {
      try {
         UUID uuid = this.getOwnerId();
         return uuid == null ? null : this.world.getPlayerByUuid(uuid);
      } catch (IllegalArgumentException illegalargumentexception) {
         return null;
      }
   }

   public boolean func_213416_eg() {
      return this.dataManager.get(field_213428_bG);
   }

   public void func_213419_u(boolean p_213419_1_) {
      this.dataManager.set(field_213428_bG, p_213419_1_);
   }

   public boolean func_213409_eh() {
      return this.dataManager.get(field_213429_bH);
   }

   public void func_213415_v(boolean p_213415_1_) {
      this.dataManager.set(field_213429_bH, p_213415_1_);
   }

   @Nullable
   public UUID getOwnerId() {
      return this.dataManager.get(OWNER_UNIQUE_ID).orElse(null);
   }

   class SitGoal extends Goal {
      private int field_220832_b;

      public SitGoal() {
         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
      }

      @Override
      public boolean shouldExecute() {
         return false;
      }

      /**
       * Execute a one shot task or start executing a continuous task
       */
      public void startExecuting() {
         List<ItemEntity> list = ZurEntity_.this.world.getEntitiesWithinAABB(ItemEntity.class, ZurEntity_.this.getBoundingBox().grow(8.0D, 8.0D, 8.0D), ZurEntity_.ITEMS);
         if (!list.isEmpty() && ZurEntity_.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
            ZurEntity_.this.getNavigator().tryMoveToEntityLiving(list.get(0), 1.2F);
         } else if (!ZurEntity_.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
            ZurEntity_.this.tryToSit();
         }

         this.field_220832_b = 0;
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         ItemStack itemstack = ZurEntity_.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
         if (!itemstack.isEmpty()) {
            ZurEntity_.this.entityDropItem(itemstack);
            ZurEntity_.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
         }
      }
   }

   private void tryToSit() {
      if (!this.isInWater()) {
         this.setMoveForward(0.0F);
         this.getNavigator().clearPath();
      }

   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_GENERIC_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_GENERIC_DEATH;
   }

   protected SoundEvent getStepSound() {
      return SoundEvents.ENTITY_PLAYER_SPLASH;
   }

   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(this.getStepSound(), 0.15F, 1.0F);
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);

      compound.putInt("InWaterTime", this.isInWater() ? this.inWaterTime : -1);
   }

   public void onKillEntity(LivingEntity entityLivingIn) {
      super.onKillEntity(entityLivingIn);
      if ((this.world.getDifficulty() == Difficulty.NORMAL || this.world.getDifficulty() == Difficulty.HARD) && entityLivingIn instanceof TraderNirtreEntity) {
         if (this.world.getDifficulty() != Difficulty.HARD && this.rand.nextBoolean()) {
            return;
         }

         TraderNirtreEntity traderNirtreEntity = (TraderNirtreEntity) entityLivingIn;
         ZurNirtreEntity zurNirtreEntity = EntityInit.ZUR_NIRTRE_ENTITY.get().create(this.world);
         (zurNirtreEntity).copyLocationAndAnglesFrom(traderNirtreEntity);
         traderNirtreEntity.remove();
         zurNirtreEntity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(zurNirtreEntity.getPosition()), SpawnReason.CONVERSION, new ZurEntity_.GroupData(false, true), (CompoundNBT)null);
         //zurNirtreEntity.setOffers(traderNirtreEntity.getOffers().write());
         //zurNirtreEntigty.setEXP(traderNirtreEntity.getXp());
         zurNirtreEntity.setChild(traderNirtreEntity.isChild());
         zurNirtreEntity.setNoAI(traderNirtreEntity.isAIDisabled());
         if (traderNirtreEntity.hasCustomName()) {
            zurNirtreEntity.setCustomName(traderNirtreEntity.getCustomName());
            zurNirtreEntity.setCustomNameVisible(traderNirtreEntity.isCustomNameVisible());
         }

         if (traderNirtreEntity.isNoDespawnRequired()) {
            zurNirtreEntity.enablePersistence();
         }

         zurNirtreEntity.setInvulnerable(this.isInvulnerable());
         this.world.addEntity(zurNirtreEntity);
         if (!this.isSilent()) {
            this.world.playEvent(null, 1026, this.getPosition(), 0);
         }
      }
   }

   public boolean canEquipItem(ItemStack stack) {
      return (stack.getItem() != Items.EGG || !this.isChild() || !this.isPassenger()) && super.canEquipItem(stack);
   }

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

   public static class GroupData implements ILivingEntityData {
      public final boolean isChild;
      public final boolean field_241400_b_;

      public GroupData(boolean p_i231567_1_, boolean p_i231567_2_) {
         this.isChild = p_i231567_1_;
         this.field_241400_b_ = p_i231567_2_;
      }
   }

   protected void sendDebugPackets() {
      super.sendDebugPackets();
      DebugPacketSender.sendLivingEntity(this);
   }
}