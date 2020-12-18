package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;
import java.util.Random;

public class FrimTree extends Tree {

    public static final BaseTreeFeatureConfig FRIM_TREE_CONFIG0 = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockItemInit.FRIM_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockItemInit.FRIM_LEAVES.get().getDefaultState()),
            new FancyFoliagePlacer(1, 2, 5, 3, 6),
            new FancyTrunkPlacer(4, 9, 11),
            new TwoLayerFeature(7, 4, 12, OptionalInt.of(9))))
            .setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build();
    public static final BaseTreeFeatureConfig FRIM_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockItemInit.FRIM_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockItemInit.FRIM_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(3, 0, 0, 0, 4),
            new StraightTrunkPlacer(4, 2, 0),
            new TwoLayerFeature(1, 0, 1)))
            .setIgnoreVines().build();
    public static final BaseTreeFeatureConfig FRIM_TREE_CONFIG1 = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockItemInit.FRIM_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockItemInit.FRIM_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(3, 1, 2, 5, 4),
            new StraightTrunkPlacer(1, 3, 5),
            new TwoLayerFeature(5, 3, 6)))
            .setIgnoreVines().build();
    private static final BeehiveTreeDecorator FEW_BEEHIVES = new BeehiveTreeDecorator(0.002F);
    private static final BeehiveTreeDecorator BEEHIVES1 = new BeehiveTreeDecorator(0.5F);
    public static final BaseTreeFeatureConfig FRIM_TREE_WITH_FEW_BEEHIVES_CONFIG = FRIM_TREE_CONFIG0
            .func_236685_a_(ImmutableList.of(FEW_BEEHIVES));

    public static final BaseTreeFeatureConfig FRIM_TREE_WITH_MANY_BEEHIVES_CONFIG = FRIM_TREE_CONFIG0
            .func_236685_a_(ImmutableList.of(BEEHIVES1));

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.field_236291_c_.withConfiguration(FRIM_TREE_CONFIG);
    }
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature1(Random randomIn, boolean b){
        return Feature.field_236291_c_.withConfiguration(FRIM_TREE_CONFIG0);
    }
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature2(Random randomIn, boolean b) {
        return Feature.field_236291_c_.withConfiguration(FRIM_TREE_CONFIG1);
    }
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature3(Random randomIn, boolean b) {
        return Feature.field_236291_c_.withConfiguration(FRIM_TREE_WITH_FEW_BEEHIVES_CONFIG);
    }
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature4(Random randomIn, boolean b) {
        return Feature.field_236291_c_.withConfiguration(FRIM_TREE_WITH_MANY_BEEHIVES_CONFIG);
    }
}
