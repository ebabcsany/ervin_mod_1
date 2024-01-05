package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.particle;

import net.minecraft.particles.ParticleTypes;

public class ParticleInit {

    public ParticleInit(ParticleTypes particles) {
        register(particles);
    }

    public void register(ParticleTypes particles) {
        com.babcsany.minecraft.init.ParticleInit.PARTICLES = particles;
    }
}
