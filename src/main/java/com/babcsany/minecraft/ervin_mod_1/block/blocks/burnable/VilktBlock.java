package com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import net.minecraft.block.*;
import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class VilktBlock extends HorizontalBlock {
   public VilktBlock(AbstractBlock.Properties properties) {
      super(properties);
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(HORIZONTAL_FACING);
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
   }

   /**
    * @deprecated call via {@link BlockState#getProperties()} whenever possible. Implementing/overriding is fine.
    */
   @Override
   public PushReaction getPushReaction(BlockState state) {
      return PushReaction.PUSH_ONLY;
   }

}