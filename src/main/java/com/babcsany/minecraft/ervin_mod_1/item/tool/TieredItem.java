package com.babcsany.minecraft.ervin_mod_1.item.tool;

import net.minecraft.item.Item;

public class TieredItem extends Item {
   private final IItemTier2 tier;

   public TieredItem(IItemTier2 tierIn, Item.Properties builder) {
      super(builder.defaultMaxDamage((int) tierIn.getAttackDamage()));
      this.tier = tierIn;
   }

   public IItemTier2 getTier() {
      return this.tier;
   }
}