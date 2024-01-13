package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.google.common.collect.Lists;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Queue;

public class Grirzt extends Block {
   public Grirzt(Properties properties) {
      super(properties);
   }

   public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
      if (!oldState.isIn(state.getBlock())) {
         this.tryAbsorb(worldIn, pos);
      }
   }

   public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
      this.tryAbsorb(worldIn, pos);
      super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
   }

   protected void tryAbsorb(World worldIn, BlockPos pos) {
      if (this.absorb(worldIn, pos)) {
         worldIn.setBlockState(pos, BlockItemInit.GRIRZT.get().getDefaultState(), 4);
         worldIn.playEvent(2001, pos, Block.getStateId(Blocks.LAVA.getDefaultState()));
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
                  if (j < 60) {
                     queue.add(new Tuple<>(blockpos1, j + 10));
                  }
               } else if (blockstate.getBlock() instanceof FlowingFluidBlock) {
                  worldIn.setBlockState(blockpos1, Blocks.AIR.getDefaultState(), 3);
                  ++i;
                  if (j < 60) {
                     queue.add(new Tuple<>(blockpos1, j + 10));
                  }
               }
            }
         }

         if (i > 120) {
            break;
         }
      }

      return i > 0;
   }
}