package com.babcsany.minecraft.ervin_mod_1.block.fluid;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;

import java.util.function.Supplier;

public class JurkBlock extends FlowingFluidBlock {
    public JurkBlock(FlowingFluid fluidIn, Properties builder) {
        super(fluidIn, builder);
    }

    public JurkBlock(Supplier<? extends FlowingFluid> supplier, Properties properties) {
        super(supplier, properties);
    }
}
