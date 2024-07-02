package com.babcsany.minecraft.ervin_mod_1.init.item.block.crops.seeds;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class SeedsItemInit {
    public static final Item TARG_SEEDS = register("targ_seeds", BlockInit.TARG_STAGE);

    public static Item register(String name, Block blockIn) {
        return UnusedItems.registerBlockItem("seeds/" + name, blockIn);
    }

    public static void register() {
        Ervin_mod_1.register(SeedsItemInit.class);
    }
}
