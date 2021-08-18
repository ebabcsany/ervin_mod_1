package com.babcsany.minecraft.ervin_mod_1.item.tool;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;

public class BurningShovelItem extends ShovelItem {
   private final int durationIn;
   public BurningShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder, int durationIn) {
      super(tier, attackDamageIn, attackSpeedIn, builder);
      this.durationIn = durationIn;
   }

   public int getUseDuration(ItemStack stack) {
      return this.durationIn;
   }
}
