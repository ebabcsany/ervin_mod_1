package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.init.BlockInit;
import net.minecraft.block.Blocks;

public class FireBlock extends net.minecraft.block.FireBlock {
    public FireBlock(Properties builder) {
        super(builder);
    }

    public static void init() {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
    }
}
