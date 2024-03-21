package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UsingAndBurningItem extends Item {
   private final int useDuration;
   private final int burnTime;

   public UsingAndBurningItem(Properties properties, int useDurationIn, int burnTimeIn) {
      super(properties);
      this.useDuration = useDurationIn;
      this.burnTime = burnTimeIn;
   }

   /**
    * How long it takes to use or consume an item
    */
   @Override
   public int getUseDuration(ItemStack stack) {
      return this.useDuration;
   }

   @Override
   public int getBurnTime(ItemStack itemStack) {
      return burnTime;
   }
}