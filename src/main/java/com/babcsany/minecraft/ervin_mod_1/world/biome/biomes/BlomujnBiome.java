package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.init.ModConfiguredSurfaceBuilders;
import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiomeMaker;
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

public class BlomujnBiome {
    public BlomujnBiome() {
        make(() -> ModConfiguredSurfaceBuilders.BLOMUJN);
    }

    public static Biome make(Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        MobSpawnInfo.Builder spawnInfoBuilder = new MobSpawnInfo.Builder();
        BiomeAmbience.Builder ambienceBuilder = new BiomeAmbience.Builder();
        Biome.Builder builder = new Biome.Builder();
        float temperature = 6.86428648622135309935614699977474100243124564054F;
        spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
        spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
        spawnInfoBuilder.withSpawnCost(EntityInit.VILT_ENTITY, 5, 12);
        spawnInfoBuilder.withSpawnCost(EntityInit.HHIJ_ENTITY, 5, 12);
        spawnInfoBuilder.withSpawnCost(EntityInit.LIWRAY, 5, 12);
        biomeBuilder.withCarver(GenerationStage.Carving.AIR,
                ConfiguredCarvers.CAVE);
        biomeBuilder.withCarver(GenerationStage.Carving.AIR,
                ConfiguredCarvers.NETHER_CAVE);
        DefaultBiomeFeatures.withCommonOverworldBlocks(biomeBuilder);
        biomeBuilder.withStructure(StructureFeatures.RUINED_PORTAL);
        biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
                Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                        .withPlacement(Placement.CHANCE.configure(new ChanceConfig(128))));
        biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Features.MUSHROOM_FIELD_VEGETATION);
        biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Features.MUSHROOM_FIELD_VEGETATION);
        biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_NOISE.configure(new NoiseDependant(0.25F, 1, 2))));
        biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(1, 0.125F, 2))));
        ModDefaultBiomeFeatures.addExtraFirgTree(biomeBuilder, 9, 4.7f, 15);
        biomeBuilder.withSurfaceBuilder(configuredSurfaceBuilderSupplier);

        DefaultBiomeFeatures.withOverworldOres(biomeBuilder);
        ModDefaultBiomeFeatures.addBlackIronOres(biomeBuilder);
        ModDefaultBiomeFeatures.addBlueIronOres(biomeBuilder);
        ModDefaultBiomeFeatures.addIronOres(biomeBuilder);
        ModDefaultBiomeFeatures.addRedIronOres(biomeBuilder);
        DefaultBiomeFeatures.withExtraGoldOre(biomeBuilder);
        DefaultBiomeFeatures.withEmeraldOre(biomeBuilder);
        ModDefaultBiomeFeatures.addStoneVariants(biomeBuilder);
        ModBiomeFeatures.addExampleFeature(biomeBuilder, 10);

        ambienceBuilder.setWaterColor(0x9c2ac2);
        ambienceBuilder.setWaterFogColor(0xc22ab5);
        ambienceBuilder.setFogColor(0xc22a5f);
        ambienceBuilder.withSkyColor(ModBiomeMaker.getSkyColorWithTemperatureModifier(temperature));
        ambienceBuilder.withGrassColor(0x802000);

        builder.precipitation(Biome.RainType.RAIN);
        builder.scale(0.14532796548612091754865192894F);
        builder.temperature(temperature);
        builder.setEffects(ambienceBuilder.build());
        builder.withMobSpawnSettings(spawnInfoBuilder.build());
        builder.withGenerationSettings(biomeBuilder.build());
        builder.category(Biome.Category.TAIGA);
        builder.downfall(743.6415698376710891457237289965631289000000012231F);
        builder.depth(42.964346246513017458421519361320132158376471513061632454652306F);

        return builder.build();
    }
}

//update mappings post command:
//gradlew --refresh-dependencies
