package com.babcsany.minecraft.ervin_mod_1.network;

import com.babcsany.minecraft.ervin_mod_1.network.play.ModServerPlayNetHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.INetHandler;
import net.minecraft.network.IPacket;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketDirection;
import org.apache.commons.lang3.Validate;

public class ModNetworkManager extends SimpleChannelInboundHandler<IPacket<?>> {
    private final PacketDirection direction;
    /** The INetHandler instance responsible for processing received packets */
    private INetHandler packetListener;

    public ModNetworkManager(PacketDirection packetDirection) {
        this.direction = packetDirection;
    }

    public void tick() {
        if (getNetHandler() instanceof ModServerPlayNetHandler) {
            ((ModServerPlayNetHandler) getNetHandler()).tick();
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, IPacket<?> iPacket) throws Exception {

    }

    /**
     * Sets the NetHandler for this NetworkManager, no checks are made if this handler is suitable for the particular
     * connection state (protocol)
     */
    public void setNetHandler(INetHandler handler) {
        Validate.notNull(handler, "packetListener");
        this.packetListener = handler;
    }

    /**
     * Gets the current handler for processing packets
     */
    public INetHandler getNetHandler() {
        return this.packetListener;
    }

    public PacketDirection getDirection() {
        return this.direction;
    }
}
