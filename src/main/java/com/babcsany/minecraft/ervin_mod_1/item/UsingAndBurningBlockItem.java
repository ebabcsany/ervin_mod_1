package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UsingAndBurningBlockItem extends UsingBlockItem {
   private final int burnTime;

   public UsingAndBurningBlockItem(Block blockIn, Properties properties, int useDurationIn, int burnTimeIn) {
      super(blockIn, properties, useDurationIn);
      this.burnTime = burnTimeIn;
   }

   @Override
   public int getBurnTime(ItemStack itemStack) {
      return this.burnTime;
   }
}