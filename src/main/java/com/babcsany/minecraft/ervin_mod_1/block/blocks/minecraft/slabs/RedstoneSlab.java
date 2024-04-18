package com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.slabs;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class RedstoneSlab extends SlabBlock {
   public RedstoneSlab(Properties properties) {
      super(properties);
   }

   /**
    * Can this block provide power. Only wire currently seems to have this change based on its state.
    * @deprecated call via {@link BlockState#canProvidePower()} whenever possible. Implementing/overriding is fine.
    */
   public boolean canProvidePower(BlockState state) {
      return true;
   }

   /**
    * @deprecated call via {@link BlockState#getWeakPower(IBlockReader, BlockPos, Direction)} whenever possible.
    * Implementing/overriding is fine.
    */
   public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
      return 7;
   }
}