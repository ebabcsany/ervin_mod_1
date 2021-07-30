package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockItemInit {

    public static BlockItemInit BLOCK_ITEMS;

    public static final Item JURKF = register("ervin_mod_1:jurkf", new BlockItem(com.babcsany.minecraft.init.BlockInit.FIRT_BLOCK, (new Item.Properties())));
    public static final Item FIRG_PLANKS = register("ervin_mod_1:firg_planks", new BlockItem(BlockInit.FIRG_PLANKS, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FIRG_PLANKS_STAIRS = register("ervin_mod_1:firg_planks_stairs", new BlockItem(BlockInit.FIRG_PLANKS_STAIRS, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FIRG_PLANKS_DOOR = register("ervin_mod_1:firg_planks_door", new BlockItem(BlockInit.FIRG_PLANKS_DOOR, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FIRT_BLOCK = register("ervin_mod_1:firt_block", new BlockItem(BlockInit.FIRT_BLOCK, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));

    private static Item register(String key, Item itemIn) {
        return Ervin_mod_1.itemRegister(new ResourceLocation(key), itemIn);
    }
}
