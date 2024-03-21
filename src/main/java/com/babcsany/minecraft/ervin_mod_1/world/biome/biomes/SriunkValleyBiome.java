package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class SriunkValleyBiome {
   public SriunkValleyBiome() {
      make(() -> ModConfiguredSurfaceBuilders.SRIUNK_VALLEY_SURFACE);
   }

   public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilderSupplier) {
      BiomeGenerationSettings.Builder generationSettingsBuilder = new BiomeGenerationSettings.Builder();
      MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
      BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
      Biome.Builder builder = new Biome.Builder();
      generationSettingsBuilder.withStructure(StructureFeatures.FORTRESS);
      generationSettingsBuilder.withStructure(StructureFeatures.NETHER_FOSSIL);
      generationSettingsBuilder.withStructure(StructureFeatures.RUINED_PORTAL_NETHER);
      generationSettingsBuilder.withStructure(StructureFeatures.BASTION_REMNANT);
      generationSettingsBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE);
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SPRING_FEATURE.withConfiguration(ModDefaultBiomeFeatures.LAVA_SPRING_CONFIG).withPlacement(Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(20, 8, 256))));
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.CHORUS_PLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(FeatureSpread.create(10, 128)))));
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.withConfiguration(ModDefaultBiomeFeatures.NETHER_SPRING_CONFIG).withPlacement(Placement.RANGE_BIASED.configure(new TopSolidRangeConfig(4, 8, 97))));
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE.configure(new ChanceConfig(10))));
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.GLOWSTONE_BLOB.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(38, 0, 128))));
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.BLUE_ORCHID_CONFIG).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(3, 0, 128))).withChance(12).feature.get());
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.TALL_GRASS_CONFIG).withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(10))));
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.NETHER_SOUL_FIRE).withPlacement(Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(35, 2, 10))));
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockItemInit.KALT_BLOCK.get().getDefaultState(), 33)).withPlacement(Placement.MAGMA.configure(new NoPlacementConfig())));
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.SPRING_FEATURE.withConfiguration(ModDefaultBiomeFeatures.ENCLOSED_NETHER_SPRING_CONFIG).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(14, 20, 128))));
      generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, isBurnableBlockItemInit.SRIUNK_BLOCK.get().getDefaultState(), 12)).withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(4, 0, 32))));
      generationSettingsBuilder.withSurfaceBuilder(surfaceBuilderSupplier);
      DefaultBiomeFeatures.withBadlandsStructures(generationSettingsBuilder);
      DefaultBiomeFeatures.withFrozenTopLayer(generationSettingsBuilder);
      spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 20, 5, 5));
      spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.GHAST, 50, 4, 4));
      spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 1, 4, 4));
      spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.STRIDER, 60, 1, 2));
      double entitySpawnCost = 0.7D;
      double maxSpawnCost = 0.15D;
      spawnInfoBuilder.withSpawnCost(EntityType.SKELETON, entitySpawnCost, maxSpawnCost);
      spawnInfoBuilder.withSpawnCost(EntityType.GHAST, entitySpawnCost, maxSpawnCost);
      spawnInfoBuilder.withSpawnCost(EntityType.ENDERMAN, entitySpawnCost, maxSpawnCost);
      spawnInfoBuilder.withSpawnCost(EntityType.STRIDER, entitySpawnCost, maxSpawnCost);
      ambienceBuilder.setWaterColor(10456252);
      ambienceBuilder.setWaterFogColor(26762304);
      ambienceBuilder.setFogColor(12538462);
      builder.withMobSpawnSettings(spawnInfoBuilder.build());
      builder.precipitation(Biome.RainType.NONE);
      builder.scale(44.0F);
      builder.temperature(0.5F);
      builder.setEffects(ambienceBuilder.build());
      builder.withGenerationSettings(generationSettingsBuilder.build());
      builder.category(Biome.Category.PLAINS);
      builder.downfall(12.4F);
      builder.depth(6.5F);
      return builder.build();
   }
}