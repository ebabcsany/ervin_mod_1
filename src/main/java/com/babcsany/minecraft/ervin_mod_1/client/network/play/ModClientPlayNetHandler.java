package com.babcsany.minecraft.ervin_mod_1.client.network.play;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.Huihk;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.TawrolEntity;
import com.babcsany.minecraft.init.EntityInit;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;

public class ModClientPlayNetHandler extends ClientPlayNetHandler {
    /** Reference to the Minecraft instance, which many handler methods operate on */
    private Minecraft client;
    /** Reference to the current ClientWorld instance, which many handler methods operate on */
    private ClientWorld world;

    public ModClientPlayNetHandler(Minecraft mcIn, Screen previousGuiScreen, NetworkManager networkManagerIn, GameProfile profileIn) {
        super(mcIn, previousGuiScreen, networkManagerIn, profileIn);
        this.client = mcIn;
    }

    @Override
    public void handleSpawnObject(SSpawnObjectPacket packetIn) {
        super.handleSpawnObject(packetIn);
//        PacketThreadUtil.checkThreadAndEnqueue(packetIn, this, this.client);
        double d0 = packetIn.getX();
        double d1 = packetIn.getY();
        double d2 = packetIn.getZ();
        EntityType<?> entitytype = packetIn.getType();
        Entity entity;
        /*if (entitytype == EntityInit.HUIHK.get()) {
            Entity entity1 = this.getWorld().getEntityByID(packetIn.getData());
            if (entity1 instanceof PlayerEntity) {
                entity = new Huihk(this.getWorld(), (PlayerEntity) entity1, d0, d1, d2);
            } else {
                entity = null;
            }
        } else if (entitytype == EntityInit.TAWROL.get()) {
            entity = new TawrolEntity(this.getWorld(), d0, d1, d2);
        } else if (entitytype == EntityType.ITEM) {
            entity = new ItemEntity(this.getWorld(), d0, d1, d2);
        } else {
            entity = null;
        }

        if (entity != null) {
            int i = packetIn.getEntityID();
            entity.setPacketCoordinates(d0, d1, d2);
            entity.moveForced(d0, d1, d2);
            entity.rotationPitch = (float)(packetIn.getPitch() * 360) / 256.0F;
            entity.rotationYaw = (float)(packetIn.getYaw() * 360) / 256.0F;
            entity.setEntityId(i);
            entity.setUniqueId(packetIn.getUniqueId());
            this.getWorld().addEntity(i, entity);
        }*/
    }

    public static void register() {
        Ervin_mod_1.register(ModClientPlayNetHandler.class);
    }
}
