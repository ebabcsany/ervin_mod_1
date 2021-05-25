package com.babcsany.minecraft.ervin_mod_1.item.food.foods;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Durg extends Item {
   public Durg(Properties properties) {
      super(properties);
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getUseDuration(ItemStack stack) {
      return 2048;
   }
}