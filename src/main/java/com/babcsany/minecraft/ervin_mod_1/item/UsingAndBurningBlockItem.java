package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

public class UsingAndBurningBlockItem extends UsingBlockItem {
   private final int burnTime;

   public UsingAndBurningBlockItem(Block blockIn, Properties properties, int useDurationIn, int burnTimeIn) {
      this(blockIn, properties, UseAction.DRINK, useDurationIn, burnTimeIn);
   }

   public UsingAndBurningBlockItem(Block blockIn, Properties properties, UseAction useActionIn, int useDurationIn, int burnTimeIn) {
      super(blockIn, properties, useActionIn, useDurationIn);
      this.burnTime = burnTimeIn;
   }

   @Override
   public int getBurnTime(ItemStack itemStack) {
      return this.burnTime;
   }
}