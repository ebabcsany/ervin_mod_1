package com.babcsany.minecraft.ervin_mod_1.item.block.burning;

import net.minecraft.block.Block;
import com.babcsany.minecraft.item.ModBlockItem;
import net.minecraft.item.ItemStack;

public class TragkBlock extends ModBlockItem {
   public TragkBlock(Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   public int getBurnTime(ItemStack stack) {
      return (int) 24488801280000L;
   }
}