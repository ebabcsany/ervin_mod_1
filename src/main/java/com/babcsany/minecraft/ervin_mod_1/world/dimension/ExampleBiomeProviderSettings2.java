package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class ExampleBiomeProviderSettings2 implements IBiomeProviderSettings {

	private final long seed;
	private final WorldType worldType;
	private ExampleGenSettings2 generatorSettings = new ExampleGenSettings2();

	public ExampleBiomeProviderSettings2(WorldInfo info) {
		this.seed = info.getSeed();
		this.worldType = info.getGenerator();
	}

	public ExampleBiomeProviderSettings2 setGeneratorSettings(ExampleGenSettings2 settings) {
		this.generatorSettings = settings;
		return this;
	}

	public long getSeed() {
		return this.seed;
	}

	public WorldType getWorldType() {
		return this.worldType;
	}

	public ExampleGenSettings2 getGeneratorSettings() {
		return this.generatorSettings;
	}
}
