package com.babcsany.minecraft.ervin_mod_1.item.tool;

import com.babcsany.minecraft.ervin_mod_1.item.Rarity;
import com.babcsany.minecraft.ervin_mod_1.item.items.i_item_tiers.IItemTier1;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TieredItem extends Item {
   private final IItemTier1 tier;
   private com.babcsany.minecraft.ervin_mod_1.item.Rarity rarity;

   public TieredItem(IItemTier1 tierIn, Item.Properties builder) {
      super(builder.defaultMaxDamage(tierIn.getMaxUses()));
      this.tier = tierIn;
   }

   /**
    * Return an item rarity from EnumRarity
    */
   public Rarity getModRarity(ItemStack stack) {
      if (!stack.isEnchanted()) {
         return this.rarity;
      } else {
         switch(this.rarity) {
            case COMMON:
            case UNCOMMON:
               return Rarity.RARE;
            case RARE:
               return Rarity.EPIC;
            case EPIC:
            default:
               return this.rarity;
         }
      }
   }

   public IItemTier1 getTier() {
      return this.tier;
   }

   /**
    * Return the enchantability factor of the item, most of the time is based on material.
    */
   public int getItemEnchantability() {
      return this.tier.getEnchantAbility();
   }

   /**
    * Return whether this item is repairable in an anvil.
    */
   public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
      return this.tier.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
   }
}