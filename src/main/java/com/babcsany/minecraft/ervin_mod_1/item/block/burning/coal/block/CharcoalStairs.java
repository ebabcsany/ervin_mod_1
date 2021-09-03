package com.babcsany.minecraft.ervin_mod_1.item.block.burning.coal.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class CharcoalStairs extends BlockItem {
   public CharcoalStairs(Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   public int getBurnTime(ItemStack stack) {
      return 12000;
   }
}