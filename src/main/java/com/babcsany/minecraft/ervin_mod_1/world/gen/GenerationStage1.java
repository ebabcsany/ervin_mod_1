package com.babcsany.minecraft.ervin_mod_1.world.gen;

import com.mojang.serialization.Codec;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.gen.GenerationStage;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerationStage1 {
   public enum Carving implements IStringSerializable {
      AIR("air"),
      AIR1("air1"),
      LIQUID("liquid");

      public static final Codec<com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Carving> field_236074_c_ = IStringSerializable.createEnumCodec(com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Carving::values, com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Carving::func_236075_a_);
      private static final Map<String, com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Carving> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Carving::getName, (p_222672_0_) -> p_222672_0_));
      private final String name;

      Carving(String name) {
         this.name = name;
      }

      public String getName() {
         return this.name;
      }

      @Nullable
      public static com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Carving func_236075_a_(String p_236075_0_) {
         return BY_NAME.get(p_236075_0_);
      }

      public String getString() {
         return this.name;
      }
   }

   public static enum Decoration implements IStringSerializable {
      RAW_GENERATION("raw_generation"),
      LAKES("lakes"),
      LOCAL_MODIFICATIONS("local_modifications"),
      UNDERGROUND_STRUCTURES("underground_structures"),
      SURFACE_STRUCTURES("surface_structures"),
      STRONGHOLDS("strongholds"),
      UNDERGROUND_ORES("underground_ores"),
      UNDERGROUND_DECORATION("underground_decoration"),
      VEGETAL_DECORATION("vegetal_decoration"),
      TOP_LAYER_MODIFICATION("top_layer_modification");

      public static final Codec<com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Decoration> field_236076_k_ = IStringSerializable.createEnumCodec(com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Decoration::values, com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Decoration::func_236077_a_);
      private static final Map<String, com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Decoration> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Decoration::getName, (p_222675_0_) -> {
         return p_222675_0_;
      }));
      private final String name;

      private Decoration(String name) {
         this.name = name;
      }

      public String getName() {
         return this.name;
      }

      public static com.babcsany.minecraft.ervin_mod_1.world.gen.GenerationStage1.Decoration func_236077_a_(String p_236077_0_) {
         return BY_NAME.get(p_236077_0_);
      }

      public String getString() {
         return this.name;
      }
   }
}