package com.babcsany.minecraft.ervin_mod_1.init.item.armor;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedItems;
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

    public static final Item FIRT_BOOTS = register("firt_boots", new BurningArmorItem(ModArmorMaterial.FIRT, EquipmentSlotType.FEET, (new Item.Properties()),9600));
    public static final Item FIRT_CHESTPLATE = register("firt_chestplate", new BurningArmorItem(ModArmorMaterial.FIRT, EquipmentSlotType.CHEST, (new Item.Properties()),19200));
    public static final Item FIRT_HELMET = register("firt_helmet", new BurningArmorItem(ModArmorMaterial.FIRT, EquipmentSlotType.HEAD, (new Item.Properties()),12000));
    public static final Item FIRT_LEGGINGS = register("firt_leggings", new BurningArmorItem(ModArmorMaterial.FIRT, EquipmentSlotType.LEGS, (new Item.Properties()),16800));

    public static Item helmetRegister(String name, Item item) {
        return register("helmet", name, item);
    }

    public static Item chestplateRegister(String name, Item item) {
        return register("chestplate", name, item);
    }

    public static Item leggingsRegister(String name, Item item) {
        return register("leggings", name, item);
    }

    public static Item bootsRegister(String name, Item item) {
        return register("boots", name, item);
    }

    public static Item armorHelmetRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return armorRegister("helmet", name, materialIn, EquipmentSlotType.HEAD, properties);
    }

    public static Item armorChestplateRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return armorRegister("chestplate", name, materialIn, EquipmentSlotType.CHEST, properties);
    }

    public static Item armorLeggingsRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return armorRegister("leggings", name, materialIn, EquipmentSlotType.LEGS, properties);
    }

    public static Item armorBootsRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return armorRegister("boots", name, materialIn, EquipmentSlotType.FEET, properties);
    }

    public static Item armorRegister(String type, String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties) {
        return armorRegister("armor/" + type + "/" + name, materialIn, slot, properties);
    }

    public static Item register(String type, String name, Item item) {
        return register("armor/" + type + "/" + name, item);
    }

    public static Item armorRegister(String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties) {
        return UnusedItems.addDefault(name, new ArmorItem(materialIn, slot, properties));
    }

    public static Item register(String name, Item item) {
        return UnusedItems.addDefault(name, item);
    }
}
