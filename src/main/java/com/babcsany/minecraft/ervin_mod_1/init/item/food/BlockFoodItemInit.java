package com.babcsany.minecraft.ervin_mod_1.init.item.food;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockFoodItemInit {

    public static final DeferredRegister<Item> FOOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item SCRAFTH = register("scrafth", BlockInit.SCRAFTH, Foods.SCRAFTH);

    public static Item register(String name, Block block, Food food) {
        return UnusedItems.registerBlockItem(name, block, new Item.Properties().food(food).group(ItemGroup.FOOD).group(ModItemGroup.ERVIN_MOD_1_SEARCH));
    }

    public static Item register(String name, Block block, Item.Properties properties) {
        return UnusedBlockItems.registerDefault(name, block, properties);
    }

    public static void register() {
        Ervin_mod_1.register(BlockFoodItemInit.class);
    }
}
