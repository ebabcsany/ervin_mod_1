package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class Worlds {
    public static RegistryKey<World> EXAMPLE = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID, "example"));
}
