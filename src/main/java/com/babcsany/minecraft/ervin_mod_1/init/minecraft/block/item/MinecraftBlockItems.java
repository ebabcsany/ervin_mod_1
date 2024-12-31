package com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.MinecraftBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.BurningBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class MinecraftBlockItems {
    private static final DeferredRegister<Item> MINECRAFT_BLOCK_ITEMS = UnusedBlockItemInit.BLOCK_ITEM_DEFERRED_REGISTER;

    public static final RegistryObject<BlockItem> COAL_STAIRS = MINECRAFT_BLOCK_ITEMS.register("coal_stairs", () -> new BurningBlockItem(MinecraftBlocks.COAL_STAIRS.get(), (new Item.Properties()), 12000));

    public static void register() {
        Ervin_mod_1.register(MinecraftBlockItems.class);
    }
}
