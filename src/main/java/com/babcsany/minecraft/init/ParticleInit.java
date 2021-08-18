package com.babcsany.minecraft.init;

import com.mojang.serialization.Codec;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.registry.Registry;

import java.util.function.Function;

public class ParticleInit {

    public static ParticleInit PARTICLES;

    public static final BasicParticleType EPKIN = register("epkin", false);
    public static final BasicParticleType ITEM_FREIN = register("item_frein", false);
    //public static final BasicParticleType DRIPPING_JURK = register("ervin_mod_1:dripping_jurk", false);
    //public static final BasicParticleType FALLING_JURK = register("ervin_mod_1:falling_jurk", false);
    //public static final BasicParticleType LANDING_JURK = register("ervin_mod_1:landing_jurk", false);
    //public static final BasicParticleType UNDERJURK = register("ervin_mod_1:underjurk", false);
    //public static final BasicParticleType DRIPPING_JURK = ParticleTypes.DRIPPING_LAVA;
    //public static final BasicParticleType FALLING_JURK = ParticleTypes.FALLING_LAVA;
    //public static final BasicParticleType LANDING_JURK = ParticleTypes.LANDING_LAVA;
    //public static final BasicParticleType UNDERJURK = ParticleTypes.UNDERWATER;

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static BasicParticleType register(String key, boolean alwaysShow) {
        return Registry.register(Registry.PARTICLE_TYPE, string(key), new BasicParticleType(alwaysShow));
    }

    private static <T extends IParticleData> ParticleType<T> register(String key, IParticleData.IDeserializer<T> deserializer, final Function<ParticleType<T>, Codec<T>> p_218416_2_) {
        return Registry.register(Registry.PARTICLE_TYPE, string(key), new ParticleType<T>(false, deserializer) {
            public Codec<T> func_230522_e_() {
                return p_218416_2_.apply(this);
            }
        });
    }

}
