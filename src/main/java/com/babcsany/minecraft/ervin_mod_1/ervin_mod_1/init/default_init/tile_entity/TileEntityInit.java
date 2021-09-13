package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.tile_entity;

import net.minecraft.tileentity.TileEntityType;

public class TileEntityInit {

    public TileEntityInit(TileEntityType<?> tileEntities) {
        register(tileEntities);
    }

    public void register(TileEntityType<?> tileEntities) {
        com.babcsany.minecraft.init.TileEntityInit.TILE_ENTITIES = tileEntities;
    }
}
