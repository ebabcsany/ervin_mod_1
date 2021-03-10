package com.babcsany.minecraft.ervin_mod_1.world.gen;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TutorialOreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.PLAINS) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(20, 5, 5, 25));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.ORE
					.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockItemInit.SURVI.get().getDefaultState(), 74))
					.withPlacement(customConfig));
			}
		}
	}
	public static void generateBlackStone() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.DESERT) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(10, 15, 15, 20));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockItemInit.BLACK_STONE.get().getDefaultState(), 24))
						.withPlacement(customConfig));
			}
		}
	}
	public static void generateBlueStone() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.PLAINS) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(10, 15, 15, 20));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockItemInit.BLUE_STONE.get().getDefaultState(), 24))
						.withPlacement(customConfig));
			}
		}
	}
	public static void generateBrownStone() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.PLAINS) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(10, 15, 15, 20));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockItemInit.BROWN_STONE.get().getDefaultState(), 24))
						.withPlacement(customConfig));
			}
		}
	}
	public static void generateCyanStone() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.PLAINS) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(10, 15, 15, 20));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockItemInit.CYAN_STONE.get().getDefaultState(), 24))
						.withPlacement(customConfig));
			}
		}
	}
	public static void generateGreenStone() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.PLAINS) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(10, 15, 15, 20));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockItemInit.GREEN_STONE.get().getDefaultState(), 24))
						.withPlacement(customConfig));
			}
		}
	}
}

//OreFeatureConfig.FillerBlockType.create("end_stone", null, new BlockMatcher(Blocks.END_STONE))