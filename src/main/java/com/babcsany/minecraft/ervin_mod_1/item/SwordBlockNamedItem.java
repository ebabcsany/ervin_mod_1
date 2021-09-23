package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.block.Block;
import com.babcsany.minecraft.item.ModBlockItem;

public class SwordBlockNamedItem extends ModBlockItem {
   public SwordBlockNamedItem(Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   /**
    * Returns the unlocalized name of this item.
    */
   public String getTranslationKey() {
      return this.getDefaultTranslationKey();
   }
}