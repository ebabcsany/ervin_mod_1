package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.entity;

import net.minecraftforge.eventbus.api.IEventBus;

public class EntityInit {

    public EntityInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.EntityInit.ENTITY_TYPES.register(modEventBus);
        return modEventBus;
    }
}
