package com.babcsany.minecraft.ervin_mod_1.item.burning;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Tragt extends Item {
   public Tragt(Properties properties) {
      super(properties);
   }

   public int getBurnTime(ItemStack stack) {
      return (int) 612220032000000L;
   }

}