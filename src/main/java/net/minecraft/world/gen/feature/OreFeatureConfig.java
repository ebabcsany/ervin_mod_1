package net.minecraft.world.gen.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.util.IStringSerializable;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OreFeatureConfig implements IFeatureConfig {
   public static final Codec<OreFeatureConfig> field_236566_a_ = RecordCodecBuilder.create((p_236568_0_) -> {
      return p_236568_0_.group(FillerBlockType.field_236571_d_.fieldOf("target").forGetter((p_236570_0_) -> {
         return p_236570_0_.target;
      }), BlockState.BLOCKSTATE_CODEC.fieldOf("state").forGetter((p_236569_0_) -> {
         return p_236569_0_.state;
      }), Codec.INT.fieldOf("size").withDefault(0).forGetter((p_236567_0_) -> {
         return p_236567_0_.size;
      })).apply(p_236568_0_, OreFeatureConfig::new);
   });
   public final FillerBlockType target;
   public final int size;
   public final BlockState state;

   public OreFeatureConfig(FillerBlockType target, BlockState state, int size) {
      this.size = size;
      this.state = state;
      this.target = target;
   }

   public static enum FillerBlockType implements IStringSerializable, net.minecraftforge.common.IExtensibleEnum {
      NATURAL_STONE("natural_stone", (p_214739_0_) -> {
         if (p_214739_0_ == null) {
            return false;
         } else {
            return p_214739_0_.isIn(Blocks.STONE) || p_214739_0_.isIn(Blocks.GRANITE) || p_214739_0_.isIn(Blocks.DIORITE) || p_214739_0_.isIn(Blocks.ANDESITE);
         }
      }),
      NATURAL_STONE1("natural_stone1", (p_214739_0_) -> {
         if (p_214739_0_ == null) {
            return false;
         } else {
            return p_214739_0_.isIn(Blocks.STONE) || p_214739_0_.isIn(BlockItemInit.BLACK_STONE.get()) || p_214739_0_.isIn(BlockItemInit.BLUE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.BROWN_STONE.get()) || p_214739_0_.isIn(BlockItemInit.CYAN_STONE.get()) || p_214739_0_.isIn(BlockItemInit.GREEN_STONE.get()) || p_214739_0_.isIn(BlockItemInit.LIGHT_BLUE1_STONE.get()) || p_214739_0_.isIn(BlockItemInit.LIGHT_BLUE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.LIGHT_GRAY_STONE.get()) || p_214739_0_.isIn(BlockItemInit.LIME_STONE.get()) || p_214739_0_.isIn(BlockItemInit.MAGENTA_STONE.get()) || p_214739_0_.isIn(BlockItemInit.ORANGE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.PINK_STONE.get()) || p_214739_0_.isIn(BlockItemInit.PURPLE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.RED_STONE.get()) || p_214739_0_.isIn(BlockItemInit.WHITE_STONE.get()) || p_214739_0_.isIn(BlockItemInit.YELLOW_STONE.get()) || p_214739_0_.isIn(Blocks.GRANITE) || p_214739_0_.isIn(Blocks.DIORITE) || p_214739_0_.isIn(Blocks.ANDESITE);
         }
      }),
      NETHERRACK("netherrack", new BlockMatcher(Blocks.NETHERRACK)),
      NETHER_ORE_REPLACEABLES("nether_ore_replaceables", (p_236572_0_) -> {
         if (p_236572_0_ == null) {
            return false;
         } else {
            return p_236572_0_.isIn(Blocks.NETHERRACK) || p_236572_0_.isIn(Blocks.BASALT) || p_236572_0_.isIn(Blocks.BLACKSTONE);
         }
      });

      public static final Codec<FillerBlockType> field_236571_d_ = IStringSerializable.createEnumCodec(FillerBlockType::values, FillerBlockType::byName);
      /** maps the filler block type name to the corresponding enum value. */
      private static final Map<String, FillerBlockType> VALUES_MAP = Arrays.stream(values()).collect(Collectors.toMap(FillerBlockType::getName, (p_236573_0_) -> {
         return p_236573_0_;
      }));
      /** the filler block type name. */
      private final String name;
      /** the predicate to match the target block to fill */
      private final Predicate<BlockState> targetBlockPredicate;

      private FillerBlockType(String nameIn, Predicate<BlockState> predicateIn) {
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