package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
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

public class ExampleBiome2 {
	public ExampleBiome2() {
		make(() -> ModConfiguredSurfaceBuilders.EXAMPLE_SURFACE2);
	}

	public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
		BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
		MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder builder = new Biome.Builder();
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 0, 5));
		/*this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 40, 0, 5));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.VILLAGER, 25, 0, 5));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WANDERING_TRADER, 30, 0, 5));
		this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BAT, 20, 0, 30));
		//this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.BLAZE, 5, 20, 50));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.COMMAND_BLOCK_MINECART, 15, 0, 5));
		this.addSpawn(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityType.DOLPHIN, 20, 0, 5));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ARROW, 25, 0, 5));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CAT, 30, 0, 5));*/

		//this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.ZUR_ENTITY.get(), 5, 5, 20));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
		spawnInfoBuilder.withCreatureSpawnProbability(10);
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.ZUR_ENTITY1.get(), 15, 10, 30));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT_ENTITY.get(), 30, 15, 40));
		//this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.SRACH_ENTITY.get(), 8, 8, 16));
		DefaultBiomeFeatures.withIcebergs(biomeBuilder);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.UNDERWATER_CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CANYON);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.UNDERWATER_CANYON);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE);
		biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(128))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG3)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(240))));
		biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG2)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(150))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG1)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(200))));
		biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(100))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								() -> Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_RED_MUSHROOM),
								() -> Feature.HUGE_BROWN_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
						.withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								() -> Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FRIM_GROUND_BUSH_CONFIG_WITH_FEW_BEEHIVES),
								() -> Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FRIM_TREE_CONFIG)))
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(1))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1)).chance(25)));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
						Placement.COUNT.configure(new FeatureSpreadConfig(1)).chance(12)));
		biomeBuilder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1).withPlacement(
						Placement.CHANCE.configure(new ChanceConfig(250)).countSpread(FeatureSpread.create(46))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG0).withPlacement(
						Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(18, 4.8f, 10))));
		biomeBuilder.withSurfaceBuilder(configuredSurfaceBuilderSupplier);

		DefaultBiomeFeatures.withOverworldOres(biomeBuilder);
		DefaultBiomeFeatures.withExtraGoldOre(biomeBuilder);
		ModDefaultBiomeFeatures.addExtraEmeraldOre(biomeBuilder);
		ModBiomeFeatures.addExampleFeature(biomeBuilder, 1000);
		ModDefaultBiomeFeatures.addStones(biomeBuilder);
		ModDefaultBiomeFeatures.addKiomne(biomeBuilder);
		DefaultBiomeFeatures.withFrozenTopLayer(biomeBuilder);

		ambienceBuilder.setWaterColor(16724639);
		ambienceBuilder.setWaterFogColor(16762304);
		ambienceBuilder.setFogColor(1253846);
		ambienceBuilder.withGrassColor(0x00FF80);

		builder.precipitation(Biome.RainType.SNOW);
		builder.scale(25.5F);
		builder.temperature(0.5F);
		builder.setEffects(ambienceBuilder.build());
		builder.withGenerationSettings(biomeBuilder.build());
		builder.category(Biome.Category.PLAINS);
		builder.downfall(0.5F);
		builder.depth(0.12F);

		return builder.build();
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
