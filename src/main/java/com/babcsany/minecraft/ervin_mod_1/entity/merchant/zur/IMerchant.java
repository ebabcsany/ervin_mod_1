package com.babcsany.minecraft.ervin_mod_1.entity.merchant.zur;

import com.babcsany.minecraft.ervin_mod_1.container.merchant.ZurContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.MerchantContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.OptionalInt;

public interface IMerchant {
   void setCustomer(@Nullable PlayerEntity player);

   @Nullable
   PlayerEntity getCustomer();

   MerchantOffers getOffers();

   @OnlyIn(Dist.CLIENT)
   void setClientSideOffers(@Nullable MerchantOffers offers);

   void onTrade(MerchantOffer offer);

   /**
    * Notifies the merchant of a possible merchantrecipe being fulfilled or not. Usually, this is just a sound byte
    * being played depending if the suggested itemstack is not null.
    */
   void verifySellingItem(ItemStack stack);

   World getWorld();

   int getXp();

   void setXP(int xpIn);

   boolean func_213705_dZ();

   SoundEvent getYesSound();

   default boolean func_223340_ej() {
      return false;
   }

   default void openMerchantContainer(PlayerEntity player, ITextComponent displayName, int level) {
      OptionalInt optionalint = player.openContainer(new SimpleNamedContainerProvider((p_213701_1_, p_213701_2_, p_213701_3_) -> {
         return new ZurContainer(p_213701_1_, p_213701_2_, this);
      }, displayName));
      if (optionalint.isPresent()) {
         MerchantOffers merchantoffers = this.getOffers();
         if (!merchantoffers.isEmpty()) {
            player.openMerchantContainer(optionalint.getAsInt(), merchantoffers, level, this.getXp(), this.func_213705_dZ(), this.func_223340_ej());
         }
      }

   }
}