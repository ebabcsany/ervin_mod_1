package com.babcsany.minecraft.ervin_mod_1.entity.villager;

import com.babcsany.minecraft.ervin_mod_1.init.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.ItemInit;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.villager.IVillagerDataHolder;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.Util;
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

public class NirtreTrades {
   /*public static final Map<NirtreProfession, Int2ObjectMap<NirtreTrades.ITrade[]>> VILLAGER_DEFAULT_TRADES = Util.make(Maps.newHashMap(), (p_221237_0_) -> {
      p_221237_0_.put(NirtreProfession.NIRTRE, gatAsIntMap(ImmutableMap.of(1, new NirtreTrades.ITrade[]{new NirtreTrades.EmeraldForItemsTrade(Items.WHEAT, 20, 16, 2), new NirtreTrades.EmeraldForItemsTrade(Items.POTATO, 26, 16, 2), new NirtreTrades.EmeraldForItemsTrade(Items.CARROT, 22, 16, 2), new NirtreTrades.EmeraldForItemsTrade(Items.BEETROOT, 15, 16, 2), new NirtreTrades.ItemsForEmeraldsTrade(Items.BREAD, 1, 6, 16, 1)}, 2, new NirtreTrades.ITrade[]{new NirtreTrades.EmeraldForItemsTrade(Blocks.PUMPKIN, 6, 12, 10), new NirtreTrades.ItemsForEmeraldsTrade(Items.PUMPKIN_PIE, 1, 4, 5), new NirtreTrades.ItemsForEmeraldsTrade(Items.APPLE, 1, 4, 16, 5)}, 3, new NirtreTrades.ITrade[]{new NirtreTrades.ItemsForEmeraldsTrade(Items.COOKIE, 3, 18, 10), new NirtreTrades.EmeraldForItemsTrade(Blocks.MELON, 4, 12, 20)}, 4, new NirtreTrades.ITrade[]{new NirtreTrades.ItemsForEmeraldsTrade(Blocks.CAKE, 1, 1, 12, 15), new NirtreTrades.SuspiciousStewForEmeraldTrade(Effects.NIGHT_VISION, 100, 15), new NirtreTrades.SuspiciousStewForEmeraldTrade(Effects.JUMP_BOOST, 160, 15), new NirtreTrades.SuspiciousStewForEmeraldTrade(Effects.WEAKNESS, 140, 15), new NirtreTrades.SuspiciousStewForEmeraldTrade(Effects.BLINDNESS, 120, 15), new NirtreTrades.SuspiciousStewForEmeraldTrade(Effects.POISON, 280, 15), new NirtreTrades.SuspiciousStewForEmeraldTrade(Effects.SATURATION, 7, 15)}, 5, new NirtreTrades.ITrade[]{new NirtreTrades.ItemsForEmeraldsTrade(Items.GOLDEN_CARROT, 3, 3, 30), new NirtreTrades.ItemsForEmeraldsTrade(Items.GLISTERING_MELON_SLICE, 4, 3, 30)})));
   });*/
   public static final Int2ObjectMap<NirtreTrades.ITrade[]> field_221240_b = gatAsIntMap(ImmutableMap.of(1, new NirtreTrades.ITrade[]{
           new NirtreTrades.ItemsForEmeraldsTrade(Items.SEA_PICKLE, 2, 1, 5, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.SLIME_BALL, 4, 1, 5, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.GLOWSTONE, 2, 1, 5, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.NAUTILUS_SHELL, 5, 1, 5, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.FERN, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.SUGAR_CANE, 1, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.PUMPKIN, 1, 1, 4, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.KELP, 3, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.CACTUS, 3, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.DANDELION, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.POPPY, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BLUE_ORCHID, 1, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.ALLIUM, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.AZURE_BLUET, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.RED_TULIP, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.ORANGE_TULIP, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.WHITE_TULIP, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.PINK_TULIP, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.OXEYE_DAISY, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.CORNFLOWER, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.LILY_OF_THE_VALLEY, 1, 1, 7, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.WHEAT_SEEDS, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BEETROOT_SEEDS, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.PUMPKIN_SEEDS, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.MELON_SEEDS, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.ACACIA_SAPLING, 5, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BIRCH_SAPLING, 5, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.DARK_OAK_SAPLING, 5, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.JUNGLE_SAPLING, 5, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.OAK_SAPLING, 5, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.SPRUCE_SAPLING, 5, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.RED_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.WHITE_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BLUE_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.PINK_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BLACK_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.GREEN_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.LIGHT_GRAY_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.MAGENTA_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.YELLOW_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.GRAY_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.PURPLE_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.LIGHT_BLUE_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.LIME_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.ORANGE_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BROWN_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.CYAN_DYE, 1, 3, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BRAIN_CORAL_BLOCK, 3, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BUBBLE_CORAL_BLOCK, 3, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.FIRE_CORAL_BLOCK, 3, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.HORN_CORAL_BLOCK, 3, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.TUBE_CORAL_BLOCK, 3, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.VINE, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BROWN_MUSHROOM, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.RED_MUSHROOM, 1, 1, 12, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.LILY_PAD, 1, 2, 5, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.SAND, 1, 8, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.RED_SAND, 1, 4, 6, 1)}, 2, new NirtreTrades.ITrade[]{
           new NirtreTrades.ItemsForEmeraldsTrade(Items.TROPICAL_FISH_BUCKET, 5, 1, 4, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.PUFFERFISH_BUCKET, 5, 1, 4, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.PACKED_ICE, 3, 1, 6, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.BLUE_ICE, 6, 1, 6, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.GUNPOWDER, 1, 1, 8, 1),
           new NirtreTrades.ItemsForEmeraldsTrade(Items.PODZOL, 3, 3, 6, 1)}, 3, new NirtreTrades.ITrade[]{
           new NirtreTrades.ItemsForRubiesTrade(BlockInit.FIRG_SAPLING.get(), 5, 1, 8, 1),
           new NirtreTrades.ItemsForRubiesTrade(BlockInit.FRIM_SAPLING.get(), 5, 1, 8, 1),
           new NirtreTrades.ItemsForRubiesTrade(ItemInit.NARIN.get(), 20, 1, 4, 4),
           new NirtreTrades.ItemsForRubiesTrade(ItemInit.SRIUNK.get(), 30, 1, 10, 2),
           new NirtreTrades.ItemsForRubiesTrade(ItemInit.PACK.get(), 4, 1, 50, 1),
           new NirtreTrades.ItemsForRubiesTrade(ItemInit.LEAT.get(), 40, 1, 20, 3),
           new NirtreTrades.ItemsForRubiesTrade(BlockInit.FIRG.get(), 1, 5, 100, 1),
           new NirtreTrades.ItemsForRubiesTrade(BlockInit.EXAMPLE_BLOCK.get(), 3, 1, 7, 2),
           new NirtreTrades.ItemsForRubiesTrade(ItemInit.FIRT.get(), 1, 4, 14, 1),
           new NirtreTrades.ItemsForRubiesTrade(ItemInit.VILKT.get(), 35, 1, 2, 6),
           new NirtreTrades.ItemsForRubiesTrade(ItemInit.GRINT.get(), 25, 1, 22, 2),
           new NirtreTrades.ItemsForRubiesTrade(ItemInit.TARG_SEEDS.get(), 2, 1, 5, 1),
           new NirtreTrades.ItemsForNautilusShellsTrade(BlockInit.DURT.get(), 5, 1, 20, 3),
           new NirtreTrades.ItemsForMlonksTrade(BlockInit.SHZ_BLOCK.get(), 4, 1, 10, 2),
           new NirtreTrades.ItemsForGrassBlocksTrade(ItemInit.ZUR_ENTITY_SPAWN_EGG.get(), 4, 1, 9, 1),
   }));

   private static Int2ObjectMap<NirtreTrades.ITrade[]> gatAsIntMap(ImmutableMap<Integer, NirtreTrades.ITrade[]> p_221238_0_) {
      return new Int2ObjectOpenHashMap<>(p_221238_0_);
   }

   static class DyedArmorForEmeraldsTrade implements NirtreTrades.ITrade {
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

   static class DyedArmorForRubiesTrade implements NirtreTrades.ITrade {
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

   static class EmeraldForItemsTrade implements NirtreTrades.ITrade {
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

   static class RubyForItemsTrade implements NirtreTrades.ITrade {
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

   static class EmeraldForMapTrade implements NirtreTrades.ITrade {
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

   static class RubyForMapTrade implements NirtreTrades.ITrade {
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

   static class EmeraldForVillageTypeItemTrade implements NirtreTrades.ITrade {
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

   static class EnchantedBookForEmeraldsTrade implements NirtreTrades.ITrade {
      private final int xpValue;

      public EnchantedBookForEmeraldsTrade(int xpValueIn) {
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

         return new MerchantOffer(new ItemStack(Items.EMERALD, j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
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

         return new MerchantOffer(new ItemStack(Items.EMERALD, j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
   }

   static class EnchantedBookForRubiesTrade implements NirtreTrades.ITrade {
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

   static class EnchantedItemForEmeraldsTrade implements NirtreTrades.ITrade {
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

   static class EnchantedItemForRubiesTrade implements NirtreTrades.ITrade {
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

   static class ItemWithPotionForEmeraldsAndItemsTrade implements NirtreTrades.ITrade {
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

   static class ItemsForEmeraldsAndItemsTrade implements NirtreTrades.ITrade {
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

   static class ItemsForEmeraldsTrade implements NirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int emeraldCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForEmeraldsTrade(Block sellingItem, int emeraldCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), emeraldCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldsTrade(Item sellingItem, int emeraldCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), emeraldCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForEmeraldsTrade(Item sellingItem, int emeraldCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), emeraldCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEmeraldsTrade(ItemStack sellingItem, int emeraldCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, emeraldCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForEmeraldsTrade(ItemStack sellingItem, int emeraldCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.emeraldCount = emeraldCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.EMERALD, this.emeraldCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForRubiesTrade implements NirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int rubyCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForRubiesTrade(Block sellingItem, int rubyCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rubyCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRubiesTrade(Item sellingItem, int rubyCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), rubyCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForRubiesTrade(Item sellingItem, int rubyCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rubyCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRubiesTrade(ItemStack sellingItem, int rubyCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, rubyCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForRubiesTrade(ItemStack sellingItem, int rubyCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.rubyCount = rubyCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(ItemInit.RUBY.get(), this.rubyCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForNautilusShellsTrade implements NirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int nautilusShellCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForNautilusShellsTrade(Block sellingItem, int nautilusShellCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), nautilusShellCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForNautilusShellsTrade(Item sellingItem, int nautilusShellCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), nautilusShellCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForNautilusShellsTrade(Item sellingItem, int nautilusShellCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), nautilusShellCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForNautilusShellsTrade(ItemStack sellingItem, int nautilusShellCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, nautilusShellCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForNautilusShellsTrade(ItemStack sellingItem, int nautilusShellCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.nautilusShellCount = nautilusShellCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.NAUTILUS_SHELL, this.nautilusShellCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForMlonksTrade implements NirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int mlonkCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForMlonksTrade(Block sellingItem, int mlonkCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), mlonkCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForMlonksTrade(Item sellingItem, int mlonkCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), mlonkCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForMlonksTrade(Item sellingItem, int mlonkCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), mlonkCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForMlonksTrade(ItemStack sellingItem, int mlonkCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, mlonkCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForMlonksTrade(ItemStack sellingItem, int mlonkCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.mlonkCount = mlonkCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(ItemInit.MLONK.get(), this.mlonkCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForGrassBlocksTrade implements NirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int grassBlockCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForGrassBlocksTrade(Block sellingItem, int grassBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), grassBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForGrassBlocksTrade(Item sellingItem, int grassBlockCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), grassBlockCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForGrassBlocksTrade(Item sellingItem, int grassBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), grassBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForGrassBlocksTrade(ItemStack sellingItem, int grassBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, grassBlockCount, maxUses, maxUses, xpValue, 0.05F);
      }

      public ItemsForGrassBlocksTrade(ItemStack sellingItem, int grassBlockCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.grassBlockCount = grassBlockCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.GRASS_BLOCK, this.grassBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class SuspiciousStewForEmeraldTrade implements NirtreTrades.ITrade {
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
         return new MerchantOffer(new ItemStack(ItemInit.RUBY.get(), 1), itemstack, 12, this.xpValue, this.priceMultiplier);
      }
   }
}