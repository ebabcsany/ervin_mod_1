package com.babcsany.minecraft.ervin_mod_1.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.BitSet;
import java.util.Random;

public class GenOreFeature extends Feature<GenOreFeatureConfig> {
   public GenOreFeature(Codec<GenOreFeatureConfig> p_i231976_1_) {
      super(p_i231976_1_);
   }

   public boolean generate(ISeedReader seedReader, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, GenOreFeatureConfig config) {
      float lvt_6_1_ = random.nextFloat() * 3.1415927F;
      float lvt_7_1_ = (float)config.size / 8.0F;
      int lvt_8_1_ = MathHelper.ceil(((float)config.size / 16.0F * 2.0F + 1.0F) / 2.0F);
      double lvt_9_1_ = (double)blockPos.getX() + Math.sin((double)lvt_6_1_) * (double)lvt_7_1_;
      double lvt_11_1_ = (double)blockPos.getX() - Math.sin((double)lvt_6_1_) * (double)lvt_7_1_;
      double lvt_13_1_ = (double)blockPos.getZ() + Math.cos((double)lvt_6_1_) * (double)lvt_7_1_;
      double lvt_15_1_ = (double)blockPos.getZ() - Math.cos((double)lvt_6_1_) * (double)lvt_7_1_;
      boolean lvt_17_1_ = true;
      double lvt_18_1_ = (double)(blockPos.getY() + random.nextInt(3) - 2);
      double lvt_20_1_ = (double)(blockPos.getY() + random.nextInt(3) - 2);
      int lvt_22_1_ = blockPos.getX() - MathHelper.ceil(lvt_7_1_) - lvt_8_1_;
      int lvt_23_1_ = blockPos.getY() - 2 - lvt_8_1_;
      int lvt_24_1_ = blockPos.getZ() - MathHelper.ceil(lvt_7_1_) - lvt_8_1_;
      int lvt_25_1_ = 2 * (MathHelper.ceil(lvt_7_1_) + lvt_8_1_);
      int lvt_26_1_ = 2 * (2 + lvt_8_1_);

      for(int lvt_27_1_ = lvt_22_1_; lvt_27_1_ <= lvt_22_1_ + lvt_25_1_; ++lvt_27_1_) {
         for(int lvt_28_1_ = lvt_24_1_; lvt_28_1_ <= lvt_24_1_ + lvt_25_1_; ++lvt_28_1_) {
            if (lvt_23_1_ <= seedReader.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, lvt_27_1_, lvt_28_1_)) {
               return this.func_207803_a(seedReader, random, config, lvt_9_1_, lvt_11_1_, lvt_13_1_, lvt_15_1_, lvt_18_1_, lvt_20_1_, lvt_22_1_, lvt_23_1_, lvt_24_1_, lvt_25_1_, lvt_26_1_);
            }
         }
      }

      return false;
   }

   protected boolean func_207803_a(IWorld p_207803_1_, Random p_207803_2_, GenOreFeatureConfig p_207803_3_, double p_207803_4_, double p_207803_6_, double p_207803_8_, double p_207803_10_, double p_207803_12_, double p_207803_14_, int p_207803_16_, int p_207803_17_, int p_207803_18_, int p_207803_19_, int p_207803_20_) {
      int lvt_21_1_ = 0;
      BitSet lvt_22_1_ = new BitSet(p_207803_19_ * p_207803_20_ * p_207803_19_);
      BlockPos.Mutable lvt_23_1_ = new BlockPos.Mutable();
      int lvt_24_1_ = p_207803_3_.size;
      double[] lvt_25_1_ = new double[lvt_24_1_ * 4];

      int lvt_26_2_;
      double lvt_28_2_;
      double lvt_30_2_;
      double lvt_32_2_;
      double lvt_34_2_;
      for(lvt_26_2_ = 0; lvt_26_2_ < lvt_24_1_; ++lvt_26_2_) {
         float lvt_27_1_ = (float)lvt_26_2_ / (float)lvt_24_1_;
         lvt_28_2_ = MathHelper.lerp((double)lvt_27_1_, p_207803_4_, p_207803_6_);
         lvt_30_2_ = MathHelper.lerp((double)lvt_27_1_, p_207803_12_, p_207803_14_);
         lvt_32_2_ = MathHelper.lerp((double)lvt_27_1_, p_207803_8_, p_207803_10_);
         lvt_34_2_ = p_207803_2_.nextDouble() * (double)lvt_24_1_ / 16.0;
         double lvt_36_1_ = ((double)(MathHelper.sin(3.1415927F * lvt_27_1_) + 1.0F) * lvt_34_2_ + 1.0) / 2.0;
         lvt_25_1_[lvt_26_2_ * 4 + 0] = lvt_28_2_;
         lvt_25_1_[lvt_26_2_ * 4 + 1] = lvt_30_2_;
         lvt_25_1_[lvt_26_2_ * 4 + 2] = lvt_32_2_;
         lvt_25_1_[lvt_26_2_ * 4 + 3] = lvt_36_1_;
      }

      for(lvt_26_2_ = 0; lvt_26_2_ < lvt_24_1_ - 1; ++lvt_26_2_) {
         if (!(lvt_25_1_[lvt_26_2_ * 4 + 3] <= 0.0)) {
            for(int lvt_27_2_ = lvt_26_2_ + 1; lvt_27_2_ < lvt_24_1_; ++lvt_27_2_) {
               if (!(lvt_25_1_[lvt_27_2_ * 4 + 3] <= 0.0)) {
                  lvt_28_2_ = lvt_25_1_[lvt_26_2_ * 4 + 0] - lvt_25_1_[lvt_27_2_ * 4 + 0];
                  lvt_30_2_ = lvt_25_1_[lvt_26_2_ * 4 + 1] - lvt_25_1_[lvt_27_2_ * 4 + 1];
                  lvt_32_2_ = lvt_25_1_[lvt_26_2_ * 4 + 2] - lvt_25_1_[lvt_27_2_ * 4 + 2];
                  lvt_34_2_ = lvt_25_1_[lvt_26_2_ * 4 + 3] - lvt_25_1_[lvt_27_2_ * 4 + 3];
                  if (lvt_34_2_ * lvt_34_2_ > lvt_28_2_ * lvt_28_2_ + lvt_30_2_ * lvt_30_2_ + lvt_32_2_ * lvt_32_2_) {
                     if (lvt_34_2_ > 0.0) {
                        lvt_25_1_[lvt_27_2_ * 4 + 3] = -1.0;
                     } else {
                        lvt_25_1_[lvt_26_2_ * 4 + 3] = -1.0;
                     }
                  }
               }
            }
         }
      }

      for(lvt_26_2_ = 0; lvt_26_2_ < lvt_24_1_; ++lvt_26_2_) {
         double lvt_27_3_ = lvt_25_1_[lvt_26_2_ * 4 + 3];
         if (!(lvt_27_3_ < 0.0)) {
            double lvt_29_1_ = lvt_25_1_[lvt_26_2_ * 4 + 0];
            double lvt_31_1_ = lvt_25_1_[lvt_26_2_ * 4 + 1];
            double lvt_33_1_ = lvt_25_1_[lvt_26_2_ * 4 + 2];
            int lvt_35_1_ = Math.max(MathHelper.floor(lvt_29_1_ - lvt_27_3_), p_207803_16_);
            int lvt_36_2_ = Math.max(MathHelper.floor(lvt_31_1_ - lvt_27_3_), p_207803_17_);
            int lvt_37_1_ = Math.max(MathHelper.floor(lvt_33_1_ - lvt_27_3_), p_207803_18_);
            int lvt_38_1_ = Math.max(MathHelper.floor(lvt_29_1_ + lvt_27_3_), lvt_35_1_);
            int lvt_39_1_ = Math.max(MathHelper.floor(lvt_31_1_ + lvt_27_3_), lvt_36_2_);
            int lvt_40_1_ = Math.max(MathHelper.floor(lvt_33_1_ + lvt_27_3_), lvt_37_1_);

            for(int lvt_41_1_ = lvt_35_1_; lvt_41_1_ <= lvt_38_1_; ++lvt_41_1_) {
               double lvt_42_1_ = ((double)lvt_41_1_ + 0.5 - lvt_29_1_) / lvt_27_3_;
               if (lvt_42_1_ * lvt_42_1_ < 1.0) {
                  for(int lvt_44_1_ = lvt_36_2_; lvt_44_1_ <= lvt_39_1_; ++lvt_44_1_) {
                     double lvt_45_1_ = ((double)lvt_44_1_ + 0.5 - lvt_31_1_) / lvt_27_3_;
                     if (lvt_42_1_ * lvt_42_1_ + lvt_45_1_ * lvt_45_1_ < 1.0) {
                        for(int lvt_47_1_ = lvt_37_1_; lvt_47_1_ <= lvt_40_1_; ++lvt_47_1_) {
                           double lvt_48_1_ = ((double)lvt_47_1_ + 0.5 - lvt_33_1_) / lvt_27_3_;
                           if (lvt_42_1_ * lvt_42_1_ + lvt_45_1_ * lvt_45_1_ + lvt_48_1_ * lvt_48_1_ < 1.0) {
                              int lvt_50_1_ = lvt_41_1_ - p_207803_16_ + (lvt_44_1_ - p_207803_17_) * p_207803_19_ + (lvt_47_1_ - p_207803_18_) * p_207803_19_ * p_207803_20_;
                              if (!lvt_22_1_.get(lvt_50_1_)) {
                                 lvt_22_1_.set(lvt_50_1_);
                                 lvt_23_1_.setPos(lvt_41_1_, lvt_44_1_, lvt_47_1_);
                                 if (p_207803_3_.target.test(p_207803_1_.getBlockState(lvt_23_1_), p_207803_2_)) {
                                    p_207803_1_.setBlockState(lvt_23_1_, p_207803_3_.state, 2);
                                    ++lvt_21_1_;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return lvt_21_1_ > 0;
   }
}