package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockWithDustColor extends Block {
   private final int dustColor;

   public BlockWithDustColor(int dustColorIn, Properties properties) {
      super(properties);
      this.dustColor = dustColorIn;
   }

   @OnlyIn(Dist.CLIENT)
   public int getDustColor(BlockState state, IBlockReader reader, BlockPos pos) {
      return this.dustColor;
   }
}