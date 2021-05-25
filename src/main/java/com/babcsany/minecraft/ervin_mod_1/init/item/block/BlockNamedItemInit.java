package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockNamedItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> TARG_SEEDS = ITEMS.register("seeds/targ_seeds", () -> new BlockNamedItem(
            BlockInit.TARG_STAGE.get(), (new Item.Properties())
    ));
}
