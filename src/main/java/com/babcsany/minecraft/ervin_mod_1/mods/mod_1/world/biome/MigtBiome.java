package com.babcsany.minecraft.ervin_mod_1.mods.mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.world.biome.spawn.SpawnListEntry;
import com.babcsany.minecraft.ervin_mod_1.init.EntityInit;
import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.placement.*;

public class MigtBiome {
    public MigtBiome(BiomeGenerationSettings.Builder biomeBuilder, MobSpawnInfo.Builder spawnInfoBuilder) {
        spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
        spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
        spawnInfoBuilder.withSpawner(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT_ENTITY.get(), 4, 2, 5));
        spawnInfoBuilder.withSpawner(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.ZUR_ENTITY.get(), 8, 2, 4));
        biomeBuilder.withCarver(GenerationStage.Carving.AIR, new ConfiguredCarver<>(WorldCarver.CAVE, new ProbabilityConfig(2.7542778539F)));
        biomeBuilder.withCarver(GenerationStage.Carving.AIR, new ConfiguredCarver<>(WorldCarver.NETHER_CAVE, new ProbabilityConfig(0.02F)));
        DefaultBiomeFeatures.withDisks(biomeBuilder);
        biomeBuilder.withStructure(StructureFeatures.RUINED_PORTAL);
        biomeBuilder.withFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
                Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                        .withPlacement(Placement.CHANCE.configure(new ChanceConfig(128))));
        biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_BOOLEAN_SELECTOR
                        .withConfiguration(new TwoFeatureChoiceConfig(
                                () -> Feature.HUGE_RED_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_RED_MUSHROOM),
                                () -> Feature.HUGE_BROWN_MUSHROOM.withConfiguration(ModDefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
                        .withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1))));
        biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(1, 6, 18))));
        biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(ModDefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_NOISE.configure(new NoiseDependant(1, 10, 3))));
        biomeBuilder.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.TREE.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA.configure(new AtSurfaceWithExtraConfig(9, 4.7f, 15))));

        ModDefaultBiomeFeatures.addOres(biomeBuilder);
        DefaultBiomeFeatures.withExtraGoldOre(biomeBuilder);
        DefaultBiomeFeatures.withEmeraldOre(biomeBuilder);
        ModDefaultBiomeFeatures.addBlueStone(biomeBuilder);
        ModBiomeFeatures.addExampleFeature(biomeBuilder, 10);
        ModBiomeFeatures.addExampleRuinedPortalFeature(biomeBuilder, 10);
    }

    public int getGrassColor(double posX, double posZ) {
        return 0xd4f2a621;
    }
}
