package com.babcsany.minecraft.ervin_mod_1.entity.villager.trades;

import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.block.crops.seeds.SeedsItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.FoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.SpecialBlockFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.isBurnableSpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableSpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.minecraft.item.spawn_egg.SpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.special.SpecialItemInit;
import com.babcsany.minecraft.init.BlockItemInit;
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
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class WanderingTraderNirtreTrades {
   public static final Int2ObjectMap<WanderingTraderNirtreTrades.ITrade[]> trade1 = gatAsIntMap(ImmutableMap.of(1, new WanderingTraderNirtreTrades.ITrade[]{
           new WanderingTraderNirtreTrades.EmeraldForItemsTrade(ItemInit.NIRG.get(), 1, 1000, 8),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(isBurnableBlockItemInit.FIRG_SAPLING.get(), 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.FRIM_SAPLING.get(), 5, 1, 8, 1),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(isBurnableItemInit.NARIN.get(), 20, 1, 4, 4),
           new WanderingTraderNirtreTrades.ItemsForRubyBlocksTrade(isBurnableBlockItemInit.TBRUHV.get(), 30, 1, 10, 2),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(ItemInit.PACK.get(), 4, 1, 50, 1),
           new WanderingTraderNirtreTrades.ItemsForRubyBlocksTrade(isBurnableItemInit.AVTER.get(), 40, 1, 20, 3),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(isBurnableBlockItemInit.DRIOP.get(), 1, 5, 100, 1),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(ItemInit.FIRT.get(), 1, 4, 14, 1),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(isBurnableItemInit.VILKT.get(), 35, 1, 2, 6),
           new WanderingTraderNirtreTrades.ItemsForSrurgsTrade(ItemInit.CHAK.get(), 20, 1, 120, 26),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(FoodItemInit.FRIM.get(), 25, 1, 22, 2),
           new WanderingTraderNirtreTrades.ItemsForRubiesTrade(SeedsItemInit.TARG_SEEDS.get(), 2, 1, 5, 1),
           new WanderingTraderNirtreTrades.ItemsForNautilusShellsTrade(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.DURT.get(), 5, 1, 20, 3),
           new WanderingTraderNirtreTrades.ItemsForMlonksTrade(isBurnableBlockItemInit.SHZ_BLOCK.get(), 4, 1, 10, 2),
           new WanderingTraderNirtreTrades.ItemsForMlonksTrade(ModSpawnEggItemInit.FREIN_SPAWN_EGG.get(), 20, 1, 10, 2),
           new WanderingTraderNirtreTrades.ItemsForObsidiansTrade(com.babcsany.minecraft.init.BlockItemInit.TRIRIJ.get(), 10, 1, 1000, 2),
           new WanderingTraderNirtreTrades.ItemsForGrassBlocksTrade(ModSpawnEggItemInit.ZUR_SPAWN_EGG.get(), 4, 1, 9, 1),
           new WanderingTraderNirtreTrades.ItemsForDreinsTrade(ModSpawnEggItemInit.$_TRADER_SPAWN_EGG.get(), 10, 1, 40, 3),
           new WanderingTraderNirtreTrades.ItemsForDreinsTrade(SpawnEggItemInit.LIGHTNING_BOLT_SPAWN_EGG.get(), 1, 1, 40000, 8),
           new WanderingTraderNirtreTrades.ItemsForSriunkBlocksTrade(isBurnableBlockItemInit.RETRUG.get(), 1, 4, 4, 10),
           new WanderingTraderNirtreTrades.ItemsForTrurksAndItemsTrade(SpecialToolItemInit.CRAINT.get(), 1, isBurnableBlockItemInit.RETRUG.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForTrurksAndItemsTrade(isBurnableFoodItemInit.DURG.get(), 1, isBurnableBlockItemInit.CRASK.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForTrurksAndItemsTrade(isBurnableBlockItemInit.SRIUNK_BLOCK.get(), 1, isBurnableBlockItemInit.SRURG.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForSrurgsAndBlocksTrade(SpecialBlockFoodItemInit.GRINT_BLOCK.get(), 4, com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.DEFERRED_BLOCK, 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForSrurgsAndItemsTrade(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.KALT_BLOCK.get(), 30, isBurnableSpecialItemInit.GRITH.get(), 1, 16, 10),
           new WanderingTraderNirtreTrades.ItemsForSrurgsAndItemsTrade(isBurnableItemInit.SRIUNK.get(), 1, ItemInit.FRIN.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsFor60SrurgsAndItemsTrade(isBurnableFoodItemInit.TIRKS.get(), 60, isBurnableSpecialToolItemInit.TERAT.get(), 1, 16, 1),
           new WanderingTraderNirtreTrades.ItemsForEnchantedBooksTrade(isBurnableBlockItemInit.EPKIH.get(), 1, 64, 1200, 4),
           new WanderingTraderNirtreTrades.ItemsForLeatBlockCraftingTablesTrade(isBurnableBlockItemInit.DRIOP.get(), 1, 10, 64, 4),
           new WanderingTraderNirtreTrades.EnchantedBlockForDurgsTrade(isBurnableBlockItemInit.NIRTK.get(), 18, 1000, 64, 8),
           new WanderingTraderNirtreTrades.EnchantedBlockForGurltsTrade(isBurnableBlockItemInit.SHZ_BLOCK.get(), 10, 1000, 20, 4),
           new WanderingTraderNirtreTrades.ItemsFor20ShzBlocksAndItemsTrade(isBurnableBlockItemInit.TBRUHV.get(), 23, com.babcsany.minecraft.ervin_mod_1.init.item.block.isBurnableBlockItemInit.GNRTHIRJ.get(), 1, 1000, 30),
           new WanderingTraderNirtreTrades.ItemsForShzsAndBlocksTrade(com.babcsany.minecraft.ervin_mod_1.init.item.block.isBurnableBlockItemInit.GNRTHIRJ.get(), 7, isBurnableBlockItemInit.NETHER_PORTAL.get(), 1, 1000, 4),
           new WanderingTraderNirtreTrades.ItemsFor64NirtksAndBlocksTrade(isBurnableBlockItemInit.NIRTKB.get(), 64, isBurnableBlockItemInit.EPKIN.get(), 1, 1000, 1),
           new WanderingTraderNirtreTrades.ItemsFor40EpkinsAndItemsTrade(isBurnableBlockItemInit.NETHER_PORTAL.get(), 10, isBurnableSpecialItemInit.TROIF.get(), 1, 100, 1),
           new WanderingTraderNirtreTrades.ItemsForNirtksAndBlocksTrade(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.AIR.get(), 1, isBurnableBlockItemInit.NIRTKB.get(), 1, 1000, 1),
           new WanderingTraderNirtreTrades.EnchantedBookForFirnsTrade(10),
           new WanderingTraderNirtreTrades.ItemsForFirtBlocksTrade(ModSpawnEggItemInit.DRURB_SPAWN_EGG.get(), 20, 1, 20, 3),
           new WanderingTraderNirtreTrades.ItemsForAvtersTrade(SpecialItemInit.GTRZIUZHIZJKJ.get(), 34, 1, 300000, 15),
           new WanderingTraderNirtreTrades.ItemsForVilktsTrade(com.babcsany.minecraft.ervin_mod_1.init.minecraft.block.item.BlockNamedItemInit.END_PORTAL.get(), 15, 3, 20, 15),
           new WanderingTraderNirtreTrades.ItemsForVilktsTrade(isBurnableBlockItemInit.CRAINT_BLOCK_CRAFTING_TABLE.get(), 10, 3, 20, 1500),
   }));

   public static final Int2ObjectMap<WanderingTraderNirtreTrades.ITrade[]> trade2 = gatAsIntMap(ImmutableMap.of(1, new WanderingTraderNirtreTrades.ITrade[]{
           new WanderingTraderNirtreTrades.ItemsForItemsAndItemsTrade(isBurnableSpecialToolItemInit.TERAT.get(), isBurnableSpecialToolItemInit.TERAT.get(), 1, 1, isBurnableSpecialToolItemInit.TERAT_STICK.get(), 1, 1000000000, 1500),
           new WanderingTraderNirtreTrades.ItemsForItemsTrade1(isBurnableSpecialToolItemInit.TERAT_STICK.get(), isBurnableSpecialToolItemInit.TERAT.get(), 2, 1, 1500),
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

         return new MerchantOffer(new ItemStack(isBurnableSpecialItemInit.FIRN.get(), j), new ItemStack(Items.BOOK), itemstack, 120, this.xpValue, 2.4F);
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
         return new MerchantOffer(itemstack, new ItemStack(ItemInit.BREND.get()), this.maxUses, this.xpValue, this.priceMultiplier);
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

      public EnchantedBlockForDurgsTrade(Block block, int durgCount, int maxUses, int xpValue) {
         this(block, durgCount, maxUses, xpValue, 0.05F);
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
         ItemStack itemstack1 = new ItemStack(isBurnableFoodItemInit.DURG.get(), j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class EnchantedBlockForGurltsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingStack;
      private final int gurltCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EnchantedBlockForGurltsTrade(Block block, int gurltCount, int maxUses, int xpValue) {
         this(block, gurltCount, maxUses, xpValue, 0.05F);
      }

      public EnchantedBlockForGurltsTrade(Block sellItem, int gurltCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingStack = new ItemStack(sellItem);
         this.gurltCount = gurltCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.gurltCount + i, 64);
         ItemStack itemstack1 = new ItemStack(ItemInit.GURLT.get(), j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class EnchantedBlockForShzBlocksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingStack;
      private final int shzBlockCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public EnchantedBlockForShzBlocksTrade(Block block, int shzBlockCount, int maxUses, int xpValue) {
         this(block, shzBlockCount, maxUses, xpValue, 0.05F);
      }

      public EnchantedBlockForShzBlocksTrade(Block sellItem, int shzBlockCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingStack = new ItemStack(sellItem);
         this.shzBlockCount = shzBlockCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.shzBlockCount + i, 64);
         ItemStack itemstack1 = new ItemStack(isBurnableBlockItemInit.SHZ_BLOCK.get(), j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForEnchantedBlockForDurksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final ItemStack sellingStack;
      private final int buyingItemCount;
      private final int durkCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForEnchantedBlockForDurksTrade(IItemProvider buyingItem, int buyingItemCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForEnchantedBlockForDurksTrade(IItemProvider buyingItem, int buyingItemCount, int durkCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.sellingStack = new ItemStack(sellingItem);
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.durkCount = durkCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         int i = 5 + rand.nextInt(15);
         ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(rand, new ItemStack(this.sellingStack.getItem()), i, false);
         int j = Math.min(this.durkCount + i, 64);
         ItemStack itemstack1 = new ItemStack(isBurnableItemInit.DURK.get(), j);
         return new MerchantOffer(itemstack1, itemstack, this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForShzsAndBlocksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int shzCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForShzsAndBlocksTrade(IItemProvider buyingItem, int buyingItemCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForShzsAndBlocksTrade(IItemProvider buyingItem, int buyingItemCount, int shzCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.shzCount = shzCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableItemInit.SHZ.get(), this.shzCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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

      public ItemsForSrurgsAndBlocksTrade(IItemProvider buyingItem, int buyingItemCount, Supplier<? extends Block> sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem.get(), sellingItemCount, maxUses, xpValue);
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

   static class ItemsFor40EpkinsAndItemsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int epkinCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor40EpkinsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 40, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor40EpkinsAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int epkinCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.epkinCount = epkinCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.EPKIN.get(), this.epkinCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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

   static class ItemsFor20ShzBlocksAndItemsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int shzBlockCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor20ShzBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 20, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor20ShzBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int shzBlockCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.shzBlockCount = shzBlockCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.SHZ_BLOCK.get(), this.shzBlockCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsFor64NirtksAndBlocksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int nirtkCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor64NirtksAndBlocksTrade(IItemProvider buyingItem, int buyingItemCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 64, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor64NirtksAndBlocksTrade(IItemProvider buyingItem, int buyingItemCount, int nirtkCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
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

   static class ItemsForVilktsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int vilktCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForVilktsTrade(Block sellingItem, int vilktCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), vilktCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForVilktsTrade(Item sellingItem, int vilktCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), vilktCount, sellingItemCount, 120, xpValue);
      }

      public ItemsForVilktsTrade(Item sellingItem, int vilktCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), vilktCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForVilktsTrade(ItemStack sellingItem, int vilktCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, vilktCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForVilktsTrade(ItemStack sellingItem, int vilktCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.vilktCount = vilktCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableItemInit.VILKT.get(), this.vilktCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForItemsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final IItemProvider item;
      private final int itemCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForItemsTrade(Item item, int itemCount, Block sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(item, itemCount, new ItemStack(sellingItem), sellingItemCount, maxUses, xpValue);
      }

      public ItemsForItemsTrade(Item item, int itemCount, Item sellingItem, int sellingItemCount, int xpValue) {
         this(item, itemCount, new ItemStack(sellingItem), sellingItemCount, 12, xpValue);
      }

      public ItemsForItemsTrade(Item item, int itemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(item, itemCount, new ItemStack(sellingItem), sellingItemCount, maxUses, xpValue);
      }

      public ItemsForItemsTrade(Item item, int itemCount, ItemStack sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(item, itemCount, sellingItem, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForItemsTrade(Item item, int itemCount, ItemStack sellingItem, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.item = item;
         this.itemCount = itemCount;
         this.sellingItem = sellingItem;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(this.item, this.itemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForItemsTrade1 implements ITrade {
      private final ItemStack sellingItem;
      private final IItemProvider item;
      private final int itemCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForItemsTrade1(Block sellingItem, Item item, int itemCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), item, itemCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForItemsTrade1(Item sellingItem, Item item, int itemCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), item, itemCount, sellingItemCount, 120, xpValue);
      }

      public ItemsForItemsTrade1(Item sellingItem, Item item, int itemCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), item, itemCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForItemsTrade1(ItemStack sellingItem, Item item, int itemCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, item, itemCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForItemsTrade1(ItemStack sellingItem, Item item, int itemCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.item = item;
         this.itemCount = itemCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(this.item, this.itemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, 0.05F);
      }
   }

   static class ItemsForItemsAndItemsTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack buyingItem;
      private final IItemProvider item;
      private final int buyingItemCount;
      private final int itemCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForItemsAndItemsTrade(IItemProvider buyingItem, Item item, int buyingItemCount, int itemCount, Item sellingItem, int sellingItemCount, int maxUses) {
         this(buyingItem, item, buyingItemCount, itemCount, sellingItem, sellingItemCount, maxUses, 1);
      }

      public ItemsForItemsAndItemsTrade(IItemProvider buyingItem, Item item, int buyingItemCount, int itemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.item = item;
         this.buyingItemCount = buyingItemCount;
         this.itemCount = itemCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(this.item, this.itemCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForItemsAndItemsTrade1 implements ITrade {
      private final ItemStack buyingItem;
      private final IItemProvider item;
      private final int buyingItemCount;
      private final int itemCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForItemsAndItemsTrade1(IItemProvider buyingItem, Item item, int buyingItemCount, int itemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, item, buyingItemCount, itemCount, sellingItem, sellingItemCount, maxUses, xpValue, "trade");
      }

      public ItemsForItemsAndItemsTrade1(IItemProvider buyingItem, Item item, int buyingItemCount, int itemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue, String string) {
         this.buyingItem = new ItemStack(buyingItem);
         this.item = item;
         this.buyingItemCount = buyingItemCount;
         this.itemCount = itemCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(this.item, this.itemCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), this.maxUses, this.xpValue, 0.05F);
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
         return new MerchantOffer(new ItemStack(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.RUBY_BLOCK.get(), this.rubyBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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
         return new MerchantOffer(new ItemStack(com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit.RUBY_BLOCK.get(), this.rubyBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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

   static class ItemsForFirtBlocksTrade implements WanderingTraderNirtreTrades.ITrade {
      private final ItemStack sellingItem;
      private final int firtBlockCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForFirtBlocksTrade(Block sellingItem, int firtBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), firtBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForFirtBlocksTrade(Item sellingItem, int firtBlockCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), firtBlockCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForFirtBlocksTrade(Item sellingItem, int firtBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), firtBlockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForFirtBlocksTrade(ItemStack sellingItem, int firtBlockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, firtBlockCount, maxUses, maxUses, xpValue, 0.05F);
      }

      public ItemsForFirtBlocksTrade(ItemStack sellingItem, int firtBlockCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.firtBlockCount = firtBlockCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(BlockItemInit.FIRT_BLOCK.get(), this.firtBlockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
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