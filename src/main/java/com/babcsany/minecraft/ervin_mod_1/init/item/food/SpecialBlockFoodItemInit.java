package com.babcsany.minecraft.ervin_mod_1.init.item.food;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import com.babcsany.minecraft.ervin_mod_1.item.UsingAndBurningBlockItem;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialBlockFoodItemInit {

    public static final DeferredRegister<Item> BURNABLE_FOOD_BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> FIRG = BURNABLE_FOOD_BLOCK_ITEMS.register("firg", () -> new UsingAndBurningBlockItem(BlockInit.FIRG.get(), (new Item.Properties()).food(Foods.FIRG).group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_SEARCH).isImmuneToFire(), 32, 10000));
    public static final RegistryObject<Item> FIRG_SLAB = BURNABLE_FOOD_BLOCK_ITEMS.register("firg_slab", () -> new UsingAndBurningBlockItem(BlockInit.FIRG_SLAB.get(), (new Item.Properties()).food(Foods.FIRG_SLAB).group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_SEARCH).isImmuneToFire(), 16, 5000));
    public static final RegistryObject<Item> FIRG_STAIRS = BURNABLE_FOOD_BLOCK_ITEMS.register("firg_stairs", () -> new UsingAndBurningBlockItem(BlockInit.FIRG_STAIRS.get(), (new Item.Properties()).food(Foods.FIRG_STAIRS).group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_SEARCH).isImmuneToFire(), 24, 7500));
    public static final RegistryObject<Item> VIRK_BLOCK = BURNABLE_FOOD_BLOCK_ITEMS.register("virk_block", () -> new BlockItem(BlockInit.VIRK_BLOCK.get(), (new Item.Properties()).isImmuneToFire().food(Foods.VIRK_BLOCK).group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GRINT_BLOCK = BURNABLE_FOOD_BLOCK_ITEMS.register("grint_block", () -> new UsingAndBurningBlockItem(BlockInit.GRINT_BLOCK.get(), (new Item.Properties()).isImmuneToFire().food(Foods.GRINT_BLOCK).group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_SEARCH), 512, 160000));
    public static final RegistryObject<Item> GRINT_SLAB = BURNABLE_FOOD_BLOCK_ITEMS.register("grint_slab", () -> new UsingAndBurningBlockItem(BlockInit.GRINT_SLAB.get(), (new Item.Properties()).isImmuneToFire().food(Foods.GRINT_SLAB).group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_SEARCH), 256, 80000));
    public static final RegistryObject<Item> GRINT_STAIRS = BURNABLE_FOOD_BLOCK_ITEMS.register("grint_stairs", () -> new UsingAndBurningBlockItem(BlockInit.GRINT_STAIRS.get(), (new Item.Properties()).isImmuneToFire().food(Foods.GRINT_STAIRS).group(net.minecraft.item.ItemGroup.FOOD).group(ItemGroup.ERVIN_MOD_1_SEARCH), 384, 120000));
}
