package com.babcsany.minecraft.ervin_mod_1.item.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TieredItem2 extends Item {
   private final IItemTier2 tier;

   public TieredItem2(IItemTier2 tierIn, Properties builder) {
      super(builder);
      this.tier = tierIn;
   }

   public boolean isEnchantable(ItemStack p_77616_1_) {
      return this.getItemStackLimit(p_77616_1_) == 2048 && this.isDamageable();
   }

   public IItemTier2 getTier() {
      return this.tier;
   }
}