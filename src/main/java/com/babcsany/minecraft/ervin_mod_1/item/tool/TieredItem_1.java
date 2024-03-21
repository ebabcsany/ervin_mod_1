package com.babcsany.minecraft.ervin_mod_1.item.tool;

import com.babcsany.minecraft.ervin_mod_1.item.Rarity;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Set;

public class TieredItem_1 extends Item {
   private final IItemTier tier;
   protected final ItemGroup group;
   private final Rarity rarity;
   private final int maxStackSize;
   private final int maxDamage;
   private final boolean burnable;
   private final Map<ToolType, Integer> toolClasses = Maps.newHashMap();

   public TieredItem_1(IItemTier tierIn, Properties builder) {
      super(builder.defaultMaxDamage(tierIn.hashCode()));
      this.tier = tierIn;
      this.group = builder.group;
      this.rarity = builder.rarity;
      this.maxDamage = builder.maxDamage;
      this.maxStackSize = builder.maxStackSize;
      this.burnable = builder.burnable;
      this.toolClasses.putAll(builder.toolClasses);
   }

   /** @deprecated */
   @Deprecated
   public final int getTieredItemMaxStackSize() {
      return this.maxStackSize;
   }

   /** @deprecated */
   @Deprecated
   public final int getTieredItemMaxDamage() {
      return this.maxDamage;
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

   public boolean isEnchantable(ItemStack p_77616_1_) {
      return this.getItemStackLimit(p_77616_1_) == 2048 && this.isDamageable();
   }

   public IItemTier getTier() {
      return this.tier;
   }

   @Nullable
   public final ItemGroup getTieredGroup() {
      return this.group;
   }

   public Set<ToolType> getToolTypes(ItemStack p_getToolTypes_1_) {
      return this.toolClasses.keySet();
   }

   public int getHarvestLevel(ItemStack p_getHarvestLevel_1_, ToolType p_getHarvestLevel_2_, @Nullable PlayerEntity p_getHarvestLevel_3_, @Nullable BlockState p_getHarvestLevel_4_) {
      return this.toolClasses.getOrDefault(p_getHarvestLevel_2_, -1);
   }

   /**
    * Return the enchantability factor of the item, most of the time is based on material.
    */
   public int getItemEnchantability() {
      return this.tier.getEnchantability();
   }

   public boolean isDamageable(DamageSource p_234685_1_) {
      return !this.burnable || !p_234685_1_.isFireDamage();
   }

   public static class Properties extends Item.Properties {
      private int maxStackSize = 2048;
      private int maxDamage;
      private ItemGroup group;
      private Rarity rarity;
      private boolean burnable;
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
         this.burnable = true;
         return this;
      }

      public Properties addToolType(ToolType p_addToolType_1_, int p_addToolType_2_) {
         this.toolClasses.put(p_addToolType_1_, p_addToolType_2_);
         return this;
      }
   }
}