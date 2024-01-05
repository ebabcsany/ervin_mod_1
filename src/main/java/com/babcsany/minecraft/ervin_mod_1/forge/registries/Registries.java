package com.babcsany.minecraft.ervin_mod_1.forge.registries;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.Init;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Registries<T extends IForgeRegistryEntry<T>> extends Init.CreateRegistries<T> {
    public Registries(IForgeRegistry<T> iForgeRegistry, String name) {
        super(iForgeRegistry, name);
    }
}
