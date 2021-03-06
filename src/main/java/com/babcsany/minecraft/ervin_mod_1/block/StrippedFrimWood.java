package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;

public class StrippedFrimWood extends Block {
   public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

   public StrippedFrimWood
           (Properties properties) {
      super(properties);
      this.setDefaultState(this.getDefaultState().with(AXIS, Direction.Axis.Y));
   }

   /* *
    * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
    * blockstate.
    * @deprecated call via {@link IBlockState#withRotation(Rotation)} whenever possible. Implementing/overriding is
    * fine.
    */
   public BlockState rotate(BlockState state, Rotation rot) {
      switch(rot) {
      case COUNTERCLOCKWISE_90:
      case CLOCKWISE_90:
         switch((Direction.Axis)state.get(AXIS)) {
         case X:
            return state.with(AXIS, Direction.Axis.Z);
         case Z:
            return state.with(AXIS, Direction.Axis.X);
         default:
            return state;
         }
      default:
         return state;
      }
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(AXIS);
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return this.getDefaultState().with(AXIS, context.getFace().getAxis());
   }
}