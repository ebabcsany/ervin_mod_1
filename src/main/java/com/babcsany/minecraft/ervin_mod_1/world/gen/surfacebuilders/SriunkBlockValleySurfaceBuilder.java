package com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.ValleySurfaceBuilder;

public class SriunkBlockValleySurfaceBuilder extends ValleySurfaceBuilder {
   private static final BlockState field_237180_a_ = isBurnableBlockItemInit.SRIUNK_BLOCK.get().getDefaultState();
   private static final BlockState field_237181_b_ = BlockItemInit.AVTER_BLOCK.get().getDefaultState();
   private static final BlockState field_237182_c_ = BlockItemInit.NIRTKB.get().getDefaultState();
   private static final ImmutableList<BlockState> field_237183_d_ = ImmutableList.of(field_237180_a_, field_237181_b_);

   public SriunkBlockValleySurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232135_1_) {
      super(p_i232135_1_);
   }

   protected ImmutableList<BlockState> func_230387_a_() {
      return field_237183_d_;
   }

   protected ImmutableList<BlockState> func_230388_b_() {
      return field_237183_d_;
   }

   protected BlockState func_230389_c_() {
      return field_237182_c_;
   }
}