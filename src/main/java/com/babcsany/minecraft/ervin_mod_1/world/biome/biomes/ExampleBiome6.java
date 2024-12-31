package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.ModSurfaceBuilder;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

public final class ExampleBiome6 {

   public ExampleBiome6() {
      make(ModConfiguredSurfaceBuilders.EXAMPLE_SURFACE6, ModSurfaceBuilder.EXAMPLE_CONFIG6);
   }

   public static <C extends ISurfaceBuilderConfig, F extends ConfiguredSurfaceBuilder<C>> Biome make(final F configuredSurfaceBuilder, final C config) {
      return make(configuredSurfaceBuilder.builder.func_242929_a(config));
   }

   public static <C extends ISurfaceBuilderConfig, F extends ConfiguredSurfaceBuilder<C>> Biome make(final F configuredSurfaceBuilder) {
      BiomeGenerationSettings.Builder generationSettingsBuilder = new BiomeGenerationSettings.Builder();
      BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
      Biome.Builder builder = new Biome.Builder();
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Feature.VOID_START_PLATFORM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
      generationSettingsBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE);
      generationSettingsBuilder.withSurfaceBuilder(configuredSurfaceBuilder);
      ModDefaultBiomeFeatures.addNirtkb1(generationSettingsBuilder);
      DefaultBiomeFeatures.withFrozenTopLayer(generationSettingsBuilder);
      ambienceBuilder.setWaterColor(10456252);
      ambienceBuilder.setWaterFogColor(26762304);
      ambienceBuilder.setFogColor(12538462);
      ambienceBuilder.withSkyColor(54179860);
      builder.precipitation(Biome.RainType.NONE);
      builder.scale(5327.2F);
      builder.temperature(0.3F);
      builder.setEffects(ambienceBuilder.build());
      builder.withMobSpawnSettings(new MobSpawnInfo.Builder().build());
      builder.withGenerationSettings(generationSettingsBuilder.build());
      builder.category(Biome.Category.PLAINS);
      builder.downfall(12.4F);
      builder.depth(6.5F);
      return builder.build();
   }
}