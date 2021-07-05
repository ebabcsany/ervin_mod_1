package com.babcsany.minecraft.ervin_mod_1.world.gen;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.init.*;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.List;
import java.util.Map;

public class addSpawnZur {
    public static com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome modBiomeIn;
    public Map<EntityClassification, List<Biome.SpawnListEntry>> spawns;
    public static final BlockState FIRT_BLOCK = BlockItemInit.FIRT_BLOCK.get().getDefaultState();

    /*public addSpawnZur(Biome.Builder biomeBuilder) {
        super(biomeBuilder);
    }*/

    public void addSpawn(EntityClassification type, Biome.SpawnListEntry spawnListEntry, com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome modBiome) {
        this.spawns.computeIfAbsent(type, k -> Lists.newArrayList()).add(spawnListEntry);
    }

    public void addSpawnZur_count_1(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
        modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 4, 1, 1));
    }

    static class addSpawnZur_weight_4 {
        public Map<EntityClassification, List<Biome.SpawnListEntry>> spawns;
        public void addSpawn(EntityClassification type, Biome.SpawnListEntry spawnListEntry) {
            this.spawns.computeIfAbsent(type, k -> Lists.newArrayList()).add(spawnListEntry);
        }
        public static void addSpawnZur_count_1(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome modBiomeIn) {
            modBiomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 4, 1, 1));
        }
        public static void addSpawnZur_count_2(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 4, 1, 2));
        }
        public static void addSpawnZur_count_3(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 4, 1, 3));
        }
        public static void addSpawnZur_count_4(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 4, 1, 4));
        }
        public static void addSpawnZur_count_8(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 4, 1, 8));
        }
    }
    public static class addSpawnZur_weight_8 {
        public static void addSpawnZur_count_1(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome modBiomeIn) {
            modBiomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 8, 1, 1));
        }
        public static void addSpawnZur_count_4(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 8, 1, 4));
        }
        public static void addSpawnZur_count_8(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 8, 1, 8));
        }
    }
    public static class addSpawnZur_weight_12 {
        public static void addSpawnZur_count_1(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome modBiomeIn) {
            modBiomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 12, 1, 1));
        }
        public static void addSpawnZur_count_4(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 12, 1, 4));
        }
        public static void addSpawnZur_count_8(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 12, 1, 8));
        }
    }
    public static class addSpawnZur_weight_16 {
        public static void addSpawnZur_count_1(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome modBiomeIn) {
            modBiomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 16, 1, 1));
        }
        public static void addSpawnZur_count_4(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 16, 1, 4));
        }
        public static void addSpawnZur_count_8(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 16, 1, 8));
        }
    }
    public static class addSpawnZur_weight_20 {
        public static void addSpawnZur_count_1(com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome modBiomeIn) {
            modBiomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 20, 1, 1));
        }
        public static void addSpawnZur_count_4(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 20, 1, 4));
        }
        public static void addSpawnZur_count_8(Biome biomeIn) {
            biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
            modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 20, 1, 8));
        }
    }
    private static void addSpawnZur_count_4(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
        modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 8, 1, 4));
    }
    private static void addSpawnZur_count_8(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.RAW_GENERATION, FeatureInit.GEN_ORE.withConfiguration(new GenOreFeatureConfig(GenOreFeatureConfig.FillerBlockType.NATURAL_DIRTS, FIRT_BLOCK, 4)).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(8))));
        modBiomeIn.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityInit.ZUR_ENTITY, 8, 1, 8));
    }
}
