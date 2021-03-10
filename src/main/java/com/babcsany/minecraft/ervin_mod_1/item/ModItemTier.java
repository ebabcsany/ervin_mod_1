package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {
    // int harvestLevel, int maxUses, float efficiency, float attackDamage, int
    //enchantability, Supplier<Ingredient> repairMaterial
    SRIUNK(8, 10000, 20.0F, 8.0F, 250, () -> Ingredient.fromItems(isBurnableItemInit.SRIUNK.get())),
    TERAT( 32, 80000, 160000.0F, 64.0F, 2000, () -> Ingredient.fromItems(isBurnableItemInit.TERAT.get())),
    BLACK_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.BLACK_COBBLESTONE.get())),
    BLUE_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.BLUE_COBBLESTONE.get())),
    BROWN_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.BROWN_COBBLESTONE.get())),
    CYAN_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.CYAN_COBBLESTONE.get())),
    GREEN_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.GREEN_COBBLESTONE.get())),
    LIGHT_BLUE_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.LIGHT_BLUE_COBBLESTONE.get())),
    LIGHT_BLUE1_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.LIGHT_BLUE1_COBBLESTONE.get())),
    LIGHT_GRAY_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.LIGHT_GRAY_COBBLESTONE.get())),
    LIME_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.LIME_COBBLESTONE.get())),
    MAGENTA_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.MAGENTA_COBBLESTONE.get())),
    ORANGE_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.ORANGE_COBBLESTONE.get())),
    PINK_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.PINK_COBBLESTONE.get())),
    PURPLE_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.PURPLE_COBBLESTONE.get())),
    RED_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.RED_COBBLESTONE.get())),
    WHITE_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.WHITE_COBBLESTONE.get())),
    YELLOW_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.YELLOW_COBBLESTONE.get())),
    BLACK_IRON_INGOT(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.fromItems(ItemInit.BLACK_IRON_INGOT.get())),
    BLUE_IRON_INGOT(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.fromItems(ItemInit.BLUE_IRON_INGOT.get())),
    RED_IRON_INGOT(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.fromItems(ItemInit.RED_IRON_INGOT.get())),
    ENDER_SRACKT(1, 24, 2, 0, 20, () -> Ingredient.fromItems(ItemInit.ENDER_SRACKT.get())),
    FIRT( 5, 1965, 14.0F, 6.0F, 148, () -> Ingredient.fromItems(ItemInit.FIRT.get())),
    NIRK( 20, 12281, 387.5F, 37.5F, 925, () -> Ingredient.fromItems(isBurnableItemInit.NIRK.get())),
    ENDER_SRACKHT(2, 48, 4.0F, 2.0F, 40, () -> Ingredient.fromItems(BlockNamedItemInit.ENDER_SRACKHT.get())),
    SURV(10, 1310, 40.0F, 10.0F, 50, () -> Ingredient.fromItems(BlockItemInit.RED_COBBLESTONE.get())),
    ENDER_STAKRACH(3, 96, 6.0F, 4.0F, 60, () -> Ingredient.fromItems(BlockNamedItemInit.ENDER_STAKRACH.get())),
    ENDER_SRAKTCAF(4, 120, 8.0F, 6.0F, 80, () -> Ingredient.fromItems(BlockNamedItemInit.ENDER_SRAKTCAF.get())),
    ENDER_TRASKRACH(5, 180, 10.0F, 8.0F, 100, () -> Ingredient.fromItems(BlockNamedItemInit.ENDER_TRASKRACH.get())),
    ENDER_TRASK(6, 320, 16.0F, 12.0F, 160, () -> Ingredient.fromItems(BlockItemInit.ENDER_TRASK.get())),
    KIRT(0, 1, 1.0F, 1.0F, 1, () -> Ingredient.fromItems(ItemInit.KIRT.get())),
    DURG(12, 17685, 126.0F, 54.0F, 1332, () -> Ingredient.fromItems(isBurnableItemInit.DURG.get())),
    OBSIDIAN(4, 3214, 64.0F, 4.0F, 8, () -> Ingredient.fromItems(Items.OBSIDIAN)),
    DURT(3, 2672, 24.0F, 5.0F, 320, () -> Ingredient.fromItems(BlockItemInit.DURT.get())),
    TRUGN( 33, 120000, 5600000.0F, 720.0F, 30000, () -> Ingredient.fromItems(isBurnableBlockItemInit.TRUGN.get())),
    TRAGN( 44, 12000000, 560000000.0F, 72000.0F, 3000000, () -> Ingredient.fromItems(isBurnableBlockItemInit.TRAGN.get())),
    TRUZN( 39, 1200000, 56000000.0F, 7200.0F, 300000, () -> Ingredient.fromItems(isBurnableBlockItemInit.TRUZN.get())),
    TGURN( 74, 324000000, 15120000000.0F, 19440000.0F, 81000000, () -> Ingredient.fromItems(isBurnableBlockItemInit.TGURN.get())),
    SRURG( 17, 54636, 2315847.0F, 340.0F, 14328, () -> Ingredient.fromItems(isBurnableBlockItemInit.SRURG.get()));

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
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
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.getValue();
    }
}


