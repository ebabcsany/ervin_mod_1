package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GravelBlock extends FallingBlock {
   public GravelBlock(Properties properties) {
      super(properties);
   }

   @OnlyIn(Dist.CLIENT)
   public int getDustColor(BlockState state) {
      return -8356741;
   }
}