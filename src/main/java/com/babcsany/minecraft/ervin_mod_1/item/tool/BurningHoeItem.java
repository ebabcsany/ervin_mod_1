package com.babcsany.minecraft.ervin_mod_1.item.tool;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class BurningHoeItem extends HoeItem {
   private final int durationIn;
   public BurningHoeItem(IItemTier p_i231595_1_, int p_i231595_2_, float p_i231595_3_, Properties p_i231595_4_, int durationIn) {
      super(p_i231595_1_, p_i231595_2_, p_i231595_3_, p_i231595_4_);
      this.durationIn = durationIn;
   }

   public int getUseDuration(ItemStack stack) {
      return this.durationIn;
   }
}
