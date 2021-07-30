package com.babcsany.minecraft.ervin_mod_1.init.fluid;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//import static com.babcsany.minecraft.ervin_mod_1.init.fluid.FluidPropertiesInit.JURK;

public class FlowingFluidInit {

    public static final DeferredRegister<Fluid> FLOWING_FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<FlowingFluid> FLOWING_JURK = FLOWING_FLUIDS.register("fluids/flowing_jurk_", () -> new ModFlowingFluid.Flowing(JURK));

}
