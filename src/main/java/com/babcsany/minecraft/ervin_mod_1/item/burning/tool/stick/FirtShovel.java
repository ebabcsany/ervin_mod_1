package com.babcsany.minecraft.ervin_mod_1.item.burning.tool.stick;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;

public class FirtShovel extends ShovelItem {
   public FirtShovel(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
      super(tier, attackDamageIn, attackSpeedIn, builder);
   }

   public int getBurnTime(ItemStack stack) {
      return 2600;
   }
}