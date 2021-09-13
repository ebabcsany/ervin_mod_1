package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world;

import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.DimensionType;
import net.minecraft.world.storage.ISpawnWorldInfo;

import java.util.function.Supplier;

public abstract class World extends net.minecraft.world.World implements World_ {
    protected World(ISpawnWorldInfo spawnWorldInfo, RegistryKey<net.minecraft.world.World> worldRegistryKey, RegistryKey<DimensionType> dimensionTypeRegistryKey, DimensionType dimensionType, Supplier<IProfiler> profilerSupplier, boolean b, boolean b1, long l) {
        super(spawnWorldInfo, worldRegistryKey, dimensionTypeRegistryKey, dimensionType, profilerSupplier, b, b1, l);
    }
}
