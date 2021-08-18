package com.babcsany.minecraft.ervin_mod_1.init.item.food;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodItemInit {

    public static final DeferredRegister<Item> FOODS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> STEEF = FOODS.register("meat/steef", () -> new Item((new Item.Properties()).food(Foods.STEEF).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> MRONT = FOODS.register("meat/mront", () -> new Item((new Item.Properties()).food(Foods.MRONT).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> COOKED_MRONT = FOODS.register("meat/cooked_mront", () -> new Item((new Item.Properties()).food(Foods.MRONT).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> COOKED_STEEF = FOODS.register("meat/cooked_steef", () -> new Item((new Item.Properties()).food(Foods.COOKED_STEEF).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> FRIM = FOODS.register("frim", () -> new Item((new Item.Properties()).food(Foods.FRIM).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> VOLMINT = FOODS.register("volmint", () -> new Item((new Item.Properties()).food(Foods.VOLMINT).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> REAT = FOODS.register("reat", () -> new Item((new Item.Properties()).food(Foods.REAT).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GUBROV = FOODS.register("gubrov", () -> new Item((new Item.Properties()).food(Foods.GUBROV).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> COOKED_GUBROV = FOODS.register("cooked_gubrov", () -> new Item((new Item.Properties()).food(Foods.COOKED_GUBROV).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> JAZZ_FRUIT = FOODS.register("jazz_fruit", () -> new Item((new Item.Properties()).food(Foods.JAZZ_FRUIT).group(ItemGroup.ERVIN_MOD_1_SEARCH)));

}
