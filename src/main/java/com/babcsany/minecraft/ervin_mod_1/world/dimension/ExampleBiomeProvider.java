package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.mojang.serialization.Codec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.*;

public class ExampleBiomeProvider /*extends BiomeProvider*/ {

	/*private static final List<Biome> biomeList = new List(BiomeInit.EXAMPLE_BIOME.get(), Biomes.BEACH);
	private Random rand;
	private final double biomeSize = 320.0D;
	private VoronoiGenerator biomeNoise;

	public ExampleBiomeProvider(ExampleBiomeProviderSettings settings) {
		super(biomeList);
		rand = new Random();
		this.biomeNoise = new VoronoiGenerator();
		this.biomeNoise.setSeed((int) settings.getSeed());
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return getBiome(new LinkedList<Biome>(biomeList),
				biomeNoise.getValue((double) x / biomeSize, (double) y / biomeSize, (double) z / biomeSize));
	}

	public Biome getBiome(List<Biome> biomeList, double noiseVal) {
		for (int i = biomeList.size(); i >= 0; i--) {
			if (noiseVal > (2.0f / biomeList.size()) * i - 1)
				return biomeList.get(i);
		}
		return biomeList.get(biomeList.size() - 1);
	}

	@Override
	protected Codec<? extends BiomeProvider> func_230319_a_() {
		return null;
	}

	@Override
	public BiomeProvider func_230320_a_(long p_230320_1_) {
		return null;
	}*/
}
