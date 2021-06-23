package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.special.ModOperatorOnlyItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableBlockItemInit {

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> TERAT_BLOCK = BLOCK_ITEMS.register("terat_block", () -> new BlockItem(BlockInit.TERAT_BLOCK.get(), (new Item.Properties()).isBurnable().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> TRIRIJ = BLOCK_ITEMS.register("tririj", () -> new BlockItem(com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit.TRIRIJ, (new Item.Properties()).isBurnable().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> THUIRTH_RAIL = BLOCK_ITEMS.register("thuirth_rail", () -> new BlockItem(BlockInit.THUIRTH_RAIL.get(), (new Item.Properties()).isBurnable().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> GNRTHIRJ = BLOCK_ITEMS.register("gnrthirj", () -> new BlockItem(BlockInit.GNRTHIRJ.get(), (new Item.Properties()).isBurnable().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> FRISZERN = BLOCK_ITEMS.register("friszern", () -> new BlockItem(BlockInit.FRISZERN, (new Item.Properties()).isBurnable().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> REPEATER_FRISZERN = BLOCK_ITEMS.register("repeater_friszern", () -> new BlockItem(BlockInit.REPEATING_FRISZERN, (new Item.Properties()).isBurnable().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> CHAIN_FRISZERN = BLOCK_ITEMS.register("chain_friszern", () -> new BlockItem(BlockInit.CHAIN_FRISZERN, (new Item.Properties()).isBurnable().rarity(Rarity.EPIC)));
}
