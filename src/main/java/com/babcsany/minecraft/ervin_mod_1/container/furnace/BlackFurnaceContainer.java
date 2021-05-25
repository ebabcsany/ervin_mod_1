package com.babcsany.minecraft.ervin_mod_1.container.furnace;

import com.babcsany.minecraft.ervin_mod_1.container.furnace.abstract_furnace.AbstractBlackFurnaceContainer;
import com.babcsany.minecraft.ervin_mod_1.init.container.ContainerInit;
import com.babcsany.minecraft.ervin_mod_1.init.container.FurnaceContainerInit;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;

public class BlackFurnaceContainer extends AbstractBlackFurnaceContainer {
   public BlackFurnaceContainer(int id, PlayerInventory playerInventoryIn) {
      super(FurnaceContainerInit.BLACK_FURNACE.get(), IRecipeType.SMELTING, id, playerInventoryIn);
   }

   public BlackFurnaceContainer(int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn, IIntArray p_i50083_4_) {
      super(FurnaceContainerInit.BLACK_FURNACE.get(), IRecipeType.SMELTING, id, playerInventoryIn, furnaceInventoryIn, p_i50083_4_);
   }

   public BlackFurnaceContainer(int id, PlayerInventory playerInventoryIn, PacketBuffer packetBuffer) {
      super(FurnaceContainerInit.BLACK_FURNACE.get(), IRecipeType.SMELTING, id, playerInventoryIn);
   }
}