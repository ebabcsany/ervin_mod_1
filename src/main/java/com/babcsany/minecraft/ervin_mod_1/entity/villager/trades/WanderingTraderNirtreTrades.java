package com.babcsany.minecraft.ervin_mod_1.entity.villager.trades;

import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.BlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.isBurnableBlockNamedItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
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

public class WanderingTraderNirtreTrades {
   public static final Int2ObjectMap<WanderingTraderNirtreTrades.ITrade[]> field_221240_b = gatAsIntMap(ImmutableMap.of(1, new WanderingTraderNirtreTrades.ITrade[]{
           /*new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.SEA_PICKLE, 2, 1, 5, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.SLIME_BALL, 4, 1, 5, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.GLOWSTONE, 2, 1, 5, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.NAUTILUS_SHELL, 5, 1, 5, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.FERN, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.SUGAR_CANE, 1, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.PUMPKIN, 1, 1, 4, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.KELP, 3, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.CACTUS, 3, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.DANDELION, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.POPPY, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BLUE_ORCHID, 1, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.ALLIUM, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.AZURE_BLUET, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.RED_TULIP, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.ORANGE_TULIP, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.WHITE_TULIP, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.PINK_TULIP, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.OXEYE_DAISY, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.CORNFLOWER, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.LILY_OF_THE_VALLEY, 1, 1, 7, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.WHEAT_SEEDS, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BEETROOT_SEEDS, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.PUMPKIN_SEEDS, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.MELON_SEEDS, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.ACACIA_SAPLING, 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BIRCH_SAPLING, 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.DARK_OAK_SAPLING, 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.JUNGLE_SAPLING, 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.OAK_SAPLING, 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.SPRUCE_SAPLING, 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.RED_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.WHITE_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BLUE_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.PINK_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BLACK_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.GREEN_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.LIGHT_GRAY_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.MAGENTA_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.YELLOW_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.GRAY_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.PURPLE_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.LIGHT_BLUE_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.LIME_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.ORANGE_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BROWN_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.CYAN_DYE, 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(ItemInit.LIGHT_BLUE1_DYE.get(), 1, 3, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BRAIN_CORAL_BLOCK, 3, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BUBBLE_CORAL_BLOCK, 3, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.FIRE_CORAL_BLOCK, 3, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.HORN_CORAL_BLOCK, 3, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.TUBE_CORAL_BLOCK, 3, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.VINE, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BROWN_MUSHROOM, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.RED_MUSHROOM, 1, 1, 12, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.LILY_PAD, 1, 2, 5, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.SAND, 1, 8, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.RED_SAND, 1, 4, 6, 1)}, 2, new WanderingTraderNirtreTrades.ITrade[]{
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.TROPICAL_FISH_BUCKET, 5, 1, 4, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.PUFFERFISH_BUCKET, 5, 1, 4, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.PACKED_ICE, 3, 1, 6, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.BLUE_ICE, 6, 1, 6, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.GUNPOWDER, 1, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.WRITABLE_BOOK, 13, 1, 4, 1),
           new WanderingTraderNirtreTrades.ItemsForEmeraldsTrade(Items.PODZOL, 3, 3, 6, 1)}, 3, new WanderingTraderNirtreTrades.ITrade[]{*/
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(BlockItemInit.FIRG_SAPLING.get(), 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(BlockItemInit.FRIM_SAPLING.get(), 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(isBurnableItemInit.NARIN.get(), 20, 1, 4, 4),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(isBurnableBlockItemInit.TBRUHV.get(), 30, 1, 10, 2),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(ItemInit.PACK.get(), 4, 1, 50, 1),
           new WanderingTraderNirtreTrades.ItemsForRubyBlocksTrade(isBurnableItemInit.AVTER.get(), 40, 1, 20, 3),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(isBurnableBlockItemInit.DRIOP.get(), 1, 5, 100, 1),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(BlockItemInit.EXAMPLE_BLOCK.get(), 3, 1, 7, 2),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(ItemInit.FIRT.get(), 1, 4, 14, 1),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(isBurnableItemInit.VILKT.get(), 35, 1, 2, 6),
           new WanderingTraderNirtreTrades.ItemsForSrurgsTrade(ItemInit.CHAK.get(), 20, 1, 120, 26),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(FoodItemInit.FRIM.get(), 25, 1, 22, 2),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(BlockNamedItemInit.TARG_SEEDS.get(), 2, 1, 5, 1),
           new WanderingTraderNirtreTrades.ItemsForNautilusShellsTrade(BlockItemInit.DURT.get(), 5, 1, 20, 3),
           new WanderingTraderNirtreTrades.ItemsForMlonksTrade(isBurnableBlockItemInit.SHZ_BLOCK.get(), 4, 1, 10, 2),
           new WanderingTraderNirtreTrades.ItemsForMlonksTrade(ItemInit.SPAWN_EGG_1.get(), 20, 1, 10, 2),
           new WanderingTraderNirtreTrades.ItemsForObsidiansTrade(BlockItemInit.TRIRIJ.get(), 10, 1, 1000, 2),
           new WanderingTraderNirtreTrades.ItemsForGrassBlocksTrade(ModSpawnEggItemInit.ZUR_ENTITY_SPAWN_EGG.get(), 4, 1, 9, 1),
           new WanderingTraderNirtreTrades.ItemsForDreinsTrade(ModSpawnEggItemInit.$_TRADER_SPAWN_EGG.get(), 10, 1, 20, 3),
           new WanderingTraderNirtreTrades.ItemsForSriunkBlocksTrade(isBurnableBlockItemInit.RETRUG.get(), 4, 1, 4, 10),
           new WanderingTraderNirtreTrades.ItemsForTrurksAndItemsTrade(com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableItemInit.CRAINT.get(), 1, isBurnableBlockItemInit.RETRUG.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForTrurksAndItemsTrade(isBurnableItemInit.DURG.get(), 1, BlockItemInit.CRASK.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForTrurksAndItemsTrade(isBurnableBlockItemInit.SRIUNK_BLOCK.get(), 1, isBurnableBlockItemInit.SRURG.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForSrurgsAndBlocksTrade(isBurnableBlockItemInit.GRINT_BLOCK.get(), 4, BlockItemInit.DEF_BLOCK.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForSrurgsAndItemsTrade(BlockItemInit.KALT_BLOCK.get(), 10, isBurnableBlockNamedItemInit.GRITH_BLOCK.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForSrurgsAndItemsTrade(Items.ANCIENT_DEBRIS, 1, ItemInit.FRIN.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsFor60SrurgsAndItemsTrade(isBurnableItemInit.TIRKS.get(), 60, com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableItemInit.TERAT.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForEnchantedBooksTrade(isBurnableBlockItemInit.EPKIH.get(), 1, 64, 1200, 4),
           new WanderingTraderNirtreTrades.ItemsForLeatBlockCraftingTablesTrade(isBurnableBlockItemInit.DRIOP.get(), 1, 10, 64, 4),
           new WanderingTraderNirtreTrades.EnchantedBlockForDurgsTrade(isBurnableBlockItemInit.NIRTK.get(), 40, 1000, 64, 8),
           new WanderingTraderNirtreTrades.ItemsForNirtksAndBlocksTrade(BlockItemInit.AIR.get(), 1, isBurnableBlockItemInit.NIRTKB.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.EnchantedBookForFirnsTrade(10),
   }));

   private static Int2ObjectMap<WanderingTraderNirtreTrades.ITrade[]> gatAsIntMap(ImmutableMap<Integer, WanderingTraderNirtreTrades.ITrade[]> p_221238_0_) {
      return new Int2ObjectOpenHashMap<>(p_221238_0_);
   }

   static class DyedArmorForEmeraldsTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class EnchantedBookForFirnsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final int xpValue;

      public EnchantedBookForFirnsTrade(int xpValueIn) {
         this.xpValue = xpValueIn;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         List<Enchantment> list = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
         Enchantment enchantment = list.get(rand.nextInt(list.size()));
         int i = MathHelper.nextInt(rand, enchantment.getMinLevel(), enchantment.getMaxLevel());
         ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));
         int j = 2 + rand.nextInt(10 + i * 100) + 30 * i;
         if (enchantment.isTreasureEnchantment()) {
            j *= 2;
         }

         if (j > 64) {
            j = 64;
         }

         return new MerchantOffer(new ItemStack(isBurnableItemInit.FIRN.get(), j), new ItemStack(Items.BOOK), itemstack, 120, this.xpValue, 2.4F);
      }
   }

   static class DyedArmorForRubiesTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class EmeraldForItemsTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class RubyForItemsTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class EmeraldForMapTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class RubyForMapTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class EmeraldForVillageTypeItemTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class EnchantedBookForRubiesTrade implements WanderingTraderNirtreTrades.ITrade {
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

         if (j > 2048) {
            j = 2048;
         }

         return new MerchantOffer(new ItemStack(ItemInit.RUBY.get(), j), new ItemStack(Items.BOOK), itemstack, 12, this.xpValue, 0.2F);
      }
   }

   static class EnchantedItemForEmeraldsTrade implements WanderingTraderNirtreTrades.ITrade {
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
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class EnchantedItemForRubiesTrade implements WanderingTraderNirtreTrades.ITrade {
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
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class EnchantedBlockForDurgsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingStack;
      private final int durgCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EnchantedBlockForDurgsTrade(Block p_i50535_1_, int durgCount, int maxUses, int xpValue) {
         this(p_i50535_1_, durgCount, maxUses, xpValue, 0.05F);
      }

      public EnchantedBlockForDurgsTrade(Block sellItem, int durgCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingStack = new ItemStack(sellItem);
         this.durgCount = durgCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.durgCount + i, 64);
         ItemStack itemstack1 = new ItemStack(isBurnableItemInit.DURG.get(), j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForEnchantedBlockForDurgsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final ItemStack sellingStack;
      private final int buyingItemCount;
      private final int durgCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForEnchantedBlockForDurgsTrade(IItemProvider buyingItem, int buyingItemCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEnchantedBlockForDurgsTrade(IItemProvider buyingItem, int buyingItemCount, int durgCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.sellingStack = new ItemStack(sellingItem);
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.durgCount = durgCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.durgCount + i, 64);
         ItemStack itemstack1 = new ItemStack(isBurnableItemInit.DURG.get(), j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class EnchantedBlockForNirtksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingStack;
      private final int nirtkCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EnchantedBlockForNirtksTrade(Block p_i50535_1_, int nirtkCount, int maxUses, int xpValue) {
         this(p_i50535_1_, nirtkCount, maxUses, xpValue, 0.05F);
      }

      public EnchantedBlockForNirtksTrade(Block sellItem, int nirtkCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingStack = new ItemStack(sellItem);
         this.nirtkCount = nirtkCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.nirtkCount + i, 64);
         ItemStack itemstack1 = new ItemStack(isBurnableBlockItemInit.NIRTK.get(), j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemWithPotionForTrurksAndItemsTrade implements WanderingTraderNirtreTrades.ITrade {
      /** An ItemStack that can have potion effects written to it. */
      private final ItemStack potionStack;
      private final int potionCount;
      private final int trurkCount;
      private final int maxUses;
      private final int xpValue;
      private final Block buyingItem;
      private final int buyingItemCount;
      private final float priceMultiplier;

      public ItemWithPotionForTrurksAndItemsTrade(Block buyingItem, int buyingItemCount, BlockItem p_i50526_3_, int p_i50526_4_, int trurks, int maxUses, int xpValue) {
         this.potionStack = new ItemStack(p_i50526_3_);
         this.trurkCount = trurks;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.buyingItem = buyingItem;
         this.buyingItemCount = buyingItemCount;
         this.potionCount = p_i50526_4_;
         this.priceMultiplier = 0.05F;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         ItemStack itemstack = new ItemStack(Items.EMERALD, this.trurkCount);
         List<Potion> list = Registry.POTION.stream().filter((potion) -> {
            return !potion.getEffects().isEmpty() && PotionBrewing.isBrewablePotion(potion);
         }).collect(Collectors.toList());
         Potion potion = list.get(rand.nextInt(list.size()));
         ItemStack itemstack1 = PotionUtils.addPotionToItemStack(new ItemStack(this.potionStack.getItem(), this.potionCount), potion);
         return new MerchantOffer(itemstack, new ItemStack(this.buyingItem, this.buyingItemCount), itemstack1, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForTrurksAndItemsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int trurkCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForTrurksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForTrurksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int trurkCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.trurkCount = trurkCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.TRURK.get(), this.trurkCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForSrurgsAndBlocksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int srurgCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForSrurgsAndBlocksTrade(IItemProvider buyingItem, int buyingItemCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForSrurgsAndBlocksTrade(IItemProvider buyingItem, int buyingItemCount, int srurgCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.srurgCount = srurgCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.SRURG.get(), this.srurgCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForSrurgsAndItemsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int srurgCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForSrurgsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForSrurgsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int srurgCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.srurgCount = srurgCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.SRURG.get(), this.srurgCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForNirtksAndBlocksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int nirtkCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForNirtksAndBlocksTrade(IItemProvider buyingItem, int buyingItemCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForNirtksAndBlocksTrade(IItemProvider buyingItem, int buyingItemCount, int nirtkCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.nirtkCount = nirtkCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.NIRTK.get(), this.nirtkCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor60SrurgsAndItemsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int srurgCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor60SrurgsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 60, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor60SrurgsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int srurgCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.srurgCount = srurgCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.SRURG.get(), this.srurgCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForEmeraldsTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class ItemsForRubiesTrade implements WanderingTraderNirtreTrades.ITrade {
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
         this(new ItemStack(sellingItem), rubyCount, sellingItemCount, 120, xpValue);
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

   static class ItemsForAvtersTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int avterCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForAvtersTrade(Block sellingItem, int avterCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), avterCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForAvtersTrade(Item sellingItem, int avterCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), avterCount, sellingItemCount, 120, xpValue);
      }

      public ItemsForAvtersTrade(Item sellingItem, int avterCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), avterCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForAvtersTrade(ItemStack sellingItem, int avterCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, avterCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForAvtersTrade(ItemStack sellingItem, int avterCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.avterCount = avterCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableItemInit.AVTER.get(), this.avterCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForRubyBlocksTrade1 implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int rubyBlockCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForRubyBlocksTrade1(Block sellingItem, int rubyBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rubyBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRubyBlocksTrade1(Item sellingItem, int rubyBlockCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), rubyBlockCount, sellingItemCount, 120, xpValue);
      }

      public ItemsForRubyBlocksTrade1(Item sellingItem, int rubyBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rubyBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRubyBlocksTrade1(ItemStack sellingItem, int rubyBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, rubyBlockCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForRubyBlocksTrade1(ItemStack sellingItem, int rubyBlockCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.rubyBlockCount = rubyBlockCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(BlockItemInit.RUBY_BLOCK.get(), this.rubyBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForRubyBlocksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int rubyBlockCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForRubyBlocksTrade(Block sellingItem, int rubyBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rubyBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRubyBlocksTrade(Item sellingItem, int rubyBlockCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), rubyBlockCount, sellingItemCount, 120, xpValue);
      }

      public ItemsForRubyBlocksTrade(Item sellingItem, int rubyBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rubyBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRubyBlocksTrade(ItemStack sellingItem, int rubyBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, rubyBlockCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForRubyBlocksTrade(ItemStack sellingItem, int rubyBlockCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.rubyBlockCount = rubyBlockCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(BlockItemInit.RUBY_BLOCK.get(), this.rubyBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForSrurgsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int srurgCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForSrurgsTrade(Block sellingItem, int srurgCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), srurgCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForSrurgsTrade(Item sellingItem, int srurgCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), srurgCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForSrurgsTrade(Item sellingItem, int srurgCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), srurgCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForSrurgsTrade(ItemStack sellingItem, int srurgCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, srurgCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForSrurgsTrade(ItemStack sellingItem, int srurgCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.srurgCount = srurgCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.SRURG.get(), this.srurgCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForNautilusShellsTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class ItemsForMlonksTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class ItemsForObsidiansTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int obsidianCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForObsidiansTrade(Block sellingItem, int obsidianCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), obsidianCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForObsidiansTrade(Item sellingItem, int obsidianCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), obsidianCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForObsidiansTrade(Item sellingItem, int obsidianCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), obsidianCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForObsidiansTrade(ItemStack sellingItem, int obsidianCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, obsidianCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForObsidiansTrade(ItemStack sellingItem, int obsidianCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.obsidianCount = obsidianCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.OBSIDIAN, this.obsidianCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForGrassBlocksTrade implements WanderingTraderNirtreTrades.ITrade {
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

   static class ItemsForSriunkBlocksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int sriunkBlockCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForSriunkBlocksTrade(Block sellingItem, int sriunkBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), sriunkBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForSriunkBlocksTrade(Item sellingItem, int sriunkBlockCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), sriunkBlockCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForSriunkBlocksTrade(Item sellingItem, int sriunkBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), sriunkBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForSriunkBlocksTrade(ItemStack sellingItem, int sriunkBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, sriunkBlockCount, maxUses, maxUses, xpValue, 0.05F);
      }

      public ItemsForSriunkBlocksTrade(ItemStack sellingItem, int sriunkBlockCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.sriunkBlockCount = sriunkBlockCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.SRIUNK_BLOCK.get(), this.sriunkBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForDreinsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int dreinCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForDreinsTrade(Block sellingItem, int dreinCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), dreinCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForDreinsTrade(Item sellingItem, int dreinCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), dreinCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForDreinsTrade(Item sellingItem, int dreinCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), dreinCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForDreinsTrade(ItemStack sellingItem, int dreinCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, dreinCount, maxUses, maxUses, xpValue, 0.05F);
      }

      public ItemsForDreinsTrade(ItemStack sellingItem, int dreinCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.dreinCount = dreinCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(ItemInit.DREIN.get(), this.dreinCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForLeatBlockCraftingTablesTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int leatBlockCraftingTableCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForLeatBlockCraftingTablesTrade(Block sellingItem, int leatBlockCraftingTableCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), leatBlockCraftingTableCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForLeatBlockCraftingTablesTrade(Item sellingItem, int leatBlockCraftingTableCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), leatBlockCraftingTableCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForLeatBlockCraftingTablesTrade(Item sellingItem, int leatBlockCraftingTableCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), leatBlockCraftingTableCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForLeatBlockCraftingTablesTrade(ItemStack sellingItem, int leatBlockCraftingTableCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, leatBlockCraftingTableCount, maxUses, maxUses, xpValue, 0.05F);
      }

      public ItemsForLeatBlockCraftingTablesTrade(ItemStack sellingItem, int leatBlockCraftingTableCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.leatBlockCraftingTableCount = leatBlockCraftingTableCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.LEAT_BLOCK_CRAFTING_TABLE.get(), this.leatBlockCraftingTableCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForEnchantedBooksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int enchantedBookCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForEnchantedBooksTrade(Block sellingItem, int enchantedBookCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), enchantedBookCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEnchantedBooksTrade(Item sellingItem, int enchantedBookCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), enchantedBookCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForEnchantedBooksTrade(Item sellingItem, int enchantedBookCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), enchantedBookCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEnchantedBooksTrade(ItemStack sellingItem, int enchantedBookCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, enchantedBookCount, maxUses, maxUses, xpValue, 0.05F);
      }

      public ItemsForEnchantedBooksTrade(ItemStack sellingItem, int enchantedBookCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.enchantedBookCount = enchantedBookCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Items.ENCHANTED_BOOK, this.enchantedBookCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class SuspiciousStewForEmeraldTrade implements WanderingTraderNirtreTrades.ITrade {
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

   public interface ITrade {
      @Nullable
      MerchantOffer getOffer(Entity trader, Random rand);
   }
}