package com.babcsany.minecraft.ervin_mod_1.fluid;

import net.minecraft.fluid.*;
import net.minecraft.util.registry.Registry;

public class ModFluids {
   //public static final FlowingFluid EMPTY = register("empty", new EmptyFluid.Flowing());
//   public static final FlowingFluid FLOWING_WATER = register("flowing_water", new WaterFluid.Flowing());
//   public static final FlowingFluid WATER = register("water", new WaterFluid.Source());
//   public static final FlowingFluid FLOWING_LAVA = register("flowing_lava", new LavaFluid.Flowing());
//   public static final FlowingFluid LAVA = register("lava", new LavaFluid.Source());
   public static final FlowingFluid FLOWING_JURK = register("flowing_jurk", new JurkFluid.Flowing());
   public static final FlowingFluid JURK = register("jurk", new JurkFluid() {

      @Override
      public boolean isSource(IFluidState state) {
         return false;
      }

      @Override
      public int getLevel(IFluidState p_207192_1_) {
         return 0;
      }
   });


   private static <T extends Fluid> T register(String key, T p_215710_1_) {
      return (T)(Registry.register(Registry.FLUID, key, p_215710_1_));
   }

   static {
      for(Fluid fluid : Registry.FLUID) {
         for(IFluidState ifluidstate : fluid.getStateContainer().getValidStates()) {
            Fluid.STATE_REGISTRY.add(ifluidstate);
         }
      }

   }
}