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
    public static final RegistryObject<Item> ENDER_SRACKHT = ITEMS.register("ender_srackht", () -> new PickaxeItem(
            ModItemTier.ENDER_SRACKT, 0, 0.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_STAKRACH = ITEMS.register("ender_stakrach", () -> new AxeItem(
            ModItemTier.ENDER_SRACKHT, 2, 2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_SRAKTCAF = ITEMS.register("ender_sraktcaf", () -> new ShovelItem(
            ModItemTier.ENDER_STAKRACH, 3, 4.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_TRASKCRAFTH = ITEMS.register("ender_trashkcrafth", () -> new SwordItem(
            ModItemTier.ENDER_TRASKRACH, 6, 6.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> ENDER_TRASKRACH = ITEMS.register("ender_traskrach", () -> new HoeItem(
            ModItemTier.ENDER_SRAKTCAF, 1, 5F, (new Item.Properties())
    ));
}
