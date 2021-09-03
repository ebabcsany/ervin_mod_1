package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.block.burning.FirtBlock;
import com.babcsany.minecraft.ervin_mod_1.item.block.burning.Tragn;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class BlockItemInit {

    public static BlockItemInit BLOCK_ITEMS;

    public static final Item JURKF = register("jurkf", new BlockItem(com.babcsany.minecraft.init.BlockInit.FIRT_BLOCK, (new Item.Properties())));
    public static final Item FIRG_PLANKS = register("firg_planks", new BlockItem(BlockInit.FIRG_PLANKS, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FIRG_PLANKS_STAIRS = register("firg_planks_stairs", new BlockItem(BlockInit.FIRG_PLANKS_STAIRS, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FIRG_PLANKS_DOOR = register("firg_planks_door", new BlockItem(BlockInit.FIRG_PLANKS_DOOR, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item FIRT_BLOCK = register("firt_block", new FirtBlock(BlockInit.FIRT_BLOCK, (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final Item TRIRIJ = register("tririj", new BlockItem(com.babcsany.minecraft.init.BlockInit.TRIRIJ, (new Item.Properties()).isBurnable().group(ItemGroup.MATERIALS)));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static Item register(String key, Item itemIn) {
        return Ervin_mod_1.itemRegister(new ResourceLocation(string(key)), itemIn);
    }
}
