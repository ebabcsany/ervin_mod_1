package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes;

import net.minecraft.util.INameable;

public abstract class IInventory implements net.minecraft.inventory.IInventory, INameable {

    @Override
    public int getInventoryStackLimit() {
        return net.minecraft.inventory.IInventory.super.getInventoryStackLimit() + 1984;
    }
}
