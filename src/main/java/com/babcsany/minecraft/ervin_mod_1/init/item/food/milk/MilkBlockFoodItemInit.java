package com.babcsany.minecraft.ervin_mod_1.init.item.food.milk;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.UsingBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MilkBlockFoodItemInit {
    private static final DeferredRegister<Item> ITEMS = UnusedItemInit.ITEM_DEFERRED_REGISTER;

    public static final RegistryObject<Item> ZUNK_BLOCK = ITEMS.register("zunk_block", () -> new UsingBlockItem(BlockInit.ZUNK_BLOCK.get(), new Item.Properties().group(ItemGroup.FOOD), 3240));
    public static final RegistryObject<Item> TNUZK_BLOCK = ITEMS.register("tnuzk_block", () -> new UsingBlockItem(BlockInit.TNUZK_BLOCK.get(), new Item.Properties().group(ItemGroup.FOOD), 2187000));
    public static final RegistryObject<Item> TNUZN = ITEMS.register("tnuzn", () -> new UsingBlockItem(BlockInit.TNUZN.get(), new Item.Properties().group(ItemGroup.FOOD), 139968000));

    public static Item register(String name, Block blockIn, int useDuration) {
        return UnusedItems.registerDefault(name, new UsingBlockItem(blockIn, new Item.Properties().group(ItemGroup.FOOD), useDuration));
    }

    public static void register() {
        Ervin_mod_1.register(MilkBlockFoodItemInit.class);
    }
}
