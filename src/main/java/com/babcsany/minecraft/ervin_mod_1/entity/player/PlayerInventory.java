package com.babcsany.minecraft.ervin_mod_1.entity.player;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.INameable;

public abstract class PlayerInventory implements IInventory, INameable {
    private final PlayerEntity player;
    private static PlayerEntity getPlayer;
    private net.minecraft.entity.player.PlayerInventory playerInventory;
    private static PlayerInventory getPlayerInventory;

    public PlayerInventory(PlayerEntity player) {
        this.player = player;
    }

    public static boolean isUsableByPlayer() {
        return getPlayerInventory.isUsableByPlayer(getPlayer);
    }

    public boolean isUsableByPlayer(PlayerEntity player) {
        if (this.player.removed) {
            return false;
        } else if (playerInventory.isUsableByPlayer(player)) {
            return false;
        } else {
            return !(player.getDistanceSq(this.player) > 2048);
        }
    }

}
