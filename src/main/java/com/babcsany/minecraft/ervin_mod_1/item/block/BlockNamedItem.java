package com.babcsany.minecraft.ervin_mod_1.item.block;

import com.babcsany.minecraft.item.ModBlockItem;
import net.minecraft.item.Item;

public class BlockNamedItem extends ModBlockItem {
   public BlockNamedItem(net.minecraft.block.Block blockIn, Properties properties) {
      super(blockIn, properties);
   }

   /**
    * Returns the unlocalized name of this item.
    */
   public String getTranslationKey() {
      return this.getDefaultTranslationKey();
   }

   @Override
   public Item asItem() {
      return super.asItem();
   }
}