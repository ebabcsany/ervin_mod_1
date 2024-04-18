package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class EndBiome0 {
	public EndBiome0() {
		make(() -> ModConfiguredSurfaceBuilders.MUHK_SURFACE);
	}

	public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
		BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
		MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder builder = new Biome.Builder();
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		DefaultBiomeFeatures.withSparseBerries(biomeBuilder);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, new ConfiguredCarver<>(WorldCarver.CAVE, new ProbabilityConfig(0.14285715F)));
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, new ConfiguredCarver<>(WorldCarver.NETHER_CAVE, new ProbabilityConfig(0.02F)));
		biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(128))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								() -> Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_RED_MUSHROOM),
								() -> Feature.HUGE_BROWN_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
						.withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT.configure(new FeatureSpreadConfig(1)).chance(25)));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1)).chance(25)));
		biomeBuilder.withSurfaceBuilder(configuredSurfaceBuilderSupplier);

		DefaultBiomeFeatures.withOverworldOres(biomeBuilder);
		DefaultBiomeFeatures.withExtraGoldOre(biomeBuilder);
		DefaultBiomeFeatures.withEmeraldOre(biomeBuilder);
		ModDefaultBiomeFeatures.addStones(biomeBuilder);
		ModBiomeFeatures.addExampleFeature(biomeBuilder, 10);
		DefaultBiomeFeatures.withFrozenTopLayer(biomeBuilder);

		ambienceBuilder.setWaterColor(4159204);
		ambienceBuilder.setWaterFogColor(329011);
		ambienceBuilder.setFogColor(10518688);
		ambienceBuilder.withSkyColor(0);
		ambienceBuilder.setMoodSound(MoodSoundAmbience.DEFAULT_CAVE);

		builder.precipitation(Biome.RainType.NONE);
		builder.scale(0.2F);
		builder.temperature(0.5F);
		builder.withGenerationSettings(biomeBuilder.build());
		builder.setEffects(ambienceBuilder.build());
		builder.category(Biome.Category.THEEND);
		builder.downfall(0.5F);
		builder.depth(0.1F);

		return builder.build();
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
