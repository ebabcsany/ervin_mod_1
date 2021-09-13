package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.sound_event;

import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;

public class SoundEventInit {

    public SoundEventInit(SoundEvents soundEvents) {
        register(soundEvents);
    }

    public void register(SoundEvents soundEvents) {
        com.babcsany.minecraft.init.SoundEventInit.SOUND_EVENTS = soundEvents;
    }
}
