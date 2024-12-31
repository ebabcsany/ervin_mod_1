package com.babcsany.minecraft.ervin_mod_1.init.item.armor.iron;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ModArmorMaterial;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IronArmorItemInit {

    public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item.Properties PROPERTIES = new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH);
    public static final RegistryObject<Item> BLACK_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "black", () -> new ArmorItem(ModArmorMaterial.BLACK_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> BLACK_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "black", () -> new ArmorItem(ModArmorMaterial.BLACK_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> BLACK_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "black", () -> new ArmorItem(ModArmorMaterial.BLACK_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> BLACK_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "black", () -> new ArmorItem(ModArmorMaterial.BLACK_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> BLUE_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "blue", () -> new ArmorItem(ModArmorMaterial.BLUE_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> BLUE_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "blue", () -> new ArmorItem(ModArmorMaterial.BLUE_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> BLUE_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "blue", () -> new ArmorItem(ModArmorMaterial.BLUE_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> BLUE_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "blue", () -> new ArmorItem(ModArmorMaterial.BLUE_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> BROWN_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "brown", () -> new ArmorItem(ModArmorMaterial.BROWN_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> BROWN_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "brown", () -> new ArmorItem(ModArmorMaterial.BROWN_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> BROWN_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "brown", () -> new ArmorItem(ModArmorMaterial.BROWN_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> BROWN_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "brown", () -> new ArmorItem(ModArmorMaterial.BROWN_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> CYAN_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "cyan", () -> new ArmorItem(ModArmorMaterial.CYAN_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> CYAN_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "cyan", () -> new ArmorItem(ModArmorMaterial.CYAN_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> CYAN_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "cyan", () -> new ArmorItem(ModArmorMaterial.CYAN_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> CYAN_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "cyan", () -> new ArmorItem(ModArmorMaterial.CYAN_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> GRAY_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "gray", () -> new ArmorItem(ModArmorMaterial.GRAY_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> GRAY_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "gray", () -> new ArmorItem(ModArmorMaterial.GRAY_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> GRAY_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "gray", () -> new ArmorItem(ModArmorMaterial.GRAY_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> GRAY_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "gray", () -> new ArmorItem(ModArmorMaterial.GRAY_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> GREEN_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "green", () -> new ArmorItem(ModArmorMaterial.GREEN_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> GREEN_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "green", () -> new ArmorItem(ModArmorMaterial.GREEN_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> GREEN_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "green", () -> new ArmorItem(ModArmorMaterial.GREEN_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> GREEN_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "green", () -> new ArmorItem(ModArmorMaterial.GREEN_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "light_blue", () -> new ArmorItem(ModArmorMaterial.LIGHT_BLUE_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "light_blue", () -> new ArmorItem(ModArmorMaterial.LIGHT_BLUE_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "light_blue", () -> new ArmorItem(ModArmorMaterial.LIGHT_BLUE_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_BLUE_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "light_blue", () -> new ArmorItem(ModArmorMaterial.LIGHT_BLUE_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_BLUE1_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "light_blue1", () -> new ArmorItem(ModArmorMaterial.LIGHT_BLUE1_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_BLUE1_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "light_blue1", () -> new ArmorItem(ModArmorMaterial.LIGHT_BLUE1_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_BLUE1_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "light_blue1", () -> new ArmorItem(ModArmorMaterial.LIGHT_BLUE1_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_BLUE1_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "light_blue1", () -> new ArmorItem(ModArmorMaterial.LIGHT_BLUE1_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "light_gray", () -> new ArmorItem(ModArmorMaterial.LIGHT_GRAY_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "light_gray", () -> new ArmorItem(ModArmorMaterial.LIGHT_GRAY_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "light_gray", () -> new ArmorItem(ModArmorMaterial.LIGHT_GRAY_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> LIGHT_GRAY_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "light_gray", () -> new ArmorItem(ModArmorMaterial.LIGHT_GRAY_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> LIME_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "lime", () -> new ArmorItem(ModArmorMaterial.LIME_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> LIME_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "lime", () -> new ArmorItem(ModArmorMaterial.LIME_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> LIME_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "lime", () -> new ArmorItem(ModArmorMaterial.LIME_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> LIME_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "lime", () -> new ArmorItem(ModArmorMaterial.LIME_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> MAGENTA_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "magenta", () -> new ArmorItem(ModArmorMaterial.MAGENTA_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> MAGENTA_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "magenta", () -> new ArmorItem(ModArmorMaterial.MAGENTA_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> MAGENTA_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "magenta", () -> new ArmorItem(ModArmorMaterial.MAGENTA_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> MAGENTA_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "magenta", () -> new ArmorItem(ModArmorMaterial.MAGENTA_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> ORANGE_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "orange", () -> new ArmorItem(ModArmorMaterial.ORANGE_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> ORANGE_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "orange", () -> new ArmorItem(ModArmorMaterial.ORANGE_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> ORANGE_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "orange", () -> new ArmorItem(ModArmorMaterial.ORANGE_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> ORANGE_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "orange", () -> new ArmorItem(ModArmorMaterial.ORANGE_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> PINK_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "pink", () -> new ArmorItem(ModArmorMaterial.PINK_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> PINK_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "pink", () -> new ArmorItem(ModArmorMaterial.PINK_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> PINK_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "pink", () -> new ArmorItem(ModArmorMaterial.PINK_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> PINK_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "pink", () -> new ArmorItem(ModArmorMaterial.PINK_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> PURPLE_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "purple", () -> new ArmorItem(ModArmorMaterial.PURPLE_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> PURPLE_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "purple", () -> new ArmorItem(ModArmorMaterial.PURPLE_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> PURPLE_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "purple", () -> new ArmorItem(ModArmorMaterial.PURPLE_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> PURPLE_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "purple", () -> new ArmorItem(ModArmorMaterial.PURPLE_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> RED_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "red", () -> new ArmorItem(ModArmorMaterial.RED_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> RED_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "red", () -> new ArmorItem(ModArmorMaterial.RED_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> RED_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "red", () -> new ArmorItem(ModArmorMaterial.RED_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> RED_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "red", () -> new ArmorItem(ModArmorMaterial.RED_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> WHITE_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "white", () -> new ArmorItem(ModArmorMaterial.WHITE_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> WHITE_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "white", () -> new ArmorItem(ModArmorMaterial.WHITE_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> WHITE_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "white", () -> new ArmorItem(ModArmorMaterial.WHITE_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> WHITE_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "white", () -> new ArmorItem(ModArmorMaterial.WHITE_IRON, EquipmentSlotType.FEET, PROPERTIES));
    public static final RegistryObject<Item> YELLOW_IRON_HELMET = ARMOR.register("armor/" + "helmet" + "/" + "iron/" + "yellow", () -> new ArmorItem(ModArmorMaterial.YELLOW_IRON, EquipmentSlotType.HEAD, PROPERTIES));
    public static final RegistryObject<Item> YELLOW_IRON_CHESTPLATE = ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + "yellow", () -> new ArmorItem(ModArmorMaterial.YELLOW_IRON, EquipmentSlotType.CHEST, PROPERTIES));
    public static final RegistryObject<Item> YELLOW_IRON_LEGGINGS = ARMOR.register("armor/" + "leggings" + "/" + "iron/" + "yellow", () -> new ArmorItem(ModArmorMaterial.YELLOW_IRON, EquipmentSlotType.LEGS, PROPERTIES));
    public static final RegistryObject<Item> YELLOW_IRON_BOOTS = ARMOR.register("armor/" + "boots" + "/" + "iron/" + "yellow", () -> new ArmorItem(ModArmorMaterial.YELLOW_IRON, EquipmentSlotType.FEET, PROPERTIES));

    public static RegistryObject<Item> ironHelmetRegister(String name, IArmorMaterial materialIn) {
        Item.Properties properties = new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH);
        return ARMOR.register("armor/" + "helmet" + "/" + "iron/" + name, () -> new ArmorItem(materialIn, EquipmentSlotType.HEAD, properties));
    }
    
    public static RegistryObject<Item> ironChestplateRegister(String name, IArmorMaterial materialIn) {
        Item.Properties properties = new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH);
        return ARMOR.register("armor/" + "chestplate" + "/" + "iron/" + name, () -> new ArmorItem(materialIn, EquipmentSlotType.CHEST, properties));
    }
    
    public static RegistryObject<Item> ironLeggingsRegister(String name, IArmorMaterial materialIn) {
        Item.Properties properties = new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH);
        return ARMOR.register("armor/" + "leggings" + "/" + "iron/" + name, () -> new ArmorItem(materialIn, EquipmentSlotType.LEGS, properties));
    }
    
    public static RegistryObject<Item> ironBootsRegister(String name, IArmorMaterial materialIn) {
        Item.Properties properties = new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH);
        return ARMOR.register("armor/" + "boots" + "/" + "iron/" + name, () -> new ArmorItem(materialIn, EquipmentSlotType.FEET, properties));
    }

    public static RegistryObject<Item> register(String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties) {
        return ARMOR.register(name, () -> new ArmorItem(materialIn, slot, properties));
    }

    public static RegistryObject<Item> armorHelmetRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return ARMOR.register("armor/" + "helmet" + "/" + name, () -> new ArmorItem(materialIn, EquipmentSlotType.HEAD, properties));
    }

    public static RegistryObject<Item> armorChestplateRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return ARMOR.register("armor/" + "chestplate" + "/" + name, () -> new ArmorItem(materialIn, EquipmentSlotType.CHEST, properties));
    }

    public static RegistryObject<Item> armorLeggingsRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return ARMOR.register("armor/" + "leggings" + "/" + name, () -> new ArmorItem(materialIn, EquipmentSlotType.LEGS, properties));
    }

    public static RegistryObject<Item> armorBootsRegister(String name, IArmorMaterial materialIn, Item.Properties properties) {
        return ARMOR.register("armor/" + "boots" + "/" + name, () -> new ArmorItem(materialIn, EquipmentSlotType.FEET, properties));
    }

    public static RegistryObject<Item> armorRegister(String type, String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties) {
        return ARMOR.register("armor/" + type + "/" + name, () -> new ArmorItem(materialIn, slot, properties));
    }

    public static RegistryObject<Item> armorRegister(String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties) {
        return ARMOR.register(name, () -> new ArmorItem(materialIn, slot, properties));
    }
    
    public static void register() {
        Ervin_mod_1.register(IronArmorItemInit.class);
    }
}
