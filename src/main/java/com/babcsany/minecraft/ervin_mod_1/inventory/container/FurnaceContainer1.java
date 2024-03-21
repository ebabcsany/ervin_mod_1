package com.babcsany.minecraft.ervin_mod_1.inventory.container;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;

public class FurnaceContainer1 extends AbstractFurnaceContainer1 {
   public FurnaceContainer1(int id, PlayerInventory playerInventoryIn) {
      super(ContainerType.FURNACE, IRecipeType.SMELTING, id, playerInventoryIn);
   }

   public FurnaceContainer1(int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn, IIntArray p_i50083_4_) {
      super(ContainerType.FURNACE, IRecipeType.SMELTING, id, playerInventoryIn, furnaceInventoryIn, p_i50083_4_);
   }

   @Override
   public RecipeBookCategory func_241850_m() {
      return RecipeBookCategory.FURNACE;
   }
}