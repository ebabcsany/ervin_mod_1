package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.sound;

import net.minecraftforge.eventbus.api.IEventBus;

public class SoundInit {

    public SoundInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.SoundInit.SOUNDS.register(modEventBus);
        return modEventBus;
    }
}
