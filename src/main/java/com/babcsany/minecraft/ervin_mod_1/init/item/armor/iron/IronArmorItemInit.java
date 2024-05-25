package com.babcsany.minecraft.ervin_mod_1.init.item.armor.iron;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.item.armor.ArmorItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.ModArmorMaterial;
import com.babcsany.minecraft.ervin_mod_1.item.group.ModItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IronArmorItemInit {

    public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, Ervin_mod_1.MOD_ID);

    public static final Item BLACK_IRON_HELMET = ironHelmetRegister("black", ModArmorMaterial.BLACK_IRON);
    public static final Item BLACK_IRON_CHESTPLATE = ironChestplateRegister("black", ModArmorMaterial.BLACK_IRON);
    public static final Item BLACK_IRON_LEGGINGS = ironLeggingsRegister("black", ModArmorMaterial.BLACK_IRON);
    public static final Item BLACK_IRON_BOOTS = ironBootsRegister("black", ModArmorMaterial.BLACK_IRON);
    public static final Item BLUE_IRON_HELMET = ironHelmetRegister("blue", ModArmorMaterial.BLUE_IRON);
    public static final Item BLUE_IRON_CHESTPLATE = ironChestplateRegister("blue", ModArmorMaterial.BLUE_IRON);
    public static final Item BLUE_IRON_LEGGINGS = ironLeggingsRegister("blue", ModArmorMaterial.BLUE_IRON);
    public static final Item BLUE_IRON_BOOTS = ironBootsRegister("blue", ModArmorMaterial.BLUE_IRON);
    public static final Item BROWN_IRON_HELMET = ironHelmetRegister("brown", ModArmorMaterial.BROWN_IRON);
    public static final Item BROWN_IRON_CHESTPLATE = ironChestplateRegister("brown", ModArmorMaterial.BROWN_IRON);
    public static final Item BROWN_IRON_LEGGINGS = ironLeggingsRegister("brown", ModArmorMaterial.BROWN_IRON);
    public static final Item BROWN_IRON_BOOTS = ironBootsRegister("brown", ModArmorMaterial.BROWN_IRON);
    public static final Item CYAN_IRON_HELMET = ironHelmetRegister("cyan", ModArmorMaterial.CYAN_IRON);
    public static final Item CYAN_IRON_CHESTPLATE = ironChestplateRegister("cyan", ModArmorMaterial.CYAN_IRON);
    public static final Item CYAN_IRON_LEGGINGS = ironLeggingsRegister("cyan", ModArmorMaterial.CYAN_IRON);
    public static final Item CYAN_IRON_BOOTS = ironBootsRegister("cyan", ModArmorMaterial.CYAN_IRON);
    public static final Item GRAY_IRON_HELMET = ironHelmetRegister("gray", ModArmorMaterial.GRAY_IRON);
    public static final Item GRAY_IRON_CHESTPLATE = ironChestplateRegister("gray", ModArmorMaterial.GRAY_IRON);
    public static final Item GRAY_IRON_LEGGINGS = ironLeggingsRegister("gray", ModArmorMaterial.GRAY_IRON);
    public static final Item GRAY_IRON_BOOTS = ironBootsRegister("gray", ModArmorMaterial.GRAY_IRON);
    public static final Item GREEN_IRON_HELMET = ironHelmetRegister("green", ModArmorMaterial.GREEN_IRON);
    public static final Item GREEN_IRON_CHESTPLATE = ironChestplateRegister("green", ModArmorMaterial.GREEN_IRON);
    public static final Item GREEN_IRON_LEGGINGS = ironLeggingsRegister("green", ModArmorMaterial.GREEN_IRON);
    public static final Item GREEN_IRON_BOOTS = ironBootsRegister("green", ModArmorMaterial.GREEN_IRON);
    public static final Item LIGHT_BLUE_IRON_HELMET = ironHelmetRegister("light_blue", ModArmorMaterial.LIGHT_BLUE_IRON);
    public static final Item LIGHT_BLUE_IRON_CHESTPLATE = ironChestplateRegister("light_blue", ModArmorMaterial.LIGHT_BLUE_IRON);
    public static final Item LIGHT_BLUE_IRON_LEGGINGS = ironLeggingsRegister("light_blue", ModArmorMaterial.LIGHT_BLUE_IRON);
    public static final Item LIGHT_BLUE_IRON_BOOTS = ironBootsRegister("light_blue", ModArmorMaterial.LIGHT_BLUE_IRON);
    public static final Item LIGHT_BLUE1_IRON_HELMET = ironHelmetRegister("light_blue1", ModArmorMaterial.LIGHT_BLUE1_IRON);
    public static final Item LIGHT_BLUE1_IRON_CHESTPLATE = ironChestplateRegister("light_blue1", ModArmorMaterial.LIGHT_BLUE1_IRON);
    public static final Item LIGHT_BLUE1_IRON_LEGGINGS = ironLeggingsRegister("light_blue1", ModArmorMaterial.LIGHT_BLUE1_IRON);
    public static final Item LIGHT_BLUE1_IRON_BOOTS = ironBootsRegister("light_blue1", ModArmorMaterial.LIGHT_BLUE1_IRON);
    public static final Item LIGHT_GRAY_IRON_HELMET = ironHelmetRegister("light_gray", ModArmorMaterial.LIGHT_GRAY_IRON);
    public static final Item LIGHT_GRAY_IRON_CHESTPLATE = ironChestplateRegister("light_gray", ModArmorMaterial.LIGHT_GRAY_IRON);
    public static final Item LIGHT_GRAY_IRON_LEGGINGS = ironLeggingsRegister("light_gray", ModArmorMaterial.LIGHT_GRAY_IRON);
    public static final Item LIGHT_GRAY_IRON_BOOTS = ironBootsRegister("light_gray", ModArmorMaterial.LIGHT_GRAY_IRON);
    public static final Item LIME_IRON_HELMET = ironHelmetRegister("lime", ModArmorMaterial.LIME_IRON);
    public static final Item LIME_IRON_CHESTPLATE = ironChestplateRegister("lime", ModArmorMaterial.LIME_IRON);
    public static final Item LIME_IRON_LEGGINGS = ironLeggingsRegister("lime", ModArmorMaterial.LIME_IRON);
    public static final Item LIME_IRON_BOOTS = ironBootsRegister("lime", ModArmorMaterial.LIME_IRON);
    public static final Item MAGENTA_IRON_HELMET = ironHelmetRegister("magenta", ModArmorMaterial.MAGENTA_IRON);
    public static final Item MAGENTA_IRON_CHESTPLATE = ironChestplateRegister("magenta", ModArmorMaterial.MAGENTA_IRON);
    public static final Item MAGENTA_IRON_LEGGINGS = ironLeggingsRegister("magenta", ModArmorMaterial.MAGENTA_IRON);
    public static final Item MAGENTA_IRON_BOOTS = ironBootsRegister("magenta", ModArmorMaterial.MAGENTA_IRON);
    public static final Item ORANGE_IRON_HELMET = ironHelmetRegister("orange", ModArmorMaterial.ORANGE_IRON);
    public static final Item ORANGE_IRON_CHESTPLATE = ironChestplateRegister("orange", ModArmorMaterial.ORANGE_IRON);
    public static final Item ORANGE_IRON_LEGGINGS = ironLeggingsRegister("orange", ModArmorMaterial.ORANGE_IRON);
    public static final Item ORANGE_IRON_BOOTS = ironBootsRegister("orange", ModArmorMaterial.ORANGE_IRON);
    public static final Item PINK_IRON_HELMET = ironHelmetRegister("pink", ModArmorMaterial.PINK_IRON);
    public static final Item PINK_IRON_CHESTPLATE = ironChestplateRegister("pink", ModArmorMaterial.PINK_IRON);
    public static final Item PINK_IRON_LEGGINGS = ironLeggingsRegister("pink", ModArmorMaterial.PINK_IRON);
    public static final Item PINK_IRON_BOOTS = ironBootsRegister("pink", ModArmorMaterial.PINK_IRON);
    public static final Item PURPLE_IRON_HELMET = ironHelmetRegister("purple", ModArmorMaterial.PURPLE_IRON);
    public static final Item PURPLE_IRON_CHESTPLATE = ironChestplateRegister("purple", ModArmorMaterial.PURPLE_IRON);
    public static final Item PURPLE_IRON_LEGGINGS = ironLeggingsRegister("purple", ModArmorMaterial.PURPLE_IRON);
    public static final Item PURPLE_IRON_BOOTS = ironBootsRegister("purple", ModArmorMaterial.PURPLE_IRON);
    public static final Item RED_IRON_HELMET = ironHelmetRegister("red", ModArmorMaterial.RED_IRON);
    public static final Item RED_IRON_CHESTPLATE = ironChestplateRegister("red", ModArmorMaterial.RED_IRON);
    public static final Item RED_IRON_LEGGINGS = ironLeggingsRegister("red", ModArmorMaterial.RED_IRON);
    public static final Item RED_IRON_BOOTS = ironBootsRegister("red", ModArmorMaterial.RED_IRON);
    public static final Item WHITE_IRON_HELMET = ironHelmetRegister("white", ModArmorMaterial.WHITE_IRON);
    public static final Item WHITE_IRON_CHESTPLATE = ironChestplateRegister("white", ModArmorMaterial.WHITE_IRON);
    public static final Item WHITE_IRON_LEGGINGS = ironLeggingsRegister("white", ModArmorMaterial.WHITE_IRON);
    public static final Item WHITE_IRON_BOOTS = ironBootsRegister("white", ModArmorMaterial.WHITE_IRON);
    public static final Item YELLOW_IRON_HELMET = ironHelmetRegister("yellow", ModArmorMaterial.YELLOW_IRON);
    public static final Item YELLOW_IRON_CHESTPLATE = ironChestplateRegister("yellow", ModArmorMaterial.YELLOW_IRON);
    public static final Item YELLOW_IRON_LEGGINGS = ironLeggingsRegister("yellow", ModArmorMaterial.YELLOW_IRON);
    public static final Item YELLOW_IRON_BOOTS = ironBootsRegister("yellow", ModArmorMaterial.YELLOW_IRON);

    public static Item ironHelmetRegister(String name, IArmorMaterial materialIn) {
        return ArmorItemInit.armorHelmetRegister("iron/" + name, materialIn, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH));
    }
    
    public static Item ironChestplateRegister(String name, IArmorMaterial materialIn) {
        return ArmorItemInit.armorChestplateRegister("iron/" + name, materialIn, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH));
    }
    
    public static Item ironLeggingsRegister(String name, IArmorMaterial materialIn) {
        return ArmorItemInit.armorLeggingsRegister("iron/" + name, materialIn, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH));
    }
    
    public static Item ironBootsRegister(String name, IArmorMaterial materialIn) {
        return ArmorItemInit.armorBootsRegister("iron/" + name, materialIn, new Item.Properties().group(ModItemGroup.ERVIN_MOD_1_SEARCH));
    }

    public static Item register(String name, IArmorMaterial materialIn, EquipmentSlotType slot, Item.Properties properties) {
        return ArmorItemInit.armorRegister(name, materialIn, slot, properties);
    }
    
    public static void register() {
        Ervin_mod_1.register(IronArmorItemInit.class);
    }
}
