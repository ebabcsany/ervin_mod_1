package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;

public class DefaultInit {
    public DefaultInit() {
        defaultRegister();
    }

    public void defaultRegister() {
        UnusedBlocks.register();
        UnusedItems.register();
        UnusedBlockItems.register();
    }
}
