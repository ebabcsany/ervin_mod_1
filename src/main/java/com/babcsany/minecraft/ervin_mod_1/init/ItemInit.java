package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ModArmorMaterial;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> SRIUNK_PICKAXE = ITEMS.register("sriunk_pickaxe", () -> new PickaxeItem(
            ModItemTier.SRIUNK, 8, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK = ITEMS.register("sriunk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_AXE = ITEMS.register("sriunk_axe", () -> new AxeItem(
            ModItemTier.SRIUNK, 20, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_HOE = ITEMS.register("sriunk_hoe", () -> new HoeItem(
            ModItemTier.SRIUNK, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_SHOVEL = ITEMS.register("sriunk_shovel", () -> new ShovelItem(
            ModItemTier.SRIUNK, 3, -2.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_SWORD = ITEMS.register("sriunk_sword", () -> new SwordItem(
            ModItemTier.SRIUNK, 10, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_HELMET = ITEMS.register("sriunk_helmet", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.HEAD, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_CHESTPLATE = ITEMS.register("sriunk_chestplate", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.CHEST, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_LEGGINGS = ITEMS.register("sriunk_leggings", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.LEGS, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_BOOTS = ITEMS.register("sriunk_boots", () -> new ArmorItem(
            ModArmorMaterial.SRIUNK, EquipmentSlotType.FEET, (new Item.Properties())
    ));
    public static final RegistryObject<Item> VILTDROP = ITEMS.register("viltdrop", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_STICK = ITEMS.register("sriunk_stick", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> REGDEM = ITEMS.register("regdem", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> DREIN = ITEMS.register("drein", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> NIRG = ITEMS.register("nirg", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT = ITEMS.register("kirt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> KIRT_STIK = ITEMS.register("kirt_stik", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> LEAT = ITEMS.register("leat", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRET = ITEMS.register("gret", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> CRAINT = ITEMS.register("craint", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> NARIN = ITEMS.register("narin", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT = ITEMS.register("terat", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_PICKAXE = ITEMS.register("terat_pickaxe", () -> new PickaxeItem(
            ModItemTier.TERAT, 200,10.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> PLMK = ITEMS.register("plmk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_AXE = ITEMS.register("terat_axe", () -> new AxeItem(
            ModItemTier.TERAT, 400,20.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_SHOVEL = ITEMS.register("terat_shovel", () -> new ShovelItem(
            ModItemTier.TERAT, 300,15.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_HOE = ITEMS.register("terat_hoe", () -> new HoeItem(
            ModItemTier.TERAT, -6.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> SRIUNK_HORSE_ARMOR = ITEMS.register("sriunk_horse_armor", () -> new HorseArmorItem(
            44, new ResourceLocation(Ervin_mod_1.MOD_ID, "textures/entity/horse/armor/sriunk_horse_armor.png"), (new Item.Properties()).maxStackSize(1).group(ItemGroup.MISC)
    ));
    public static final RegistryObject<Item> TERAT_SWORD = ITEMS.register("terat_sword", () -> new SwordItem(
            ModItemTier.SRIUNK, 10, -3.0F, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_HELMET = ITEMS.register("terat_helmet", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.HEAD, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_CHESTPLATE = ITEMS.register("terat_chestplate", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.CHEST, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_LEGGINGS = ITEMS.register("terat_leggings", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.LEGS, (new Item.Properties())
    ));
    public static final RegistryObject<Item> TERAT_BOOTS = ITEMS.register("terat_boots", () -> new ArmorItem(
            ModArmorMaterial.TERAT, EquipmentSlotType.FEET, (new Item.Properties())
    ));
    public static final RegistryObject<Item> NIRK = ITEMS.register("nirk", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> FRIM = ITEMS.register("frim", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> FRIN = ITEMS.register("frin", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRT = ITEMS.register("firt", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> FIRN = ITEMS.register("firn", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> GRINT = ITEMS.register("grint", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> BREND = ITEMS.register("brend", () -> new Item(
            (new Item.Properties())
    ));
    public static final RegistryObject<Item> SIRK = ITEMS.register("sirk", () -> new Item(
            (new Item.Properties())
    ));
}