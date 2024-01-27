package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class UnusedItemInit {

    public static final DeferredRegister<Item> ITEM_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);
    private static final ArrayList<RegistryObject<Item>> UNUSED_ITEMS = new ArrayList<>();
    private static RegistryObject<Item> LAST_ITEM;
    private static ArrayList<String> UNUSED_ITEMS_PATHS = new ArrayList<>();
}
