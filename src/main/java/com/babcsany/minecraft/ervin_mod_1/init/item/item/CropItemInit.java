package com.babcsany.minecraft.ervin_mod_1.init.item.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.item.Item;

public class CropItemInit {
    public static final Item TARG = register("targ");

    public static Item register(String name) {
        return register(name, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS));
    }

    public static Item register(String name, Item.Properties properties) {
        return register(name, new Item(properties));
    }

    public static Item register(String name, Item itemIn) {
        return UnusedItems.addDefault("seeds/" + name, itemIn);
    }

    public static void register() {
        Ervin_mod_1.register(CropItemInit.class);
    }
}
