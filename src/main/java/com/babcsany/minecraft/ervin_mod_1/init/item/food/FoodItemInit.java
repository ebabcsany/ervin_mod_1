package com.babcsany.minecraft.ervin_mod_1.init.item.food;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.JurkBucketItem;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodItemInit {

    public static final DeferredRegister<Item> FOOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<Item> BREFK = ITEMS.register("brefk", () -> new JurkBucketItem((new Item.Properties())));
    public static final RegistryObject<Item> VIRK = FOOD_ITEMS.register("virk", () -> new Item((new Item.Properties()).food(Foods.VIRK).isBurnable()));
    public static final RegistryObject<Item> STEEF = FOOD_ITEMS.register("steef", () -> new Item((new Item.Properties()).food(Foods.STEEF)));
    public static final RegistryObject<Item> COOKED_STEEF = FOOD_ITEMS.register("cooked_steef", () -> new Item((new Item.Properties()).food(Foods.COOKED_STEEF)));
    public static final RegistryObject<Item> FRIM = FOOD_ITEMS.register("frim", () -> new Item((new Item.Properties()).food(Foods.FRIM)));
    public static final RegistryObject<Item> VOLMINT = FOOD_ITEMS.register("volmint", () -> new Item((new Item.Properties()).food(Foods.VOLMINT)));
    public static final RegistryObject<Item> ZUNT = FOOD_ITEMS.register("zunt", () -> new Item((new Item.Properties()).food(Foods.ZUNT)));
    public static final RegistryObject<Item> REAT = FOOD_ITEMS.register("reat", () -> new Item((new Item.Properties()).food(Foods.REAT)));
    public static final RegistryObject<Item> GUBROV = FOOD_ITEMS.register("gubrov", () -> new Item((new Item.Properties()).food(Foods.GUBROV)));
    public static final RegistryObject<Item> COOKED_GUBROV = FOOD_ITEMS.register("cooked_gubrov", () -> new Item((new Item.Properties()).food(Foods.COOKED_GUBROV)));
    public static final RegistryObject<Item> JAZZ_FRUIT = FOOD_ITEMS.register("jazz_fruit", () -> new Item((new Item.Properties()).food(Foods.JAZZ_FRUIT)));
    public static final RegistryObject<Item> SCRAFTH = FOOD_ITEMS.register("scrafth", () -> new BlockNamedItem(BlockInit.SCRAFTH.get(), (new Item.Properties()).food(Foods.SCRAFTH)));
    public static final RegistryObject<Item> FIRG = FOOD_ITEMS.register("firg", () -> new BlockNamedItem(BlockInit.FIRG.get(), (new Item.Properties()).isBurnable().food(Foods.FIRG)));
    public static final RegistryObject<Item> FIRG_SLAB = FOOD_ITEMS.register("firg_slab", () -> new BlockNamedItem(BlockInit.FIRG_SLAB.get(), (new Item.Properties()).isBurnable().food(Foods.FIRG_SLAB)));
    public static final RegistryObject<Item> FIRG_STAIRS = FOOD_ITEMS.register("firg_stairs", () -> new BlockNamedItem(BlockInit.FIRG_STAIRS.get(), (new Item.Properties()).isBurnable().food(Foods.FIRG_STAIRS)));
    public static final RegistryObject<Item> VIRK_BLOCK = FOOD_ITEMS.register("virk_block", () -> new BlockNamedItem(BlockInit.VIRK_BLOCK.get(), (new Item.Properties()).isBurnable().food(Foods.VIRK_BLOCK)));
}
