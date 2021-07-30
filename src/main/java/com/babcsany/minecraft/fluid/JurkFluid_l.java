package com.babcsany.minecraft.fluid;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.fluid.fluids.ModFlowingFluid;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.fluid.block.ModFlowingFluidBlock;
import com.babcsany.minecraft.tags.FluidTags;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public abstract class JurkFluid_l extends ModFlowingFluid {
   protected JurkFluid_l(Properties properties) {
      super(properties);
   }

   @Override
   @OnlyIn(Dist.CLIENT)
   public void animateTick(World worldIn, BlockPos pos, FluidState state, Random random) {
      if (!state.isSource() && !state.get(FALLING)) {
         if (random.nextInt(64) == 0) {
            worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
         }

         if (random.nextInt(100) == 0) {
            double d0 = (double)pos.getX() + random.nextDouble();
            double d1 = (double)pos.getY() + 1.0D;
            double d2 = (double)pos.getZ() + random.nextDouble();
            worldIn.addParticle(ParticleTypes.LAVA, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
         }

         if (random.nextInt(200) == 0) {
            worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
         }
      } else if (random.nextInt(10) == 0) {
         worldIn.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + random.nextDouble(), (double)pos.getY() + random.nextDouble(), (double)pos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
      }

   }

   @Override
   public void randomTick(World p_207186_1_, BlockPos pos, FluidState state, Random random) {
      if (p_207186_1_.getGameRules().getBoolean(GameRules.KEEP_INVENTORY)) {
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

   @Override
   @Nullable
   @OnlyIn(Dist.CLIENT)
   public IParticleData getDripParticleData() {
      return ParticleTypes.DRIPPING_WATER;
   }

   @Override
   public int getSlopeFindDistance(IWorldReader worldIn) {
      return worldIn.func_230315_m_().func_236040_e_() ? 4 : 2;
   }

   @Override
   public int getLevelDecreasePerBlock(IWorldReader worldIn) {
      return 1;
   }

   @Override
   public int getTickRate(IWorldReader p_205569_1_) {
      return 3;
   }

   @Override
   public boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
      return fluidState.getActualHeight(blockReader, pos) >= 0.44444445F && !fluid.isIn(FluidTags.JURK);
   }

   private void triggerEffects(IWorld p_205581_1_, BlockPos p_205581_2_) {
      p_205581_1_.playEvent(1501, p_205581_2_, 0);
   }

   @Override
   protected void flowInto(IWorld worldIn, BlockPos pos, BlockState blockStateIn, Direction direction, FluidState fluidStateIn) {
      if (direction == Direction.DOWN) {
         FluidState fluidstate = worldIn.getFluidState(pos);
         if (this.isIn(FluidTags.JURK) && fluidstate.isTagged(net.minecraft.tags.FluidTags.WATER)) {
            if (blockStateIn.getBlock() instanceof ModFlowingFluidBlock) {
               worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
            }

            if (blockStateIn.getBlock() instanceof net.minecraft.block.FlowingFluidBlock) {
               worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
            }

            this.triggerEffects(worldIn, pos);
            return;
         }
      }
      if (direction == Direction.DOWN) {
         FluidState fluidstate = worldIn.getFluidState(pos);
         if (this.isIn(FluidTags.JURK) && fluidstate.isTagged(net.minecraft.tags.FluidTags.LAVA)) {
            if (blockStateIn.getBlock() instanceof ModFlowingFluidBlock) {
               worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
            }

            if (blockStateIn.getBlock() instanceof net.minecraft.block.FlowingFluidBlock) {
               worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
            }

            this.triggerEffects(worldIn, pos);
            return;
         }
      }
      if (direction == Direction.DOWN) {
         FluidState fluidstate = worldIn.getFluidState(pos);
         if (this.isIn(net.minecraft.tags.FluidTags.LAVA) && fluidstate.isTagged(FluidTags.JURK)) {
            if (blockStateIn.getBlock() instanceof ModFlowingFluidBlock) {
               worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
            }

            if (blockStateIn.getBlock() instanceof net.minecraft.block.FlowingFluidBlock) {
               worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
            }

            this.triggerEffects(worldIn, pos);
            return;
         }
      }
      if (direction == Direction.DOWN) {
         FluidState fluidstate = worldIn.getFluidState(pos);
         if (this.isIn(net.minecraft.tags.FluidTags.WATER) && fluidstate.isTagged(FluidTags.JURK)) {
            if (blockStateIn.getBlock() instanceof ModFlowingFluidBlock) {
               worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
            }

            if (blockStateIn.getBlock() instanceof net.minecraft.block.FlowingFluidBlock) {
               worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
            }

            this.triggerEffects(worldIn, pos);
            return;
         }
      }

      super.flowInto(worldIn, pos, blockStateIn, direction, fluidStateIn);
   }

   @Override
   protected float getExplosionResistance() {
      return 100.0F;
   }

   public static class Flowing extends JurkFluid_l {
      public Flowing(ModFlowingFluid.Properties properties)
      {
         super(properties);
         setDefaultState(getStateContainer().getBaseState().with(LEVEL_1_8, 7));
      }

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

   public static class Source extends JurkFluid_l {
      public Source(ModFlowingFluid.Properties properties)
      {
         super(properties);
      }

      public int getLevel(FluidState p_207192_1_) {
         return 8;
      }

      public boolean isSource(FluidState state) {
         return true;
      }
   }
}