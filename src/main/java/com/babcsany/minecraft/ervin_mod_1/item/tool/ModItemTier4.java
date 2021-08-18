package com.babcsany.minecraft.ervin_mod_1.item.tool;

public enum ModItemTier4 implements IItemTier4 {
    /** int harvestLevel, float efficiency, float attackDamage, int
    enchantAbility */
    //CRAINT(12,13214,5432.0F,56,320, () -> Ingredient.fromItems(SpecialToolItemInit.CRAINT.get())),
    //TERAT(28,145241,123621.0F,324,1643, () -> Ingredient.fromItems(isBurnableItemInit.TERAT_NUGGET.get()));
    CRAINT(12,5432.0F,56,320),
    TERAT(28,123621.0F,324,1643);

    private final int harvestLevel;
    //
    private final float efficiency;
    private final float attackDamage;
    private final int enchantAbility;
    //

    ModItemTier4(int harvestLevel, float efficiency, float attackDamage, int enchantAbility) {
        this.harvestLevel = harvestLevel;
        //
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantAbility = enchantAbility;
        //
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getEnchantAbility() {
        return enchantAbility;
    }

}
