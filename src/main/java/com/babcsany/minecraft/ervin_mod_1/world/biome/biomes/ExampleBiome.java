package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
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

public class ExampleBiome {
	public ExampleBiome() {
		make(() -> ModConfiguredSurfaceBuilders.EXAMPLE_SURFACE);
	}

	public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
		BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
		MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder builder = new Biome.Builder();
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 30, 1, 20));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.LIWRAY.get(), 1, 1, 3));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.ROVENT_ENTITY.get(), 1, 1, 3));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.ZUR_ENTITY.get(), 20, 1, 1));
		spawnInfoBuilder.withSpawner(EntityClassification.WATER_CREATURE, new SpawnListEntry(EntityInit.GUBROV.get(), 1, 1, 4));
		spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.FREIN_ENTITY.get(), 1, 0, 2));
		spawnInfoBuilder.withSpawner(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 40, 1, 20));
		spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT_ENTITY.get(), 2, 0, 2));
		DefaultBiomeFeatures.withStrongholdAndMineshaft(biomeBuilder);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE);
		biomeBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CANYON);
		biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(64))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG4)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(120))));
		biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG3)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(75))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG2)
						.withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(NoPlacementConfig.INSTANCE))
						.withChance(100.0F).feature.get());
		biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG1)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(50))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.MUSHROOM_FIELD_VEGETATION);
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								() -> Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_GRINTH_MUSHROOM),
								() -> Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_SCRAFTH_MUSHROOM)))
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(1))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								() -> Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FRIM_GROUND_BUSH_CONFIG_WITH_FEW_BEEHIVES),
								() -> Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FRIM_TREE_CONFIG)))
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(1))));
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG)
						.withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1)))
						.withChance(0.25F).feature.get());
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.SCRAFTH_MUSHROOM_CONFIG)
						.withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1)))
						.withChance(0.25F).feature.get());
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.RED_MUSHROOM_CONFIG)
						.withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1)))
						.withChance(0.125F).feature.get());
		biomeBuilder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG)
						.withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG))
						.withChance(10).feature.get());
		biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG0).withPlacement(
						Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(45, 12.0f, 25))));
		biomeBuilder.withSurfaceBuilder(configuredSurfaceBuilderSupplier);

		ModDefaultBiomeFeatures.addOres(biomeBuilder);
		ModDefaultBiomeFeatures.addBlackIronOres(biomeBuilder);
		ModDefaultBiomeFeatures.addIronOres(biomeBuilder);
		ModDefaultBiomeFeatures.addRedIronOres(biomeBuilder);
		DefaultBiomeFeatures.withExtraGoldOre(biomeBuilder);
		ModDefaultBiomeFeatures.addExtraEmeraldOre(biomeBuilder);
		ModBiomeFeatures.addExampleFeature(biomeBuilder, 1000);
		ModBiomeFeatures.addExampleRuinedPortalFeature(biomeBuilder, 10000);
		ModDefaultBiomeFeatures.addStones(biomeBuilder);
		ModDefaultBiomeFeatures.addKiomne(biomeBuilder);
		ModDefaultBiomeFeatures.addFirgTrees(biomeBuilder);

		ambienceBuilder.setWaterColor(16724639);
		ambienceBuilder.setWaterFogColor(16762304);
		ambienceBuilder.setFogColor(1253846);
		ambienceBuilder.withGrassColor(0xFF0000);

		builder.precipitation(Biome.RainType.SNOW);
		builder.scale(51.6F);
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
