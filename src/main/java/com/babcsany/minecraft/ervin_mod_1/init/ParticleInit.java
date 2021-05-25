package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.particles.BasicParticleType1;
import com.babcsany.minecraft.ervin_mod_1.particles.ColouredParticle;
import com.babcsany.minecraft.ervin_mod_1.particles.ParticleType1;
import com.mojang.serialization.Codec;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleInit {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Ervin_mod_1.MOD_ID);

    //public static final BasicParticleType HAPPY_VILLAGER = register("ervin_mod_1:jurk", false);
    /*public static final RegistryObject<ParticleType<BasicParticleType>> JURK = PARTICLE_TYPES.register(
            "jurk",
            () -> new ParticleType<BasicParticleType>(false, BasicParticleType.DESERIALIZER) {
                @Override
                public Codec<BasicParticleType> func_230522_e_() {
                    return null;
                }
            });
    public static final RegistryObject<ParticleType<BasicParticleType>> DRIPPING_JURK = PARTICLE_TYPES.register(
            "dripping_jurk",
            () -> new ParticleType<BasicParticleType>(false, BasicParticleType.DESERIALIZER) {
                @Override
                public Codec<BasicParticleType> func_230522_e_() {
                    return null;
                }
            });*/

    /*@SuppressWarnings("resource")
    @SubscribeEvent
    public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particles.registerFactory(ParticleInit.COLOURED_PARTICLE.get(),
                ColouredParticle.Factory::new);
    }*/

    private static BasicParticleType register(String key, boolean alwaysShow) {
        return Registry.register(Registry.PARTICLE_TYPE, key, new BasicParticleType(alwaysShow));
    }
}
