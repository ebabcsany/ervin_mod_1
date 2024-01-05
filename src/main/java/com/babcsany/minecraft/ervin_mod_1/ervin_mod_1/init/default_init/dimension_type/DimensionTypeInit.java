package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.dimension_type;

import net.minecraft.world.DimensionType;

public class DimensionTypeInit {

    public DimensionTypeInit(DimensionType dimensionType) {
        register(dimensionType);
    }

    public void register(DimensionType dimensionType) {
        com.babcsany.minecraft.ervin_mod_1.init.DimensionTypeInit.DIMENSION_TYPES = dimensionType;
    }
}
