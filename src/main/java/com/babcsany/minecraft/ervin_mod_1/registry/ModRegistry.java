package com.babcsany.minecraft.ervin_mod_1.registry;

import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome;
import com.babcsany.minecraft.registry.ModBiomes;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.*;
import net.minecraft.entity.EntityType;
import net.minecraft.util.IObjectIntIterable;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.stream.Stream;

public class ModRegistry<T> {
    public static final RegistryKey<Registry<ModBiome<?>>> MOD_BIOME_KEY = createKey("ervin_mod_1:mod_biome");

    //public static final DefaultedRegistry<ModBiome<?>> MOD_BIOME = Registry.forgeDefaulted(MOD_BIOME_KEY, ModBiome.class, () -> ModBiomes.DEFAULT);

    public static <T> RegistryKey<Registry<T>> createKey(String name) {
        return RegistryKey.func_240904_a_(new ResourceLocation(name));
    }
}
