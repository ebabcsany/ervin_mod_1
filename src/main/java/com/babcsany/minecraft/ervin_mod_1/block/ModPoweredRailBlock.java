package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.PoweredRailBlock;

public class ModPoweredRailBlock extends PoweredRailBlock {
   public ModPoweredRailBlock(Properties builder) {
      super(builder);
   }

   public ModPoweredRailBlock(Properties builder, boolean isPoweredRail) {
      super(builder, isPoweredRail);
   }
}