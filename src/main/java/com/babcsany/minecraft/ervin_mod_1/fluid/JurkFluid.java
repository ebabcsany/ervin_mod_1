package com.babcsany.minecraft.ervin_mod_1.fluid;

import com.babcsany.minecraft.ervin_mod_1.block.FlowingFluidBlock1;
import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.FluidInit;
import com.babcsany.minecraft.ervin_mod_1.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import com.babcsany.minecraft.ervin_mod_1.tags.FluidTag;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class JurkFluid extends FlowingFluid {
   public Fluid getFlowingFluid() {
      return FluidInit.FLOWING_JURK.get();
   }

   public Fluid getStillFluid() {
      return FluidInit.JURK.get();
   }

   public Item getFilledBucket() {
      return ItemInit.JURK_BUCKET.get();
   }

   @OnlyIn(Dist.CLIENT)
   public void animateTick(World worldIn, BlockPos pos, FluidState state, Random random) {
      if (!state.isSource() && !state.get(FALLING)) {
         if (random.nextInt(64) == 0) {
            worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
         }
      } else if (random.nextInt(10) == 0) {
         worldIn.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + random.nextDouble(), (double)pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
      }

   }

   @Nullable
   @OnlyIn(Dist.CLIENT)
   public IParticleData getDripParticleData() {
      return ParticleTypes.DRIPPING_WATER;
   }

   protected boolean canSourcesMultiply() {
      return true;
   }

   protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
      TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
      Block.spawnDrops(state, worldIn.getWorld(), pos, tileentity);
   }

   public int getSlopeFindDistance(IWorldReader worldIn) {
      return 4;
   }

   public BlockState getBlockState(FluidState state) {
      return BlockInit.JURK.get().getDefaultState().with(FlowingFluidBlock1.LEVEL, Integer.valueOf(getLevelFromState(state)));
   }

   public boolean isEquivalentTo(Fluid fluidIn) {
      return fluidIn == FluidInit.JURK.get() || fluidIn == FluidInit.FLOWING_JURK.get();
   }

   public int getLevelDecreasePerBlock(IWorldReader worldIn) {
      return 1;
   }

   public int getTickRate(IWorldReader p_205569_1_) {
      return 5;
   }

   public boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
      return direction == Direction.DOWN && !fluid.isIn(FluidTag.JURK);
   }

   protected float getExplosionResistance() {
      return 100.0F;
   }

   public static class Flowing extends JurkFluid {
      protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
         super.fillStateContainer(builder);
         builder.add(LEVEL_1_8);
      }

      public int getLevel(FluidState p_207192_1_) {
         return p_207192_1_.get(LEVEL_1_8);
      }

      public boolean isSource(FluidState state) {
         return false;
      }
   }

   public static class Source extends JurkFluid {
      public int getLevel(FluidState p_207192_1_) {
         return 6;
      }

      public boolean isSource(FluidState state) {
         return true;
      }
   }
}