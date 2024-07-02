package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

import java.util.function.Supplier;

public class ModBlock extends Block {
    public ModBlock(Properties properties) {
        super(properties);
    }

    public static VoxelShape makeCuboidShape(double fromX, double fromY, double fromZ, double toX, double toY, double toZ) {
        return Block.makeCuboidShape(fromX, fromY, fromZ, toX, toY, toZ);
    }

    public static Direction getInvertedDirection(Direction direction) {
        if (direction == Direction.UP) {
            direction = Direction.DOWN;
        } else if (direction == Direction.DOWN) {
            direction = Direction.UP;
        } else if (direction == Direction.EAST) {
            direction = Direction.WEST;
        } else if (direction == Direction.WEST) {
            direction = Direction.EAST;
        } else if (direction == Direction.NORTH) {
            direction = Direction.SOUTH;
        } else if (direction == Direction.SOUTH) {
            direction = Direction.NORTH;
        }
        return direction;
    }

    public static void ifDirection(Direction direction, Supplier<?> supplier) {
        if (direction == Direction.UP) {
            direction = Direction.DOWN;
        } else if (direction == Direction.DOWN) {
            direction = Direction.UP;
        } else if (direction == Direction.EAST) {
            direction = Direction.WEST;
        } else if (direction == Direction.WEST) {
            direction = Direction.EAST;
        } else if (direction == Direction.NORTH) {
            direction = Direction.SOUTH;
        } else if (direction == Direction.SOUTH) {
            direction = Direction.NORTH;
        }
    }
}
