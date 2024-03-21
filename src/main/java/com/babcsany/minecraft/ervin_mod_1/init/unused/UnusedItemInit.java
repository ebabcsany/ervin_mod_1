package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class UnusedItemInit {

    public static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final int REGISTRY_OBJECTS_COUNT = 2;
    public static RegistryObject<Item> LAST_ITEM;
    private static final ArrayList<String> PATHS = new ArrayList<>(REGISTRY_OBJECTS_COUNT);
    private static final ArrayList<RegistryObject<Item>> REGISTRY_OBJECTS = registryObjects();

    private static ArrayList<RegistryObject<Item>> registryObjects() {
        ArrayList<RegistryObject<Item>> registryObjectArrayList = new ArrayList<>(REGISTRY_OBJECTS_COUNT);
        registryObjectArrayList.addAll(unusedBlockItemsPropertiesRegistryObjects());
        return registryObjectArrayList;
    }

    private static Collection<RegistryObject<Item>> unusedBlockItemsPropertiesRegistryObjects(String... strings) {
        ArrayList<RegistryObject<Item>> list = new ArrayList<>();
        for (String name : strings) {
            list.add(unusedBlockItemPropertiesRegistryObject(name));
        }
        return list;
    }

    private static RegistryObject<Item> unusedBlockItemPropertiesRegistryObject(String name) {
        return unusedBlockItemRegistryObject(name, new Item.Properties());
    }

    private static RegistryObject<Item> unusedBlockItemRegistryObject(String name, Item.Properties properties) {
        return registryObject(name, () -> new Item(properties));
    }

    private static <T extends Item> RegistryObject<Item> register(String name, Supplier<T> supplier) {
        return registryObject(name, supplier);
    }

    private static <T extends Item> RegistryObject<Item> registryObject(String name, Supplier<T> supplier) {
        return registryObject(ITEM_DEFERRED_REGISTER, name, supplier);
    }

    public static <T extends Item> RegistryObject<Item> registryObject(DeferredRegister<Item> deferredRegister, String name, Supplier<T> supplier) {
        String path = path(name);
        PATHS.add(path);
        return LAST_ITEM = deferredRegister.register(path, supplier);
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    @Deprecated
    public static Item getItem(String name) {
        return get(name).get();
    }

    public static RegistryObject<Item> get(String name) {
        int index = PATHS.indexOf(path(name));
        return get(index);
    }

    public static RegistryObject<Item> getLast() {
        return LAST_ITEM;
    }

    public static RegistryObject<Item> get(int index) {
        return REGISTRY_OBJECTS.get(index);
    }

    public static Item getLastItem() {
        return getLast().get();
    }
}
