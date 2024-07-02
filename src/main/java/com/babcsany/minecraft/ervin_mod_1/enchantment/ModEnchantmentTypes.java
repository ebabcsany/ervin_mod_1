package com.babcsany.minecraft.ervin_mod_1.enchantment;

import com.babcsany.minecraft.ervin_mod_1.item.HuihkRodItem;
import net.minecraft.enchantment.EnchantmentType;

public class ModEnchantmentTypes {
    /**
     * Return true if the item passed can be enchanted by a enchantment of this type.
     */
    public static final EnchantmentType HUIHK_ROD = EnchantmentType.create("HUIHK_ROD", (itemIn) -> itemIn instanceof HuihkRodItem);
}
