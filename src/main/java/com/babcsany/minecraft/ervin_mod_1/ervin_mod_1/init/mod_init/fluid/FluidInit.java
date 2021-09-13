package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.fluid;

import com.babcsany.minecraft.ervin_mod_1.init.block.FluidBlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.fluid.FlowingFluidInit;
import net.minecraftforge.eventbus.api.IEventBus;

public class FluidInit {

    public FluidInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        com.babcsany.minecraft.ervin_mod_1.init.fluid.FluidInit.FLUIDS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.fluid.FluidInit.FLUID_BLOCKS.register(modEventBus);
        FluidBlockInit.FLUID_BLOCKS.register(modEventBus);
        FlowingFluidInit.FLOWING_FLUIDS.register(modEventBus);
        return modEventBus;
    }
}
