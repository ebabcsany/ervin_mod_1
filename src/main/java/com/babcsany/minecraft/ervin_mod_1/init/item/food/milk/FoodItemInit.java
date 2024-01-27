package com.babcsany.minecraft.ervin_mod_1.init.item.food.milk;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.food.foods.milk.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodItemInit {

    public static final DeferredRegister<Item> FOOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> ZUNT = FOOD_ITEMS.register("zunt", () -> new Zunt((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD)));
    public static final RegistryObject<Item> ZUNB = FOOD_ITEMS.register("zunb", () -> new Zunb((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD)));
    public static final RegistryObject<Item> ZUNK = FOOD_ITEMS.register("zunk", () -> new Zunk((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD)));
    public static final RegistryObject<Item> ZUNKT = FOOD_ITEMS.register("zunkt", () -> new Zunkt((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD)));
    public static final RegistryObject<Item> ZUNKTH = FOOD_ITEMS.register("zunkth", () -> new Zunkth((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD)));
}
