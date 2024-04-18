package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;

public class Dimensions {
    public static final RegistryKey<Dimension> EXAMPLE = RegistryKey.getOrCreateKey(Registry.DIMENSION_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID, "example"));
}
