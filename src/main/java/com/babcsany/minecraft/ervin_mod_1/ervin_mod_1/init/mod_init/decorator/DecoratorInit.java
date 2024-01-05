package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.decorator;

import net.minecraftforge.eventbus.api.IEventBus;

public class DecoratorInit {

    public DecoratorInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.DecoratorInit.DECORATORS.register(modEventBus);
        return modEventBus;
    }
}
