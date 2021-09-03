package com.babcsany.minecraft.ervin_mod_1.init.item.armor;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.burning.armor.firt.FirtBoots;
import com.babcsany.minecraft.ervin_mod_1.item.burning.armor.firt.FirtChestplate;
import com.babcsany.minecraft.ervin_mod_1.item.burning.armor.firt.FirtHelmet;
import com.babcsany.minecraft.ervin_mod_1.item.ModArmorMaterial;
import com.babcsany.minecraft.ervin_mod_1.item.burning.armor.firt.FirtLeggings;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmorItemInit {

    public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> FIRT_BOOTS = ARMOR.register("firt_boots", () -> new FirtBoots(ModArmorMaterial.FIRT, EquipmentSlotType.FEET, (new Item.Properties())));
    public static final RegistryObject<Item> FIRT_CHESTPLATE = ARMOR.register("firt_chestplate", () -> new FirtChestplate(ModArmorMaterial.FIRT, EquipmentSlotType.CHEST, (new Item.Properties())));
    public static final RegistryObject<Item> FIRT_HELMET = ARMOR.register("firt_helmet", () -> new FirtHelmet(ModArmorMaterial.FIRT, EquipmentSlotType.HEAD, (new Item.Properties())));
    public static final RegistryObject<Item> FIRT_LEGGINGS = ARMOR.register("firt_leggings", () -> new FirtLeggings(ModArmorMaterial.FIRT, EquipmentSlotType.LEGS, (new Item.Properties())));
}
