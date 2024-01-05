package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.world_carver;

import net.minecraftforge.eventbus.api.IEventBus;

public class WorldCarverInit {

    public WorldCarverInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.WorldCarverInit.CARVERS.register(modEventBus);
        return modEventBus;
    }
}
