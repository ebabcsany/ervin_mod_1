package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class TheBhjuigBiome extends Biome {
   public TheBhjuigBiome(Builder biomeBuilder) {
      super(biomeBuilder);
      this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Feature.VOID_START_PLATFORM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ARROW, 25, 0, 1));
   }
}