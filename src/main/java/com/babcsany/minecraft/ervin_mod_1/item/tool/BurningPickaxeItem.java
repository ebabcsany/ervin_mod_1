package com.babcsany.minecraft.ervin_mod_1.item.tool;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;

public class BurningPickaxeItem extends PickaxeItem {
   private final int durationIn;
   public BurningPickaxeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder, int durationIn) {
      super(tier, attackDamageIn, attackSpeedIn, builder);
      this.durationIn = durationIn;
   }

   public int getUseDuration(ItemStack stack) {
      return this.durationIn;
   }
}
