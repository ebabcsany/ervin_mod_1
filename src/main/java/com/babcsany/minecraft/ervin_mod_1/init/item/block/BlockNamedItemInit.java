package com.babcsany.minecraft.ervin_mod_1.init.item.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.FoodInit;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.AxeItem1;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import com.babcsany.minecraft.ervin_mod_1.item.TeratBlockItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockNamedItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> TARG_SEEDS = ITEMS.register("seeds/targ_seeds", () -> new BlockNamedItem(
            BlockInit.TARG_STAGE.get(), (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRG = ITEMS.register("firg", () -> new BlockNamedItem(
            BlockInit.FIRG.get(), (new Item.Properties()).isBurnable().food(FoodInit.FIRG)
    ));
    public static final RegistryObject<Item> FIRG_SLAB = ITEMS.register("firg_slab", () -> new BlockNamedItem(
            BlockInit.FIRG_SLAB.get(), (new Item.Properties()).isBurnable().food(FoodInit.FIRG_SLAB)
    ));
    public static final RegistryObject<Item> FIRG_STAIRS = ITEMS.register("firg_stairs", () -> new BlockNamedItem(
            BlockInit.FIRG_STAIRS.get(), (new Item.Properties()).isBurnable().food(FoodInit.FIRG_STAIRS)
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
    public static final RegistryObject<Item> SCRAFTH = ITEMS.register("scrafth", () -> new BlockNamedItem(
            BlockInit.SCRAFTH.get(), (new Item.Properties()).food(FoodInit.SCRAFTH)
    ));
    public static final RegistryObject<Item> VIRK_BLOCK = ITEMS.register("virk_block", () -> new BlockNamedItem(
            BlockInit.VIRK_BLOCK.get(), (new Item.Properties()).isBurnable().food(FoodInit.VIRK_BLOCK)
    ));
}
