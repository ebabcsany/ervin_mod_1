package com.babcsany.minecraft.ervin_mod_1.world.gen.feature.structure;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Blocks;
import net.minecraft.block.PaneBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.jigsaw.*;
import net.minecraft.world.gen.feature.structure.PlainsVillagePools;
import net.minecraft.world.gen.feature.template.*;

public class ExampleVillagePools {
   static final ImmutableList<StructureProcessor> immutablelist;
   static final ImmutableList<StructureProcessor> immutablelist1;
   static final ImmutableList<StructureProcessor> immutablelist2;
   static final ImmutableList<StructureProcessor> immutablelist3;
   public static final StructureProcessorList ZOMBIE_FIRG;
   static final StructureProcessorList MOSSY_10_PERCENT;
   public static final StructureProcessorList STREET_FIRG;
   public static final StructureProcessorList FARM_FIRG;

   public static void init() {
   }

   private static StructureProcessorList register(String p_244127_0_, ImmutableList<StructureProcessor> p_244127_1_) {
      ResourceLocation lvt_2_1_ = new ResourceLocation(p_244127_0_);
      StructureProcessorList lvt_3_1_ = new StructureProcessorList(p_244127_1_);
      return (StructureProcessorList) WorldGenRegistries.register(WorldGenRegistries.STRUCTURE_PROCESSOR_LIST, lvt_2_1_, lvt_3_1_);
   }

   static {
      immutablelist = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.8F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()), new RuleEntry(new TagMatchRuleTest(BlockTags.DOORS), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.WALL_TORCH), AlwaysTrueRuleTest.INSTANCE, Blocks.AIR.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.MOSSY_COBBLESTONE, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHITE_TERRACOTTA, 0.07F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.OAK_LOG, 0.05F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.OAK_PLANKS, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.OAK_STAIRS, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.STRIPPED_OAK_LOG, 0.02F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GLASS_PANE, 0.5F), AlwaysTrueRuleTest.INSTANCE, Blocks.COBWEB.getDefaultState()), new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, Boolean.valueOf(true)).with(PaneBlock.SOUTH, Boolean.valueOf(true))), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.NORTH, Boolean.valueOf(true)).with(PaneBlock.SOUTH, Boolean.valueOf(true))), new RuleEntry(new BlockStateMatchRuleTest(Blocks.GLASS_PANE.getDefaultState().with(PaneBlock.EAST, Boolean.valueOf(true)).with(PaneBlock.WEST, Boolean.valueOf(true))), AlwaysTrueRuleTest.INSTANCE, Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState().with(PaneBlock.EAST, Boolean.valueOf(true)).with(PaneBlock.WEST, Boolean.valueOf(true))), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.3F), AlwaysTrueRuleTest.INSTANCE, Blocks.CARROTS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.POTATOES.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.BEETROOTS.getDefaultState()))));
      immutablelist1 = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.COBBLESTONE, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.MOSSY_COBBLESTONE.getDefaultState()))));
      immutablelist2 = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_PATH), new BlockMatchRuleTest(Blocks.WATER), Blocks.OAK_PLANKS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.GRASS_PATH, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.GRASS_BLOCK.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.GRASS_BLOCK), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()), new RuleEntry(new BlockMatchRuleTest(Blocks.DIRT), new BlockMatchRuleTest(Blocks.WATER), Blocks.WATER.getDefaultState()))));
      immutablelist3 = ImmutableList.of(new RuleStructureProcessor(ImmutableList.of(new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.3F), AlwaysTrueRuleTest.INSTANCE, Blocks.CARROTS.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(BlockInit.TARG_STAGE.get(), 0.2F), AlwaysTrueRuleTest.INSTANCE, Blocks.POTATOES.getDefaultState()), new RuleEntry(new RandomBlockMatchRuleTest(Blocks.WHEAT, 0.1F), AlwaysTrueRuleTest.INSTANCE, Blocks.BEETROOTS.getDefaultState()))));
      ZOMBIE_FIRG = register("zombie_firg", immutablelist);
      MOSSY_10_PERCENT = register("mossify_10_percent", immutablelist1);
      STREET_FIRG = register("street_firg", immutablelist2);
      FARM_FIRG = register("farm_firg", immutablelist3);
      JigsawPatternRegistry.func_244094_a(new JigsawPattern(new ResourceLocation("village/plains/streets"), new ResourceLocation("village/plains/terminators"), ImmutableList.of(Pair.of(JigsawPiece.func_242851_a("village/plains/streets/corner_01", STREET_FIRG), 2), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/corner_02", ProcessorLists.STREET_PLAINS), 2), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/corner_03", ProcessorLists.STREET_PLAINS), 2), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/straight_01", ProcessorLists.STREET_PLAINS), 4), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/straight_02", ProcessorLists.STREET_PLAINS), 4), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/straight_03", ProcessorLists.STREET_PLAINS), 7), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/straight_04", ProcessorLists.STREET_PLAINS), 7), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/straight_05", ProcessorLists.STREET_PLAINS), 3), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/straight_06", ProcessorLists.STREET_PLAINS), 4), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/crossroad_01", ProcessorLists.STREET_PLAINS), 2), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/crossroad_02", ProcessorLists.STREET_PLAINS), 1), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/crossroad_03", ProcessorLists.STREET_PLAINS), 2), new Pair[]{Pair.of(JigsawPiece.func_242851_a("village/plains/streets/crossroad_04", ProcessorLists.STREET_PLAINS), 2), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/crossroad_05", ProcessorLists.STREET_PLAINS), 2), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/crossroad_06", ProcessorLists.STREET_PLAINS), 2), Pair.of(JigsawPiece.func_242851_a("village/plains/streets/turn_01", ProcessorLists.STREET_PLAINS), 3)}), JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING));
   }
}