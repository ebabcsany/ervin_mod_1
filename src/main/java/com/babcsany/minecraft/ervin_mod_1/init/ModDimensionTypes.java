package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> EXAMPLE = register("example");

    public static RegistryKey<DimensionType> register(String name) {
        return register(Ervin_mod_1.MOD_ID, name);
    }

    public static RegistryKey<DimensionType> register(String namespace, String path) {
        return RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(namespace, path));
    }

    public static void register() {
        Ervin_mod_1.register(ModDimensionTypes.class);
    }
}
