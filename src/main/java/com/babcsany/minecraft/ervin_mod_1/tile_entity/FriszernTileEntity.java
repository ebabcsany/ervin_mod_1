package com.babcsany.minecraft.ervin_mod_1.tile_entity;

import com.babcsany.minecraft.ervin_mod_1.block.Friszern;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CommandBlockBlock;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.CommandBlockLogic;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
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
   private final CommandBlockLogic commandBlockLogic = new CommandBlockLogic() {
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
         return new CommandSource(this, Vector3d.copyCentered(FriszernTileEntity.this.pos), Vector2f.ZERO, this.getWorld(), 2, this.getName().getString(), this.getName(), this.getWorld().getServer(), (Entity)null);
      }
   };

   public FriszernTileEntity() {
      super(TileEntityType.COMMAND_BLOCK);
   }

   public CompoundNBT write(CompoundNBT compound) {
      super.write(compound);
      compound.putBoolean("powered", this.isPowered());
      compound.putBoolean("conditionMet", this.isConditionMet());
      compound.putBoolean("auto", this.isAuto());
      return compound;
   }

   public void read(BlockState state, CompoundNBT nbt) {
      super.read(state, nbt);
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
         CompoundNBT compoundnbt = this.write(new CompoundNBT());
         return new SUpdateTileEntityPacket(this.pos, 2, compoundnbt);
      } else {
         return null;
      }
   }

   /**
    * Checks if players can use this tile entity to access operator (permission level 2) commands either directly or
    * indirectly, such as give or setblock. A similar method exists for entities at {@link
    * Entity#ignoreItemEntityData()}.<p>For example, {@link
    * SignTileEntity#onlyOpsCanSetNbt() signs} (player right-clicking) and {@link
    * FriszernTileEntity#onlyOpsCanSetNbt() command blocks} are considered
    * accessible.</p>@return true if this block entity offers ways for unauthorized players to use restricted commands
    */
   public boolean onlyOpsCanSetNbt() {
      return true;
   }

   public CommandBlockLogic getCommandBlockLogic() {
      return this.commandBlockLogic;
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
      boolean flag = this.auto;
      this.auto = autoIn;
      if (!flag && autoIn && !this.powered && this.world != null && this.getMode() != Mode.SEQUENCE) {
         this.func_226988_y_();
      }
      if (!flag && autoIn && !this.powered && this.world != null && this.getMode() != Mode.SEQUENCE) {
         this.func_226988_z_();
      }

   }

   public void func_226987_h_() {
      Mode commandblocktileentity$mode = this.getMode();
      if (commandblocktileentity$mode == Mode.AUTO && (this.powered || this.auto) && this.world != null) {
         this.func_226988_y_();
      }
      if (commandblocktileentity$mode == Mode.AUTO && (this.powered || this.auto) && this.world != null) {
         this.func_226988_z_();
      }

   }

   private void func_226988_y_() {
      Block block = this.getBlockState().getBlock();
      if (block instanceof CommandBlockBlock) {
         this.setConditionMet();
         this.world.getPendingBlockTicks().scheduleTick(this.pos, block, 1);
      }

   }

   private void func_226988_z_() {
      Block block = this.getBlockState().getBlock();
      if (block instanceof Friszern) {
         this.setConditionMet();
         this.world.getPendingBlockTicks().scheduleTick(this.pos, block, 1);
      }

   }

   public boolean isConditionMet() {
      return this.conditionMet;
   }

   public boolean setConditionMet() {
      this.conditionMet = true;
      if (this.isConditional()) {
         BlockPos blockpos = this.pos.offset(this.world.getBlockState(this.pos).get(CommandBlockBlock.FACING).getOpposite());
         if (this.world.getBlockState(blockpos).getBlock() instanceof CommandBlockBlock) {
            TileEntity tileentity = this.world.getTileEntity(blockpos);
            this.conditionMet = tileentity instanceof FriszernTileEntity;
         } else {
            this.conditionMet = false;
         }
      }

      return this.conditionMet;
   }

   public boolean isSendToClient() {
      return this.sendToClient;
   }

   public void setSendToClient(boolean p_184252_1_) {
      this.sendToClient = p_184252_1_;
   }

   public Mode getMode() {
      BlockState blockstate = this.getBlockState();
      if (blockstate.isIn(Blocks.COMMAND_BLOCK)) {
         return Mode.REDSTONE;
      } else if (blockstate.isIn(Blocks.REPEATING_COMMAND_BLOCK)) {
         return Mode.AUTO;
      } else {
         return blockstate.isIn(Blocks.CHAIN_COMMAND_BLOCK) ? Mode.SEQUENCE : Mode.REDSTONE;
      }
   }

   public boolean isConditional() {
      BlockState blockstate = this.world.getBlockState(this.getPos());
      return blockstate.getBlock() instanceof CommandBlockBlock ? blockstate.get(CommandBlockBlock.CONDITIONAL) : false;
   }

   /**
    * validates a tile entity
    */
   public void validate() {
      this.updateContainingBlockInfo();
      super.validate();
   }

   public static enum Mode {
      SEQUENCE,
      AUTO,
      REDSTONE;
   }
}
