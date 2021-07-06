package com.babcsany.minecraft.init;

import com.mojang.serialization.Codec;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;

public class ParticleInit {

    public static ParticleInit PARTICLES;

    public static final BasicParticleType EPKIN = register("ervin_mod_1:epkin", false);
    public static final BasicParticleType ITEM_FREIN = register("ervin_mod_1:item_frein", false);

    private static BasicParticleType register(String key, boolean alwaysShow) {
        return Registry.register(Registry.PARTICLE_TYPE, key, new BasicParticleType(alwaysShow));
    }

    private static <T extends IParticleData> ParticleType<T> register(String key, IParticleData.IDeserializer<T> deserializer, final Function<ParticleType<T>, Codec<T>> p_218416_2_) {
        return Registry.register(Registry.PARTICLE_TYPE, key, new ParticleType<T>(false, deserializer) {
            public Codec<T> func_230522_e_() {
                return p_218416_2_.apply(this);
            }
        });
    }
}
