package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Nirtkb extends FallingBlock {
   private final int dustColor;

   public Nirtkb(int dustColorIn, Properties properties) {
      super(properties);
      this.dustColor = dustColorIn;
   }

   @OnlyIn(Dist.CLIENT)
   public int getDustColor(BlockState state) {
      return this.dustColor;
   }
}