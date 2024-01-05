package com.babcsany.minecraft.ervin_mod_1.item.burning.tool.stick;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class FirtAxe extends AxeItem {
   public FirtAxe(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
      super(tier, attackDamageIn, attackSpeedIn, builder);
   }

   public int getBurnTime(ItemStack stack) {
      return 7400;
   }
}
