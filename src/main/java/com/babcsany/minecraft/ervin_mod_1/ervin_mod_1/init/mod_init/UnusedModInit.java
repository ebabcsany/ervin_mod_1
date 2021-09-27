package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init;

import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockInit;
import net.minecraftforge.eventbus.api.IEventBus;

public class UnusedModInit {

    public UnusedModInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public void register(IEventBus modEventBus) {
        UnusedBlockInit.BLOCK_DEFERRED_REGISTER.register(modEventBus);
    }
}
