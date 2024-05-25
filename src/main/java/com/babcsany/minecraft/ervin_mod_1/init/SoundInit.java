package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;

public class SoundInit {

    public static final SoundEvent LIWRAY_AMBIENT = register("entity/example_entity.ambient");

    @Deprecated
    public static SoundEvent register(String key) {
        return Registry.register(Registry.SOUND_EVENT, Ervin_mod_1.identifier(key), new SoundEvent(Ervin_mod_1.getKey(key)));
    }

    public static void register() {
        Ervin_mod_1.register(SoundInit.class);
    }
}
