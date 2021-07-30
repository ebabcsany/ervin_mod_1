package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.storage.ISpawnWorldInfo;

import java.util.function.Supplier;

public abstract class World extends net.minecraft.world.World {

    //public static final RegistryKey<net.minecraft.world.World> EXAMPLE = RegistryKey.func_240903_a_(Registry.WORLD_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID,"example"));

    protected World(ISpawnWorldInfo p_i231617_1_, RegistryKey<net.minecraft.world.World> p_i231617_2_, RegistryKey<DimensionType> p_i231617_3_, DimensionType p_i231617_4_, Supplier<IProfiler> p_i231617_5_, boolean p_i231617_6_, boolean p_i231617_7_, long p_i231617_8_) {
        super(p_i231617_1_, p_i231617_2_, p_i231617_3_, p_i231617_4_, p_i231617_5_, p_i231617_6_, p_i231617_7_, p_i231617_8_);
    }
}
