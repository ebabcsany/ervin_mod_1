package com.babcsany.minecraft.ervin_mod_1.item.block;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class GrithBlock extends Grith_Block {
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
      update(entity, entity.getPosition(), entity.getPosition(), BlockInit.GRITH_BLOCK.get().getDefaultState(), Blocks.AIR.getDefaultState());
      update(entity, entity.getPosition(), entity.getPosition(), BlockInit.GRITH_SLAB.get().getDefaultState(), Blocks.AIR.getDefaultState());
      update(entity, entity.getPosition(), entity.getPosition(), BlockInit.GRITH_STAIRS.get().getDefaultState(), Blocks.AIR.getDefaultState());
      onEntityItemUpdateDown(stack, entity);
      onEntityItemUpdateUp(stack, entity);
      onEntityItemUpdateSide(stack, entity);

      return super.onEntityItemUpdate(stack, entity);
   }

   public static void update(ItemEntity entity, BlockPos pos, BlockPos pos1, BlockState state, BlockState state1) {
      if (entity.getEntityWorld().setBlockState(pos, state)) { entity.getEntityWorld().setBlockState(pos1, state1); }
   }
}