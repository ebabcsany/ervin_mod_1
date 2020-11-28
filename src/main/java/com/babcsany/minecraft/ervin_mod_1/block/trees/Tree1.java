package com.babcsany.minecraft.ervin_mod_1.block.trees;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class Tree1 {
   /**
    * Get a {@link ConfiguredFeature} of tree
    */
   @Nullable
   protected abstract ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_);

   public boolean func_225545_a_(IWorld p_225545_1_, ChunkGenerator<?> p_225545_2_, BlockPos p_225545_3_, BlockState p_225545_4_, Random p_225545_5_) {
      ConfiguredFeature<TreeFeatureConfig, ?> configuredfeature = this.getTreeFeature(p_225545_5_, this.func_230140_a_(p_225545_1_, p_225545_3_));
      if (configuredfeature == null) {
         return false;
      } else {
         p_225545_1_.setBlockState(p_225545_3_, Blocks.AIR.getDefaultState(), 4);
         ((TreeFeatureConfig)configuredfeature.config).forcePlacement();
         if (configuredfeature.place(p_225545_1_, p_225545_2_, p_225545_5_, p_225545_3_)) {
            return true;
         } else {
            p_225545_1_.setBlockState(p_225545_3_, p_225545_4_, 4);
            return false;
         }
      }
   }

   @Nullable
   protected abstract ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature1(Random randomIn, boolean p_225546_2_);

   public boolean func_225545_b_(IWorld p_225545_1_, ChunkGenerator<?> p_225545_2_, BlockPos p_225545_3_, BlockState p_225545_4_, Random p_225545_5_) {
      ConfiguredFeature<TreeFeatureConfig, ?> configuredfeature = this.getTreeFeature1(p_225545_5_, this.func_230140_a_(p_225545_1_, p_225545_3_));
      if (configuredfeature == null) {
         return false;
      } else {
         p_225545_1_.setBlockState(p_225545_3_, Blocks.AIR.getDefaultState(), 4);
         ((TreeFeatureConfig)configuredfeature.config).forcePlacement();
         if (configuredfeature.place(p_225545_1_, p_225545_2_, p_225545_5_, p_225545_3_)) {
            return true;
         } else {
            p_225545_1_.setBlockState(p_225545_3_, p_225545_4_, 4);
            return false;
         }
      }
   }

   private boolean func_230140_a_(IWorld p_230140_1_, BlockPos p_230140_2_) {
      for(BlockPos blockpos : BlockPos.Mutable.getAllInBoxMutable(p_230140_2_.down().north(2).west(2), p_230140_2_.up().south(2).east(2))) {
         if (p_230140_1_.getBlockState(blockpos).isIn(BlockTags.FLOWERS)) {
            return true;
         }
      }

      return false;
   }
}