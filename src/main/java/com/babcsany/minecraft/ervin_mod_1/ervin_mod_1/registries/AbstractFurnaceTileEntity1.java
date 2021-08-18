package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries;

import net.minecraft.client.gui.recipebook.FurnaceRecipeGui;
import net.minecraft.item.Item;

import java.util.Set;

public abstract class AbstractFurnaceTileEntity1 extends FurnaceRecipeGui {

    @Override
    protected Set<Item> func_212958_h() {
        return AbstractFurnaceTileEntity.init().keySet();
    }
}
