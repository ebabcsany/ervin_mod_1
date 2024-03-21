package com.babcsany.minecraft.ervin_mod_1.block.tripwire;

import net.minecraft.block.FourWayBlock;
import net.minecraft.block.SixWayBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;

import java.util.Map;

public class ModFourWayBlock extends FourWayBlock {
   protected static final Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP = SixWayBlock.FACING_TO_PROPERTY_MAP.entrySet().stream().filter((entry) -> {
      return entry.getKey().getAxis().isHorizontal();
   }).collect(Util.toMapCollector());

   public ModFourWayBlock(float nodeWidth, float extensionWidth, float nodeHeight, float extensionHeight, float collisionY, Properties properties) {
      super(nodeWidth, extensionWidth, nodeHeight, extensionHeight, collisionY, properties);
   }
}