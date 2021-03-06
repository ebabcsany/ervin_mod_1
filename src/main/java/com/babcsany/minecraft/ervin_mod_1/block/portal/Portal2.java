package com.babcsany.minecraft.ervin_mod_1.block.portal;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public interface Portal2 {

    default boolean isAir1(BlockState state, IBlockReader world, BlockPos pos)
    {
        return state.getMaterial() == Material.AIR;
    }

    default boolean isExamplePortalFrame(BlockState state, IWorldReader world, BlockPos pos)
    {
        return state.getBlock() == BlockInit.GRITK_BLOCK1.get();
    }
}
