package com.babcsany.minecraft.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.registry.Registry;

public class SoundEventInit {

    public static SoundEvents SOUND_EVENTS;

//    public static final SoundEvent AMBIENT_CDS652_1 = register("ambient/cds652_1");
//    public static final SoundEvent AMBIENT_SDISCG = register("ambient.sdiscg");

    private static SoundEvent register(String key) {
        return Registry.register(Registry.SOUND_EVENT, string(key), new SoundEvent(new ResourceLocation(key)));
    }

    public static String string(String key) {
        String string = "ervin_mod_1:" + key + ".ogg";
        return string;
    }
}
