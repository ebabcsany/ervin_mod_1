package com.babcsany.minecraft.ervin_mod_1.container.furnace;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;

public class BlackFurnaceContainer extends AbstractFurnaceContainer {
   public BlackFurnaceContainer(int id, PlayerInventory playerInventoryIn) {
      super(ContainerType.FURNACE, IRecipeType.SMELTING, id, playerInventoryIn);
   }

   public BlackFurnaceContainer(int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn, IIntArray p_i50083_4_) {
      super(ContainerType.FURNACE, IRecipeType.SMELTING, id, playerInventoryIn, furnaceInventoryIn, p_i50083_4_);
   }
}