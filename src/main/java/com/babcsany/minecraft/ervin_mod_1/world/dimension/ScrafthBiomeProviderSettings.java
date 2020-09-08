package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class ScrafthBiomeProviderSettings implements IBiomeProviderSettings {

	private final long seed;
	private final WorldType worldType;
	private ScrafthGenSettings generatorSettings = new ScrafthGenSettings();

	public ScrafthBiomeProviderSettings(WorldInfo info) {
		this.seed = info.getSeed();
		this.worldType = info.getGenerator();
	}

	public ScrafthBiomeProviderSettings setGeneratorSettings(ScrafthGenSettings settings) {
		this.generatorSettings = settings;
		return this;
	}

	public long getSeed() {
		return this.seed;
	}

	public WorldType getWorldType() {
		return this.worldType;
	}

	public ScrafthGenSettings getGeneratorSettings() {
		return this.generatorSettings;
	}
}
