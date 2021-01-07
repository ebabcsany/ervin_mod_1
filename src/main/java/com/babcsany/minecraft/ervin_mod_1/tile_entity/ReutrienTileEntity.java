package com.babcsany.minecraft.ervin_mod_1.tile_entity;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.TileEntityInit;
import com.babcsany.minecraft.ervin_mod_1.reutrien.AbstractReutrien;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.WeightedSpawnerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;

import javax.annotation.Nullable;

public class ReutrienTileEntity extends TileEntity implements ITickableTileEntity {
   private final AbstractReutrien spawnerLogic = new AbstractReutrien() {
      public void broadcastEvent(int id) {
         ReutrienTileEntity.this.world.addBlockEvent(ReutrienTileEntity.this.pos, BlockItemInit.REUTRIEN.get(), id, 0);
      }

      public World getWorld() {
         return ReutrienTileEntity.this.world;
      }

      public BlockPos getSpawnerPosition() {
         return ReutrienTileEntity.this.pos;
      }

      public void setNextSpawnData(WeightedSpawnerEntity nextSpawnData) {
         super.setNextSpawnData(nextSpawnData);
         if (this.getWorld() != null) {
            BlockState blockstate = this.getWorld().getBlockState(this.getSpawnerPosition());
            this.getWorld().notifyBlockUpdate(ReutrienTileEntity.this.pos, blockstate, blockstate, 4);
         }

      }
   };

   public ReutrienTileEntity() {
      super(TileEntityInit.REUTRIEN.get());
   }

   public void read(BlockState state, CompoundNBT nbt) {
      super.read(state, nbt);
      this.spawnerLogic.read(nbt);
   }

   public CompoundNBT write(CompoundNBT compound) {
      super.write(compound);
      this.spawnerLogic.write(compound);
      return compound;
   }

   public void tick() {
      this.spawnerLogic.tick();
   }

   /**
    * Retrieves packet to send to the client whenever this Tile Entity is resynced via World.notifyBlockUpdate. For
    * modded TE's, this packet comes back to you clientside in {@link #onDataPacket}
    */
   @Nullable
   public SUpdateTileEntityPacket getUpdatePacket() {
      return new SUpdateTileEntityPacket(this.pos, 1, this.getUpdateTag());
   }

   /* *
    * Get an NBT compound to sync to the client with SPacketChunkData, used for initial loading of the chunk or when
    * many blocks change at once. This compound comes back to you clientside in {@link handleUpdateTag}
    */
   public CompoundNBT getUpdateTag() {
      CompoundNBT compoundnbt = this.write(new CompoundNBT());
      compoundnbt.remove("SpawnPotentials");
      return compoundnbt;
   }

   /* *
    * See {@link Block#eventReceived} for more information. This must return true serverside before it is called
    * clientside.
    */
   public boolean receiveClientEvent(int id, int type) {
      return this.spawnerLogic.setDelayToMin(id) ? true : super.receiveClientEvent(id, type);
   }

   /* *
    * Checks if players can use this tile entity to access operator (permission level 2) commands either directly or
    * indirectly, such as give or setblock. A similar method exists for entities at {@link
    * net.minecraft.entity.Entity#ignoreItemEntityData()}.<p>For example, {@link
    * net.minecraft.tileentity.TileEntitySign#onlyOpsCanSetNbt() signs} (player right-clicking) and {@link
    * net.minecraft.tileentity.TileEntityCommandBlock#onlyOpsCanSetNbt() command blocks} are considered
    * accessible.</p>@return true if this block entity offers ways for unauthorized players to use restricted commands
    */
   public boolean onlyOpsCanSetNbt() {
      return true;
   }

   public AbstractReutrien getSpawnerBaseLogic() {
      return this.spawnerLogic;
   }
}