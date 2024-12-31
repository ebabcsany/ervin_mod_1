package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiomeMaker;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.ModSurfaceBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

public class TheBhjuigBiome {
   public TheBhjuigBiome() {
      make(ModConfiguredSurfaceBuilders.BHJUIG_SURFACE, ModSurfaceBuilder.BHJUIG_CONFIG);
   }

   public static <C extends ISurfaceBuilderConfig, F extends ConfiguredSurfaceBuilder<C>> Biome make(final F configuredSurfaceBuilder, final C config) {
      return make(configuredSurfaceBuilder.builder.func_242929_a(config));
   }

   public static <C extends ISurfaceBuilderConfig, F extends ConfiguredSurfaceBuilder<C>> Biome make(final F surfaceBuilder) {
      BiomeGenerationSettings.Builder generationSettingsBuilder = new BiomeGenerationSettings.Builder();
      MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
      BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
      Biome.Builder builder = new Biome.Builder();
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Feature.VOID_START_PLATFORM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
      spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ARROW, 25, 0, 1));
      ambienceBuilder.setWaterColor(28634578);
      ambienceBuilder.setWaterFogColor(837428654);
      ambienceBuilder.setFogColor(792356895);
      ambienceBuilder.withSkyColor(ModBiomeMaker.getSkyColorWithTemperatureModifier(0.5F));
      builder.precipitation(Biome.RainType.SNOW);
      builder.scale(16.3F);
      builder.temperature(0.5F);
      builder.category(Biome.Category.PLAINS);
      builder.downfall(4.0F);
      builder.depth(2.5F);
      builder.setEffects(ambienceBuilder.build());
      builder.withMobSpawnSettings(spawnInfoBuilder.build());
      builder.withGenerationSettings(generationSettingsBuilder.withSurfaceBuilder(surfaceBuilder).build());
      return builder.build();
   }
}