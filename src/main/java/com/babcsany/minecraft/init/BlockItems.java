package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.BurningBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<BlockItem> JURKF = ITEMS.register("jurkf", () -> new BlockItem(BlockInit.FIRT_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<BlockItem> FIRG_PLANKS = ITEMS.register("firg_planks", () -> new BlockItem(BlockInit.FIRG_PLANKS.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> FIRG_PLANKS_STAIRS = ITEMS.register("firg_planks_stairs", () -> new BlockItem(BlockInit.FIRG_PLANKS_STAIRS.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> FIRG_PLANKS_DOOR = ITEMS.register("firg_planks_door", () -> new BlockItem(BlockInit.FIRG_PLANKS_DOOR.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> FIRT_BLOCK = ITEMS.register("firt_block", () -> new BurningBlockItem(BlockInit.FIRT_BLOCK.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS), 21600));
    public static final RegistryObject<BlockItem> TRIRIJ = ITEMS.register("tririj", () -> new BlockItem(BlockInit.TRIRIJ.get(), (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<BlockItem> REUTRIEN = ITEMS.register("reutrien", () -> new BlockItem(BlockInit.REUTRIEN.get(), (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS)));

    public static RegistryObject<BlockItem> register(String name, Block blockIn) {
        return UnusedBlockItemInit.registryObject(ITEMS, name, () -> new BlockItem(blockIn, (new Item.Properties())));
    }

    public static RegistryObject<BlockItem> register(String name, Block blockIn, ItemGroup group) {
        Item.Properties properties = (new Item.Properties()).group(group);
        return UnusedBlockItemInit.registryObject(ITEMS, name, () -> new BlockItem(blockIn, properties));
    }

    public static RegistryObject<BlockItem> register(String name, Block blockIn, Item.Properties properties) {
        return UnusedBlockItemInit.registryObject(ITEMS, name, () -> new BlockItem(blockIn, properties));
    }

    public static RegistryObject<BlockItem> register(String name, BlockItem item) {
        return UnusedBlockItemInit.registryObject(ITEMS, name, () -> item);
    }
}
