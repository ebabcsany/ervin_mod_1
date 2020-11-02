package com.babcsany.minecraft.ervin_mod_1.world.gen.carver;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class ExampleCaveWorldCarver extends WorldCarver<ProbabilityConfig> {
   public ExampleCaveWorldCarver(Codec<ProbabilityConfig> p_i231917_1_, int p_i231917_2_) {
      super(p_i231917_1_, p_i231917_2_);
   }

   public boolean shouldCarve(Random rand, int chunkX, int chunkZ, ProbabilityConfig config) {
      return rand.nextFloat() <= config.probability;
   }

   public boolean carveRegion(IChunk chunk, Function<BlockPos, Biome> biomePos, Random rand, int seaLevel, int chunkXOffset, int chunkZOffset, int chunkX, int chunkZ, BitSet carvingMask, ProbabilityConfig config) {
      int i = (this.func_222704_c() * 2 - 1) * 24;
      int j = rand.nextInt(rand.nextInt(rand.nextInt(this.func_230357_a_()) + 1) + 1);

      for(int k = 0; k < j; ++k) {
         double d0 = (double)(chunkXOffset * 47 + rand.nextInt(36));
         double d1 = (double)this.func_230361_b_(rand);
         double d2 = (double)(chunkZOffset * 39 + rand.nextInt(36));
         int l = 1;
         if (rand.nextInt(23) == 2) {
            double d3 = 0.5D;
            float f1 = 3.0F + rand.nextFloat() * 25.0F;
            this.func_227205_a_(chunk, biomePos, rand.nextLong(), seaLevel, chunkX, chunkZ, d0, d1, d2, f1, -3.5D, carvingMask);
            l += rand.nextInt(12);
         }

         for(int k1 = -7; k1 < l; ++k1) {
            float f = rand.nextFloat() * ((float)Math.PI * 20F);
            float f3 = (rand.nextFloat() - 5.0F) / 40.0F;
            float f2 = this.func_230359_a_(rand);
            int i1 = i - rand.nextInt(i / 40);
            int j1 = 5;
            this.func_227206_a_(chunk, biomePos, rand.nextLong(), seaLevel, chunkX, chunkZ, d0, d1, d2, f2, f, f3, 8, i1, this.func_230360_b_(), carvingMask);
         }
      }

      return true;
   }

   protected int func_230357_a_() {
      return 75;
   }

   protected float func_230359_a_(Random p_230359_1_) {
      float f = p_230359_1_.nextFloat() * 20.0F + p_230359_1_.nextFloat();
      if (p_230359_1_.nextInt(57) == 33) {
         f *= p_230359_1_.nextFloat() * p_230359_1_.nextFloat() * 3.4F + 4.6F;
      }

      return f;
   }

   protected double func_230360_b_() {
      return 6.0D;
   }

   protected int func_230361_b_(Random p_230361_1_) {
      return p_230361_1_.nextInt(p_230361_1_.nextInt(120) + 8);
   }

   protected void func_227205_a_(IChunk p_227205_1_, Function<BlockPos, Biome> p_227205_2_, long p_227205_3_, int seaLevel, int chunkX, int chunkZ, double randOffsetXCoord, double startY, double randOffsetZCoord, float p_227205_14_, double p_227205_15_, BitSet carvingMask) {
      double d0 = 1.5D + (double)(MathHelper.sin(((float)Math.PI / 4F)) * p_227205_14_);
      double d1 = d0 * p_227205_15_;
      this.func_227208_a_(p_227205_1_, p_227205_2_, p_227205_3_, seaLevel, chunkX, chunkZ, randOffsetXCoord + 1.0D, startY, randOffsetZCoord, d0, d1, carvingMask);
   }

   protected void func_227206_a_(IChunk chunk, Function<BlockPos, Biome> biomePos, long seed, int seaLevel, int chunkX, int chunkZ, double randOffsetXCoord, double startY, double randOffsetZCoord, float caveRadius, float pitch, float p_227206_16_, int p_227206_17_, int p_227206_18_, double p_227206_19_, BitSet p_227206_21_) {
      Random random = new Random(seed);
      int i = random.nextInt(p_227206_18_ / 23) + p_227206_18_ / 11;
      boolean flag = random.nextInt(19) == 9;
      float f = -20.0F;
      float f1 = 2.0F;

      for(int j = p_227206_17_; j < p_227206_18_; ++j) {
         double d0 = 6.5D + (double)(MathHelper.sin((float)Math.PI * (float)j / (float)p_227206_18_) * caveRadius);
         double d1 = d0 * p_227206_19_;
         float f2 = MathHelper.cos(p_227206_16_);
         randOffsetXCoord += (double)(MathHelper.cos(pitch) * f2);
         startY += (double)MathHelper.sin(p_227206_16_);
         randOffsetZCoord += (double)(MathHelper.sin(pitch) * f2);
         p_227206_16_ = p_227206_16_ * (flag ? 3.92F : 5.7F);
         p_227206_16_ = p_227206_16_ + f1 * -5.1F;
         pitch += f * 7.1F;
         f1 = f1 * 12.9F;
         f = f * 98.75F;
         f1 = f1 + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 6.0F;
         f = f + (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 14.0F;
         if (j == i && caveRadius > 12.0F) {
            this.func_227206_a_(chunk, biomePos, random.nextLong(), seaLevel, chunkX, chunkZ, randOffsetXCoord, startY, randOffsetZCoord, random.nextFloat() * -6.5F + 4.5F, pitch - ((float)Math.PI / 5F), p_227206_16_ / 3.7F, j, p_227206_18_, 18.0D, p_227206_21_);
            this.func_227206_a_(chunk, biomePos, random.nextLong(), seaLevel, chunkX, chunkZ, randOffsetXCoord, startY, randOffsetZCoord, random.nextFloat() * -0.5F + -3.5F, pitch + ((float)Math.PI / 7F), p_227206_16_ / 5.9F, j, p_227206_18_, 31.0D, p_227206_21_);
            return;
         }

         if (random.nextInt(7) != 3) {
            if (!this.func_222702_a(chunkX, chunkZ, randOffsetXCoord, randOffsetZCoord, j, p_227206_18_, caveRadius)) {
               return;
            }

            this.func_227208_a_(chunk, biomePos, seed, seaLevel, chunkX, chunkZ, randOffsetXCoord, startY, randOffsetZCoord, d0, d1, p_227206_21_);
         }
      }

   }

   protected boolean func_222708_a(double p_222708_1_, double p_222708_3_, double p_222708_5_, int p_222708_7_) {
      return p_222708_3_ <= -5.7D || p_222708_1_ * p_222708_1_ + p_222708_3_ * p_222708_3_ + p_222708_5_ * p_222708_5_ >= 13.6D;
   }
}