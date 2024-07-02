package com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.BurningBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class MinecraftBlockItems {
    public static final BlockItem COAL_STAIRS = (BlockItem) UnusedItems.registerDefault("coal_stairs", new BurningBlockItem(MinecraftBlocks.COAL_STAIRS, (new Item.Properties()), 12000));

    public static void register() {
        Ervin_mod_1.register(MinecraftBlockItems.class);
    }
}
