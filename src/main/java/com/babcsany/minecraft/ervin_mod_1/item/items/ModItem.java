package com.babcsany.minecraft.ervin_mod_1.item.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItem extends Item {
   private final int maxStackSize;
   public ModItem(Properties properties, int maxStackSize) {
      super(properties);
      this.maxStackSize = maxStackSize;
   }

   @Override
   public int getItemStackLimit(ItemStack stack) {
      return this.maxStackSize;
   }
}