package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier1;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TieredTeratItem extends Item {
   private final IItemTier1 tier;

   public TieredTeratItem(IItemTier1 tierIn, Properties builder) {
      super(builder);
      this.tier = tierIn;
   }

   public IItemTier1 getTier() {
      return this.tier;
   }
}