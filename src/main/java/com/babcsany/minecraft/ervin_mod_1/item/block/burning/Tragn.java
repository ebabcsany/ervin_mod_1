package com.babcsany.minecraft.ervin_mod_1.item.block.burning;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class Tragn extends BlockItem {
   public Tragn(Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   public int getBurnTime(ItemStack stack) {
      return (int) 15305500800000000L;
   }
}