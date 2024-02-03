package com.babcsany.minecraft.ervin_mod_1.init.unused.l;

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

    public static final int registryObjectsCount = 2;
    private static final ArrayList<String> PATHS = new ArrayList<>(registryObjectsCount);
    private static final ArrayList<RegistryObject<Item>> REGISTRY_OBJECTS = registryObjects();

    private static ArrayList<RegistryObject<Item>> registryObjects() {
        ArrayList<RegistryObject<Item>> registryObjectArrayList = new ArrayList<>(registryObjectsCount);
        registryObjectArrayList.addAll(unusedBlockItemsPropertiesRegistryObjects("air", "tgruhuft"));
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
        return registryObject(name, () -> new BlockItem(UnusedBlockInit.get(name).get(), properties));
    }

    private static <T extends BlockItem> RegistryObject<Item> registryObject(String name, Supplier<T> supplier) {
        String path = path(name);
        PATHS.add(path);
        return BLOCK_ITEM_DEFERRED_REGISTER.register(path, supplier);
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

    public static RegistryObject<Item> get(int index) {
        return REGISTRY_OBJECTS.get(index);
    }
}
