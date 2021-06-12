package com.babcsany.minecraft.ervin_mod_1.inventory.container;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;

public class SmokerContainer1 extends AbstractFurnaceContainer1 {
   public SmokerContainer1(int id, PlayerInventory playerInventory) {
      super(ContainerType.SMOKER, IRecipeType.SMOKING, id, playerInventory);
   }

   public SmokerContainer1(int id, PlayerInventory playerInventory, IInventory inventory, IIntArray p_i50062_4_) {
      super(ContainerType.SMOKER, IRecipeType.SMOKING, id, playerInventory, inventory, p_i50062_4_);
   }
}