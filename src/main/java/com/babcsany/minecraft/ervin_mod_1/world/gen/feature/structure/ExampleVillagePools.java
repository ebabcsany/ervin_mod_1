package com.babcsany.minecraft.ervin_mod_1.world.gen.feature.structure;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.jigsaw.*;
import net.minecraft.world.gen.feature.template.*;

public class ExampleVillagePools {
   public static void init() {
   }

   static {
      ImmutableList<StructureProcessor> immutablelist = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.8F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()), new RuleEntry(new TagMatchRuleTest(BlockTags.DOORS), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.WALL_TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.MOSSY_COBBLESTONE, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHITE_TERRACOTTA, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.OAK_LOG, 0.05F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.OAK_PLANKS, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.OAK_STAIRS, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STRIPPED_OAK_LOG, 0.02F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GLASS_PANE, 0.5F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, Boolean.valueOf(true)).with(PaneBlock.SOUTH, Boolean.valueOf(true))), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, Boolean.valueOf(true)).with(PaneBlock.SOUTH, Boolean.valueOf(true))), new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.EAST, Boolean.valueOf(true)).with(PaneBlock.WEST, Boolean.valueOf(true))), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.EAST, Boolean.valueOf(true)).with(PaneBlock.WEST, Boolean.valueOf(true))), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.3F), AlwaysTrueRuleTest.INSTANCE, Blocks.CARROTS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.POTATOES.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.BEETROOTS.getDefaultState()))));
      ImmutableList<StructureProcessor> immutablelist1 = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))));
      ImmutableList<StructureProcessor> immutablelist2 = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_PATH), new BlockMatchRuleTest(Blocks.WATER), Blocks.OAK_PLANKS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_PATH, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.GRASS_BLOCK.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_BLOCK), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.DIRT), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()))));
      ImmutableList<StructureProcessor> immutablelist3 = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.3F), AlwaysTrueRuleTest.INSTANCE, Blocks.CARROTS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.POTATOES.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.BEETROOTS.getDefaultState()))));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/town_centers"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/town_centers/plains_fountain_01", ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))))), 50), new Pair<>(new LegacySingleJigsawPiece("village/plains/town_centers/plains_meeting_point_1", ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))))), 50), new Pair<>(new LegacySingleJigsawPiece("village/plains/town_centers/plains_meeting_point_2"), 50), new Pair<>(new LegacySingleJigsawPiece("village/plains/town_centers/plains_meeting_point_3", ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.7F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))))), 50), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/town_centers/plains_fountain_01", immutablelist), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/town_centers/plains_meeting_point_1", immutablelist), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/town_centers/plains_meeting_point_2", immutablelist), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/town_centers/plains_meeting_point_3", immutablelist), 1)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/streets"), new ResourceLocation("village/plains/terminators"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/corner_01", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/corner_02", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/corner_03", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/straight_01", immutablelist2), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/straight_02", immutablelist2), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/straight_03", immutablelist2), 7), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/straight_04", immutablelist2), 7), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/straight_05", immutablelist2), 3), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/straight_06", immutablelist2), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/crossroad_01", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/crossroad_02", immutablelist2), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/crossroad_03", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/crossroad_04", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/crossroad_05", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/crossroad_06", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/streets/turn_01", immutablelist2), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/zombie/streets"), new ResourceLocation("village/plains/terminators"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/corner_01", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/corner_02", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/corner_03", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/straight_01", immutablelist2), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/straight_02", immutablelist2), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/straight_03", immutablelist2), 7), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/straight_04", immutablelist2), 7), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/straight_05", immutablelist2), 3), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/straight_06", immutablelist2), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/crossroad_01", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/crossroad_02", immutablelist2), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/crossroad_03", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/crossroad_04", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/crossroad_05", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/crossroad_06", immutablelist2), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/streets/turn_01", immutablelist2), 3)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/houses"), new ResourceLocation("village/plains/terminators"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_house_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_house_2", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_house_3", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_house_4", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_house_5", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_house_6", immutablelist1), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_house_7", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_house_8", immutablelist1), 3), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_medium_house_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_medium_house_2", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_big_house_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_butcher_shop_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_butcher_shop_2", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_tool_smith_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_fletcher_house_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_shepherds_house_1"), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_armorer_house_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_fisher_cottage_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_tannery_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_cartographer_1", immutablelist1), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_library_1", immutablelist1), 5), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_library_2", immutablelist1), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_masons_house_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_weaponsmith_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_temple_3", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_temple_4", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_stable_1", immutablelist1), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_stable_2"), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_large_farm_1", immutablelist3), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_farm_1", immutablelist3), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_animal_pen_1"), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_animal_pen_2"), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_animal_pen_3"), 5), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_accessory_1"), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_meeting_point_4", ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.7F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))))), 3), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_meeting_point_5"), 1), Pair.of(EmptyJigsawPiece.INSTANCE, 10)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/zombie/houses"), new ResourceLocation("village/plains/terminators"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_small_house_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_small_house_2", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_small_house_3", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_small_house_4", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_small_house_5", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_small_house_6", immutablelist), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_small_house_7", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_small_house_8", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_medium_house_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_medium_house_2", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_big_house_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_butcher_shop_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_butcher_shop_2", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_tool_smith_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_fletcher_house_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_shepherds_house_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_armorer_house_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_fisher_cottage_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_tannery_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_cartographer_1", immutablelist), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_library_1", immutablelist), 3), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_library_2", immutablelist), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_masons_house_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_weaponsmith_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_temple_3", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_temple_4", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_stable_1", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_stable_2", immutablelist), 2), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_large_farm_1", immutablelist), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_small_farm_1", immutablelist), 4), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_animal_pen_1", immutablelist), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/houses/plains_animal_pen_2", immutablelist), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_animal_pen_3", immutablelist), 5), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_meeting_point_4", immutablelist), 3), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/houses/plains_meeting_point_5", immutablelist), 1), Pair.of(EmptyJigsawPiece.INSTANCE, 10)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/terminators"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/terminators/terminator_01", immutablelist2), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/terminators/terminator_02", immutablelist2), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/terminators/terminator_03", immutablelist2), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/terminators/terminator_04", immutablelist2), 1)), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/trees"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new FeatureJigsawPiece(Feature.field_236291_c_.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)), 1)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/decor"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/plains_lamp_1"), 2), new Pair<>(new FeatureJigsawPiece(Feature.field_236291_c_.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)), 1), new Pair<>(new FeatureJigsawPiece(Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.PLAINS_FLOWER_CONFIG)), 1), new Pair<>(new FeatureJigsawPiece(Feature.BLOCK_PILE.withConfiguration(DefaultBiomeFeatures.HAY_PILE_CONFIG)), 1), Pair.of(EmptyJigsawPiece.INSTANCE, 2)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/zombie/decor"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/plains_lamp_1", immutablelist), 1), new Pair<>(new FeatureJigsawPiece(Feature.field_236291_c_.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)), 1), new Pair<>(new FeatureJigsawPiece(Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.PLAINS_FLOWER_CONFIG)), 1), new Pair<>(new FeatureJigsawPiece(Feature.BLOCK_PILE.withConfiguration(DefaultBiomeFeatures.HAY_PILE_CONFIG)), 1), Pair.of(EmptyJigsawPiece.INSTANCE, 2)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/villagers"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/villagers/nitwit"), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/villagers/baby"), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/plains/zombie/villagers"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/villagers/nitwit"), 1), new Pair<>(new LegacySingleJigsawPiece("village/plains/zombie/villagers/unemployed"), 10)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/common/animals"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cows_1"), 7), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/pigs_1"), 7), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/horses_1"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/horses_2"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/horses_3"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/horses_4"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/horses_5"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/sheep_1"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/sheep_2"), 1), Pair.of(EmptyJigsawPiece.INSTANCE, 5)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/common/sheep"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/common/animals/sheep_1"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/sheep_2"), 1)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/common/cats"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_black"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_british"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_calico"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_persian"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_ragdoll"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_red"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_siamese"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_tabby"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_white"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cat_jellie"), 1), Pair.of(EmptyJigsawPiece.INSTANCE, 3)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/common/butcher_animals"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/common/animals/cows_1"), 3), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/pigs_1"), 3), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/sheep_1"), 1), new Pair<>(new LegacySingleJigsawPiece("village/common/animals/sheep_2"), 1)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/common/iron_golem"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/common/iron_golem"), 1)), JigsawPattern.PlacementBehaviour.RIGID));
      JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Ervin_mod_1.MOD_ID,"village/common/well_bottoms"), new ResourceLocation("empty"), ImmutableList.of(new Pair<>(new LegacySingleJigsawPiece("village/common/well_bottom"), 1)), JigsawPattern.PlacementBehaviour.RIGID));
   }
}