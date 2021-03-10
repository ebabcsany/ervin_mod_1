package com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.ValleySurfaceBuilder;

public class ExampleSurfaceBuilder extends ValleySurfaceBuilder {
   private static final BlockState LEAT_BLOCK_CRAFTING_TABLE = isBurnableBlockItemInit.LEAT_BLOCK_CRAFTING_TABLE.get().getDefaultState();
   private static final BlockState CRASK = BlockItemInit.CRASK.get().getDefaultState();
   private static final BlockState GRITK_BLOCK = BlockItemInit.GRITK_BLOCK.get().getDefaultState();
   private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
   private static final BlockState SRIUNK_BLOCK = isBurnableBlockItemInit.SRIUNK_BLOCK.get().getDefaultState();
   private static final BlockState TRUGN = isBurnableBlockItemInit.TRUGN.get().getDefaultState();
   private static final BlockState TRINKS = BlockItemInit.TRINKS.get().getDefaultState();
   private static final BlockState WATER = Blocks.WATER.getDefaultState();
   private static final BlockState LAVA = Blocks.LAVA.getDefaultState();
   private static final ImmutableList<BlockState> LEAT_BLOCK_CRAFTING_TABLE_CRASK_TRUGN = ImmutableList.of(LEAT_BLOCK_CRAFTING_TABLE, CRASK, TRUGN);
   private static final ImmutableList<BlockState> LEAT_BLOCK_CRAFTING_TABLE_SRIUNK_BLOCK_LAVA = ImmutableList.of(GRASS_BLOCK, SRIUNK_BLOCK, LAVA);
   private static final ImmutableList<BlockState> TRINKS_WATER_GRITK_BLOCK = ImmutableList.of(TRINKS, WATER, GRITK_BLOCK);

   public ExampleSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232123_1_) {
      super(p_i232123_1_);
   }

   protected ImmutableList<BlockState> getLeatBlockCraftingTableCraskTrugn() {
      return LEAT_BLOCK_CRAFTING_TABLE_CRASK_TRUGN;
   }

   protected ImmutableList<BlockState> func_230387_a_() {
      return LEAT_BLOCK_CRAFTING_TABLE_SRIUNK_BLOCK_LAVA;
   }

   protected ImmutableList<BlockState> func_230388_b_() {
      return TRINKS_WATER_GRITK_BLOCK;
   }

   protected BlockState func_230389_c_() {
      return GRITK_BLOCK;
   }

   protected BlockState getSriunkBlock() {
      return SRIUNK_BLOCK;
   }
}