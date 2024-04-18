package com.babcsany.minecraft.ervin_mod_1.item.tool;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.DamageSource;

public class TieredBlockItem_1 extends BlockItem {
   private final IItemTier2 tier;
   private final Rarity rarity;
   private final int maxStackSize;
   private final int maxDamage;
   private final boolean burnable;

   public TieredBlockItem_1(Block blockIn, IItemTier2 tierIn, Properties builder) {
      super(blockIn, builder.defaultMaxDamage(tierIn.hashCode()));
      this.tier = tierIn;
      this.rarity = builder.rarity;
      this.maxDamage = builder.maxDamage;
      this.maxStackSize = builder.maxStackSize;
      this.burnable = builder.burnable;
   }

   /** @deprecated */
   @Deprecated
   public final int getTieredBlockItemMaxStackSize() {
      return this.maxStackSize;
   }

   /** @deprecated */
   @Deprecated
   public final int getTieredBlockItemMaxDamage() {
      return this.maxDamage;
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

   public boolean isEnchantable(ItemStack p_77616_1_) {
      return this.getItemStackLimit(p_77616_1_) == 2048 && this.isDamageable();
   }

   public boolean isDamageable(DamageSource p_234685_1_) {
      return !this.burnable || !p_234685_1_.isFireDamage();
   }

   public static class Properties extends Item.Properties {
      private int maxStackSize = 2048;
      private int maxDamage;
      private Rarity rarity;
      private boolean burnable;

      public Properties() {
         super();
         this.rarity = Rarity.COMMON;
      }

      public Properties maxStackSize(int maxStackSize) {
         this.maxStackSize = maxStackSize;
         return this;
      }

      public Properties maxDamage(int maxDamage) {
         this.maxDamage = maxDamage;
         return this;
      }

      public Item.Properties rarity(Rarity rarity) {
         this.rarity = rarity;
         return this;
      }

      public Properties isImmuneToFire() {
         this.burnable = true;
         return this;
      }
   }
}