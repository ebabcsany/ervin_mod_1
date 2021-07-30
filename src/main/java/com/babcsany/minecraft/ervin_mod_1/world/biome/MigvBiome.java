package com.babcsany.minecraft.ervin_mod_1.world.biome;

import com.babcsany.minecraft.ervin_mod_1.init.ModBiomeFeatures;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.placement.*;

public class MigvBiome extends Biome {
    public MigvBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 10, 2, 5));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.BEE, 20, 2, 10));
        //this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityInit.VILT_ENTITY.get(), 4, 2, 5));
        //this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityInit.ZUR_ENTITY.get(), 8, 2, 4));
        this.addCarver(GenerationStage.Carving.AIR,
                Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(2.7542778539F)));
        this.addCarver(GenerationStage.Carving.AIR,
                Biome.createCarver(WorldCarver.field_236240_b_, new ProbabilityConfig(0.02F)));
        DefaultBiomeFeatures.func_235189_a_(this);
        this.func_235063_a_(DefaultBiomeFeatures.RUINED_PORTAL_STANDARD);
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
                Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                        .withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(128))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_BOOLEAN_SELECTOR
                        .withConfiguration(new TwoFeatureChoiceConfig(
                                Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM),
                                Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
                        .withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(1, 0.25F))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new HeightWithChanceConfig(1, 0.125F))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.field_236291_c_.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(9, 4.7f, 15))));

        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addExtraGoldOre(this);
        DefaultBiomeFeatures.addExtraEmeraldOre(this);
        ModDefaultBiomeFeatures.addOrangeStone(this);
        ModBiomeFeatures.addExampleFeature(this, 10);
    }

    @Override
    public int getGrassColor(double posX, double posZ) {
        return 0xd4f2a6;
    }
}

//update mappings post command:
//gradlew --refresh-dependencies