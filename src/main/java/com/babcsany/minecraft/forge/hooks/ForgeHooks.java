package com.babcsany.minecraft.forge.hooks;


import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.fluid.JurkFluid;
import net.minecraft.fluid.EmptyFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;

public class ForgeHooks {

    public static net.minecraftforge.common.ForgeHooks forgeHooks = null;
    static net.minecraftforge.fluids.FluidAttributes forgeFluidAttributes = null;

    public static FluidAttributes createVanillaFluidAttributes(Fluid fluid)
    {
        if (fluid instanceof EmptyFluid)
            return FluidAttributes.builder(null, null)
                    .translationKey("block.minecraft.air")
                    .color(0).density(0).temperature(0).luminosity(0).viscosity(0).build(fluid);
        if (fluid instanceof WaterFluid)
            return FluidAttributes.Water.builder(
                    new ResourceLocation("block/water_still"),
                    new ResourceLocation("block/water_flow"))
                    .overlay(new ResourceLocation("block/water_overlay"))
                    .translationKey("block.minecraft.water")
                    .color(0xFF3F76E4).build(fluid);
        if (fluid instanceof JurkFluid)
            return FluidAttributes.builder(
                    new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_still"),
                    new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_flow"))
                    .overlay(new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_overlay"))
                    .translationKey("block.ervin_mod_1.fluids.jurk")
                    .luminosity(3).density(500).viscosity(2000).temperature(300).build(fluid);
        if (fluid instanceof LavaFluid)
            return FluidAttributes.builder(
                    new ResourceLocation("block/lava_still"),
                    new ResourceLocation("block/lava_flow"))
                    .translationKey("block.minecraft.lava")
                    .luminosity(15).density(3000).viscosity(6000).temperature(1300).build(fluid);
        throw new RuntimeException("Mod fluids must override createAttributes.");
    }
}
