package com.babcsany.minecraft.ervin_mod_1.world.gen.carver;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.BlockStateInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockNamedItemInit;
import com.babcsany.minecraft.init.BlockInit;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import org.apache.commons.lang3.mutable.MutableBoolean;

import java.util.BitSet;
import java.util.Random;
import java.util.function.Function;

public class UnderlavaCaveWorldCarver extends CaveWorldCarver {
   public UnderlavaCaveWorldCarver(Codec<ProbabilityConfig> p_i231920_1_) {
      super(p_i231920_1_, 256);
   }

   protected boolean func_222700_a(IChunk chunkIn, int chunkX, int chunkZ, int minX, int maxX, int minY, int maxY, int minZ, int maxZ) {
      return false;
   }

   protected boolean func_230358_a_(IChunk p_230358_1_, Function<BlockPos, Biome> p_230358_2_, BitSet p_230358_3_, Random p_230358_4_, BlockPos.Mutable p_230358_5_, BlockPos.Mutable p_230358_6_, BlockPos.Mutable p_230358_7_, int p_230358_8_, int p_230358_9_, int p_230358_10_, int p_230358_11_, int p_230358_12_, int p_230358_13_, int p_230358_14_, int p_230358_15_, MutableBoolean p_230358_16_) {
      return func_222728_a(this, p_230358_1_, p_230358_3_, p_230358_4_, p_230358_5_, p_230358_8_, p_230358_9_, p_230358_10_, p_230358_11_, p_230358_12_, p_230358_13_, p_230358_14_, p_230358_15_);
   }

   static UnderlavaCaveWorldCarver underlavaCaveWorldCarver;
   protected static boolean func_222728_a(WorldCarver<?> carver, IChunk iChunk, BitSet bitSet, Random random, BlockPos.Mutable mutable, int i3, int i4, int i5, int pos1, int pos3, int i1, int pos2, int i2) {
      if (pos2 >= i3) {
         return false;
      } else {
         int i = i1 | i2 << 4 | pos2 << 8;
         if (bitSet.get(i)) {
            return false;
         } else {
            bitSet.set(i);
            mutable.setPos(pos1, pos2, pos3);
            BlockState blockstate = iChunk.getBlockState(mutable);
            if (!underlavaCaveWorldCarver.isCarvables(blockstate)) {
               return false;
            } else if (pos2 == 10) {
               float f = random.nextFloat();
               if ((double)f < 0.25D) {
                  iChunk.setBlockState(mutable, Blocks.MAGMA_BLOCK.getDefaultState(), false);
                  iChunk.getBlocksToBeTicked().scheduleTick(mutable, Blocks.MAGMA_BLOCK, 0);
               } else {
                  iChunk.setBlockState(mutable, BlockItemInit.DURT.get().getDefaultState(), false);
               }

               return true;
            } else if (pos2 < 10) {
               iChunk.setBlockState(mutable, Blocks.LAVA.getDefaultState(), false);
               return false;
            } else {
               boolean flag = false;

               for(Direction direction : Direction.Plane.HORIZONTAL) {
                  int j = pos1 + direction.getXOffset();
                  int k = pos3 + direction.getZOffset();
                  if (j >> 4 != i4 || k >> 4 != i5 || iChunk.getBlockState(mutable.setPos(j, pos2, k)).isAir()) {
                     iChunk.setBlockState(mutable, LAVA.getBlockState(), false);
                     iChunk.getFluidsToBeTicked().scheduleTick(mutable, LAVA.getFluid(), 0);
                     flag = true;
                     break;
                  }
               }

               mutable.setPos(pos1, pos2, pos3);
               if (!flag) {
                  iChunk.setBlockState(mutable, LAVA.getBlockState(), false);
                  return true;
               } else {
                  return true;
               }
            }
         }
      }
   }

   public boolean isCarvables(BlockState p_222706_1_) {
      return carvableBlocks.contains(p_222706_1_.getBlock());
   }
}