package com.babcsany.minecraft.ervin_mod_1.block.trees;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModDefaultBiomeFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class FirgTree extends Tree1 {
   /**
    * Get a {@link ConfiguredFeature} of tree
    */
   @Nullable
   protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
      return randomIn.nextInt(20) == 0 ? Feature.field_236291_c_.withConfiguration(p_225546_2_ ? ModDefaultBiomeFeatures.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG : ModDefaultBiomeFeatures.FIRG_TREE_CONFIG) : Feature.field_236291_c_.withConfiguration(p_225546_2_ ? ModDefaultBiomeFeatures.FIRG_TREE_WITH_MORE_BEEHIVES_CONFIG1 : ModDefaultBiomeFeatures.FIRG_TREE_CONFIG1);
   }
   @Nullable
   protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature1(Random randomIn, boolean p_225546_2_) {
      return randomIn.nextInt(10) == 0 ? Feature.field_236291_c_.withConfiguration(p_225546_2_ ? ModDefaultBiomeFeatures.FIRG_TREE_WITH_MORE_FIRGS_CONFIG : ModDefaultBiomeFeatures.FIRG_TREE_CONFIG2) : Feature.field_236291_c_.withConfiguration(p_225546_2_ ? ModDefaultBiomeFeatures.FIRG_TREE_WITH_MORE_FIRGS_CONFIG1 : ModDefaultBiomeFeatures.FIRG_TREE_CONFIG3);
   }
   @Nullable
   protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTree_Feature(Random randomIn, boolean p_225546_2_) {
      return Feature.field_236291_c_.withConfiguration(ModDefaultBiomeFeatures.FIRG_TREE_CONFIG3);
   }
   @Nullable
   protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
      return Feature.field_236291_c_.withConfiguration(ModDefaultBiomeFeatures.MEGA_FIRG_TREE_CONFIG);
   }
}