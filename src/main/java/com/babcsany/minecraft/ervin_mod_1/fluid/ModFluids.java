package com.babcsany.minecraft.ervin_mod_1.fluid;

import net.minecraft.fluid.*;
import net.minecraft.util.registry.Registry;

public class ModFluids {
   public static final Fluid EMPTY = register("empty", new EmptyFluid());
   public static final FlowingFluid FLOWING_WATER = register("flowing_water", new WaterFluid.Flowing());
   public static final FlowingFluid WATER = register("water", new WaterFluid.Source());
   public static final FlowingFluid FLOWING_LAVA = register("flowing_lava", new LavaFluid.Flowing());
   public static final FlowingFluid LAVA = register("lava", new LavaFluid.Source());
   public static final FlowingFluid2 FLOWING_JURK = register("flowing_jurk", new JurkFluid.Flowing());
   public static final FlowingFluid2 JURK = register("jurk", new JurkFluid.Source());
   public static final FlowingFluid1 FLOWING_MILK = register("flowing_milk", new MilkFluid.Flowing());
   public static final FlowingFluid1 MILK = register("milk", new MilkFluid() {

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