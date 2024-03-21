package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import com.babcsany.minecraft.ervin_mod_1.world.gen.treedecorator.FirgTreeDecorator;
import com.babcsany.minecraft.init.FeatureInit;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.foliageplacer.*;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.treedecorator.*;
import net.minecraft.world.gen.trunkplacer.*;

import java.util.OptionalInt;

import static net.minecraft.block.Blocks.*;

public class ModDefaultBiomeFeatures {
   private static final BlockState GRASS = Blocks.GRASS.getDefaultState();
   private static final BlockState SOUL_FIRE = Blocks.GRASS.getDefaultState();
   private static final BlockState OBSIDIAN = Blocks.OBSIDIAN.getDefaultState();
   private static final BlockState AIR = Blocks.AIR.getDefaultState();
   private static final BlockState FIRG = BlockInit.FIRG.get().getDefaultState();
   private static final BlockState NIRTKB = isBurnableBlockItemInit.NIRTKB.get().getDefaultState();
   private static final BlockState SCRAFTH = BlockInit.SCRAFTH.get().getDefaultState();
   private static final BlockState GRITH_BLOCK = BlockInit.GRITH_BLOCK.get().getDefaultState();
   private static final BlockState GRINT_BLOCK = BlockInit.GRINT_BLOCK.get().getDefaultState();
   private static final BlockState RED_GRASS_BLOCK = BlockItemInit.RED_GRASS_BLOCK.get().getDefaultState();
   private static final BlockState BARRIER = Blocks.BARRIER.getDefaultState();
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
   private static final BlockState SRIUNK_BLOCK = isBurnableBlockItemInit.SRIUNK_BLOCK.get().getDefaultState();
   private static final BlockState KALT_BLOCK = BlockItemInit.KALT_BLOCK.get().getDefaultState();
   private static final BlockState VILKT_BLOCK = isBurnableBlockItemInit.VILKT_BLOCK.get().getDefaultState();
   private static final BlockState FIRG_LOG = BlockItemInit.FIRG_LOG.get().getDefaultState();
   private static final BlockState FRIM_LOG = BlockItemInit.FRIM_LOG.get().getDefaultState();
   private static final BlockState FIRG_LEAVES = isBurnableBlockItemInit.FIRG_LEAVES.get().getDefaultState();
   private static final BlockState FRIM_LEAVES = BlockItemInit.FRIM_LEAVES.get().getDefaultState();
   private static final BlockState FERN = Blocks.FERN.getDefaultState();
   private static final BlockState PODZOL = Blocks.PODZOL.getDefaultState();
   private static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
   private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
   private static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.getDefaultState();
   private static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();
   private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
   private static final BlockState SPRUCE_LEAVES = Blocks.SPRUCE_LEAVES.getDefaultState();
   private static final BlockState ACACIA_LOG = Blocks.ACACIA_LOG.getDefaultState();
   private static final BlockState ACACIA_LEAVES = Blocks.ACACIA_LEAVES.getDefaultState();
   private static final BlockState BIRCH_LOG = Blocks.BIRCH_LOG.getDefaultState();
   private static final BlockState BIRCH_LEAVES = Blocks.BIRCH_LEAVES.getDefaultState();
   private static final BlockState DARK_OAK_LOG = Blocks.DARK_OAK_LOG.getDefaultState();
   private static final BlockState DARK_OAK_LEAVES = Blocks.DARK_OAK_LEAVES.getDefaultState();
   private static final BlockState WATER = Blocks.WATER.getDefaultState();
   private static final BlockState LAVA = Blocks.LAVA.getDefaultState();
   private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
   private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
   private static final BlockState GRANITE = Blocks.GRANITE.getDefaultState();
   private static final BlockState DIORITE = Blocks.DIORITE.getDefaultState();
   private static final BlockState ANDESITE = Blocks.ANDESITE.getDefaultState();
   private static final BlockState COAL_ORE = Blocks.COAL_ORE.getDefaultState();
   private static final BlockState IRON_ORE = Blocks.IRON_ORE.getDefaultState();
   private static final BlockState BLUE_STONE_IRON_ORE = BlockItemInit.BLUE_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState BROWN_STONE_IRON_ORE = BlockItemInit.BROWN_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState CYAN_STONE_IRON_ORE = BlockItemInit.CYAN_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState GREEN_STONE_IRON_ORE = BlockItemInit.GREEN_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState LIGHT_BLUE_STONE_IRON_ORE = BlockItemInit.LIGHT_BLUE_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState LIGHT_BLUE1_STONE_IRON_ORE = BlockItemInit.LIGHT_BLUE1_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState LIGHT_GRAY_STONE_IRON_ORE = BlockItemInit.LIGHT_GRAY_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState LIME_STONE_IRON_ORE = BlockItemInit.LIME_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState MAGENTA_STONE_IRON_ORE = BlockItemInit.MAGENTA_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState ORANGE_STONE_IRON_ORE = BlockItemInit.ORANGE_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState PINK_STONE_IRON_ORE = BlockItemInit.PINK_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState PURPLE_STONE_IRON_ORE = BlockItemInit.PURPLE_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState RED_STONE_IRON_ORE = BlockItemInit.RED_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState WHITE_STONE_IRON_ORE = BlockItemInit.WHITE_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState YELLOW_STONE_IRON_ORE = BlockItemInit.YELLOW_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_BLACK_IRON_ORE = BlockItemInit.BLACK_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_BLUE_IRON_ORE = BlockItemInit.BLACK_STONE_BLUE_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_BROWN_IRON_ORE = BlockItemInit.BLACK_STONE_BROWN_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_CYAN_IRON_ORE = BlockItemInit.BLACK_STONE_CYAN_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_GRAY_IRON_ORE = BlockItemInit.BLACK_STONE_GRAY_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_GREEN_IRON_ORE = BlockItemInit.BLACK_STONE_GREEN_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_IRON_ORE = BlockItemInit.BLACK_STONE_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_LIGHT_BLUE1_IRON_ORE = BlockItemInit.BLACK_STONE_LIGHT_BLUE1_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_LIGHT_BLUE_IRON_ORE = BlockItemInit.BLACK_STONE_LIGHT_BLUE_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_LIGHT_GRAY_IRON_ORE = BlockItemInit.BLACK_STONE_LIGHT_GRAY_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_LIME_IRON_ORE = BlockItemInit.BLACK_STONE_LIME_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_MAGENTA_IRON_ORE = BlockItemInit.BLACK_STONE_MAGENTA_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_ORANGE_IRON_ORE = BlockItemInit.BLACK_STONE_ORANGE_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_PINK_IRON_ORE = BlockItemInit.BLACK_STONE_PINK_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_PURPLE_IRON_ORE = BlockItemInit.BLACK_STONE_PURPLE_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_RED_IRON_ORE = BlockItemInit.BLACK_STONE_RED_IRON_ORE.get().getDefaultState();
   private static final BlockState BLACK_STONE_YELLOW_IRON_ORE = BlockItemInit.BLACK_STONE_YELLOW_IRON_ORE.get().getDefaultState();
   private static final BlockState BLUE_STONE_BLACK_IRON_ORE = BlockItemInit.BLUE_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState BLUE_STONE_BLUE_IRON_ORE = BlockItemInit.BLUE_STONE_BLUE_IRON_ORE.get().getDefaultState();
   private static final BlockState BROWN_STONE_BLACK_IRON_ORE = BlockItemInit.BROWN_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState CYAN_STONE_BLACK_IRON_ORE = BlockItemInit.CYAN_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState GREEN_STONE_BLACK_IRON_ORE = BlockItemInit.GREEN_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState LIGHT_BLUE_STONE_BLACK_IRON_ORE = BlockItemInit.LIGHT_BLUE_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState LIGHT_BLUE1_STONE_BLACK_IRON_ORE = BlockItemInit.LIGHT_BLUE1_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState LIGHT_GRAY_STONE_BLACK_IRON_ORE = BlockItemInit.LIGHT_GRAY_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState LIME_STONE_BLACK_IRON_ORE = BlockItemInit.LIME_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState MAGENTA_STONE_BLACK_IRON_ORE = BlockItemInit.MAGENTA_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState ORANGE_STONE_BLACK_IRON_ORE = BlockItemInit.ORANGE_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState PINK_STONE_BLACK_IRON_ORE = BlockItemInit.PINK_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState PURPLE_STONE_BLACK_IRON_ORE = BlockItemInit.PURPLE_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState RED_STONE_BLACK_IRON_ORE = BlockItemInit.RED_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState STONE_BLACK_IRON_ORE = BlockItemInit.STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState WHITE_STONE_BLACK_IRON_ORE = BlockItemInit.WHITE_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState YELLOW_STONE_BLACK_IRON_ORE = BlockItemInit.YELLOW_STONE_BLACK_IRON_ORE.get().getDefaultState();
   private static final BlockState RUBY_ORE = BlockItemInit.RUBY_ORE.get().getDefaultState();
   private static final BlockState GOLD_ORE = Blocks.GOLD_ORE.getDefaultState();
   private static final BlockState REDSTONE_ORE = Blocks.REDSTONE_ORE.getDefaultState();
   private static final BlockState DIAMOND_ORE = Blocks.DIAMOND_ORE.getDefaultState();
   private static final BlockState LAPIS_ORE = Blocks.LAPIS_ORE.getDefaultState();
   private static final BlockState STONE = Blocks.STONE.getDefaultState();
   private static final BlockState EMERALD_ORE = Blocks.EMERALD_ORE.getDefaultState();
   private static final BlockState INFESTED_STONE = Blocks.INFESTED_STONE.getDefaultState();
   private static final BlockState SAND = Blocks.SAND.getDefaultState();
   private static final BlockState CLAY = Blocks.CLAY.getDefaultState();
   private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
   private static final BlockState MOSSY_COBBLESTONE = Blocks.MOSSY_COBBLESTONE.getDefaultState();
   private static final BlockState LARGE_FERN = Blocks.LARGE_FERN.getDefaultState();
   private static final BlockState TALL_GRASS = Blocks.TALL_GRASS.getDefaultState();
   private static final BlockState LILAC = Blocks.LILAC.getDefaultState();
   private static final BlockState ROSE_BUSH = Blocks.ROSE_BUSH.getDefaultState();
   private static final BlockState PEONY = Blocks.PEONY.getDefaultState();
   private static final BlockState BROWN_MUSHROOM = Blocks.BROWN_MUSHROOM.getDefaultState();
   private static final BlockState RED_MUSHROOM = Blocks.RED_MUSHROOM.getDefaultState();
   private static final BlockState GRINTH_MUSHROOM = BlockItemInit.GRINTH_MUSHROOM.get().getDefaultState();
   private static final BlockState SEAGRASS = Blocks.SEAGRASS.getDefaultState();
   private static final BlockState PACKED_ICE = Blocks.PACKED_ICE.getDefaultState();
   private static final BlockState BLUE_ICE = Blocks.BLUE_ICE.getDefaultState();
   private static final BlockState LILY_OF_THE_VALLEY = Blocks.LILY_OF_THE_VALLEY.getDefaultState();
   private static final BlockState BLUE_ORCHID = Blocks.BLUE_ORCHID.getDefaultState();
   private static final BlockState POPPY = Blocks.POPPY.getDefaultState();
   private static final BlockState DANDELION = Blocks.DANDELION.getDefaultState();
   private static final BlockState DEAD_BUSH = Blocks.DEAD_BUSH.getDefaultState();
   private static final BlockState MELON = Blocks.MELON.getDefaultState();
   private static final BlockState PUMPKIN = Blocks.PUMPKIN.getDefaultState();
   private static final BlockState SWEET_BERRY_BUSH = Blocks.SWEET_BERRY_BUSH.getDefaultState().with(SweetBerryBushBlock.AGE, Integer.valueOf(3));
   private static final BlockState FIRE = Blocks.FIRE.getDefaultState();
   private static final BlockState NETHERRACK = Blocks.NETHERRACK.getDefaultState();
   private static final BlockState LILY_PAD = Blocks.LILY_PAD.getDefaultState();
   private static final BlockState SNOW = Blocks.SNOW.getDefaultState();
   private static final BlockState JACK_O_LATERN = Blocks.JACK_O_LANTERN.getDefaultState();
   private static final BlockState SUNFLOWER = Blocks.SUNFLOWER.getDefaultState();
   private static final BlockState CACTUS = Blocks.CACTUS.getDefaultState();
   private static final BlockState SUGAR_CANE = Blocks.SUGAR_CANE.getDefaultState();
   public static final StructureFeature<MineshaftConfig, ? extends Structure<MineshaftConfig>> MINESHAFT_NORMAL = Structure.MINESHAFT.withConfiguration(new MineshaftConfig(0.004F, MineshaftStructure.Type.NORMAL));
   public static final StructureFeature<MineshaftConfig, ? extends Structure<MineshaftConfig>> MINESHAFT_MESA = Structure.MINESHAFT.withConfiguration(new MineshaftConfig(0.004F, MineshaftStructure.Type.MESA));
   public static final StructureFeature<ShipwreckConfig, ? extends Structure<ShipwreckConfig>> SHIPWRECK = Structure.SHIPWRECK.withConfiguration(new ShipwreckConfig(false));
   public static final StructureFeature<RuinedPortalFeature, ? extends Structure<RuinedPortalFeature>> RUINED_PORTAL = Structure.RUINED_PORTAL.withConfiguration(new RuinedPortalFeature(RuinedPortalStructure.Location.DESERT));
   public static final StructureFeature<NoFeatureConfig, ? extends Structure<NoFeatureConfig>> STRONGHOLD = Structure.STRONGHOLD.withConfiguration(NoFeatureConfig.INSTANCE);
   public static final StructureFeature<ProbabilityConfig, ? extends Structure<ProbabilityConfig>> BURIED_TREASURE = Structure.BURIED_TREASURE.withConfiguration(new ProbabilityConfig(0.01F));
   private static final BlockState RED_MUSHROOM_BLOCK = Blocks.RED_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.DOWN, Boolean.FALSE);
   private static final BlockState GRINTH_MUSHROOM_BLOCK = BlockItemInit.GRINTH_MUSHROOM_BLOCK.get().getDefaultState().with(HugeMushroomBlock.DOWN, Boolean.FALSE);
   private static final BlockState BROWN_MUSHROOM_BLOCK = Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.UP, Boolean.TRUE).with(HugeMushroomBlock.DOWN, Boolean.FALSE);
   private static final BlockState MUSHROOM_STEM = Blocks.MUSHROOM_STEM.getDefaultState().with(HugeMushroomBlock.UP, Boolean.FALSE).with(HugeMushroomBlock.DOWN, Boolean.FALSE);
   public static final BaseTreeFeatureConfig OAK_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(0, 0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
   private static final BeehiveTreeDecorator FEW_BEEHIVES = new BeehiveTreeDecorator(0.002F);
   private static final BeehiveTreeDecorator BEEHIVES = new BeehiveTreeDecorator(0.02F);
   private static final BeehiveTreeDecorator BEEHIVES1 = new BeehiveTreeDecorator(0.5F);
   private static final BeehiveTreeDecorator BEEHIVES2 = new BeehiveTreeDecorator(5.0F);
   private static final FirgTreeDecorator FIRGS = new FirgTreeDecorator(5.0F);
   private static final BeehiveTreeDecorator MANY_BEEHIVES = new BeehiveTreeDecorator(0.05F);
   public static final BaseTreeFeatureConfig OAK_TREE_WITH_MORE_BEEHIVES_CONFIG = OAK_TREE_CONFIG.copy(ImmutableList.of(MANY_BEEHIVES));
   public static final BaseTreeFeatureConfig OAK_TREE_WITH_FEW_BEEHIVES_CONFIG = OAK_TREE_CONFIG.copy(ImmutableList.of(FEW_BEEHIVES));
   public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG1 = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FIRG_LOG), new SimpleBlockStateProvider(FIRG_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(4, 0), FeatureSpread.create(0, 0), 2), new StraightTrunkPlacer(3, 5, 2), new TwoLayerFeature(6, 2, 4))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FIRG_LOG), new SimpleBlockStateProvider(FIRG_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(6, 0), FeatureSpread.create(0, 0), 2), new StraightTrunkPlacer(1, 6, 3), new TwoLayerFeature(4, 5, 3))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG2 = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FIRG_LOG), new SimpleBlockStateProvider(FIRG), new BlobFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(0, 0), 2), new StraightTrunkPlacer(3, 4, 2), new TwoLayerFeature(4, 0, 3))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG3 = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FIRG_LOG), new SimpleBlockStateProvider(FIRG), new BlobFoliagePlacer(FeatureSpread.create(5, 0), FeatureSpread.create(0, 0), 3), new StraightTrunkPlacer(5, 3, 6), new TwoLayerFeature(2, 1, 3))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig JUNGLE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(JUNGLE_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(0, 0), 3), new StraightTrunkPlacer(4, 8, 0), new TwoLayerFeature(1, 0, 1))).setDecorators(ImmutableList.of(new CocoaTreeDecorator(0.2F), TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.field_236871_b_)).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig JUNGLE_SAPLING_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(JUNGLE_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(0, 0), 3), new StraightTrunkPlacer(4, 8, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig PINE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new PineFoliagePlacer(FeatureSpread.create(1, 0), FeatureSpread.create(1, 0), FeatureSpread.create(3, 1)), new StraightTrunkPlacer(6, 4, 0), new TwoLayerFeature(2, 0, 2))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig SPRUCE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new SpruceFoliagePlacer(FeatureSpread.create(2, 1), FeatureSpread.create(0, 2), FeatureSpread.create(1, 1)), new StraightTrunkPlacer(5, 2, 1), new TwoLayerFeature(2, 0, 2))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig ACACIA_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ACACIA_LOG), new SimpleBlockStateProvider(ACACIA_LEAVES), new AcaciaFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(0, 0)), new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 2))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig BIRCH_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(0, 0), 3), new StraightTrunkPlacer(5, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig FRIM_TREE_CONFIG1 = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FRIM_LOG), new SimpleBlockStateProvider(FRIM_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(3, 1), FeatureSpread.create(2, 5), 4), new StraightTrunkPlacer(1, 3, 5), new TwoLayerFeature(5, 3, 6))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig FRIM_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FRIM_LOG), new SimpleBlockStateProvider(FRIM_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(3, 0), FeatureSpread.create(0, 0), 4), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig BIRCH_TREE_WITH_FEW_BEEHIVES_CONFIG = BIRCH_TREE_CONFIG.copy(ImmutableList.of(FEW_BEEHIVES));
   public static final BaseTreeFeatureConfig BIRCH_TREE_WITH_BEEHIVES_CONFIG = BIRCH_TREE_CONFIG.copy(ImmutableList.of(BEEHIVES));
   public static final BaseTreeFeatureConfig BIRCH_TREE_CONFIG_CLASH = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(0, 0), 3), new StraightTrunkPlacer(5, 2, 6), new TwoLayerFeature(1, 0, 1))).setIgnoreVines().setDecorators(ImmutableList.of(FEW_BEEHIVES)).build();
   public static final BaseTreeFeatureConfig SWAMP_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(3, 0), FeatureSpread.create(0, 0), 3), new StraightTrunkPlacer(5, 3, 0), new TwoLayerFeature(1, 0, 1))).setMaxWaterDepth(1).setDecorators(ImmutableList.of(LeaveVineTreeDecorator.field_236871_b_)).build();
   public static final BaseTreeFeatureConfig FANCY_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new FancyFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(4, 0), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build();
   public static final BaseTreeFeatureConfig FRIM_TREE_CONFIG0 = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FRIM_LOG), new SimpleBlockStateProvider(FRIM_LEAVES), new FancyFoliagePlacer(FeatureSpread.create(1, 2), FeatureSpread.create(5, 3), 6), new FancyTrunkPlacer(4, 9, 11), new TwoLayerFeature(7, 4, 12, OptionalInt.of(9)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build();
   public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG0 = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FIRG_LOG), new SimpleBlockStateProvider(FIRG_LEAVES), new FancyFoliagePlacer(FeatureSpread.create(4, 3), FeatureSpread.create(1, 5), 2), new FancyTrunkPlacer(8, 2, 6), new TwoLayerFeature(13, 11, 5, OptionalInt.of(2)))).setIgnoreVines().setHeightmap(Heightmap.Type.MOTION_BLOCKING).build();
   public static final BaseTreeFeatureConfig FANCY_TREE_WITH_FEW_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.copy(ImmutableList.of(FEW_BEEHIVES));
   public static final BaseTreeFeatureConfig FANCY_TREE_WITH_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.copy(ImmutableList.of(BEEHIVES));
   public static final BaseTreeFeatureConfig FANCY_TREE_WITH_MORE_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.copy(ImmutableList.of(MANY_BEEHIVES));
   public static final BaseTreeFeatureConfig FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1 = FANCY_TREE_CONFIG.copy(ImmutableList.of(BEEHIVES1));
   public static final BaseTreeFeatureConfig FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.copy(ImmutableList.of(BEEHIVES1));
   public static final BaseTreeFeatureConfig FRIM_TREE_WITH_FEW_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.copy(ImmutableList.of(FEW_BEEHIVES));
   public static final BaseTreeFeatureConfig FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.copy(ImmutableList.of(BEEHIVES));
   public static final BaseTreeFeatureConfig FRIM_TREE_WITH_MANY_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.copy(ImmutableList.of(BEEHIVES1));
   public static final BaseTreeFeatureConfig FIRG_TREE_WITH_MANY_BEEHIVES_CONFIG = FANCY_TREE_CONFIG.copy(ImmutableList.of(BEEHIVES2));
   public static final BaseTreeFeatureConfig FIRG_TREE_WITH_MORE_FIRGS_CONFIG = FANCY_TREE_CONFIG.copy(ImmutableList.of(FIRGS));
   public static final BaseTreeFeatureConfig FIRG_TREE_WITH_MORE_FIRGS_CONFIG1 = FIRG_TREE_CONFIG.copy(ImmutableList.of(FIRGS));
   public static final BaseTreeFeatureConfig field_230133_o_ = FANCY_TREE_CONFIG.copy(ImmutableList.of(FEW_BEEHIVES));
   public static final BaseTreeFeatureConfig field_230133_p_ = FANCY_TREE_CONFIG.copy(ImmutableList.of(BEEHIVES));
   public static final BaseTreeFeatureConfig field_230134_q_ = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(0, 0),FeatureSpread.create(4, 0), 0), new StraightTrunkPlacer(1, 2, 3), new TwoLayerFeature(3, 2, 1))).setIgnoreVines().setDecorators(ImmutableList.of(BEEHIVES)).build();
   public static final BaseTreeFeatureConfig field_230134_r_ = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(2, 0),FeatureSpread.create(6, 4), 0), new StraightTrunkPlacer(3, 5, 2), new TwoLayerFeature(6, 0, 1))).setIgnoreVines().setDecorators(ImmutableList.of(MANY_BEEHIVES)).build();
   public static final BaseTreeFeatureConfig field_230136_s_ = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new MegaPineFoliagePlacer(FeatureSpread.create(2, 6), FeatureSpread.create(4, 3), FeatureSpread.create(5, 1)), new GiantTrunkPlacer(4, 5, 6), new ThreeLayerFeature(5, 6, 7, 3, 2, OptionalInt.empty()))).setDecorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.field_236871_b_)).build();
   public static final BaseTreeFeatureConfig FRIM_GROUND_BUSH_CONFIG_WITH_FEW_BEEHIVES = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FRIM_LOG), new SimpleBlockStateProvider(FRIM_LEAVES), new BlobFoliagePlacer(FeatureSpread.create(1, 0), FeatureSpread.create(0, 0), 3), new StraightTrunkPlacer(5, 2, 6), new TwoLayerFeature(4, 1, 5))).setIgnoreVines().setDecorators(ImmutableList.of(FEW_BEEHIVES)).build();
   public static final BaseTreeFeatureConfig JUNGLE_GROUND_BUSH_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BushFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(1, 0), 2), new StraightTrunkPlacer(1, 0, 0), new TwoLayerFeature(0, 0, 0))).setHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build();
   public static final BaseTreeFeatureConfig FRIM_GROUND_BUSH_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FRIM_LOG), new SimpleBlockStateProvider(FRIM_LEAVES), new BushFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(1, 0), 2), new StraightTrunkPlacer(1, 0, 0), new TwoLayerFeature(0, 0, 0))).setHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build();
   public static final BaseTreeFeatureConfig DARK_OAK_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(DARK_OAK_LOG), new SimpleBlockStateProvider(DARK_OAK_LEAVES), new DarkOakFoliagePlacer(FeatureSpread.create(0, 0), FeatureSpread.create(0, 0)), new DarkOakTrunkPlacer(6, 2, 1), new ThreeLayerFeature(1, 1, 0, 1, 2, OptionalInt.empty()))).setMaxWaterDepth(Integer.MAX_VALUE).setHeightmap(Heightmap.Type.MOTION_BLOCKING).setIgnoreVines().build();
   public static final BaseTreeFeatureConfig MEGA_SPRUCE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new MegaPineFoliagePlacer(FeatureSpread.create(0, 0), FeatureSpread.create(0, 0), FeatureSpread.create(4, 13)), new GiantTrunkPlacer(13, 2, 14), new TwoLayerFeature(1, 1, 2))).setDecorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL)))).build();
   public static final BaseTreeFeatureConfig MEGA_PINE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new MegaPineFoliagePlacer(FeatureSpread.create(0, 0), FeatureSpread.create(0, 0), FeatureSpread.create(4, 3)), new GiantTrunkPlacer(13, 2, 14), new TwoLayerFeature(1, 1, 2))).setDecorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(PODZOL)))).build();
   public static final BaseTreeFeatureConfig MEGA_FIRG_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(FIRG_LOG), new SimpleBlockStateProvider(FIRG), new MegaPineFoliagePlacer(FeatureSpread.create(1, 3), FeatureSpread.create(2, 6), FeatureSpread.create(4, 3)), new GiantTrunkPlacer(13, 8, 14), new TwoLayerFeature(2, 4, 3))).setDecorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(RED_GRASS_BLOCK)))).build();
   public static final BaseTreeFeatureConfig MEGA_JUNGLE_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(JUNGLE_LEAVES), new JungleFoliagePlacer(FeatureSpread.create(2, 0), FeatureSpread.create(0, 0), 2), new MegaJungleTrunkPlacer(10, 2, 19), new TwoLayerFeature(1, 1, 2))).setDecorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, LeaveVineTreeDecorator.field_236871_b_)).build();
   public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS), new SimpleBlockPlacer())).tries(32).build();
   public static final BlockClusterFeatureConfig TAIGA_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(GRASS, 1).addWeightedBlockstate(FERN, 4), SimpleBlockPlacer.PLACER)).tries(32).build();
   public static final BlockClusterFeatureConfig LUSH_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(GRASS, 3).addWeightedBlockstate(FERN, 1), SimpleBlockPlacer.PLACER)).blacklist(ImmutableSet.of(PODZOL)).tries(32).build();
   public static final BlockClusterFeatureConfig LILY_OF_THE_VALLEY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILY_OF_THE_VALLEY), SimpleBlockPlacer.PLACER)).tries(64).build();
   public static final BlockClusterFeatureConfig BLUE_ORCHID_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BLUE_ORCHID), new SimpleBlockPlacer())).tries(64).build();
   public static final BlockClusterFeatureConfig DEFAULT_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(POPPY, 2).addWeightedBlockstate(DANDELION, 1), SimpleBlockPlacer.PLACER)).tries(64).build();
   public static final BlockClusterFeatureConfig PLAINS_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new PlainFlowerBlockStateProvider(), new SimpleBlockPlacer())).tries(64).build();
   public static final BlockClusterFeatureConfig FOREST_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new ForestFlowerBlockStateProvider(), new SimpleBlockPlacer())).tries(64).build();
   public static final BlockClusterFeatureConfig DEAD_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DEAD_BUSH), new SimpleBlockPlacer())).tries(4).build();
   public static final BlockClusterFeatureConfig MELON_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MELON), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(GRASS_BLOCK.getBlock())).replaceable().replaceable().build();
   public static final BlockClusterFeatureConfig PUMPKIN_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PUMPKIN), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(GRASS_BLOCK.getBlock())).replaceable().build();
   public static final BlockClusterFeatureConfig SWEET_BERRY_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SWEET_BERRY_BUSH), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(GRASS_BLOCK.getBlock())).replaceable().build();
   public static final BlockClusterFeatureConfig NETHER_FIRE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(FIRE), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(NETHERRACK.getBlock())).replaceable().build();
   public static final BlockClusterFeatureConfig LILY_PAD_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILY_PAD), new SimpleBlockPlacer())).tries(10).build();
   public static final BlockClusterFeatureConfig RED_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RED_MUSHROOM), new SimpleBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig GRINTH_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SCRAFTH), new SimpleBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig SCRAFTH_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SCRAFTH), new SimpleBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig BROWN_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BROWN_MUSHROOM), new SimpleBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig LILAC_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILAC), new DoublePlantBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig NETHER_SOUL_FIRE = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SOUL_FIRE), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(SOUL_SOIL.getBlock())).replaceable().build();
   public static final BlockClusterFeatureConfig ROSE_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ROSE_BUSH), new DoublePlantBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig PEONY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PEONY), new DoublePlantBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig SUNFLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SUNFLOWER), new DoublePlantBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig TALL_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_GRASS), new DoublePlantBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig LARGE_FERN_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LARGE_FERN), new DoublePlantBlockPlacer())).tries(64).replaceable().build();
   public static final BlockClusterFeatureConfig CACTUS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CACTUS), new ColumnBlockPlacer(1, 2))).tries(10).replaceable().build();
   public static final BlockClusterFeatureConfig SUGAR_CANE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(SUGAR_CANE), new ColumnBlockPlacer(2, 2))).tries(20).xSpread(4).ySpread(0).zSpread(4).replaceable().requiresWater().build();
   public static final BlockStateProvidingFeatureConfig HAY_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new AxisRotatingBlockStateProvider(Blocks.HAY_BLOCK));
   public static final BlockStateProvidingFeatureConfig SRIUNK_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(SRIUNK_BLOCK));
   public static final BlockStateProvidingFeatureConfig SNOW_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(SNOW));
   public static final BlockStateProvidingFeatureConfig MELON_PILE_CONFIG = new BlockStateProvidingFeatureConfig(new SimpleBlockStateProvider(MELON));
   public static final BlockStateProvidingFeatureConfig PUMPKIN_PILE_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(PUMPKIN, 19).addWeightedBlockstate(JACK_O_LATERN, 1));
   public static final BlockStateProvidingFeatureConfig SRIUNK_PILE_CONFIG1 = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(SRIUNK_BLOCK, 19).addWeightedBlockstate(BARRIER, 1));
   public static final BlockStateProvidingFeatureConfig BLUE_ICE_PILE_CONFIG = new BlockStateProvidingFeatureConfig((new WeightedBlockStateProvider()).addWeightedBlockstate(BLUE_ICE, 1).addWeightedBlockstate(PACKED_ICE, 5));
   public static final LiquidsConfig WATER_SPRING_CONFIG = new LiquidsConfig(Fluids.WATER.getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE));
   public static final LiquidsConfig WATER1_SPRING_CONFIG = new LiquidsConfig(Fluids.WATER.getDefaultState(), true, 20, 12, ImmutableSet.of(BlockItemInit.BLACK_STONE.get(), BlockItemInit.BLUE_STONE.get(), BlockItemInit.BROWN_STONE.get(), BlockItemInit.CYAN_STONE.get(), BlockItemInit.GREEN_STONE.get(), BlockItemInit.LIGHT_BLUE_STONE.get(), BlockItemInit.LIGHT_BLUE1_STONE.get(), BlockItemInit.LIGHT_GRAY_STONE.get(), BlockItemInit.LIME_STONE.get(), BlockItemInit.MAGENTA_STONE.get(), BlockItemInit.ORANGE_STONE.get(), BlockItemInit.PINK_STONE.get(), BlockItemInit.PURPLE_STONE.get(), BlockItemInit.RED_STONE.get(), BlockItemInit.WHITE_STONE.get(), BlockItemInit.YELLOW_STONE.get(), Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE));
   public static final LiquidsConfig LAVA_SPRING_CONFIG = new LiquidsConfig(Fluids.LAVA.getDefaultState(), true, 4, 1, ImmutableSet.of(Blocks.STONE, Blocks.GRANITE, Blocks.DIORITE, Blocks.ANDESITE));
   public static final LiquidsConfig NETHER_SPRING_CONFIG = new LiquidsConfig(Fluids.LAVA.getDefaultState(), false, 4, 1, ImmutableSet.of(Blocks.NETHERRACK));
   public static final LiquidsConfig ENCLOSED_NETHER_SPRING_CONFIG = new LiquidsConfig(Fluids.LAVA.getDefaultState(), false, 5, 0, ImmutableSet.of(Blocks.NETHERRACK));
   public static final BigMushroomFeatureConfig BIG_RED_MUSHROOM = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(RED_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 2);
   public static final BigMushroomFeatureConfig BIG_GRINTH_MUSHROOM = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(GRINTH_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 2);
   public static final BigMushroomFeatureConfig BIG_SCRAFTH_MUSHROOM = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(SCRAFTH), new SimpleBlockStateProvider(GRINT_BLOCK), 4);
   public static final BigMushroomFeatureConfig BIG_SCRAFTH_MUSHROOM1 = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(SCRAFTH), new SimpleBlockStateProvider(GRINT_BLOCK), 40);
   public static final BigMushroomFeatureConfig BIG_FIRG_MUSHROOM = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(FIRG), new SimpleBlockStateProvider(GRINT_BLOCK), 16);
   public static final BigMushroomFeatureConfig BIG_BROWN_MUSHROOM = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(BROWN_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 3);


   public static void addLakes(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
      builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(LAVA)).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
   }

   public static void addWaterLakes(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(40))));
   }

   public static void addDesertLakes(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(LAVA)).withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));
   }

   public static void addStoneVariants(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, DIRT, 33)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 256))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GRAVEL, 33)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 256))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GRANITE, 33)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 80))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, DIORITE, 33)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 80))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ANDESITE, 33)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 80))));
   }

   public static void addEndStoneVariants(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, END_STONE, 20)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, END_SRACKT, 16)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, END_SRACT, 12)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, END_STONE_CISK, 4)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, END_STONE_CRISK, 2)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, ENDER_SACKT, 8)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, ENDER_SACT, 6)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, ENDER_SRACK, 10)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, ENDER_SRACKH, 14)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_END_STONES, ENDER_SRACT, 18)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
   }

   public static void addFirgs(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, FIRG, 400)).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(0, 0, 2000))));
   }

   public static void addNirtkb(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, NIRTKB, 400)).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(0, 0, 2000))));
   }

   public static void addNirtkb1(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, NIRTKB, 100)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 2000))));
   }

   public static void addScrafth(BiomeGenerationSettings.Builder builder) {
      addScrafth(builder, 400, 0, 0, 2000);
   }

   public static void addScrafth(BiomeGenerationSettings.Builder builder, int size, int bottomOffset, int topOffset, int maximum) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, SCRAFTH, size)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(bottomOffset, topOffset, maximum))));
   }

   public static void addOrangeStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ORANGE_STONE, 400)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 2000))));
   }

   public static void addBlueStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLUE_STONE, 400)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 2000))));
   }

   public static void addStones(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLACK_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig( 0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLUE_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BROWN_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig( 0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CYAN_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GREEN_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig( 0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE1_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_GRAY_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIME_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MAGENTA_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ORANGE_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PINK_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PURPLE_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RED_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, WHITE_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, YELLOW_STONE, 40)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 320))));
   }

   public static void addOres(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, COAL_ORE, 17)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(20, 0, 128))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(20, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GOLD_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 32))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, REDSTONE_ORE, 8)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 16))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, DIAMOND_ORE, 8)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 16))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LAPIS_ORE, 7)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(FeatureSpread.create(1, 16)))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RUBY_ORE, 6)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(FeatureSpread.create(2, 32)))));
   }

   public static void addOrangeStoneOres(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_ORANGE_STONE_OVERWORLD, COAL_ORE, 17)).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(128))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_ORANGE_STONE_OVERWORLD, ORANGE_STONE_IRON_ORE, 9)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_ORANGE_STONE_OVERWORLD, GOLD_ORE, 9)).withPlacement(Placement.RANGE_VERY_BIASED.configure(new TopSolidRangeConfig(0, 0, 15))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_ORANGE_STONE_OVERWORLD, REDSTONE_ORE, 8)).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(20))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_ORANGE_STONE_OVERWORLD, DIAMOND_ORE, 8)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 16))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_ORANGE_STONE_OVERWORLD, LAPIS_ORE, 7)).withPlacement(Placement.RANGE_BIASED.configure(new TopSolidRangeConfig(1, 16, 16))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.BASE_ORANGE_STONE_OVERWORLD, RUBY_ORE, 6)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 32, 32))));
   }

   public static void addBlackIronOres(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLACK_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLUE_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BROWN_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CYAN_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GREEN_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE1_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_GRAY_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIME_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MAGENTA_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ORANGE_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PINK_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PURPLE_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RED_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, WHITE_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, YELLOW_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(0, 0, 64))));
   }

   public static void addBlueIronOres(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLACK_STONE_BLUE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLUE_STONE_BLUE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BROWN_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CYAN_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GREEN_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE1_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_GRAY_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIME_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MAGENTA_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ORANGE_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PINK_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PURPLE_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RED_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, WHITE_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, YELLOW_STONE_BLACK_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
   }

   public static void addIronOres(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLACK_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLUE_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BROWN_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CYAN_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GREEN_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE1_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_GRAY_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIME_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MAGENTA_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ORANGE_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PINK_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PURPLE_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RED_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, WHITE_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, YELLOW_STONE_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
   }

   public static void addRedIronOres(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLACK_STONE_RED_IRON_ORE, 9)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))));
   }

   public static void addExtraGoldOre(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GOLD_ORE, 9)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(32, 32, 80))));
   }

   public static void addExtraDiamondOre(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, DIAMOND_ORE, 9)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 1, 32))));
   }

   public static void addExtraBlackStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLACK_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraBlueStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BLUE_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraBrownStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BROWN_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraCyanStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, CYAN_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraGreenStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, GREEN_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraLightBlueStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_BLUE_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraLightGrayStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIGHT_GRAY_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraLimeStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, LIME_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraMagentaStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, MAGENTA_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraOrangeStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ORANGE_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraPinkStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PINK_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraPurpleStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, PURPLE_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraRedStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RED_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraWhiteStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, WHITE_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraYellowStone(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, YELLOW_STONE, 30)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(320, 320, 800))));
   }

   public static void addExtraEmeraldOre(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(STONE, EMERALD_ORE)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraDirt(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(FIRG, DIRT)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addSriunkOre(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(END_STONE, SRIUNK_ORE)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraSriunkOre(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.END_STONE, SRIUNK_ORE, 12)).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0, 115))));
   }

   public static void addExtraKaltBlock(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(END_STONE, KALT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock1(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(BLACK_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock2(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(BLUE_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock3(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(BROWN_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock4(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(CYAN_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock5(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(GREEN_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock6(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(LIGHT_BLUE_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock7(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(LIGHT_GRAY_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock8(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(LIME_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock9(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(MAGENTA_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock10(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(ORANGE_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock11(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(PINK_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock12(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(PURPLE_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock13(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(RED_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock14(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(WHITE_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addExtraVilktBlock15(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(YELLOW_STONE, VILKT_BLOCK)).withPlacement(Placement.EMERALD_ORE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addEmeraldOreFeature(BiomeGenerationSettings.Builder builder, GenerationStage.Decoration decorationStageIn, BlockState target, BlockState state, ConfiguredPlacement<?> placement) {
      builder.withFeature(decorationStageIn, Feature.EMERALD_ORE.withConfiguration(new ReplaceBlockConfig(target, state)).withPlacement(placement));
   }

   private static void addOreFeature(BiomeGenerationSettings.Builder builder, GenerationStage.Decoration decoration, RuleTest ruleTest, BlockState state, int size, ConfiguredPlacement<?> placement) {
      builder.withFeature(decoration, Feature.ORE.withConfiguration(new OreFeatureConfig(ruleTest, state, size)).withPlacement(placement));
   }

   public static void addFeature(BiomeGenerationSettings.Builder builder, GenerationStage.Decoration decorationStageIn, ConfiguredFeature<?, ?> featureIn) {
      builder.withFeature(decorationStageIn, featureIn);
   }

   public static void addInfestedStone(BiomeGenerationSettings.Builder builder) {
      addOreFeature(builder, GenerationStage.Decoration.UNDERGROUND_DECORATION, OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, INFESTED_STONE, 9, Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0, 64)));
   }

   public static void addSedimentDisks(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(SAND, FeatureSpread.create(7), 2, Lists.newArrayList(DIRT, GRASS_BLOCK))).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(3, 7, 4))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(CLAY, FeatureSpread.create(4), 1, Lists.newArrayList(DIRT, CLAY))).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(1, 9, 5))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(GRAVEL, FeatureSpread.create(6), 2, Lists.newArrayList(DIRT, GRASS_BLOCK))).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(1, 0, 14))));
   }

   public static void addSwampClayDisks(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(CLAY, FeatureSpread.create(4, 7), 1, Lists.newArrayList(DIRT, CLAY))).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addTaigaRocks(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(MOSSY_COBBLESTONE)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(4, 3, 8))));
   }

   public static void addTaigaLargeFerns(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LARGE_FERN_CONFIG).withPlacement(Placement.SPREAD_32_ABOVE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addSparseBerryBushes(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SWEET_BERRY_BUSH_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(12))).withPlacement(Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addBerryBushes(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SWEET_BERRY_BUSH_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(1))).withPlacement(Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addBamboo(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.01F)).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(16))).withPlacement(Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addBambooJungleVegetation(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.2F)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(6, 85, 43))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.05F), Feature.TREE.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.15F), Feature.TREE.withConfiguration(MEGA_JUNGLE_TREE_CONFIG).withChance(0.7F)), Feature.RANDOM_PATCH.withConfiguration(LUSH_GRASS_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(30, 0.1F, 1))));
   }

   public static void addTaigaConifers(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(PINE_TREE_CONFIG).withChance(0.33333334F)), Feature.TREE.withConfiguration(SPRUCE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addScatteredOakTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F)), Feature.TREE.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
   }

   public static void addBirchTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.withConfiguration(BIRCH_TREE_WITH_FEW_BEEHIVES_CONFIG).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addForestTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(BIRCH_TREE_WITH_FEW_BEEHIVES_CONFIG).withChance(0.2F), Feature.TREE.withConfiguration(FANCY_TREE_WITH_FEW_BEEHIVES_CONFIG).withChance(0.1F)), Feature.TREE.withConfiguration(OAK_TREE_WITH_FEW_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addFrimTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FRIM_TREE_WITH_FEW_BEEHIVES_CONFIG).withChance(0.2F), Feature.TREE.withConfiguration(FANCY_TREE_WITH_FEW_BEEHIVES_CONFIG).withChance(0.1F)), Feature.TREE.withConfiguration(OAK_TREE_WITH_FEW_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(20, 1.0F, 2))));
   }

   public static void addFirgTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FIRG_TREE_CONFIG).withChance(10.0F), Feature.TREE.withConfiguration(FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG).withChance(5.0F)), Feature.TREE.withConfiguration(FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(50, 5.0F, 10))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FIRG_TREE_CONFIG1).withChance(10.0F), Feature.TREE.withConfiguration(FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1).withChance(5.0F)), Feature.TREE.withConfiguration(FIRG_TREE_WITH_MANY_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(50, 5.0F, 10))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FIRG_TREE_CONFIG2).withChance(10.0F), Feature.TREE.withConfiguration(FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG).withChance(5.0F)), Feature.TREE.withConfiguration(FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(50, 5.0F, 10))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FIRG_TREE_CONFIG3).withChance(10.0F), Feature.TREE.withConfiguration(FIRG_TREE_WITH_MANY_BEEHIVES_CONFIG).withChance(5.0F)), Feature.TREE.withConfiguration(FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(50, 5.0F, 10))));
   }

   public static void addTallBirchForestTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(BIRCH_TREE_CONFIG_CLASH).withChance(0.5F)), Feature.TREE.withConfiguration(BIRCH_TREE_WITH_FEW_BEEHIVES_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addSavannaTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(ACACIA_TREE_CONFIG).withChance(0.8F)), Feature.TREE.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
   }

   public static void addShatteredSavannaTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(ACACIA_TREE_CONFIG).withChance(0.8F)), Feature.TREE.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
   }

   public static void addScatteredOakAndSpruceTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(SPRUCE_TREE_CONFIG).withChance(0.666F), Feature.TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F)), Feature.TREE.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
   }

   public static void addOakAndSpruceTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(SPRUCE_TREE_CONFIG).withChance(0.666F), Feature.TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F)), Feature.TREE.withConfiguration(OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));
   }

   public static void addJungleTreeForest(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F), Feature.TREE.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.5F), Feature.TREE.withConfiguration(MEGA_JUNGLE_TREE_CONFIG).withChance(0.33333334F)), Feature.TREE.withConfiguration(JUNGLE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(50, 0.1F, 1))));
   }

   public static void addOakAndJungleTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F), Feature.TREE.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.5F)), Feature.TREE.withConfiguration(JUNGLE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
   }

   public static void addSparseOakTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.withConfiguration(OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
   }

   public static void addScatteredSpruceTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.TREE.withConfiguration(SPRUCE_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
   }

   public static void addGiantSpruceTaigaTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(MEGA_SPRUCE_TREE_CONFIG).withChance(0.33333334F), Feature.TREE.withConfiguration(PINE_TREE_CONFIG).withChance(0.33333334F)), Feature.TREE.withConfiguration(SPRUCE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addGiantTreeTaigaTrees(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(MEGA_SPRUCE_TREE_CONFIG).withChance(0.025641026F), Feature.TREE.withConfiguration(MEGA_PINE_TREE_CONFIG).withChance(0.30769232F), Feature.TREE.withConfiguration(PINE_TREE_CONFIG).withChance(0.33333334F)), Feature.TREE.withConfiguration(SPRUCE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
   }

   public static void addTaigaGrassDeadBushesMushrooms(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TAIGA_GRASS_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(7))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(FeatureSpread.create(3, 5)))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(3)).chance(12)));
   }

   public static void addDefaultFlowers(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DEFAULT_FLOWER_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(2))));
   }

   public static void addExtraDefaultFlowers(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DEFAULT_FLOWER_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(4))));
   }

   public static void addSparseGrass(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1))));
   }

   public static void addTaigaGrassAndMushrooms(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TAIGA_GRASS_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1)).chance(25)));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(FeatureSpread.create(1, 12)))));
   }

   public static void addPlainsTallGrass(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TALL_GRASS_CONFIG).withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8D, 0, 7))));
   }

   public static void addMushrooms(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(4))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(8))));
   }

   public static void addReedsAndPumpkins(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SUGAR_CANE_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(10))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PUMPKIN_PATCH_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(32))));
   }

   public static void addReedsPumpkinsCactus(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SUGAR_CANE_CONFIG).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(13))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PUMPKIN_PATCH_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(32))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CACTUS_CONFIG).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(5))));
   }

   public static void addJunglePlants(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(MELON_PATCH_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.VINES.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(50, 69.754F, 842))));
   }

   public static void addExtraReedsPumpkinsCactus(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SUGAR_CANE_CONFIG).withPlacement(Placement.HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).chance(60));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PUMPKIN_PATCH_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(32))));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CACTUS_CONFIG).withPlacement(Placement.HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).chance(10));
   }

   public static void addExtraReedsAndPumpkins(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(SUGAR_CANE_CONFIG).withPlacement(Placement.HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).range(20));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(PUMPKIN_PATCH_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(32))));
   }

   public static void addDesertFeatures(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.DESERT_WELL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(1000))));
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(64))));
   }

   public static void addFossils(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(64))));
   }

   public static void addExtraKelp(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.KELP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(120, 80.0D, 0.02D))));
   }

   public static void addSeagrass(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(SEAGRASS, ImmutableList.of(STONE), ImmutableList.of(WATER), ImmutableList.of(WATER))).withPlacement(Placement.CARVING_MASK.configure(new CaveEdgeConfig(GenerationStage.Carving.LIQUID, 0.1F))));
   }

   public static void addSgrealn(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SIMPLE_BLOCK.withConfiguration(new BlockWithContextConfig(CHEST.getDefaultState(), ImmutableList.of(NETHERRACK, STONE, BEDROCK.getDefaultState()), ImmutableList.of(WATER, LAVA), ImmutableList.of(WATER, LAVA))).withPlacement(Placement.CARVING_MASK.configure(new CaveEdgeConfig(GenerationStage.Carving.LIQUID, 0.1F))));
   }

   public static void addTallSeagrassSparse(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new ProbabilityConfig(80)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addTallSeagrassLush(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new ProbabilityConfig(74)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addKelp(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.KELP.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(80, 80.0D, 0.04D))));
   }

   public static void addSprings(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(WATER_SPRING_CONFIG).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(8, 8, 256))).count(50));
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(8, 16, 256))).count(20));
   }

   public static void addIcebergs(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(PACKED_ICE)).withPlacement(Placement.ICEBERG.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).withChance(16).feature.get());
      builder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(BLUE_ICE)).withPlacement(Placement.ICEBERG.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)).withChance(200).feature.get());
   }

   public static void addBlueIce(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.BLUE_ICE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(20))).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(30, 32, 64))));
   }

   public static void addFreezeTopLayer(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Feature.FREEZE_TOP_LAYER.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }

   public static void addEndCity(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, Feature.END_ISLAND.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
   }
   public static void addKiomne(BiomeGenerationSettings.Builder builder) {
      builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.TREE.withConfiguration(FIRG_TREE_CONFIG).withChance(10.0F),Feature.TREE.withConfiguration(FRIM_GROUND_BUSH_CONFIG).withChance(50.0F),Feature.TREE.withConfiguration(MEGA_FIRG_TREE_CONFIG).withChance(0.33333334F)),Feature.TREE.withConfiguration(FRIM_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(5000, 10.0F,100))).chance(10));
   }
}