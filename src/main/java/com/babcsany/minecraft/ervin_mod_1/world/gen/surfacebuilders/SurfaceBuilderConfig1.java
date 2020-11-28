package com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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

   public static SurfaceBuilderConfig1 deserialize(Dynamic<?> p_215455_0_) {
      BlockState blockstate = p_215455_0_.get("top_material").map(BlockState::deserialize).orElse(BlockInit.AIR.get().getDefaultState());
      BlockState blockstate1 = p_215455_0_.get("under_material").map(BlockState::deserialize).orElse(BlockInit.AIR.get().getDefaultState());
      BlockState blockstate2 = p_215455_0_.get("underwater_material").map(BlockState::deserialize).orElse(BlockInit.AIR.get().getDefaultState());
      return new SurfaceBuilderConfig1(blockstate, blockstate1, blockstate2);
   }
}