package com.babcsany.minecraft.ervin_mod_1.init.item.food;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import com.babcsany.minecraft.ervin_mod_1.item.UsingAndBurningItem;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableFoodItemInit {

    public static final DeferredRegister<Item> BURNABLE_FOODS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> TIRKS = BURNABLE_FOODS.register("tirks", () -> new Item((new Item.Properties()).food(Foods.TIRKS).isImmuneToFire().group(net.minecraft.item.ItemGroup.FOOD).group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> VIRK = BURNABLE_FOODS.register("virk", () -> new Item((new Item.Properties()).food(Foods.VIRK).isImmuneToFire().group(net.minecraft.item.ItemGroup.FOOD).group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item GRINT = UnusedItems.register("grint", new UsingAndBurningItem((new Item.Properties()).food(Foods.GRINT).isImmuneToFire().group(ItemGroup.FOOD).group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH), 128, 40000));
    public static final Item DURG = UnusedItems.register("durg", new UsingAndBurningItem((new Item.Properties()).food(Foods.DURG).isImmuneToFire().group(ItemGroup.FOOD).group(ModItemGroup.ERVIN_MOD_1_ITEMS).group(ModItemGroup.ERVIN_MOD_1_SEARCH), 2048, 640000));
}
