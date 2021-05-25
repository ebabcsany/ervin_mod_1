package com.babcsany.minecraft.ervin_mod_1.init.item.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import com.babcsany.minecraft.ervin_mod_1.item.block.GrithBlock;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableSpecialBlockItemInit {

    public static final DeferredRegister<Item> SPECIAL_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<GrithBlock> GRITH_BLOCK = SPECIAL_ITEMS.register("grith_block", () -> new GrithBlock(BlockInit.GRITH_BLOCK.get(), (new Item.Properties())));
    public static final RegistryObject<GrithBlock> GRITH_SLAB = SPECIAL_ITEMS.register("grith_slab", () -> new GrithBlock(BlockInit.GRITH_SLAB.get(), (new Item.Properties())));
    public static final RegistryObject<GrithBlock> GRITH_STAIRS = SPECIAL_ITEMS.register("grith_stairs", () -> new GrithBlock(BlockInit.GRITH_STAIRS.get(), (new Item.Properties())));
}
