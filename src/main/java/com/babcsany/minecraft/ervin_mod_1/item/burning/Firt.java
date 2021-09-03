package com.babcsany.minecraft.ervin_mod_1.item.burning;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Firt extends Item {
   public Firt(Properties properties) {
      super(properties);
   }

   public int getBurnTime(ItemStack stack) {
      return 2400;
   }

}