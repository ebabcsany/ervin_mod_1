package com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MinecraftBlockNamedItemInit {
    public static final Item NETHER_PORTAL = register("nether_portal", Blocks.NETHER_PORTAL);
    public static final Item END_PORTAL = register("end_portal", Blocks.END_PORTAL);
    public static final Item END_GATEWAY = register("end_gateway", Blocks.END_GATEWAY);
    public static final Item WATER = register("water", Blocks.WATER);

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
