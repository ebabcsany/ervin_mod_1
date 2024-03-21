package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
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

import java.util.function.Supplier;

public class TheBhjuigBiome {
   public TheBhjuigBiome() {
      make(() -> ModConfiguredSurfaceBuilders.BHJUIG_SURFACE);
   }

   public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilderSupplier) {
      BiomeGenerationSettings.Builder generationSettingsBuilder = new BiomeGenerationSettings.Builder();
      MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
      BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
      Biome.Builder builder = new Biome.Builder();
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.TOP_LAYER_MODIFICATION, Feature.VOID_START_PLATFORM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
      spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ARROW, 25, 0, 1));
      ambienceBuilder.setWaterColor(28634578);
      ambienceBuilder.setWaterFogColor(837428654);
      ambienceBuilder.setFogColor(792356895);
      builder.precipitation(Biome.RainType.SNOW);
      builder.scale(16.3F);
      builder.temperature(0.5F);
      builder.category(Biome.Category.PLAINS);
      builder.downfall(4.0F);
      builder.depth(2.5F);
      builder.setEffects(ambienceBuilder.build());
      builder.withGenerationSettings(generationSettingsBuilder.withSurfaceBuilder(surfaceBuilderSupplier).build());
      return builder.build();
   }
}