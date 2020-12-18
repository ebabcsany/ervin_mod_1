package com.babcsany.minecraft.ervin_mod_1.block.portal;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import net.minecraft.block.BlockState;
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
        return state.getBlock() == BlockInit.EXAMPLE_PORTAL_BLOCK.get();
    }
}
