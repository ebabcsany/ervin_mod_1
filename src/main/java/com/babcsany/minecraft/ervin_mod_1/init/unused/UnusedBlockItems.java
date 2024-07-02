package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ToolTypeInit;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
    private static ArrayList<BlockItem> BLOCK_ITEMS = new ArrayList<>();

    public static Collection<Item> unusedBlockItemsProperties(String... strings) {
        ArrayList<Item> list = new ArrayList<>();
        for (String name : strings) {
            list.add(unusedBlockItemProperties(name));
        }
        return list;
    }

    private static Item unusedBlockItemProperties(String name) {
        return registerDefault(name, UnusedBlocks.get(name), new Item.Properties());
    }

    private static Item unusedBlockItemProperties(Block blockIn) {
        return unusedBlockItem(getPath(blockIn), new Item.Properties());
    }

    private static Item unusedBlockNamedItemProperties(String name, String blockName) {
        return unusedBlockNamedItem(name, blockName, new Item.Properties());
    }

    private static Item unusedBlockItem(String name, Item.Properties properties) {
        return registerDefault(name, UnusedBlocks.get(name), properties);
    }

    private static Item unusedBlockNamedItem(String name, String blockName, Item.Properties properties) {
        return registerBlockNamedItem(name, UnusedBlocks.get(blockName), properties);
    }

    private static Item unusedBlockNamedItem(String name, Block blockIn) {
        return registerBlockNamedItem(name, blockIn, new Item.Properties());
    }

    private static Item registerBlockItem(Block blockIn, Item.Properties properties) {
        return registerDefault(getPath(blockIn), blockIn, properties);
    }

    private static Item registerBlockNamedItem(String name, Block blockIn, Item.Properties properties) {
        return registerUnused(name, new BlockNamedItem(blockIn, properties));
    }

    private static <T extends BlockItem> Item registerUnused(String name, T blockItem) {
        return registerDefault(path(name), blockItem);
    }

    private static Item registerUnused(String name, Block blockIn, Item.Properties properties) {
        return registerDefault(path(name), blockIn, properties);
    }

    public static Item registerDefault(String name, Block blockIn) {
        return registerDefault(name, blockIn, new Item.Properties());
    }

    private static Item registerDefault(Block blockIn) {
        return register(blockIn, ItemGroup.SEARCH);
    }

    private static Item register(Block blockIn) {
        return register(new BlockItem(blockIn, new Item.Properties()));
    }

    private static Item register(Block blockIn, ItemGroup groupIn) {
        return register(new BlockItem(blockIn, UnusedItems.properties(groupIn)));
    }

    private static Item register(BlockItem blockItemIn) {
        return registerDefault(blockItemIn.getBlock(), blockItemIn);
    }

    public static Item registerDefault(String path, Block blockIn, Item.Properties properties) {
        BlockItem blockItem = new BlockItem(blockIn, properties);
        boolean notContains = !BLOCK_ITEM_PATHS.contains(path) && !BLOCK_ITEMS.contains(blockItem);
        UnusedBlocks.registerDefault(path, blockIn);
        UnusedItems.register(path, blockItem);
        if (notContains) {
            addDefault(blockIn);
        }
        return blockItem;
    }

    private static <T extends BlockItem> Item registerDefault(Block blockIn, T blockItemIn) {
        ResourceLocation key = getKey(blockIn);
        boolean notContains = !BLOCK_ITEM_PATHS.contains(key.getPath()) && !BLOCK_ITEMS.contains(blockItemIn);
        UnusedBlocks.registerDefault(key, blockIn);
        UnusedItems.register(key, blockItemIn);
        if (notContains) {
            addDefault(blockIn);
        }
        return blockItemIn;
    }

    public static <T extends BlockItem> T registerDefault(String path, T blockItemIn) {
        boolean notContains = !BLOCK_ITEM_PATHS.contains(path) && !BLOCK_ITEMS.contains(blockItemIn);
        UnusedBlocks.registerDefault(path, blockItemIn.getBlock());
        UnusedItems.register(path, blockItemIn);
        if (notContains) {
            addDefault(blockItemIn.getBlock());
        }
        return blockItemIn;
    }

    private static BlockItem add(String name) {
        return addDefault(path(name));
    }

    private static BlockItem add(Block blockIn) {
        return addDefault(getPath(blockIn), blockIn);
    }

    private static BlockItem add(String name, String blockName) {
        return addDefault(path(name), UnusedBlocks.get(blockName));
    }

    private static BlockItem addDefault(String path) {
        return addDefault(path, path);
    }

    private static BlockItem addDefault(Block blockIn) {
        return addDefault(getPath(blockIn), blockIn);
    }

    private static String getPath(Block blockIn) {
        return getKey(blockIn).getPath();
    }

    @Deprecated
    private static ResourceLocation getKey(Block blockIn) {
        return Registry.BLOCK.getKey(blockIn);
    }

    private static BlockItem addDefault(String path, String blockPath) {
        return addDefault(path, UnusedBlocks.getDefault(blockPath));
    }

    private static BlockItem addDefault(String path, Block blockIn) {
        return addDefault(path, blockIn, new Item.Properties());
    }

    private static BlockItem addDefault(String path, Block blockIn, Item.Properties properties) {
        return addDefault(path, new BlockItem(blockIn, properties));
    }

    private static <T extends BlockItem> T addDefault(String path, T blockItem) {
        if (!BLOCK_ITEM_PATHS.contains(path) && !BLOCK_ITEMS.contains(blockItem)) {
            BLOCK_ITEMS.add(blockItem);
            addPath(path);
            LAST_BLOCK_ITEM = blockItem;
        }
        return blockItem;
    }

    public static BlockItem get(String name) {
        return getDefault(path(name));
    }

    private static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    private static void addPath(String path) {
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
        registerUnused("air", new Block(Block.Properties.create(Material.AIR).doesNotBlockMovement().noDrops()), new Item.Properties().isImmuneToFire());
        registerUnused("tgruhuft", UnusedBlocks.setBlockRequiresTool(Material.CAKE, 4, 12354, 15365, ToolTypeInit.PHISK, SoundType.CHAIN), new Item.Properties().isImmuneToFire());
    }
}
