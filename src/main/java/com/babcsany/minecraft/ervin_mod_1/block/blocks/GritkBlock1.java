package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import com.babcsany.minecraft.item.ModBlockItemUseContext;
import net.minecraft.state.StateContainer;

public class GritkBlock1 extends HorizontalBlock {
   public GritkBlock1(Properties properties) {
      super(properties);
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(HORIZONTAL_FACING);
   }

   public BlockState getStateForPlacement(ModBlockItemUseContext context) {
      return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
   }
}