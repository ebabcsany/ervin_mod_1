package com.babcsany.minecraft.tile_entity;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.function.Supplier;

public class ModTileEntityType<T extends TileEntity> extends TileEntityType<T> {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Supplier<? extends T> factory;
    private final Set<Block> validBlocks;
    private final Type<?> datafixerType;
    private ModTileEntityType<?> type;

    @Nullable
    public static ResourceLocation getId(ModTileEntityType<?> tileEntityTypeIn) {
        return Registry.BLOCK_ENTITY_TYPE.getKey(tileEntityTypeIn);
    }

    public static <T extends TileEntity> ModTileEntityType<T> register(String key, ModTileEntityType.Builder<T> builder) {
        if (builder.blocks.isEmpty()) {
            LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", string(key));
        }

        Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, string(key));
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, string(key), builder.build(type));
    }

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    public ModTileEntityType(Supplier<? extends T> factoryIn, Set<Block> validBlocksIn, Type<?> dataFixerType) {
        super(factoryIn, validBlocksIn, dataFixerType);
        this.factory = factoryIn;
        this.validBlocks = validBlocksIn;
        this.datafixerType = dataFixerType;
    }

    @Nullable
    public T create() {
        return this.factory.get();
    }

    public boolean isValidBlock(Block blockIn) {
        return this.validBlocks.contains(blockIn);
    }

    @Nullable
    public T getIfExists(IBlockReader blockReader, BlockPos pos) {
        TileEntity tileentity = blockReader.getTileEntity(pos);
        return (T)(tileentity != null && this.getType() == this ? tileentity : null);
    }

    public ModTileEntityType<?> getType() {
        return this.type;
    }

    public static class Builder<T extends TileEntity> {
        private final Supplier<? extends T> factory;
        private final Set<Block> blocks;

        private Builder(Supplier<? extends T> factoryIn, Set<Block> validBlocks) {
            this.factory = factoryIn;
            this.blocks = validBlocks;
        }

        public static <T extends TileEntity> Builder<T> create(Supplier<? extends T> factoryIn, Block... validBlocks) {
            return new Builder<>(factoryIn, ImmutableSet.copyOf(validBlocks));
        }

        public ModTileEntityType<T> build(Type<?> datafixerType) {
            return new ModTileEntityType<>(this.factory, this.blocks, datafixerType);
        }
    }
}
