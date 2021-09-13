package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.container;

import com.babcsany.minecraft.ervin_mod_1.init.container.FurnaceContainerInit;
import net.minecraftforge.eventbus.api.IEventBus;

public class ContainerInit {

    public ContainerInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.container.ContainerInit.CONTAINER_TYPES.register(modEventBus);
        FurnaceContainerInit.CONTAINER_TYPES.register(modEventBus);
        return modEventBus;
    }
}
