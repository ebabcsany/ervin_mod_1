package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier1;
import net.minecraft.item.Item;

public class TieredCraintItem extends Item {
   private final IItemTier1 tier;

   public TieredCraintItem(IItemTier1 tierIn, Properties builder) {
      super(builder);
      this.tier = tierIn;
   }

   public IItemTier1 getTier() {
      return this.tier;
   }
}