package com.babcsany.minecraft.ervin_mod_1.item.block.burning.coal.block;

import net.minecraft.block.Block;
import com.babcsany.minecraft.item.ModBlockItem;
import net.minecraft.item.ItemStack;

public class CoalSlab extends ModBlockItem {
   public CoalSlab(Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   public int getBurnTime(ItemStack stack) {
      return 8000;
   }
}