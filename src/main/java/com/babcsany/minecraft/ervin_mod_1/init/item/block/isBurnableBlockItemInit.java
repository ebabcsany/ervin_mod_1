package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableBlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> TERAT_BLOCK = BLOCK_ITEMS.register("terat_block", () -> new BlockItem(BlockInit.TERAT_BLOCK.get(), (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> THUIRTH_RAIL = BLOCK_ITEMS.register("thuirth_rail", () -> new BlockItem(BlockInit.THUIRTH_RAIL.get(), (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> GNRTHIRJ = BLOCK_ITEMS.register("gnrthirj", () -> new BlockItem(BlockInit.GNRTHIRJ.get(), (new Item.Properties()).isImmuneToFire().group(ItemGroup.MATERIALS)));
}
