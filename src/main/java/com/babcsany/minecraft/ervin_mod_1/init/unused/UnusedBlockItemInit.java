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

public class UnusedBlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEM_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final int REGISTRY_OBJECTS_COUNT = 2;
    public static RegistryObject<BlockItem> LAST_BLOCK_ITEM;
    private static final ArrayList<String> PATHS = new ArrayList<>(REGISTRY_OBJECTS_COUNT);
    private static final ArrayList<RegistryObject<BlockItem>> REGISTRY_OBJECTS = registryObjects();

    private static ArrayList<RegistryObject<BlockItem>> registryObjects() {
        ArrayList<RegistryObject<BlockItem>> registryObjectArrayList = new ArrayList<>(REGISTRY_OBJECTS_COUNT);
        registryObjectArrayList.addAll(unusedBlockItemsPropertiesRegistryObjects("air", "tgruhuft"));
        return registryObjectArrayList;
    }

    private static Collection<RegistryObject<BlockItem>> unusedBlockItemsPropertiesRegistryObjects(String... strings) {
        ArrayList<RegistryObject<BlockItem>> list = new ArrayList<>();
        for (String name : strings) {
            list.add(unusedBlockItemPropertiesRegistryObject(name));
        }
        return list;
    }

    private static RegistryObject<BlockItem> unusedBlockItemPropertiesRegistryObject(String name) {
        return unusedBlockItemRegistryObject(name, new Item.Properties());
    }

    private static RegistryObject<BlockItem> unusedBlockItemRegistryObject(String name, Item.Properties properties) {
        return registryObject(name, () -> new BlockItem(UnusedBlockInit.get(name).get(), properties));
    }

    private static <T extends BlockItem> RegistryObject<BlockItem> register(String name, Supplier<T> supplier) {
        return registryObject(name, supplier);
    }

    private static <T extends BlockItem> RegistryObject<BlockItem> registryObject(String name, Supplier<T> supplier) {
        return registryObject(BLOCK_ITEM_DEFERRED_REGISTER, name, supplier);
    }

    public static <T extends BlockItem> RegistryObject<BlockItem> registryObject(DeferredRegister<Item> deferredRegister, String name, Supplier<T> supplier) {
        String path = path(name);
        PATHS.add(path);
        return LAST_BLOCK_ITEM = deferredRegister.register(path, supplier);
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    @Deprecated
    public static BlockItem getBlockItem(String name) {
        return get(name).get();
    }

    public static RegistryObject<BlockItem> get(String name) {
        int index = PATHS.indexOf(path(name));
        return get(index);
    }

    public static RegistryObject<BlockItem> getLast() {
        return LAST_BLOCK_ITEM;
    }

    public static RegistryObject<BlockItem> get(int index) {
        return REGISTRY_OBJECTS.get(index);
    }

    public static BlockItem getLastBlockItem() {
        return getLast().get();
    }
}
