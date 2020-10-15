package com.babcsany.minecraft.ervin_mod_1.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;

import java.util.Random;

public abstract class BlockStateProvider1 implements IDynamicSerializable {
   protected final BlockStateProviderType<?> blockStateProvider;

   protected BlockStateProvider1(BlockStateProviderType<?> p_i225854_1_) {
      this.blockStateProvider = p_i225854_1_;
   }

   public abstract BlockState getBlockState(Random p_225574_1_, BlockPos p_225574_2_);
}