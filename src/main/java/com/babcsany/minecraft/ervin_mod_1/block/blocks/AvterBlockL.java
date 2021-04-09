package com.babcsany.minecraft.ervin_mod_1.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class AvterBlockL extends Block implements IBucketPickupHandler1 {
    public AvterBlockL(Properties properties) { super(properties); }

    @Override
    public Block pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
        return null;
    }
}

