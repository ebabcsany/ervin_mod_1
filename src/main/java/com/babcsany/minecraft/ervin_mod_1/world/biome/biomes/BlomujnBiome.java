package com.babcsany.minecraft.ervin_mod_1.world.biome.biomes;

import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.placement.*;

public class BlomujnBiome {
    public BlomujnBiome(BiomeGenerationSettings.Builder biomeBuilder, MobSpawnInfo.Builder spawnInfoBuilder) {
        spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
        spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
        spawnInfoBuilder.withSpawnCost(EntityInit.VILT_ENTITY.get(), 5, 12);
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
        biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(9, 4.7f, 15))));

        DefaultBiomeFeatures.withOverworldOres(biomeBuilder);
        ModDefaultBiomeFeatures.addBlackIronOres(biomeBuilder);
        ModDefaultBiomeFeatures.addBlueIronOres(biomeBuilder);
        ModDefaultBiomeFeatures.addIronOres(biomeBuilder);
        ModDefaultBiomeFeatures.addRedIronOres(biomeBuilder);
        DefaultBiomeFeatures.withExtraGoldOre(biomeBuilder);
        DefaultBiomeFeatures.withEmeraldOre(biomeBuilder);
        ModDefaultBiomeFeatures.addStoneVariants(biomeBuilder);
        ModBiomeFeatures.addExampleFeature(biomeBuilder, 10);
    }

    public int getGrassColor(double posX, double posZ) {
        return 0x802000;
    }
}

//update mappings post command:
//gradlew --refresh-dependencies
