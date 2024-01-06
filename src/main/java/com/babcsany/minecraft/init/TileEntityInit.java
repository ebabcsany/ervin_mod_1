package com.babcsany.minecraft.init;

import com.babcsany.minecraft.tile_entity.ModTileEntityType;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import java.util.function.Supplier;

public class TileEntityInit<T extends TileEntity> {

    public static TileEntityInit<?> TILE_ENTITIES;

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    public static <T extends TileEntity> Block[] validBlocks(Block... validBlocks) {
        return validBlocks;
    }

    private static native <G extends TileEntity> ModTileEntityType<G> builder(Supplier<? extends G> factoryIn);

    private static <T extends TileEntity> Supplier<? extends T> supplier(Supplier<? extends T> supplier) {
        return supplier;
    }
}
