package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.ItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

import static com.babcsany.minecraft.ervin_mod_1.init.ItemInit.TERAT;

public enum ModItemTier implements IItemTier {
    // int harvestLevel, int maxUses, float efficiency, float attackDamage, int
    //enchantability, Supplier<Ingredient> repairMaterial
    SRIUNK(8, 10000, 20.0F, 8.0F, 250, () -> Ingredient.fromItems(ItemInit.SRIUNK.get())),
    TERAT( 32, 80000, 160000.0F, 64.0F, 2000, () -> Ingredient.fromItems(ItemInit.TERAT.get())),
    RED_COBBLESTONE(1, 131, 4.0F, 1.0F, 5, () -> Ingredient.fromItems(BlockInit.RED_COBBLESTONE.get())),
    ENDER_SRACKT(1, 24, 2, 0, 20, () -> Ingredient.fromItems(ItemInit.ENDER_SRACKT.get())),
    FIRT( 5, 1965, 14.0F, 6.0F, 148, () -> Ingredient.fromItems(ItemInit.FIRT.get())),
    NIRK( 20, 12281, 387.5F, 37.5F, 925, () -> Ingredient.fromItems(ItemInit.NIRK.get())),
    ENDER_SRACKHT(2, 48, 4.0F, 2.0F, 40, () -> Ingredient.fromItems(ItemInit.ENDER_SRACKHT.get())),
    SURV(10, 1310, 40.0F, 10.0F, 50, () -> Ingredient.fromItems(BlockInit.RED_COBBLESTONE.get())),
    ENDER_STAKRACH(3, 96, 6.0F, 4.0F, 60, () -> Ingredient.fromItems(ItemInit.ENDER_STAKRACH.get())),
    ENDER_SRAKTCAF(4, 120, 8.0F, 6.0F, 80, () -> Ingredient.fromItems(ItemInit.ENDER_SRAKTCAF.get())),
    ENDER_TRASKRACH(5, 180, 10.0F, 8.0F, 100, () -> Ingredient.fromItems(ItemInit.ENDER_TRASKRACH.get())),
    ENDER_TRASK(6, 320, 16.0F, 12.0F, 160, () -> Ingredient.fromItems(BlockInit.ENDER_TRASK.get())),
    KIRT(0, 1, 1.0F, 1.0F, 4, () -> Ingredient.fromItems(ItemInit.KIRT.get())),
    DURG(12, 17685, 126.0F, 54.0F, 1332, () -> Ingredient.fromItems(ItemInit.DURG.get())),
    OBSIDIAN(4, 3214, 16.0F, 4.0F, 8, () -> Ingredient.fromItems(Items.OBSIDIAN)),
    DURT(3, 2672, 24.0F, 5.0F, 320, () -> Ingredient.fromItems(BlockInit.DURT.get())),
    TRUGN( 33, 120000, 5600000.0F, 720.0F, 30000, () -> Ingredient.fromItems(BlockInit.TRUGN.get()));

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


