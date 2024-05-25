package com.babcsany.minecraft.ervin_mod_1.init.item.food;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import com.babcsany.minecraft.ervin_mod_1.item.UsingAndBurningBlockItem;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialBlockFoodItemInit {

    public static final DeferredRegister<Item> BURNABLE_FOOD_BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item FIRG = addUsingAndBurning("firg", BlockInit.FIRG, Foods.FIRG, 32, 10000);
    public static final Item FIRG_SLAB = addUsingAndBurning("firg_slab", BlockInit.FIRG_SLAB, Foods.FIRG_SLAB, 16, 5000);
    public static final Item FIRG_STAIRS = addUsingAndBurning("firg_stairs", BlockInit.FIRG_STAIRS, Foods.FIRG_STAIRS, 24, 7500);
    public static final Item VIRK_BLOCK = UnusedBlockItems.addDefault("virk_block", new BlockItem(BlockInit.VIRK_BLOCK, (new Item.Properties()).isImmuneToFire().food(Foods.VIRK_BLOCK).group(ItemGroup.FOOD).group(ModItemGroup.ERVIN_MOD_1_SEARCH)));
    public static final Item GRINT_BLOCK = addUsingAndBurning("grint_block", BlockInit.GRINT_BLOCK, Foods.GRINT_BLOCK, 512, 160000);
    public static final Item GRINT_SLAB = addUsingAndBurning("grint_slab", BlockInit.GRINT_SLAB, Foods.GRINT_SLAB, 256, 80000);
    public static final Item GRINT_STAIRS = addUsingAndBurning("grint_stairs", BlockInit.GRINT_STAIRS, Foods.GRINT_STAIRS, 384, 120000);

    public static Item addUsingAndBurning(String path, Block blockIn, Food food, int useDurationIn, int burnTimeIn) {
        return addUsingAndBurning(path, blockIn, new Item.Properties().isImmuneToFire().food(food).group(ItemGroup.FOOD).group(ModItemGroup.ERVIN_MOD_1_SEARCH), useDurationIn, burnTimeIn);
    }

    public static Item addUsingAndBurning(String path, Block blockIn, Item.Properties properties, int useDurationIn, int burnTimeIn) {
        return UnusedBlockItems.addDefault(path, new UsingAndBurningBlockItem(blockIn, properties, useDurationIn, burnTimeIn));
    }
}
