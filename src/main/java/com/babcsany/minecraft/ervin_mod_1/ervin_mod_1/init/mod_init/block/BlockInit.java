package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.mod_init.block;

import com.babcsany.minecraft.ervin_mod_1.init.IMolaBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockItemInit_;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialBlockInit;
import net.minecraftforge.eventbus.api.IEventBus;

public class BlockInit {

    public BlockInit(IEventBus modEventBus) {
        register(modEventBus);
    }

    public IEventBus register(IEventBus modEventBus) {
        IMolaBlocks.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit.BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit.BURNABLE_BLOCKS.register(modEventBus);
        com.babcsany.minecraft.ervin_mod_1.init.block.animation.colors.BlockItemInit.ANIMATION_BLOCKS.register(modEventBus);
        MinecraftBlocks.BLOCKS.register(modEventBus);
        BlockItemInit_.BLOCK_ITEMS.register(modEventBus);
        SpecialBlockInit.SPECIAL_BLOCKS.register(modEventBus);
        return modEventBus;
    }
}
