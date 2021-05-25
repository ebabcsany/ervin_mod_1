package com.babcsany.minecraft.ervin_mod_1.init.item.block.tool;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import com.babcsany.minecraft.ervin_mod_1.item.block.ender.EnderStakrach;
import com.babcsany.minecraft.ervin_mod_1.item.block.tool.*;
import com.babcsany.minecraft.ervin_mod_1.item.group.ItemGroup;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolItemInit {

    public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> ENDER_SRACKHT = TOOLS.register("ender_srackht", () -> new PickaxeBlockItem(ModItemTier.ENDER_SRACKT, BlockInit.ENDER_SRACKHT.get(), 0, 0.0F, (new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SEARCH))));
    public static final RegistryObject<Item> ENDER_STAKRACH = TOOLS.register("ender_stakrach", () -> new AxeBlockItem(ModItemTier.ENDER_SRACKHT, BlockInit.ENDER_STAKRACH.get(), 2, 2.0F, (new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SEARCH))));
    public static final RegistryObject<Item> ENDER_SRAKTCAF = TOOLS.register("ender_sraktcaf", () -> new ShovelBlockItem(ModItemTier.ENDER_STAKRACH, BlockInit.ENDER_SRAKTCAF.get(), 3, 4.0F, (new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SEARCH))));
    public static final RegistryObject<Item> ENDER_TRASKCRAFTH = TOOLS.register("ender_traskcrafth", () -> new SwordBlockItem(ModItemTier.ENDER_TRASKRACH, BlockInit.ENDER_TRASKCRAFTH.get(), 6, 6.0F, (new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SEARCH))));
    public static final RegistryObject<Item> ENDER_TRASKRACH = TOOLS.register("ender_traskrach", () -> new HoeBlockItem(ModItemTier.ENDER_SRAKTCAF, BlockInit.ENDER_TRASKRACH.get(), 1, 5.0F, (new Item.Properties().group(ItemGroup.ERVIN_MOD_1_SEARCH))));
}
