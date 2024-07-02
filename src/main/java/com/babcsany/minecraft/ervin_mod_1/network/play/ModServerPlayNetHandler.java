package com.babcsany.minecraft.ervin_mod_1.network.play;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.server.management.ModPlayerList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.network.play.client.CClientStatusPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModServerPlayNetHandler extends ServerPlayNetHandler {
    private final MinecraftServer server;

    public ModServerPlayNetHandler(MinecraftServer server, NetworkManager networkManagerIn, ServerPlayerEntity playerIn) {
        super(server, networkManagerIn, playerIn);
        this.server = server;
    }

    @Override
    public void tick() {
        super.tick();

        super.captureCurrentPosition();
    }

    /**
     * Processes the client status updates: respawn attempt from player, opening statistics or achievements, or acquiring
     * 'open inventory' achievement
     */
    @Override
    public void processClientStatus(CClientStatusPacket packetIn) {
        super.processClientStatus(packetIn);
        PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, this.player.getServerWorld());
        this.player.markPlayerActive();
        CClientStatusPacket.State cclientstatuspacket$state = packetIn.getStatus();
        switch(cclientstatuspacket$state) {
            case PERFORM_RESPAWN:
                if (this.player.queuedEndExit) {
                    this.player.queuedEndExit = false;
                    this.player = ((ModPlayerList) this.server.getPlayerList()).spawn(this.player, true);
                    CriteriaTriggers.CHANGED_DIMENSION.testForAll(this.player, World.THE_END, World.OVERWORLD);
                } else {
                    if (this.player.getHealth() > 0.0F) {
                        return;
                    }

                    this.player = ((ModPlayerList) this.server.getPlayerList()).spawn(this.player, false);
                    if (this.server.isHardcore()) {
                        this.player.setGameType(GameType.SPECTATOR);
                        this.player.getServerWorld().getGameRules().get(GameRules.SPECTATORS_GENERATE_CHUNKS).set(false, this.server);
                    }
                }
                break;
            case REQUEST_STATS:
                this.player.getStats().sendStats(this.player);
        }

    }

    public static void register() {
        Ervin_mod_1.register(ModServerPlayNetHandler.class);
    }
}
