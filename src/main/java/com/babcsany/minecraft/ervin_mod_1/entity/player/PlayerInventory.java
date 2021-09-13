package com.babcsany.minecraft.ervin_mod_1.entity.player;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.INameable;

public abstract class PlayerInventory implements IInventory, INameable {
    private static PlayerEntity getPlayer;
    private static PlayerInventory getPlayerInventory;
    private final net.minecraft.entity.player.PlayerInventory playerInventory;
    private final boolean isUsableByPlayer;
    private final int getDistanceSq = 2048;

    public PlayerInventory(PlayerEntity player, net.minecraft.entity.player.PlayerInventory playerInventory) {
        this.playerInventory = playerInventory;
        this.isUsableByPlayer = isUsableByPlayer(player);
    }

    public boolean isUsableByPlayer() {
        return this.isUsableByPlayer;
    }

    public int getDistanceSq() {
        return this.getDistanceSq;
    }

    public boolean isUsableByPlayer(PlayerEntity player) {
        if (playerInventory.isUsableByPlayer(player)) {
            return false;
        } else {
            if (player.removed) {
                return false;
            } else {
                return !(player.getDistanceSq(player) > getDistanceSq);
            }
        }
    }

}
