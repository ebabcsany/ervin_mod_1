package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import com.babcsany.minecraft.init.BlockInit;
import com.babcsany.minecraft.init.FeatureInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class TwustBiome {
	public TwustBiome() {
		make(() -> ModConfiguredSurfaceBuilders.TWUST_SURFACE);
	}

	public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
		BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder biomeBuilder = new Biome.Builder();
		builder.withCarver(GenerationStage.Carving.AIR, WorldCarver.CAVE.func_242761_a(new ProbabilityConfig(2.64353268137F)));
		builder.withSurfaceBuilder(configuredSurfaceBuilderSupplier);
		ModDefaultBiomeFeatures.addExtraDirt(builder);
		ModDefaultBiomeFeatures.addExtraKaltBlock(builder);
		ModDefaultBiomeFeatures.addFirgs(builder);
		ModDefaultBiomeFeatures.addWaterLakes(builder);
		ModDefaultBiomeFeatures.addFeature(builder, GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.WATER, BlockInit.FIRT_BLOCK.get().getDefaultState(), 30)));
		ambienceBuilder.setWaterColor(16777215);
		ambienceBuilder.setWaterFogColor(16777210);
		ambienceBuilder.setFogColor(1677241);
		ambienceBuilder.withGrassColor(0xe0c0a0);
		biomeBuilder.precipitation(Biome.RainType.SNOW);
		biomeBuilder.scale(1003.2F);
		biomeBuilder.temperature(0.5F);
		biomeBuilder.setEffects(ambienceBuilder.build());
		biomeBuilder.withGenerationSettings(builder.build());
		biomeBuilder.category(Biome.Category.THEEND);
		biomeBuilder.downfall(0.5F);
		biomeBuilder.depth(0.12F);
		return biomeBuilder.build();
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
