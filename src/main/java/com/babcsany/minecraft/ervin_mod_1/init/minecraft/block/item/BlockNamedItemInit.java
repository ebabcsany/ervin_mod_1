package com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockNamedItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> NETHER_PORTAL = BLOCK_ITEMS.register("minecraft/nether_portal", () -> new BlockNamedItem(Blocks.NETHER_PORTAL, (new Item.Properties())));
    public static final RegistryObject<Item> END_PORTAL = BLOCK_ITEMS.register("minecraft/end_portal", () -> new BlockNamedItem(Blocks.END_PORTAL, (new Item.Properties())));
    public static final RegistryObject<Item> END_GATEWAY = BLOCK_ITEMS.register("minecraft/end_gateway", () -> new BlockNamedItem(Blocks.END_GATEWAY, (new Item.Properties())));
}
