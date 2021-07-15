package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
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

public class FirgTree extends Tree {

    //public static BaseTreeFeatureConfig FIRG_TREE_CONFIG;
    public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG0 = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockItemInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(isBurnableBlockItemInit.FIRG_LEAVES.get().getDefaultState()),
            new FancyFoliagePlacer(4, 3, 1, 5, 2),
            new FancyTrunkPlacer(8, 2, 6),
            new TwoLayerFeature(13, 11, 5, OptionalInt.of(2))))
            .setIgnoreVines().func_236702_a_(Heightmap.Type.MOTION_BLOCKING).build();
    public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG1 = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockItemInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(isBurnableBlockItemInit.FIRG_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(6, 0, 0, 0, 2),
            new StraightTrunkPlacer(1, 6, 3),
            new TwoLayerFeature(4, 5, 3)))
            .setIgnoreVines().build();
    public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG2 = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockItemInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(isBurnableBlockItemInit.FIRG_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(4, 0, 0, 0, 2),
            new StraightTrunkPlacer(3, 5, 2),
            new TwoLayerFeature(6, 2, 4)))
            .setIgnoreVines().build();
    public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG3 = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockItemInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.FIRG.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0, 0, 0, 2),
            new StraightTrunkPlacer(3, 4, 2),
            new TwoLayerFeature(4, 0, 3)))
            .setIgnoreVines().build();
    public static final BaseTreeFeatureConfig FIRG_TREE_CONFIG4 = (new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockItemInit.FIRG_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInit.FIRG.get().getDefaultState()),
            new BlobFoliagePlacer(5, 0, 0, 0, 3),
            new StraightTrunkPlacer(5, 3, 6),
            new TwoLayerFeature(2, 1, 3))).setIgnoreVines().build();
    private static final BeehiveTreeDecorator BEEHIVES2 = new BeehiveTreeDecorator(5.0F);
    private static final BeehiveTreeDecorator BEEHIVES1 = new BeehiveTreeDecorator(0.5F);
    private static final BeehiveTreeDecorator BEEHIVES = new BeehiveTreeDecorator(0.02F);
    public static final BaseTreeFeatureConfig FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG = FIRG_TREE_CONFIG0
            .func_236685_a_(ImmutableList.of(BEEHIVES));
    public static final BaseTreeFeatureConfig FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG1 = FIRG_TREE_CONFIG1
            .func_236685_a_(ImmutableList.of(BEEHIVES));
    public static final BaseTreeFeatureConfig FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG = FIRG_TREE_CONFIG2
            .func_236685_a_(ImmutableList.of(BEEHIVES1));
    public static final BaseTreeFeatureConfig FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1 = FIRG_TREE_CONFIG3
            .func_236685_a_(ImmutableList.of(BEEHIVES1));
    public static final BaseTreeFeatureConfig FIRG_TREE_WITH_MANY_BEEHIVES_CONFIG = FIRG_TREE_CONFIG4
            .func_236685_a_(ImmutableList.of(BEEHIVES2));

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.field_236291_c_.withConfiguration(FIRG_TREE_CONFIG0);
    }

    /*public static BaseTreeFeatureConfig setFirgTreeConfig(BaseTreeFeatureConfig... baseTreeFeatureConfigs) {
        return FIRG_TREE_CONFIG;
    }

    static {
        FIRG_TREE_CONFIG = setFirgTreeConfig(FIRG_TREE_CONFIG0, FIRG_TREE_CONFIG1, FIRG_TREE_CONFIG2, FIRG_TREE_CONFIG3, FIRG_TREE_CONFIG4, FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG, FIRG_TREE_WITH_FEW_BEEHIVES_CONFIG1, FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG, FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1, FIRG_TREE_WITH_MANY_BEEHIVES_CONFIG);
    }*/
}
