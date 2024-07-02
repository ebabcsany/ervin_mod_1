package com.babcsany.minecraft.ervin_mod_1.block.tripwire.tripwire_hook;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import net.minecraft.block.*;
import net.minecraft.util.*;

public class OrangeTripWireHook extends ModTripWireHookBlock {
   public OrangeTripWireHook(Properties properties) {
      super(properties);
   }

   @Override
   public Block getTripWire() {
      return BlockInit.ORANGE_TRIPWIRE;
   }

   @Override
   public Block getTripWireHook() {
      return BlockInit.ORANGE_TRIPWIRE_HOOK;
   }
}