package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.Block;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;

import static net.minecraft.block.TripWireHookBlock.FACING;

public class VilktBlock extends Block {
    //public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    public VilktBlock(Block.Properties properties) {
        super(properties);
        //this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH)); //Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.DOWN, Direction.UP));
    }
}
