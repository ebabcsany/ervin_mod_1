package com.babcsany.minecraft.ervin_mod_1.forge.common.extensions;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public interface IForgeBlockState {

    default BlockState getBlockState()
    {
        return (BlockState)this;
    }


    default boolean isExamplePortalFrame(IWorldReader world, BlockPos pos)
    {
        return getBlockState().getBlock().isExamplePortalFrame(getBlockState(), world, pos);
    }
}
