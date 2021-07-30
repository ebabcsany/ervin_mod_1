package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public interface IBucketPickupHandler {
   Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state);
}
