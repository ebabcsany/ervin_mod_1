package com.babcsany.minecraft.ervin_mod_1.world.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class ExampleBiomeSurfaceBuilder4 extends SurfaceBuilder<SurfaceBuilderConfig> {

	public ExampleBiomeSurfaceBuilder4(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function) {
		super(function);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		Random rd = new Random();
		int i = rd.nextInt(14);
		if (i == 0) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(BlockInit.FIRT_BLOCK.get().getDefaultState(),
							BlockInit.LEAT_BLOCK_CRAFTING_TABLE.get().getDefaultState(), BlockInit.GRITH_BLOCK.get().getDefaultState()
					));
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock,
					defaultFluid, seaLevel, seed,
					new SurfaceBuilderConfig(
							i == 1 ? Blocks.DIRT.getDefaultState()
									: BlockInit.DURT.get().getDefaultState(),
							BlockInit.VILTDROP_BLOCK.get().getDefaultState(), BlockInit.EPKIN.get().getDefaultState()
					));
		}
	}
}
