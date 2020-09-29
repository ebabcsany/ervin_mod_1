package com.babcsany.minecraft.ervin_mod_1.world.feature;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class JazzTree extends Tree {

	public static final BaseTreeFeatureConfig JAZZ_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.JAZZ_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.JAZZ_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(40, 2, 5, 10, 1),
			new StraightTrunkPlacer(15, 30, 25),
            new TwoLayerFeature(13, 17, 8))).setIgnoreVines().build();

	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.field_236291_c_.withConfiguration(JAZZ_TREE_CONFIG);
	}
}
