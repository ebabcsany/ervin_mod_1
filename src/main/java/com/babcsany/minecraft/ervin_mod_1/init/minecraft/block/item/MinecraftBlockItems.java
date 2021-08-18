package com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item;

import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.item.BurningBlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import static com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.BlockNamedItemInit.BLOCK_ITEMS;

public class MinecraftBlockItems {

    public static final RegistryObject<Item> COAL_STAIRS = BLOCK_ITEMS.register("coal_stairs", () -> new BurningBlockItem(MinecraftBlocks.COAL_STAIRS.get(), (new Item.Properties()), 12000));

}
