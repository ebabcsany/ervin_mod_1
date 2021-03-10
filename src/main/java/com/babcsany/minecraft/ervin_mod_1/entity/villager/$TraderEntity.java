package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.$TraderLookAtCustomerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.$TraderTradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.$TraderTrades;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class $TraderEntity extends Abstract$TraderEntity {
   @Nullable
   private BlockPos $traderTarget;
   private int despawnDelay;

   public $TraderEntity(EntityType<? extends $TraderEntity> type, World worldIn) {
      super(type, worldIn);
      this.forceSpawn = true;
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new $TraderTradeWithPlayerGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
      this.goalSelector.addGoal(1, new $TraderLookAtCustomerGoal(this));
      this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.35D));
      this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
      this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D).createMutableAttribute(Attributes.MAX_HEALTH, 16.0D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK).createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D);
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
      if (itemstack.getItem() != ItemInit.ZUR_ENTITY_SPAWN_EGG.get() && this.isAlive() && !this.hasCustomer() && !this.isChild()) {
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
      $TraderTrades.ITrade[] a$tradertrades$itrade = $TraderTrades.field_221240_b.get(1);
      if (a$tradertrades$itrade != null) {
         MerchantOffers merchantoffers = this.getOffers();
         this.addTrades(merchantoffers, a$tradertrades$itrade, 10);
         int i = this.rand.nextInt(a$tradertrades$itrade.length);
         $TraderTrades.ITrade $tradertrades$itrade = a$tradertrades$itrade[i];
         MerchantOffer merchantoffer = $tradertrades$itrade.getOffer(this, this.rand);
         if (merchantoffer != null) {
            merchantoffers.add(merchantoffer);
         }

      }
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("DespawnDelay", this.despawnDelay);
      if (this.$traderTarget != null) {
         compound.put("$traderTarget", NBTUtil.writeBlockPos(this.$traderTarget));
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

      if (compound.contains("$traderTarget")) {
         this.$traderTarget = NBTUtil.readBlockPos(compound.getCompound("$traderTarget"));
      }

      this.setGrowingAge(Math.max(0, this.getGrowingAge()));
   }

   public boolean canDespawn(double distanceToClosestPlayer) {
      return false;
   }

   protected void on$TraderTrade(MerchantOffer offer) {
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

   protected SoundEvent get$TraderYesNoSound(boolean getYesSound) {
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

   }

   public $TraderEntity createChild(Abstract$TraderEntity ageable) {
      return EntityInit.$_TRADER_ENTITY.get().create(this.world);
   }

   private void handleDespawn() {
      if (this.despawnDelay > 0 && !this.hasCustomer() && --this.despawnDelay == 0) {
         this.remove();
      }

   }

   public void set$traderTarget(@Nullable BlockPos pos) {
      this.$traderTarget = pos;
   }

   @Nullable
   private BlockPos set$traderTarget() {
      return this.$traderTarget;
   }

}