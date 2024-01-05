package com.babcsany.minecraft.ervin_mod_1.item.burning;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Garkth extends Item {
   public Garkth(Properties properties) {
      super(properties);
   }

   public int getBurnTime(ItemStack stack) {
      return (int) 18895680000L;
   }

}