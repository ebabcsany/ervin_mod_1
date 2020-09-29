package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;

import java.util.Random;

import static com.babcsany.minecraft.ervin_mod_1.state.ModBlockStateProperties.HORIZONTAL_FACING;

public class Firg extends Block{
    public Firg(Block.Properties properties) { super(properties); }
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final Direction[] GENERATE_DIRECTIONS = new Direction[]{Direction.WEST};
    public static Direction getGenerationDirection(Random rand) {
        return Util.getRandomObject(GENERATE_DIRECTIONS, rand);
    }
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}
