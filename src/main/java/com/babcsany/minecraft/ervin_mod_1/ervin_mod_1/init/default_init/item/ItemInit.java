package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.item;

import com.babcsany.minecraft.init.BlockItemInit;
import com.babcsany.minecraft.init.lc.block.LcBlockItemInit;
import com.babcsany.minecraft.init.special.PaintingItemInit;
import net.minecraft.item.Items;

public class ItemInit {

    public ItemInit(Items items) {
        register(items);
    }

    public void register(Items items) {
        com.babcsany.minecraft.init.ItemInit.ITEMS = items;
        PaintingItemInit.PAINTING_ITEMS = items;
        LcBlockItemInit.LC_BLOCK_ITEMS = items;
        BlockItemInit.BLOCK_ITEMS = items;
    }
}
