package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.world.gen.Heightmap;
import com.babcsany.minecraft.world.world;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.profiler.IProfiler;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.ITickList;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.AbstractChunkProvider;
import net.minecraft.world.storage.ISpawnWorldInfo;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class WorldInit extends world {

    public static WorldInit WORLDS;

    public static ISpawnWorldInfo worldInfo;
    public static RegistryKey<World> worldRegistryKey;
    public static RegistryKey<DimensionType> dimensionTypeRegistryKey;
    public static DimensionType dimensionType;
    public static Supplier<IProfiler> profilerSupplier;
    public static boolean Boolean;
    public static long Long;

    public static final RegistryKey<World> EXAMPLE = worldRegistryKey("example");

    public WorldInit() {
        this(worldInfo, worldRegistryKey, dimensionTypeRegistryKey, dimensionType, profilerSupplier, Boolean, Boolean, Long);
    }

    public WorldInit(ISpawnWorldInfo p_i231617_1_, RegistryKey<net.minecraft.world.World> p_i231617_2_, RegistryKey<DimensionType> p_i231617_3_, DimensionType p_i231617_4_, Supplier<IProfiler> p_i231617_5_, boolean p_i231617_6_, boolean p_i231617_7_, long p_i231617_8_) {
        super(p_i231617_1_, p_i231617_2_, p_i231617_3_, p_i231617_4_, p_i231617_5_, p_i231617_6_, p_i231617_7_, p_i231617_8_);
    }

    public static RegistryKey<World> worldRegistryKey(String key) {
        return registryKey(key, worldRegistryKey);
    }

    public static <T> RegistryKey<T> registryKey(String key, RegistryKey<T> registryKey) {
        RegistryKey<T> dimensionRegistryKey = registryKey;
        RegistryKey.func_240903_a_(Registry.DIMENSION_KEY, new ResourceLocation(string(key)));
        return dimensionRegistryKey;
    }

    public static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
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
    public net.minecraft.world.World getWorld() {
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
    public int getHeight(Heightmap.Type heightmapType, int x, int z) {
        return 0;
    }

    @Override
    public Biome getNoiseBiomeRaw(int x, int y, int z) {
        return null;
    }
}
