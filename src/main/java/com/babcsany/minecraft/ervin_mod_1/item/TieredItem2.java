package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier1;
import com.babcsany.minecraft.ervin_mod_1.item.tool.IItemTier2;
import net.minecraft.item.Item;

public class TieredItem2 extends Item {
   private final IItemTier2 tier;

   public TieredItem2(IItemTier2 tierIn, Properties builder) {
      super(builder);
      this.tier = tierIn;
   }

   public IItemTier2 getTier() {
      return this.tier;
   }
}