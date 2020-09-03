package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OreFeatureConfig1 implements IFeatureConfig {
   public final OreFeatureConfig1.FillerBlockType1 target;
   public final int size;
   public final BlockState state;

   public OreFeatureConfig1(OreFeatureConfig1.FillerBlockType1 target, BlockState state, int size) {
      this.size = size;
      this.state = state;
      this.target = target;
   }

   public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
      return new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("size"), ops.createInt(this.size), ops.createString("target"), ops.createString(this.target.getName()), ops.createString("state"), BlockState.serialize(ops, this.state).getValue())));
   }

   public static OreFeatureConfig1 deserialize(Dynamic<?> in) {
      int i = in.get("size").asInt(10);
      OreFeatureConfig1.FillerBlockType1 orefeatureconfig$fillerblocktype = OreFeatureConfig1.FillerBlockType1.byName(in.get("target").asString(""));
      BlockState blockstate = in.get("state").map(BlockState::deserialize).orElse(BlockInit.AIR.get().getDefaultState());
      return new OreFeatureConfig1(orefeatureconfig$fillerblocktype, blockstate, i);
   }

   public static enum FillerBlockType1 implements net.minecraftforge.common.IExtensibleEnum {
      NATURAL_STONE("natural_stone", (p_214739_0_) -> {
         if (p_214739_0_ == null) {
            return false;
         } else {
            Block block = p_214739_0_.getBlock();
            return block == Blocks.STONE || block == BlockInit.BLACK_STONE.get() || block == BlockInit.BLUE_STONE.get() || block == BlockInit.BROWN_STONE.get() || block == BlockInit.CYAN_STONE.get() || block == BlockInit.GREEN_STONE.get() || block == BlockInit.LIGHT_BLUE_STONE.get() || block == BlockInit.LIGHT_GRAY_STONE.get() || block == BlockInit.LIME_STONE.get() || block == BlockInit.MAGENTA_STONE.get() || block == BlockInit.ORANGE_STONE.get() || block == BlockInit.PINK_STONE.get() || block == BlockInit.PURPLE_STONE.get() || block == BlockInit.RED_STONE.get() || block == BlockInit.WHITE_STONE.get() || block == BlockInit.YELLOW_STONE.get() || block == BlockInit.SURVI.get() || block == Blocks.GRANITE || block == Blocks.DIORITE || block == Blocks.ANDESITE;
         }
      }),
      NETHERRACK("netherrack", new BlockMatcher(Blocks.NETHERRACK));

      /** maps the filler block type name to the corresponding enum value. */
      private static final Map<String, OreFeatureConfig1.FillerBlockType1> VALUES_MAP = Arrays.stream(values()).collect(Collectors.toMap(OreFeatureConfig1.FillerBlockType1::getName, (p_214740_0_) -> {
         return p_214740_0_;
      }));
      /** the filler block type name. */
      private final String name;
      /** the predicate to match the target block to fill */
      private final Predicate<BlockState> targetBlockPredicate;

      private FillerBlockType1(String nameIn, Predicate<BlockState> predicateIn) {
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
      public static OreFeatureConfig1.FillerBlockType1 byName(String nameIn) {
         return VALUES_MAP.get(nameIn);
      }

      /**
       * returns the target block state predicate
       */
      public Predicate<BlockState> getTargetBlockPredicate() {
         return this.targetBlockPredicate;
      }
      
      public static FillerBlockType1 create(String enumName, String nameIn, Predicate<BlockState> predicateIn) {
         throw new IllegalStateException("Enum not extended");
      }

      @Override
      @Deprecated
      public void init() {
          VALUES_MAP.put(getName(), this);
      }
   }
}