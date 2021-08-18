package com.babcsany.minecraft.ervin_mod_1.init.item.food;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import com.babcsany.minecraft.ervin_mod_1.item.food.foods.Firg;
import com.babcsany.minecraft.ervin_mod_1.item.food.foods.FirgSlab;
import com.babcsany.minecraft.ervin_mod_1.item.food.foods.FirgStairs;
import com.babcsany.minecraft.ervin_mod_1.item.food.foods.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialBlockFoodItemInit {

    public static final DeferredRegister<Item> BURNABLE_FOOD_BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> FIRG = BURNABLE_FOOD_BLOCK_ITEMS.register("firg", () -> new Firg(BlockInit.FIRG.get(), (new Item.Properties()).food(Foods.FIRG).group(ItemGroup.ERVIN_MOD_1_SEARCH).isBurnable()));
    public static final RegistryObject<Item> FIRG_SLAB = BURNABLE_FOOD_BLOCK_ITEMS.register("firg_slab", () -> new FirgSlab(BlockInit.FIRG_SLAB.get(), (new Item.Properties()).food(Foods.FIRG_SLAB).group(ItemGroup.ERVIN_MOD_1_SEARCH).isBurnable()));
    public static final RegistryObject<Item> FIRG_STAIRS = BURNABLE_FOOD_BLOCK_ITEMS.register("firg_stairs", () -> new FirgStairs(BlockInit.FIRG_STAIRS.get(), (new Item.Properties()).food(Foods.FIRG_STAIRS).group(ItemGroup.ERVIN_MOD_1_SEARCH).isBurnable()));
    public static final RegistryObject<Item> VIRK_BLOCK = BURNABLE_FOOD_BLOCK_ITEMS.register("virk_block", () -> new BlockItem(BlockInit.VIRK_BLOCK.get(), (new Item.Properties()).isBurnable().food(Foods.VIRK_BLOCK).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GRINT_BLOCK = BURNABLE_FOOD_BLOCK_ITEMS.register("grint_block", () -> new GrintBlock(BlockInit.GRINT_BLOCK.get(), (new Item.Properties()).isBurnable().food(Foods.GRINT_BLOCK).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GRINT_SLAB = BURNABLE_FOOD_BLOCK_ITEMS.register("grint_slab", () -> new GrintSlab(BlockInit.GRINT_SLAB.get(), (new Item.Properties()).isBurnable().food(Foods.GRINT_BLOCK).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final RegistryObject<Item> GRINT_STAIRS = BURNABLE_FOOD_BLOCK_ITEMS.register("grint_stairs", () -> new GrintStairs(BlockInit.GRINT_STAIRS.get(), (new Item.Properties()).isBurnable().food(Foods.GRINT_BLOCK).group(ItemGroup.ERVIN_MOD_1_SEARCH)));
}
