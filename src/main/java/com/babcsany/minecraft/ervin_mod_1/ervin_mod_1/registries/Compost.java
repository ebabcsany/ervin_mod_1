package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.registries;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.crops.seeds.SeedsItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.BlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import net.minecraft.block.ComposterBlock;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class Compost {

    public static void registerCompostable(float chance, IItemProvider itemIn) {
        ComposterBlock.CHANCES.put(itemIn.asItem(), chance);
    }

    public static <T extends IItemProvider & IForgeRegistryEntry<? super T>> void registerCompostable(float chance, RegistryObject<T> supplierIn) {
        registerCompostable(chance, supplierIn.get());
    }
    public static void init() {
        ComposterBlock.CHANCES.defaultReturnValue(-1.0F);
        ComposterBlock.CHANCES.put(((IItemProvider) ItemInit.EPKIN.get()).asItem(), 0.3F);
        registerCompostable(0.3F, SeedsItemInit.TARG_SEEDS);
        registerCompostable(0.35F, BlockItemInit.FRIM_LEAVES);
        registerCompostable(0.35F, BlockItemInit.FRIM_SAPLING);
        registerCompostable(0.4F, isBurnableBlockItemInit.FIRG_LEAVES);
        registerCompostable(0.4F, isBurnableBlockItemInit.FIRG_SAPLING);
        registerCompostable(0.45F, BlockFoodItemInit.SCRAFTH);
        registerCompostable(0.5F, SpecialBlockFoodItemInit.FIRG_SLAB);
        registerCompostable(0.65F, FoodItemInit.JAZZ_FRUIT);
        registerCompostable(0.7F, ItemInit.CRAKH);
        registerCompostable(0.75F, SpecialBlockFoodItemInit.FIRG_STAIRS);
        registerCompostable(0.85F, FoodItemInit.FRIM);
        registerCompostable(1.0F, SpecialBlockFoodItemInit.FIRG);
        registerCompostable(1.25F, FoodItemInit.REAT);
        registerCompostable(4.0F, isBurnableFoodItemInit.GRINT);
        registerCompostable(8.0F, SpecialBlockFoodItemInit.GRINT_SLAB);
        registerCompostable(12.0F, SpecialBlockFoodItemInit.GRINT_STAIRS);
        registerCompostable(16.0F, SpecialBlockFoodItemInit.GRINT_BLOCK);
        registerCompostable(64.0F, isBurnableFoodItemInit.DURG);
        registerCompostable(210.0F, SpecialBlockFoodItemInit.VIRK_BLOCK);
    }
}
