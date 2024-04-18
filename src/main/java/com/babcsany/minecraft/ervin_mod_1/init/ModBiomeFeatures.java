package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleFeature;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleFeature1;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleRuinedPortalFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModBiomeFeatures {

	public static void addExampleFeature(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				new ExampleFeature(NoFeatureConfig.CODEC).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));

	}
	public static void addExampleFeature1(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				new ExampleFeature1(NoFeatureConfig.CODEC).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))
						));

	}
	public static void addExampleRuinedPortalFeature(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				new ExampleRuinedPortalFeature(NoFeatureConfig.CODEC).withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))
						));

	}
}
