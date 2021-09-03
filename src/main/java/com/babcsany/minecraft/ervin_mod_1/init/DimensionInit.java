package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.world.dimension;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;

public final class DimensionInit {

    public static Dimension DIMENSIONS;

    public static RegistryKey<Dimension> EXAMPLE = dimensionRegistryKey("example");
    static RegistryKey<Dimension> dimensionRegistryKey;

    public DimensionInit() {
        register();
    }

    public void register() {
        dimension.DIMENSION_KEYS.add(EXAMPLE);
        new dimension();
    }

    public static RegistryKey<Dimension> dimensionRegistryKey(String key) {
        return registryKey(key, dimensionRegistryKey);
    }

    public static <T> RegistryKey<T> registryKey(String key, RegistryKey<T> registryKey) {
        RegistryKey<T> dimensionRegistryKey = registryKey;
        RegistryKey.func_240903_a_(Registry.DIMENSION_KEY, new ResourceLocation(dimension.string(key)));
        return dimensionRegistryKey;
    }
}
