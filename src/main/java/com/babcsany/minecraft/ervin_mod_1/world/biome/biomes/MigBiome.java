package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.biome.surface_builders.MigBiomeSurfaceBuilder;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.ModSurfaceBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.placement.*;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.function.Supplier;

public class MigBiome extends ModBiome {
    public MigBiome() {
        super();
        make(ModConfiguredSurfaceBuilders.MIG_SURFACE, ModSurfaceBuilder.MIG_CONFIG);
    }

    public static <C extends ISurfaceBuilderConfig, F extends ConfiguredSurfaceBuilder<C>> Biome make(final F configuredSurfaceBuilder, final C config) {
        return make(configuredSurfaceBuilder.builder.func_242929_a(config));
    }

    public static <C extends ISurfaceBuilderConfig, F extends ConfiguredSurfaceBuilder<C>> Biome make(final F configuredSurfaceBuilder) {
        BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder()).withSurfaceBuilder(configuredSurfaceBuilder);
        MobSpawnInfo.Builder spawners = new MobSpawnInfo.Builder();
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
        spawners.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT.get(), 4, 2, 5));
        spawners.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.ZUR.get(), 8, 2, 4));
        builder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.CAVE);
        builder.withCarver(GenerationStage.Carving.AIR, ConfiguredCarvers.NETHER_CAVE);
        DefaultBiomeFeatures.withStrongholdAndMineshaft(builder);
        builder.withStructure(StructureFeatures.RUINED_PORTAL);
        builder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
                Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                        .withPlacement(Placement.CHANCE.configure(new ChanceConfig(128))));
        ModDefaultBiomeFeatures.addFeatureWithRandomBooleanSelector(builder,
                GenerationStage.Decoration.VEGETAL_DECORATION,
                () -> Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_RED_MUSHROOM),
                () -> Feature.HUGE_BROWN_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_BROWN_MUSHROOM),
                Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(25, 8, 1)));
        ModDefaultBiomeFeatures.addBrownMushroomWithRandomPatch(builder, 1, 1);
        builder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
                                Placement.HEIGHTMAP_SPREAD_DOUBLE.configure(new NoPlacementConfig()))
                        .withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(FeatureSpread.create(1, 1)))));
        ModDefaultBiomeFeatures.addExtraFirgTree(builder, 9, 4.7f, 15);

        ModDefaultBiomeFeatures.addOrangeStoneOres(builder);
        ModDefaultBiomeFeatures.addExtraGoldOre(builder);
        ModDefaultBiomeFeatures.addExtraEmeraldOre(builder);
        ModDefaultBiomeFeatures.addOrangeStone(builder);
        ModBiomeFeatures.addExampleFeature(builder, 10);
        ModBiomeFeatures.addExampleRuinedPortalFeature(builder, 10);

        BiomeAmbience.Builder biomeAmbienceBuilder = new BiomeAmbience.Builder();

        biomeAmbienceBuilder.setWaterColor(10456252);
        biomeAmbienceBuilder.setWaterFogColor(0x1985c4);
        biomeAmbienceBuilder.setFogColor(12538462);
        biomeAmbienceBuilder.withSkyColor(10403487);
        biomeAmbienceBuilder.withGrassColor(8396800);

        Biome.Builder biomeBuilder = new Biome.Builder();

        biomeBuilder.precipitation(Biome.RainType.SNOW);
        biomeBuilder.category(Biome.Category.PLAINS);
        biomeBuilder.depth(6.5F);
        biomeBuilder.scale(7.9F);
        biomeBuilder.temperature(0.5F);
        biomeBuilder.withTemperatureModifier(Biome.TemperatureModifier.FROZEN);
        biomeBuilder.downfall(12.4F);
        biomeBuilder.setEffects(biomeAmbienceBuilder.build());
        biomeBuilder.withGenerationSettings(builder.build());
        biomeBuilder.withMobSpawnSettings(spawners.build());

        return biomeBuilder.build();
    }
}
