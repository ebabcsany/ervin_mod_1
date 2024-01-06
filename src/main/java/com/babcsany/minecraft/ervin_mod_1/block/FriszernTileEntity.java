package com.babcsany.minecraft.ervin_mod_1.block;

import com.babcsany.minecraft.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.command.CommandSource;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class FriszernTileEntity extends TileEntity {
   private boolean powered;
   private boolean auto;
   private boolean conditionMet;
   private boolean sendToClient;
   private final FriszernLogic friszernLogic = new FriszernLogic() {
      /**
       * Sets the command.
       */
      public void setCommand(String command) {
         super.setCommand(command);
         FriszernTileEntity.this.markDirty();
      }

      public ServerWorld getWorld() {
         return (ServerWorld) FriszernTileEntity.this.world;
      }

      public void updateCommand() {
         BlockState blockstate = FriszernTileEntity.this.world.getBlockState(FriszernTileEntity.this.pos);
         this.getWorld().notifyBlockUpdate(FriszernTileEntity.this.pos, blockstate, blockstate, 3);
      }

      @OnlyIn(Dist.CLIENT)
      public Vector3d getPositionVector() {
         return Vector3d.copyCentered(FriszernTileEntity.this.pos);
      }

      public CommandSource getCommandSource() {
         return new CommandSource(this, Vector3d.copyCentered(FriszernTileEntity.this.pos), Vector2f.ZERO, this.getWorld(), 2, this.getName().getString(), this.getName(), this.getWorld().getServer(), null);
      }
   };

   public FriszernTileEntity(TileEntityType<?> tileEntityTypeIn) {
      super(tileEntityTypeIn);
   }

   public CompoundNBT write1(CompoundNBT compound) {
      super.write(compound);
      this.friszernLogic.write(compound);
      compound.putBoolean("powered", this.isPowered());
      compound.putBoolean("conditionMet", this.isConditionMet());
      compound.putBoolean("auto", this.isAuto());
      return compound;
   }

   public void read1(BlockState state, CompoundNBT nbt) {
      super.read(state, nbt);
      this.friszernLogic.read(nbt);
      this.powered = nbt.getBoolean("powered");
      this.conditionMet = nbt.getBoolean("conditionMet");
      this.setAuto(nbt.getBoolean("auto"));
   }

   /**
    * Retrieves packet to send to the client whenever this Tile Entity is resynced via World.notifyBlockUpdate. For
    * modded TE's, this packet comes back to you clientside in {@link #onDataPacket}
    */
   @Nullable
   public SUpdateTileEntityPacket getUpdatePacket() {
      if (this.isSendToClient()) {
         this.setSendToClient(false);
         CompoundNBT compoundNBT = this.write(new CompoundNBT());
         return new SUpdateTileEntityPacket(this.pos, 2, compoundNBT);
      } else {
         return null;
      }
   }

   /* *
    * Checks if players can use this tile entity to access operator (permission level 2) commands either directly or
    * indirectly, such as give or setblock. A similar method exists for entities at {@link
    * Entity#ignoreItemEntityData()}.<p>For example, {@link
    * net.minecraft.tileentity.TileEntitySign#onlyOpsCanSetNbt() signs} (player right-clicking) and {@link
    * net.minecraft.tileentity.TileEntityCommandBlock#onlyOpsCanSetNbt() command blocks} are considered
    * accessible.</p>@return true if this block entity offers ways for unauthorized players to use restricted commands
    */
   public boolean onlyOpsCanSetNbt() {
      return true;
   }

   public FriszernLogic getLogic() {
      return this.friszernLogic;
   }

   public void setPowered(boolean poweredIn) {
      this.powered = poweredIn;
   }

   public boolean isPowered() {
      return this.powered;
   }

   public boolean isAuto() {
      return this.auto;
   }

   public void setAuto(boolean autoIn) {
      this.auto = autoIn;

   }

   public boolean isConditionMet() {
      return this.conditionMet;
   }

   public boolean isSendToClient() {
      return this.sendToClient;
   }

   public void setSendToClient(boolean p_184252_1_) {
      this.sendToClient = p_184252_1_;
   }

   public FriszernTileEntity.Mode getFriszernMode() {
      BlockState blockState = this.getBlockState();
      if (blockState.isIn(BlockInit.FRISZERN)) {
         return FriszernTileEntity.Mode.REDSTONE;
      } else if (blockState.isIn(BlockInit.REPEATING_FRISZERN)) {
         return FriszernTileEntity.Mode.AUTO;
      } else {
         return blockState.isIn(BlockInit.CHAIN_FRISZERN) ? FriszernTileEntity.Mode.SEQUENCE : FriszernTileEntity.Mode.REDSTONE;
      }
   }

   /**
    * validates a tile entity
    */
   public void validate1() {
      this.updateContainingBlockInfo();
      super.validate();
   }

   public enum Mode {
      SEQUENCE,
      AUTO,
      REDSTONE;
   }
}