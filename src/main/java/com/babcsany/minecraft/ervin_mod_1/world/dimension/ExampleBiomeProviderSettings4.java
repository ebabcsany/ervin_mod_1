package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class ExampleBiomeProviderSettings4 implements IBiomeProviderSettings {

	private final long seed;
	private final WorldType worldType;
	private ExampleGenSettings4 generatorSettings = new ExampleGenSettings4();

	public ExampleBiomeProviderSettings4(WorldInfo info) {
		this.seed = info.getSeed();
		this.worldType = info.getGenerator();
	}

	public ExampleBiomeProviderSettings4 setGeneratorSettings(ExampleGenSettings4 settings) {
		this.generatorSettings = settings;
		return this;
	}

	public long getSeed() {
		return this.seed;
	}

	public WorldType getWorldType() {
		return this.worldType;
	}

	public ExampleGenSettings4 getGeneratorSettings() {
		return this.generatorSettings;
	}
}
