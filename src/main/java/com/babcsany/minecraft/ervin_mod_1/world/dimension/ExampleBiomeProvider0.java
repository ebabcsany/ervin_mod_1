package com.babcsany.minecraft.ervin_mod_1.world.dimension;

public class ExampleBiomeProvider0 /*extends BiomeProvider*/ {

	/*private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.EXAMPLE_BIOME.get(), Biomes.BEACH);
	private Random rand;
	private final double biomeSize = 16.0D;
	private VoronoiGenerator biomeNoise;

	public ExampleBiomeProvider0(ExampleBiomeProviderSettings0 settings) {
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
	}*/
}
