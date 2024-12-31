package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiomeMaker;
import com.babcsany.minecraft.ervin_mod_1.world.biome.surface_builders.ExampleBiomeSurfaceBuilder5;
import com.babcsany.minecraft.ervin_mod_1.world.feature.JazzTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.ModSurfaceBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.function.Supplier;

public class ExampleBiome5 {
	public ExampleBiome5() {
		make(ModConfiguredSurfaceBuilders.EXAMPLE_SURFACE5.get(), ModSurfaceBuilder.COARSE_DIRT_DIRT_DIRT_CONFIG);
	}

	public static Biome make(final ExampleBiomeSurfaceBuilder5 configuredSurfaceBuilder, SurfaceBuilderConfig config) {
		BiomeGenerationSettings.Builder generationSettingsBuilder = new BiomeGenerationSettings.Builder();
		MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder builder = new Biome.Builder();
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		DefaultBiomeFeatures.withBadlandsGrass(generationSettingsBuilder);
		generationSettingsBuilder.withCarver(GenerationStage.Carving.AIR, new ConfiguredCarver<>(WorldCarver.CAVE, new ProbabilityConfig(1.65432F)));
		generationSettingsBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE);
		DefaultBiomeFeatures.withNormalMushroomGeneration(generationSettingsBuilder);
		generationSettingsBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.RED_MUSHROOM_NORMAL);
		generationSettingsBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.BROWN_MUSHROOM_NORMAL);
		ModDefaultBiomeFeatures.addExtraTree(generationSettingsBuilder, JazzTree.JAZZ_TREE_CONFIG, 7, 0.1f, 1);
		generationSettingsBuilder.withSurfaceBuilder(configuredSurfaceBuilder.func_242929_a(config));

		DefaultBiomeFeatures.withOverworldOres(generationSettingsBuilder);
		DefaultBiomeFeatures.withExtraGoldOre(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraBlackStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraBlueStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraBrownStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraCyanStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraGreenStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraLightBlueStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraLightGrayStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraLimeStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraMagentaStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraOrangeStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraPinkStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraPurpleStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraRedStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraWhiteStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addExtraYellowStone(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addWaterLakes(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addStones(generationSettingsBuilder);
		ModDefaultBiomeFeatures.addStoneVariants(generationSettingsBuilder);
		DefaultBiomeFeatures.withEmeraldOre(generationSettingsBuilder);
		ModBiomeFeatures.addExampleFeature(generationSettingsBuilder, 10);
		DefaultBiomeFeatures.withFrozenTopLayer(generationSettingsBuilder);

		ambienceBuilder.setWaterColor(16724639);
		ambienceBuilder.setWaterFogColor(16762304);
		ambienceBuilder.setFogColor(1253846);
		ambienceBuilder.withGrassColor(0xFF0080);
		ambienceBuilder.withSkyColor(ModBiomeMaker.getSkyColorWithTemperatureModifier(37.19F));
		ambienceBuilder.withFoliageColor(0xFF5080);

		builder.precipitation(Biome.RainType.RAIN);
		builder.scale(1.2F);
		builder.temperature(4.162F);
		builder.setEffects(ambienceBuilder.build());
		builder.withMobSpawnSettings(spawnInfoBuilder.build());
		builder.withGenerationSettings(generationSettingsBuilder.build());
		builder.category(Biome.Category.PLAINS);
		builder.downfall(0.5F);
		builder.depth(0.12F);

		return builder.build();
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
