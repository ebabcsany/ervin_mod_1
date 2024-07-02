package com.babcsany.minecraft.ervin_mod_1.enchantment;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;

public class ModEnchantmentHelper extends EnchantmentHelper {
    public static int getHuihkingLuckBonus(ItemStack stack) {
        return getEnchantmentLevel(ModEnchantments.LUCK_OF_THE_SEA, stack);
    }

    public static int getHuihkingSpeedBonus(ItemStack stack) {
        return getEnchantmentLevel(ModEnchantments.LURE, stack);
    }
}
