package com.babcsany.minecraft.ervin_mod_1.block.tripwire.tripwire_hook;

import com.google.common.base.MoreObjects;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ModTripWireHookBlock extends TripWireHookBlock {
   public ModTripWireHookBlock(Properties properties) {
      super(properties);
   }

   public Block getTripWire() {
      return Blocks.TRIPWIRE;
   }

   public Block getTripWireHook() {
      return Blocks.TRIPWIRE_HOOK;
   }

   public void calculateState(World worldIn, BlockPos pos, BlockState hookState, boolean attaching, boolean shouldNotifyNeighbours, int searchRange, @Nullable BlockState state) {
      Direction direction = hookState.get(FACING);
      boolean flag = hookState.get(ATTACHED);
      boolean flag1 = hookState.get(POWERED);
      boolean flag2 = !attaching;
      boolean flag3 = false;
      int i = 0;
      BlockState[] ablockstate = new BlockState[42];

      for(int j = 1; j < 42; ++j) {
         BlockPos blockpos = pos.offset(direction, j);
         BlockState blockstate = worldIn.getBlockState(blockpos);
         if (blockstate.matchesBlock(getTripWireHook())) {
            if (blockstate.get(FACING) == direction.getOpposite()) {
               i = j;
            }
            break;
         }

         if (!blockstate.matchesBlock(getTripWire()) && j != searchRange) {
            ablockstate[j] = null;
            flag2 = false;
         } else {
            if (j == searchRange) {
               blockstate = MoreObjects.firstNonNull(state, blockstate);
            }

            boolean flag4 = !blockstate.get(TripWireBlock.DISARMED);
            boolean flag5 = blockstate.get(TripWireBlock.POWERED);
            flag3 |= flag4 && flag5;
            ablockstate[j] = blockstate;
            if (j == searchRange) {
               worldIn.getPendingBlockTicks().scheduleTick(pos, this, 10);
               flag2 &= flag4;
            }
         }
      }

      flag2 = flag2 & i > 1;
      flag3 = flag3 & flag2;
      BlockState blockstate1 = this.getDefaultState().with(ATTACHED, Boolean.valueOf(flag2)).with(POWERED, Boolean.valueOf(flag3));
      if (i > 0) {
         BlockPos blockpos1 = pos.offset(direction, i);
         Direction direction1 = direction.getOpposite();
         worldIn.setBlockState(blockpos1, blockstate1.with(FACING, direction1), 3);
         this.notifyNeighbors(worldIn, blockpos1, direction1);
         this.playSound(worldIn, blockpos1, flag2, flag3, flag, flag1);
      }

      this.playSound(worldIn, pos, flag2, flag3, flag, flag1);
      if (!attaching) {
         worldIn.setBlockState(pos, blockstate1.with(FACING, direction), 3);
         if (shouldNotifyNeighbours) {
            this.notifyNeighbors(worldIn, pos, direction);
         }
      }

      if (flag != flag2) {
         for(int k = 1; k < i; ++k) {
            BlockPos blockpos2 = pos.offset(direction, k);
            BlockState blockstate2 = ablockstate[k];
            if (blockstate2 != null) {
               worldIn.setBlockState(blockpos2, blockstate2.with(ATTACHED, Boolean.valueOf(flag2)), 3);
               if (!worldIn.getBlockState(blockpos2).isAir()) {
               }
            }
         }
      }

   }

   private void playSound(World worldIn, BlockPos pos, boolean attaching, boolean activated, boolean detaching, boolean deactivating) {
      if (activated && !deactivating) {
         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_TRIPWIRE_CLICK_ON, SoundCategory.BLOCKS, 0.4F, 0.6F);
      } else if (!activated && deactivating) {
         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_TRIPWIRE_CLICK_OFF, SoundCategory.BLOCKS, 0.4F, 0.5F);
      } else if (attaching && !detaching) {
         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_TRIPWIRE_ATTACH, SoundCategory.BLOCKS, 0.4F, 0.7F);
      } else if (!attaching && detaching) {
         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_TRIPWIRE_DETACH, SoundCategory.BLOCKS, 0.4F, 1.2F / (worldIn.rand.nextFloat() * 0.2F + 0.9F));
      }

   }

   private void notifyNeighbors(World worldIn, BlockPos pos, Direction side) {
      worldIn.notifyNeighborsOfStateChange(pos, this);
      worldIn.notifyNeighborsOfStateChange(pos.offset(side.getOpposite()), this);
   }
}