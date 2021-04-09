package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nullable;
import java.util.Map;

public class WallOrFloorItem1 extends BlockItem {
   protected final Block wallBlock;

   public WallOrFloorItem1(Block floorBlock, Block wallBlockIn, Properties propertiesIn) {
      super(floorBlock, propertiesIn);
      this.wallBlock = wallBlockIn;
   }

   @Nullable
   protected BlockState getStateForPlacement(BlockItemUseContext context) {
      BlockState blockstate = this.wallBlock.getStateForPlacement(context);
      BlockState blockstate1 = null;
      IWorldReader iworldreader = context.getWorld();
      BlockPos blockpos = context.getPos();

      for(Direction direction : context.getNearestLookingDirections()) {
         if (direction != Direction.UP) {
            BlockState blockstate2 = direction == Direction.DOWN ? this.getBlock().getStateForPlacement(context) : blockstate;
            if (blockstate2 != null && blockstate2.isValidPosition(iworldreader, blockpos)) {
               blockstate1 = blockstate2;
               break;
            }
         }
      }

      return blockstate1 != null && iworldreader.func_226663_a_(blockstate1, blockpos, ISelectionContext.dummy()) ? blockstate1 : null;
   }

   public void addToBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
      super.addToBlockToItemMap(blockToItemMap, itemIn);
      blockToItemMap.put(this.wallBlock, itemIn);
   }

   public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
      super.removeFromBlockToItemMap(blockToItemMap, itemIn);
      blockToItemMap.remove(this.wallBlock);
   }
}