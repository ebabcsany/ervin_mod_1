package com.babcsany.minecraft.fluid;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.init.BlockInit;
import com.babcsany.minecraft.init.FluidInit;
import com.babcsany.minecraft.init.item.ItemInit;
import com.babcsany.minecraft.tags.FluidTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import com.babcsany.minecraft.fluid.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class JurkFluid extends LavaFluid {
    public Fluid getFlowingFluid() {
        return FluidInit.FLOWING_JURK;
    }

    public Fluid getStillFluid() {
        return FluidInit.JURK;
    }

    public Item getFilledBucket() {
        return ItemInit.JURK_BUCKET;
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

    public void randomTick(World worldIn, BlockPos pos, FluidState state, Random random) {
        if (worldIn.getGameRules().getBoolean(GameRules.KEEP_INVENTORY)) {
            int i = random.nextInt(3);
            if (i > 0) {
                BlockPos blockpos = pos;

                for(int j = 0; j < i; ++j) {
                    blockpos = blockpos.add(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
                    if (!worldIn.isBlockPresent(blockpos)) {
                        return;
                    }
                }
            } else {
                for(int k = 0; k < 3; ++k) {
                    BlockPos blockpos1 = pos.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                    if (!worldIn.isBlockPresent(blockpos1)) {
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

    public int getSlopeFindDistance(IWorldReader worldIn) {
        return worldIn.func_230315_m_().func_236040_e_() ? 4 : 2;
    }

    protected boolean canSourcesMultiply() {
        return true;
    }

    protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state) {
        TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
        Block.spawnDrops(state, worldIn.getWorld(), pos, tileentity);
    }

    public BlockState getBlockState(FluidState state) {
        return BlockInit.JURK.getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
    }

    public boolean isEquivalentTo(Fluid fluidIn) {
        return fluidIn == FluidInit.JURK || fluidIn == FluidInit.FLOWING_JURK;
    }

    public int getLevelDecreasePerBlock(IWorldReader worldIn) {
        return 1;
    }

    public int getTickRate(IWorldReader p_205569_1_) {
        return 5;
    }

    public boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction) {
        return fluidState.getActualHeight(blockReader, pos) >= 0.44444445F && !fluid.isIn(FluidTags.JURK);
    }

    private void triggerEffects(IWorld p_205581_1_, BlockPos p_205581_2_) {
        p_205581_1_.playEvent(1501, p_205581_2_, 0);
    }

    protected void flowInto(IWorld worldIn, BlockPos pos, BlockState blockStateIn, Direction direction, FluidState fluidStateIn) {
        if (direction == Direction.DOWN) {
            FluidState fluidstate = worldIn.getFluidState(pos);
            if (this.isIn(FluidTags.JURK) && fluidstate.isTagged(net.minecraft.tags.FluidTags.WATER)) {
                if (blockStateIn.getBlock() instanceof FlowingFluidBlock) {
                    worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
                }
            }
            if (this.isIn(FluidTags.JURK) && fluidstate.isTagged(net.minecraft.tags.FluidTags.LAVA)) {
                if (blockStateIn.getBlock() instanceof FlowingFluidBlock) {
                    worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
                }
            }
            if (this.isIn(net.minecraft.tags.FluidTags.LAVA) && fluidstate.isTagged(FluidTags.JURK)) {
                if (blockStateIn.getBlock() instanceof FlowingFluidBlock) {
                    worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
                }
            }
            if (this.isIn(net.minecraft.tags.FluidTags.WATER) && fluidstate.isTagged(FluidTags.JURK)) {
                if (blockStateIn.getBlock() instanceof FlowingFluidBlock) {
                    worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, BlockItemInit.DURTGURBF.get().getDefaultState()), 3);
                }
            }
        }

        super.flowInto(worldIn, pos, blockStateIn, direction, fluidStateIn);
    }

    protected float getExplosionResistance() {
        return 100.0F;
    }

    public static class Flowing extends JurkFluid {
        protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL_1_8);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends JurkFluid {
        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
