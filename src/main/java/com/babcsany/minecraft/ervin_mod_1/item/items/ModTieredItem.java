package com.babcsany.minecraft.ervin_mod_1.item.items;

import com.babcsany.minecraft.ervin_mod_1.item.Rarity;
import com.google.common.collect.Maps;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ToolType;

import java.util.Map;

public class ModTieredItem extends Item {
    private final IItemTier tier;
    private final boolean isImmuneToFire;

    public ModTieredItem(IItemTier tierIn, Properties builder) {
        super(builder.defaultMaxDamage(tierIn.getMaxUses()));
        this.tier = tierIn;
        this.isImmuneToFire = builder.isImmuneToFire;
    }

    public IItemTier getTier() {
        return this.tier;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability() {
        return this.tier.getEnchantability();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return this.tier.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
    }

    public boolean isImmuneToFire() {
        return this.isImmuneToFire;
    }

    public boolean isDamageable(DamageSource damageSource) {
        return !this.isImmuneToFire || !damageSource.isFireDamage();
    }

    public static class Properties extends Item.Properties {
        private int maxStackSize = 64;
        private int maxDamage;
        private ItemGroup group;
        private Rarity rarity;
        private boolean isImmuneToFire;
        private Map<ToolType, Integer> toolClasses;

        public Properties() {
            super();
            this.toolClasses = Maps.newHashMap();
        }

        public Properties maxStackSize(int maxStackSize) {
            this.maxStackSize = maxStackSize;
            return this;
        }

        public Properties maxDamage(int maxDamage) {
            this.maxDamage = maxDamage;
            return this;
        }

        public Properties group(ItemGroup group) {
            this.group = group;
            return this;
        }

        public Properties rarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public Properties isImmuneToFire() {
            this.isImmuneToFire = true;
            return this;
        }

        public Properties addToolType(ToolType p_addToolType_1_, int p_addToolType_2_) {
            this.toolClasses.put(p_addToolType_1_, p_addToolType_2_);
            return this;
        }
    }
}
