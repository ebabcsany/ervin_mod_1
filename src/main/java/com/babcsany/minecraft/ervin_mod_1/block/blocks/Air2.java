package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.state.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class Air2 extends Block {
   public static final BooleanProperty DEF = ModBlockStateProperties.DEF;

   public Air2(Properties builder) {
      super(builder);
      this.setDefaultState(this.stateContainer.getBaseState().with(DEF, Boolean.FALSE));
   }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      return facing != Direction.UP ? super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos) : stateIn.with(DEF, facingState.isIn(BlockItemInit.DEF_BLOCK.get()));
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      BlockState blockstate = context.getWorld().getBlockState(context.getPos().up());
      return this.getDefaultState().with(DEF, blockstate.isIn(BlockItemInit.DEF_BLOCK.get()));
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(DEF);
   }
}
