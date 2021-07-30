package com.babcsany.minecraft.ervin_mod_1.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

public class ModBlock_T<T> extends Block {
    public ModBlock_T(AbstractBlock.Properties properties, AbstractModBlock.Properties modProperties) {
        super(properties);
    }
}
