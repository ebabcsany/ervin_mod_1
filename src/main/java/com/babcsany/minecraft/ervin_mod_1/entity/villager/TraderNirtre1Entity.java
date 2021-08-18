package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.TraderNirtre1LookAtCustomerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.TraderNirtre1TradeWithPlayerGoal;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.trades.TraderNirtreTrades;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialItemInit;
import com.babcsany.minecraft.init.EntityInit;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TraderNirtre1Entity extends AbstractTraderNirtre1Entity {
   @Nullable
   private BlockPos traderNirtreTarget;
   public int timeUntilNextItem = this.rand.nextInt(12000) + 12000;
   private int despawnDelay;
   public float wingRotation;
   public float wingRotDelta = 1.0F;
   public boolean dropItem;
   private int xp;

   public TraderNirtre1Entity(EntityType<? extends TraderNirtre1Entity> type, World worldIn) {
      super(type, worldIn);
      this.forceSpawn = true;
   }

   protected void registerGoals() {
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(-1, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_INVISIBILITY), SoundEvents.ENTITY_WANDERING_TRADER_DISAPPEARED, (trader) -> !this.world.isDaytime() && !trader.isInvisible()));
      this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.ENTITY_WANDERING_TRADER_REAPPEARED, (trader) -> this.world.isDaytime() && trader.isInvisible()));
      this.goalSelector.addGoal(-1, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_NIGHT_VISION), SoundEvents.ENTITY_WANDERING_TRADER_DISAPPEARED, (trader) -> !this.world.isRaining() && !trader.isInvisible()));
      this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.ENTITY_WANDERING_TRADER_REAPPEARED, (trader) -> this.world.isRaining() && trader.isInvisible()));
      this.goalSelector.addGoal(-1, new UseItemGoal<>(this, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.LONG_FIRE_RESISTANCE), SoundEvents.ENTITY_WANDERING_TRADER_DISAPPEARED, (trader) -> !this.world.isNightTime() && !trader.isInvisible()));
      this.goalSelector.addGoal(0, new UseItemGoal<>(this, new ItemStack(Items.MILK_BUCKET), SoundEvents.ENTITY_WANDERING_TRADER_REAPPEARED, (trader) -> this.world.isNightTime() && trader.isInvisible()));
      this.goalSelector.addGoal(1, new TraderNirtre1TradeWithPlayerGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 0.5D));
      this.goalSelector.addGoal(1, new TraderNirtre1LookAtCustomerGoal(this));
      this.goalSelector.addGoal(4, new MoveTowardsRestrictionGoal(this, 0.35D));
      this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 0.35D));
      this.goalSelector.addGoal(9, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 3.0F, 1.0F));
      this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
      this.goalSelector.addGoal(10, new LookAtGoal(this, MobEntity.class, 8.0F));
   }

   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 1600.0D).createMutableAttribute(Attributes.MAX_HEALTH, 400.0D).createMutableAttribute(Attributes.ATTACK_KNOCKBACK).createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D);
   }

   @Nullable
   public AgeableEntity createChild(AgeableEntity ageable) {
      return null;
   }

   @Override
   public void onTrade(MerchantOffer offer) {
   }

   @Override
   protected void onTraderNirtre1Trade(MerchantOffer offer) {

   }

   public boolean func_213705_dZ() {
      return false;
   }

   public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
      ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
      if (itemstack.getItem() != ModSpawnEggItemInit.TRADER_NIRTRE_SPAWN_EGG.get() && this.isAlive() && !this.hasCustomer() && !this.isChild()) {
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
      TraderNirtreTrades.ITrade[] aTraderNirtreTrades$iTrade = TraderNirtreTrades.field_221240_b.get(1);
      if (aTraderNirtreTrades$iTrade != null) {
         MerchantOffers merchantoffers = this.getOffers();
         this.addTrades(merchantoffers, aTraderNirtreTrades$iTrade, 5);
         int i = this.rand.nextInt(aTraderNirtreTrades$iTrade.length);
         TraderNirtreTrades.ITrade traderNirtreTrades$iTrade = aTraderNirtreTrades$iTrade[i];
         MerchantOffer merchantoffer = traderNirtreTrades$iTrade.getOffer(this, this.rand);
         if (merchantoffer != null) {
            merchantoffers.add(merchantoffer);
         }

      }
   }

   public void setOffers(MerchantOffers offersIn) {
      this.offers = offersIn;
   }

   public void setXp(int xpIn) {
      this.xp = xpIn;
   }

   public void writeAdditional(CompoundNBT compound) {
      super.writeAdditional(compound);
      compound.putInt("DespawnDelay", this.despawnDelay);
      if (this.traderNirtreTarget != null) {
         compound.put("TraderNirtreTarget", NBTUtil.writeBlockPos(this.traderNirtreTarget));
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

      if (compound.contains("TraderNirtreTarget")) {
         this.traderNirtreTarget = NBTUtil.readBlockPos(compound.getCompound("TraderNirtreTarget"));
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
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_WANDERING_TRADER_HURT;
   }*/

   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_WANDERING_TRADER_DEATH;
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
      this.wingRotation += this.wingRotDelta * 2.0F;
      if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isDropItem() && --this.timeUntilNextItem <= 0) {
         this.entityDropItem(SpecialItemInit.TFJHU_1.get());
         this.timeUntilNextItem = this.rand.nextInt(12000) + 12000;
      }
   }

   public boolean isDropItem() {
      return this.dropItem;
   }

   public void onStruckByLightning_(LightningBoltEntity lightningBolt) {
      if (this.world.getDifficulty() != Difficulty.PEACEFUL) {
         LOGGER.info("Trader Nirtre {} was struck by lightning {}.", this, lightningBolt);
         ZurEntity zurEntity = EntityInit.ZUR_ENTITY.create(this.world);
         zurEntity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, this.rotationPitch);
         zurEntity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(zurEntity.getPosition()), SpawnReason.CONVERSION, null, null);
         zurEntity.setNoAI(this.isAIDisabled());
         if (this.hasCustomName()) {
            zurEntity.setCustomName(this.getCustomName());
            zurEntity.setCustomNameVisible(this.isCustomNameVisible());
         }

         zurEntity.enablePersistence();
         this.world.addEntity(zurEntity);
         this.remove();
      } else {
         super.onStruckByLightning(lightningBolt);
      }

   }

   public void setWanderTarget(@Nullable BlockPos pos) {
      this.traderNirtreTarget = pos;
   }

   @Nullable
   private BlockPos getWanderTarget() {
      return this.traderNirtreTarget;
   }

}