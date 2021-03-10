package com.babcsany.minecraft.ervin_mod_1.entity.villager.trades;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
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
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.PotionUtils;
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

public class TraderNirtreTrades {
   public static final Int2ObjectMap<TraderNirtreTrades.ITrade[]> field_221240_b = gatAsIntMap(ImmutableMap.of(1, new TraderNirtreTrades.ITrade[]{
           new TraderNirtreTrades.ItemsForChaksTrade(Items.EMERALD, 25, 1, 22, 2),
           new TraderNirtreTrades.ItemsForChaksTrade(ItemInit.RUBY.get(), 2, 1, 5, 1),
           new TraderNirtreTrades.ItemsForChaksTrade(Items.NAUTILUS_SHELL, 5, 1, 20, 3),
           new TraderNirtreTrades.ItemsForChaksTrade(ItemInit.MLONK.get(), 4, 1, 10, 2),
           new TraderNirtreTrades.ItemsForChaksTrade(Items.GRASS_BLOCK, 4, 1, 9, 1),
           new TraderNirtreTrades.ItemsForKirtsTrade(ItemInit.$_TRADER_SPAWN_EGG.get(), 64, 1, 20, 1),
           new TraderNirtreTrades.ItemsForEmeraldBlocksTrade(ItemInit.WANDERING_TRADER_NIRTRE_SPAWN_EGG.get(), 50, 1, 20, 1),
           new TraderNirtreTrades.ItemsForEmeraldBlocksTrade(ItemInit.SRACH_ENTITY_SPAWN_EGG.get(), 1, 1, 20, 1),
           new TraderNirtreTrades.ItemsForRegdemBlocksAndItemsTrade(BlockItemInit.FREIN_BLOCK.get(), 10, ItemInit.HHIJ_SPAWN_EGG.get(), 1, 16, 4),
           new TraderNirtreTrades.ItemsForEmeraldsAndItemsTrade(ItemInit.SPAWN_EGG_1.get(), 1, isBurnableItemInit.FIRN.get(), 1, 16, 1),
           new TraderNirtreTrades.ItemsForFirnsTrade(ItemInit.FREIN_BALL.get(), 10, 16, 50),
           new TraderNirtreTrades.ItemsForGrutsTrade(isBurnableItemInit.TIRKS.get(), 30, 4, 50),
   }));

   private static Int2ObjectMap<TraderNirtreTrades.ITrade[]> gatAsIntMap(ImmutableMap<Integer, TraderNirtreTrades.ITrade[]> p_221238_0_) {
      return new Int2ObjectOpenHashMap<>(p_221238_0_);
   }

   static class DyedArmorForEmeraldsTrade implements TraderNirtreTrades.ITrade {
      private final Item tradeItem;
      private final int price;
      private final int maxUses;
      private final int xpValue;

      public DyedArmorForEmeraldsTrade(Item itemIn, int priceIn) {
         this(itemIn, priceIn, 12, 1);
      }

      public DyedArmorForEmeraldsTrade(Item tradeItemIn, int priceIn, int maxUsesIn, int xpValueIn) {
         this.tradeItem = tradeItemIn;
         this.price = priceIn;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(Items.EMERALD, this.price);
         ItemStack itemstack1 = new ItemStack(this.tradeItem);
         if (this.tradeItem instanceof DyeableArmorItem) {
            List<DyeItem> list = Lists.newArrayList();
            list.add(getRandomDyeItem(rand));
            if (rand.nextFloat() > 0.7F) {
               list.add(getRandomDyeItem(rand));
            }

            if (rand.nextFloat() > 0.8F) {
               list.add(getRandomDyeItem(rand));
            }

            itemstack1 = IDyeableArmorItem.dyeItem(itemstack1, list);
         }

         return new MerchantOffer(itemstack, itemstack1, this.maxUses, this.xpValue, 0.2F);
      }

      private static DyeItem getRandomDyeItem(Random p_221232_0_) {
         return DyeItem.getItem(DyeColor.byId(p_221232_0_.nextInt(16)));
      }
   }

   static class DyedArmorForRubiesTrade implements TraderNirtreTrades.ITrade {
      private final Item tradeItem;
      private final int price;
      private final int maxUses;
      private final int xpValue;

      public DyedArmorForRubiesTrade(Item itemIn, int priceIn) {
         this(itemIn, priceIn, 12, 1);
      }

      public DyedArmorForRubiesTrade(Item tradeItemIn, int priceIn, int maxUsesIn, int xpValueIn) {
         this.tradeItem = tradeItemIn;
         this.price = priceIn;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(ItemInit.RUBY.get(), this.price);
         ItemStack itemstack1 = new ItemStack(this.tradeItem);
         if (this.tradeItem instanceof DyeableArmorItem) {
            List<DyeItem> list = Lists.newArrayList();
            list.add(getRandomDyeItem(rand));
            if (rand.nextFloat() > 0.7F) {
               list.add(getRandomDyeItem(rand));
            }

            if (rand.nextFloat() > 0.8F) {
               list.add(getRandomDyeItem(rand));
            }

            itemstack1 = IDyeableArmorItem.dyeItem(itemstack1, list);
         }

         return new MerchantOffer(itemstack, itemstack1, this.maxUses, this.xpValue, 0.2F);
      }

      private static DyeItem getRandomDyeItem(Random p_221232_0_) {
         return DyeItem.getItem(DyeColor.byId(p_221232_0_.nextInt(16)));
      }
   }

   static class EmeraldForItemsTrade implements TraderNirtreTrades.ITrade {
      private final Item tradeItem;
      private final int count;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EmeraldForItemsTrade(IItemProvider tradeItemIn, int countIn, int maxUsesIn, int xpValueIn) {
         this.tradeItem = tradeItemIn.asItem();
         this.count = countIn;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
         this.priceMultiplier = 0.05F;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(this.tradeItem, this.count);
         return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class RubyForItemsTrade implements TraderNirtreTrades.ITrade {
      private final Item tradeItem;
      private final int count;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public RubyForItemsTrade(IItemProvider tradeItemIn, int countIn, int maxUsesIn, int xpValueIn) {
         this.tradeItem = tradeItemIn.asItem();
         this.count = countIn;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
         this.priceMultiplier = 0.05F;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(this.tradeItem, this.count);
         return new MerchantOffer(itemstack, new ItemStack(ItemInit.RUBY.get()), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class EmeraldForMapTrade implements TraderNirtreTrades.ITrade {
      private final int count;
      private final Structure<?> structureName;
      private final MapDecoration.Type mapDecorationType;
      private final int maxUses;
      private final int xpValue;

      public EmeraldForMapTrade(int count, Structure<?> structureName, MapDecoration.Type mapDecorationType, int maxUses, int xpValue) {
         this.count = count;
         this.structureName = structureName;
         this.mapDecorationType = mapDecorationType;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         if (!(trader.world instanceof ServerWorld)) {
            return null;
         } else {
            ServerWorld serverworld = (ServerWorld)trader.world;
            BlockPos blockpos = serverworld.func_241117_a_(this.structureName, trader.getPosition(), 100, true);
            if (blockpos != null) {
               ItemStack itemstack = FilledMapItem.setupNewMap(serverworld, blockpos.getX(), blockpos.getZ(), (byte)2, true, true);
               FilledMapItem.func_226642_a_(serverworld, itemstack);
               MapData.addTargetDecoration(itemstack, blockpos, "+", this.mapDecorationType);
               itemstack.setDisplayName(new TranslationTextComponent("filled_map." + this.structureName.getStructureName().toLowerCase(Locale.ROOT)));
               return new MerchantOffer(new ItemStack(Items.EMERALD, this.count), new ItemStack(Items.COMPASS), itemstack, this.maxUses, this.xpValue, 0.2F);
            } else {
               return null;
            }
         }
      }
   }

   static class RubyForMapTrade implements TraderNirtreTrades.ITrade {
      private final int count;
      private final Structure<?> structureName;
      private final MapDecoration.Type mapDecorationType;
      private final int maxUses;
      private final int xpValue;

      public RubyForMapTrade(int count, Structure<?> structureName, MapDecoration.Type mapDecorationType, int maxUses, int xpValue) {
         this.count = count;
         this.structureName = structureName;
         this.mapDecorationType = mapDecorationType;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         if (!(trader.world instanceof ServerWorld)) {
            return null;
         } else {
            ServerWorld serverworld = (ServerWorld)trader.world;
            BlockPos blockpos = serverworld.func_241117_a_(this.structureName, trader.getPosition(), 100, true);
            if (blockpos != null) {
               ItemStack itemstack = FilledMapItem.setupNewMap(serverworld, blockpos.getX(), blockpos.getZ(), (byte)2, true, true);
               FilledMapItem.func_226642_a_(serverworld, itemstack);
               MapData.addTargetDecoration(itemstack, blockpos, "+", this.mapDecorationType);
               itemstack.setDisplayName(new TranslationTextComponent("filled_map." + this.structureName.getStructureName().toLowerCase(Locale.ROOT)));
               return new MerchantOffer(new ItemStack(ItemInit.RUBY.get(), this.count), new ItemStack(Items.COMPASS), itemstack, this.maxUses, this.xpValue, 0.2F);
            } else {
               return null;
            }
         }
      }
   }

   static class EmeraldForVillageTypeItemTrade implements TraderNirtreTrades.ITrade {
      private final Map<IVillagerType, Item> villagerTypeItems;
      private final int count;
      private final int maxUses;
      private final int xpValue;

      public EmeraldForVillageTypeItemTrade(int count, int maxUsesIn, int xpValueIn, Map<IVillagerType, Item> villagerTypeItemsIn) {
         Registry.VILLAGER_TYPE.stream().filter((villagerType) -> {
            return !villagerTypeItemsIn.containsKey(villagerType);
         }).findAny().ifPresent((villagerType) -> {
            throw new IllegalStateException("Missing trade for villager type: " + Registry.VILLAGER_TYPE.getKey(villagerType));
         });
         this.villagerTypeItems = villagerTypeItemsIn;
         this.count = count;
         this.maxUses = maxUsesIn;
         this.xpValue = xpValueIn;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         if (trader instanceof IVillagerDataHolder) {
            ItemStack itemstack = new ItemStack(this.villagerTypeItems.get(((IVillagerDataHolder)trader).getVillagerData().getType()), this.count);
            return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.maxUses, this.xpValue, 0.05F);
         } else {
            return null;
         }
      }
   }

   static class EnchantedBookForFirnsTrade implements TraderNirtreTrades.ITrade {
      private final int xpValue;

      public EnchantedBookForFirnsTrade(int xpValueIn) {
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(5 + i * 10) + 3 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 2048) {
            j = 2048;
         }

         return new MerchantOffer(new ItemStack(isBurnableItemInit.FIRN.get(), j), new ItemStack(Items.BOOK), itemstack, 120, this.xpValue, 2.4F);
      }
   }

   static class EnchantedBookForMlonksTrade implements TraderNirtreTrades.ITrade {
      private final int xpValue;

      public EnchantedBookForMlonksTrade(int xpValueIn) {
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(5 + i * 10) + 3 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 2048) {
            j = 2048;
         }

         return new MerchantOffer(new ItemStack(ItemInit.MLONK.get(), j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
      public MerchantOffer getOffer1(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(5 + i * 10) + 3 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 2048) {
            j = 2048;
         }

         return new MerchantOffer(new ItemStack(ItemInit.MLONK.get(), j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
   }

   static class EnchantedBookForRubiesTrade implements TraderNirtreTrades.ITrade {
      private final int xpValue;

      public EnchantedBookForRubiesTrade(int xpValueIn) {
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(5 + i * 10) + 3 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 64) {
            j = 64;
         }

         return new MerchantOffer(new ItemStack(ItemInit.RUBY.get(), j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
      public MerchantOffer getOffer1(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(5 + i * 10) + 3 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 64) {
            j = 64;
         }

         return new MerchantOffer(new ItemStack(ItemInit.RUBY.get(), j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
   }

   static class EnchantedItemForEmeraldsTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack sellingStack;
      private final int emeraldCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EnchantedItemForEmeraldsTrade(Item p_i50535_1_, int emeraldCount, int maxUses, int xpValue) {
         this(p_i50535_1_, emeraldCount, maxUses, xpValue, 0.05F);
      }

      public EnchantedItemForEmeraldsTrade(Item sellItem, int emeraldCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingStack = new ItemStack(sellItem);
         this.emeraldCount = emeraldCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.emeraldCount + i, 64);
         ItemStack itemstack1 = new ItemStack(Items.EMERALD, j);
         ItemStack itemstack2 = new ItemStack(Items.EMERALD, j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class EnchantedItemForRubiesTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack sellingStack;
      private final int rubyCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EnchantedItemForRubiesTrade(Item p_i50535_1_, int rubyCount, int maxUses, int xpValue) {
         this(p_i50535_1_, rubyCount, maxUses, xpValue, 0.05F);
      }

      public EnchantedItemForRubiesTrade(Item sellItem, int rubyCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingStack = new ItemStack(sellItem);
         this.rubyCount = rubyCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.rubyCount + i, 64);
         ItemStack itemstack1 = new ItemStack(ItemInit.RUBY.get(), j);
         ItemStack itemstack2 = new ItemStack(ItemInit.RUBY.get(), j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   public interface ITrade {
      @Nullable
      MerchantOffer getOffer(Entity trader, Random rand);
   }

   static class ItemWithPotionForEmeraldsAndItemsTrade implements TraderNirtreTrades.ITrade {
      /** An ItemStack that can have potion effects written to it. */
      private final ItemStack potionStack;
      private final int potionCount;
      private final int emeraldCount;
      private final int rubyCount;
      private final int maxUses;
      private final int xpValue;
      private final Item buyingItem;
      private final int buyingItemCount;
      private final float priceMultiplier;

      public ItemWithPotionForEmeraldsAndItemsTrade(Item buyingItem, int buyingItemCount, Item p_i50526_3_, int p_i50526_4_, int emeralds, int rubies, int maxUses, int xpValue) {
         this.potionStack = new ItemStack(p_i50526_3_);
         this.emeraldCount = emeralds;
         this.rubyCount = rubies;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.buyingItem = buyingItem;
         this.buyingItemCount = buyingItemCount;
         this.potionCount = p_i50526_4_;
         this.priceMultiplier = 0.05F;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(Items.EMERALD, this.emeraldCount);
         ItemStack itemstack_1 = new ItemStack(ItemInit.RUBY.get(), this.rubyCount);
         List<Potion> list = Registry.POTION.stream().filter((potion) -> {
            return !potion.getEffects().isEmpty() && PotionBrewing.isBrewablePotion(potion);
         }).collect(Collectors.toList());
         Potion potion = list.get(rand.nextInt(list.size()));
         ItemStack itemstack1 = PotionUtils.addPotionToItemStack(new ItemStack(this.potionStack.getItem(), this.potionCount), potion);
         return new MerchantOffer(itemstack, new ItemStack(this.buyingItem, this.buyingItemCount), itemstack1, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForEmeraldsAndItemsTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int emeraldCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForEmeraldsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int emeraldCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.emeraldCount = emeraldCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(ItemInit.RUBY.get(), this.emeraldCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForTgurnsAndItemsTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int tgurnCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForTgurnsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForTgurnsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int tgurnCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.tgurnCount = tgurnCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.TGURN.get(), this.tgurnCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForChaksTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int chakCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForChaksTrade(Block sellingItem, int chakCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), chakCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForChaksTrade(Item sellingItem, int chakCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), chakCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForChaksTrade(Item sellingItem, int chakCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), chakCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForChaksTrade(ItemStack sellingItem, int chakCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, chakCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForChaksTrade(ItemStack sellingItem, int chakCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.chakCount = chakCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(ItemInit.CHAK.get(), this.chakCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForKirtsTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int kirtCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForKirtsTrade(Block sellingItem, int kirtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), kirtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForKirtsTrade(Item sellingItem, int kirtCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), kirtCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForKirtsTrade(Item sellingItem, int kirtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), kirtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForKirtsTrade(ItemStack sellingItem, int kirtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, kirtCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForKirtsTrade(ItemStack sellingItem, int kirtCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.kirtCount = kirtCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(ItemInit.KIRT.get(), this.kirtCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForRottenFleshsTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int rottenFleshCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForRottenFleshsTrade(Block sellingItem, int rottenFleshCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rottenFleshCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRottenFleshsTrade(Item sellingItem, int rottenFleshCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), rottenFleshCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForRottenFleshsTrade(Item sellingItem, int rottenFleshCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rottenFleshCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRottenFleshsTrade(ItemStack sellingItem, int rottenFleshCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, rottenFleshCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForRottenFleshsTrade(ItemStack sellingItem, int rottenFleshCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.rottenFleshCount = rottenFleshCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.ROTTEN_FLESH, this.rottenFleshCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForFirnsTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int firnCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForFirnsTrade(Block sellingItem, int firnCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), firnCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForFirnsTrade(Item sellingItem, int firnCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), firnCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForFirnsTrade(Item sellingItem, int firnCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), firnCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForFirnsTrade(ItemStack sellingItem, int firnCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, firnCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForFirnsTrade(ItemStack sellingItem, int firnCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.firnCount = firnCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableItemInit.FIRN.get(), this.firnCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForGrutsTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int grutCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForGrutsTrade(Block sellingItem, int grutCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), grutCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForGrutsTrade(Item sellingItem, int grutCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), grutCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForGrutsTrade(Item sellingItem, int grutCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), grutCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForGrutsTrade(ItemStack sellingItem, int grutCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, grutCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForGrutsTrade(ItemStack sellingItem, int grutCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.grutCount = grutCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableItemInit.GRUT.get(), this.grutCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForEmeraldBlocksTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int emeraldBlockCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForEmeraldBlocksTrade(Block sellingItem, int emeraldBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), emeraldBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldBlocksTrade(Item sellingItem, int emeraldBlockCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), emeraldBlockCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForEmeraldBlocksTrade(Item sellingItem, int emeraldBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), emeraldBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldBlocksTrade(ItemStack sellingItem, int emeraldBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, emeraldBlockCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForEmeraldBlocksTrade(ItemStack sellingItem, int emeraldBlockCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.emeraldBlockCount = emeraldBlockCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.EMERALD_BLOCK, this.emeraldBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForRegdemBlocksAndItemsTrade implements TraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int regdemBlockCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForRegdemBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRegdemBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int regdemBlockCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.regdemBlockCount = regdemBlockCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(BlockItemInit.REGDEM_BLOCK.get(), this.regdemBlockCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class SuspiciousStewForEmeraldTrade implements TraderNirtreTrades.ITrade {
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