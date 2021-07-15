package com.babcsany.minecraft.ervin_mod_1.fluid;

import com.babcsany.minecraft.ervin_mod_1.init.*;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.tags.FluidTag;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.*;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class JurkFluid extends WaterFluid {
   public Fluid getFlowingFluid() {
      return FluidInit.FLOWING_JURK.get();
   }

   public Fluid getStillFluid() {
      return FluidInit.JURK.get();
   }

   public Item getFilledBucket() {
      return ItemInit.JURK_BUCKETI.get();
   }

   @OnlyIn(Dist.CLIENT)
   public void animateTick(World worldIn, BlockPos pos, FluidState state, Random random) {
      BlockPos blockpos = pos.up();
      if (worldIn.getBlockState(blockpos).isAir() && !worldIn.getBlockState(blockpos).isOpaqueCube(worldIn, blockpos)) {
         if (random.nextInt(100) == 0) {
            double d0 = (double)pos.getX() + random.nextDouble();
            double d1 = (double)pos.getY() + 1.0D;
            double d2 = (double)pos.getZ() + random.nextDouble();
            worldIn.addParticle((IParticleData) ParticleTypes.BLOCK, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
         }

         if (random.nextInt(200) == 0) {
            worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
         }
      }

   }

   public void randomTick(World p_207186_1_, BlockPos pos, FluidState state, Random random) {
      if (p_207186_1_.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
         int i = random.nextInt(3);
         if (i > 0) {
            BlockPos blockpos = pos;

            for(int j = 0; j < i; ++j) {
               blockpos = blockpos.add(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
               if (!p_207186_1_.isBlockPresent(blockpos)) {
                  return;
               }
            }
         } else {
            for(int k = 0; k < 3; ++k) {
               BlockPos blockpos1 = pos.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
               if (!p_207186_1_.isBlockPresent(blockpos1)) {
                  return;
               }
            }
         }

      }
   }

   @Nullable
   @OnlyIn(Dist.CLIENT)
   public IParticleData getDripParticleData() {
      return ParticleTypes.DRIPPING_WATER;
   }

   protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
      this.triggerEffects(worldIn, pos);
   }

   public int getSlopeFindDistance(IWorldReader worldIn) {
      return worldIn.func_230315_m_().func_236040_e_() ? 4 : 2;
   }

   public BlockState getBlockState(FluidState state) {
      return Blocks.LAVA.getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
   }

   public boolean isEquivalentTo(Fluid fluidIn) {
         return fluidIn == Fluids.LAVA || fluidIn == Fluids.FLOWING_LAVA;
   }

   public int getLevelDecreasePerBlock(IWorldReader worldIn) {
      return worldIn.func_230315_m_().func_236040_e_() ? 1 : 2;
   }

   public boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
      return fluidState.getActualHeight(blockReader, pos) >= 0.44444445F && fluid.isIn(FluidTag.LAVA);
   }

   public int getTickRate(IWorldReader p_205569_1_) {
      return p_205569_1_.func_230315_m_().func_236040_e_() ? 10 : 30;
   }

   public int func_215667_a(World p_215667_1_, BlockPos p_215667_2_, FluidState p_215667_3_, FluidState p_215667_4_) {
      int i = this.getTickRate(p_215667_1_);
      if (!p_215667_3_.isEmpty() && !p_215667_4_.isEmpty() && !p_215667_3_.get(FALLING) && !p_215667_4_.get(FALLING) && p_215667_4_.getActualHeight(p_215667_1_, p_215667_2_) > p_215667_3_.getActualHeight(p_215667_1_, p_215667_2_) && p_215667_1_.getRandom().nextInt(4) != 0) {
         i *= 4;
      }

      return i;
   }

   private void triggerEffects(IWorld p_205581_1_, BlockPos p_205581_2_) {
      p_205581_1_.playEvent(1501, p_205581_2_, 0);
   }

   protected boolean canSourcesMultiply() {
      return false;
   }

   protected void flowInto(IWorld worldIn, BlockPos pos, BlockState blockStateIn, Direction direction, FluidState fluidStateIn) {
      if (direction == Direction.DOWN) {
         FluidState fluidstate = worldIn.getFluidState(pos);
         if (this.isIn(FluidTag.JURK) && fluidstate.isTagged(FluidTag.LAVA)) {
            if (blockStateIn.getBlock() instanceof FlowingFluidBlock) {
               worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURT.get().getDefaultState()), 3);
            }

            this.triggerEffects(worldIn, pos);
            return;
         }
      }

      super.flowInto(worldIn, pos, blockStateIn, direction, fluidStateIn);
   }

   protected boolean ticksRandomly() {
      return true;
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
         return 8;
      }

      public boolean isSource(FluidState state) {
         return true;
      }
   }
}