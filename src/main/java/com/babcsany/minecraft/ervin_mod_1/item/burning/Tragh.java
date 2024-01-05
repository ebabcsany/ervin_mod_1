package com.babcsany.minecraft.ervin_mod_1.item.burning;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Tragh extends Item {
   public Tragh(Properties properties) {
      super(properties);
   }

   public int getBurnTime(ItemStack stack) {
      return (int) 170061120000L;
   }

}