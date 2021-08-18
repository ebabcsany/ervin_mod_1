package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BurningItem extends Item {
   public int durationIn;
   public BurningItem(Properties properties, int durationIn) {
      super(properties);
      this.durationIn = durationIn;
   }

   public int getUseDuration(ItemStack stack) {
      return this.durationIn;
   }

}