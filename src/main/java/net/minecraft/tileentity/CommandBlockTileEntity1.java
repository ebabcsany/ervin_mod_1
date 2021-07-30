package net.minecraft.tileentity;

import com.babcsany.minecraft.ervin_mod_1.block.Friszernk;
import com.babcsany.minecraft.ervin_mod_1.block.FriszernLogic;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CommandBlockBlock;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class CommandBlockTileEntity1 extends TileEntity {
   private boolean powered;
   private boolean auto;
   private boolean conditionMet;
   private boolean sendToClient;
   protected boolean removed;
   private CompoundNBT customTileData;
   private final CommandBlockLogic commandBlockLogic = new CommandBlockLogic() {
      /**
       * Sets the command.
       */
      public void setCommand(String command) {
         super.setCommand(command);
         CommandBlockTileEntity1.this.markDirty();
      }

      public ServerWorld getWorld() {
         return (ServerWorld) CommandBlockTileEntity1.this.world;
      }

      public void updateCommand() {
         BlockState blockstate = CommandBlockTileEntity1.this.world.getBlockState(CommandBlockTileEntity1.this.pos);
         this.getWorld().notifyBlockUpdate(CommandBlockTileEntity1.this.pos, blockstate, blockstate, 3);
      }

      @OnlyIn(Dist.CLIENT)
      public Vector3d getPositionVector() {
         return Vector3d.copyCentered(CommandBlockTileEntity1.this.pos);
      }

      public CommandSource getCommandSource() {
         return new CommandSource(this, Vector3d.copyCentered(CommandBlockTileEntity1.this.pos), Vector2f.ZERO, this.getWorld(), 2, this.getName().getString(), this.getName(), this.getWorld().getServer(), (Entity)null);
      }
   };

   public CommandBlockTileEntity1() {
      super(TileEntityType.COMMAND_BLOCK);
   }

   public CompoundNBT write(CompoundNBT compound) {
      super.write(compound);
      this.commandBlockLogic.write(compound);
      compound.putBoolean("powered", this.isPowered());
      compound.putBoolean("conditionMet", this.isConditionMet());
      compound.putBoolean("auto", this.isAuto());
      return compound;
   }

   public void read(BlockState state, CompoundNBT nbt) {
      super.read(state, nbt);
      this.commandBlockLogic.read(nbt);
      this.powered = nbt.getBoolean("powered");
      this.conditionMet = nbt.getBoolean("conditionMet");
      this.setAuto(nbt.getBoolean("auto"));
   }

   public void read1(BlockState state, CompoundNBT nbt) {
      this.pos = new BlockPos(nbt.getInt("x"), nbt.getInt("y"), nbt.getInt("z"));
      if (nbt.contains("ForgeData")) this.customTileData = nbt.getCompound("ForgeData");
      if (getCapabilities() != null && nbt.contains("ForgeCaps")) deserializeCaps(nbt.getCompound("ForgeCaps"));
   }

   public CompoundNBT write1(CompoundNBT compound) {
      return this.writeInternal(compound);
   }

   private CompoundNBT writeInternal(CompoundNBT compound) {
      ResourceLocation resourcelocation = TileEntityType.getId(this.getType());
      if (resourcelocation == null) {
         throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
      } else {
         compound.putString("id", resourcelocation.toString());
         compound.putInt("x", this.pos.getX());
         compound.putInt("y", this.pos.getY());
         compound.putInt("z", this.pos.getZ());
         if (this.customTileData != null) compound.put("ForgeData", this.customTileData);
         if (getCapabilities() != null) compound.put("ForgeCaps", serializeCaps());
         return compound;
      }
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
    * net.minecraft.tileentity.SignTileEntity#onlyOpsCanSetNbt() signs} (player right-clicking) and {@link
    * CommandBlockTileEntity1#onlyOpsCanSetNbt() command blocks} are considered
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

   }

   public void func_226987_h_() {
      Mode commandblocktileentity$mode = this.getMode();
      if (commandblocktileentity$mode == Mode.AUTO && (this.powered || this.auto) && this.world != null) {
         this.func_226988_y_();
      }

   }

   private void func_226988_y_() {
      Block block = this.getBlockState().getBlock();
      if (block instanceof CommandBlockBlock) {
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
            this.conditionMet = tileentity instanceof CommandBlockTileEntity1 && ((CommandBlockTileEntity1)tileentity).getCommandBlockLogic().getSuccessCount() > 0;
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

   public void validate1() {
      this.removed = false;
   }

   public static enum Mode {
      SEQUENCE,
      AUTO,
      REDSTONE;
   }

   public static class FriszernTileEntity extends CommandBlockTileEntity1 {
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

      public CompoundNBT write1(CompoundNBT compound) {
         super.write1(compound);
         this.friszernLogic.write(compound);
         compound.putBoolean("powered", this.isPowered());
         compound.putBoolean("conditionMet", this.isConditionMet());
         compound.putBoolean("auto", this.isAuto());
         return compound;
      }

      public void read1(BlockState state, CompoundNBT nbt) {
         super.read1(state, nbt);
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
         boolean flag = this.auto;
         this.auto = autoIn;
         if (!flag && autoIn && !this.powered && this.world != null && this.getFriszernMode() != FriszernTileEntity.Mode.SEQUENCE) {
            this.func_226988_y_();
         }

      }

      public void func_226987_i_() {
         FriszernTileEntity.Mode friszernTileEntity$mode = this.getFriszernMode();
         if (friszernTileEntity$mode == FriszernTileEntity.Mode.AUTO && (this.powered || this.auto) && this.world != null) {
            this.func_226988_y_();
         }

      }

      private void func_226988_y_() {
         Block block = this.getBlockState().getBlock();
         if (block instanceof Friszernk) {
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
            BlockPos blockPos = this.pos.offset(this.world.getBlockState(this.pos).get(Friszernk.FACING).getOpposite());
            if (this.world.getBlockState(blockPos).getBlock() instanceof Friszernk) {
               TileEntity tileEntity = this.world.getTileEntity(blockPos);
               this.conditionMet = tileEntity instanceof com.babcsany.minecraft.ervin_mod_1.block.FriszernTileEntity && ((com.babcsany.minecraft.ervin_mod_1.block.FriszernTileEntity)tileEntity).getLogic().getSuccessCount() > 0;
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

      public boolean isConditional1() {
         BlockState blockstate = this.world.getBlockState(this.getPos());
         return blockstate.getBlock() instanceof Friszernk ? blockstate.get(Friszernk.CONDITIONAL) : false;
      }

      /**
       * validates a tile entity
       */
      public void validate1() {
         this.updateContainingBlockInfo();
         super.validate1();
      }

      public enum Mode {
         SEQUENCE,
         AUTO,
         REDSTONE;
      }
   }
}