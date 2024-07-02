package com.babcsany.minecraft.ervin_mod_1.entity;

import com.babcsany.minecraft.ervin_mod_1.entity.projectile.Huihk;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class ModPlayer extends PlayerEntity {
    public static Huihk huihk = null;
    public PlayerEntity player = this;

    public ModPlayer(World worldIn, BlockPos pos, float yaw, GameProfile profile) {
        super(worldIn, pos, yaw, profile);
    }
}
