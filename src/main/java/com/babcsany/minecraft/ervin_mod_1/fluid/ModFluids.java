package com.babcsany.minecraft.ervin_mod_1.fluid;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.fluid.*;
import net.minecraft.util.registry.Registry;

public class ModFluids {
   //public static final Fluid EMPTY = register("empty", new EmptyFluid());
   public static final FlowingFluid FLOWING_WATER = register("flowing_water", new WaterFluid.Flowing());
   public static final FlowingFluid WATER = register("water", new WaterFluid.Source());
   public static final FlowingFluid FLOWING_LAVA = register("flowing_lava", new LavaFluid.Flowing());
   public static final FlowingFluid LAVA = register("lava", new LavaFluid.Source());
   public static final FlowingFluid FLOWING_MILK = register("flowing_milk", new MilkFluid.Flowing());
   public static final FlowingFluid MILK = register("milk", new MilkFluid.Source());
   /*public static final FlowingFluid FLOWING_JURK = register("flowing_jurk", new JurkFluid.Flowing());
   public static final FlowingFluid JURK = register("jurk", new JurkFluid.Source());*/

   private static <T extends Fluid> T register(String key, T p_215710_1_) {
      return Registry.register(Registry.FLUID, key, p_215710_1_);
   }

   static {
      for(Fluid fluid : Registry.FLUID) {
         for(FluidState fluidstate : fluid.getStateContainer().getValidStates()) {
            Fluid.STATE_REGISTRY.add(fluidstate);
         }
      }

   }
}