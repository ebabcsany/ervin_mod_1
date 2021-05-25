package com.babcsany.minecraft.ervin_mod_1.item.items.i_item_tiers;

import net.minecraft.item.crafting.Ingredient;

public interface IItemTier1 {
   int getMaxUses();

   float getEfficiency();

   float getAttackDamage();

   int getHarvestLevel();

   int getEnchantAbility();

   Ingredient getRepairMaterial();
}