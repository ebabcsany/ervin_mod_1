package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.Random;

public class JazzTree extends Tree {

	public static final BaseTreeFeatureConfig JAZZ_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockItemInit.JAZZ_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockItemInit.JAZZ_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(FeatureSpread.create(20, 1), FeatureSpread.create(4, 10), 1),
			new StraightTrunkPlacer(8, 15, 20),
            new TwoLayerFeature(6, 8, 4))).setIgnoreVines().build();

	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.TREE.withConfiguration(JAZZ_TREE_CONFIG);
	}
}
