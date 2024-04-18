package com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

public class SurfaceBuilderConfig1 implements ISurfaceBuilderConfig {
   private final BlockState topMaterial;
   private final BlockState underMaterial;
   private final BlockState underWaterMaterial;

   public SurfaceBuilderConfig1(BlockState topMaterial, BlockState underMaterial, BlockState underWaterMaterial) {
      this.topMaterial = topMaterial;
      this.underMaterial = underMaterial;
      this.underWaterMaterial = underWaterMaterial;
   }

   public BlockState getTop() {
      return this.topMaterial;
   }

   public BlockState getUnder() {
      return this.underMaterial;
   }

   public BlockState getUnderWaterMaterial() {
      return this.underWaterMaterial;
   }
}