package com.babcsany.minecraft.ervin_mod_1.util.math;

import jdk.nashorn.internal.ir.annotations.Immutable;
import net.minecraft.block.BlockState;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;

@Immutable
public class ModBlockPos extends BlockPos {
    public ModBlockPos(int p_i46030_1_, int p_i46030_2_, int p_i46030_3_) {
        super(p_i46030_1_, p_i46030_2_, p_i46030_3_);
    }

    public ModBlockPos(double p_i46031_1_, double p_i46031_3_, double p_i46031_5_) {
        super(p_i46031_1_, p_i46031_3_, p_i46031_5_);
    }

    public ModBlockPos(Vector3d p_i47100_1_) {
        super(p_i47100_1_);
    }

    public ModBlockPos(IPosition p_i50799_1_) {
        super(p_i50799_1_);
    }

    public ModBlockPos(Vector3i p_i46034_1_) {
        super(p_i46034_1_);
    }

    public static boolean setWorldPos(Entity entity, int up, int down, int north, int south, int west, int east, BlockState state) {
        return entity.getEntityWorld().setBlockState(getEntityPos(entity, up, down, north, south, west, east), state);
    }

    public static BlockPos getEntityPos(Entity entity, int up, int down, int north, int south, int west, int east) {
        return entity.getPosition().up(up).down(down).north(north).south(south).west(west).east(east);
    }
}
