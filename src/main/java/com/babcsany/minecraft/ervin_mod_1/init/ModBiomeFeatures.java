package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.world.feature.SriunkFeature;
import com.babcsany.minecraft.ervin_mod_1.world.feature.SriunkFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModBiomeFeatures {

	public static void addExampleFeature(Biome biome, int chance) {
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				new SriunkFeature(NoFeatureConfig::deserialize).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))));
	}
}
