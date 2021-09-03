package com.babcsany.minecraft.ervin_mod_1.item.burning.tool.stick;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class FirtHoe extends HoeItem {
   public FirtHoe(IItemTier p_i231595_1_, int p_i231595_2_, float p_i231595_3_, Properties p_i231595_4_) {
      super(p_i231595_1_, p_i231595_2_, p_i231595_3_, p_i231595_4_);
   }

   public int getBurnTime(ItemStack stack) {
      return 5000;
   }
}
