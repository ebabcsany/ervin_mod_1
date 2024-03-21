package com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.from_sponge;

import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.google.common.collect.Lists;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Queue;

public class Retrug extends SpongeBlock {
   public Retrug(Properties properties) {
      super(properties);
   }

   protected void tryAbsorb(World worldIn, BlockPos pos) {
      if (this.absorb(worldIn, pos)) {
         worldIn.setBlockState(pos, isBurnableBlockItemInit.TRURK.get().getDefaultState(), 2);
         worldIn.playEvent(2002, pos, Block.getStateId(Blocks.LAVA.getDefaultState()));
      }

   }

   private boolean absorb(World worldIn, BlockPos pos) {
      Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
      queue.add(new Tuple<>(pos, 0));
      int i = 0;

      while(!queue.isEmpty()) {
         Tuple<BlockPos, Integer> tuple = queue.poll();
         BlockPos blockpos = tuple.getA();
         int j = tuple.getB();

         for(Direction direction : Direction.values()) {
            BlockPos blockpos1 = blockpos.offset(direction);
            BlockState blockstate = worldIn.getBlockState(blockpos1);
            FluidState fluidstate = worldIn.getFluidState(blockpos1);
            Material material = blockstate.getMaterial();
            if (fluidstate.isTagged(FluidTags.LAVA)) {
               if (blockstate.getBlock() instanceof IBucketPickupHandler && ((IBucketPickupHandler)blockstate.getBlock()).pickupFluid(worldIn, blockpos1, blockstate) != Fluids.EMPTY) {
                  ++i;
                  if (j < 6) {
                     queue.add(new Tuple<>(blockpos1, j + 1));
                  }
               } else if (blockstate.getBlock() instanceof FlowingFluidBlock) {
                  worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
                  ++i;
                  if (j < 6) {
                     queue.add(new Tuple<>(blockpos1, j + 1));
                  }
               }
            }
         }

         if (i > 64) {
            break;
         }
      }

      return i > 0;
   }
}