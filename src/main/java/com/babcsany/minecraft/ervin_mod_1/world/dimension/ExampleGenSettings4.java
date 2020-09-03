package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.world.gen.GenerationSettings;

public class ExampleGenSettings4 extends GenerationSettings {

	public int getBiomeSize() {
		return 1;
	}

	public int getRiverSize() {
		return 1;
	}

	public int getBiomeId() {
		return -1;
	}

	@Override
	public int getBedrockFloorHeight() {
		return 1;
	}
}
