package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiomeMaker;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class ExampleBiome1 {
	public ExampleBiome1() {
		make(() -> ModConfiguredSurfaceBuilders.EXAMPLE_SURFACE1);
	}

	public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
		BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
		MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder builder = new Biome.Builder();
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 20, 50));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.AREA_EFFECT_CLOUD, 40, 20, 50));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BAT, 20, 20, 50));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.BLAZE, 5, 20, 50));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.COMMAND_BLOCK_MINECART, 15, 20, 50));
		spawnInfoBuilder.withSpawner(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.DOLPHIN, 20, 20, 50));
		spawnInfoBuilder.withSpawner(EntityClassification.MISC, new SpawnListEntry(EntityType.ARROW, 25, 20, 50));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CAT, 30, 20, 50));

		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.ZUR, 5, 5, 20));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.LIWRAY, 15, 10, 30));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT, 30, 15, 40));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.SRACH_ENTITY, 8, 8, 16));
		DefaultBiomeFeatures.withBadlandsStructures(biomeBuilder);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.UNDERWATER_CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CANYON);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.UNDERWATER_CANYON);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE);
		biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(128))));
		ModDefaultBiomeFeatures.addFirgTree3(biomeBuilder, 240);
		ModDefaultBiomeFeatures.addFirgTree2(biomeBuilder, 150);
		ModDefaultBiomeFeatures.addFirgTree1(biomeBuilder, 200);
		ModDefaultBiomeFeatures.addFirgTree(biomeBuilder, 100);
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								() -> Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_RED_MUSHROOM),
								() -> Feature.HUGE_BROWN_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
						.withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								() -> Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FRIM_GROUND_BUSH_CONFIG_WITH_FEW_BEEHIVES),
								() -> Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FRIM_TREE_CONFIG)))
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(1))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT.configure(new FeatureSpreadConfig(1)).chance(25)));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1)).chance(12)));
		biomeBuilder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1).withPlacement(
						Placement.CHANCE.configure(new ChanceConfig(250))));
		ModDefaultBiomeFeatures.addExtraTree(biomeBuilder, FirgTree.FIRG_TREE_CONFIG0, 18, 4.8f, 10);
		biomeBuilder.withSurfaceBuilder(configuredSurfaceBuilderSupplier);

		DefaultBiomeFeatures.withOverworldOres(biomeBuilder);
		DefaultBiomeFeatures.withExtraGoldOre(biomeBuilder);
		ModDefaultBiomeFeatures.addExtraEmeraldOre(biomeBuilder);
		ModBiomeFeatures.addExampleFeature(biomeBuilder, 1000);
		ModDefaultBiomeFeatures.addStones(biomeBuilder);
		ModDefaultBiomeFeatures.addKiomne(biomeBuilder);
		DefaultBiomeFeatures.withFrozenTopLayer(biomeBuilder);

		ambienceBuilder.setWaterColor(4563891);
		ambienceBuilder.setWaterFogColor(7543209);
		ambienceBuilder.setFogColor(62529834);
		ambienceBuilder.withSkyColor(ModBiomeMaker.getSkyColorWithTemperatureModifier(0.67F));
		ambienceBuilder.withGrassColor(0xff80000);

		builder.precipitation(Biome.RainType.RAIN);
		builder.scale(1.2F);
		builder.temperature(0.5F);
		builder.setEffects(ambienceBuilder.build());
		builder.withMobSpawnSettings(spawnInfoBuilder.build());
		builder.withGenerationSettings(biomeBuilder.build());
		builder.category(Biome.Category.PLAINS);
		builder.downfall(5.5F);
		builder.depth(12.12F);

		return builder.build();
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
