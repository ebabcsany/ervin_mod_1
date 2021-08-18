package com.babcsany.minecraft.ervin_mod_1.item.tool;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class BurningAxeItem extends AxeItem {
   private final int durationIn;
   public BurningAxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder, int durationIn) {
      super(tier, attackDamageIn, attackSpeedIn, builder);
      this.durationIn = durationIn;
   }

   public int getUseDuration(ItemStack stack) {
      return this.durationIn;
   }
}
