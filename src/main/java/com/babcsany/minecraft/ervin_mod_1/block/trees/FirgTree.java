package com.babcsany.minecraft.ervin_mod_1.block.trees;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class FirgTree extends Tree {
   /**
    * Get a {@link ConfiguredFeature} of tree
    */
   @Nullable
   protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
      return randomIn.nextInt(10) == 0 ? Feature.FANCY_TREE.withConfiguration(p_225546_2_ ? ModDefaultBiomeFeatures.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG : ModDefaultBiomeFeatures.FIRG_TREE_CONFIG) : Feature.NORMAL_TREE.withConfiguration(p_225546_2_ ? ModDefaultBiomeFeatures.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1 : ModDefaultBiomeFeatures.FIRG_TREE_CONFIG1);
   }
}