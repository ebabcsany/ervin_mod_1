package com.babcsany.minecraft.fluid;

public abstract class Fluid extends net.minecraft.fluid.Fluid {

    static com.babcsany.minecraft.forge.hooks.ForgeHooks forgeHooks;

    protected Fluid() {
    }

    /**
     * Creates the fluid attributes object, which will contain all the extended values for the fluid that aren't part of the vanilla system.
     * Do not call this from outside. To retrieve the values use {@link net.minecraft.fluid.Fluid#getAttributes()}
     */
    @Override
    protected net.minecraftforge.fluids.FluidAttributes createAttributes()
    {
        return com.babcsany.minecraft.forge.hooks.ForgeHooks.createVanillaFluidAttributes(this);
    }

    private net.minecraftforge.fluids.FluidAttributes forgeFluidAttributes;
}
