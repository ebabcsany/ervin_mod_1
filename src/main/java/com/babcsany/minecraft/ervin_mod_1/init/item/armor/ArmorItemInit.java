package com.babcsany.minecraft.ervin_mod_1.init.item.armor;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedItemInit;
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

    public static RegistryObject<Item> helmetRegister(String name, Item item) {
        return register("helmet", name, item);
    }

    public static RegistryObject<Item> chestplateRegister(String name, Item item) {
        return register("chestplate", name, item);
    }

    public static RegistryObject<Item> leggingsRegister(String name, Item item) {
        return register("leggings", name, item);
    }

    public static RegistryObject<Item> bootsRegister(String name, Item item) {
        return register("boots", name, item);
    }

    public static RegistryObject<Item> armorHelmetRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return armorRegister("helmet", name, materialIn, EquipmentSlotType.HEAD, properties);
    }

    public static RegistryObject<Item> armorChestplateRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return armorRegister("chestplate", name, materialIn, EquipmentSlotType.CHEST, properties);
    }

    public static RegistryObject<Item> armorLeggingsRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return armorRegister("leggings", name, materialIn, EquipmentSlotType.LEGS, properties);
    }

    public static RegistryObject<Item> armorBootsRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return armorRegister("boots", name, materialIn, EquipmentSlotType.FEET, properties);
    }

    public static RegistryObject<Item> armorRegister(String type, String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties) {
        return armorRegister("armor/" + type + "/" + name, materialIn, slot, properties);
    }

    public static RegistryObject<Item> register(String type, String name, Item item) {
        return register("armor/" + type + "/" + name, item);
    }

    public static RegistryObject<Item> armorRegister(String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties) {
        return ARMOR.register(name, () -> new ArmorItem(materialIn, slot, properties));
    }

    public static RegistryObject<Item> register(String name, Item item) {
        return ARMOR.register(name, () -> item);
    }
}
