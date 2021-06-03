package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.block.ExamplePortalBlock;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;

import java.util.Objects;
import java.util.Random;

import static net.minecraft.block.AbstractFireBlock.getFireForPlacement;

public class Air extends Block {
    private static final int BOUND_X = 3;
    private static final int BOUND_Y = 3;
    private static final int BOUND_Z = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_15;
    public Air(Block.Properties properties) {
        super(properties);
    }

    public static BlockState getAirForPlacement(IBlockReader reader, BlockPos pos) {
        return BlockItemInit.AIR.get().getDefaultState();
    }

    private static boolean shouldLightPortal(IWorld world, BlockPos pos) {
        for(Direction direction : Direction.Plane.HORIZONTAL) {
            if (world.getBlockState(pos.offset(direction)).isIn(BlockItemInit.EXAMPLE_BLOCK.get()) && ExamplePortalBlock.isExamplePortal(world, pos) != null) {
                return true;
            }
        }

        return false;
    }

    private static boolean isScrafthConditions(BlockState state, IWorldReader worldReader, BlockPos pos) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = worldReader.getBlockState(blockpos);
        if (blockstate.isIn(BlockInit.SCRAFTH.get())) {
            return true;
        } else if (blockstate.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = LightEngine.func_215613_a(worldReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getOpacity(worldReader, blockpos));
            return i < worldReader.getMaxLightLevel();
        }
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!isScrafthConditions(state, worldIn, pos)) {
            if (!worldIn.isAreaLoaded(pos, 4)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            worldIn.setBlockState(pos, BlockInit.SCRAFTH.get().getDefaultState());
        }/* else {
            if (worldIn.getLight(pos.up()) >= 9) {
                BlockState blockstate = this.getDefaultState();

                for(int i = 0; i < 6; ++i) {
                    BlockPos blockpos = pos.add(random.nextInt(BOUND_X) - 1, random.nextInt(BOUND_Y) - 1, random.nextInt(BOUND_Z) - 1);
                    if (worldIn.getBlockState(blockpos).isIn(BlockInit.SCRAFTH.get())) {
                        worldIn.setBlockState(blockpos, blockstate);
                    }
                }
            }

        }*/
    }
}
