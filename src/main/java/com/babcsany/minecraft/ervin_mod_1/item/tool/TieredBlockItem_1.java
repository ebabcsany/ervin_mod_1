package com.babcsany.minecraft.ervin_mod_1.item.tool;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class TieredBlockItem_1 extends BlockItem {
   private final IItemTier2 tier;
   private Rarity rarity;

   public TieredBlockItem_1(Block blockIn, IItemTier2 tierIn, Properties builder) {
      super(blockIn, builder.defaultMaxDamage(tierIn.hashCode()));
      this.tier = tierIn;
   }

   /**
    * Return an item rarity from EnumRarity
    */
   public Rarity getRarity(ItemStack stack) {
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

   public IItemTier2 getTier() {
      return this.tier;
   }
}