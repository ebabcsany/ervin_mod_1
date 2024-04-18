package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UsingAndBurningItem extends UsingItem {
   private final int burnTime;

   public UsingAndBurningItem(Properties properties, int useDurationIn, int burnTimeIn) {
      super(properties, useDurationIn);
      this.burnTime = useDurationIn;
   }

   @Override
   public int getBurnTime(ItemStack itemStack) {
      return this.burnTime;
   }
}