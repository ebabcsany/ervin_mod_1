package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
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
    private static BlockItem LAST_BLOCK_ITEM;
    private static final ArrayList<String> BLOCK_ITEM_PATHS = new ArrayList<>();
    private static final ArrayList<BlockItem> BLOCK_ITEMS = new ArrayList<>();

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
        return registerDefault(getPath(blockIn), blockIn, properties);
    }

    private static Item registerBlockNamedItem(String name, Block blockIn, Item.Properties properties) {
        return registerUnused(name, new BlockNamedItem(blockIn, properties));
    }

    public static <T extends BlockItem> Item registerUnused(String name, T blockItem) {
        return registerDefault(path(name), blockItem);
    }

    public static Item registerDefault(String name, Block blockIn) {
        return registerDefault(name, blockIn, new Item.Properties());
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
        return registerDefault(blockItemIn.getBlock(), blockItemIn);
    }

    public static Item registerDefault(String path, Block blockIn, Item.Properties properties) {
        BlockItem blockItem = new BlockItem(blockIn, properties);
        UnusedBlocks.registerDefault(path, blockIn);
        return UnusedItems.register(path, blockItem);
    }

    public static <T extends BlockItem> Item registerDefault(Block blockIn, T itemIn) {
        ResourceLocation key = getKey(blockIn);
        UnusedBlocks.registerDefault(key, blockIn);
        addDefault(blockIn);
        return UnusedItems.register(key, itemIn);
    }

    public static <T extends BlockItem> Item registerDefault(String path, T blockItem) {
        UnusedBlocks.registerDefault(path, blockItem.getBlock());
        addDefault(blockItem.getBlock());
        return UnusedItems.register(path, blockItem);
    }

    public static BlockItem add(String name) {
        return addDefault(path(name));
    }

    public static BlockItem add(Block blockIn) {
        return addDefault(getPath(blockIn), blockIn);
    }

    public static BlockItem add(String name, String blockName) {
        return addDefault(path(name), UnusedBlocks.get(blockName));
    }

    public static BlockItem addDefault(String path) {
        return addDefault(path, path);
    }

    public static BlockItem addDefault(Block blockIn) {
        return addDefault(getPath(blockIn), blockIn);
    }

    public static String getPath(Block blockIn) {
        return getKey(blockIn).getPath();
    }

    @Deprecated
    public static ResourceLocation getKey(Block blockIn) {
        return Registry.BLOCK.getKey(blockIn);
    }

    public static BlockItem addDefault(String path, String blockPath) {
        return addDefault(path, UnusedBlocks.getDefault(blockPath));
    }

    public static BlockItem addDefault(String path, Block blockIn) {
        return addDefault(path, blockIn, new Item.Properties());
    }

    public static BlockItem addDefault(String path, Block blockIn, Item.Properties properties) {
        return addDefault(path, new BlockItem(blockIn, properties));
    }

    public static <T extends BlockItem> T addDefault(String path, T blockItem) {
        UnusedBlocks.addDefault(path, blockItem.getBlock());
        UnusedItems.addDefault(path, blockItem);
        BLOCK_ITEMS.add(blockItem);
        addPath(path);
        LAST_BLOCK_ITEM = blockItem;
        return blockItem;
    }

    public static BlockItem get(String name) {
        return getDefault(path(name));
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    public static void addPath(String path) {
        UnusedBlocks.addPath(path);
        UnusedItems.addPath(path);
        if (!BLOCK_ITEM_PATHS.contains(path)) {
            BLOCK_ITEM_PATHS.add(path);
        }
    }

    public static BlockItem getDefault(String path) {
        int index = BLOCK_ITEM_PATHS.indexOf(path);
        return get(index);
    }

    public static BlockItem get(int index) {
        return BLOCK_ITEMS.get(index);
    }

    public static BlockItem getLast() {
        return LAST_BLOCK_ITEM;
    }

    public static void register() {
        Ervin_mod_1.register(UnusedBlockItems.class);
    }

    static {
        Collection<Item> values = unusedBlockItemsProperties("air", "tgruhuft");
        values.size();
    }
}
