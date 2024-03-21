package com.babcsany.minecraft.ervin_mod_1.world.gen;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockInit;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FrimTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import com.babcsany.minecraft.init.BlockInit;
import com.babcsany.minecraft.init.FeatureInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

import static com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig.FillerBlockType.*;
import static net.minecraft.entity.EntityClassification.*;
import static net.minecraft.world.gen.GenerationStage.Decoration;

public class FeatureGen {
	private static final BlockState RUBY_ORE = BlockItemInit.RUBY_ORE.get().getDefaultState();
	private static final BlockState AIR = UnusedBlockInit.get("air").get().getDefaultState();
	private static final BlockState KALT_BLOCK = BlockItemInit.KALT_BLOCK.get().getDefaultState();
	private static final BlockState SURVI = BlockItemInit.SURVI.get().getDefaultState();
	private static final BlockState TRIRIJ = BlockInit.TRIRIJ.get().getDefaultState();
	private static final BlockState TRUGN = isBurnableBlockItemInit.TRUGN.get().getDefaultState();
	private static final BlockState NETHERRACK = Blocks.NETHERRACK.getDefaultState();
	private static final BlockState OBSIDIAN = Blocks.OBSIDIAN.getDefaultState();
	private static final BlockState FIRT_BLOCK = BlockInit.FIRT_BLOCK.get().getDefaultState();
	private static final BlockState MAGMA_BLOCK = Blocks.MAGMA_BLOCK.getDefaultState();
	private static final BlockState STONE = Blocks.STONE.getDefaultState();
	private static final BlockState BLACK_STONE = BlockItemInit.BLACK_STONE.get().getDefaultState();
	private static final BlockState BLUE_STONE = BlockItemInit.BLUE_STONE.get().getDefaultState();
	private static final BlockState BROWN_STONE = BlockItemInit.BROWN_STONE.get().getDefaultState();
	private static final BlockState CYAN_STONE = BlockItemInit.CYAN_STONE.get().getDefaultState();
	private static final BlockState GREEN_STONE = BlockItemInit.GREEN_STONE.get().getDefaultState();
	private static final BlockState GRINT_BLOCK = com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit.GRINT_BLOCK.get().getDefaultState();
	private static final BlockState FIGHIV = com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit.FIGHIV.get().getDefaultState();
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
	private static final BlockState[] END_BLOCKS = new BlockState[]{GRINT_BLOCK, FIGHIV};
	public static final BlockStateProvidingFeatureConfig ACACIA_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(ACACIA_TURG));
	public static final BlockStateProvidingFeatureConfig BIRCH_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(BIRCH_TURG));
	public static final BlockStateProvidingFeatureConfig DARK_OAK_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(DARK_OAK_TURG));
	public static final BlockStateProvidingFeatureConfig JUNGLE_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(JUNGLE_TURG));
	public static final BlockStateProvidingFeatureConfig OAK_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(OAK_TURG));
	public static final BlockStateProvidingFeatureConfig SPRUCE_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(SPRUCE_TURG));
	public static final BlockStateProvidingFeatureConfig FIRG_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(FIRG_TURG));
	public static final BlockStateProvidingFeatureConfig FRIM_TURG_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(FRIM_TURG));
	public static final ConfiguredFeature<?, ?> END_CONFIG = new ConfiguredFeature<>(Feature.BLOCK_PILE, new BlockStateProvidingFeatureConfig(new BlockStateProvider() {
		@Override
		protected BlockStateProviderType<?> getProviderType() {
			return BlockStateProviderType.WEIGHTED_STATE_PROVIDER;
		}

		@Override
		public BlockState getBlockState(Random random, BlockPos blockPos) {
			double lvt_3_1_ = MathHelper.clamp((1.0 + Biome.INFO_NOISE.noiseAt((double)blockPos.getX() / 48.0, (double)blockPos.getZ() / 48.0, false)) / 2.0, 7.0, 0.9999);
			return END_BLOCKS[(int)(lvt_3_1_ * (double) END_BLOCKS.length)];
		}
	}));

	public static void generateFeature() {
		for (Biome biomeIn : ForgeRegistries.BIOMES) {
			BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
			if (biomeIn == Biomes.OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 130);
			}
			if (biomeIn == Biomes.PLAINS) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFrimTrees(builder, 5);
				addOakTurgs(builder, 36);
				addFirgTurgs(builder, 48);
				addFrimTurgs(builder, 48);
				addFirtBlocksInTurgs(builder, 10, 90);
			}
			if (biomeIn == Biomes.DESERT) {
				addOres(builder);
				addStones(builder);
			}
			if (biomeIn == Biomes.MOUNTAINS) {
				addOres(builder);
				addStones(builder);
			}
			if (biomeIn == Biomes.FOREST) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFrimTrees(builder, 5);
				addFirtBlocksInTurgs(builder, 10, 100);
				addBirchTurgs(builder, 16);
				addOakTurgs(builder, 48);
				addFirgTurgs(builder, 34);
				addFrimTurgs(builder, 48);
			}
			if (biomeIn == Biomes.TAIGA) {
				addOres(builder);
				addStones(builder);
				addFrimTrees(builder, 5);
				addFrimTurgs(builder, 16);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.SWAMP) {
				addOres(builder);
				addStones(builder);
				addFrimTrees(builder, 5);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.RIVER) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.NETHER_WASTES) {
				addNetherBlocks(builder);
			}
			if (biomeIn == Biomes.THE_END) {
				ModDefaultBiomeFeatures.addFeature(builder, Decoration.TOP_LAYER_MODIFICATION, END_CONFIG);
				addNaturalEndStone(builder);
				addEndStoneVariants(builder);
				addEndStoneOres(builder);
			}
			if (biomeIn == Biomes.FROZEN_OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.FROZEN_RIVER) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 20, 100);
			}
			if (biomeIn == Biomes.SNOWY_TUNDRA) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 20, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 16);
			}
			if (biomeIn == Biomes.SNOWY_MOUNTAINS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 4, 16);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELDS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 150);
				addFirtBlocksInNaturalDirts(builder, 4, 8);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELD_SHORE) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 20, 150);
				addFirtBlocksInNaturalDirts(builder, 4, 8);
			}
			if (biomeIn == Biomes.BEACH) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 16);
			}
			if (biomeIn == Biomes.DESERT_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 4, 8);
			}
			if (biomeIn == Biomes.WOODED_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFirgTurgs(builder, 48);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.TAIGA_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.MOUNTAIN_EDGE) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFirtBlocksInNaturalDirts(builder, 4, 24);
			}
			if (biomeIn == Biomes.JUNGLE) {
				addOres(builder);
				addStones(builder);
				addJungleTurgs(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 8);
			}
			if (biomeIn == Biomes.JUNGLE_HILLS) {
				addOres(builder);
				addStones(builder);
				addJungleTurgs(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 8);
			}
			if (biomeIn == Biomes.JUNGLE_EDGE) {
				addOres(builder);
				addStones(builder);
				addJungleTurgs(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 8);
			}
			if (biomeIn == Biomes.DEEP_OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.STONE_SHORE) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 8, 32);
			}
			if (biomeIn == Biomes.SNOWY_BEACH) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 16);
			}
			if (biomeIn == Biomes.BIRCH_FOREST) {
				addOres(builder);
				addStones(builder);
				addBirchTurgs(builder, 50);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 8);
			}
			if (biomeIn == Biomes.BIRCH_FOREST_HILLS) {
				addOres(builder);
				addStones(builder);
				addBirchTurgs(builder, 50);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 8);
			}
			if (biomeIn == Biomes.DARK_FOREST) {
				addOres(builder);
				addStones(builder);
				addDarkOakTurgs(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 16);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFirgTurgs(builder, 32);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 16);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 4, 16);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 12, 8);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 12, 8);
			}
			if (biomeIn == Biomes.WOODED_MOUNTAINS) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFirtBlocksInNaturalDirts(builder, 8, 12);
			}
			if (biomeIn == Biomes.SAVANNA) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFrimTrees(builder, 5);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 10, 16);
			}
			if (biomeIn == Biomes.SAVANNA_PLATEAU) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFrimTrees(builder, 5);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 12, 18);
			}
			if (biomeIn == Biomes.BADLANDS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addKaltBlockInTerracottaVariants(builder, 6, 14);
			}
			if (biomeIn == Biomes.WOODED_BADLANDS_PLATEAU) {
				addOres(builder);
				addStones(builder);
				addSparseFrimTrees(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addKaltBlockInTerracottaVariants(builder, 9, 15);
			}
			if (biomeIn == Biomes.BADLANDS_PLATEAU) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addKaltBlockInTerracottaVariants(builder, 13, 20);
			}
			if (biomeIn == Biomes.SMALL_END_ISLANDS) {
				ModDefaultBiomeFeatures.addFeature(builder, Decoration.TOP_LAYER_MODIFICATION, END_CONFIG);
				addNaturalEndStone(builder);
				addEndStoneVariants(builder);
				addEndStoneOres(builder);
			}
			if (biomeIn == Biomes.END_MIDLANDS) {
				ModDefaultBiomeFeatures.addFeature(builder, Decoration.TOP_LAYER_MODIFICATION, END_CONFIG);
				addNaturalEndStone(builder);
				addEndStoneVariants(builder);
				addEndStoneOres(builder);
			}
			if (biomeIn == Biomes.END_HIGHLANDS) {
				ModDefaultBiomeFeatures.addFeature(builder, Decoration.TOP_LAYER_MODIFICATION, END_CONFIG);
				addNaturalEndStone(builder);
				addEndStoneVariants(builder);
				addEndStoneOres(builder);
			}
			if (biomeIn == Biomes.END_BARRENS) {
				ModDefaultBiomeFeatures.addFeature(builder, Decoration.TOP_LAYER_MODIFICATION, END_CONFIG);
				addNaturalEndStone(builder);
				addEndStoneVariants(builder);
				addEndStoneOres(builder);
			}
			if (biomeIn == Biomes.WARM_OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.LUKEWARM_OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.COLD_OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.DEEP_WARM_OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.DEEP_WARM_OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.DEEP_COLD_OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.DEEP_FROZEN_OCEAN) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
			}
			if (biomeIn == Biomes.THE_VOID) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addAir1Feature(builder, 4, 8);
			}
			if (biomeIn == Biomes.SUNFLOWER_PLAINS) {
				addOres(builder);
				addStones(builder);
				addFirgTrees(builder);
				addFrimTrees(builder, 5);
				addAir1Feature(builder, 5, 9);
				addFirtBlocksInNaturalDirts(builder, 15, 6);
			}
			if (biomeIn == Biomes.DESERT_LAKES) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 11, 11);
			}
			if (biomeIn == Biomes.GRAVELLY_MOUNTAINS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 7, 10);
			}
			if (biomeIn == Biomes.FLOWER_FOREST) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 10, 13);
			}
			if (biomeIn == Biomes.TAIGA_MOUNTAINS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 5, 9);
			}
			if (biomeIn == Biomes.SWAMP_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 6, 17);
			}
			if (biomeIn == Biomes.ICE_SPIKES) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 4, 8);
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 17, 7);
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE_EDGE) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 20, 6);
			}
			if (biomeIn == Biomes.TALL_BIRCH_FOREST) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 8, 8);
			}
			if (biomeIn == Biomes.TALL_BIRCH_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 8, 9);
			}
			if (biomeIn == Biomes.DARK_FOREST_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 10, 13);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_MOUNTAINS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 7, 19);
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 14, 15);
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 21, 12);
			}
			if (biomeIn == Biomes.MODIFIED_GRAVELLY_MOUNTAINS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInNaturalDirts(builder, 16, 8);
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA) {
				addOres(builder);
				addStones(builder);
				addFrimTrees(builder, 5);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 13, 15);
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA_PLATEAU) {
				addOres(builder);
				addStones(builder);
				addFrimTrees(builder, 5);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 11, 17);
			}
			if (biomeIn == Biomes.ERODED_BADLANDS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addKaltBlockInTerracottaVariants(builder, 11, 15);
			}
			if (biomeIn == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU) {
				addOres(builder);
				addStones(builder);
				addSparseFrimTrees(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addKaltBlockInTerracottaVariants(builder, 8, 10);
				addAir1Feature(builder, 15, 8);
			}
			if (biomeIn == Biomes.MODIFIED_BADLANDS_PLATEAU) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addKaltBlockInTerracottaVariants(builder, 9, 13);
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 7, 14);
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE_HILLS) {
				addOres(builder);
				addStones(builder);
				addFirtBlocksInTurgs(builder, 10, 100);
				addFirtBlocksInNaturalDirts(builder, 14, 9);
			}
			if (biomeIn == Biomes.SOUL_SAND_VALLEY) {
				addNetherBlocks(builder);
			}
			if (biomeIn == Biomes.CRIMSON_FOREST) {
				addNetherBlocks(builder);
			}
			if (biomeIn == Biomes.WARPED_FOREST) {
				addNetherBlocks(builder);
			}
			if (biomeIn == Biomes.BASALT_DELTAS) {
				addNetherBlocks(builder);
			}
		}
	}

	public static void getSpawns() {
		for (Biome biomeIn : ForgeRegistries.BIOMES) {
			MobSpawnInfo.Builder builder = new MobSpawnInfo.Builder();
			if (biomeIn == Biomes.OCEAN) {
				addSpawnZur(builder, 36);
				addSpawner(builder, ModSpawnerType.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.PLAINS) {
				addSpawnZur(builder, 38);
				addSpawner(builder, ModSpawnerType.SRACH, 6, 1, 4);
				addSpawner(builder, ModSpawnerType.LIWRAY, 8, 0, 4);
			}
			if (biomeIn == Biomes.DESERT) {
				addSpawnZur(builder, 8);
				addSpawner(builder, ModSpawnerType.LIWRAY, 16, 1, 3);
			}
			if (biomeIn == Biomes.MOUNTAINS) {
				addSpawnZur(builder, 41);
				addSpawner(builder, ModSpawnerType.SRACH, 8, 1, 4);
				addSpawner(builder, ModSpawnerType.LIWRAY, 16, 1, 3);
			}
			if (biomeIn == Biomes.FOREST) {
				addSpawnZur(builder, 34);
				addSpawner(builder, ModSpawnerType.SRACH, 13, 1, 4);
				addSpawner(builder, ModSpawnerType.GWURST, 2, 4, 4);
			}
			if (biomeIn == Biomes.TAIGA) {
				addSpawnZur(builder, 37);
				addSpawner(builder, ModSpawnerType.SRACH, 9, 1, 4);
			}
			if (biomeIn == Biomes.SWAMP) {
				addSpawnZur(builder, 33);
				addSpawner(builder, ModSpawnerType.SRACH, 5, 1, 4);
				addSpawner(builder, ModSpawnerType.FREIN);
			}
			if (biomeIn == Biomes.RIVER) {
				addSpawnZur(builder, 39, 1);
				addSpawner(builder, ModSpawnerType.GUBROV, 16, 1, 5);
				addSpawner(builder, ModSpawnerType.FREIN, 1, 1);
			}
			if (biomeIn == Biomes.NETHER_WASTES) {
				addSpawnZur(builder, 24, 0, 4);
			}
			if (biomeIn == Biomes.THE_END) {
				addSpawnZur(builder);
			}
			if (biomeIn == Biomes.FROZEN_OCEAN) {
				addSpawnZur(builder, 42, 1);
				addSpawner(builder, ModSpawnerType.GUBROV, 16, 1, 5);
			}
			if (biomeIn == Biomes.FROZEN_RIVER) {
				addSpawnZur(builder, 44, 1);
				addSpawner(builder, ModSpawnerType.GUBROV, 10, 1, 5);
			}
			if (biomeIn == Biomes.SNOWY_TUNDRA) {
				addSpawnZur(builder, 43, 1);
			}
			if (biomeIn == Biomes.SNOWY_MOUNTAINS) {
				addSpawnZur(builder, 40, 1);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELDS) {
				addSpawnZur(builder, 4, 1);
			}
			if (biomeIn == Biomes.MUSHROOM_FIELD_SHORE) {
				addSpawnZur(builder, 4, 1);
			}
			if (biomeIn == Biomes.BEACH) {
				addSpawnZur(builder, 34, 1);
			}
			if (biomeIn == Biomes.DESERT_HILLS) {
				addSpawnZur(builder, 8, 1);
			}
			if (biomeIn == Biomes.WOODED_HILLS) {
				addSpawnZur(builder, 39, 1);
				addSpawner(builder, ModSpawnerType.SRACH, 12, 1, 4);
			}
			if (biomeIn == Biomes.TAIGA_HILLS) {
				addSpawnZur(builder, 45, 1);
				addSpawner(builder, ModSpawnerType.SRACH, 12, 1, 4);
			}
			if (biomeIn == Biomes.MOUNTAIN_EDGE) {
				addSpawnZur(builder, 44, 1);
				addSpawner(builder, ModSpawnerType.SRACH, 12, 1, 4);
			}
			if (biomeIn == Biomes.JUNGLE) {
				addSpawnZur(builder, 42, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.JUNGLE_HILLS) {
				addSpawnZur(builder, 46, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.JUNGLE_EDGE) {
				addSpawnZur(builder, 43, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.DEEP_OCEAN) {
				addSpawnZur(builder, 38, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 13, 1, 5);
			}
			if (biomeIn == Biomes.STONE_SHORE) {
				addSpawnZur(builder, 37, 1);
			}
			if (biomeIn == Biomes.SNOWY_BEACH) {
				addSpawnZur(builder, 33, 1);
			}
			if (biomeIn == Biomes.BIRCH_FOREST) {
				addSpawnZur(builder, 34, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.BIRCH_FOREST_HILLS) {
				addSpawnZur(builder, 36, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.DARK_FOREST) {
				addSpawnZur(builder, 35, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA) {
				addSpawnZur(builder, 38, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_HILLS) {
				addSpawnZur(builder, 40, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA) {
				addSpawnZur(builder, 44, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.GIANT_TREE_TAIGA_HILLS) {
				addSpawnZur(builder, 46, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.WOODED_MOUNTAINS) {
				addSpawnZur(builder, 39, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.SAVANNA) {
				addSpawnZur(builder, 36, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.SAVANNA_PLATEAU) {
				addSpawnZur(builder, 34, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.BADLANDS) {
				addSpawnZur(builder, 37, 1);
			}
			if (biomeIn == Biomes.WOODED_BADLANDS_PLATEAU) {
				addSpawnZur(builder, 43, 1);
			}
			if (biomeIn == Biomes.BADLANDS_PLATEAU) {
				addSpawnZur(builder, 39, 1);
			}
			if (biomeIn == Biomes.SMALL_END_ISLANDS) {
				addSpawnZur(builder);
			}
			if (biomeIn == Biomes.END_MIDLANDS) {
				addSpawnZur(builder);
			}
			if (biomeIn == Biomes.END_HIGHLANDS) {
				addSpawnZur(builder);
			}
			if (biomeIn == Biomes.END_BARRENS) {
				addSpawnZur(builder);
			}
			if (biomeIn == Biomes.WARM_OCEAN) {
				addSpawnZur(builder, 41, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 8, 1, 5);
			}
			if (biomeIn == Biomes.LUKEWARM_OCEAN) {
				addSpawnZur(builder, 38, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 14, 1, 5);
			}
			if (biomeIn == Biomes.COLD_OCEAN) {
				addSpawnZur(builder, 34, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 16, 1, 5);
			}
			if (biomeIn == Biomes.DEEP_WARM_OCEAN) {
				addSpawnZur(builder, 37, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 14, 1, 5);
			}
			if (biomeIn == Biomes.DEEP_LUKEWARM_OCEAN) {
				addSpawnZur(builder, 35, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 15, 1, 5);
			}
			if (biomeIn == Biomes.DEEP_COLD_OCEAN) {
				addSpawnZur(builder, 37, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 16, 1, 5);
			}
			if (biomeIn == Biomes.DEEP_FROZEN_OCEAN) {
				addSpawnZur(builder, 39, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 16, 1, 5);
			}
			if (biomeIn == Biomes.THE_VOID) {
				addSpawnZur(builder);
			}
			if (biomeIn == Biomes.SUNFLOWER_PLAINS) {
				addSpawnZur(builder, 24, 1);
			}
			if (biomeIn == Biomes.DESERT_LAKES) {
				addSpawnZur(builder, 34, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 16, 1, 5);
			}
			if (biomeIn == Biomes.GRAVELLY_MOUNTAINS) {
				addSpawnZur(builder, 28, 1);
			}
			if (biomeIn == Biomes.FLOWER_FOREST) {
				addSpawnZur(builder, 22, 1);
			}
			if (biomeIn == Biomes.TAIGA_MOUNTAINS) {
				addSpawnZur(builder, 29, 1);
			}
			if (biomeIn == Biomes.SWAMP_HILLS) {
				addSpawnZur(builder, 30, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 16, 1, 5);
			}
			if (biomeIn == Biomes.ICE_SPIKES) {
				addSpawnZur(builder, 26, 1);
				addSpawner(builder, WATER_CREATURE, EntityInit.GUBROV.get(), 16, 1, 5);
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE) {
				addSpawnZur(builder, 23, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.MODIFIED_JUNGLE_EDGE) {
				addSpawnZur(builder, 31, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.TALL_BIRCH_FOREST) {
				addSpawnZur(builder, 21, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.TALL_BIRCH_HILLS) {
				addSpawnZur(builder, 23, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.DARK_FOREST_HILLS) {
				addSpawnZur(builder, 27, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.SNOWY_TAIGA_MOUNTAINS) {
				addSpawnZur(builder, 20, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA) {
				addSpawnZur(builder, 30, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.GIANT_SPRUCE_TAIGA_HILLS) {
				addSpawnZur(builder, 32, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.MODIFIED_GRAVELLY_MOUNTAINS) {
				addSpawnZur(builder, 34, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA) {
				addSpawnZur(builder, 37, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.SHATTERED_SAVANNA_PLATEAU) {
				addSpawnZur(builder, 35, 1);
			}
			if (biomeIn == Biomes.ERODED_BADLANDS) {
				addSpawnZur(builder, 33, 1);
				addSpawner(builder, CREATURE, EntityInit.SRACH_ENTITY.get(), 12, 1, 4);
			}
			if (biomeIn == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU) {
				addSpawnZur(builder, 29, 1);
			}
			if (biomeIn == Biomes.MODIFIED_BADLANDS_PLATEAU) {
				addSpawnZur(builder, 31, 1);
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE) {
				addSpawnZur(builder, 33, 1);
			}
			if (biomeIn == Biomes.BAMBOO_JUNGLE_HILLS) {
				addSpawnZur(builder, 26, 1);
			}
			if (biomeIn == Biomes.SOUL_SAND_VALLEY) {
				addSpawnZur(builder, 10, 0, 4);
			}
			if (biomeIn == Biomes.CRIMSON_FOREST) {
				addSpawnZur(builder, 10, 0, 4);
			}
			if (biomeIn == Biomes.WARPED_FOREST) {
				addSpawnZur(builder, 10, 0, 4);
			}
			if (biomeIn == Biomes.BASALT_DELTAS) {
				addSpawnZur(builder, 10, 0, 4);
			}
		}
	}

	public static void generateBlackStone() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
			if (biome == Biomes.THE_END) {
				builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONES, SRIUNK_ORE, 50)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0, 320))));
				builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONES, BLACK_STONE, 20)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 80, 465))));
			}
		}
	}

	public static void addFirgTrees(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG0).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG1).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG2).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG3).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_CONFIG4).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG1).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FirgTree.FIRG_TREE_WITH_MANY_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(5))));
	}

	public static void addFrimTrees(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FrimTree.FRIM_TREE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FrimTree.FRIM_TREE_CONFIG0).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FrimTree.FRIM_TREE_CONFIG1).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FrimTree.FRIM_TREE_WITH_FEW_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.TREE.withConfiguration(FrimTree.FRIM_TREE_WITH_MANY_BEEHIVES_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
	}

	public static void addSparseFrimTrees(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.withConfiguration(FrimTree.FRIM_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.withConfiguration(FrimTree.FRIM_TREE_CONFIG0).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.withConfiguration(FrimTree.FRIM_TREE_CONFIG1).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
	}

	public static void addStones(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLACK_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLUE_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BROWN_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CYAN_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GREEN_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE1_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_GRAY_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIME_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MAGENTA_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ORANGE_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PINK_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PURPLE_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RED_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, WHITE_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, YELLOW_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
	}

	public static void addOres(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, SURVI, 45)).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(30))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RUBY_ORE, 12)).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(8, 16, 64))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, AIR, 8)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(60))));
	}

	public static void addEndStoneOres(BiomeGenerationSettings.Builder builder) {
		ModDefaultBiomeFeatures.addExtraSriunkOre(builder);
	}

	public static void addNaturalEndStone(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONES, END_STONE, 20)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 256))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONES, END_SRACKT, 16)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 204))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONES, END_SRACT, 12)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 154))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONES, END_STONE_CISK, 4)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 51))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONES, END_STONE_CRISK, 2)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 26))));
	}

	public static void addNetherBlocks(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, TRIRIJ, 6)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.MAGMA_BLOCK, TRIRIJ, 16)).withPlacement(Placement.MAGMA.configure(new NoPlacementConfig())));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.TRIRIJ, MAGMA_BLOCK, 8)).withPlacement(Placement.MAGMA.configure(new NoPlacementConfig())));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER, TRIRIJ, 8)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 96))));
	}

	public static void addEndStoneVariants(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONE_VARIANTS, ENDER_SACKT, 16)).withPlacement(Placement.RANGE_BIASED.configure(new TopSolidRangeConfig(0, 0, 256))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONE_VARIANTS, ENDER_SACT, 12)).withPlacement(Placement.RANGE_BIASED.configure(new TopSolidRangeConfig(0, 0, 256))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONE_VARIANTS, ENDER_SRACK, 20)).withPlacement(Placement.RANGE_BIASED.configure(new TopSolidRangeConfig(0, 0, 256))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONE_VARIANTS, ENDER_SRACKH, 28)).withPlacement(Placement.RANGE_BIASED.configure(new TopSolidRangeConfig(0, 0, 256))));
		builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_END_STONE_VARIANTS, ENDER_SRACT, 36)).withPlacement(Placement.RANGE_BIASED.configure(new TopSolidRangeConfig(0, 0, 256))));
	}

	private static void addAcaciaTurgs(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(ACACIA_TURG_PILE_CONFIG).withPlacement(Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(new NoPlacementConfig())));
	}

	private static void addBirchTurgs(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(BIRCH_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
	}

	private static void addDarkOakTurgs(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(DARK_OAK_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(50))));
	}

	private static void addJungleTurgs(BiomeGenerationSettings.Builder builder) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(JUNGLE_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(50))));
	}

	private static void addOakTurgs(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(OAK_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
	}

	private static void addSpruceTurgs(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(SPRUCE_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance)).withPlacement(Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG))));
	}

	private static void addFirgTurgs(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(FIRG_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance)).withPlacement(Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG))));
	}

	private static void addFrimTurgs(BiomeGenerationSettings.Builder builder, int chance) {
		builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BLOCK_PILE.withConfiguration(FRIM_TURG_PILE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance)).withPlacement(Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG))));
	}

	private static void addTrugnInNaturalStone1(BiomeGenerationSettings.Builder builder, int size, int chance) {
		builder.withFeature(Decoration.TOP_LAYER_MODIFICATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_STONES_OVERWORLD, TRUGN, size)).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
	}

	private static void addFirtBlocksInNaturalDirts(BiomeGenerationSettings.Builder builder, int size, int chance) {
		builder.withFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_DIRTS_OVERWORLD, FIRT_BLOCK, size)).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance)).withPlacement(Placement.HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG))));
	}

	private static void addFirtBlocksInTurgs(BiomeGenerationSettings.Builder builder, int size, int chance) {
		builder.withFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_TURGS_OVERWORLD, FIRT_BLOCK, size)).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
	}

	private static void addKaltBlockInTerracottaVariants(BiomeGenerationSettings.Builder builder, int size, int chance) {
		builder.withFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_TERRACOTTA_VARIANTS_OVERWORLD, KALT_BLOCK, size)).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
	}

	private static void addAir1Feature(BiomeGenerationSettings.Builder builder, int size, int chance) {
		builder.withFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(BASE_STONES_OVERWORLD, AIR, size)).withPlacement(Placement.CHANCE.configure(new ChanceConfig(chance))));
	}

	private static void addGenOreFeature(BiomeGenerationSettings.Builder builder, GenerationStage.Decoration decoration, RuleTest ruleTest, BlockState state, int size, ConfiguredPlacement<?> placement) {
		builder.withFeature(decoration, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(ruleTest, state, size)).withPlacement(placement));
	}

	private static void addOreFeature(BiomeGenerationSettings.Builder builder, GenerationStage.Decoration decoration, RuleTest ruleTest, BlockState state, int size, ConfiguredPlacement<?> placement) {
		builder.withFeature(decoration, Feature.ORE.withConfiguration(new OreFeatureConfig(ruleTest, state, size)).withPlacement(placement));
	}

	private static void addFeature(BiomeGenerationSettings.Builder builder, GenerationStage.Decoration decoration, ConfiguredFeature<?, ?> featureIn) {
		builder.withFeature(decoration, featureIn);
	}

	private static void addSpawnZur(MobSpawnInfo.Builder builder) {
		addSpawnZur(builder, 1);
	}

	private static void addSpawnZur(MobSpawnInfo.Builder builder, int weight) {
		addSpawnZur(builder, weight, 0);
	}

	private static void addSpawnZur(MobSpawnInfo.Builder builder, int weight, int minGroupCountIn) {
		addSpawnZur(builder, weight, minGroupCountIn, Math.max(minGroupCountIn, 1));
	}

	private static void addSpawnZur(MobSpawnInfo.Builder builder, int weight, int minGroupCountIn, int maxGroupCountIn) {
		addSpawner(builder, ModSpawnerType.ZUR, weight, minGroupCountIn, maxGroupCountIn);
	}

	private static void addCreatureSpawner(MobSpawnInfo.Builder builder, EntityType<?> entityTypeIn) {
		addSpawner(builder, CREATURE, entityTypeIn);
	}

	private static void addCreatureSpawner(MobSpawnInfo.Builder builder, EntityType<?> entityTypeIn, int weight) {
		addSpawner(builder, CREATURE, entityTypeIn, weight);
	}

	private static void addCreatureSpawner(MobSpawnInfo.Builder builder, EntityType<?> entityTypeIn, int weight, int minGroupCountIn) {
		addSpawner(builder, CREATURE, entityTypeIn, weight, minGroupCountIn);
	}

	private static void addCreatureSpawner(MobSpawnInfo.Builder builder, EntityType<?> entityTypeIn, int weight, int minGroupCountIn, int maxGroupCountIn) {
		addSpawner(builder, CREATURE, entityTypeIn, weight, minGroupCountIn, maxGroupCountIn);
	}

	private static void addSpawner(MobSpawnInfo.Builder builder, ModSpawnerType modSpawnerTypeIn) {
		addSpawner(builder, modSpawnerTypeIn, 1);
	}

	private static void addSpawner(MobSpawnInfo.Builder builder, ModSpawnerType modSpawnerTypeIn, int weight) {
		addSpawner(builder, modSpawnerTypeIn, weight, 0);
	}

	private static void addSpawner(MobSpawnInfo.Builder builder, ModSpawnerType modSpawnerTypeIn, int weight, int minGroupCountIn) {
		addSpawner(builder, modSpawnerTypeIn, weight, minGroupCountIn, 1);
	}

	private static void addSpawner(MobSpawnInfo.Builder builder, ModSpawnerType modSpawnerTypeIn, int weight, int minGroupCountIn, int maxGroupCountIn) {
		builder.withSpawner(modSpawnerTypeIn.classification, new SpawnListEntry(modSpawnerTypeIn.type, weight, minGroupCountIn, maxGroupCountIn));
	}

	private static void addSpawner(MobSpawnInfo.Builder builder, EntityClassification entityClassification, EntityType<?> entityTypeIn) {
		addSpawner(builder, entityClassification, entityTypeIn, 1);
	}

	private static void addSpawner(MobSpawnInfo.Builder builder, EntityClassification entityClassification, EntityType<?> entityTypeIn, int weight) {
		addSpawner(builder, entityClassification, entityTypeIn, weight, 0);
	}

	private static void addSpawner(MobSpawnInfo.Builder builder, EntityClassification entityClassification, EntityType<?> entityTypeIn, int weight, int minGroupCountIn) {
		addSpawner(builder, entityClassification, entityTypeIn, weight, minGroupCountIn, Math.max(minGroupCountIn, 1));
	}

	private static void addSpawner(MobSpawnInfo.Builder builder, EntityClassification entityClassification, EntityType<?> entityTypeIn, int weight, int minGroupCountIn, int maxGroupCountIn) {
		builder.withSpawner(entityClassification, new SpawnListEntry(entityTypeIn, weight, minGroupCountIn, maxGroupCountIn));
	}

	private static void addSpawnCost(MobSpawnInfo.Builder builder, EntityType<?> entityTypeIn, int spawnCostPerEntityIn, int maxSpawnCostIn) {
		builder.withSpawnCost(entityTypeIn, spawnCostPerEntityIn, maxSpawnCostIn);
	}

	static GenerationStage.Decoration decoration1;
	public static final GenerationStage.Decoration decoration = decoration1;
	public GenOreFeatureConfig.FillerBlockType fillerBlockType;

	public static final EntityClassification AMBIENT = EntityClassification.AMBIENT;
	public static final EntityClassification WATER_AMBIENT = EntityClassification.WATER_AMBIENT;
	public static final EntityClassification MISC = EntityClassification.MISC;

	public static native void lok(Feature<?> feature);

	public enum ModSpawnerType {
		GUBROV(EntityClassification.WATER_CREATURE, EntityInit.GUBROV.get()),
		SRACH(EntityClassification.CREATURE, EntityInit.SRACH_ENTITY.get()),
		GWURST(EntityClassification.CREATURE, EntityInit.GWURST.get()),
		FREIN(EntityClassification.MONSTER, EntityInit.FREIN_ENTITY.get()),
		LIWRAY(EntityClassification.CREATURE, EntityInit.LIWRAY.get()),
		ZUR(EntityClassification.CREATURE, EntityInit.ZUR_ENTITY.get());

		private final EntityClassification classification;
		private final EntityType<?> type;

		ModSpawnerType(EntityClassification classification, EntityType<?> type) {
			this.classification = classification;
			this.type = type;
		}

		public EntityClassification getClassification() {
			return classification;
		}

		public EntityType<?> getType() {
			return type;
		}
	}
}
