package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.ZombieTraderLookAtCustomerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.ZombieTraderTradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.ZombieTraderTrades;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ZombieTraderEntity extends AbstractZombieTraderEntity {
   @Nullable
   private BlockPos zombieTraderTarget;
   private int despawnDelay;

   public ZombieTraderEntity(EntityType<? extends ZombieTraderEntity> type, World worldIn) {
      super(type, worldIn);
      this.forceSpawn = true;
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new ZombieTraderTradeWithPlayerGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
      this.goalSelector.addGoal(1, new ZombieTraderLookAtCustomerGoal(this));
      this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
      this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.35D));
      this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
      this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23F).createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.ARMOR, 2).createMutableAttribute(Attributes.ZOMBIE_SPAWN_REINFORCEMENTS);
   }

   @Nullable
   public AgeableEntity createChild(AgeableEntity ageable) {
      return null;
   }

   @Override
   protected void onZombieTraderTrade(MerchantOffer offer) {

   }

   public boolean func_213705_dZ() {
      return false;
   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (itemstack.getItem() != ModSpawnEggItemInit.ZOMBIE_TRADER_SPAWN_EGG.get() && this.isAlive() && !this.hasCustomer() && !this.isChild()) {
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
      ZombieTraderTrades.ITrade[] aZombieTraderTrades$itrade = ZombieTraderTrades.field_221240_b.get(1);
      if (aZombieTraderTrades$itrade != null) {
         MerchantOffers merchantoffers = this.getOffers();
         int i = this.rand.nextInt(aZombieTraderTrades$itrade.length);
         this.addTrades(merchantoffers, aZombieTraderTrades$itrade, 4);
         ZombieTraderTrades.ITrade zombieTraderTrades$itrade = aZombieTraderTrades$itrade[i];
         MerchantOffer merchantoffer = zombieTraderTrades$itrade.getOffer(this, this.rand);
         if (merchantoffer != null) {
            merchantoffers.add(merchantoffer);
         }

      }
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("DespawnDelay", this.despawnDelay);
      if (this.zombieTraderTarget != null) {
         compound.put("ZombieTraderTarget", NBTUtil.writeBlockPos(this.zombieTraderTarget));
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
         this.zombieTraderTarget = NBTUtil.readBlockPos(compound.getCompound("ZombieTraderTarget"));
      }

      this.setGrowingAge(Math.max(0, this.getGrowingAge()));
   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return false;
   }

   protected void onVillagerTrade(MerchantOffer offer) {
      if (offer.getDoesRewardExp()) {
         int i = 3 + this.rand.nextInt(4);
         this.world.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), i));
      }

   }

   /*protected SoundEvent getAmbientSound() {
      return this.hasCustomer() ? SoundEvents.ENTITY_WANDERING_TRADER_TRADE : SoundEvents.ENTITY_WANDERING_TRADER_AMBIENT;
   }*/

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_ZOMBIE_HURT;
   }

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_ZOMBIE_DEATH;
   }

   /*protected SoundEvent getDrinkSound(ItemStack stack) {
      Item item = stack.getItem();
      return item == Items.MILK_BUCKET ? SoundEvents.ENTITY_WANDERING_TRADER_DRINK_MILK : SoundEvents.ENTITY_WANDERING_TRADER_DRINK_POTION;
   }

   protected SoundEvent getVillagerYesNoSound(boolean getYesSound) {
      return getYesSound ? SoundEvents.ENTITY_WANDERING_TRADER_YES : SoundEvents.ENTITY_WANDERING_TRADER_NO;
   }

   public SoundEvent getYesSound() {
      return SoundEvents.ENTITY_WANDERING_TRADER_YES;
   }*/

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

   }

   private void handleDespawn() {
      if (this.despawnDelay > 0 && !this.hasCustomer() && --this.despawnDelay == 0) {
         this.remove();
      }

   }

   public void setWanderTarget(@Nullable BlockPos pos) {
      this.zombieTraderTarget = pos;
   }

   @Nullable
   private BlockPos getWanderTarget() {
      return this.zombieTraderTarget;
   }

}