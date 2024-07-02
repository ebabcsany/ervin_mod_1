package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableBlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item TERAT_BLOCK = register("terat_block", new BlockItem(BlockInit.TERAT_BLOCK, (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS)));
    public static final Item THUIRTH_RAIL = register("thuirth_rail", new BlockItem(BlockInit.THUIRTH_RAIL, (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS)));
    public static final Item GNRTHIRJ = register("gnrthirj", new BlockItem(BlockInit.GNRTHIRJ, (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS)));

    public static Item register(String name, Item item) {
        return UnusedItems.registerDefault(name, item);
    }

    public static void register() {
        Ervin_mod_1.register(isBurnableBlockItemInit.class);
    }
}
