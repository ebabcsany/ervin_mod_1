package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class BurningBlockItem extends BlockItem {
   public final int durationIn;
   public BurningBlockItem(Block blockIn, Properties properties, int durationIn) {
      super(blockIn, properties);
      this.durationIn = durationIn;
   }

   /*public int getUseDuration(ItemStack stack) {
      return this.durationIn;
   }*/
}