package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.tool.EnderToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableSpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableToolItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {
    /** int harvestLevel, int maxUses, float efficiency, float attackDamage, int
    enchantability, Supplier<Ingredient> repairMaterial */
    SRIUNK(14, 13462, 220.0F, 26.0F, 250, () -> Ingredient.fromItems(isBurnableItemInit.SRIUNK)),
    TERAT(32, 165846, 210000.0F, 384.0F, 2210, () -> Ingredient.fromItems(isBurnableSpecialToolItemInit.TERAT)),
    CRAINT(12,13214,5432.0F,56,320, () -> Ingredient.fromItems(SpecialToolItemInit.CRAINT.get())),
    BLACK_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.BLACK_COBBLESTONE)),
    BLUE_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockItemInit.BLUE_COBBLESTONE)),
    BROWN_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.BROWN_COBBLESTONE)),
    CYAN_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.CYAN_COBBLESTONE)),
    GREEN_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.GREEN_COBBLESTONE)),
    LIGHT_BLUE_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.LIGHT_BLUE_COBBLESTONE)),
    LIGHT_BLUE1_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.LIGHT_BLUE1_COBBLESTONE)),
    LIGHT_GRAY_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.LIGHT_GRAY_COBBLESTONE)),
    LIME_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.LIME_COBBLESTONE)),
    MAGENTA_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.MAGENTA_COBBLESTONE)),
    ORANGE_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.ORANGE_COBBLESTONE)),
    PINK_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.PINK_COBBLESTONE)),
    PURPLE_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.PURPLE_COBBLESTONE)),
    RED_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.RED_COBBLESTONE)),
    WHITE_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.WHITE_COBBLESTONE)),
    YELLOW_STONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.YELLOW_COBBLESTONE)),
    BLACK_IRON_INGOT(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.fromItems(ItemInit.BLACK_IRON_INGOT)),
    BLUE_IRON_INGOT(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.fromItems(ItemInit.BLUE_IRON_INGOT)),
    RED_IRON_INGOT(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.fromItems(ItemInit.RED_IRON_INGOT)),
    ENDER_SRACKT(1, 24, 2, 0, 20, () -> Ingredient.fromItems(ItemInit.ENDER_SRACKT)),
    FIRT(5, 1965, 14.0F, 6.0F, 148, () -> Ingredient.fromItems(ItemInit.FIRT)),
    Bj(3, 5600, 26.0F, 3.0F, 41, () -> Ingredient.fromItems(isBurnableToolItemInit.Bj_PICKAXE.get())),
    NIRK(18, 12281, 387.5F, 117.5F, 925, () -> Ingredient.fromItems(isBurnableItemInit.NIRK)),
    ENDER_SRACKHT(2, 48, 4.0F, 2.0F, 40, () -> Ingredient.fromItems(EnderToolItemInit.ENDER_SRACKHT)),
    SURV(2, 1310, 40.0F, 10.0F, 50, () -> Ingredient.fromItems(BlockItemInit.SURV)),
    ENDER_STAKRACH(3, 96, 6.0F, 4.0F, 60, () -> Ingredient.fromItems(EnderToolItemInit.ENDER_STAKRACH)),
    ENDER_SRAKTCAF(4, 120, 8.0F, 6.0F, 80, () -> Ingredient.fromItems(EnderToolItemInit.ENDER_SRAKTCAF)),
    ENDER_TRASKRACH(5, 180, 10.0F, 8.0F, 100, () -> Ingredient.fromItems(EnderToolItemInit.ENDER_TRASKRACH)),
    ENDER_TRASK(6, 320, 16.0F, 12.0F, 160, () -> Ingredient.fromItems(BlockItemInit.ENDER_TRASK)),
    KIRT(0, 1, 0.0F, 0.0F, 1, () -> Ingredient.fromItems(ItemInit.KIRT)),
    KIRT_STIK(0, 26, 1.0F, 1.0F, 2, () -> Ingredient.fromItems(ItemInit.KIRT_STIK)),
    DURG(12, 17685, 126.0F, 54.0F, 1332, () -> Ingredient.fromItems(isBurnableFoodItemInit.DURG)),
    OBSIDIAN(4, 3214, 64.0F, 4.0F, 8, () -> Ingredient.fromItems(Items.OBSIDIAN)),
    DURT(3, 2672, 24.0F, 5.0F, 320, () -> Ingredient.fromItems(BlockItemInit.DURT)),
    TRUGN(33, 120000, 5600000.0F, 720.0F, 30000, () -> Ingredient.fromItems(isBurnableBlockItemInit.TRUGN)),
    TRAGN(44, 12000000, 560000000.0F, 72000.0F, 3000000, () -> Ingredient.fromItems(isBurnableBlockItemInit.TRAGN)),
    TRUZN(39, 1200000, 56000000.0F, 7200.0F, 300000, () -> Ingredient.fromItems(isBurnableBlockItemInit.TRUZN)),
    TGURN(74, 324000000, 15120000000.0F, 19440000.0F, 81000000, () -> Ingredient.fromItems(isBurnableBlockItemInit.TGURN)),
    SRURG(17, 54636, 2315847.0F, 340.0F, 14328, () -> Ingredient.fromItems(isBurnableBlockItemInit.SRURG)),
    THUFR(119, 543800000, 3690527310400000000.0F, 34894526265243262.0F, 143288, () -> Ingredient.fromItems(isBurnableSpecialToolItemInit.THUFR));

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
