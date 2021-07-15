package com.babcsany.minecraft.ervin_mod_1.world.gen;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.init.*;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FrimTree;
import static com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig.FillerBlockType.*;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockStateProvidingFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.registries.ForgeRegistries;
import static net.minecraft.entity.EntityClassification.*;
import static net.minecraft.world.gen.GenerationStage.*;
import static net.minecraft.world.gen.placement.Placement.*;

public class FeatureGen {
	private static final BlockState RUBY_ORE = BlockItemInit.RUBY_ORE.get().getDefaultState();
	private static final BlockState AIR = BlockItemInit.AIR.get().getDefaultState();
	private static final BlockState KALT_BLOCK = BlockItemInit.KALT_BLOCK.get().getDefaultState();
	private static final BlockState SURVI = BlockItemInit.SURVI.get().getDefaultState();
	private static final BlockState TRIRIJ = isBurnableBlockItemInit.TRIRIJ.getDefaultState();
	private static final BlockState TRUGN = isBurnableBlockItemInit.TRUGN.get().getDefaultState();
	private static final BlockState NETHERRACK = Blocks.NETHERRACK.getDefaultState();
	private static final BlockState OBSIDIAN = Blocks.OBSIDIAN.getDefaultState();
	public static final BlockState FIRT_BLOCK = BlockInit.FIRT_BLOCK.getDefaultState();
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
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEFAULT) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.PLAINS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
				addOakTurgs(biomeIn, 48);
				addFirgTurgs(biomeIn, 48);
				addFrimTurgs(biomeIn, 48);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DESERT) {
				addOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.MOUNTAINS) {
				addOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.FOREST) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
				addBirchTurgs(biomeIn, 16);
				addOakTurgs(biomeIn, 48);
				addFirgTurgs(biomeIn, 48);
				addFrimTurgs(biomeIn, 48);
			}
			if (biomeIn == Biomes.TAIGA) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFrimTrees(biomeIn);
				addFrimTurgs(biomeIn, 16);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SWAMP) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.RIVER) {
				addOres(biomeIn);
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
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.FROZEN_RIVER) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SNOWY_TUNDRA) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 16);
			}
			if (biomeIn == Biomes.SNOWY_MOUNTAINS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 16);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELDS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 8);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELD_SHORE) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 8);
			}
			if (biomeIn == Biomes.BEACH) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 16);
			}
			if (biomeIn == Biomes.DESERT_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 8);
			}
			if (biomeIn == Biomes.WOODED_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFirgTurgs(biomeIn, 48);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.TAIGA_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.MOUNTAIN_EDGE) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 24);
			}
			if (biomeIn == Biomes.JUNGLE) {
				addOres(biomeIn);
				addStones(biomeIn);
				addJungleTurgs(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 8);
			}
			if (biomeIn == Biomes.JUNGLE_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addJungleTurgs(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 8);
			}
			if (biomeIn == Biomes.JUNGLE_EDGE) {
				addOres(biomeIn);
				addStones(biomeIn);
				addJungleTurgs(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 8);
			}
			if (biomeIn == Biomes.DEEP_OCEAN) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.STONE_SHORE) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 8, 32);
			}
			if (biomeIn == Biomes.SNOWY_BEACH) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 16);
			}
			if (biomeIn == Biomes.BIRCH_FOREST) {
				addOres(biomeIn);
				addStones(biomeIn);
				addBirchTurgs(biomeIn, 50);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 8);
			}
			if (biomeIn == Biomes.BIRCH_FOREST_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addBirchTurgs(biomeIn, 50);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 8);
			}
			if (biomeIn == Biomes.DARK_FOREST) {
				addOres(biomeIn);
				addStones(biomeIn);
				addDarkOakTurgs(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 16);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFirgTurgs(biomeIn, 32);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 16);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 4, 16);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 12, 8);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 12, 8);
			}
			if (biomeIn == Biomes.WOODED_MOUNTAINS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFirtBlockFeature(biomeIn, 8, 12);
			}
			if (biomeIn == Biomes.SAVANNA) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 10, 16);
			}
			if (biomeIn == Biomes.SAVANNA_PLATEAU) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 12, 18);
			}
			if (biomeIn == Biomes.BADLANDS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addKaltBlockFeature(biomeIn, 6, 14);
			}
			if (biomeIn == Biomes.WOODED_BADLANDS_PLATEAU) {
				addOres(biomeIn);
				addStones(biomeIn);
				addSparseFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
				addKaltBlockFeature(biomeIn, 9, 15);
			}
			if (biomeIn == Biomes.BADLANDS_PLATEAU) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addKaltBlockFeature(biomeIn, 13, 20);
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
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.LUKEWARM_OCEAN) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.COLD_OCEAN) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEEP_WARM_OCEAN) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEEP_LUKEWARM_OCEAN) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEEP_COLD_OCEAN) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.DEEP_FROZEN_OCEAN) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.THE_VOID) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addAir1Feature(biomeIn, 4, 8);
			}
			if (biomeIn == Biomes.SUNFLOWER_PLAINS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirgTrees(biomeIn);
				addFrimTrees(biomeIn);
				addFirtBlockFeature(biomeIn, 15, 6);
			}
			if (biomeIn == Biomes.DESERT_LAKES) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 11, 11);
			}
			if (biomeIn == Biomes.GRAVELLY_MOUNTAINS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirtBlockFeature(biomeIn, 7, 10);
			}
			if (biomeIn == Biomes.FLOWER_FOREST) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirtBlockFeature(biomeIn, 10, 13);
			}
			if (biomeIn == Biomes.TAIGA_MOUNTAINS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFirtBlockFeature(biomeIn, 5, 9);
			}
			if (biomeIn == Biomes.SWAMP_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 6, 17);
			}
			if (biomeIn == Biomes.ICE_SPIKES) {
				addOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE_EDGE) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.TALL_BIRCH_FOREST) {
				addOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.TALL_BIRCH_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.DARK_FOREST_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_MOUNTAINS) {
				addOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_GRAVELLY_MOUNTAINS) {
				addOres(biomeIn);
				addStones(biomeIn);
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA_PLATEAU) {
				addOres(biomeIn);
				addStones(biomeIn);
				addFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.ERODED_BADLANDS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU) {
				addOres(biomeIn);
				addStones(biomeIn);
				addSparseFrimTrees(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.MODIFIED_BADLANDS_PLATEAU) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 7, 14);
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE_HILLS) {
				addOres(biomeIn);
				addStones(biomeIn);
				addGenerateBlocks(biomeIn);
				addFirtBlockFeature(biomeIn, 14, 9);
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

	public static void getSpawns() {
		for (Biome biomeIn : ForgeRegistries.BIOMES) {
			if (biomeIn == Biomes.OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 36, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.PLAINS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 38, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.DESERT) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 8, 1, 1);
			}
			if (biomeIn == Biomes.MOUNTAINS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 41, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.FOREST) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 34, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.TAIGA) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 37, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.SWAMP) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 33, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.RIVER) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 39, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.NETHER_WASTES) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 24, 0, 4);
			}
			if (biomeIn == Biomes.THE_END) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 1, 0, 1);
			}
			if (biomeIn == Biomes.FROZEN_OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 42, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.FROZEN_RIVER) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 44, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 10, 1, 5);
			}
			if (biomeIn == Biomes.SNOWY_TUNDRA) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 43, 1, 1);
			}
			if (biomeIn == Biomes.SNOWY_MOUNTAINS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 40, 1, 1);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELDS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 4, 1, 1);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELD_SHORE) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 4, 1, 1);
			}
			if (biomeIn == Biomes.BEACH) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 34, 1, 1);
			}
			if (biomeIn == Biomes.DESERT_HILLS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 8, 1, 1);
			}
			if (biomeIn == Biomes.WOODED_HILLS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 39, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.TAIGA_HILLS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 45, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.MOUNTAIN_EDGE) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 44, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.JUNGLE) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 42, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.JUNGLE_HILLS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 46, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.JUNGLE_EDGE) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 43, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.DEEP_OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 38, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 13, 1, 5);
			}
			if (biomeIn == Biomes.STONE_SHORE) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 37, 1, 1);
			}
			if (biomeIn == Biomes.SNOWY_BEACH) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 33, 1, 1);
			}
			if (biomeIn == Biomes.BIRCH_FOREST) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 34, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.BIRCH_FOREST_HILLS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 36, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.DARK_FOREST) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 35, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 38, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_HILLS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 40, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 44, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA_HILLS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 46, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.WOODED_MOUNTAINS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 39, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.SAVANNA) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 36, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.SAVANNA_PLATEAU) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 34, 1, 1);
				addSpawn(biomeIn, CREATURE, EntityInit.SRACH_ENTITY, 12, 1, 4);
			}
			if (biomeIn == Biomes.BADLANDS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 37, 1, 1);
			}
			if (biomeIn == Biomes.WOODED_BADLANDS_PLATEAU) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 43, 1, 1);
			}
			if (biomeIn == Biomes.BADLANDS_PLATEAU) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 39, 1, 1);
			}
			if (biomeIn == Biomes.SMALL_END_ISLANDS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 1, 0, 1);
			}
			if (biomeIn == Biomes.END_MIDLANDS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 1, 0, 1);
			}
			if (biomeIn == Biomes.END_HIGHLANDS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 1, 0, 1);
			}
			if (biomeIn == Biomes.END_BARRENS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 1, 0, 1);
			}
			if (biomeIn == Biomes.WARM_OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 41, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 8, 1, 5);
			}
			if (biomeIn == Biomes.LUKEWARM_OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 38, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 14, 1, 5);
			}
			if (biomeIn == Biomes.COLD_OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 34, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.DEEP_WARM_OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 37, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 14, 1, 5);
			}
			if (biomeIn == Biomes.DEEP_LUKEWARM_OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 35, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 15, 1, 5);
			}
			if (biomeIn == Biomes.DEEP_COLD_OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 37, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.DEEP_FROZEN_OCEAN) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 39, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.THE_VOID) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 1, 0, 1);
			}
			if (biomeIn == Biomes.SUNFLOWER_PLAINS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 24, 1, 1);
			}
			if (biomeIn == Biomes.DESERT_LAKES) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 34, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.GRAVELLY_MOUNTAINS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 28, 1, 1);
			}
			if (biomeIn == Biomes.FLOWER_FOREST) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 22, 1, 1);
			}
			if (biomeIn == Biomes.TAIGA_MOUNTAINS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 29, 1, 1);
			}
			if (biomeIn == Biomes.SWAMP_HILLS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 30, 1, 1);
				addSpawn(biomeIn, WATER_CREATURE, EntityInit.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.ICE_SPIKES) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 26, 1, 1));
				biomeIn.getSpawns(EntityClassification.WATER_CREATURE).add(new Biome.SpawnListEntry(EntityInit.GUBROV, 16, 1, 5));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 23, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 17)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(7))));
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE_EDGE) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 31, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 20)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(6))));
			}
			if (biomeIn == Biomes.TALL_BIRCH_FOREST) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 21, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 8)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
			}
			if (biomeIn == Biomes.TALL_BIRCH_HILLS) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 23, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 8)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(9))));
			}
			if (biomeIn == Biomes.DARK_FOREST_HILLS) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 27, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 10)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(13))));
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_MOUNTAINS) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 20, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 7)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(19))));
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 30, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 14)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(15))));
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA_HILLS) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 32, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 21)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(12))));
			}
			if (biomeIn == Biomes.MODIFIED_GRAVELLY_MOUNTAINS) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 34, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 16)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 37, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 13)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(15))));
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA_PLATEAU) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 35, 1, 1));
				biomeIn.addFeature(Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 11)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(17))));
			}
			if (biomeIn == Biomes.ERODED_BADLANDS) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 33, 1, 1));
				biomeIn.addFeature(Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(TERRACOTTA_VARIANTS, KALT_BLOCK, 11)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(15))));
			}
			if (biomeIn == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 29, 1, 1));
				biomeIn.addFeature(Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(TERRACOTTA_VARIANTS, KALT_BLOCK, 8)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(10))));
			}
			if (biomeIn == Biomes.MODIFIED_BADLANDS_PLATEAU) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 31, 1, 1));
				biomeIn.addFeature(Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(TERRACOTTA_VARIANTS, KALT_BLOCK, 9)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(13))));
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 33, 1, 1));
				biomeIn.addFeature(Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 7)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(14))));
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE_HILLS) {
				biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 26, 1, 1));
				biomeIn.addFeature(Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, 14)).withPlacement(CHANCE_HEIGHTMAP.configure(new ChanceConfig(9))));
			}
			if (biomeIn == Biomes.SOUL_SAND_VALLEY) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 10, 0, 4);
			}
			if (biomeIn == Biomes.CRIMSON_FOREST) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 10, 0, 4);
			}
			if (biomeIn == Biomes.WARPED_FOREST) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 10, 0, 4);
			}
			if (biomeIn == Biomes.BASALT_DELTAS) {
				addSpawn(biomeIn, MONSTER, EntityInit.ZUR_ENTITY, 10, 0, 4);
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
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG0).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG1).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG2).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG3).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_CONFIG4).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.field_236291_c_.withConfiguration(FirgTree.FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG1).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(5))));
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

	public static void addOres(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, SURVI, 45)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 25))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RUBY_ORE, 12)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(8, 16, 64))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, AIR, 8)).withPlacement(Placement.COUNT_DEPTH_AVERAGE.configure(new DepthAverageConfig(20, 24, 36))));
	}

	public static void addEndStoneOres(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.END_STONE, SRIUNK_ORE, 16)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(30, 0, 0, 115))));
	}

	public static void addNaturalEndStone(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_STONE, 20)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(80, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_SRACKT, 16)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(64, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_SRACT, 12)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(48, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_STONE_CISK, 4)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(16, 0, 0, 256))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_END_STONE, END_STONE_CRISK, 2)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 256))));
	}

	public static void addNetherBlocks(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, TRIRIJ, 6)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 64))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.MAGMA_BLOCK, TRIRIJ, 16)).withPlacement(Placement.MAGMA.configure(new FrequencyConfig(30))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.TRIRIJ, MAGMA_BLOCK, 8)).withPlacement(Placement.MAGMA.configure(new FrequencyConfig(15))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES, TRIRIJ, 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(12, 0, 0, 96))));
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

	private static void addAcaciaTurgs(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(ACACIA_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(50))));
	}

	private static void addBirchTurgs(Biome biomeIn, int chance) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(BIRCH_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))));
	}

	private static void addDarkOakTurgs(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(DARK_OAK_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(50))));
	}

	private static void addJungleTurgs(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(JUNGLE_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(50))));
	}

	private static void addOakTurgs(Biome biomeIn, int chance) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(OAK_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))));
	}

	private static void addSpruceTurgs_chance_32(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(SPRUCE_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(32))));
	}

	private static void addFirgTurgs(Biome biomeIn, int chance) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(FIRG_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))));
	}

	private static void addFrimTurgs(Biome biomeIn, int chance) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(FRIM_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(chance))));
	}

	private static void addGenerateBlocks(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.TURGS, FIRT_BLOCK, 10)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(100))));
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.WATER, TRUGN, 1)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(10))));
	}

	private static void addFirtBlockFeature(Biome biomeIn, int size, int chance) {
		biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_DIRTS, FIRT_BLOCK, size)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(chance))));
	}

	private static void addKaltBlockFeature(Biome biomeIn, int size, int chance) {
		biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(TERRACOTTA_VARIANTS, KALT_BLOCK, size)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(chance))));
	}

	private static void addAir1Feature(Biome biomeIn, int size, int chance) {
		biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(NATURAL_STONE1, AIR, size)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(chance))));
	}

	private static void addGenOreFeature(Biome biomeIn, GenerationStage.Decoration decoration, GenOreFeatureConfig.FillerBlockType fillerBlockType, BlockState state, int size, ConfiguredPlacement<?> placement) {
		biomeIn.addFeature(decoration, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(fillerBlockType, state, size)).withPlacement(placement));
	}

	private static void addOreFeature(Biome biomeIn, GenerationStage.Decoration decoration, OreFeatureConfig.FillerBlockType fillerBlockType, BlockState state, int size, ConfiguredPlacement<?> placement) {
		biomeIn.addFeature(decoration, Feature.ORE.withConfiguration(new OreFeatureConfig(fillerBlockType, state, size)).withPlacement(placement));
	}

	private static void addSpawn(Biome biomeIn, EntityClassification entityClassification, EntityType<?> entityTypeIn, int weight, int minGroupCountIn, int maxGroupCountIn) {
		biomeIn.getSpawns(entityClassification).add(new Biome.SpawnListEntry(entityTypeIn, weight, minGroupCountIn, maxGroupCountIn));
	}

	private static void addSpawnZur(Biome biomeIn, int weight, int minGroupCountIn, int maxGroupCountIn) {
		biomeIn.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, weight, minGroupCountIn, maxGroupCountIn));
	}

	private static void addEntityClassification(EntityClassification entityClassification) {
	}

	static GenerationStage.Decoration decoration1;
	public static final GenerationStage.Decoration decoration = decoration1;
	public GenOreFeatureConfig.FillerBlockType fillerBlockType;

	public static final EntityClassification AMBIENT = EntityClassification.AMBIENT;
	public static final EntityClassification WATER_AMBIENT = EntityClassification.WATER_AMBIENT;
	public static final EntityClassification MISC = EntityClassification.MISC;

	//public static final EntityClassification ZUR = EntityClassification.create("zur", "8", 40, true, true, 64);
}
