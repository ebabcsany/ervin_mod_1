package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public final class ExampleBiome6 {

   public ExampleBiome6() {
      make(() -> ModConfiguredSurfaceBuilders.EXAMPLE_SURFACE6);
   }

   public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
      BiomeGenerationSettings.Builder generationSettingsBuilder = new BiomeGenerationSettings.Builder();
      BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
      Biome.Builder builder = new Biome.Builder();
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Feature.VOID_START_PLATFORM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
      generationSettingsBuilder.withCarver(GenerationStage.Carving.AIR,
              ConfiguredCarvers.CAVE);
      generationSettingsBuilder.withSurfaceBuilder(configuredSurfaceBuilderSupplier);
      ModDefaultBiomeFeatures.addNirtkb1(generationSettingsBuilder);
      DefaultBiomeFeatures.withFrozenTopLayer(generationSettingsBuilder);
      ambienceBuilder.setWaterColor(10456252);
      ambienceBuilder.setWaterColor(26762304);
      ambienceBuilder.setWaterColor(12538462);
      builder.precipitation(Biome.RainType.NONE);
      builder.scale(5327.2F);
      builder.temperature(0.5F);
      builder.setEffects(ambienceBuilder.build());
      builder.withGenerationSettings(generationSettingsBuilder.build());
      builder.category(Biome.Category.PLAINS);
      builder.downfall(12.4F);
      builder.depth(6.5F);
      return builder.build();
   }
}