package com.babcsany.minecraft.ervin_mod_1.init.block.item;

import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.BurningBlockItem;
import net.minecraft.item.Item;

public class isBurnableBlockItemInit_ {

    public static final Item TRAGN = register("tragn", new BurningBlockItem(isBurnableBlockItemInit.TRAGN, (new Item.Properties()).isImmuneToFire(), (int) 15305500800000000L));
    public static final Item TRAGK_BLOCK = register("tragk_block", new BurningBlockItem(isBurnableBlockItemInit.TRAGK_BLOCK, (new Item.Properties()).isImmuneToFire(), (int) 24488801280000L));
    public static final Item TRAGK_SLAB = register("tragk_slab", new BurningBlockItem(isBurnableBlockItemInit.TRAGK_SLAB, (new Item.Properties()).isImmuneToFire(), (int) 12244400640000L));
    public static final Item TRAGK_STAIRS = register("tragk_stairs", new BurningBlockItem(isBurnableBlockItemInit.TRAGK_STAIRS, (new Item.Properties()).isImmuneToFire(), (int) 18366600960000L));
    public static final Item GARK_BLOCK = register("gark_block", new BurningBlockItem(isBurnableBlockItemInit.GARK_BLOCK, (new Item.Properties()).isImmuneToFire(),131220000));
    public static final Item GARK_SLAB = register("gark_slab", new BurningBlockItem(isBurnableBlockItemInit.GARK_SLAB, (new Item.Properties()).isImmuneToFire(),65610000));
    public static final Item GARK_STAIRS = register("gark_stairs", new BurningBlockItem(isBurnableBlockItemInit.GARK_STAIRS, (new Item.Properties()).isImmuneToFire(),98415000));

    public static Item register(String name, Item item) {
        return UnusedItems.registerDefault(name, item);
    }
}
