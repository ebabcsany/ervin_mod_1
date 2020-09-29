package com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

public class SurfaceBuilderConfig1 implements ISurfaceBuilderConfig {
   public static final Codec<SurfaceBuilderConfig1> field_237203_a_ = RecordCodecBuilder.create((p_237204_0_) -> {
      return p_237204_0_.group(BlockState.BLOCKSTATE_CODEC.fieldOf("top_material").forGetter((p_237207_0_) -> {
         return p_237207_0_.topMaterial;
      }), BlockState.BLOCKSTATE_CODEC.fieldOf("under_material").forGetter((p_237206_0_) -> {
         return p_237206_0_.underMaterial;
      }), BlockState.BLOCKSTATE_CODEC.fieldOf("underwater_material").forGetter((p_237205_0_) -> {
         return p_237205_0_.underWaterMaterial;
      })).apply(p_237204_0_, SurfaceBuilderConfig1::new);
   });
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