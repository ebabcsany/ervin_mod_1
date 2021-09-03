package com.babcsany.minecraft.ervin_mod_1.item.burning;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Tragk extends Item {
   public Tragk(Properties properties) {
      super(properties);
   }

   public int getBurnTime(ItemStack stack) {
      return (int) 1530550080000L;
   }

}