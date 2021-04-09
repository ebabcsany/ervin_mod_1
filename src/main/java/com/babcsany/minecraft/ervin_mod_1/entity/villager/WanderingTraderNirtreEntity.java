package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import java.util.EnumSet;
import javax.annotation.Nullable;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.LookAtCustomerGoal1;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.WanderingTraderTradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.WanderingTraderNirtreTrades;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class WanderingTraderNirtreEntity extends AbstractNirtreEntity {
   @Nullable
   private BlockPos wanderTarget;
   private int despawnDelay;
   public float wingRotation;
   public float destPos;
   public float wingRotDelta = 1.0F;
   public int timeUntilNextItem = this.rand.nextInt(6000) + 6000;
   public boolean wanderingTraderNirtreJockey;

   public WanderingTraderNirtreEntity(EntityType<? extends WanderingTraderNirtreEntity> type, World worldIn) {
      super(type, worldIn);
      this.forceSpawn = true;
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(0, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_INVISIBILITY), SoundEvents.ENTITY_WANDERING_TRADER_DISAPPEARED, (trader) -> !this.world.isDaytime() && !trader.isInvisible()));
      this.goalSelector.addGoal(0, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_NIGHT_VISION), SoundEvents.ENTITY_WANDERING_TRADER_DISAPPEARED, (trader) -> !this.world.isRaining() && !trader.isInvisible()));
      this.goalSelector.addGoal(0, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_FIRE_RESISTANCE), SoundEvents.ENTITY_WANDERING_TRADER_DISAPPEARED, (trader) -> !this.world.isNightTime() && !trader.isInvisible()));
      this.goalSelector.addGoal(1, new WanderingTraderTradeWithPlayerGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
      this.goalSelector.addGoal(1, new LookAtCustomerGoal1(this));
      this.goalSelector.addGoal(2, new WanderingTraderNirtreEntity.MoveToGoal(this, 2.0D, 0.35D));
      this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
      this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.35D));
      this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
      this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 160.0D).createMutableAttribute(Attributes.MAX_HEALTH, 400.0D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK).createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
   }

   @Nullable
   public AgeableEntity createChild(AgeableEntity ageable) {
      return null;
   }

   public boolean func_213705_dZ() {
      return false;
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
      WanderingTraderNirtreTrades.ITrade[] aWanderingTraderNirtreTrades$itrade = WanderingTraderNirtreTrades.field_221240_b.get(1);
      WanderingTraderNirtreTrades.ITrade[] aWanderingTraderNirtreTrades$itrade1 = WanderingTraderNirtreTrades.field_221240_b.get(2);
      WanderingTraderNirtreTrades.ITrade[] aWanderingTraderNirtreTrades$itrade2 = WanderingTraderNirtreTrades.field_221240_b.get(3);
      if (aWanderingTraderNirtreTrades$itrade != null && aWanderingTraderNirtreTrades$itrade1 != null && aWanderingTraderNirtreTrades$itrade2 !=null) {
         MerchantOffers merchantoffers = this.getOffers();
         this.addWanderingTraderNirtreTrades(merchantoffers, aWanderingTraderNirtreTrades$itrade, 5);
         this.addWanderingTraderNirtreTrades(merchantoffers, aWanderingTraderNirtreTrades$itrade2, 10);
         int i = this.rand.nextInt(aWanderingTraderNirtreTrades$itrade1.length);
         WanderingTraderNirtreTrades.ITrade villagertrades$itrade = aWanderingTraderNirtreTrades$itrade1[i];
         MerchantOffer merchantoffer = villagertrades$itrade.getOffer(this, this.rand);
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

      if (compound.contains("ZombieTraderTarget")) {
         this.wanderTarget = NBTUtil.readBlockPos(compound.getCompound("ZombieTraderTarget"));
      }

      this.setGrowingAge(Math.max(0, this.getGrowingAge()));
   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return false;
   }

   protected void onNirtreTrade(MerchantOffer offer) {
      if (offer.getDoesRewardExp()) {
         int i = 3 + this.rand.nextInt(4);
         this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), i));
      }

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

   protected SoundEvent getVillagerYesNoSound(boolean getYesSound) {
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

   /**
    * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
    * use this to react to sunlight and start to burn.
    */
   public void livingTick() {
      super.livingTick();
      if (!this.world.isRemote) {
         this.handleDespawn();
      }
      this.wingRotation += this.wingRotDelta * 2.0F;
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isWanderingTraderNirtreJockey() && --this.timeUntilNextItem <= 0) {
         this.entityDropItem(ItemInit.FIRK.get());
         this.entityDropItem(ItemInit.Bj_PICKAXE.get());
         this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
      }
   }

   public boolean isWanderingTraderNirtreJockey() {
      return this.wanderingTraderNirtreJockey;
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
}