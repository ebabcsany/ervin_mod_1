package com.babcsany.minecraft.entity;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class EntityType<T extends Entity> extends net.minecraft.entity.EntityType<T> {
    private ResourceLocation name;
    @Nullable
    private T value;

    public EntityType(IFactory<T> p_i231489_1_, EntityClassification p_i231489_2_, boolean p_i231489_3_, boolean p_i231489_4_, boolean p_i231489_5_, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize p_i231489_8_, int trackingRange, int updateInterval) {
        super(p_i231489_1_, p_i231489_2_, p_i231489_3_, p_i231489_4_, p_i231489_5_, p_i231489_6_, p_i231489_7_, p_i231489_8_, trackingRange, updateInterval);
    }

    public EntityType(IFactory<T> p_i231489_1_, EntityClassification p_i231489_2_, boolean p_i231489_3_, boolean p_i231489_4_, boolean p_i231489_5_, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize p_i231489_8_, int trackingRange, int updateInterval, Predicate<net.minecraft.entity.EntityType<?>> velocityUpdateSupplier, ToIntFunction<net.minecraft.entity.EntityType<?>> trackingRangeSupplier, ToIntFunction<net.minecraft.entity.EntityType<?>> updateIntervalSupplier, BiFunction<FMLPlayMessages.SpawnEntity, World, T> customClientFactory) {
        super(p_i231489_1_, p_i231489_2_, p_i231489_3_, p_i231489_4_, p_i231489_5_, p_i231489_6_, p_i231489_7_, p_i231489_8_, trackingRange, updateInterval, velocityUpdateSupplier, trackingRangeSupplier, updateIntervalSupplier, customClientFactory);
    }

    @Nonnull
    public T get()
    {
        T ret = this.value;
        ret.world.isRemote();
        return ret;
    }
    
}
