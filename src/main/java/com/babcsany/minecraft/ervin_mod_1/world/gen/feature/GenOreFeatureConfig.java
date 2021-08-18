package com.babcsany.minecraft.ervin_mod_1.world.gen.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.init.BlockInit;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenOreFeatureConfig implements IFeatureConfig {
   public static final Codec<GenOreFeatureConfig> field_236566_a_ = RecordCodecBuilder.create((p_236568_0_) -> p_236568_0_.group(FillerBlockType.field_236571_d_.fieldOf("target").forGetter((p_236570_0_) -> p_236570_0_.target), BlockState.BLOCKSTATE_CODEC.fieldOf("state").forGetter((p_236569_0_) -> p_236569_0_.state), Codec.INT.fieldOf("size").withDefault(0).forGetter((p_236567_0_) -> p_236567_0_.size)).apply(p_236568_0_, GenOreFeatureConfig::new));
   public final FillerBlockType target;
   public final int size;
   public final BlockState state;

   public GenOreFeatureConfig(FillerBlockType target, BlockState state, int size) {
      this.size = size;
      this.state = state;
      this.target = target;
   }

   public enum FillerBlockType implements IStringSerializable, net.minecraftforge.common.IExtensibleEnum {
      NATURAL_STONE("natural_stone", (p_214739_0_) -> {
         if (p_214739_0_ == null) {
            return false;
         } else {
            return p_214739_0_.isIn(Blocks.STONE) || p_214739_0_.isIn(Blocks.GRANITE) || p_214739_0_.isIn(Blocks.DIORITE) || p_214739_0_.isIn(Blocks.ANDESITE);
         }
      }),
      NATURAL_ORANGE_STONE("natural_orange_stone", (p_214739_0_) -> {
         if (p_214739_0_ == null) {
            return false;
         } else {
            return p_214739_0_.isIn(BlockItemInit.ORANGE_STONE.get()) || p_214739_0_.isIn(Blocks.GRANITE) || p_214739_0_.isIn(Blocks.DIORITE) || p_214739_0_.isIn(Blocks.ANDESITE);
         }
      }),
      NATURAL_END_STONE("natural_end_stone", (natural_end_stone) -> {
         if (natural_end_stone == null) {
            return false;
         } else {
            return natural_end_stone.isIn(Blocks.END_STONE) || natural_end_stone.isIn(BlockItemInit.END_SRACKT.get()) || natural_end_stone.isIn(BlockItemInit.END_SRACT.get()) || natural_end_stone.isIn(BlockItemInit.END_STONE_CISK.get()) || natural_end_stone.isIn(BlockItemInit.END_STONE_CRISK.get());
         }
      }),
      TURGS("turgs", (turgs) -> {
         if (turgs == null) {
            return false;
         } else {
            return turgs.isIn(BlockItemInit.OAK_TURG.get()) || turgs.isIn(BlockItemInit.DARK_OAK_TURG.get()) || turgs.isIn(BlockItemInit.ACACIA_TURG.get()) || turgs.isIn(BlockItemInit.BIRCH_TURG.get()) || turgs.isIn(BlockItemInit.JUNGLE_TURG.get()) || turgs.isIn(BlockItemInit.SPRUCE_TURG.get()) || turgs.isIn(BlockItemInit.FIRG_TURG.get()) || turgs.isIn(BlockItemInit.FRIM_TURG.get()) || turgs.isIn(BlockItemInit.TURG.get());
         }
      }),
      END_STONE_VARIANTS("end_stone_variants", (end_stone_variants) -> {
         if (end_stone_variants == null) {
            return false;
         } else {
            return end_stone_variants.isIn(Blocks.END_STONE) || end_stone_variants.isIn(BlockItemInit.END_SRACKT.get()) || end_stone_variants.isIn(BlockItemInit.ENDER_SACKT.get()) || end_stone_variants.isIn(BlockItemInit.ENDER_SRACT.get()) || end_stone_variants.isIn(BlockItemInit.ENDER_SRACK.get()) || end_stone_variants.isIn(BlockItemInit.ENDER_SACT.get()) || end_stone_variants.isIn(BlockItemInit.ENDER_SRACKH.get());
         }
      }),
      NATURAL_STONE1("natural_stone1", (p_214739_0_) -> {
         if (p_214739_0_ == null) {
            return false;
         } else {
            return p_214739_0_.isIn(Blocks.STONE) || p_214739_0_.isIn(BlockItemInit.BLACK_STONE.get()) || p_214739_0_.isIn(BlockItemInit.BLUE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.BROWN_STONE.get()) || p_214739_0_.isIn(BlockItemInit.CYAN_STONE.get()) || p_214739_0_.isIn(BlockItemInit.GREEN_STONE.get()) || p_214739_0_.isIn(BlockItemInit.LIGHT_BLUE1_STONE.get()) || p_214739_0_.isIn(BlockItemInit.LIGHT_BLUE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.LIGHT_GRAY_STONE.get()) || p_214739_0_.isIn(BlockItemInit.LIME_STONE.get()) || p_214739_0_.isIn(BlockItemInit.MAGENTA_STONE.get()) || p_214739_0_.isIn(BlockItemInit.ORANGE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.PINK_STONE.get()) || p_214739_0_.isIn(BlockItemInit.PURPLE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.RED_STONE.get()) || p_214739_0_.isIn(BlockItemInit.WHITE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.YELLOW_STONE.get()) || p_214739_0_.isIn(Blocks.GRANITE) || p_214739_0_.isIn(Blocks.DIORITE) || p_214739_0_.isIn(Blocks.ANDESITE);
         }
      }),
      NATURAL_DIRTS("natural_dirts", (natural_dirts) -> {
         if (natural_dirts == null) {
            return false;
         } else {
            return natural_dirts.isIn(Blocks.DIRT) || natural_dirts.isIn(Blocks.GRASS_BLOCK) || natural_dirts.isIn(Blocks.COARSE_DIRT) || natural_dirts.isIn(Blocks.GRASS_PATH) || natural_dirts.isIn(Blocks.PODZOL);
         }
      }),
      TERRACOTTA_VARIANTS("terracotta_variants", (terracotta_variants) -> {
         if (terracotta_variants == null) {
            return false;
         } else {
            return terracotta_variants.isIn(Blocks.TERRACOTTA) || terracotta_variants.isIn(Blocks.BLACK_TERRACOTTA) || terracotta_variants.isIn(Blocks.BLUE_TERRACOTTA) || terracotta_variants.isIn(Blocks.BROWN_TERRACOTTA) || terracotta_variants.isIn(Blocks.CYAN_TERRACOTTA) || terracotta_variants.isIn(Blocks.GRAY_TERRACOTTA) || terracotta_variants.isIn(Blocks.GREEN_TERRACOTTA) || terracotta_variants.isIn(Blocks.LIGHT_BLUE_TERRACOTTA) || terracotta_variants.isIn(Blocks.LIGHT_GRAY_TERRACOTTA) || terracotta_variants.isIn(Blocks.LIME_TERRACOTTA) || terracotta_variants.isIn(Blocks.MAGENTA_TERRACOTTA) || terracotta_variants.isIn(Blocks.ORANGE_TERRACOTTA) || terracotta_variants.isIn(Blocks.PINK_TERRACOTTA) || terracotta_variants.isIn(Blocks.PURPLE_TERRACOTTA) || terracotta_variants.isIn(Blocks.RED_TERRACOTTA) || terracotta_variants.isIn(Blocks.WHITE_TERRACOTTA) || terracotta_variants.isIn(Blocks.YELLOW_TERRACOTTA);
         }
      }),
      TRIRIJ("tririj", new BlockMatcher(BlockInit.TRIRIJ)),
      DIRT("dirt", new BlockMatcher(Blocks.DIRT)),
      RED_SAND("red_sand", new BlockMatcher(Blocks.RED_SAND)),
      WATER("water", new BlockMatcher(Blocks.WATER)),
      MAGMA_BLOCK("magma_block", new BlockMatcher(Blocks.MAGMA_BLOCK)),
      END_STONE("end_stone", new BlockMatcher(Blocks.END_STONE)),
      NETHER_ORE_REPLACEABLES("nether_ore_replaceables", (p_236572_0_) -> {
         if (p_236572_0_ == null) {
            return false;
         } else {
            return p_236572_0_.isIn(Blocks.NETHERRACK) || p_236572_0_.isIn(Blocks.BASALT) || p_236572_0_.isIn(Blocks.BLACKSTONE);
         }
      });

      public static final Codec<FillerBlockType> field_236571_d_ = IStringSerializable.createEnumCodec(FillerBlockType::values, FillerBlockType::byName);
      /** maps the filler block type name to the corresponding enum value. */
      private static final Map<String, FillerBlockType> VALUES_MAP = Arrays.stream(values()).collect(Collectors.toMap(FillerBlockType::getName, (p_236573_0_) -> p_236573_0_));
      /** the filler block type name. */
      private final String name;
      /** the predicate to match the target block to fill */
      private final Predicate<BlockState> targetBlockPredicate;

      FillerBlockType(String nameIn, Predicate<BlockState> predicateIn) {
         this.name = nameIn;
         this.targetBlockPredicate = predicateIn;
      }

      /**
       * returns the name of the filler block type.
       */
      public String getName() {
         return this.name;
      }

      /**
       * returns the filler block type with the given name.
       *  
       * @param nameIn the filler block type name
       */
      public static FillerBlockType byName(String nameIn) {
         return VALUES_MAP.get(nameIn);
      }

      public static FillerBlockType create(String enumName, String nameIn, Predicate<BlockState> predicateIn) {
         throw new IllegalStateException("Enum not extended");
      }

      @Override
      @Deprecated
      public void init() {
          VALUES_MAP.put(getName(), this);
      }

      /**
       * returns the target block state predicate
       */
      public Predicate<BlockState> getTargetBlockPredicate() {
         return this.targetBlockPredicate;
      }

      public String getString() {
         return this.name;
      }
   }
}