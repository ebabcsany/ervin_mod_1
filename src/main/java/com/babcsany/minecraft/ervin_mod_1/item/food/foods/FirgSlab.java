package com.babcsany.minecraft.ervin_mod_1.item.food.foods;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FirgSlab extends BlockItem {
   public FirgSlab(Block blockIn, Item.Properties properties) {
      super(blockIn, properties);
   }

   /**
    * How long it takes to use or consume an item
    */
   public int getUseDuration(ItemStack stack) {
      return 16;
   }

   @Override
   public int getBurnTime(ItemStack itemStack) {
      return 5000;
   }
}