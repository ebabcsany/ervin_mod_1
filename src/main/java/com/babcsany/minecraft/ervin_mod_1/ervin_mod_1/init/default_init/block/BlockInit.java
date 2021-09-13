package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.block;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.block.blocks.LcBlocksInit;
import com.babcsany.minecraft.init.lc.block.LcBlockInit;
import net.minecraft.block.Blocks;

public class BlockInit {

    public BlockInit(Blocks blocks) {
        register(blocks);
    }

    public void register(Blocks blocks) {
        new LcBlocksInit(blocks);
        com.babcsany.minecraft.init.BlockInit.BLOCKS = blocks;
        LcBlockInit.LC_BLOCKS = blocks;
    }
}
