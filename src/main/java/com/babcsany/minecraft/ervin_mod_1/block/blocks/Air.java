package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.block.ExamplePortalBlock;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import java.util.Objects;

import static net.minecraft.block.AbstractFireBlock.getFireForPlacement;

public class Air extends Block {
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
}
