package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class FirgTree {

    public static final TreeFeatureConfig FIRG_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.FIRG_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(10, 10))).baseHeight(40).heightRandA(5).foliageHeight(125).ignoreVines()
            .setSapling((IPlantable) BlockInit.FIRG_SAPLING.get()).build();

    //@Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(FIRG_TREE_CONFIG);
    }
}