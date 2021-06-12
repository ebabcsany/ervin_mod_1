package com.babcsany.minecraft.ervin_mod_1.inventory.container;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;

public class BlastFurnaceContainer1 extends AbstractFurnaceContainer1 {
   public BlastFurnaceContainer1(int p_i50097_1_, PlayerInventory p_i50097_2_) {
      super(ContainerType.BLAST_FURNACE, IRecipeType.BLASTING, p_i50097_1_, p_i50097_2_);
   }

   public BlastFurnaceContainer1(int p_i50098_1_, PlayerInventory p_i50098_2_, IInventory p_i50098_3_, IIntArray p_i50098_4_) {
      super(ContainerType.BLAST_FURNACE, IRecipeType.BLASTING, p_i50098_1_, p_i50098_2_, p_i50098_3_, p_i50098_4_);
   }
}