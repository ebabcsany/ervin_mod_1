package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
import net.minecraftforge.eventbus.api.IEventBus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultInit {
    public static final Logger LOGGER = LogManager.getLogger();

    public DefaultInit() {
        defaultRegister();
    }

    public DefaultInit(IEventBus modEventBus) {
//        this();
        defaultRegister(modEventBus);
    }

    public void defaultRegister(IEventBus modEventBus) {
        UnusedBlockItemInit.BLOCK_ITEM_DEFERRED_REGISTER.register(modEventBus);
        UnusedBlockInit.BLOCK_DEFERRED_REGISTER.register(modEventBus);
        UnusedItemInit.ITEM_DEFERRED_REGISTER.register(modEventBus);
    }

    public void defaultRegister() {
        UnusedBlockItems.register();
        UnusedBlocks.register();
        UnusedItems.register();
    }
}
