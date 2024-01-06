package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.inventory.IInventory;
import com.babcsany.minecraft.ervin_mod_1.init.World;
import net.minecraft.entity.player.PlayerEntity;

public class Ervin_mod_1_classes {

    static net.minecraft.inventory.IInventory iInventory;
    static PlayerEntity playerEntity;

    public static void inventory() {
        Ervin_mod_1.Class(IInventory.class);
    }

    public static void world() {
        Ervin_mod_1.Class(World.class);
    }

}
