package com.babcsany.minecraft.item;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.math.MathHelper;

public class MerchantOffer {
   /** The first input for this offer. */
   private final ItemStack buyingStackFirst;
   /** The second input for this offer. */
   private final ItemStack buyingStackSecond;
   /** The output of this offer. */
   private final ItemStack sellingStack;
   private boolean doesRewardEXP = true;
   private int specialPrice;
   private float priceMultiplier;
   private int givenEXP = 1;

   public MerchantOffer(CompoundNBT dataTag) {
      this.buyingStackFirst = ItemStack.read(dataTag.getCompound("buy"));
      this.buyingStackSecond = ItemStack.read(dataTag.getCompound("buyB"));
      this.sellingStack = ItemStack.read(dataTag.getCompound("sell"));

      if (dataTag.contains("rewardExp", 1)) {
         this.doesRewardEXP = dataTag.getBoolean("rewardExp");
      }

      if (dataTag.contains("xp", 3)) {
         this.givenEXP = dataTag.getInt("xp");
      }

      if (dataTag.contains("priceMultiplier", 5)) {
         this.priceMultiplier = dataTag.getFloat("priceMultiplier");
      }

      this.specialPrice = dataTag.getInt("specialPrice");
   }

   public MerchantOffer(ItemStack buyingStackFirstIn, ItemStack sellingStackIn, int maxUsesIn, int givenEXPIn, float priceMultiplierIn) {
      this(buyingStackFirstIn, ItemStack.EMPTY, sellingStackIn, maxUsesIn, givenEXPIn, priceMultiplierIn);
   }

   public MerchantOffer(ItemStack buyingStackFirstIn, ItemStack buyingStackSecondIn, ItemStack sellingStackIn, int maxUsesIn, int givenEXPIn, float priceMultiplierIn) {
      this(buyingStackFirstIn, buyingStackSecondIn, sellingStackIn, 0, maxUsesIn, givenEXPIn, priceMultiplierIn);
   }

   public MerchantOffer(ItemStack buyingStackFirstIn, ItemStack buyingStackSecondIn, ItemStack sellingStackIn, int usesIn, int maxUsesIn, int givenEXPIn, float priceMultiplierIn) {
      this(buyingStackFirstIn, buyingStackSecondIn, sellingStackIn, usesIn, maxUsesIn, givenEXPIn, priceMultiplierIn, 0);
   }

   public MerchantOffer(ItemStack buyingStackFirstIn, ItemStack buyingStackSecondIn, ItemStack sellingStackIn, int usesIn, int maxUsesIn, int givenEXPIn, float priceMultiplierIn, int demandIn) {
      this.buyingStackFirst = buyingStackFirstIn;
      this.buyingStackSecond = buyingStackSecondIn;
      this.sellingStack = sellingStackIn;
      this.givenEXP = givenEXPIn;
      this.priceMultiplier = priceMultiplierIn;
   }

   public ItemStack getBuyingStackFirst() {
      return this.buyingStackFirst;
   }

   public ItemStack getBuyingStackSecond() {
      return this.buyingStackSecond;
   }

   public ItemStack getSellingStack() {
      return this.sellingStack;
   }

   public ItemStack getCopyOfSellingStack() {
      return this.sellingStack.copy();
   }

   public void increaseSpecialPrice(int add) {
      this.specialPrice += add;
   }

   public void resetSpecialPrice() {
      this.specialPrice = 0;
   }

   public int getSpecialPrice() {
      return this.specialPrice;
   }

   public void setSpecialPrice(int price) {
      this.specialPrice = price;
   }

   public float getPriceMultiplier() {
      return this.priceMultiplier;
   }

   public int getGivenExp() {
      return this.givenEXP;
   }

   public boolean getDoesRewardExp() {
      return this.doesRewardEXP;
   }

   public CompoundNBT write() {
      CompoundNBT compoundnbt = new CompoundNBT();
      compoundnbt.put("buy", this.buyingStackFirst.write(new CompoundNBT()));
      compoundnbt.put("sell", this.sellingStack.write(new CompoundNBT()));
      compoundnbt.put("buyB", this.buyingStackSecond.write(new CompoundNBT()));
      compoundnbt.putBoolean("rewardExp", this.doesRewardEXP);
      compoundnbt.putInt("xp", this.givenEXP);
      compoundnbt.putFloat("priceMultiplier", this.priceMultiplier);
      compoundnbt.putInt("specialPrice", this.specialPrice);
      return compoundnbt;
   }

   private boolean equalIgnoringDamage(ItemStack left, ItemStack right) {
      if (right.isEmpty() && left.isEmpty()) {
         return true;
      } else {
         ItemStack itemstack = left.copy();
         if (itemstack.getItem().isDamageable()) {
            itemstack.setDamage(itemstack.getDamage());
         }

         return ItemStack.areItemsEqual(itemstack, right) && (!right.hasTag() || itemstack.hasTag() && NBTUtil.areNBTEquals(right.getTag(), itemstack.getTag(), false));
      }
   }
}
