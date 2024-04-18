package com.babcsany.minecraft.ervin_mod_1.client.entity.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.util.ClientRecipeBook;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stats.StatisticsManager;

public class ModClientPlayer extends ClientPlayerEntity {
    private final PlayerEntity player;

    public ModClientPlayer(Minecraft mc, ClientWorld world, ClientPlayNetHandler connection, StatisticsManager stats, ClientRecipeBook recipeBook, boolean clientSneakState, boolean clientSprintState) {
        super(mc, world, connection, stats, recipeBook, clientSneakState, clientSprintState);
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
    public void closeScreen() {
        super.closeScreen();
    }
}
