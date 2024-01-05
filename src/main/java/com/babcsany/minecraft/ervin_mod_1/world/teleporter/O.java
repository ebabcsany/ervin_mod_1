package com.babcsany.minecraft.ervin_mod_1.world.teleporter;

import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;

import javax.annotation.Nullable;

public interface O {
    boolean placeInExamplePortal(Entity entity, float p_222268_2_);

    @Nullable
    BlockPattern.PortalInfo placeInExistingExamplePortal(BlockPos p_222272_1_, Vector3d p_222272_2_, Direction directionIn, double p_222272_4_, double p_222272_6_, boolean p_222272_8_);

    boolean makeExamplePortal(Entity entityIn);
}
