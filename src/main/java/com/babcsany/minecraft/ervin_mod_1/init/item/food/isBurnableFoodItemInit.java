package com.babcsany.minecraft.ervin_mod_1.init.item.food;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableFoodItemInit {

    public static final DeferredRegister<Item> BURNABLE_FOODS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> TIRKS = BURNABLE_FOODS.register("tirks", () -> new Item((new Item.Properties()).food(Foods.TIRKS).isBurnable().group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> VIRK = BURNABLE_FOODS.register("virk", () -> new Item((new Item.Properties()).food(Foods.VIRK).isBurnable().group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GRINT = BURNABLE_FOODS.register("grint", () -> new Item((new Item.Properties()).food(Foods.GRINT).isBurnable().group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> DURG = BURNABLE_FOODS.register("durg", () -> new Item((new Item.Properties()).food(Foods.DURG).isBurnable().group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_ITEMS).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
}
