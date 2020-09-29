package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleFeature;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleFeature1;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModBiomeFeatures {

	public static void addExampleFeature(Biome biome, int chance) {
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				new ExampleFeature(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))
						));

	}
	public static void addExampleFeature1(Biome biome, int chance) {
		biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				new ExampleFeature1(NoFeatureConfig.field_236558_a_).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(chance))
						));

	}
}
