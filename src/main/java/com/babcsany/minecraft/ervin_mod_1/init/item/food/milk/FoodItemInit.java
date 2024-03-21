package com.babcsany.minecraft.ervin_mod_1.init.item.food.milk;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.UsingItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodItemInit {

    public static final DeferredRegister<Item> FOOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> ZUNT = FOOD_ITEMS.register("zunt", () -> new UsingItem((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD), 120));
    public static final RegistryObject<Item> ZUNB = FOOD_ITEMS.register("zunb", () -> new UsingItem((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD), 360));
    public static final RegistryObject<Item> ZUNK = FOOD_ITEMS.register("zunk", () -> new UsingItem((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD), 1080));
    public static final RegistryObject<Item> ZUNKT = FOOD_ITEMS.register("zunkt", () -> new UsingItem((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD), 9720));
    public static final RegistryObject<Item> ZUNKTH = FOOD_ITEMS.register("zunkth", () -> new UsingItem((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD), 48600));
    public static final RegistryObject<Item> TNUZH = FOOD_ITEMS.register("tnuzh", () -> new UsingItem((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD), 145800));
    public static final RegistryObject<Item> TNUZK = FOOD_ITEMS.register("tnuzk", () -> new UsingItem((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD), 437400));
    public static final RegistryObject<Item> TNUZT = FOOD_ITEMS.register("tnuzt", () -> new UsingItem((new Item.Properties()).group(net.minecraft.item.ItemGroup.FOOD), 17496000));
}
