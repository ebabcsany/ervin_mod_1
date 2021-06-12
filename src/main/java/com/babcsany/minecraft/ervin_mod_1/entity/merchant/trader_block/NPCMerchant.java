package com.babcsany.minecraft.ervin_mod_1.entity.merchant.trader_block;

import com.babcsany.minecraft.ervin_mod_1.inventory.merchant.trader_block.TraderBlockInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class NPCMerchant implements IMerchant {
   private final TraderBlockInventory merchantInventory;
   private final PlayerEntity customer;
   private MerchantOffers offers = new MerchantOffers();
   private int xp;

   public NPCMerchant(PlayerEntity player) {
      this.customer = player;
      this.merchantInventory = new TraderBlockInventory(this);
   }

   @Nullable
   public PlayerEntity getCustomer() {
      return this.customer;
   }

   public void setCustomer(@Nullable PlayerEntity player) {
   }

   public MerchantOffers getOffers() {
      return this.offers;
   }

   @OnlyIn(Dist.CLIENT)
   public void setClientSideOffers(@Nullable MerchantOffers offers) {
      this.offers = offers;
   }

   public void onTrade(MerchantOffer offer) {
      offer.increaseUses();
   }

   /**
    * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
    * being played depending if the suggested itemstack is not null.
    */
   public void verifySellingItem(ItemStack stack) {
   }

   public World getWorld() {
      return this.customer.world;
   }

   public int getXp() {
      return this.xp;
   }

   public void setXP(int xpIn) {
      this.xp = xpIn;
   }

   public boolean func_213705_dZ() {
      return true;
   }

   public SoundEvent getYesSound() {
      return SoundEvents.ENTITY_VILLAGER_YES;
   }
}