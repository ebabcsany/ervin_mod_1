package com.babcsany.minecraft.ervin_mod_1.forge.common.extensions;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public interface IForgeBlock {

    default boolean isExamplePortalFrame(BlockState state, IWorldReader world, BlockPos pos)
    {
        return state.isIn(BlockItemInit.GRITK_BLOCK.get());
    }
}
