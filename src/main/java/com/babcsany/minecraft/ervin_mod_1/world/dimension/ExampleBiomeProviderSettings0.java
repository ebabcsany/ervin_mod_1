package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class ExampleBiomeProviderSettings0 implements IBiomeProviderSettings {

	private final long seed;
	private final WorldType worldType;
	private ExampleGenSettings0 generatorSettings = new ExampleGenSettings0();

	public ExampleBiomeProviderSettings0(WorldInfo info) {
		this.seed = info.getSeed();
		this.worldType = info.getGenerator();
	}

	public ExampleBiomeProviderSettings0 setGeneratorSettings(ExampleGenSettings0 settings) {
		this.generatorSettings = settings;
		return this;
	}

	public long getSeed() {
		return this.seed;
	}

	public WorldType getWorldType() {
		return this.worldType;
	}

	public ExampleGenSettings0 getGeneratorSettings() {
		return this.generatorSettings;
	}
}
