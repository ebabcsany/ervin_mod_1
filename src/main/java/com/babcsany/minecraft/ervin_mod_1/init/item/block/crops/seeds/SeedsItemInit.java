package com.babcsany.minecraft.ervin_mod_1.init.item.block.crops.seeds;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SeedsItemInit {

    public static final DeferredRegister<Item> SEEDS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> TARG_SEEDS = SEEDS.register("seeds/targ_seeds", () -> new BlockNamedItem(
            BlockInit.TARG_STAGE.get(), (new Item.Properties())
    ));
}
