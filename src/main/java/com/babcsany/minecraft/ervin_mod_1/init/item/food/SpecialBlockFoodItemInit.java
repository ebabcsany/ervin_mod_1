package com.babcsany.minecraft.ervin_mod_1.init.item.food;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import com.babcsany.minecraft.ervin_mod_1.item.UsingAndBurningBlockItem;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialBlockFoodItemInit {
    public static final Item FIRG = addUsingAndBurning("firg", BlockInit.FIRG, Foods.FIRG, 32, 10000);
    public static final Item FIRG_SLAB = addUsingAndBurning("firg_slab", BlockInit.FIRG_SLAB, Foods.FIRG_SLAB, 16, 5000);
    public static final Item FIRG_STAIRS = addUsingAndBurning("firg_stairs", BlockInit.FIRG_STAIRS, Foods.FIRG_STAIRS, 24, 7500);
    public static final Item VIRK_BLOCK = addUsingAndBurning("virk_block", BlockInit.VIRK_BLOCK, Foods.VIRK_BLOCK);
    public static final Item GRINT_BLOCK = addUsingAndBurning("grint_block", BlockInit.GRINT_BLOCK, Foods.GRINT_BLOCK, 512, 160000);
    public static final Item GRINT_SLAB = addUsingAndBurning("grint_slab", BlockInit.GRINT_SLAB, Foods.GRINT_SLAB, 256, 80000);
    public static final Item GRINT_STAIRS = addUsingAndBurning("grint_stairs", BlockInit.GRINT_STAIRS, Foods.GRINT_STAIRS, 384, 120000);

    public static Item addUsingAndBurning(String path, Block blockIn, Food food, int useDurationIn, int burnTimeIn) {
        return addUsingAndBurning(path, blockIn, properties(food), useDurationIn, burnTimeIn);
    }

    public static Item addUsingAndBurning(String path, Block blockIn, Item.Properties properties, int useDurationIn, int burnTimeIn) {
        return UnusedItems.registerDefault(path, new UsingAndBurningBlockItem(blockIn, properties, UseAction.EAT, useDurationIn, burnTimeIn));
    }

    public static Item addUsingAndBurning(String path, Block blockIn, Food food) {
        return addUsingAndBurning(path, blockIn, properties(food));
    }

    public static Item addUsingAndBurning(String path, Block blockIn, Item.Properties properties) {
        return UnusedItems.registerBlockItem(path, blockIn, properties);
    }

    public static Item.Properties properties(Food food) {
        return new Item.Properties().isImmuneToFire().food(food).group(ItemGroup.FOOD).group(ModItemGroup.ERVIN_MOD_1_SEARCH);
    }

    public static void register() {
        Ervin_mod_1.register(SpecialBlockFoodItemInit.class);
    }
}
