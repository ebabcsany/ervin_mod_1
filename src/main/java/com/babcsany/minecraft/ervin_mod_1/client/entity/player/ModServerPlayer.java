package com.babcsany.minecraft.ervin_mod_1.client.entity.player;

import com.babcsany.minecraft.ervin_mod_1.entity.ModPlayer;
import com.mojang.authlib.GameProfile;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameType;
import net.minecraft.world.server.ServerWorld;

public class ModServerPlayer extends ModPlayer {
    private final PlayerEntity player;
    private final PlayerAdvancements advancements;

    public ModServerPlayer(MinecraftServer server, ServerWorld worldIn, GameProfile profile) {
        super(worldIn, worldIn.getSpawnPoint(), worldIn.getSpawnAngle(), profile);
        this.player = this;
        this.advancements = server.getPlayerList().getPlayerAdvancements((ServerPlayerEntity) this.player);
    }

    /**
     * Returns true if the player is in spectator mode.
     */
    @Override
    public boolean isSpectator() {
        return ((ServerPlayerEntity) player).interactionManager.getGameType() == GameType.SPECTATOR;
    }

    @Override
    public boolean isCreative() {
        return ((ServerPlayerEntity) player).interactionManager.getGameType() == GameType.CREATIVE;
    }

    public ServerWorld getServerWorld() {
        return (ServerWorld) this.world;
    }

    public PlayerAdvancements getAdvancements() {
        return this.advancements;
    }
}
