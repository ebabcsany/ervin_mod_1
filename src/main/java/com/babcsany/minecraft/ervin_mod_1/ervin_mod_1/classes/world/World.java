package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.world;

import net.minecraft.profiler.IProfiler;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.iorld;
import net.minecraft.world.storage.ISpawnWorldInfo;

import java.util.function.Supplier;

public abstract class World extends iorld implements World_ {
    protected World(ISpawnWorldInfo spawnWorldInfo, RegistryKey<iorld> worldRegistryKey, RegistryKey<DimensionType> dimensionTypeRegistryKey, DimensionType dimensionType, Supplier<IProfiler> profilerSupplier, boolean b, boolean b1, long l) {
        super(spawnWorldInfo, worldRegistryKey, dimensionTypeRegistryKey, dimensionType, profilerSupplier, b, b1, l);
    }

    public static boolean isOutsideBuildHeight(BlockPos pos) {
        return isYOutOfBounds(pos.getY());
    }

    public static boolean isYOutOfBounds(int y) {
        return y < -64 || y >= 1024;
    }

    /*@Override
    public void notifyBlockUpdate(BlockPos pos, BlockState oldState, BlockState newState, int flags) {

    }

    @Override
    public void playSound(@Nullable PlayerEntity player, double x, double y, double z, SoundEvent soundIn, SoundCategory category, float volume, float pitch) {

    }

    @Override
    public void playMovingSound(@Nullable PlayerEntity playerIn, Entity entityIn, SoundEvent eventIn, SoundCategory categoryIn, float volume, float pitch) {

    }

    @Nullable
    @Override
    public Entity getEntityByID(int id) {
        return null;
    }

    @Nullable
    @Override
    public MapData getMapData(String mapName) {
        return null;
    }

    @Override
    public void registerMapData(MapData mapDataIn) {

    }

    @Override
    public int getNextMapId() {
        return 0;
    }

    @Override
    public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress) {

    }

    @Override
    public Scoreboard getScoreboard() {
        return null;
    }

    @Override
    public RecipeManager getRecipeManager() {
        return null;
    }

    @Override
    public NetworkTagManager getTags() {
        return null;
    }

    @Override
    public ITickList<Block> getPendingBlockTicks() {
        return null;
    }

    @Override
    public ITickList<Fluid> getPendingFluidTicks() {
        return null;
    }

    @Override
    public AbstractChunkProvider getChunkProvider() {
        return null;
    }

    @Override
    public void playEvent(@Nullable PlayerEntity player, int type, BlockPos pos, int data) {

    }

    @Override
    public float func_230487_a_(Direction p_230487_1_, boolean p_230487_2_) {
        return 0;
    }

    @Override
    public List<? extends PlayerEntity> getPlayers() {
        return null;
    }

    @Override
    public Biome getNoiseBiomeRaw(int x, int y, int z) {
        return null;
    }*/
}
