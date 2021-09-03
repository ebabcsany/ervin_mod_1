package com.babcsany.minecraft.ervin_mod_1.init.block.item;

import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.block.burning.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import static com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit.BURNABLE_ITEMS;

public class isBurnableBlockItemInit_ {

    public static isBurnableBlockItemInit_ BURNING_BLOCK_ITEMS;

    public static final RegistryObject<Item> TRAGN = BURNABLE_ITEMS.register("tragn", () -> new Tragn(BlockInit.TRAGN.get(), (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRAGK_BLOCK = BURNABLE_ITEMS.register("tragk_block", () -> new TragkBlock(BlockInit.TRAGK_BLOCK.get(), (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRAGK_SLAB = BURNABLE_ITEMS.register("tragk_slab", () -> new TragkSlab(BlockInit.TRAGK_SLAB.get(), (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRAGK_STAIRS = BURNABLE_ITEMS.register("tragk_stairs", () -> new TragkStairs(BlockInit.TRAGK_STAIRS.get(), (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> GARK_BLOCK = BURNABLE_ITEMS.register("gark_block", () -> new GarkBlock(BlockInit.GARK_BLOCK.get(), (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> GARK_SLAB = BURNABLE_ITEMS.register("gark_slab", () -> new GarkSlab(BlockInit.GARK_SLAB.get(), (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> GARK_STAIRS = BURNABLE_ITEMS.register("gark_stairs", () -> new GarkStairs(BlockInit.GARK_STAIRS.get(), (new Item.Properties()).isBurnable()));
}
