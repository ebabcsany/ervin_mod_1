package com.babcsany.minecraft.ervin_mod_1.init.item.block.tool;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import com.babcsany.minecraft.ervin_mod_1.item.block.tool.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnderToolItemInit {
    public static final Item ENDER_SRACKHT = register("ender_srackht", new PickaxeBlockItem(ModItemTier.ENDER_SRACKT, BlockInit.ENDER_SRACKHT, 0, 0.0F, (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH))));
    public static final Item ENDER_STAKRACH = register("ender_stakrach", new AxeBlockItem(ModItemTier.ENDER_SRACKHT, BlockInit.ENDER_STAKRACH, 2, 2.0F, (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH))));
    public static final Item ENDER_SRAKTCAF = register("ender_sraktcaf", new ShovelBlockItem(ModItemTier.ENDER_STAKRACH, BlockInit.ENDER_SRAKTCAF, 3, 4.0F, (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH))));
    public static final Item ENDER_TRASKRACH = register("ender_traskrach", new HoeBlockItem(ModItemTier.ENDER_SRAKTCAF, BlockInit.ENDER_TRASKRACH, 1, 5.0F, (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH))));
    public static final Item ENDER_TRASKCRAFTH = register("ender_traskcrafth", new SwordBlockItem(ModItemTier.ENDER_TRASKRACH, BlockInit.ENDER_TRASKCRAFTH, 6, 6.0F, (new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH))));

    public static BlockItem register(String name, BlockItem blockItem) {
        return new Cast<BlockItem>().cast(UnusedItems.registerDefault(name, blockItem));
    }

    public static void register() {
        Ervin_mod_1.register(EnderToolItemInit.class);
    }
}
