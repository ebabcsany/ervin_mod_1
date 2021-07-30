package com.babcsany.minecraft.block;

import com.babcsany.minecraft.ervin_mod_1.block.AbstractModBlock;
import net.minecraft.block.Block;

public class ModBlock_1<T> extends Block {
    static Properties properties;
    public ModBlock_1(AbstractModBlock.Properties modProperties) {
        super(properties);
    }

    public T t;
}
