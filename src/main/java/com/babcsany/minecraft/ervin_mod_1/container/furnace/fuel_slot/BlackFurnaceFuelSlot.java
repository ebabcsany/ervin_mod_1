package com.babcsany.minecraft.ervin_mod_1.container.furnace.fuel_slot;

import com.babcsany.minecraft.ervin_mod_1.container.furnace.abstract_furnace.AbstractBlackFurnaceContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class BlackFurnaceFuelSlot extends Slot {
   private final AbstractBlackFurnaceContainer abstractBlackFurnaceContainer;

   public BlackFurnaceFuelSlot(AbstractBlackFurnaceContainer abstractBlackFurnaceContainer, IInventory iInventory, int p_i50084_3_, int p_i50084_4_, int p_i50084_5_) {
      super(iInventory, p_i50084_3_, p_i50084_4_, p_i50084_5_);
      this.abstractBlackFurnaceContainer = abstractBlackFurnaceContainer;
   }

   /**
    * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
    */
   public boolean isItemValid(ItemStack stack) {
      return this.abstractBlackFurnaceContainer.isFuel(stack) || isBucket(stack);
   }

   public int getItemStackLimit(ItemStack stack) {
      return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
   }

   public static boolean isBucket(ItemStack stack) {
      return stack.getItem() == Items.BUCKET;
   }
}