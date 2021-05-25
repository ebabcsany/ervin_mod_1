package com.babcsany.minecraft.ervin_mod_1.init.item.tool;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.*;
import net.minecraft.item.*;
import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableToolItemInit {

    public static final DeferredRegister<Item> BURNABLE_TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> Bj_PICKAXE = BURNABLE_TOOLS.register("bj_pickaxe", () -> new com.babcsany.minecraft.ervin_mod_1.item.PickaxeItem(ModItemTier.Bj, 2, 6.2F, (new Item.Properties())));
    public static final RegistryObject<Item> DURG_AXE = BURNABLE_TOOLS.register("durg_axe", () -> new AxeItem(ModItemTier.DURG, 144, 189.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DURG_HOE = BURNABLE_TOOLS.register("durg_hoe", () -> new HoeItem(ModItemTier.DURG, 5, 10F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DURG_PICKAXE = BURNABLE_TOOLS.register("durg_pickaxe", () -> new PickaxeItem(ModItemTier.DURG, 36, 75.6F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DURG_SHOVEL = BURNABLE_TOOLS.register("durg_shovel", () -> new ShovelItem(ModItemTier.DURG, 108, 151.2F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DURG_SWORD = BURNABLE_TOOLS.register("durg_sword", () -> new SwordItem(ModItemTier.DURG, 72, 113.4F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> NIRK_AXE = BURNABLE_TOOLS.register("nirk_axe", () -> new AxeItem(ModItemTier.NIRK, 160, 320.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> NIRK_HOE = BURNABLE_TOOLS.register("nirk_hoe", () -> new HoeItem(ModItemTier.NIRK, 50, 64.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> NIRK_PICKAXE = BURNABLE_TOOLS.register("nirk_pickaxe", () -> new PickaxeItem(ModItemTier.NIRK, 50, 105.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> NIRK_SHOVEL = BURNABLE_TOOLS.register("nirk_shovel", () -> new ShovelItem(ModItemTier.NIRK, 120, 160.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> NIRK_SWORD = BURNABLE_TOOLS.register("nirk_sword", () -> new SwordItem(ModItemTier.NIRK, 80, 256.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRIUNK_AXE = BURNABLE_TOOLS.register("sriunk_axe", () -> new AxeItem(ModItemTier.SRIUNK, 20, 40.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRIUNK_HOE = BURNABLE_TOOLS.register("sriunk_hoe", () -> new HoeItem(ModItemTier.SRIUNK, 6, 4.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRIUNK_PICKAXE = BURNABLE_TOOLS.register("sriunk_pickaxe", () -> new PickaxeItem(ModItemTier.SRIUNK, 8, 22.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRIUNK_SHOVEL = BURNABLE_TOOLS.register("sriunk_shovel", () -> new ShovelItem(ModItemTier.SRIUNK, 12, 30.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRIUNK_SWORD = BURNABLE_TOOLS.register("sriunk_sword", () -> new SwordItem(ModItemTier.SRIUNK, 15, 36.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRURG_AXE = BURNABLE_TOOLS.register("srurg_axe", () -> new AxeItem(ModItemTier.SRURG, 6725, 3540.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRURG_HOE = BURNABLE_TOOLS.register("srurg_hoe", () -> new HoeItem(ModItemTier.SRURG, 461, 268.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRURG_PICKAXE = BURNABLE_TOOLS.register("srurg_pickaxe", () -> new PickaxeItem(ModItemTier.SRURG, 1356, 814.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRURG_SHOVEL = BURNABLE_TOOLS.register("srurg_shovel", () -> new ShovelItem(ModItemTier.SRURG, 4167, 2232.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRURG_SWORD = BURNABLE_TOOLS.register("srurg_sword", () -> new SwordItem(ModItemTier.SRURG, 2713, 1619.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT_AXE = BURNABLE_TOOLS.register("terat_axe", () -> new AxeItem(ModItemTier.TERAT, 450,200.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT_HOE = BURNABLE_TOOLS.register("terat_hoe", () -> new HoeItem(ModItemTier.TERAT, 150, 50.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT_PICKAXE = BURNABLE_TOOLS.register("terat_pickaxe", () -> new PickaxeItem(ModItemTier.TERAT, 250,100.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT_SHOVEL = BURNABLE_TOOLS.register("terat_shovel", () -> new ShovelItem(ModItemTier.TERAT, 350,150.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT_SWORD = BURNABLE_TOOLS.register("terat_sword", () -> new SwordItem(ModItemTier.TERAT, 300, 60.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DEBUG_TERAT_AXE = BURNABLE_TOOLS.register("debug_terat_axe", () -> new DebugAxeItem(ModItemTier.TERAT, 450,200.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DEBUG_TERAT_HOE = BURNABLE_TOOLS.register("debug_terat_hoe", () -> new DebugHoeItem(ModItemTier.TERAT, 150, 50.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DEBUG_TERAT_PICKAXE = BURNABLE_TOOLS.register("debug_terat_pickaxe", () -> new DebugPickaxeItem(ModItemTier.TERAT, 250,100.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DEBUG_TERAT_SHOVEL = BURNABLE_TOOLS.register("debug_terat_shovel", () -> new DebugShovelItem(ModItemTier.TERAT, 350,150.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DEBUG_TERAT_SWORD = BURNABLE_TOOLS.register("debug_terat_sword", () -> new DebugSwordItem(ModItemTier.TERAT, 300, 60.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TGURN_AXE = BURNABLE_TOOLS.register("tgurn_axe", () -> new AxeItem(ModItemTier.TGURN, 11700000, 7290000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TGURN_HOE = BURNABLE_TOOLS.register("tgurn_hoe", () -> new HoeItem(ModItemTier.TGURN, 2340000, 1458000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TGURN_PICKAXE = BURNABLE_TOOLS.register("tgurn_pickaxe", () -> new PickaxeItem(ModItemTier.TGURN, 4680000, 2916000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TGURN_SHOVEL = BURNABLE_TOOLS.register("tgurn_shovel", () -> new ShovelItem(ModItemTier.TGURN, 9360000, 5832000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TGURN_SWORD = BURNABLE_TOOLS.register("tgurn_sword", () -> new SwordItem(ModItemTier.TGURN, 7020000, 4374000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRAGN_AXE = BURNABLE_TOOLS.register("tragn_axe", () -> new AxeItem(ModItemTier.TRAGN, 650000, 405000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRAGN_HOE = BURNABLE_TOOLS.register("tragn_hoe", () -> new HoeItem(ModItemTier.TRAGN, 130000, 81000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRAGN_PICKAXE = BURNABLE_TOOLS.register("tragn_pickaxe", () -> new PickaxeItem(ModItemTier.TRAGN, 260000, 162000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRAGN_SHOVEL = BURNABLE_TOOLS.register("tragn_shovel", () -> new ShovelItem(ModItemTier.TRAGN, 520000, 324000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRAGN_SWORD = BURNABLE_TOOLS.register("tragn_sword", () -> new SwordItem(ModItemTier.TRAGN, 390000, 243000.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUGN_AXE = BURNABLE_TOOLS.register("trugn_axe", () -> new AxeItem(ModItemTier.TRUGN, 6500, 4050.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUGN_HOE = BURNABLE_TOOLS.register("trugn_hoe", () -> new HoeItem(ModItemTier.TRUGN, 1300, 810.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUGN_PICKAXE = BURNABLE_TOOLS.register("trugn_pickaxe", () -> new PickaxeItem(ModItemTier.TRUGN, 2600, 1620.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUGN_SHOVEL = BURNABLE_TOOLS.register("trugn_shovel", () -> new ShovelItem(ModItemTier.TRUGN, 5200, 3240.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUGN_SWORD = BURNABLE_TOOLS.register("trugn_sword", () -> new SwordItem(ModItemTier.TRUGN, 3900, 2430.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUZN_AXE = BURNABLE_TOOLS.register("truzn_axe", () -> new AxeItem(ModItemTier.TRUZN, 65000, 40500.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUZN_HOE = BURNABLE_TOOLS.register("truzn_hoe", () -> new HoeItem(ModItemTier.TRUZN, 13000, 8100.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUZN_PICKAXE = BURNABLE_TOOLS.register("truzn_pickaxe", () -> new PickaxeItem(ModItemTier.TRUGN, 26000, 16200.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUZN_SHOVEL = BURNABLE_TOOLS.register("truzn_shovel", () -> new ShovelItem(ModItemTier.TRUZN, 52000, 32400.0F, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TRUZN_SWORD = BURNABLE_TOOLS.register("truzn_sword", () -> new SwordItem(ModItemTier.TRUZN, 39000, 24300.0F, (new Item.Properties()).isBurnable()));

}