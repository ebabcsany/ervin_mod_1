package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ExampleBiomeProvider3 extends BiomeProvider {

	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.EXAMPLE_BIOME3.get(), Biomes.BEACH);
	private Random rand;
	private final double biomeSize = 3480.0D;
	private VoronoiGenerator biomeNoise;

	public ExampleBiomeProvider3(ExampleBiomeProviderSettings3 settings) {
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
		for (int i = biomeList.size(); i >= 1; i--) {
			if (noiseVal > (1.0f / biomeList.size()) * i - 1)
				return biomeList.get(i);
		}
		return biomeList.get(biomeList.size() - 1);
	}
}
