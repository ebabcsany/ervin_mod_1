package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.init.ItemInit;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.villager.IVillagerDataHolder;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class $TraderTrades {
   public static final Int2ObjectMap<$TraderTrades.ITrade[]> field_221240_b = gatAsIntMap(ImmutableMap.of(1, new $TraderTrades.ITrade[]{
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_1$.get(), 6, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_2$.get(), 12, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_3$.get(), 18, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_4$.get(), 24, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_5$.get(), 30, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_6$.get(), 36, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_7$.get(), 42, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_8$.get(), 48, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_9$.get(), 54, 1, 1000, 1),
           new $TraderTrades.ItemsForFirtsTrade(ItemInit.$_10$.get(), 60, 1, 1000, 1),
           new $TraderTrades.ItemsFor$_1$sTrade(ItemInit.RUBY.get(), 1, 4, 10, 1),
           new $TraderTrades.ItemsFor$_2$sTrade(ItemInit.LEAT.get(), 1, 4, 10, 1),
           new $TraderTrades.ItemsFor$_3$sTrade(ItemInit.SRIUNK.get(), 1, 1, 10, 1),
           new $TraderTrades.ItemsFor$_4$sTrade(ItemInit.MLONK.get(), 1, 1, 10, 1),
           new $TraderTrades.ItemsFor$_5$sTrade(ItemInit.DURG.get(), 1, 1, 10, 1),
           new $TraderTrades.ItemsFor$_6$sTrade(ItemInit.CRAINT.get(), 1, 1, 10, 1),
           new $TraderTrades.ItemsFor$_7$sTrade(ItemInit.NIRK.get(), 1, 1, 10, 1),
           new $TraderTrades.ItemsFor$_8$sTrade(ItemInit.REAT.get(), 1, 1, 10, 1),
           new $TraderTrades.ItemsFor$_9$sTrade(ItemInit.GNITH.get(), 1, 27, 10, 1),
           new $TraderTrades.ItemsFor$_10$sTrade(ItemInit.RUGK.get(), 1, 1, 10, 1),
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
         return new MerchantOffer(new ItemStack(ItemInit.$_1$.get(), this.$_1$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(ItemInit.$_2$.get(), this.$_2$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(ItemInit.$_3$.get(), this.$_3$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(ItemInit.$_4$.get(), this.$_4$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(ItemInit.$_5$.get(), this.$_5$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(ItemInit.$_6$.get(), this.$_6$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(ItemInit.$_7$.get(), this.$_7$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(ItemInit.$_8$.get(), this.$_8$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(ItemInit.$_9$.get(), this.$_9$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(ItemInit.$_10$.get(), this.$_10$Count), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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