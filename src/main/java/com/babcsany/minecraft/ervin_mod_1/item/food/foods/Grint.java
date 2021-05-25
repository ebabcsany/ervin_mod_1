package com.babcsany.minecraft.ervin_mod_1.item.food.foods;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Grint extends Item {
   public Grint(Properties properties) {
      super(properties);
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getUseDuration(ItemStack stack) {
      return 128;
   }
}