package com.babcsany.minecraft.world.server;

import com.mojang.datafixers.DataFixer;
import net.minecraft.entity.Entity;
import net.minecraft.network.IPacket;
import net.minecraft.util.concurrent.ThreadTaskExecutor;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.village.PointOfInterestManager;
import net.minecraft.world.chunk.IChunkLightProvider;
import net.minecraft.world.chunk.listener.IChunkStatusListener;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.*;
import net.minecraft.world.server.TicketManager;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.SaveFormat;

import javax.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class S extends TicketManager {

    public static B b;
    public boolean ProcessUpdates(ChunkManager chunkManager) {
        return processUpdates(chunkManager);
    }
    public S(Executor p_i50707_1_, Executor p_i50707_2_) {
        super(p_i50707_1_, p_i50707_2_);
    }

    @Override
    protected void forceChunk(ChunkPos pos, boolean add) {
        super.forceChunk(pos, add);
    }

    @Override
    public boolean contains(long p_219371_1_) {
        return false;
    }

    @Nullable
    @Override
    public ChunkHolder getChunkHolder(long chunkPosIn) {
        return null;
    }

    @Nullable
    @Override
    public ChunkHolder setChunkLevel(long chunkPosIn, int newLevel, @Nullable ChunkHolder holder, int oldLevel) {
        return null;
    }

    public void tick_() {
        this.tick();
    }

    public static class L extends G {

        public L(ServerWorld p_i232602_1_, SaveFormat.LevelSave p_i232602_2_, DataFixer p_i232602_3_, TemplateManager p_i232602_4_, Executor p_i232602_5_, ThreadTaskExecutor<Runnable> p_i232602_6_, IChunkLightProvider p_i232602_7_, ChunkGenerator p_i232602_8_, IChunkStatusListener p_i232602_9_, Supplier<DimensionSavedDataManager> p_i232602_10_, int p_i232602_11_, boolean p_i232602_12_) {
            super(p_i232602_1_, p_i232602_2_, p_i232602_3_, p_i232602_4_, p_i232602_5_, p_i232602_6_, p_i232602_7_, p_i232602_8_, p_i232602_9_, p_i232602_10_, p_i232602_11_, p_i232602_12_);
        }

        @Override
        protected void sendToAllTracking(Entity entity, IPacket<?> p_219222_2_) {
            super.sendToAllTracking(entity, p_219222_2_);
        }

        @Override
        public PointOfInterestManager getPointOfInterestManager() {
            return super.getPointOfInterestManager();
        }

        @Override
        protected void setViewDistance(int viewDistance) {
            super.setViewDistance(viewDistance);
        }

        @Override
        public void untrack(Entity entity) {
            super.untrack(entity);
        }

        @Override
        public void sendToTrackingAndSelf(Entity entity, IPacket<?> p_219225_2_) {
            super.sendToTrackingAndSelf(entity, p_219225_2_);
        }

        @Override
        public void track(Entity entityIn) {
            super.track(entityIn);
        }

        @Override
        public void tickEntityTracker() {
            super.tickEntityTracker();
        }

        @Override
        public boolean isOutsideSpawningRadius(ChunkPos chunkPosIn) {
            return super.isOutsideSpawningRadius(chunkPosIn);
        }

        @Override
        public Iterable<ChunkHolder> getLoadedChunksIterable() {
            return super.getLoadedChunksIterable();
        }



        public ServerWorldLightManager get_LightManager() {
            return super.getLightManager();
        }

        @Nullable
        public ChunkHolder func_219219_b_(long chunkPosIn) {
            return super.func_219219_b(chunkPosIn);
        }

        public void save_1(boolean flush) {
            save(flush);
        }

        public boolean refresh_Off_ThreadCache() {
            return refreshOffThreadCache();
        }

        public void tick_(BooleanSupplier hasMoreTime) {
            this.tick(hasMoreTime);
        }
    }

    public static class B extends ModChunkManager {
        private static ModServerWorld modServerWorld;
        private static SaveFormat.LevelSave levelSave;
        private static DataFixer dataFixer;
        private static TemplateManager templateManager;
        private static Executor executor;
        private static ThreadTaskExecutor<Runnable> runnableThreadTaskExecutor;
        private static IChunkLightProvider iChunkLightProvider;
        private static ChunkGenerator chunkGenerator;
        private static IChunkStatusListener iChunkStatusListener;
        private static Supplier<DimensionSavedDataManager> dimensionSavedDataManagerSupplier;
        private static int anInt;
        private static boolean aBoolean;

        public B() {
            this(modServerWorld, levelSave, dataFixer, templateManager, executor, runnableThreadTaskExecutor, iChunkLightProvider, chunkGenerator, iChunkStatusListener, dimensionSavedDataManagerSupplier, anInt, aBoolean);
        }

        public void G() {
            get_TicketManager();
        }

        public B(ModServerWorld modServerWorld, SaveFormat.LevelSave levelSave, DataFixer dataFixer, TemplateManager templateManager, Executor executor, ThreadTaskExecutor<Runnable> runnableThreadTaskExecutor, IChunkLightProvider iChunkLightProvider, ChunkGenerator chunkGenerator, IChunkStatusListener iChunkStatusListener, Supplier<DimensionSavedDataManager> dimensionSavedDataManagerSupplier, int anInt, boolean aBoolean) {
            super(modServerWorld, levelSave, dataFixer, templateManager, executor, runnableThreadTaskExecutor, iChunkLightProvider, chunkGenerator, iChunkStatusListener, dimensionSavedDataManagerSupplier, anInt, aBoolean);
        }
    }
}
