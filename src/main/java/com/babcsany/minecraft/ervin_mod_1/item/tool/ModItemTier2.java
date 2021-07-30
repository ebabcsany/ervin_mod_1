package com.babcsany.minecraft.ervin_mod_1.item.tool;

public enum ModItemTier2 implements IItemTier2 {
    /** int harvestLevel, int maxUses, float efficiency, float attackDamage, int
    enchantability, Supplier<Ingredient> repairMaterial */
    GVR(1010000, 120),
    CRAINT(10000,50),
    TERAT(160000,120);

    //private final int harvestLevel;
    //private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    //private final int enchantability;
    //private final LazyValue<Ingredient> repairMaterial;

    ModItemTier2(/*int harvestLevel, /*int maxUses,*/ float efficiency, float attackDamage /*int enchantability, Supplier<Ingredient> repairMaterialIn*/) {
        //this.harvestLevel = harvestLevel;
        //this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        //this.enchantability = enchantability;
        //this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    /*public int getHarvestLevel() {
        return harvestLevel;
    }

    /*public int getMaxUses() {
        return maxUses;
    }*/

    public float getEfficiency() {
        return efficiency;
    }

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

