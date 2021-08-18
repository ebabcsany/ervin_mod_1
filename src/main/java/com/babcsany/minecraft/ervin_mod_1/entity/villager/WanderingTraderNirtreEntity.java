package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.NirtreLookAtCustomerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.NirtreTradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.WanderingTraderNirtreTrades;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableToolItemInit;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class WanderingTraderNirtreEntity extends AbstractNirtreEntity {
   private static final int[] LEVEL_EXPERIENCE_AMOUNTS = new int[]{0, 50, 350, 750, 1250};
   @Nullable
   private BlockPos wanderTarget;
   private int despawnDelay;
   public float wingRotation;
   public float destPos;
   private int inWaterTime;
   private int timeUntilReset;
   private boolean leveledUp;
   @Nullable
   private PlayerEntity previousCustomer;
   private int xp;
   public float wingRotDelta = 1.0F;
   private int level;
   private int traderNirtreConversionTime;
   public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;
   public int timeUntilNextItem_ = this.rand.nextInt(12000) + 7000;
   public boolean dropItem;

   public WanderingTraderNirtreEntity(EntityType<? extends WanderingTraderNirtreEntity> type, World worldIn) {
      super(type, worldIn);
      this.forceSpawn = true;
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(0, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.INVISIBILITY), SoundEvents.ENTITY_WANDERING_TRADER_DISAPPEARED, (trader) -> !this.world.isDaytime() && !trader.isInvisible()));
      this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.ENTITY_WANDERING_TRADER_REAPPEARED, (trader) -> this.world.isDaytime() && trader.isInvisible()));
      this.goalSelector.addGoal(1, new NirtreTradeWithPlayerGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
      this.goalSelector.addGoal(1, new NirtreLookAtCustomerGoal(this));
      this.goalSelector.addGoal(2, new WanderingTraderNirtreEntity.MoveToGoal(this, 2.0D, 0.35D));
      this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
      this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.35D));
      this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
      this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK);
   }

   @Nullable
   public AgeableEntity createChild(AgeableEntity ageable) {
      return null;
   }

   public boolean func_213705_dZ() {
      return true;
   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (itemstack.getItem() != ModSpawnEggItemInit.WANDERING_TRADER_NIRTRE_SPAWN_EGG.get() && this.isAlive() && !this.hasCustomer() && !this.isChild()) {
         if (p_230254_2_ == Hand.MAIN_HAND) {
            p_230254_1_.addStat(Stats.TALKED_TO_VILLAGER);
         }

         if (this.getOffers().isEmpty()) {
            return ActionResultType.func_233537_a_(this.world.isRemote);
         } else {
            if (!this.world.isRemote) {
               this.setCustomer(p_230254_1_);
               this.openMerchantContainer(p_230254_1_, this.getDisplayName(), 1);
            }

            return ActionResultType.func_233537_a_(this.world.isRemote);
         }
      } else {
         return super.func_230254_b_(p_230254_1_, p_230254_2_);
      }
   }

   protected void populateTradeData() {
      WanderingTraderNirtreTrades.ITrade[] aWanderingTraderNirtreTrades$iTrade = WanderingTraderNirtreTrades.trade1.get(1);
      WanderingTraderNirtreTrades.ITrade1[] aWanderingTraderNirtreTrades$iTrade1 = WanderingTraderNirtreTrades.trade2.get(1);
      if (aWanderingTraderNirtreTrades$iTrade != null && aWanderingTraderNirtreTrades$iTrade1 != null) {
         MerchantOffers merchantoffers = this.getOffers();
         com.babcsany.minecraft.item.MerchantOffers merchantoffers1 = this.getOffers1();
         this.addWanderingTraderNirtreTrades(merchantoffers, aWanderingTraderNirtreTrades$iTrade, 10);
         int i = this.rand.nextInt(aWanderingTraderNirtreTrades$iTrade.length);
         WanderingTraderNirtreTrades.ITrade wanderingTraderNirtreTrades$iTrade = aWanderingTraderNirtreTrades$iTrade[i];
         MerchantOffer merchantoffer = wanderingTraderNirtreTrades$iTrade.getOffer(this, this.rand);
         if (merchantoffer != null) {
            merchantoffers.add(merchantoffer);
         }

      }
   }

   protected void populateTradeData1() {
      WanderingTraderNirtreTrades.ITrade1[] aWanderingTraderNirtreTrades$iTrade1 = WanderingTraderNirtreTrades.trade2.get(1);
      if (aWanderingTraderNirtreTrades$iTrade1 != null) {
         com.babcsany.minecraft.item.MerchantOffers merchantoffers = this.getOffers1();
         this.addWanderingTraderNirtreTrades(merchantoffers, aWanderingTraderNirtreTrades$iTrade1, 1);
         int i = this.rand.nextInt(aWanderingTraderNirtreTrades$iTrade1.length);
         WanderingTraderNirtreTrades.ITrade1 wanderingTraderNirtreTrades$iTrade = aWanderingTraderNirtreTrades$iTrade1[i];
         com.babcsany.minecraft.item.MerchantOffer merchantoffer = wanderingTraderNirtreTrades$iTrade.getOffer(this, this.rand);
         if (merchantoffer != null) {
            merchantoffers.add(merchantoffer);
         }

      }
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("DespawnDelay", this.despawnDelay);
      if (this.wanderTarget != null) {
         compound.put("WanderTarget", NBTUtil.writeBlockPos(this.wanderTarget));
      }

   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      super.readAdditional(compound);
      if (compound.contains("DespawnDelay", 99)) {
         this.despawnDelay = compound.getInt("DespawnDelay");
      }

      if (compound.contains("WanderTarget")) {
         this.wanderTarget = NBTUtil.readBlockPos(compound.getCompound("WanderTarget"));
      }

      this.setGrowingAge(Math.max(0, this.getGrowingAge()));
   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return false;
   }

   protected void onNirtreTrade(MerchantOffer offer) {
      int f = 3 + this.rand.nextInt(4);
      this.xp += offer.getGivenExp();
      this.previousCustomer = this.getCustomer();
      if (this.canLevelUp()) {
         this.timeUntilReset = 40;
         this.leveledUp = true;
         f += 5;
      }
      if (offer.getDoesRewardExp()) {
         int i = 3 + this.rand.nextInt(4);
         this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), i));
      }

   }

   public int getLevel() {
      return this.level;
   }

   private boolean canLevelUp() {
      int i = this.getLevel();
      return canLevelUp(i) && this.xp >= func_221127_c(i);
   }

   public static int func_221127_c(int p_221127_0_) {
      return canLevelUp(p_221127_0_) ? LEVEL_EXPERIENCE_AMOUNTS[p_221127_0_] : 0;
   }

   public static boolean canLevelUp(int level) {
      return level >= 1 && level < 5;
   }

   protected SoundEvent getAmbientSound() {
      return this.hasCustomer() ? SoundEvents.ENTITY_WANDERING_TRADER_TRADE : SoundEvents.ENTITY_WANDERING_TRADER_AMBIENT;
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_WANDERING_TRADER_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_WANDERING_TRADER_DEATH;
   }

   protected SoundEvent getDrinkSound(ItemStack stack) {
      Item item = stack.getItem();
      return item == Items.MILK_BUCKET ? SoundEvents.ENTITY_WANDERING_TRADER_DRINK_MILK : SoundEvents.ENTITY_WANDERING_TRADER_DRINK_POTION;
   }

   protected SoundEvent getNirtreYesNoSound(boolean getYesSound) {
      return getYesSound ? SoundEvents.ENTITY_WANDERING_TRADER_YES : SoundEvents.ENTITY_WANDERING_TRADER_NO;
   }

   public SoundEvent getYesSound() {
      return SoundEvents.ENTITY_WANDERING_TRADER_YES;
   }

   public void setDespawnDelay(int delay) {
      this.despawnDelay = delay;
   }

   public int getDespawnDelay() {
      return this.despawnDelay;
   }

   private void handleDespawn() {
      if (this.despawnDelay > 0 && !this.hasCustomer() && --this.despawnDelay == 0) {
         this.remove();
      }

   }

   public void setWanderTarget(@Nullable BlockPos pos) {
      this.wanderTarget = pos;
   }

   @Nullable
   private BlockPos getWanderTarget() {
      return this.wanderTarget;
   }

   class MoveToGoal extends Goal {
      final WanderingTraderNirtreEntity traderEntity;
      final double maxDistance;
      final double speed;

      MoveToGoal(WanderingTraderNirtreEntity traderEntityIn, double distanceIn, double speedIn) {
         this.traderEntity = traderEntityIn;
         this.maxDistance = distanceIn;
         this.speed = speedIn;
         this.setMutexFlags(EnumSet.of(Flag.MOVE));
      }

      /**
       * Reset the task's internal state. Called when this task is interrupted by another one
       */
      public void resetTask() {
         this.traderEntity.setWanderTarget(null);
         WanderingTraderNirtreEntity.this.navigator.clearPath();
      }

      /**
       * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
       * method as well.
       */
      public boolean shouldExecute() {
         BlockPos blockpos = this.traderEntity.getWanderTarget();
         return blockpos != null && this.isWithinDistance(blockpos, this.maxDistance);
      }

      /**
       * Keep ticking a continuous task that has already been started
       */
      public void tick() {
         BlockPos blockpos = this.traderEntity.getWanderTarget();
         if (blockpos != null && WanderingTraderNirtreEntity.this.navigator.noPath()) {
            if (this.isWithinDistance(blockpos, 10.0D)) {
               Vector3d vector3d = (new Vector3d((double)blockpos.getX() - this.traderEntity.getPosX(), (double)blockpos.getY() - this.traderEntity.getPosY(), (double)blockpos.getZ() - this.traderEntity.getPosZ())).normalize();
               Vector3d vector3d1 = vector3d.scale(10.0D).add(this.traderEntity.getPosX(), this.traderEntity.getPosY(), this.traderEntity.getPosZ());
               WanderingTraderNirtreEntity.this.navigator.tryMoveToXYZ(vector3d1.x, vector3d1.y, vector3d1.z, this.speed);
            } else {
               WanderingTraderNirtreEntity.this.navigator.tryMoveToXYZ(blockpos.getX(), blockpos.getY(), blockpos.getZ(), this.speed);
            }
         }

      }

      private boolean isWithinDistance(BlockPos pos, double distance) {
         return !pos.withinDistance(this.traderEntity.getPositionVec(), distance);
      }
   }

   public void livingTick() {
      super.livingTick();
      if (!this.world.isRemote) {
         this.handleDespawn();
      }
      this.wingRotation += this.wingRotDelta * 2.0F;
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isDropItem() && --this.timeUntilNextItem <= 0) {
         this.entityDropItem(isBurnableToolItemInit.Bj_PICKAXE.get());
         this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
      }
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isDropItem() && --this.timeUntilNextItem <= 0) {
         this.entityDropItem(BlockItemInit_.FIGHIV.get());
         this.timeUntilNextItem_ = this.rand.nextInt(28000) + 14000;
      }
   }

   public boolean isDropItem() {
      return this.dropItem;
   }

}