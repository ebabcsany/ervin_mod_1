package com.babcsany.minecraft.ervin_mod_1.block.trees;

import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class FrimTree extends Tree {
   /**
    * Get a {@link ConfiguredFeature} of tree
    */
   @Nullable
   protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
      return Feature.NORMAL_TREE.withConfiguration(p_225546_2_ ? ModDefaultBiomeFeatures.field_230136_t_ : ModDefaultBiomeFeatures.FRIM_TREE_CONFIG);
   }
}