package com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.l.UnusedBlockInit;
import com.babcsany.minecraft.init.BlockInit;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class MigSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
   public MigSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232124_1_) {
      super(p_i232124_1_);
   }

   public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
      this.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, config.getTop(), config.getUnder(), config.getUnderWaterMaterial(), seaLevel);
   }

   protected void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, BlockState top, BlockState middle, BlockState bottom, int sealevel) {
      BlockState blockstate = top;
      BlockState blockState1 = middle;
      BlockPos.Mutable blockPos$mutable = new BlockPos.Mutable();
      int i = -1;
      int j = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
      int k = x & 15;
      int l = z & 15;

      for(int i1 = startHeight; i1 >= 0; --i1) {
         blockPos$mutable.setPos(k, i1, l);
         BlockState blockState2 = chunkIn.getBlockState(blockPos$mutable);
         if (blockState2.isAir()) {
            i = -1;
         } else if (blockState2.isIn(defaultBlock.getBlock())) {
            if (i == -1) {
               if (j <= 0) {
                  blockstate = isBurnableBlockItemInit.LEAT_BLOCK.get().getDefaultState();
                  blockState1 = defaultBlock;
               } else if (i1 >= sealevel - 4 && i1 <= sealevel + 1) {
                  blockstate = top;
                  blockState1 = middle;
               }

               if (i1 < sealevel && blockstate.isAir()) {
                  if (biomeIn.getTemperature(blockPos$mutable.setPos(x, i1, z)) < 0.15F) {
                     blockstate = BlockInit.FIRT_BLOCK.get().getDefaultState();
                  } else {
                     blockstate = defaultFluid;
                  }

                  blockPos$mutable.setPos(k, i1, l);
               }

               i = j;
               if (i1 >= sealevel - 1) {
                  chunkIn.setBlockState(blockPos$mutable, blockstate, false);
               } else if (i1 < sealevel - 7 - j) {
                  blockstate = UnusedBlockInit.AIR.get().getDefaultState();
                  blockState1 = defaultBlock;
                  chunkIn.setBlockState(blockPos$mutable, bottom, false);
               } else {
                  chunkIn.setBlockState(blockPos$mutable, blockState1, false);
               }
            } else if (i > 0) {
               --i;
               chunkIn.setBlockState(blockPos$mutable, blockState1, false);
               if (i == 0 && blockState1.isIn(BlockItemInit.FRIT_BLOCK.get()) && j > 1) {
                  i = random.nextInt(4) + Math.max(0, i1 - 63);
                  blockState1 = blockState1.isIn(BlockItemInit.KALT_BLOCK.get()) ? isBurnableBlockItemInit.SRIUNK_BLOCK.get().getDefaultState() : BlockItemInit.FRIT_BLOCK.get().getDefaultState();
               }
            }
         }
      }

   }
}
