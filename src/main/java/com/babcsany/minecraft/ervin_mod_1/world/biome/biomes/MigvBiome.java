package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

import java.util.function.Supplier;

public class MigvBiome {
    public MigvBiome() {
        make(() -> ModConfiguredSurfaceBuilders.MIG_SURFACE);
    }

    public static Biome make(final Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilderSupplier) {
        BiomeGenerationSettings.Builder generationSettingsBuilder = new BiomeGenerationSettings.Builder();
        MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
        BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
        Biome.Builder builder = new Biome.Builder();
        spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
        spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
        spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT_ENTITY.get(), 4, 2, 5));
        spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.ZUR_ENTITY.get(), 8, 2, 4));
        generationSettingsBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE);
        generationSettingsBuilder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE);
        DefaultBiomeFeatures.withBadlandsStructures(generationSettingsBuilder);
        generationSettingsBuilder.withStructure(StructureFeatures.RUINED_PORTAL);
        generationSettingsBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
                Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                        .withPlacement(Placement.CHANCE.configure(new ChanceConfig(128))));
        generationSettingsBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.MUSHROOM_FIELD_VEGETATION);
        generationSettingsBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
                        Placement.HEIGHTMAP.configure(NoPlacementConfig.INSTANCE)));
        generationSettingsBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
                        Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(NoPlacementConfig.INSTANCE)));
        generationSettingsBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(9, 4.7f, 15))));
        generationSettingsBuilder.withSurfaceBuilder(surfaceBuilderSupplier);

        DefaultBiomeFeatures.withCommonOverworldBlocks(generationSettingsBuilder);
        DefaultBiomeFeatures.withExtraGoldOre(generationSettingsBuilder);
        DefaultBiomeFeatures.withEmeraldOre(generationSettingsBuilder);
        ModDefaultBiomeFeatures.addOrangeStone(generationSettingsBuilder);
        ModBiomeFeatures.addExampleFeature(generationSettingsBuilder, 10);

        ambienceBuilder.setWaterColor(10456252);
        ambienceBuilder.setWaterFogColor(26762304);
        ambienceBuilder.setFogColor(12538462);
        ambienceBuilder.withSkyColor(0xd4f2a6);
        ambienceBuilder.withGrassColor(0xB6E18F);
        builder.precipitation(Biome.RainType.SNOW);
        builder.scale(8.5F);
        builder.temperature(0.5F);
        builder.setEffects(ambienceBuilder.build());
        builder.withGenerationSettings(generationSettingsBuilder.build());
        builder.category(Biome.Category.PLAINS);
        builder.downfall(12.4f);
        builder.depth(6.5f);
        builder.withTemperatureModifier(Biome.TemperatureModifier.NONE);
        return builder.build();
    }
}

//update mappings post command:
//gradlew --refresh-dependencies
