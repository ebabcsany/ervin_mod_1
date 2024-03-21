package com.babcsany.minecraft.ervin_mod_1.world.biome.surface_builders;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockInit;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class EndBiomeSurfaceBuilder0 extends SurfaceBuilder<SurfaceBuilderConfig> {

	public EndBiomeSurfaceBuilder0(Codec<SurfaceBuilderConfig> function) {
		super(function);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
							 BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		Random rd = new Random();
		int i = rd.nextInt(3);
		if (i == 0) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(UnusedBlockInit.get("air").get().getDefaultState(),
							BlockItemInit.DEFERRED_BLOCK.get().getDefaultState(), Blocks.END_STONE.getDefaultState()));
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							i == 1 ? Blocks.END_STONE.getDefaultState()
									: BlockItemInit.AVTER_BLOCK.get().getDefaultState(),
							BlockItemInit.DEFERRED_BLOCK.get().getDefaultState(), Blocks.END_STONE.getDefaultState()));
		}
	}
}