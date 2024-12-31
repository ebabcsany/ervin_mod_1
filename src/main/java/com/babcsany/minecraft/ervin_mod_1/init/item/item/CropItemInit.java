package com.babcsany.minecraft.ervin_mod_1.init.item.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class CropItemInit {
    private static final DeferredRegister<Item> CROPS = UnusedItemInit.ITEM_DEFERRED_REGISTER;

    public static final RegistryObject<Item> TARG = CROPS.register("targ", () -> new Item(new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS)));

    public static Item register(String name) {
        return register(name, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_ITEMS));
    }

    public static Item register(String name, Item.Properties properties) {
        return register(name, new Item(properties));
    }

    public static Item register(String name, Item itemIn) {
        return UnusedItems.registerDefault("crops/" + name, itemIn);
    }

    public static void register() {
        Ervin_mod_1.register(CropItemInit.class);
    }
}
