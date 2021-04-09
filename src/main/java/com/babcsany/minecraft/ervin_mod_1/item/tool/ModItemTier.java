package com.babcsany.minecraft.ervin_mod_1.item.tool;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier1 {
    // int harvestLevel, int maxUses, float efficiency, float attackDamage, int
    //enchantability, Supplier<Ingredient> repairMaterial
    CRAINT(50),
    TERAT(120);

    //private final int harvestLevel;
    //private final int maxUses;
    //private final float efficiency;
    private final float attackDamage;
    //private final int enchantability;
    //private final LazyValue<Ingredient> repairMaterial;

    ModItemTier(/*int harvestLevel, int maxUses, float efficiency,*/ float attackDamage /*int enchantability, Supplier<Ingredient> repairMaterialIn*/) {
        //this.harvestLevel = harvestLevel;
        //this.maxUses = maxUses;
        //this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        //this.enchantability = enchantability;
        //this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    /*public int getHarvestLevel() {
        return harvestLevel;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public float getEfficiency() {
        return efficiency;
    }*/

    public float getAttackDamage() {
        return attackDamage;
    }

    /*public int getEnchantability() {
        return enchantability;
    }

    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }*/
}


