package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableBlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<BlockItem> TERAT_BLOCK = register("terat_block", BlockInit.TERAT_BLOCK, (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS));
    public static final RegistryObject<BlockItem> THUIRTH_RAIL = register("thuirth_rail", BlockInit.THUIRTH_RAIL, (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS));
    public static final RegistryObject<BlockItem> GNRTHIRJ = register("gnrthirj", BlockInit.GNRTHIRJ, (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS));

    public static RegistryObject<BlockItem> register(String name, RegistryObject<Block> item, Item.Properties properties) {
        return UnusedBlockItemInit.registryObject(BLOCK_ITEMS, name, () -> new BlockItem(item.orElse(Blocks.AIR), properties));
    }

    public static void register() {
        Ervin_mod_1.register(isBurnableBlockItemInit.class);
    }
}
