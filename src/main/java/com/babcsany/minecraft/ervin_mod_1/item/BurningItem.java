package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

public class BurningItem extends Item {
   public int durationIn;
   public BurningItem(Properties properties, int burnTimeIn) {
      super(properties);
      this.durationIn = burnTimeIn;
   }

   @Override
   public int getBurnTime(ItemStack stack) {
//      FurnaceFuelBurnTimeEvent event = new FurnaceFuelBurnTimeEvent(stack, this.durationIn);
      return this.durationIn;
   }
}