package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class ColoredRotatedPillarBlock extends RotatedPillarBlock {
   private final MaterialColor verticalColor;
   private final MaterialColor materialColor;

   public ColoredRotatedPillarBlock(MaterialColor colorIn, Properties properties) {
      super(properties);
      this.verticalColor = colorIn;
      this.materialColor = colorIn;
   }

   public ColoredRotatedPillarBlock(MaterialColor verticalColorIn, MaterialColor materialColorIn, Properties properties) {
      super(properties);
      this.verticalColor = verticalColorIn;
      this.materialColor = materialColorIn;
   }

   /**
    * Get the MapColor for this Block and the given BlockState
    * @deprecated call via {@link BlockState#getMaterialColor(IBlockReader, BlockPos)} whenever possible.
    * Implementing/overriding is fine.
    */
   public MaterialColor getMaterialColor(BlockState state, IBlockReader worldIn, BlockPos pos) {
      return state.get(AXIS) == Direction.Axis.Y ? this.verticalColor : this.materialColor;
   }
}