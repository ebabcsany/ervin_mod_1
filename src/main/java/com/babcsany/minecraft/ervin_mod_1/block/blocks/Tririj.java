package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class Tririj extends Block {
   public Tririj(Properties properties) {
      super(properties);
   }

   /**
    * Called when the given entity walks on this Block
    */
   public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
      if (entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn)) {
         entityIn.attackEntityFrom(DamageSource.GENERIC, 1000000000000000000000000000000.0F);
      }

      super.onEntityWalk(worldIn, pos, entityIn);
   }

   /**
    * Update the provided state given the provided neighbor facing and neighbor state, returning a new state.
    * For example, fences make their connections to the passed in state if possible, and wet concrete powder immediately
    * returns its solidified counterpart.
    * Note that this method should ideally consider only the specific face passed in.
    */
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      if (facing == Direction.UP && facingState.isIn(Blocks.WATER)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 20);
      }
      if (facing == Direction.DOWN && facingState.isIn(Blocks.WATER)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 20);
      }
      if (facing == Direction.EAST && facingState.isIn(Blocks.WATER)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 20);
      }
      if (facing == Direction.NORTH && facingState.isIn(Blocks.WATER)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 20);
      }
      if (facing == Direction.SOUTH && facingState.isIn(Blocks.WATER)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 20);
      }
      if (facing == Direction.WEST && facingState.isIn(Blocks.WATER)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 20);
      }

      return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
   }

   /**
    * Performs a random tick on a block.
    */
   public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
      BlockPos blockpos = pos.up();
      if (worldIn.getFluidState(pos).isTagged(FluidTags.WATER)) {
         worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 5000000000000000000000000000000.0F, 26000000000000000000000000000000.0F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);
         worldIn.spawnParticle(ParticleTypes.LARGE_SMOKE, (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.25D, (double)blockpos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
      }

   }

   public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
      worldIn.getPendingBlockTicks().scheduleTick(pos, this, 20);
   }
}