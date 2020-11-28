package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<SoundEvent> AMBIENT = SOUNDS.register("entity/example_entity.ambient",
            () -> new SoundEvent(new ResourceLocation(Ervin_mod_1.MOD_ID, "entity/example_entity.ambient")
            ));
    public static class AMBIENT {
        public static SoundEvent get() {
            return null;
        }
    }
}
