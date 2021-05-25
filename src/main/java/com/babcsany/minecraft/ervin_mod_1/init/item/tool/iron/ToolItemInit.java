package com.babcsany.minecraft.ervin_mod_1.init.item.tool.iron;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolItemInit {

    public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> BLACK_IRON_AXE = TOOLS.register("tools/iron/axe/black_iron_axe", () -> new AxeItem(ModItemTier.BLACK_IRON_INGOT, 6.0F, -3.1F, (new Item.Properties())));
    public static final RegistryObject<Item> BLACK_IRON_HOE = TOOLS.register("tools/iron/hoe/black_iron_hoe", () -> new HoeItem(ModItemTier.BLACK_IRON_INGOT, -2, -1.0F, (new Item.Properties())));
    public static final RegistryObject<Item> BLACK_IRON_PICKAXE = TOOLS.register("tools/iron/pickaxe/black_iron_pickaxe", () -> new PickaxeItem(ModItemTier.BLACK_IRON_INGOT, 1, -2.8F, (new Item.Properties())));
    public static final RegistryObject<Item> BLACK_IRON_SHOVEL = TOOLS.register("tools/iron/shovel/black_iron_shovel", () -> new ShovelItem(ModItemTier.BLACK_IRON_INGOT,1.5F, -3.0F, (new Item.Properties())));
    public static final RegistryObject<Item> BLACK_IRON_SWORD = TOOLS.register("tools/iron/sword/black_iron_sword", () -> new SwordItem(ModItemTier.BLACK_IRON_INGOT, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> BLUE_IRON_AXE = TOOLS.register("tools/iron/axe/blue_iron_axe", () -> new AxeItem(ModItemTier.BLUE_IRON_INGOT, 6.0F, -3.1F, (new Item.Properties())));
    public static final RegistryObject<Item> BLUE_IRON_HOE = TOOLS.register("tools/iron/hoe/blue_iron_hoe", () -> new HoeItem(ModItemTier.BLUE_IRON_INGOT, -2, -1.0F, (new Item.Properties())));
    public static final RegistryObject<Item> BLUE_IRON_PICKAXE = TOOLS.register("tools/iron/pickaxe/blue_iron_pickaxe", () -> new PickaxeItem(ModItemTier.BLUE_IRON_INGOT, 1, -2.8F, (new Item.Properties())));
    public static final RegistryObject<Item> BLUE_IRON_SHOVEL = TOOLS.register("tools/iron/shovel/blue_iron_shovel", () -> new ShovelItem(ModItemTier.BLUE_IRON_INGOT,1.5F, -3.0F, (new Item.Properties())));
    public static final RegistryObject<Item> BLUE_IRON_SWORD = TOOLS.register("tools/iron/sword/blue_iron_sword", () -> new SwordItem(ModItemTier.BLUE_IRON_INGOT, 3, -2.4F, (new Item.Properties())));
    public static final RegistryObject<Item> RED_IRON_AXE = TOOLS.register("tools/iron/axe/red_iron_axe", () -> new AxeItem(ModItemTier.RED_IRON_INGOT, 6.0F, -3.1F, (new Item.Properties())));
    public static final RegistryObject<Item> RED_IRON_HOE = TOOLS.register("tools/iron/hoe/red_iron_hoe", () -> new HoeItem(ModItemTier.RED_IRON_INGOT, -2, -1.0F, (new Item.Properties())));
    public static final RegistryObject<Item> RED_IRON_PICKAXE = TOOLS.register("tools/iron/pickaxe/red_iron_pickaxe", () -> new PickaxeItem(ModItemTier.RED_IRON_INGOT, 1, -2.8F, (new Item.Properties())));
    public static final RegistryObject<Item> RED_IRON_SHOVEL = TOOLS.register("tools/iron/shovel/red_iron_shovel", () -> new ShovelItem(ModItemTier.RED_IRON_INGOT,1.5F, -3.0F, (new Item.Properties())));
    public static final RegistryObject<Item> RED_IRON_SWORD = TOOLS.register("tools/iron/sword/red_iron_sword", () -> new SwordItem(ModItemTier.RED_IRON_INGOT, 3, -2.4F, (new Item.Properties())));
}
