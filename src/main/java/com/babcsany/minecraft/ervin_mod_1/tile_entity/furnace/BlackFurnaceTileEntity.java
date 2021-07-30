package com.babcsany.minecraft.ervin_mod_1.tile_entity.furnace;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class BlackFurnaceTileEntity extends AbstractFurnaceTileEntity {
   public BlackFurnaceTileEntity() {
      super(TileEntityType.FURNACE, IRecipeType.SMELTING);
   }

   protected ITextComponent getDefaultName() {
      return new TranslationTextComponent("container.furnace");
   }

   protected Container createMenu(int id, PlayerInventory player) {
      return new FurnaceContainer(id, player, this, this.furnaceData);
   }
}