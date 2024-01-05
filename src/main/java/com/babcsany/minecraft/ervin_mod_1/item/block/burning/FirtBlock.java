package com.babcsany.minecraft.ervin_mod_1.item.block.burning;

import com.babcsany.minecraft.item.ModBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class FirtBlock extends ModBlockItem {
   public FirtBlock(Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   public FirtBlock(ModBlockItem modBlockItem) {
      super(modBlockItem.getBlock(), new Properties());
   }

   public int getBurnTime(ItemStack stack) {
      return 21600;
   }
}