package com.babcsany.minecraft.ervin_mod_1.entity.villager.trades;

import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.$ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.IItemProvider;

import javax.annotation.Nullable;
import java.util.Random;

public class $TraderTrades {
   public static final Int2ObjectMap<$TraderTrades.ITrade[]> field_221240_b = gatAsIntMap(ImmutableMap.of(1, new $TraderTrades.ITrade[]{
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_1$.get(), 6, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_2$.get(), 12, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_3$.get(), 18, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_4$.get(), 24, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_5$.get(), 30, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_6$.get(), 36, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_7$.get(), 42, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_8$.get(), 48, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_9$.get(), 54, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade($ItemInit.$_10$.get(), 60, 1, 1000, 1),
           new $TraderTrades.ItemsFor$_1$sTrade(ItemInit.RUBY.get(), 1, 4, 1000, 1),
           new $TraderTrades.ItemsFor$_1$sTrade(ItemInit.SRACH.get(), 4, 1, 1000, 1),
           new $TraderTrades.ItemsFor$_2$sTrade(isBurnableItemInit.LEAT.get(), 1, 4, 1000, 1),
           new $TraderTrades.ItemsFor$_3$sTrade(ItemInit.CHAK.get(), 18, 1, 1000, 1),
           new $TraderTrades.ItemsFor$_4$sTrade(ItemInit.MLONK.get(), 12, 1, 1000, 1),
           new $TraderTrades.ItemsFor$_5$sTrade(isBurnableItemInit.GART.get(), 24, 1, 1000, 1),
           new $TraderTrades.ItemsFor$_6$sTrade(isBurnableItemInit.TERAT_NUGGET.get(), 60, 1, 1000, 1),
           new $TraderTrades.ItemsFor30$_10$sAndItemsTrade(ItemInit.FIRK.get(), 30, isBurnableBlockItemInit.CRAINT_BLOCK.get(), 12, 1000, 5),
           new $TraderTrades.ItemsForTgurkBlocksAndItemsTrade($ItemInit.$_6$.get(), 30, SpecialToolItemInit.CRAINT.get(), 30, 1000, 5),
           new $TraderTrades.ItemsFor$_7$sTrade(isBurnableItemInit.NIRK.get(), 15, 1, 1000, 1),
           new $TraderTrades.ItemsFor$_8$sTrade(FoodItemInit.REAT.get(), 9, 1, 1000, 1),
           new $TraderTrades.ItemsFor$_9$sTrade(ItemInit.GNITH.get(), 10, 27, 1000, 1),
           new $TraderTrades.ItemsFor$_10$sTrade(isBurnableItemInit.RUGK.get(), 10, 1, 1000, 1),
   }));

   private static Int2ObjectMap<$TraderTrades.ITrade[]> gatAsIntMap(ImmutableMap<Integer, $TraderTrades.ITrade[]> p_221238_0_) {
      return new Int2ObjectOpenHashMap<>(p_221238_0_);
   }

   public interface ITrade {
      @Nullable
      MerchantOffer getOffer(Entity trader, Random rand);
   }

   static class ItemsForFirtsTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int firtCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForFirtsTrade(Block sellingItem, int firtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), firtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForFirtsTrade(Item sellingItem, int firtCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), firtCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForFirtsTrade(Item sellingItem, int firtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), firtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForFirtsTrade(ItemStack sellingItem, int firtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, firtCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForFirtsTrade(ItemStack sellingItem, int firtCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.firtCount = firtCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(ItemInit.FIRT.get(), this.firtCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForDurgsTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int durgCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForDurgsTrade(Block sellingItem, int durgCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), durgCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForDurgsTrade(Item sellingItem, int durgCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), durgCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForDurgsTrade(Item sellingItem, int durgCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), durgCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForDurgsTrade(ItemStack sellingItem, int durgCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, durgCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForDurgsTrade(ItemStack sellingItem, int durgCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.durgCount = durgCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableFoodItemInit.DURG.get(), this.durgCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_1$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_1$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_1$sTrade(Block sellingItem, int $_1$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_1$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_1$sTrade(Item sellingItem, int $_1$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_1$Count, sellingItemCount, 3000, xpValue);
      }

      public ItemsFor$_1$sTrade(Item sellingItem, int $_1$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_1$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_1$sTrade(ItemStack sellingItem, int $_1$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_1$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_1$sTrade(ItemStack sellingItem, int $_1$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_1$Count = $_1$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_1$.get(), this.$_1$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_2$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_2$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_2$sTrade(Block sellingItem, int $_2$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_2$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_2$sTrade(Item sellingItem, int $_2$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_2$Count, sellingItemCount, 12, xpValue);
      }

      public ItemsFor$_2$sTrade(Item sellingItem, int $_2$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_2$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_2$sTrade(ItemStack sellingItem, int $_2$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_2$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_2$sTrade(ItemStack sellingItem, int $_2$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_2$Count = $_2$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_2$.get(), this.$_2$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_3$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_3$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_3$sTrade(Block sellingItem, int $_3$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_3$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_3$sTrade(Item sellingItem, int $_3$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_3$Count, sellingItemCount, 12, xpValue);
      }

      public ItemsFor$_3$sTrade(Item sellingItem, int $_3$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_3$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_3$sTrade(ItemStack sellingItem, int $_3$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_3$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_3$sTrade(ItemStack sellingItem, int $_3$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_3$Count = $_3$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_3$.get(), this.$_3$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_4$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_4$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_4$sTrade(Block sellingItem, int $_4$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_4$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_4$sTrade(Item sellingItem, int $_4$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_4$Count, sellingItemCount, 12, xpValue);
      }

      public ItemsFor$_4$sTrade(Item sellingItem, int $_4$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_4$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_4$sTrade(ItemStack sellingItem, int $_4$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_4$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_4$sTrade(ItemStack sellingItem, int $_4$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_4$Count = $_4$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_4$.get(), this.$_4$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_5$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_5$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_5$sTrade(Block sellingItem, int $_5$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_5$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_5$sTrade(Item sellingItem, int $_5$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_5$Count, sellingItemCount, 12, xpValue);
      }

      public ItemsFor$_5$sTrade(Item sellingItem, int $_5$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_5$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_5$sTrade(ItemStack sellingItem, int $_5$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_5$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_5$sTrade(ItemStack sellingItem, int $_5$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_5$Count = $_5$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_5$.get(), this.$_5$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_6$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_6$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_6$sTrade(Block sellingItem, int $_6$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_6$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_6$sTrade(Item sellingItem, int $_6$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_6$Count, sellingItemCount, 12, xpValue);
      }

      public ItemsFor$_6$sTrade(Item sellingItem, int $_6$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_6$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_6$sTrade(ItemStack sellingItem, int $_6$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_6$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_6$sTrade(ItemStack sellingItem, int $_6$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_6$Count = $_6$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_6$.get(), this.$_6$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_7$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_7$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_7$sTrade(Block sellingItem, int $_7$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_7$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_7$sTrade(Item sellingItem, int $_7$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_7$Count, sellingItemCount, 12, xpValue);
      }

      public ItemsFor$_7$sTrade(Item sellingItem, int $_7$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_7$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_7$sTrade(ItemStack sellingItem, int $_7$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_7$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_7$sTrade(ItemStack sellingItem, int $_7$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_7$Count = $_7$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_7$.get(), this.$_7$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_8$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_8$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_8$sTrade(Block sellingItem, int $_8$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_8$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_8$sTrade(Item sellingItem, int $_8$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_8$Count, sellingItemCount, 12, xpValue);
      }

      public ItemsFor$_8$sTrade(Item sellingItem, int $_8$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_8$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_8$sTrade(ItemStack sellingItem, int $_8$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_8$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_8$sTrade(ItemStack sellingItem, int $_8$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_8$Count = $_8$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_8$.get(), this.$_8$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_9$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_9$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_9$sTrade(Block sellingItem, int $_9$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_9$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_9$sTrade(Item sellingItem, int $_9$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_9$Count, sellingItemCount, 12, xpValue);
      }

      public ItemsFor$_9$sTrade(Item sellingItem, int $_9$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_9$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_9$sTrade(ItemStack sellingItem, int $_9$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_9$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_9$sTrade(ItemStack sellingItem, int $_9$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_9$Count = $_9$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_9$.get(), this.$_9$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor$_10$sTrade implements $TraderTrades.ITrade {
      private final ItemStack sellingItem;
      private final int $_10$Count;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor$_10$sTrade(Block sellingItem, int $_10$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_10$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_10$sTrade(Item sellingItem, int $_10$Count, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), $_10$Count, sellingItemCount, 12, xpValue);
      }

      public ItemsFor$_10$sTrade(Item sellingItem, int $_10$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), $_10$Count, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor$_10$sTrade(ItemStack sellingItem, int $_10$Count, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, $_10$Count, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsFor$_10$sTrade(ItemStack sellingItem, int $_10$Count, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.$_10$Count = $_10$Count;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_10$.get(), this.$_10$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForTgurkBlocksAndItemsTrade implements $TraderTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int tgurkBlockCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForTgurkBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForTgurkBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int tgurkBlockCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.tgurkBlockCount = tgurkBlockCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.TGURK_BLOCK.get(), this.tgurkBlockCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor30$_10$sAndItemsTrade implements $TraderTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int $_10$Count;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor30$_10$sAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 30, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor30$_10$sAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int $_10$Count, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.$_10$Count = $_10$Count;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack($ItemInit.$_10$.get(), this.$_10$Count), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class SuspiciousStewForEmeraldTrade implements $TraderTrades.ITrade {
      final Effect effect;
      final int duration;
      final int xpValue;
      private final float priceMultiplier;

      public SuspiciousStewForEmeraldTrade(Effect effectIn, int durationIn, int xpValue) {
         this.effect = effectIn;
         this.duration = durationIn;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(Items.SUSPICIOUS_STEW, 1);
         SuspiciousStewItem.addEffect(itemstack, this.effect, this.duration);
         return new MerchantOffer(new ItemStack(Items.EMERALD, 1), itemstack, 12, this.xpValue, this.priceMultiplier);
      }
   }
}