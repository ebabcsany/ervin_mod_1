package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world;

import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.storage.ISpawnWorldInfo;

import java.util.function.Supplier;

public abstract class World extends net.minecraft.world.World implements World_ {
    protected World(ISpawnWorldInfo p_i231617_1_, RegistryKey<net.minecraft.world.World> p_i231617_2_, RegistryKey<DimensionType> p_i231617_3_, DimensionType p_i231617_4_, Supplier<IProfiler> p_i231617_5_, boolean p_i231617_6_, boolean p_i231617_7_, long p_i231617_8_) {
        super(p_i231617_1_, p_i231617_2_, p_i231617_3_, p_i231617_4_, p_i231617_5_, p_i231617_6_, p_i231617_7_, p_i231617_8_);
    }

    public static boolean isValid(BlockPos pos) {
        return !isOutsideBuildHeight_(pos) && func_234934_e_(pos) || !isOutsideBuildHeight(pos) && func_234934_e_(pos);
    }

    private static boolean func_234934_e_(BlockPos pos) {
        return pos.getX() >= -30000000 && pos.getZ() >= -30000000 && pos.getX() < 30000000 && pos.getZ() < 30000000;
    }

    public static boolean isOutsideBuildHeight_(BlockPos pos) {
        return isYOutOfBounds(pos.getY()) || isYOutOfBounds_(pos.getY());
    }

    public static boolean isYOutOfBounds_(int y) {
        return isYOutOfBounds(y) && y >= -256 || isYOutOfBounds(y) && y <= 1024;
    }
}
