package com.babcsany.minecraft.world.gen.surfacebuilders;

import com.babcsany.minecraft.init.BlockInit;
import com.babcsany.minecraft.init.lc.block.LcBlockInit;
import com.babcsany.minecraft.init.lc.block.blocks.H_u_fBlockInit;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class DefaultSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
   public DefaultSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232124_1_) {
      super(p_i232124_1_);
   }

   public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
      this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, config.getTop(), config.getUnder(), config.getUnderWaterMaterial(), seaLevel);
   }

   protected void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState middle, BlockState bottom, int sealevel) {
      BlockState blockstate = top;
      BlockState blockstate1 = middle;
      BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
      int i = -1;
      int j = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
      int k = x & 15;
      int l = z & 15;

      for(int i1 = startHeight; i1 >= 0; --i1) {
         blockpos$mutable.setPos(k, i1, l);
         BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
         if (blockstate2.isAir()) {
            i = -1;
         } else if (blockstate2.isIn(defaultBlock.getBlock())) {
            if (i == -1) {
               if (j <= 0) {
                  blockstate = LcBlockInit.FI_RT_PLOCK.getDefaultState();
                  blockstate1 = defaultBlock;
               } else if (i1 >= sealevel - 4 && i1 <= sealevel + 1) {
                  blockstate = top;
                  blockstate1 = middle;
               }

               if (i1 < sealevel && (blockstate == null || blockstate.isAir())) {
                  if (biomeIn.getTemperature(blockpos$mutable.setPos(x, i1, z)) < 0.15F) {
                     blockstate = BlockInit.CHAIN_FRISZERN.getDefaultState();
                  } else {
                     blockstate = defaultFluid;
                  }

                  blockpos$mutable.setPos(k, i1, l);
               }

               i = j;
               if (i1 >= sealevel - 1) {
                  chunkIn.setBlockState(blockpos$mutable, blockstate, false);
               } else if (i1 < sealevel - 7 - j) {
                  blockstate = H_u_fBlockInit.H_U_F_BLOCK.getDefaultState();
                  blockstate1 = defaultBlock;
                  chunkIn.setBlockState(blockpos$mutable, bottom, false);
               } else {
                  chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
               }
            } else if (i > 0) {
               --i;
               chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
               if (i == 0 && blockstate1.isIn(BlockInit.FRISZERN) && j > 1) {
                  i = random.nextInt(4) + Math.max(0, i1 - 63);
                  blockstate1 = blockstate1.isIn(BlockInit.TRIRIJ) ? LcBlockInit.FI_RT_PLOCK.getDefaultState() : BlockInit.FIRT_BLOCK.getDefaultState();
               }
            }
         }
      }

   }
}
