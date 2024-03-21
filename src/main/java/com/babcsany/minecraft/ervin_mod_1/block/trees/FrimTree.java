package com.babcsany.minecraft.ervin_mod_1.block.trees;

import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.Nullable;
import java.util.Random;

public class FrimTree extends Tree {
   /**
    * Get a {@link ConfiguredFeature} of tree
    */
   @Nullable
   protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
      return Feature.TREE.withConfiguration(p_225546_2_ ? ModDefaultBiomeFeatures.FRIM_GROUND_BUSH_CONFIG_WITH_FEW_BEEHIVES : ModDefaultBiomeFeatures.FRIM_TREE_CONFIG);
   }
}