package com.babcsany.minecraft.ervin_mod_1.init.item.tool;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import com.babcsany.minecraft.ervin_mod_1.item.food.Foods;
import com.babcsany.minecraft.ervin_mod_1.item.tool.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolItemInit {

    public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> DURT_AXE = TOOLS.register("durt_axe", () -> new AxeItem(ModItemTier.DURT, 14, 2.0F, (new Item.Properties())));
    public static final RegistryObject<Item> DURT_HOE = TOOLS.register("durt_hoe", () -> new HoeItem(ModItemTier.DURT, 1, 0.8F, (new Item.Properties())));
    public static final RegistryObject<Item> DURT_PICKAXE = TOOLS.register("durt_pickaxe", () -> new PickaxeItem(ModItemTier.DURT, 4, 1.0F, (new Item.Properties())));
    public static final RegistryObject<Item> DURT_SHOVEL = TOOLS.register("durt_shovel", () -> new ShovelItem(ModItemTier.DURT, 11, 1.5F, (new Item.Properties())));
    public static final RegistryObject<Item> DURT_SWORD = TOOLS.register("durt_sword", () -> new SwordItem(ModItemTier.DURT, 8, 1.2F, (new Item.Properties())));
    public static final RegistryObject<Item> FIRT_AXE = TOOLS.register("firt_axe", () -> new BurningAxeItem(ModItemTier.FIRT, 16, 21.0F, (new Item.Properties()), 7400));
    public static final RegistryObject<Item> FIRT_HOE = TOOLS.register("firt_hoe", () -> new BurningHoeItem(ModItemTier.FIRT, 2, -1F, (new Item.Properties()), 5000));
    public static final RegistryObject<Item> FIRT_PICKAXE = TOOLS.register("firt_pickaxe", () -> new BurningPickaxeItem(ModItemTier.FIRT, 4, 8.4F, (new Item.Properties()), 7400));
    public static final RegistryObject<Item> FIRT_SHOVEL = TOOLS.register("firt_shovel", () -> new BurningShovelItem(ModItemTier.FIRT, 12, 16.8F, (new Item.Properties()), 2600));
    public static final RegistryObject<Item> FIRT_SWORD = TOOLS.register("firt_sword", () -> new BurningSwordItem(ModItemTier.FIRT, 8, 12.6F, (new Item.Properties()), 4900));
    public static final RegistryObject<Item> KIRT_AXE = TOOLS.register("kirt_axe", () -> new AxeItem(ModItemTier.KIRT, 0.4F, 2.5F, (new Item.Properties()).food(Foods.VIRK)));
    public static final RegistryObject<Item> KIRT_HOE = TOOLS.register("kirt_hoe", () -> new HoeItem(ModItemTier.KIRT, 0, 0.5F, (new Item.Properties())));
    public static final RegistryObject<Item> KIRT_PICKAXE = TOOLS.register("kirt_pickaxe", () -> new PickaxeItem(ModItemTier.KIRT, 0, 1.0F, (new Item.Properties())));
    public static final RegistryObject<Item> KIRT_SHOVEL = TOOLS.register("kirt_shovel", () -> new ShovelItem(ModItemTier.KIRT, 0.3F, 2.0F, (new Item.Properties())));
    public static final RegistryObject<Item> KIRT_SWORD = TOOLS.register("kirt_sword", () -> new SwordItem(ModItemTier.KIRT, 1, 1.5F, (new Item.Properties())));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = TOOLS.register("obsidian_pickaxe", () -> new PickaxeItem(ModItemTier.OBSIDIAN, 2, -2.0F, (new Item.Properties())));
    public static final RegistryObject<Item> SURV_AXE = TOOLS.register("surv_axe", () -> new AxeItem(ModItemTier.SURV, 30, 10.0F, (new Item.Properties())));
    public static final RegistryObject<Item> SURV_HOE = TOOLS.register("surv_hoe", () -> new HoeItem(ModItemTier.SURV, 5, 2F, (new Item.Properties())));
    public static final RegistryObject<Item> SURV_PICKAXE = TOOLS.register("surv_pickaxe", () -> new PickaxeItem(ModItemTier.SURV, 10, 3.0F, (new Item.Properties())));
    public static final RegistryObject<Item> SURV_SHOVEL = TOOLS.register("surv_shovel", () -> new ShovelItem(ModItemTier.SURV, 20, 5.0F, (new Item.Properties())));
    public static final RegistryObject<Item> SURV_SWORD = TOOLS.register("surv_sword", () -> new SwordItem(ModItemTier.SURV, 15, 8.0F, (new Item.Properties())));
}
