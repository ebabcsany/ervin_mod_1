package com.babcsany.minecraft.ervin_mod_1.item.block;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrithBlock extends BlockItem {
   Grith_Block grith_block;
   public GrithBlock(Block blockIn, Properties properties) {
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

   @Override
   public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
      if (entity.getEntityWorld().setBlockState(entity.getPosition(), BlockInit.GRITH_BLOCK.get().getDefaultState()) || entity.getEntityWorld().setBlockState(entity.getPosition(), BlockInit.GRITH_SLAB.get().getDefaultState()) || entity.getEntityWorld().setBlockState(entity.getPosition(), BlockInit.GRITH_STAIRS.get().getDefaultState())) { entity.getEntityWorld().setBlockState(entity.getPosition(), Blocks.AIR.getDefaultState()); }
      grith_block.onEntityItemUpdateDown(stack, entity);
      Grith_Block.onEntityItemUpdateUp(stack, entity);
      Grith_Block.onEntityItemUpdateSide(stack, entity);

      return super.onEntityItemUpdate(stack, entity);
   }
}