package com.babcsany.minecraft.ervin_mod_1.init.item.armor;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.BurningArmorItem;
import com.babcsany.minecraft.ervin_mod_1.item.ModArmorMaterial;
import com.babcsany.minecraft.ervin_mod_1.item.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmorItemInit {

    public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> FIRT_BOOTS = ARMOR.register("firt_boots", () -> new BurningArmorItem(ModArmorMaterial.FIRT, EquipmentSlotType.FEET, (new Item.Properties()),9600));
    public static final RegistryObject<Item> FIRT_CHESTPLATE = ARMOR.register("firt_chestplate", () -> new BurningArmorItem(ModArmorMaterial.FIRT, EquipmentSlotType.CHEST, (new Item.Properties()),19200));
    public static final RegistryObject<Item> FIRT_HELMET = ARMOR.register("firt_helmet", () -> new BurningArmorItem(ModArmorMaterial.FIRT, EquipmentSlotType.HEAD, (new Item.Properties()),12000));
    public static final RegistryObject<Item> FIRT_LEGGINGS = ARMOR.register("firt_leggings", () -> new BurningArmorItem(ModArmorMaterial.FIRT, EquipmentSlotType.LEGS, (new Item.Properties()),16800));
}
