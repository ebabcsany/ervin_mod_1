package com.babcsany.minecraft.ervin_mod_1.item.burning.tool.stick;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class FirtSword extends SwordItem {
   public FirtSword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
      super(tier, attackDamageIn, attackSpeedIn, builderIn);
   }

   public int getBurnTime(ItemStack stack) {
      return 4900;
   }
}
