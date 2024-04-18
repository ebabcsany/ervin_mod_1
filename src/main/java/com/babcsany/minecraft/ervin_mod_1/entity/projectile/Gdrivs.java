package com.babcsany.minecraft.ervin_mod_1.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class Gdrivs extends Item {
    public Gdrivs(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    public static boolean containsEntity(ItemStack stack) {
        return false;
    }

    public static Entity getEntityFromStack(ItemStack stack, Entity entity, boolean b) {
        return null;
    }

    public static CompoundNBT getNBTfromEntity(Entity target) {
        return null;
    }

    public boolean isBlacklisted(Entity entity) {
        return false;
    }
}
