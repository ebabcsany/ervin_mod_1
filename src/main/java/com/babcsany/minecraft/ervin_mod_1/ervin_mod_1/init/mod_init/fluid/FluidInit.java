package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.fluid;

import net.minecraftforge.eventbus.api.IEventBus;

public class FluidInit {

    public FluidInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        return modEventBus;
    }
}
