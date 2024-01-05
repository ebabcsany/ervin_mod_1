package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.surface_builder;

import net.minecraftforge.eventbus.api.IEventBus;

public class SurfaceBuilderInit {

    public SurfaceBuilderInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.SurfaceBuilderInit.SURFACE_BUILDERS.register(modEventBus);
        return modEventBus;
    }
}
