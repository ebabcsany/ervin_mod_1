package com.babcsany.minecraft.ervin_mod_1.init.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class $ItemInit {
    public static final DeferredRegister<Item> $ = UnusedItemInit.ITEM_DEFERRED_REGISTER;

    public static final RegistryObject<Item> $_1$ = $.register("1", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> $_2$ = $.register("2", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> $_3$ = $.register("3", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> $_4$ = $.register("4", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> $_5$ = $.register("5", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> $_6$ = $.register("6", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> $_7$ = $.register("7", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> $_8$ = $.register("8", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> $_9$ = $.register("9", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));
    public static final RegistryObject<Item> $_10$ = $.register("10", () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));

    public static Item registerDefault(String name) {
        return UnusedItems.registerDefault("usd/" + name, new Item.Properties().isImmuneToFire().group(ModItemGroup.ERVIN_MOD_1_ITEMS));
    }

    public static void register() {
        Ervin_mod_1.register($ItemInit.class);
    }
}
