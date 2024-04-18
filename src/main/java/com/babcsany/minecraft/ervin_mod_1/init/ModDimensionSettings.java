package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.DimensionSettings;

public class ModDimensionSettings {
    public static final RegistryKey<DimensionSettings> EXAMPLE = RegistryKey.getOrCreateKey(Registry.NOISE_SETTINGS_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID, "example"));
}
