package com.babcsany.minecraft.ervin_mod_1.network;

import com.babcsany.minecraft.ervin_mod_1.network.play.ModServerPlayNetHandler;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.IPacket;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketDirection;

public class ModNetworkManager extends NetworkManager {
    public ModNetworkManager(PacketDirection packetDirection) {
        super(packetDirection);
    }

    @Override
    public void channelRead0(ChannelHandlerContext p_channelRead0_1_, IPacket<?> p_channelRead0_2_) throws Exception {
        super.channelRead0(p_channelRead0_1_, p_channelRead0_2_);
    }

    @Override
    public void tick() {
        super.tick();

        if (super.getNetHandler() instanceof ModServerPlayNetHandler) {
            ((ModServerPlayNetHandler) super.getNetHandler()).tick();
        }
    }
}
