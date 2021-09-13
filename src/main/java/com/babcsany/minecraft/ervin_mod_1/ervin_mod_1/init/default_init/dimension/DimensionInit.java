package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.dimension;

import net.minecraft.world.Dimension;

public class DimensionInit {

    public DimensionInit(Dimension dimension) {
        register(dimension);
    }

    public void register(Dimension dimension) {
        com.babcsany.minecraft.ervin_mod_1.init.DimensionInit.DIMENSIONS = dimension;
    }
}
