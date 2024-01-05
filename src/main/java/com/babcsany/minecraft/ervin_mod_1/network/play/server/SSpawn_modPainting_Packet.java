package com.babcsany.minecraft.ervin_mod_1.network.play.server;

import com.babcsany.minecraft.ervin_mod_1.entity.item.modPainting_Entity;
import com.babcsany.minecraft.ervin_mod_1.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.io.IOException;
import java.util.UUID;

public class SSpawn_modPainting_Packet implements IPacket<IClientPlayNetHandler> {
   private int entityID;
   private UUID uniqueId;
   private BlockPos position;
   private Direction facing;
   private int title;

   public SSpawn_modPainting_Packet() {
   }

   public SSpawn_modPainting_Packet(modPainting_Entity painting) {
      this.entityID = painting.getEntityId();
      this.uniqueId = painting.getUniqueID();
      this.position = painting.getHangingPosition();
      this.facing = painting.getHorizontalFacing();
      //this.title = ModRegistry.modPainting_MOTIVE.getId(painting.art);
   }

   /**
    * Reads the raw packet data from the data stream.
    */
   public void readPacketData(PacketBuffer buf) throws IOException {
      this.entityID = buf.readVarInt();
      this.uniqueId = buf.readUniqueId();
      this.title = buf.readVarInt();
      this.position = buf.readBlockPos();
      this.facing = Direction.byHorizontalIndex(buf.readUnsignedByte());
   }

   /**
    * Writes the raw packet data to the data stream.
    */
   public void writePacketData(PacketBuffer buf) throws IOException {
      buf.writeVarInt(this.entityID);
      buf.writeUniqueId(this.uniqueId);
      buf.writeVarInt(this.title);
      buf.writeBlockPos(this.position);
      buf.writeByte(this.facing.getHorizontalIndex());
   }

   /**
    * Passes this Packet on to the NetHandler for processing.
    */
   public void processPacket(IClientPlayNetHandler handler) {
      handler.handleSpawn_modPainting(this);
   }

   @OnlyIn(Dist.CLIENT)
   public int getEntityID() {
      return this.entityID;
   }

   @OnlyIn(Dist.CLIENT)
   public UUID getUniqueId() {
      return this.uniqueId;
   }

   @OnlyIn(Dist.CLIENT)
   public BlockPos getPosition() {
      return this.position;
   }

   @OnlyIn(Dist.CLIENT)
   public Direction getFacing() {
      return this.facing;
   }

   /*@OnlyIn(Dist.CLIENT)
   public modPainting_Type getType() {
      return ModRegistry.modPainting_MOTIVE.getByValue(this.title);
   }*/
}
