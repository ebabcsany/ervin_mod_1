package com.babcsany.minecraft.item;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.PacketBuffer;

import java.util.ArrayList;

public class MerchantOffers extends ArrayList<MerchantOffer> {
   public MerchantOffers() {
   }

   public MerchantOffers(CompoundNBT p_i50011_1_) {
      ListNBT listnbt = p_i50011_1_.getList("Recipes", 10);

      for(int i = 0; i < listnbt.size(); ++i) {
         this.add(new MerchantOffer(listnbt.getCompound(i)));
      }

   }

   public void write(PacketBuffer p_222196_1_) {
      p_222196_1_.writeByte((byte)(this.size() & 255));

      for (MerchantOffer merchantoffer : this) {
         p_222196_1_.writeItemStack(merchantoffer.getBuyingStackFirst());
         p_222196_1_.writeItemStack(merchantoffer.getSellingStack());
         ItemStack itemstack = merchantoffer.getBuyingStackSecond();
         p_222196_1_.writeBoolean(!itemstack.isEmpty());
         if (!itemstack.isEmpty()) {
            p_222196_1_.writeItemStack(itemstack);
         }

         p_222196_1_.writeInt(merchantoffer.getGivenExp());
         p_222196_1_.writeInt(merchantoffer.getSpecialPrice());
         p_222196_1_.writeFloat(merchantoffer.getPriceMultiplier());
      }

   }

   public static MerchantOffers read(PacketBuffer p_222198_0_) {
      MerchantOffers merchantoffers = new MerchantOffers();
      int i = p_222198_0_.readByte() & 255;

      for(int j = 0; j < i; ++j) {
         ItemStack itemstack = p_222198_0_.readItemStack();
         ItemStack itemstack1 = p_222198_0_.readItemStack();
         ItemStack itemstack2 = ItemStack.EMPTY;
         if (p_222198_0_.readBoolean()) {
            itemstack2 = p_222198_0_.readItemStack();
         }

         int k = p_222198_0_.readInt();
         int l = p_222198_0_.readInt();
         int i1 = p_222198_0_.readInt();
         int j1 = p_222198_0_.readInt();
         float f = p_222198_0_.readFloat();
         int k1 = p_222198_0_.readInt();
         MerchantOffer merchantoffer = new MerchantOffer(itemstack, itemstack2, itemstack1, k, l, i1, f, k1);

         merchantoffer.setSpecialPrice(j1);
         merchantoffers.add(merchantoffer);
      }

      return merchantoffers;
   }

   public CompoundNBT write() {
      CompoundNBT compoundnbt = new CompoundNBT();
      ListNBT listnbt = new ListNBT();

      for(int i = 0; i < this.size(); ++i) {
         MerchantOffer merchantoffer = this.get(i);
         listnbt.add(merchantoffer.write());
      }

      compoundnbt.put("Recipes", listnbt);
      return compoundnbt;
   }
}
