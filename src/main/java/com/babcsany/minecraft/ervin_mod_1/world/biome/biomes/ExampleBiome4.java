package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class ExampleBiome4 {
	public ExampleBiome4() {
		make(() -> ModConfiguredSurfaceBuilders.EXAMPLE_SURFACE4);
	}

	public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
		BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
		MobSpawnInfo.Builder spawn = new MobSpawnInfo.Builder();
		BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
		Biome.Builder biomeBuilder = new Biome.Builder();
		spawn.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 0, 5));
		spawn.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.IRON_GOLEM, 50, 0, 5));
		spawn.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 0, 10));
		spawn.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 40, 0, 5));
		spawn.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BAT, 30, 0, 10));
		DefaultBiomeFeatures.withStrongholdAndMineshaft(builder);
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(5120))));
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.MEGA_FIRG_TREE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(24))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.END_ISLAND.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(15))));
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.VOID_START_PLATFORM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(NoPlacementConfig.INSTANCE)).withChance(20.0F).feature.get());
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.GRASS_CONFIG)
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(1000))));
		DefaultBiomeFeatures.withNormalMushroomGeneration(builder);
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_BOOLEAN_SELECTOR
						.withConfiguration(new TwoFeatureChoiceConfig(
								() -> Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_BROWN_MUSHROOM),
								() -> Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FRIM_TREE_CONFIG)))
						.withPlacement(Placement.CHANCE.configure(new ChanceConfig(1))));
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
						Placement.HEIGHTMAP_WORLD_SURFACE.configure(new NoPlacementConfig())).range(1).withChance(0.25F).feature.get());
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.GRINTH_MUSHROOM_CONFIG).withPlacement(
						Placement.HEIGHTMAP_WORLD_SURFACE.configure(new NoPlacementConfig())).range(1).withChance(0.4F).feature.get());
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
						Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(NoPlacementConfig.INSTANCE)).withChance(0.125F).feature.get());
		builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
				Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG).withPlacement(
						Placement.CHANCE.configure(new ChanceConfig(25))).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG0).withPlacement(
						Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(18, 4.8f, 10))));
		builder.withSurfaceBuilder(configuredSurfaceBuilderSupplier);

		DefaultBiomeFeatures.withOverworldOres(builder);
		DefaultBiomeFeatures.withExtraGoldOre(builder);
		ModDefaultBiomeFeatures.addExtraBlackStone(builder);
		ModDefaultBiomeFeatures.addExtraBlueStone(builder);
		ModDefaultBiomeFeatures.addExtraBrownStone(builder);
		ModDefaultBiomeFeatures.addExtraCyanStone(builder);
		ModDefaultBiomeFeatures.addExtraGreenStone(builder);
		ModDefaultBiomeFeatures.addExtraLightBlueStone(builder);
		ModDefaultBiomeFeatures.addExtraLightGrayStone(builder);
		ModDefaultBiomeFeatures.addExtraLimeStone(builder);
		ModDefaultBiomeFeatures.addExtraMagentaStone(builder);
		ModDefaultBiomeFeatures.addExtraOrangeStone(builder);
		ModDefaultBiomeFeatures.addExtraPinkStone(builder);
		ModDefaultBiomeFeatures.addExtraPurpleStone(builder);
		ModDefaultBiomeFeatures.addExtraRedStone(builder);
		ModDefaultBiomeFeatures.addExtraWhiteStone(builder);
		ModDefaultBiomeFeatures.addExtraYellowStone(builder);
		ModDefaultBiomeFeatures.addExtraEmeraldOre(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock1(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock2(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock3(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock4(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock5(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock6(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock7(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock8(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock9(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock10(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock11(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock12(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock13(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock14(builder);
		ModDefaultBiomeFeatures.addExtraVilktBlock15(builder);
		ModDefaultBiomeFeatures.addEmeraldOreFeature(builder, GenerationStage.Decoration.UNDERGROUND_ORES, Blocks.STONE.getDefaultState(), BlockItemInit.KALT_BLOCK.get().getDefaultState(), Placement.COUNT.configure(new FeatureSpreadConfig(FeatureSpread.create(20, 10))).range(30));
		ModBiomeFeatures.addExampleFeature(builder, 10000);
		ModDefaultBiomeFeatures.addKiomne(builder);
		ModDefaultBiomeFeatures.addStones(builder);
		ModDefaultBiomeFeatures.addEndCity(builder);
		DefaultBiomeFeatures.withFrozenTopLayer(builder);

		ambienceBuilder.setWaterColor(34895);
		ambienceBuilder.setWaterFogColor(131263);
		ambienceBuilder.setFogColor(4562745);
		ambienceBuilder.withGrassColor(0x8040ff);

		biomeBuilder.precipitation(Biome.RainType.NONE);
		biomeBuilder.scale(10000.0F);
		biomeBuilder.temperature(50.0F);
		biomeBuilder.setEffects(ambienceBuilder.build());
		biomeBuilder.withGenerationSettings(builder.build());
		biomeBuilder.category(Biome.Category.BEACH);
		biomeBuilder.downfall(50.0F);
		biomeBuilder.scale(10.0F);

		return biomeBuilder.build();
	}
}

//update mappings post command:
//gradlew --refresh-dependencies
