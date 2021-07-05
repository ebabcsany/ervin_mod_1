package com.babcsany.minecraft.ervin_mod_1.item.food.foods;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class GrintBlock extends BlockItem {
   public GrintBlock(Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getUseDuration(ItemStack stack) {
      return 512;
   }

   @Override
   public int getBurnTime(ItemStack itemStack) {
      return 160000;
   }
}