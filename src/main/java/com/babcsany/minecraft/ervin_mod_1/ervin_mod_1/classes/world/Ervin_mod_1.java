package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.profiler.IProfiler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.storage.ISpawnWorldInfo;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.function.Supplier;

public abstract class Ervin_mod_1 extends World {
    private Thread mainThread;
    protected Ervin_mod_1(ISpawnWorldInfo p_i231617_1_, RegistryKey<World> p_i231617_2_, RegistryKey<DimensionType> p_i231617_3_, DimensionType p_i231617_4_, Supplier<IProfiler> p_i231617_5_, boolean p_i231617_6_, boolean p_i231617_7_, long p_i231617_8_) {
        super(p_i231617_1_, p_i231617_2_, p_i231617_3_, p_i231617_4_, p_i231617_5_, p_i231617_6_, p_i231617_7_, p_i231617_8_);
    }

    /**
     * Check if the given BlockPos has valid coordinates
     */
    public static boolean isValid(BlockPos pos) {
        return !isOutsideBuildHeight(pos) && func_234934_e_(pos);
    }

    public static boolean func_234935_k_(BlockPos p_234935_0_) {
        return !func_234933_d_(p_234935_0_.getY()) && func_234934_e_(p_234935_0_);
    }

    private static boolean func_234934_e_(BlockPos p_234934_0_) {
        return p_234934_0_.getX() >= -30000000 && p_234934_0_.getZ() >= -30000000 && p_234934_0_.getX() < 30000000 && p_234934_0_.getZ() < 30000000;
    }

    private static boolean func_234933_d_(int p_234933_0_) {
        return p_234933_0_ < -20000000 || p_234933_0_ >= 20000000;
    }

    public static boolean isOutsideBuildHeight(BlockPos pos) {
        return isYOutOfBounds(pos.getY());
    }

    public static boolean isYOutOfBounds(int y) {
        return y < -256 || y >= 1024;
    }

    public boolean setBlockState(BlockPos pos, BlockState state, int flags, int recursionLeft) {
        if (isOutsideBuildHeight(pos)) {
            return false;
        } else if (!this.isRemote && this.func_234925_Z_()) {
            return false;
        } else {
            Chunk chunk = this.getChunkAt(pos);
            Block block = state.getBlock();

            pos = pos.toImmutable(); // Forge - prevent mutable BlockPos leaks
            net.minecraftforge.common.util.BlockSnapshot blockSnapshot = null;
            if (this.captureBlockSnapshots && !this.isRemote) {
                blockSnapshot = net.minecraftforge.common.util.BlockSnapshot.create(this, pos, flags);
                this.capturedBlockSnapshots.add(blockSnapshot);
            }

            BlockState old = getBlockState(pos);
            int oldLight = old.getLightValue(this, pos);
            int oldOpacity = old.getOpacity(this, pos);

            BlockState blockstate = chunk.setBlockState(pos, state, (flags & 64) != 0);
            if (blockstate == null) {
                if (blockSnapshot != null) this.capturedBlockSnapshots.remove(blockSnapshot);
                return false;
            } else {
                BlockState blockstate1 = this.getBlockState(pos);
                if (blockstate1 != blockstate && (blockstate1.getOpacity(this, pos) != oldOpacity || blockstate1.getLightValue(this, pos) != oldLight || blockstate1.isTransparent() || blockstate.isTransparent())) {
                    this.getProfiler().startSection("queueCheckLight");
                    this.getChunkProvider().getLightManager().checkBlock(pos);
                    this.getProfiler().endSection();
                }

                if (blockSnapshot == null) { // Don't notify clients or update physics while capturing blockstates
                    this.markAndNotifyBlock(pos, chunk, blockstate, state, flags, recursionLeft);
                }
                return true;
            }
        }
    }

    public BlockState getBlockState(BlockPos pos) {
        if (isOutsideBuildHeight(pos)) {
            return Blocks.VOID_AIR.getDefaultState();
        } else {
            Chunk chunk = this.getChunk(pos.getX() >> 4, pos.getZ() >> 4);
            return chunk.getBlockState(pos);
        }
    }

    public FluidState getFluidState(BlockPos pos) {
        if (isOutsideBuildHeight(pos)) {
            return Fluids.EMPTY.getDefaultState();
        } else {
            Chunk chunk = this.getChunkAt(pos);
            return chunk.getFluidState(pos);
        }
    }

    @Nullable
    private TileEntity getPendingTileEntityAt(BlockPos pos) {
        for (TileEntity tileentity : this.addedTileEntityList) {
            if (!tileentity.isRemoved() && tileentity.getPos().equals(pos)) {
                return tileentity;
            }
        }

        return null;
    }

    @Nullable
    public TileEntity getTileEntity(BlockPos pos) {
        if (isOutsideBuildHeight(pos)) {
            return null;
        } else if (!this.isRemote && Thread.currentThread() != this.mainThread) {
            return null;
        } else {
            TileEntity tileentity = null;
            if (this.processingLoadedTiles) {
                tileentity = this.getPendingTileEntityAt(pos);
            }

            if (tileentity == null) {
                tileentity = this.getChunkAt(pos).getTileEntity(pos, Chunk.CreateEntityType.IMMEDIATE);
            }

            if (tileentity == null) {
                tileentity = this.getPendingTileEntityAt(pos);
            }

            return tileentity;
        }
    }

    public void setTileEntity(BlockPos pos, @Nullable TileEntity tileEntityIn) {
        if (!isOutsideBuildHeight(pos)) {
            pos = pos.toImmutable(); // Forge - prevent mutable BlockPos leaks
            if (tileEntityIn != null && !tileEntityIn.isRemoved()) {
                if (this.processingLoadedTiles) {
                    tileEntityIn.setWorldAndPos(this, pos);
                    Iterator<TileEntity> iterator = this.addedTileEntityList.iterator();

                    while(iterator.hasNext()) {
                        TileEntity tileentity = iterator.next();
                        if (tileentity.getPos().equals(pos)) {
                            tileentity.remove();
                            iterator.remove();
                        }
                    }

                    this.addedTileEntityList.add(tileEntityIn);
                } else {
                    Chunk chunk = this.getChunkAt(pos);
                    if (chunk != null) chunk.addTileEntity(pos, tileEntityIn);
                    this.addTileEntity(tileEntityIn);
                }
            }

        }
    }

    public boolean isBlockPresent(BlockPos pos) {
        return isOutsideBuildHeight(pos) ? false : this.getChunkProvider().chunkExists(pos.getX() >> 4, pos.getZ() >> 4);
    }

    public boolean func_234929_a_(BlockPos p_234929_1_, Entity p_234929_2_, Direction p_234929_3_) {
        if (isOutsideBuildHeight(p_234929_1_)) {
            return false;
        } else {
            IChunk ichunk = this.getChunk(p_234929_1_.getX() >> 4, p_234929_1_.getZ() >> 4, ChunkStatus.FULL, false);
            return ichunk == null ? false : ichunk.getBlockState(p_234929_1_).isTopSolid(this, p_234929_1_, p_234929_2_, p_234929_3_);
        }
    }
}
