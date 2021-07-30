package com.babcsany.minecraft.ervin_mod_1.registry;

import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class ModRegistry<T> {
    public static final RegistryKey<Registry<ModBiome<?>>> MOD_BIOME_KEY = createKey("ervin_mod_1:mod_biome");

    //public static final DefaultedRegistry<ModBiome<?>> MOD_BIOME = Registry.forgeDefaulted(MOD_BIOME_KEY, ModBiome.class, () -> ModBiomes.DEFAULT);

    public static <T> RegistryKey<Registry<T>> createKey(String name) {
        return RegistryKey.func_240904_a_(new ResourceLocation(name));
    }
}
