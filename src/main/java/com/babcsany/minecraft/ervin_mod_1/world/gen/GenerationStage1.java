package com.babcsany.minecraft.ervin_mod_1.world.gen;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerationStage1 {
   public static enum Carving1 {
      AIR("air"),
      AIR1("air1"),
      LIQUID("liquid");

      private static final Map<String, GenerationStage1.Carving1> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(GenerationStage1.Carving1::getName, (p_222672_0_) -> {
         return p_222672_0_;
      }));
      private final String name;

      private Carving1(String name) {
         this.name = name;
      }

      public String getName() {
         return this.name;
      }
   }

   public static enum Decoration {
      RAW_GENERATION("raw_generation"),
      LOCAL_MODIFICATIONS("local_modifications"),
      UNDERGROUND_STRUCTURES("underground_structures"),
      SURFACE_STRUCTURES("surface_structures"),
      UNDERGROUND_ORES("underground_ores"),
      UNDERGROUND_DECORATION("underground_decoration"),
      VEGETAL_DECORATION("vegetal_decoration"),
      TOP_LAYER_MODIFICATION("top_layer_modification");

      private static final Map<String, GenerationStage1.Decoration> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(GenerationStage1.Decoration::getName, (p_222675_0_) -> {
         return p_222675_0_;
      }));
      private final String name;

      private Decoration(String name) {
         this.name = name;
      }

      public String getName() {
         return this.name;
      }
   }
}