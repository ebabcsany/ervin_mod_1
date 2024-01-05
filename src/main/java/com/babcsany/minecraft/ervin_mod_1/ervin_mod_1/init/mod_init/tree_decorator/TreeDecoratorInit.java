package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.tree_decorator;

import net.minecraftforge.eventbus.api.IEventBus;

public class TreeDecoratorInit {

    public TreeDecoratorInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.TreeDecoratorInit.TREE_DECORATOR_TYPES.register(modEventBus);
        return modEventBus;
    }
}
