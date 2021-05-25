package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> ZUNK_SLAB = BLOCK_ITEMS.register("zunk_slab", () -> new BlockItem(BlockInit.ZUNK_SLAB.get(), (new Item.Properties())));
    public static final RegistryObject<Item> ZUNK_STAIRS = BLOCK_ITEMS.register("zunk_stairs", () -> new BlockItem(BlockInit.ZUNK_STAIRS.get(), (new Item.Properties())));
    public static final RegistryObject<Item> JURK = BLOCK_ITEMS.register("jurk", () -> new BlockItem(BlockInit.JURK.get(), (new Item.Properties())));
    public static final RegistryObject<Item> FIGHIV = BLOCK_ITEMS.register("fighiv", () -> new BlockItem(BlockInit.FIGHIV.get(), (new Item.Properties())));
    public static final RegistryObject<Item> BLACK_STRING = BLOCK_ITEMS.register("tripwires/black_string", () -> new BlockItem(BlockInit.BLACK_TRIPWIRE.get(), (new Item.Properties())));
}
