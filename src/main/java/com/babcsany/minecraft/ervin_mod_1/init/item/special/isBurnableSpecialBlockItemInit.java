package com.babcsany.minecraft.ervin_mod_1.init.item.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.item.block.GrithBlock;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableSpecialBlockItemInit {

    public static final DeferredRegister<Item> SPECIAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final GrithBlock GRITH_BLOCK = UnusedBlockItems.registerDefault("grith_block", new GrithBlock(BlockInit.GRITH_BLOCK, (new Item.Properties())));
    public static final GrithBlock GRITH_SLAB = UnusedBlockItems.registerDefault("grith_slab", new GrithBlock(BlockInit.GRITH_SLAB, (new Item.Properties())));
    public static final GrithBlock GRITH_STAIRS = UnusedBlockItems.registerDefault("grith_stairs", new GrithBlock(BlockInit.GRITH_STAIRS, (new Item.Properties())));
}
