package com.babcsany.minecraft.ervin_mod_1.init.item.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> REGDEMP = ITEMS.register("regdemp", () -> new Item((new com.babcsany.minecraft.ervin_mod_1.item.item.Item().group(ItemGroup.SEARCH))));
}
