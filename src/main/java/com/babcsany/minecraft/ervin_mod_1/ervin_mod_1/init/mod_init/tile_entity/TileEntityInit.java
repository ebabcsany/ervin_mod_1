package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.tile_entity;

import net.minecraftforge.eventbus.api.IEventBus;

public class TileEntityInit {

    public TileEntityInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.TileEntityInit.TILE_ENTITY_TYPES.register(modEventBus);
        return modEventBus;
    }
}
