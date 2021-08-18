package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.crops.seeds.SeedsItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.BlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import net.minecraft.util.IItemProvider;

public class ComposterBlock extends net.minecraft.block.ComposterBlock {
    public ComposterBlock(Properties properties) {
        super(properties);
    }

    public static void init() {
        CHANCES.defaultReturnValue(-1.0F);
        registerCompostable(0.3F, SeedsItemInit.TARG_SEEDS.get());
        registerCompostable(0.35F, BlockItemInit.FRIM_LEAVES.get());
        registerCompostable(0.35F, BlockItemInit.FRIM_SAPLING.get());
        registerCompostable(0.4F, isBurnableBlockItemInit.FIRG_LEAVES.get());
        registerCompostable(0.4F, isBurnableBlockItemInit.FIRG_SAPLING.get());
        registerCompostable(0.45F, BlockFoodItemInit.SCRAFTH.get());
        registerCompostable(0.5F, SpecialBlockFoodItemInit.FIRG_SLAB.get());
        registerCompostable(0.65F, FoodItemInit.JAZZ_FRUIT.get());
        registerCompostable(0.7F, ItemInit.CRAKH.get());
        registerCompostable(0.75F, SpecialBlockFoodItemInit.FIRG_STAIRS.get());
        registerCompostable(0.85F, FoodItemInit.FRIM.get());
        registerCompostable(1.0F, SpecialBlockFoodItemInit.FIRG.get());
        registerCompostable(1.25F, FoodItemInit.REAT.get());
        registerCompostable(4.0F, isBurnableFoodItemInit.GRINT.get());
        registerCompostable(8.0F, SpecialBlockFoodItemInit.GRINT_SLAB.get());
        registerCompostable(12.0F, SpecialBlockFoodItemInit.GRINT_STAIRS.get());
        registerCompostable(16.0F, SpecialBlockFoodItemInit.GRINT_BLOCK.get());
        registerCompostable(64.0F, isBurnableFoodItemInit.DURG.get());
        registerCompostable(210.0F, SpecialBlockFoodItemInit.VIRK_BLOCK.get());
    }

    public static void registerCompostable(float chance, IItemProvider itemIn) {
        CHANCES.put(itemIn.asItem(), chance);
    }
}
