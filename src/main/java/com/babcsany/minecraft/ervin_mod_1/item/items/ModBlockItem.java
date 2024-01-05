package com.babcsany.minecraft.ervin_mod_1.item.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class ModBlockItem extends com.babcsany.minecraft.item.ModBlockItem {
   private final int maxStackSize;
   public ModBlockItem(Block blockIn, Properties properties, int maxStackSize) {
      super(blockIn, properties);
      this.maxStackSize = maxStackSize;
   }

   @Override
   public int getItemStackLimit(ItemStack stack) {
      return this.maxStackSize;
   }
}