package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class FirgLeaves extends LeavesBlock {
   public FirgLeaves(AbstractBlock.Properties properties) {
      super(properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, 12).with(PERSISTENT, Boolean.FALSE));
   }

   /**
    * Returns whether or not this block is of a type that needs random ticking. Called for ref-counting purposes by
    * ExtendedBlockStorage in order to broadly cull a chunk from the random chunk update list for efficiency's sake.
    */
   public boolean ticksRandomly(BlockState state) {
      return state.get(DISTANCE) == 12 && !state.get(PERSISTENT);
   }

   /**
    * Performs a random tick on a block.
    */
   public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
      if (!state.get(PERSISTENT) && state.get(DISTANCE) == 12) {
         spawnDrops(state, worldIn, pos);
         worldIn.removeBlock(pos, false);
      }

   }

   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      worldIn.setBlockState(pos, updateDistance(state, worldIn, pos), 6);
   }

   public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
      return 2;
   }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      int i = getDistance(facingState) + 1;
      if (i != 1 || stateIn.get(DISTANCE) != i) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 2);
      }

      return stateIn;
   }

   private static BlockState updateDistance(BlockState state, IWorld worldIn, BlockPos pos) {
      int i = 7;
      BlockPos.Mutable blockPos$mutable = new BlockPos.Mutable();

      for(Direction direction : Direction.values()) {
         blockPos$mutable.func_239622_a_(pos, direction);
         i = Math.min(i, getDistance(worldIn.getBlockState(blockPos$mutable)) + 1);
         if (i == 1) {
            break;
         }
      }

      return state.with(DISTANCE, i);
   }

   private static int getDistance(BlockState neighbor) {
      if (BlockTags.LOGS.contains(neighbor.getBlock())) {
         return 0;
      } else {
         return neighbor.getBlock() instanceof FirgLeaves ? neighbor.get(DISTANCE) : 12;
      }
   }

   /**
    * Called periodically clientside on blocks near the player to show effects (like furnace fire particles). Note that
    * this method is unrelated to {@link #randomTick} and will always be called regardless
    * of whether the block can receive random update ticks
    */
   @OnlyIn(Dist.CLIENT)
   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
      if (worldIn.isRainingAt(pos.up())) {
         if (rand.nextInt(15) == 2) {
            BlockPos blockpos = pos.down();
            BlockState blockstate = worldIn.getBlockState(blockpos);
            if (!blockstate.isSolid() || !blockstate.isSolidSide(worldIn, blockpos, Direction.UP)) {
               double d0 = (double)pos.getX() + rand.nextDouble();
               double d1 = (double)pos.getY() - 0.05D;
               double d2 = (double)pos.getZ() + rand.nextDouble();
               worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
         }
      }
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return updateDistance(this.getDefaultState().with(PERSISTENT, Boolean.TRUE), context.getWorld(), context.getPos());
   }
}