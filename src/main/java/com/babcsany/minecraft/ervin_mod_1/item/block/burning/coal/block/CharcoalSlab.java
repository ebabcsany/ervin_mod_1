package com.babcsany.minecraft.ervin_mod_1.item.block.burning.coal.block;

import net.minecraft.block.Block;
import com.babcsany.minecraft.item.ModBlockItem;
import net.minecraft.item.ItemStack;

public class CharcoalSlab extends ModBlockItem {
   public CharcoalSlab(Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   public int getBurnTime(ItemStack stack) {
      return 8000;
   }
}