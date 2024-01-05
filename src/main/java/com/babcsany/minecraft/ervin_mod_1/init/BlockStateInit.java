package com.babcsany.minecraft.ervin_mod_1.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

import java.util.function.Supplier;

public class BlockStateInit {
    public static Block block;
    public static Supplier<Block> blockSupplier;

    public static BlockState block(Block block) {
        final BlockState BLOCK_STATE = block.getDefaultState();
        return BLOCK_STATE;
    }

    public static BlockState blockSupplier(Supplier<Block> blockSupplier) {
        final BlockState SUPPLIER_BLOCK_STATE = blockSupplier.get().getDefaultState();
        return SUPPLIER_BLOCK_STATE;
    }
}
