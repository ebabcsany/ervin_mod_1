package com.babcsany.minecraft.ervin_mod_1.init.item.armor;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableArmorItemInit {

    public static final DeferredRegister<Item> BURNABLE_ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Item> DURG_BOOTS = BURNABLE_ARMOR.register("durg_boots", () -> new ArmorItem(ModArmorMaterial.DURG, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DURG_CHESTPLATE = BURNABLE_ARMOR.register("durg_chestplate", () -> new ArmorItem(ModArmorMaterial.DURG, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DURG_HELMET = BURNABLE_ARMOR.register("durg_helmet", () -> new ArmorItem(ModArmorMaterial.DURG, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> DURG_LEGGINGS = BURNABLE_ARMOR.register("durg_leggings", () -> new ArmorItem(ModArmorMaterial.DURG, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRIUNK_BOOTS = BURNABLE_ARMOR.register("sriunk_boots", () -> new ArmorItem(ModArmorMaterial.SRIUNK, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRIUNK_CHESTPLATE = BURNABLE_ARMOR.register("sriunk_chestplate", () -> new ArmorItem(ModArmorMaterial.SRIUNK, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRIUNK_HELMET = BURNABLE_ARMOR.register("sriunk_helmet", () -> new ArmorItem(ModArmorMaterial.SRIUNK, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> SRIUNK_LEGGINGS = BURNABLE_ARMOR.register("sriunk_leggings", () -> new ArmorItem(ModArmorMaterial.SRIUNK, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> NIRK_BOOTS = BURNABLE_ARMOR.register("nirk_boots", () -> new ArmorItem(ModArmorMaterial.NIRK, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> NIRK_CHESTPLATE = BURNABLE_ARMOR.register("nirk_chestplate", () -> new ArmorItem(ModArmorMaterial.NIRK, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> NIRK_HELMET = BURNABLE_ARMOR.register("nirk_helmet", () -> new ArmorItem(ModArmorMaterial.NIRK, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> NIRK_LEGGINGS = BURNABLE_ARMOR.register("nirk_leggings", () -> new ArmorItem(ModArmorMaterial.NIRK, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT_BOOTS = BURNABLE_ARMOR.register("terat/terat_boots", () -> new ArmorItem(ModArmorMaterial.TERAT, EquipmentSlotType.FEET, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT_CHESTPLATE = BURNABLE_ARMOR.register("terat/terat_chestplate", () -> new ArmorItem(ModArmorMaterial.TERAT, EquipmentSlotType.CHEST, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT_HELMET = BURNABLE_ARMOR.register("terat/terat_helmet", () -> new ArmorItem(ModArmorMaterial.TERAT, EquipmentSlotType.HEAD, (new Item.Properties()).isBurnable()));
    public static final RegistryObject<Item> TERAT_LEGGINGS = BURNABLE_ARMOR.register("terat/terat_leggings", () -> new ArmorItem(ModArmorMaterial.TERAT, EquipmentSlotType.LEGS, (new Item.Properties()).isBurnable()));
}
