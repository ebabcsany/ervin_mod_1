package com.babcsany.minecraft.ervin_mod_1.client.entity.player;

import com.babcsany.minecraft.ervin_mod_1.entity.ModPlayer;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class ModClientPlayer extends ModPlayer {
    private final PlayerEntity player;

    public ModClientPlayer(World worldIn, BlockPos pos, float yaw, GameProfile profile) {
        super(worldIn, pos, yaw, profile);
        this.player = this;
    }

    public PlayerEntity getPlayer() {
        return this.player;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public boolean isUser() {
        return true;
    }

    /**
     * Returns true if the player is in spectator mode.
     */
    @Override
    public boolean isSpectator() {
        NetworkPlayerInfo networkplayerinfo = Minecraft.getInstance().getConnection().getPlayerInfo(this.getGameProfile().getId());
        return networkplayerinfo != null && networkplayerinfo.getGameType() == GameType.SPECTATOR;
    }

    @Override
    public boolean isCreative() {
        NetworkPlayerInfo networkplayerinfo = Minecraft.getInstance().getConnection().getPlayerInfo(this.getGameProfile().getId());
        return networkplayerinfo != null && networkplayerinfo.getGameType() == GameType.CREATIVE;
    }

    @Override
    public void closeScreen() {
        super.closeScreen();
    }
}
