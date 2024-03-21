package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BurningItem extends Item {
   public int durationIn;
   public BurningItem(Properties properties, int burnTimeIn) {
      super(properties);
      this.durationIn = burnTimeIn;
   }

   public int getBurnTime(ItemStack stack) {
      return this.durationIn;
   }

}