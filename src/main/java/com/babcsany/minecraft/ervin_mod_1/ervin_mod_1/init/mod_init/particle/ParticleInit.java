package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.particle;

import net.minecraftforge.eventbus.api.IEventBus;

public class ParticleInit {

    public ParticleInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.ParticleInit.PARTICLE_TYPES.register(modEventBus);
        return modEventBus;
    }
}
