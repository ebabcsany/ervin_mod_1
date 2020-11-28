package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class FrimLog extends FrimWood {
   private final MaterialColor verticalColor;

   public FrimLog(MaterialColor verticalColorIn, Properties properties) {
      super(properties);
      this.verticalColor = verticalColorIn;
   }

   /* *
    * Get the MapColor for this Block and the given BlockState
    * @deprecated call via {@link IBlockState#getMapColor(IBlockAccess,BlockPos)} whenever possible.
    * Implementing/overriding is fine.
    */
   public MaterialColor getMaterialColor(BlockState state, IBlockReader worldIn, BlockPos pos) {
      return state.get(AXIS) == Direction.Axis.Y ? this.verticalColor : this.materialColor;
   }
}