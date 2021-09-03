package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.player.PlayerEntity1;
import com.babcsany.minecraft.ervin_mod_1.entity.player.PlayerInventory;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.inventory.IInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class Ervin_mod_1_classes {

    static net.minecraft.inventory.IInventory iInventory;
    public static PlayerEntity playerEntity;
    public static BlockPos pos;
    static PlayerEntity1 playerEntity1;

    public static void inventory_classes() {
        Ervin_mod_1.Class(com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.IInventory.class);
        Ervin_mod_1.Class(PlayerInventory.class);
    }

    private static <T> void Class(Class<T> Class) {
        if (iInventory instanceof IInventory) {
            return;
        }
        if (playerEntity instanceof PlayerEntity1) {
            playerEntity1.tick();
            playerEntity.tick();
            ((PlayerEntity1) playerEntity).updateTurtleHelmet();
        }
    }

    public static void world() {
        com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world.World.isValid(pos);
    }
}
