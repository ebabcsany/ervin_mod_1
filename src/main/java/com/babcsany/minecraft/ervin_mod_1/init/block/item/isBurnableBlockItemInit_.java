package com.babcsany.minecraft.ervin_mod_1.init.block.item;

import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.BurningBlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import static com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit.BURNABLE_ITEMS;

public class isBurnableBlockItemInit_ {

    public static final RegistryObject<Item> TRAGN = BURNABLE_ITEMS.register("tragn", () -> new BurningBlockItem(isBurnableBlockItemInit.TRAGN.get(), (new Item.Properties()).isBurnable(), (int) 15305500800000000L));
    public static final RegistryObject<Item> TRAGK_BLOCK = BURNABLE_ITEMS.register("tragk_block", () -> new BurningBlockItem(isBurnableBlockItemInit.TRAGK_BLOCK.get(), (new Item.Properties()).isBurnable(), (int) 24488801280000L));
    public static final RegistryObject<Item> TRAGK_SLAB = BURNABLE_ITEMS.register("tragk_slab", () -> new BurningBlockItem(isBurnableBlockItemInit.TRAGK_SLAB.get(), (new Item.Properties()).isBurnable(), (int) 12244400640000L));
    public static final RegistryObject<Item> TRAGK_STAIRS = BURNABLE_ITEMS.register("tragk_stairs", () -> new BurningBlockItem(isBurnableBlockItemInit.TRAGK_STAIRS.get(), (new Item.Properties()).isBurnable(), (int) 18366600960000L));
    public static final RegistryObject<Item> GARK_BLOCK = BURNABLE_ITEMS.register("gark_block", () -> new BurningBlockItem(isBurnableBlockItemInit.GARK_BLOCK.get(), (new Item.Properties()).isBurnable(),131220000));
    public static final RegistryObject<Item> GARK_SLAB = BURNABLE_ITEMS.register("gark_slab", () -> new BurningBlockItem(isBurnableBlockItemInit.GARK_SLAB.get(), (new Item.Properties()).isBurnable(),65610000));
    public static final RegistryObject<Item> GARK_STAIRS = BURNABLE_ITEMS.register("gark_stairs", () -> new BurningBlockItem(isBurnableBlockItemInit.GARK_STAIRS.get(), (new Item.Properties()).isBurnable(),98415000));
}
