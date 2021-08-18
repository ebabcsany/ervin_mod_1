package com.babcsany.minecraft.ervin_mod_1.item.tool;

import com.babcsany.minecraft.ervin_mod_1.item.IItemTier_;
import com.babcsany.minecraft.ervin_mod_1.item.Rarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TieredItem_ extends Item {
   private final IItemTier_ tier;
   private Rarity rarity;

   public TieredItem_(IItemTier_ tierIn, Properties builder) {
      super(builder.defaultMaxDamage((int)tierIn.getAttackDamage()));
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

   public IItemTier_ getTier() {
      return this.tier;
   }

   /**
    * Return the enchantability factor of the item, most of the time is based on material.
    */
   public int getItemEnchantability() {
      return this.tier.getEnchantability();
   }
}