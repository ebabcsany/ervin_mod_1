package com.babcsany.minecraft.ervin_mod_1.play;

import com.babcsany.minecraft.ervin_mod_1.block.FriszernTileEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.IServerPlayNetHandler;
import net.minecraft.tileentity.CommandBlockTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.io.IOException;

public class CUpdateFriszernPacket implements IPacket<IServerPlayNetHandler1> {
   private BlockPos pos;
   private String command;
   private boolean trackOutput;
   private boolean conditional;
   private boolean auto;
   private FriszernTileEntity.Mode mode;

   public CUpdateFriszernPacket() {
   }

   @OnlyIn(Dist.CLIENT)
   public CUpdateFriszernPacket(BlockPos p_i49543_1_, String p_i49543_2_, FriszernTileEntity.Mode p_i49543_3_, boolean p_i49543_4_, boolean p_i49543_5_, boolean p_i49543_6_) {
      this.pos = p_i49543_1_;
      this.command = p_i49543_2_;
      this.trackOutput = p_i49543_4_;
      this.conditional = p_i49543_5_;
      this.auto = p_i49543_6_;
      this.mode = p_i49543_3_;
   }

   /**
    * Reads the raw packet data from the data stream.
    */
   public void readPacketData(PacketBuffer buf) throws IOException {
      this.pos = buf.readBlockPos();
      this.command = buf.readString(32767);
      this.mode = buf.readEnumValue(FriszernTileEntity.Mode.class);
      int i = buf.readByte();
      this.trackOutput = (i & 1) != 0;
      this.conditional = (i & 2) != 0;
      this.auto = (i & 4) != 0;
   }

   /**
    * Writes the raw packet data to the data stream.
    */
   public void writePacketData(PacketBuffer buf) throws IOException {
      buf.writeBlockPos(this.pos);
      buf.writeString(this.command);
      buf.writeEnumValue(this.mode);
      int i = 0;
      if (this.trackOutput) {
         i |= 1;
      }

      if (this.conditional) {
         i |= 2;
      }

      if (this.auto) {
         i |= 4;
      }

      buf.writeByte(i);
   }

   /**
    * Passes this Packet on to the NetHandler for processing.
    */
   public void processPacket(IServerPlayNetHandler1 handler) {
      handler.processUpdateFriszern(this);
   }

   public BlockPos getPos() {
      return this.pos;
   }

   public String getCommand() {
      return this.command;
   }

   public boolean shouldTrackOutput() {
      return this.trackOutput;
   }

   public boolean isConditional() {
      return this.conditional;
   }

   public boolean isAuto() {
      return this.auto;
   }

   public FriszernTileEntity.Mode getMode() {
      return this.mode;
   }
}