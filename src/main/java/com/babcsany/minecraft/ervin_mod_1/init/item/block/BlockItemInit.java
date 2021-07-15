package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.init.FluidInit;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> ZUNK_SLAB = BLOCK_ITEMS.register("zunk_slab", () -> new BlockItem(BlockInit.ZUNK_SLAB.get(), (new Item.Properties())));
    public static final RegistryObject<Item> ZUNK_STAIRS = BLOCK_ITEMS.register("zunk_stairs", () -> new BlockItem(BlockInit.ZUNK_STAIRS.get(), (new Item.Properties())));
    public static final RegistryObject<Item> JURK = BLOCK_ITEMS.register("jurkf", () -> new BlockItem(com.babcsany.minecraft.init.BlockInit.JURK, (new Item.Properties())));
    public static final RegistryObject<Item> FIGHIV = BLOCK_ITEMS.register("fighiv", () -> new BlockItem(BlockInit.FIGHIV.get(), (new Item.Properties())));
    public static final RegistryObject<Item> BLACK_STRING = BLOCK_ITEMS.register("strings/black_string", () -> new BlockItem(BlockInit.BLACK_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> BLUE_STRING = BLOCK_ITEMS.register("strings/blue_string", () -> new BlockItem(BlockInit.BLUE_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> BROWN_STRING = BLOCK_ITEMS.register("strings/brown_string", () -> new BlockItem(BlockInit.BROWN_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> CYAN_STRING = BLOCK_ITEMS.register("strings/cyan_string", () -> new BlockItem(BlockInit.CYAN_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> GRAY_STRING = BLOCK_ITEMS.register("strings/gray_string", () -> new BlockItem(BlockInit.GRAY_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> GREEN_STRING = BLOCK_ITEMS.register("strings/green_string", () -> new BlockItem(BlockInit.GREEN_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> LIGHT_BLUE1_STRING = BLOCK_ITEMS.register("strings/light_blue1_string", () -> new BlockItem(BlockInit.LIGHT_BLUE1_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> LIGHT_BLUE_STRING = BLOCK_ITEMS.register("strings/light_blue_string", () -> new BlockItem(BlockInit.LIGHT_BLUE_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> LIGHT_GRAY_STRING = BLOCK_ITEMS.register("strings/light_gray_string", () -> new BlockItem(BlockInit.LIGHT_GRAY_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> LIME_STRING = BLOCK_ITEMS.register("strings/lime_string", () -> new BlockItem(BlockInit.LIME_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> MAGENTA_STRING = BLOCK_ITEMS.register("strings/magenta_string", () -> new BlockItem(BlockInit.MAGENTA_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> ORANGE_STRING = BLOCK_ITEMS.register("strings/orange_string", () -> new BlockItem(BlockInit.ORANGE_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> PINK_STRING = BLOCK_ITEMS.register("strings/pink_string", () -> new BlockItem(BlockInit.PINK_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> PURPLE_STRING = BLOCK_ITEMS.register("strings/purple_string", () -> new BlockItem(BlockInit.PURPLE_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> RED_STRING = BLOCK_ITEMS.register("strings/red_string", () -> new BlockItem(BlockInit.RED_TRIPWIRE.get(), (new Item.Properties())));
    public static final RegistryObject<Item> YELLOW_STRING = BLOCK_ITEMS.register("strings/yellow_string", () -> new BlockItem(BlockInit.YELLOW_TRIPWIRE.get(), (new Item.Properties())));
}
