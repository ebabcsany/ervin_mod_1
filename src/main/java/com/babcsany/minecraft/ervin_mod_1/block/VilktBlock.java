package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class VilktBlock extends HorizontalBlock {
   public VilktBlock(Properties properties) {
      super(properties);
   }

   protected int getExperience(Random rand) {
      if (this == BlockItemInit.SRIUNK_ORE.get()) {
         return MathHelper.nextInt(rand, 1, 5);
      /*} else if (this == Blocks.DIAMOND_ORE) {
         return MathHelper.nextInt(rand, 3, 7);
      } else if (this == BlockInit.SRIUNK_ORE.get()) {
         return MathHelper.nextInt(rand, 4, 9);*/
      } else if (this == BlockItemInit.RUBY_ORE.get()) {
         return MathHelper.nextInt(rand, 3, 7);
      /*} else if (this == Blocks.LAPIS_ORE) {
         return MathHelper.nextInt(rand, 2, 5);
      } else if (this == Blocks.NETHER_QUARTZ_ORE) {
         return MathHelper.nextInt(rand, 2, 5);*/
      } else {
         return this == BlockItemInit.VILKT_BLOCK.get() ? MathHelper.nextInt(rand, 0, 10) : 0;
      }
   }

   /**
    * Perform side-effects from block dropping, such as creating silverfish
    */
   public void spawnAdditionalDrops(BlockState state, World worldIn, BlockPos pos, ItemStack stack) {
      super.spawnAdditionalDrops(state, worldIn, pos, stack);
   }

   @Override
   public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
      return silktouch == 0 ? this.getExperience(RANDOM) : 0;
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(HORIZONTAL_FACING);
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
   }
}