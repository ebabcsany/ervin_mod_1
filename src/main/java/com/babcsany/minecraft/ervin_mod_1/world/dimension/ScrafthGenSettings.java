package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.world.gen.GenerationSettings;

public class ScrafthGenSettings extends GenerationSettings {

	public int getBiomeSize() {
		return 4;
	}

	public int getRiverSize() {
		return 4;
	}

	public int getBiomeId() {
		return -1;
	}

	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}
}
