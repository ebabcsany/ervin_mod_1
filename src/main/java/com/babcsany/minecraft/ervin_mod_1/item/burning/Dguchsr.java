package com.babcsany.minecraft.ervin_mod_1.item.burning;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Dguchsr extends Item {
   public Dguchsr(Properties properties) {
      super(properties);
   }

   public int getBurnTime(ItemStack stack) {
      return 3405;
   }

}