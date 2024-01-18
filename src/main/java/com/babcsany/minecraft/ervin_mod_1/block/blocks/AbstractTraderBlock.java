package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.entity.merchant.trader_block.IMerchant;
import com.babcsany.minecraft.ervin_mod_1.entity.trigger.CriteriaTriggers1;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class AbstractTraderBlock extends Block implements INPC, IMerchant {
   @Nullable
   private PlayerEntity customer;
   public int livingSoundTime;
   private Vector3d positionVec;
   public World world;
   @Nullable
   protected MerchantOffers offers;
   private final Inventory traderBlockInventory = new Inventory(8);

   public AbstractTraderBlock(Properties properties) { super(properties); }

   public int getXp() {
      return 0;
   }

   public void setCustomer(@Nullable PlayerEntity player) {
      this.customer = player;
   }

   @Nullable
   public PlayerEntity getCustomer() {
      return this.customer;
   }

   public boolean hasCustomer() {
      return this.customer != null;
   }

   /*public MerchantOffers getOffers() {
      if (this.offers == null) {
         this.offers = new MerchantOffers();
         this.populateTradeData();
      }

      return this.offers;
   }*/

   @OnlyIn(Dist.CLIENT)
   public void setClientSideOffers(@Nullable MerchantOffers offers) {
   }

   public void setXP(int xpIn) {
   }

   public World getWorld() {
      return this.world;
   }

   protected abstract void onTraderBlockTrade(MerchantOffer offer);

   public boolean func_213705_dZ() {
      return true;
   }

   /**
    * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
    * being played depending if the suggested itemstack is not null.
    */
   public void verifySellingItem(ItemStack stack) {
      if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
         this.livingSoundTime = -this.getTalkInterval();
         //this.playSound(this.get$TraderYesNoSound(!stack.isEmpty()), this.getSoundVolume(), this.getSoundPitch());
      }

   }

   public int getTalkInterval() {
      return 80;
   }
/*
   public SoundEvent getYesSound() {
      return SoundEvents.AMBIENT_CAVE;
   }

   protected SoundEvent get$TraderYesNoSound(boolean getYesSound) {
      return getYesSound ? SoundEvents.AMBIENT_CAVE : SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS;
   }*/

   /*public void playCelebrateSound() {
      this.playSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP, this.getSoundVolume(), this.getSoundPitch());
   }*/

   public void writeAdditional(CompoundNBT compound) {
      MerchantOffers merchantoffers = this.getOffers();
      if (!merchantoffers.isEmpty()) {
         compound.put("Offers", merchantoffers.write());
      }

      compound.put("Inventory", this.traderBlockInventory.write());
   }

   /**
    * (abstract) Protected helper method to read subclass entity data from NBT.
    */
   public void readAdditional(CompoundNBT compound) {
      if (compound.contains("Offers", 10)) {
         this.offers = new MerchantOffers(compound.getCompound("Offers"));
      }

      this.traderBlockInventory.read(compound.getList("Inventory", 10));
   }

   /*@Nullable
   public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
      this.resetCustomer();
      return super.changeDimension(server, teleporter);
   }*/

   protected void resetCustomer() {
      this.setCustomer(null);
   }

   /**
    * Called when the mob's health reaches 0.
    */
   public void onDeath(DamageSource cause) {
      this.resetCustomer();
   }

   @OnlyIn(Dist.CLIENT)
   protected void spawnParticles(IParticleData particleData) {
      final Random rand = new Random();
      for(int i = 0; i < 5; ++i) {
         double d0 = rand.nextGaussian() * 0.02D;
         double d1 = rand.nextGaussian() * 0.02D;
         double d2 = rand.nextGaussian() * 0.02D;
         //this.world.addParticle(particleData, this.getPosXRandom(1.0D), this.getPosYRandom() + 1.0D, this.getPosZRandom(1.0D), d0, d1, d2);
      }

   }

   /*public final float getWidth() {
      return this.size.width;
   }

   public final float getHeight() {
      return this.size.height;
   }

   public double getPosXWidth(double p_226275_1_) {
      return this.positionVec.x + (double)this.getWidth() * p_226275_1_;
   }

   public double getPosXRandom(double p_226282_1_) {
      final Random rand = new Random();
      return this.getPosXWidth((2.0D * rand.nextDouble() - 1.0D) * p_226282_1_);
   }

   public double getPosYHeight(double p_226283_1_) {
      return this.positionVec.y + (double)this.getHeight() * p_226283_1_;
   }

   public double getPosYRandom() {
      final Random rand = new Random();
      return this.getPosYHeight(rand.nextDouble());
   }

   public double getPosZWidth(double p_226285_1_) {
      return this.positionVec.z + (double)this.getWidth() * p_226285_1_;
   }

   public double getPosZRandom(double p_226287_1_) {
      final Random rand = new Random();
      return this.getPosZWidth((2.0D * rand.nextDouble() - 1.0D) * p_226287_1_);
   }*/

   /*public boolean canBeLeashedTo(PlayerEntity player) {
      return false;
   }

   public Inventory getTraderBlockInventory() {
      return this.traderBlockInventory;
   }

   protected abstract void populateTradeData();

   /**
    * add limites numbers of trades to the given MerchantOffers
    * /
   protected void addTrades(MerchantOffers givenMerchantOffers, TraderBlockTrades.ITrade[] newTrades, int maxNumbers) {
      Set<Integer> set = Sets.newHashSet();
      final Random rand = new Random();
      if (newTrades.length > maxNumbers) {
         while(set.size() < maxNumbers) {
            set.add(rand.nextInt(newTrades.length));
         }
      } else {
         for(int i = 0; i < newTrades.length; ++i) {
            set.add(i);
         }
      }

      for(Integer integer : set) {
         TraderBlockTrades.ITrade traderBlockTrades$itrade = newTrades[integer];
         MerchantOffer merchantoffer = traderBlockTrades$itrade.getOffer(this, rand);
         if (merchantoffer != null) {
            givenMerchantOffers.add(merchantoffer);
         }
      }

   }*/
}