package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.init.EntityInit;
import com.babcsany.minecraft.init.FeatureInit;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public final class ExampleBiome6 extends Biome {

   public ExampleBiome6(Builder biomeBuilder) {
      super(biomeBuilder);
      this.addFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, FeatureInit.VOID_START_PLATFORM1.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
      this.addCarver(GenerationStage.Carving.AIR,
              Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(6.586974623F)));
      ModDefaultBiomeFeatures.addNirtkb1(this);
      this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.ZUR_ENTITY, 50, -6, 1));
      DefaultBiomeFeatures.addFreezeTopLayer(this);
   }
}