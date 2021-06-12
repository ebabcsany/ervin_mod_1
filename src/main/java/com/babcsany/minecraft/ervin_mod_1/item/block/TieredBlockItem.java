package com.babcsany.minecraft.ervin_mod_1.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;

public class TieredBlockItem extends BlockItem {
   private final IItemTier tier;

   public TieredBlockItem(IItemTier tierIn, Block blockIn, Properties builder) {
      super(blockIn, builder.defaultMaxDamage(tierIn.getMaxUses()));
      this.tier = tierIn;
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
}