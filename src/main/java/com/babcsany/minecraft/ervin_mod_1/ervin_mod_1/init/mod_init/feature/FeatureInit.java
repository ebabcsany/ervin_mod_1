package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.feature;

import net.minecraftforge.eventbus.api.IEventBus;

public class FeatureInit {

    public FeatureInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.FeatureInit.FEATURES.register(modEventBus);
        return modEventBus;
    }
}
