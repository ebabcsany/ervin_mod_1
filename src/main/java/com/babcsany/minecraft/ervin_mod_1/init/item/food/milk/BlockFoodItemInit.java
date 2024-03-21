package com.babcsany.minecraft.ervin_mod_1.init.item.food.milk;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.UsingBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockFoodItemInit {

    public static final DeferredRegister<Item> FOOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> ZUNK_BLOCK = FOOD_ITEMS.register("zunk_block", () -> new UsingBlockItem(BlockInit.ZUNK_BLOCK.get(), (new Item.Properties()).group(ItemGroup.FOOD), 3240));
    public static final RegistryObject<Item> TNUZK_BLOCK = FOOD_ITEMS.register("tnuzk_block", () -> new UsingBlockItem(BlockInit.TNUZK_BLOCK.get(), (new Item.Properties()).group(ItemGroup.FOOD), 2187000));
    public static final RegistryObject<Item> TNUZN = FOOD_ITEMS.register("tnuzn", () -> new UsingBlockItem(BlockInit.TNUZN.get(), (new Item.Properties()).group(ItemGroup.FOOD), 139968000));
}
