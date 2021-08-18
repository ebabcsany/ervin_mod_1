package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.item.crafting.Ingredient;

public interface IItemTier_ {
   float getMaxUses();

   float getEfficiency();

   float getAttackDamage();

   int getHarvestLevel();

   int getEnchantability();

   Ingredient getRepairMaterial();
}
