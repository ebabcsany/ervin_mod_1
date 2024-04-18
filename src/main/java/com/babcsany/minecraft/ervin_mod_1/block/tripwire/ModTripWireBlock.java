package com.babcsany.minecraft.ervin_mod_1.block.tripwire;

import com.babcsany.minecraft.ervin_mod_1.block.tripwire.tripwire_hook.ModTripWireHookBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TripWireBlock;
import net.minecraft.block.TripWireHookBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModTripWireBlock extends TripWireBlock {
   private final ModTripWireHookBlock hook;

   public ModTripWireBlock(ModTripWireHookBlock hook, Properties properties) {
      super(hook, properties);
      this.hook = hook;
   }

   public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
      if (!isMoving && !state.matchesBlock(newState.getBlock())) {
         this.notifyHook(worldIn, pos, state.with(POWERED, Boolean.valueOf(true)));
      }
   }

   private void notifyHook(World worldIn, BlockPos pos, BlockState state) {
      for(Direction direction : new Direction[]{Direction.SOUTH, Direction.WEST}) {
         for(int i = 1; i < 42; ++i) {
            BlockPos blockpos = pos.offset(direction, i);
            BlockState blockstate = worldIn.getBlockState(blockpos);
            if (blockstate.matchesBlock(this.hook)) {
               if (blockstate.get(TripWireHookBlock.FACING) == direction.getOpposite()) {
                  this.hook.calculateState(worldIn, blockpos, blockstate, false, true, i, state);
               }
               break;
            }

            if (!blockstate.matchesBlock(this)) {
               break;
            }
         }
      }

   }

   public boolean shouldConnectTo(BlockState state, Direction direction) {
      Block block = state.getBlock();
      if (block == this.hook) {
         return state.get(TripWireHookBlock.FACING) == direction.getOpposite();
      } else {
         return block == this;
      }
   }
}