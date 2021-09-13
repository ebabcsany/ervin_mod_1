package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.block.blocks;

import com.babcsany.minecraft.init.lc.block.blocks.H_u_fBlockInit;
import net.minecraft.block.Blocks;

public class LcBlocksInit {

    public LcBlocksInit(Blocks blocks) {
        register(blocks);
    }

    public void register(Blocks blocks) {
        H_u_fBlockInit.H_U_F_BLOCKS = blocks;
    }
}
