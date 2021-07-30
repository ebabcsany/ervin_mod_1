package com.babcsany.minecraft.ervin_mod_1.block;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;
import net.minecraft.util.registry.Registry;

public class ModBlockState extends BlockState implements net.minecraftforge.common.extensions.IForgeBlockState {
   public static final Codec<BlockState> BLOCKSTATE_CODEC = func_235897_a_(Registry.BLOCK, Block::getDefaultState).stable();

   public ModBlockState(Block block, ImmutableMap<Property<?>, Comparable<?>> propertiesToValueMap, MapCodec<BlockState> codec) {
      super(block, propertiesToValueMap, codec);
   }

   protected ModBlockState getSelf() {
      return this;
   }
}
