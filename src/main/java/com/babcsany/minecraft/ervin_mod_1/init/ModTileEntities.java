package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.tile_entity.LeatBlockCraftingTableTileEntity;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.types.Type;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;
import java.util.function.Supplier;

public class ModTileEntities {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final TileEntityType<LeatBlockCraftingTableTileEntity> LEAT_BLOCK_CRAFTING_TABLE = register("barrel", Builder.create(LeatBlockCraftingTableTileEntity::new, isBurnableBlockItemInit.LEAT_BLOCK_CRAFTING_TABLE.getBlock()));

    @Deprecated
    public static <T extends TileEntity> TileEntityType<T> register(String key, Builder<T> builder) {
        if (builder.blocks.isEmpty()) {
            LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", key);
        }

        Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, key);
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, key, builder.build(type));
    }

    public static final class Builder<T extends TileEntity> {
        private final Supplier<? extends T> factory;
        private final Set<Block> blocks;

        private Builder(Supplier<? extends T> factoryIn, Set<Block> validBlocks) {
            this.factory = factoryIn;
            this.blocks = validBlocks;
        }

        public static <T extends TileEntity> Builder<T> create(Supplier<? extends T> factoryIn, Block... validBlocks) {
            return new Builder<>(factoryIn, ImmutableSet.copyOf(validBlocks));
        }

        public TileEntityType<T> build(Type<?> datafixerType) {
            return new TileEntityType<>(this.factory, this.blocks, datafixerType);
        }
    }
}
