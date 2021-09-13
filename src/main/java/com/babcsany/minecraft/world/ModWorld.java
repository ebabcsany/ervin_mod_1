package com.babcsany.minecraft.world;

import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.storage.ISpawnWorldInfo;

import java.util.function.Supplier;

public abstract class ModWorld extends world {
    public ModWorld(ISpawnWorldInfo spawnWorldInfo, RegistryKey<world> worldRegistryKey, RegistryKey<dimensionType> dimensionTypeRegistryKey, dimensionType dimensionType, Supplier<IProfiler> profilerSupplier, boolean isRemote, boolean Boolean, long l) {
        super(spawnWorldInfo, worldRegistryKey, dimensionTypeRegistryKey, dimensionType, profilerSupplier, isRemote, Boolean, l);
    }
}
