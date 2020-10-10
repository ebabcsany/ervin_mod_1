package com.babcsany.minecraft.ervin_mod_1.world.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class MigBiomeSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public MigBiomeSurfaceBuilder(Codec<SurfaceBuilderConfig> function) {
		super(function);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		Random rd = new Random();
		int i = rd.nextInt(3);
		if (i == 0) {
			SurfaceBuilder.BADLANDS.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							Blocks.GRASS_BLOCK.getDefaultState(),
							BlockInit.EXAMPLE_BLOCK.get().getDefaultState(),
							Blocks.OBSIDIAN.getDefaultState()));
		} if (i == 1) {
			SurfaceBuilder.FROZEN_OCEAN.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							BlockInit.END_PORTAL.get().getDefaultState(),
							BlockInit.DURT.get().getDefaultState(),
							Blocks.CHEST.getDefaultState()));
		} if (i == 2) {
			SurfaceBuilder.MOUNTAIN.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							BlockInit.SCRAFTH.get().getDefaultState(),
							BlockInit.NETHER_PORTAL.get().getDefaultState(),
							BlockInit.LEAT_BLOCK.get().getDefaultState()));
		} if (i == 1) {
			SurfaceBuilder.WOODED_BADLANDS.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							BlockInit.KALT_BLOCK.get().getDefaultState(),
							BlockInit.GRINTH_MUSHROOM.get().getDefaultState(),
							Blocks.COARSE_DIRT.getDefaultState()));
		} if (i == 2) {
			SurfaceBuilder.GIANT_TREE_TAIGA.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							Blocks.WATER.getDefaultState(),
							Blocks.DIRT.getDefaultState(),
							Blocks.AIR.getDefaultState()));
		} if (i == 1) {
			SurfaceBuilder.SWAMP.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							BlockInit.TRUGK_BLOCK.get().getDefaultState(),
							BlockInit.GRITH_BLOCK.get().getDefaultState(),
							BlockInit.DIAMOND_BLOCK.get().getDefaultState()));
		} if (i == 0) {
			SurfaceBuilder.ERODED_BADLANDS.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							BlockInit.NIRK_BLOCK.get().getDefaultState(),
							BlockInit.ZUNK_BLOCK.get().getDefaultState(),
							BlockInit.ZURK_BLOCK.get().getDefaultState()));
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							BlockInit.SRIUNK_BLOCK.get().getDefaultState(),
							BlockInit.TRUGN.get().getDefaultState(),
							BlockInit.TRINKS.get().getDefaultState()
					));
		}
	}
}
