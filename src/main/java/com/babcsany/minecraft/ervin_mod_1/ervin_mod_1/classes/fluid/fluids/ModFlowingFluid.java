package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.fluid.fluids;

import com.babcsany.minecraft.fluid.block.ModFlowingFluidBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public abstract class ModFlowingFluid extends ForgeFlowingFluid {

    private final Supplier<? extends Fluid> flowing;
    private final Supplier<? extends Fluid> still;
    @Nullable
    private final Supplier<? extends Item> bucket;
    @Nullable
    private final Supplier<? extends ModFlowingFluidBlock> block;
    private final Supplier<? extends net.minecraft.block.FlowingFluidBlock> block1;
    private final FluidAttributes.Builder builder;
    private final boolean canMultiply;
    private final int slopeFindDistance;
    private final int levelDecreasePerBlock;
    private final float explosionResistance;
    private final int tickRate;

    protected ModFlowingFluid(Properties properties)
    {
        super(properties);
        this.flowing = properties.flowing;
        this.still = properties.still;
        this.builder = properties.attributes;
        this.canMultiply = properties.canMultiply;
        this.bucket = properties.bucket;
        this.block = properties.block;
        this.block1 = properties.block1;
        this.slopeFindDistance = properties.slopeFindDistance;
        this.levelDecreasePerBlock = properties.levelDecreasePerBlock;
        this.explosionResistance = properties.explosionResistance;
        this.tickRate = properties.tickRate;
    }

    @Override
    public Fluid getFlowingFluid()
    {
        return flowing.get();
    }

    @Override
    public Fluid getStillFluid()
    {
        return still.get();
    }

    @Override
    protected boolean canSourcesMultiply()
    {
        return canMultiply;
    }

    @Override
    protected void beforeReplacingBlock(IWorld worldIn, BlockPos pos, BlockState state)
    {
        TileEntity tileentity = state.getBlock().hasTileEntity(state) ? worldIn.getTileEntity(pos) : null;
        Block.spawnDrops(state, worldIn.getWorld(), pos, tileentity);
    }

    @Override
    protected int getSlopeFindDistance(IWorldReader worldIn)
    {
        return slopeFindDistance;
    }

    @Override
    protected int getLevelDecreasePerBlock(IWorldReader worldIn)
    {
        return levelDecreasePerBlock;
    }

    @Override
    public Item getFilledBucket()
    {
        return bucket != null ? bucket.get() : Items.AIR;
    }

    @Override
    protected boolean canDisplace(FluidState state, IBlockReader world, BlockPos pos, Fluid fluidIn, Direction direction)
    {
        // Based on the water implementation, may need to be overriden for mod fluids that shouldn't behave like water.
        return direction == Direction.DOWN && !isEquivalentTo(fluidIn);
    }

    @Override
    public int getTickRate(IWorldReader world)
    {
        return tickRate;
    }

    @Override
    protected float getExplosionResistance()
    {
        return explosionResistance;
    }

    @Override
    protected BlockState getBlockState(FluidState state)
    {
        if (block != null)
            return block.get().getDefaultState().with(ModFlowingFluidBlock.LEVEL, getLevelFromState(state));
        return Blocks.AIR.getDefaultState();
    }

    protected BlockState getBlockState1(FluidState state)
    {
        if (block1 != null)
            return block1.get().getDefaultState().with(ModFlowingFluidBlock.LEVEL, getLevelFromState(state));
        return Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean isEquivalentTo(Fluid fluidIn) {
        return fluidIn == still.get() || fluidIn == flowing.get();
    }

    @Override
    protected FluidAttributes createAttributes()
    {
        return builder.build(this);
    }

    public static class Flowing extends ModFlowingFluid
    {
        public Flowing(ModFlowingFluid.Properties properties)
        {
            super(properties);
            setDefaultState(getStateContainer().getBaseState().with(LEVEL_1_8, 7));
        }

        protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        public int getLevel(FluidState state) {
            return state.get(LEVEL_1_8);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends ModFlowingFluid
    {
        public Source(ModFlowingFluid.Properties properties)
        {
            super(properties);
        }

        public int getLevel(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Properties extends ForgeFlowingFluid.Properties
    {
        private final Supplier<? extends Fluid> still;
        private final Supplier<? extends Fluid> flowing;
        private final FluidAttributes.Builder attributes;
        private boolean canMultiply;
        private Supplier<? extends Item> bucket;
        private Supplier<? extends ModFlowingFluidBlock> block;
        private Supplier<? extends net.minecraft.block.FlowingFluidBlock> block1;
        private int slopeFindDistance = 4;
        private int levelDecreasePerBlock = 1;
        private float explosionResistance = 1;
        private int tickRate = 5;

        public Properties(Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing, FluidAttributes.Builder attributes)
        {
            super(still, flowing, attributes);
            this.still = still;
            this.flowing = flowing;
            this.attributes = attributes;
        }

        public Properties canMultiply()
        {
            canMultiply = true;
            return this;
        }

        public Properties bucket(Supplier<? extends Item> bucket)
        {
            this.bucket = bucket;
            return this;
        }

        public Properties block1(Supplier<? extends ModFlowingFluidBlock> block)
        {
            this.block = block;
            return this;
        }

        public Properties block(Supplier<? extends net.minecraft.block.FlowingFluidBlock> block)
        {
            this.block1 = block;
            return this;
        }

        public Properties slopeFindDistance(int slopeFindDistance)
        {
            this.slopeFindDistance = slopeFindDistance;
            return this;
        }

        public Properties levelDecreasePerBlock(int levelDecreasePerBlock)
        {
            this.levelDecreasePerBlock = levelDecreasePerBlock;
            return this;
        }

        public Properties explosionResistance(float explosionResistance)
        {
            this.explosionResistance = explosionResistance;
            return this;
        }

        public Properties tickRate(int tickRate)
        {
            this.tickRate = tickRate;
            return this;
        }
    }
}
