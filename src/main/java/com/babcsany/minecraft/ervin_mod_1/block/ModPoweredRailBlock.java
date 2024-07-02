package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.state.properties.RailShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ModPoweredRailBlock extends PoweredRailBlock {
   @SuppressWarnings("UnusedDeclaration")
   public ModPoweredRailBlock(Properties builder) {
      super(builder);
   }

   public ModPoweredRailBlock(Properties builder, boolean isPoweredRail) {
      super(builder, isPoweredRail);
   }

   @Override
   protected boolean findPoweredRailSignal(World worldIn, BlockPos pos, BlockState state, boolean searchForward, int recursionCount) {
      if (recursionCount >= 56) {
         return false;
      } else {
         int i = pos.getX();
         int j = pos.getY();
         int k = pos.getZ();
         boolean flag = true;
         RailShape railshape = state.get(SHAPE);
         switch (railshape) {
            case NORTH_SOUTH:
               if (searchForward) {
                  ++k;
               } else {
                  --k;
               }
               break;
            case EAST_WEST:
               if (searchForward) {
                  --i;
               } else {
                  ++i;
               }
               break;
            case ASCENDING_EAST:
               if (searchForward) {
                  --i;
               } else {
                  ++i;
                  ++j;
                  flag = false;
               }

               railshape = RailShape.EAST_WEST;
               break;
            case ASCENDING_WEST:
               if (searchForward) {
                  --i;
                  ++j;
                  flag = false;
               } else {
                  ++i;
               }

               railshape = RailShape.EAST_WEST;
               break;
            case ASCENDING_NORTH:
               if (searchForward) {
                  ++k;
               } else {
                  --k;
                  ++j;
                  flag = false;
               }

               railshape = RailShape.NORTH_SOUTH;
               break;
            case ASCENDING_SOUTH:
               if (searchForward) {
                  ++k;
                  ++j;
                  flag = false;
               } else {
                  --k;
               }

               railshape = RailShape.NORTH_SOUTH;
         }

         if (this.isSamePoweredRail(worldIn, new BlockPos(i, j, k), searchForward, recursionCount, railshape)) {
            return true;
         } else {
            return flag && this.isSamePoweredRail(worldIn, new BlockPos(i, j - 1, k), searchForward, recursionCount, railshape);
         }
      }
   }

   @Override
   public boolean isActivatorRail() {
      return super.isActivatorRail();
   }

   @Override
   public float getRailMaxSpeed(BlockState state, World world, BlockPos pos, AbstractMinecartEntity cart) {
      return 3.0F;
   }
}