package com.babcsany.minecraft.ervin_mod_1.world.dimension;

import net.minecraft.world.gen.GenerationSettings;

public class ExampleGenSettings2 extends GenerationSettings {

	public int getBiomeSize() {
		return 14;
	}

	public int getRiverSize() {
		return 36;
	}

	public int getBiomeId() {
		return -19;
	}

	@Override
	public int getBedrockFloorHeight() {
		return -1;
	}
}
