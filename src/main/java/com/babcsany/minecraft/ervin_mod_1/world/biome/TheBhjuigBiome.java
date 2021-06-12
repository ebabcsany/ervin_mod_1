package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.init.FeatureInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;

public final class TheBhjuigBiome extends Biome {
   public TheBhjuigBiome(Builder biomeBuilder) {
      super(biomeBuilder);
      this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, FeatureInit.VOID_START_PLATFORM1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
   }
}