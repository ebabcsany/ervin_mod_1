package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.world;

import net.minecraft.world.World;

public class WorldInit {

    public WorldInit(World worlds) {
        register(worlds);
    }

    public void register(World worlds) {
        com.babcsany.minecraft.ervin_mod_1.init.WorldInit.WORLDS = worlds;
    }
}
