package com.babcsany.minecraft.ervin_mod_1.item.tool;

public enum ModItemTier3 implements IItemTier3 {
    // int harvestLevel, int maxUses, float efficiency, float attackDamage, int
    //enchantability, Supplier<Ingredient> repairMaterial
    //GVR(4,1010000, 120),
    CRAINT(19,200,60),
    SRIUNK(14,70,20),
    TERAT(32,160000,210);

    private final int harvestLevel;
    private final float efficiency;
    private final float attackDamage;
    //private final int enchantability;

    ModItemTier3(int harvestLevel, /*int maxUses,*/ float efficiency, float attackDamage /*int enchantability, Supplier<Ingredient> repairMaterialIn*/) {
        this.harvestLevel = harvestLevel;
        //this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        //this.enchantability = enchantability;
        //this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    public int getHarvestLevel() {
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


