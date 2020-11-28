package com.babcsany.minecraft.ervin_mod_1.block.portal;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public interface Portal1 {

    default BlockState getBlockState()
    {
        return (BlockState)this;
    }

    default boolean isExamplePortalFrame(IWorldReader world, BlockPos pos)
    {
        return getBlockState().getBlock().isPortalFrame(getBlockState(), world, pos);
    }
}
