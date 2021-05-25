package com.babcsany.minecraft.ervin_mod_1.world.gen;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.FeatureInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FrimTree;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockPileFeature;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;

public class FeatureGen {
	private static final BlockState RUBY_ORE = BlockItemInit.RUBY_ORE.get().getDefaultState();
	private static final BlockState AIR = BlockItemInit.AIR.get().getDefaultState();
	private static final BlockState SURVI = BlockItemInit.SURVI.get().getDefaultState();
	private static final BlockState TRIRIJ = isBurnableBlockItemInit.TRIRIJ.getDefaultState();
	private static final BlockState NETHERRACK = Blocks.NETHERRACK.getDefaultState();
	private static final BlockState OBSIDIAN = Blocks.OBSIDIAN.getDefaultState();
	private static final BlockState FIRT_BLOCK = BlockItemInit.FIRT_BLOCK.get().getDefaultState();
	private static final BlockState MAGMA_BLOCK = Blocks.MAGMA_BLOCK.getDefaultState();
	private static final BlockState STONE = Blocks.STONE.getDefaultState();
	private static final BlockState BLACK_STONE = BlockItemInit.BLACK_STONE.get().getDefaultState();
	private static final BlockState BLUE_STONE = BlockItemInit.BLUE_STONE.get().getDefaultState();
	private static final BlockState BROWN_STONE = BlockItemInit.BROWN_STONE.get().getDefaultState();
	private static final BlockState CYAN_STONE = BlockItemInit.CYAN_STONE.get().getDefaultState();
	private static final BlockState GREEN_STONE = BlockItemInit.GREEN_STONE.get().getDefaultState();
	private static final BlockState LIGHT_BLUE1_STONE = BlockItemInit.LIGHT_BLUE1_STONE.get().getDefaultState();
	private static final BlockState LIGHT_BLUE_STONE = BlockItemInit.LIGHT_BLUE_STONE.get().getDefaultState();
	private static final BlockState LIGHT_GRAY_STONE = BlockItemInit.LIGHT_GRAY_STONE.get().getDefaultState();
	private static final BlockState LIME_STONE = BlockItemInit.LIME_STONE.get().getDefaultState();
	private static final BlockState MAGENTA_STONE = BlockItemInit.MAGENTA_STONE.get().getDefaultState();
	private static final BlockState ORANGE_STONE = BlockItemInit.ORANGE_STONE.get().getDefaultState();
	private static final BlockState PINK_STONE = BlockItemInit.PINK_STONE.get().getDefaultState();
	private static final BlockState PURPLE_STONE = BlockItemInit.PURPLE_STONE.get().getDefaultState();
	private static final BlockState RED_STONE = BlockItemInit.RED_STONE.get().getDefaultState();
	private static final BlockState WHITE_STONE = BlockItemInit.WHITE_STONE.get().getDefaultState();
	private static final BlockState YELLOW_STONE = BlockItemInit.YELLOW_STONE.get().getDefaultState();
	private static final BlockState SRIUNK_ORE = BlockItemInit.SRIUNK_ORE.get().getDefaultState();
	private static final BlockState END_STONE = Blocks.END_STONE.getDefaultState();
	private static final BlockState END_SRACKT = BlockItemInit.END_SRACKT.get().getDefaultState();
	private static final BlockState END_SRACT = BlockItemInit.END_SRACT.get().getDefaultState();
	private static final BlockState END_STONE_CISK = BlockItemInit.END_STONE_CISK.get().getDefaultState();
	private static final BlockState END_STONE_CRISK = BlockItemInit.END_STONE_CRISK.get().getDefaultState();
	private static final BlockState ENDER_SACKT = BlockItemInit.ENDER_SACKT.get().getDefaultState();
	private static final BlockState ENDER_SACT = BlockItemInit.ENDER_SACT.get().getDefaultState();
	private static final BlockState ENDER_SRACK = BlockItemInit.ENDER_SRACK.get().getDefaultState();
	private static final BlockState ENDER_SRACKH = BlockItemInit.ENDER_SRACKH.get().getDefaultState();
	private static final BlockState ENDER_SRACT = BlockItemInit.ENDER_SRACT.get().getDefaultState();
	private static final BlockState ACACIA_TURG = BlockItemInit.ACACIA_TURG.get().getDefaultState();
	private static final BlockState BIRCH_TURG = BlockItemInit.BIRCH_TURG.get().getDefaultState();
	private static final BlockState DARK_OAK_TURG = BlockItemInit.DARK_OAK_TURG.get().getDefaultState();
	private static final BlockState JUNGLE_TURG = BlockItemInit.JUNGLE_TURG.get().getDefaultState();
	private static final BlockState OAK_TURG = BlockItemInit.OAK_TURG.get().getDefaultState();
	private static final BlockState SPRUCE_TURG = BlockItemInit.SPRUCE_TURG.get().getDefaultState();
	private static final BlockState FIRG_TURG = BlockItemInit.FIRG_TURG.get().getDefaultState();
	private static final BlockState FRIM_TURG = BlockItemInit.FRIM_TURG.get().getDefaultState();
	public static final BlockStateProvidingFeatureConfig ACACIA_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(ACACIA_TURG));
	public static final BlockStateProvidingFeatureConfig BIRCH_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(BIRCH_TURG));
	public static final BlockStateProvidingFeatureConfig DARK_OAK_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(DARK_OAK_TURG));
	public static final BlockStateProvidingFeatureConfig JUNGLE_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(JUNGLE_TURG));
	public static final BlockStateProvidingFeatureConfig OAK_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(OAK_TURG));
	public static final BlockStateProvidingFeatureConfig SPRUCE_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(SPRUCE_TURG));
	public static final BlockStateProvidingFeatureConfig FIRG_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(FIRG_TURG));
	public static final BlockStateProvidingFeatureConfig FRIM_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(FRIM_TURG));

	public static void GenerateFeature() {
		for (Biome biomeIn : ForgeRegistries.BIOMES) {
			if (biomeIn == Biomes.OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEFAULT) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.PLAINS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DESERT) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
			}
			if (biomeIn == Biomes.MOUNTAINS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.FOREST) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.TAIGA) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SWAMP) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.RIVER) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.NETHER_WASTES) {
				addNetherBlocks(biomeIn);
			}
			if (biomeIn == Biomes.THE_END) {
				addNaturalEndStone(biomeIn);
				addEndStoneVariants(biomeIn);
				addEndStoneOres(biomeIn);
			}
			if (biomeIn == Biomes.FROZEN_OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.FROZEN_RIVER) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SNOWY_TUNDRA) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SNOWY_MOUNTAINS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELDS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELD_SHORE) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.BEACH) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DESERT_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.WOODED_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.TAIGA_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.MOUNTAIN_EDGE) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
			}
			if (biomeIn == Biomes.JUNGLE) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.JUNGLE_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.JUNGLE_EDGE) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEEP_OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.STONE_SHORE) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SNOWY_BEACH) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.BIRCH_FOREST) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.BIRCH_FOREST_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DARK_FOREST) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.WOODED_MOUNTAINS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
			}
			if (biomeIn == Biomes.SAVANNA) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SAVANNA_PLATEAU) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.BADLANDS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.WOODED_BADLANDS_PLATEAU) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addSparseFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.BADLANDS_PLATEAU) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SMALL_END_ISLANDS) {
				addNaturalEndStone(biomeIn);
				addEndStoneVariants(biomeIn);
				addEndStoneOres(biomeIn);
			}
			if (biomeIn == Biomes.END_MIDLANDS) {
				addNaturalEndStone(biomeIn);
				addEndStoneVariants(biomeIn);
				addEndStoneOres(biomeIn);
			}
			if (biomeIn == Biomes.END_HIGHLANDS) {
				addNaturalEndStone(biomeIn);
				addEndStoneVariants(biomeIn);
				addEndStoneOres(biomeIn);
			}
			if (biomeIn == Biomes.END_BARRENS) {
				addNaturalEndStone(biomeIn);
				addEndStoneVariants(biomeIn);
				addEndStoneOres(biomeIn);
			}
			if (biomeIn == Biomes.WARM_OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.LUKEWARM_OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.COLD_OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEEP_WARM_OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEEP_LUKEWARM_OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEEP_COLD_OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEEP_FROZEN_OCEAN) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.THE_VOID) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SUNFLOWER_PLAINS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
			}
			if (biomeIn == Biomes.DESERT_LAKES) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.GRAVELLY_MOUNTAINS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.FLOWER_FOREST) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.TAIGA_MOUNTAINS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.SWAMP_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.ICE_SPIKES) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE_EDGE) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.TALL_BIRCH_FOREST) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.TALL_BIRCH_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.DARK_FOREST_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_MOUNTAINS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_GRAVELLY_MOUNTAINS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA_PLATEAU) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.ERODED_BADLANDS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addSparseFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_BADLANDS_PLATEAU) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE_HILLS) {
				addGenerateOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SOUL_SAND_VALLEY) {
				addNetherBlocks(biomeIn);
			}
			if (biomeIn == Biomes.CRIMSON_FOREST) {
				addNetherBlocks(biomeIn);
			}
			if (biomeIn == Biomes.WARPED_FOREST) {
				addNetherBlocks(biomeIn);
			}
			if (biomeIn == Biomes.BASALT_DELTAS) {
				addNetherBlocks(biomeIn);
			}
		}
	}
	public static void generateBlackStone() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.THE_END) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, SRIUNK_ORE, 50)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
			}
		}
	}
	/*public static void generateBlueStone() {
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
	public static void generateRubyOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.BEACH) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(10, 15, 15, 20));
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.ORE
						.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, Blocks.STONE.getDefaultState(), 12))
						.withPlacement(customConfig));
			}
		}
	}*/

	public static void addFirgTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG0).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG1).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG2).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG3).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_WITH_MANY_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
	}

	public static void addFrimTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FrimTree.FRIM_TREE_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FrimTree.FRIM_TREE_CONFIG0).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FrimTree.FRIM_TREE_CONFIG1).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FrimTree.FRIM_TREE_WITH_FEW_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FrimTree.FRIM_TREE_WITH_MANY_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
	}

	public static void addSparseFrimTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(FrimTree.FRIM_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(FrimTree.FRIM_TREE_CONFIG0).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(FrimTree.FRIM_TREE_CONFIG1).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
	}

	public static void addStones(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BLACK_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BLUE_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BROWN_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, CYAN_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GREEN_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, LIGHT_BLUE1_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, LIGHT_BLUE_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, LIGHT_GRAY_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, LIME_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MAGENTA_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ORANGE_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, PINK_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, PURPLE_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RED_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, WHITE_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, YELLOW_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 320))));
	}

	public static void addGenerateOres(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, SURVI, 45)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 25))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RUBY_ORE, 6)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(4, 32, 32))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AIR, 10)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(40, 24, 36))));
	}

	public static void addEndStoneOres(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.END_STONE, SRIUNK_ORE, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(40, 0, 0, 128))));
	}

	public static void addNaturalEndStone(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_SRACKT, 16)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_SRACT, 12)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_STONE_CISK, 4)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_STONE_CRISK, 2)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
	}

	public static void addNetherBlocks(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.MAGMA_BLOCK, TRIRIJ, 16)).withPlacement(Placement.MAGMA.configure(new FrequencyConfig(10))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.TRIRIJ, MAGMA_BLOCK, 8)).withPlacement(Placement.MAGMA.configure(new FrequencyConfig(5))));
	}

	public static void addEndStoneVariants(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.END_STONE_VARIANTS, ENDER_SACKT, 16)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.END_STONE_VARIANTS, ENDER_SACT, 12)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.END_STONE_VARIANTS, ENDER_SRACK, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.END_STONE_VARIANTS, ENDER_SRACKH, 28)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.END_STONE_VARIANTS, ENDER_SRACT, 36)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
	}

	public static enum GenerateRubyOreg {
		//OreFeatureConfig.FillerBlockType.create("end_stone", null, new BlockMatcher(Blocks.END_STONE));
	}

	private static void addGenerateOakTurgs(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, OAK_TURG, 10)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(100))));
	}

	private static void addGenerateSpruceTurgs(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(SPRUCE_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(50))));
	}

	private static void addGenerateFirgTurgs(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(FIRG_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(50))));	}

	private static void addGenerateFrimTurgs(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, OAK_TURG, 10)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(100))));
	}

	private static void addGenerateBlocks(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.TURGS, FIRT_BLOCK, 8)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(100))));
	}
}
