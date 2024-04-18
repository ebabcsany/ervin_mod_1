package com.babcsany.minecraft.ervin_mod_1.init.item.food.milk;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.item.UsingBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MilkBlockFoodItemInit {
    public static final Item ZUNK_BLOCK = register("zunk_block", BlockInit.ZUNK_BLOCK, 3240);
    public static final Item TNUZK_BLOCK = register("tnuzk_block", BlockInit.TNUZK_BLOCK, 2187000);
    public static final Item TNUZN = register("tnuzn", BlockInit.TNUZN, 139968000);

    public static Item register(String name, Block blockIn, int useDuration) {
        return UnusedBlockItems.addDefault(name, new UsingBlockItem(blockIn, new Item.Properties().group(ItemGroup.FOOD), useDuration));
    }

    public static void register() {
        Ervin_mod_1.register(MilkBlockFoodItemInit.class);
    }
}
