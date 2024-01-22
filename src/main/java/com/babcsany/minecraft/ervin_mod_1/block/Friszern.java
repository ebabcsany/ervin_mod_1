package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ContainerBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.Random;

public class Friszern extends ContainerBlock {
    public int O() {
        return Blocks.AIR.getHarvestLevel(Blocks.AIR.getDefaultState());
    }

    protected Friszern(Properties p_i48446_1_) {
        super(p_i48446_1_);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader iBlockReader) {
        return super.createTileEntity(this.getDefaultState(), iBlockReader);
    }
}
