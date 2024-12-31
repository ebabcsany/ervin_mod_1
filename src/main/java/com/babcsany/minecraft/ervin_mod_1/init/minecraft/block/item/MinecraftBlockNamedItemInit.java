package com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MinecraftBlockNamedItemInit {
    private static final DeferredRegister<Item> ITEMS = UnusedItemInit.ITEM_DEFERRED_REGISTER;

    public static final RegistryObject<Item> NETHER_PORTAL = ITEMS.register("nether_portal", () -> new BlockNamedItem(Blocks.NETHER_PORTAL, (new Item.Properties())));
    public static final RegistryObject<Item> END_PORTAL = ITEMS.register("end_portal", () -> new BlockNamedItem(Blocks.END_PORTAL, (new Item.Properties())));
    public static final RegistryObject<Item> END_GATEWAY = ITEMS.register("end_gateway", () -> new BlockNamedItem(Blocks.END_GATEWAY, (new Item.Properties())));
    public static final RegistryObject<Item> WATER = ITEMS.register("water", () -> new BlockNamedItem(Blocks.WATER, (new Item.Properties())));

    public static Item register(String name, Block blockIn) {
        return register(name, new BlockNamedItem(blockIn, (new Item.Properties())));
    }

    public static Item register(String name, Block blockIn, Item.Properties properties) {
        return register(name, new BlockNamedItem(blockIn, properties));
    }

    public static Item register(String name, BlockItem blockItem) {
        return UnusedItems.registerDefault(name, blockItem);
    }

    public static void register() {
        Ervin_mod_1.register(MinecraftBlockNamedItemInit.class);
    }
}
