package com.babcsany.minecraft.ervin_mod_1.block.tripwire.tripwire_hook;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class LightBlue1TripWireHook extends ModTripWireHookBlock {
   public LightBlue1TripWireHook(Properties properties) {
      super(properties);
      this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(POWERED, Boolean.valueOf(false)).with(ATTACHED, Boolean.valueOf(false)));
   }

   @Override
   public Block getTripWire() {
      return BlockInit.LIGHT_BLUE1_TRIPWIRE.get();
   }

   @Override
   public Block getTripWireHook() {
      return BlockInit.LIGHT_BLUE1_TRIPWIRE_HOOK.get();
   }
}