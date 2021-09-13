package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.fluid;

import net.minecraft.fluid.Fluids;

public class FluidInit {

    public FluidInit(Fluids fluids) {
        register(fluids);
    }

    public void register(Fluids fluids) {
        com.babcsany.minecraft.init.FluidInit.FLUIDS = fluids;
    }
}
