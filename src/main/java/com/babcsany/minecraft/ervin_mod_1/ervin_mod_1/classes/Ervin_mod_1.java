package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes;

import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.storage.ISpawnWorldInfo;

import java.util.function.Supplier;

public abstract class Ervin_mod_1 extends World {
    protected Ervin_mod_1(ISpawnWorldInfo p_i231617_1_, RegistryKey<World> p_i231617_2_, RegistryKey<DimensionType> p_i231617_3_, DimensionType p_i231617_4_, Supplier<IProfiler> p_i231617_5_, boolean p_i231617_6_, boolean p_i231617_7_, long p_i231617_8_) {
        super(p_i231617_1_, p_i231617_2_, p_i231617_3_, p_i231617_4_, p_i231617_5_, p_i231617_6_, p_i231617_7_, p_i231617_8_);
    }

    public static boolean isValid(BlockPos pos) {
        return !isOutsideBuildHeight(pos) && func_234934_e_(pos);
    }

    public static boolean isOutsideBuildHeight(BlockPos pos) {
        return isYOutOfBounds(pos.getY());
    }

    public static boolean isYOutOfBounds(int y) {
        return y < 0 || y >= 1024;
    }
}
