package com.babcsany.minecraft.ervin_mod_1.init.item.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.ModFoodInit;
import com.babcsany.minecraft.ervin_mod_1.item.item.Item_1;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public final com.babcsany.minecraft.ervin_mod_1.item.item.Item moditem;
    public static final RegistryObject<Item> REGDEMP = ITEMS.register("regdemp", () -> new Item_1((new Item.Properties()),(new com.babcsany.minecraft.ervin_mod_1.item.item.Item.Properties().modFood(ModFoodInit.REGDEMP))));

    public ItemInit(com.babcsany.minecraft.ervin_mod_1.item.item.Item item) {
        this.moditem = item;
    }
}
