package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Collection;

public class UnusedBlockItems {
    public static Item LAST_BLOCK_ITEM;
    private static final ArrayList<String> BLOCK_ITEM_PATHS = new ArrayList<>();
    private static final ArrayList<Item> BLOCK_ITEMS = new ArrayList<>();

    public static Collection<Item> unusedBlockItemsProperties(String... strings) {
        ArrayList<Item> list = new ArrayList<>();
        for (String name : strings) {
            list.add(unusedBlockItemProperties(name));
        }
        return list;
    }

    private static Item unusedBlockItemProperties(String name) {
        return unusedBlockItem(name, new Item.Properties());
    }

    private static Item unusedBlockItemProperties(Block blockIn) {
        return unusedBlockItem(getPath(blockIn), new Item.Properties());
    }

    private static Item unusedBlockNamedItemProperties(String name, String blockName) {
        return unusedBlockNamedItem(name, blockName, new Item.Properties());
    }

    private static Item unusedBlockItem(String name, Item.Properties properties) {
        return registerBlockItem(UnusedBlocks.get(name), properties);
    }

    private static Item unusedBlockNamedItem(String name, String blockName, Item.Properties properties) {
        return registerBlockNamedItem(name, UnusedBlocks.get(blockName), properties);
    }

    public static Item unusedBlockNamedItem(String name, Block blockIn) {
        return registerBlockNamedItem(name, blockIn, new Item.Properties());
    }

    private static Item registerBlockItem(Block blockIn, Item.Properties properties) {
        return registerDefault(getPath(blockIn), register(blockIn, new Item(properties)));
    }

    private static Item registerBlockNamedItem(String name, Block blockIn, Item.Properties properties) {
        return registerDefault(name, new BlockNamedItem(blockIn, properties));
    }

    private static <T extends Item> Item registerDefault(String name, T blockItem) {
        return addDefault(path(name), blockItem);
    }

    public static Item registerDefault(Block blockIn) {
        return register(blockIn, ItemGroup.SEARCH);
    }

    public static Item register(Block blockIn) {
        return register(new BlockItem(blockIn, new Item.Properties()));
    }

    public static Item register(Block blockIn, ItemGroup groupIn) {
        return register(new BlockItem(blockIn, UnusedItems.properties(groupIn)));
    }

    public static Item register(BlockItem blockItemIn) {
        return register(blockItemIn.getBlock(), blockItemIn);
    }

    public static Item register(Block blockIn, Item itemIn) {
        return UnusedItems.register(getKey(blockIn), itemIn);
    }

    @Deprecated
    public static ResourceLocation getKey(Block blockIn) {
        return Registry.BLOCK.getKey(blockIn);
    }

    public static Item add(String name) {
        return addDefault(path(name));
    }

    public static Item add(Block blockIn) {
        return addDefault(getPath(blockIn), blockIn);
    }

    public static Item add(String name, String blockName) {
        return addDefault(path(name), UnusedBlocks.get(blockName));
    }

    public static Item addDefault(String path) {
        return addDefault(path, path);
    }

    public static Item addDefault(Block blockIn) {
        return addDefault(getPath(blockIn), blockIn);
    }

    public static String getPath(Block blockIn) {
        return getKey(blockIn).getPath();
    }

    public static Item addDefault(String path, String blockPath) {
        return addDefault(path, UnusedBlocks.getDefault(blockPath));
    }

    public static Item addDefault(String path, Block blockIn) {
        return addDefault(path, blockIn, new Item.Properties());
    }

    public static Item addDefault(String path, Block blockIn, Item.Properties properties) {
        return addDefault(path, new BlockItem(blockIn, properties));
    }

    public static Item addDefault(String path, Item blockItem) {
        BLOCK_ITEMS.add(blockItem);
        BLOCK_ITEM_PATHS.add(path);
        LAST_BLOCK_ITEM = blockItem;
        return UnusedItems.addDefault(path, blockItem);
    }

    public static Item get(String name) {
        return getDefault(path(name));
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    public static Item getDefault(String path) {
        int index = BLOCK_ITEM_PATHS.indexOf(path);
        return get(index);
    }

    public static Item get(int index) {
        return BLOCK_ITEMS.get(index);
    }

    public static Item getLast() {
        return LAST_BLOCK_ITEM;
    }

    public static void register() {
        Ervin_mod_1.register(UnusedBlockItems.class);
    }

    static {
        Collection<Item> values = unusedBlockItemsProperties("air", "tgruhuft");
    }
}
