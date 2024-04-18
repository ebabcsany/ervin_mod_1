package com.babcsany.minecraft.ervin_mod_1.world.gen.feature;

import com.babcsany.minecraft.ervin_mod_1.tags.ModBlockTags;
import com.babcsany.minecraft.init.BlockInit;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;

public class GenOreFeatureConfig implements IFeatureConfig {
   public static final Codec<GenOreFeatureConfig> CODEC = RecordCodecBuilder.create((p_236568_0_) -> {
      return p_236568_0_.group(RuleTest.CODEC.fieldOf("target").forGetter((p_236570_0_) -> {
         return p_236570_0_.target;
      }), BlockState.CODEC.fieldOf("state").forGetter((p_236569_0_) -> {
         return p_236569_0_.state;
      }), Codec.intRange(0, 64).fieldOf("size").forGetter((p_236567_0_) -> {
         return p_236567_0_.size;
      })).apply(p_236568_0_, GenOreFeatureConfig::new);
   });
   public final RuleTest target;
   public final int size;
   public final BlockState state;

   public GenOreFeatureConfig(RuleTest p_i241989_1_, BlockState p_i241989_2_, int p_i241989_3_) {
      this.size = p_i241989_3_;
      this.state = p_i241989_2_;
      this.target = p_i241989_1_;
   }

   public static final class FillerBlockType {
      public static final RuleTest BASE_STONE_OVERWORLD;
      public static final RuleTest BASE_ORANGE_STONE_OVERWORLD;
      public static final RuleTest BASE_STONES_OVERWORLD;
      public static final RuleTest BASE_TURGS_OVERWORLD;
      public static final RuleTest BASE_DIRTS_OVERWORLD;
      public static final RuleTest BASE_TERRACOTTA_VARIANTS_OVERWORLD;
      public static final RuleTest BASE_END_STONES;
      public static final RuleTest BASE_END_STONE_VARIANTS;
      public static final RuleTest TRIRIJ;
      public static final RuleTest DIRT;
      public static final RuleTest RED_SAND;
      public static final RuleTest WATER;
      public static final RuleTest MAGMA_BLOCK;
      public static final RuleTest END_STONE;
      public static final RuleTest NETHERRACK;
      public static final RuleTest BASE_STONE_NETHER;

      static {
         BASE_STONE_OVERWORLD = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
         BASE_ORANGE_STONE_OVERWORLD = new TagMatchRuleTest(ModBlockTags.BASE_ORANGE_STONE_OVERWORLD);
         BASE_STONES_OVERWORLD = new TagMatchRuleTest(ModBlockTags.BASE_STONES_OVERWORLD);
         BASE_TURGS_OVERWORLD = new TagMatchRuleTest(ModBlockTags.BASE_TURGS_OVERWORLD);
         BASE_DIRTS_OVERWORLD = new TagMatchRuleTest(ModBlockTags.BASE_DIRTS_OVERWORLD);
         BASE_TERRACOTTA_VARIANTS_OVERWORLD = new TagMatchRuleTest(ModBlockTags.BASE_TERRACOTTA_VARIANTS_OVERWORLD);
         BASE_END_STONES = new TagMatchRuleTest(ModBlockTags.BASE_END_STONES);
         BASE_END_STONE_VARIANTS = new TagMatchRuleTest(ModBlockTags.BASE_END_STONE_VARIANTS);
         TRIRIJ = new BlockMatchRuleTest(BlockInit.TRIRIJ.get());
         DIRT = new BlockMatchRuleTest(Blocks.DIRT);
         RED_SAND = new BlockMatchRuleTest(Blocks.RED_SAND);
         WATER = new BlockMatchRuleTest(Blocks.WATER);
         MAGMA_BLOCK = new BlockMatchRuleTest(Blocks.MAGMA_BLOCK);
         END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);
         NETHERRACK = new BlockMatchRuleTest(Blocks.NETHERRACK);
         BASE_STONE_NETHER = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
      }
   }
}