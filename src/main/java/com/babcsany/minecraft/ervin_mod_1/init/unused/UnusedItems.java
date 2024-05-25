package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Collection;

public class UnusedItems {
    private static Item LAST_ITEM;
    private static final ArrayList<String> ITEM_PATHS = new ArrayList<>();
    private static final ArrayList<Item> ITEMS = new ArrayList<>();

    private static Collection<Item> unusedItemsPropertiesDefault(String... strings) {
        ArrayList<Item> list = new ArrayList<>();
        for (String name : strings) {
            list.add(unusedItemPropertiesDefault(name));
        }
        return list;
    }

    private static Collection<Item> unusedItemsProperties(String... strings) {
        ArrayList<Item> list = new ArrayList<>();
        for (String name : strings) {
            list.add(unusedItemProperties(name));
        }
        return list;
    }

    private static Item unusedItemPropertiesDefault(String name) {
        return unusedItem(name, propertiesDefault());
    }

    private static Item unusedItemProperties(String name) {
        return unusedItem(name, new Item.Properties());
    }

    public static Item unusedItem(String name, Item.Properties properties) {
        return registerUnused(name, new Item(properties));
    }

    public static <T extends Item> Item registerUnused(String name, T item) {
        return register(path(name), item);
    }

    public static <T extends Item> Item registerDefault(String path, T item) {
        return register(path, item);
    }

    public static Item.Properties propertiesDefault() {
        return properties(ItemGroup.SEARCH);
    }

    public static Item register(String key) {
        return register(key, new Item(new Item.Properties()));
    }

    public static Item register(String key, ItemGroup groupIn) {
        return register(key, new Item(properties(groupIn)));
    }

    public static Item.Properties properties(ItemGroup groupIn) {
        return new Item.Properties().group(groupIn);
    }

    public static <T extends Item> Item register(String key, T itemIn) {
        addDefault(key, itemIn);
        return register(Ervin_mod_1.getKey(key), itemIn);
    }

    public static Item register(ResourceLocation key, Item itemIn) {
        if (itemIn instanceof BlockItem) {
            ((BlockItem)itemIn).addToBlockToItemMap(Item.BLOCK_TO_ITEM, itemIn);
        }

        return Registry.register(registry(), key, itemIn);
    }

    @Deprecated
    public static DefaultedRegistry<Item> registry() {
        return Registry.ITEM;
    }

    public static Item add(String name) {
        return addDefault(path(name));
    }

    public static Item addDefault(String path) {
        return addDefault(path, new Item.Properties());
    }

    public static Item addDefault(String path, Item.Properties properties) {
        return addDefault(path, new Item(properties));
    }

    public static Item addDefault(String path, Item item) {
        ITEMS.add(item);
        ITEM_PATHS.add(path);
        return LAST_ITEM = item;
    }

    public static Item get(String name) {
        return getDefault(path(name));
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    public static Item getDefault(String path) {
        int index = ITEM_PATHS.indexOf(path);
        return get(index);
    }

    public static Item get(int index) {
        return ITEMS.get(index);
    }

    public static Item getLast() {
        return LAST_ITEM;
    }

    public static void register() {
        Ervin_mod_1.register(UnusedItems.class);
    }

    static {
        Collection<Item> values = unusedItemsProperties("thunm");
        values.size();
    }
}
