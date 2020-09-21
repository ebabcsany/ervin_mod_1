package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

import static com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures.FIRG_TREE_CONFIG;

public class FirgTree extends Tree {

    public static final TreeFeatureConfig FIRG_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.FIRG_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(6, 2))).baseHeight(3).heightRandA(1).foliageHeight(5).ignoreVines()
            .setSapling((IPlantable) BlockInit.FIRG_SAPLING.get()).build();
    public static final TreeFeatureConfig FIRG_TREE_CONFIG1 = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.FIRG_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(4, 2))).baseHeight(6).heightRandA(8).foliageHeight(5).ignoreVines()
            .setSapling((IPlantable) BlockInit.FIRG_SAPLING.get()).build();
    public static final TreeFeatureConfig FIRG_TREE_CONFIG2 = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.FIRG.get().getDefaultState()),
            new BlobFoliagePlacer(2, 2))).baseHeight(5).heightRandA(3).foliageHeight(1).ignoreVines()
            .setSapling((IPlantable) BlockInit.FIRG_SAPLING.get()).build();
    public static final TreeFeatureConfig FIRG_TREE_CONFIG3 = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.FIRG.get().getDefaultState()),
            new BlobFoliagePlacer(5, 3))).baseHeight(6).heightRandA(4).foliageHeight(2).ignoreVines()
            .setSapling((IPlantable) BlockInit.FIRG_SAPLING.get()).build();
    public static final TreeFeatureConfig FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.FIRG_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(4, 9))).decorators(ImmutableList.of(new BeehiveTreeDecorator(0.5F)))
            .setSapling((IPlantable) BlockInit.FIRG_SAPLING.get()).build();
    public static final TreeFeatureConfig FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1 = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.FIRG_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(7, 2))).baseHeight(1).heightRandA(8).foliageHeight(3).ignoreVines()
            .decorators(ImmutableList.of(new BeehiveTreeDecorator(0.5F)))
            .setSapling((net.minecraftforge.common.IPlantable) BlockInit.FIRG_SAPLING.get()).build();


    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(FIRG_TREE_CONFIG);
    }
}
