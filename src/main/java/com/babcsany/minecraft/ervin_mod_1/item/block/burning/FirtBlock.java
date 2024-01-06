package com.babcsany.minecraft.ervin_mod_1.item.block.burning;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class FirtBlock extends BlockItem {
   public FirtBlock(Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   public FirtBlock(BlockItem modBlockItem) {
      super(modBlockItem.getBlock(), new Properties());
   }

   public int getBurnTime(ItemStack stack) {
      return 21600;
   }
}