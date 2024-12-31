package com.babcsany.minecraft.ervin_mod_1.item.tool;

import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.item.items.i_item_tiers.IItemTier1;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier1 implements IItemTier1 {
    /** int harvestLevel, int maxUses, float efficiency, float attackDamage, int
    enchantAbility, Supplier<Ingredient> repairMaterial */
    CRAINT(12,13214,5432.0F,56,320, () -> Ingredient.fromItems(SpecialToolItemInit.CRAINT.get())),
    TERAT(28,145241,123621.0F,324,1643, () -> Ingredient.fromItems(isBurnableItemInit.TERAT_NUGGET.get()));

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantAbility;
    private final LazyValue<Ingredient> repairMaterial;

    ModItemTier1(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantAbility, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantAbility = enchantAbility;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    public int getHarvestLevel() {
        return harvestLevel;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    public int getEnchantAbility() {
        return enchantAbility;
    }

    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
}


