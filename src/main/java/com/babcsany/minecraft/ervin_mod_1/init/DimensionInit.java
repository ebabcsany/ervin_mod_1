package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.world.dimension;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraftforge.eventbus.api.IEventBus;

public final class DimensionInit {

    public static Dimension DIMENSIONS;

    public static RegistryKey<dimension> EXAMPLE = dimensionRegistryKey("example");
    static RegistryKey<dimension> dimensionRegistryKey;

    public DimensionInit() {
        register();
    }

    public void register() {
        ModDimensionKey(EXAMPLE);
    }

    public static void ModDimensionKey(RegistryKey<dimension> dimensionRegistryKey) {
        dimension.MOD_DIMENSION_KEYS.add(dimensionRegistryKey);
    }

    public static RegistryKey<dimension> dimensionRegistryKey(String key) {
        return registryKey(key, dimensionRegistryKey);
    }

    public static <T> RegistryKey<T> registryKey(String key, RegistryKey<T> registryKey) {
        RegistryKey<T> dimensionRegistryKey = registryKey;
        RegistryKey.func_240903_a_(Registry.DIMENSION_KEY, new ResourceLocation(dimension.string(key)));
        return dimensionRegistryKey;
    }

    public IEventBus register(IEventBus modEventBus) {
        return modEventBus;
    }
}
