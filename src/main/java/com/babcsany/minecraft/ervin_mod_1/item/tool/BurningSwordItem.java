package com.babcsany.minecraft.ervin_mod_1.item.tool;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class BurningSwordItem extends SwordItem {
   private final int durationIn;
   public BurningSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn, int durationIn) {
      super(tier, attackDamageIn, attackSpeedIn, builderIn);
      this.durationIn = durationIn;
   }

   public int getUseDuration(ItemStack stack) {
      return this.durationIn;
   }
}
