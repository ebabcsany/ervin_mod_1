package com.babcsany.minecraft.ervin_mod_1.item.burning;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Garkt extends Item {
   public Garkt(Properties properties) {
      super(properties);
   }

   public int getBurnTime(ItemStack stack) {
      return 1180980000;
   }

}