package com.babcsany.minecraft.init;

import com.babcsany.minecraft.tile_entity.ModTileEntityType;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import java.util.function.Supplier;

public class TileEntityInit<T extends TileEntity> {

    public static TileEntityInit<?> TILE_ENTITIES;
}
