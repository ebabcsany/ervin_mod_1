package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleFeature;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleFeature1;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleRuinedPortalFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class ModBiomeFeatures {
	public static Feature<NoFeatureConfig> EXAMPLE_FEATURE = register("example_feature", new ExampleFeature(NoFeatureConfig.CODEC));
	public static Feature<NoFeatureConfig> EXAMPLE_FEATURE1 = register("example_feature1", new ExampleFeature1(NoFeatureConfig.CODEC));
	public static Feature<NoFeatureConfig> EXAMPLE_RUINED_PORTAL_FEATURE = register("example_ruined_portal_feature", new ExampleRuinedPortalFeature(NoFeatureConfig.CODEC));

	public static void addExampleFeature(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				EXAMPLE_FEATURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance)))
		);
	}
	public static void addExampleFeature1(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				EXAMPLE_FEATURE1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance)))
		);
	}
	public static void addExampleRuinedPortalFeature(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				EXAMPLE_RUINED_PORTAL_FEATURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance)))
		);
	}

	@Deprecated
	public static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
		return Registry.register(Registry.FEATURE, Ervin_mod_1.identifier(key), value);
	}
}
