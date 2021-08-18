package com.babcsany.minecraft.init;

import com.babcsany.minecraft.enchantment.KtchsfitEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.registry.Registry;

public class EnchantmentInit {

    public static final Enchantment KTCHSFIT = register("ktchsfit", new KtchsfitEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final Enchantment KTCHSFIT1 = register("ktchsfit1", new KtchsfitEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final Enchantment KTCHSFIT2 = register("ktchsfit2", new KtchsfitEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final Enchantment KTCHSFIT3 = register("ktchsfit3", new KtchsfitEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final Enchantment KTCHSFIT4 = register("ktchsfit4", new KtchsfitEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));
    public static final Enchantment KTCHSFIT5 = register("ktchsfit5", new KtchsfitEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.MAINHAND));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static Enchantment register(String key, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, string(key), enchantment);
    }
}
