package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.biome;

import net.minecraftforge.eventbus.api.IEventBus;

public class BiomeInit {

    public BiomeInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.BiomeInit.BIOMES.register(modEventBus);
        return modEventBus;
    }
}
