package com.babcsany.minecraft.ervin_mod_1.entity.villager.trades;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.ItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.food.isBurnableFoodItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.spawn_egg.ModSpawnEggItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.special.SpecialItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.SpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.item.tool.isBurnableSpecialToolItemInit;
import com.babcsany.minecraft.ervin_mod_1.tags.ItemTag;
import com.babcsany.minecraft.init.BlockItemInit;
import com.babcsany.minecraft.init.EntityInit;
import com.babcsany.minecraft.item.IEntityProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.villager.IVillagerDataHolder;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnMobPacket;
import net.minecraft.potion.*;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.HandSide;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public class ZurTrades {
   public static final Int2ObjectMap<ZurTrades.ITrade[]> field_221240_b = gatAsIntMap(ImmutableMap.of(1, new ZurTrades.ITrade[]{
           new ZurTrades.ItemsForEmeraldsTrade(ModSpawnEggItemInit.DGRURB_SPAWN_EGG.get(), 5, 1, 50, 2),
           new ZurTrades.ItemsForBedrocksTrade(SpecialItemInit.GRITHK.get(), 5, 1, 50, 10),
           new ZurTrades.ItemsForTirskBlocksAndItemsTrade(SpecialItemInit.GRITHK.get(), 1, isBurnableSpecialToolItemInit.TERAT.get(), 4, 30, 30),
   }));

   private static Int2ObjectMap<ZurTrades.ITrade[]> gatAsIntMap(ImmutableMap<Integer, ZurTrades.ITrade[]> p_221238_0_) {
      return new Int2ObjectOpenHashMap<>(p_221238_0_);
   }

   static class DyedArmorForEmeraldsTrade implements ZurTrades.ITrade {
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

   static class DyedArmorForRubiesTrade implements ZurTrades.ITrade {
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

   static class EmeraldForItemsTrade implements ZurTrades.ITrade {
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

   static class RubyForItemsTrade implements ZurTrades.ITrade {
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

   static class EmeraldForMapTrade implements ZurTrades.ITrade {
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

   static class RubyForMapTrade implements ZurTrades.ITrade {
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

   static class EmeraldForVillageTypeItemTrade implements ZurTrades.ITrade {
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

   static class EnchantedBookForEmeraldsTrade implements ZurTrades.ITrade {
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

   static class EnchantedBookForRubiesTrade implements ZurTrades.ITrade {
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

   static class EnchantedItemForEmeraldsTrade implements ZurTrades.ITrade {
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

   static class EnchantedItemForRubiesTrade implements ZurTrades.ITrade {
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

   static class ItemWithPotionForEmeraldsAndItemsTrade implements ZurTrades.ITrade {
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

   static class ItemsFor64FirtBlocksAndItemsTrade implements ZurTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int firtCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsFor64FirtBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 64, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsFor64FirtBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int firtCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.firtCount = firtCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(BlockItemInit.FIRT_BLOCK, this.firtCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForTirskBlocksAndItemsTrade implements ZurTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int tirskBlockCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForTirskBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForTirskBlocksAndItemsTrade(IItemProvider buyingItem, int buyingItemCount, int tirskBlockCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.tirskBlockCount = tirskBlockCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.TIRSK_BLOCK.get(), this.tirskBlockCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   /*static class ItemsForTirskBlocksAndEntitiesTrade implements ZurTrades.ITrade {
      private final ItemStack buyingItem;
      private final int buyingItemCount;
      private final int zurEntityCount;
      private final ItemStack sellingItem;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForTirskBlocksAndEntitiesTrade(IEntityProvider buyingItem, int buyingItemCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this(buyingItem, buyingItemCount, 1, sellingItem, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForTirskBlocksAndEntitiesTrade(IEntityProvider buyingItem, int buyingItemCount, int tirskBlockCount, Item sellingItem, int sellingItemCount, int maxUses, int xpValue) {
         this.buyingItem = new ItemStack(buyingItem);
         this.buyingItemCount = buyingItemCount;
         this.zurEntityCount = tirskBlockCount;
         this.sellingItem = new ItemStack(sellingItem);
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = 0.05F;
      }

      @Nullable
      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableBlockItemInit.TIRSK_BLOCK.get(), this.zurEntityCount), new ItemStack(this.buyingItem.getItem(), this.buyingItemCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }*/

   static class ItemsForEmeraldsTrade implements ZurTrades.ITrade {
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

   static class ItemsForDurgsTrade implements ZurTrades.ITrade {
      private final ItemStack sellingItem;
      private final int durgCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForDurgsTrade(Block sellingItem, int emeraldCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), emeraldCount, sellingItemCount, maxUses, xpValue);
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

   static class ItemsForBedrocksTrade implements ZurTrades.ITrade {
      private final ItemStack sellingItem;
      private final int bedrockCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForBedrocksTrade(Block sellingItem, int bedrockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), bedrockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForBedrocksTrade(Item sellingItem, int bedrockCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), bedrockCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForBedrocksTrade(Item sellingItem, int bedrockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), bedrockCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForBedrocksTrade(ItemStack sellingItem, int bedrockCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, bedrockCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForBedrocksTrade(ItemStack sellingItem, int bedrockCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.bedrockCount = bedrockCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(Blocks.BEDROCK, this.bedrockCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForRugtsTrade implements ZurTrades.ITrade {
      private final ItemStack sellingItem;
      private final int rugtCount;
      private final int sellingItemCount;
      private final int maxUses;
      private final int xpValue;
      private final float priceMultiplier;

      public ItemsForRugtsTrade(Block sellingItem, int rugtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rugtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRugtsTrade(Item sellingItem, int rugtCount, int sellingItemCount, int xpValue) {
         this(new ItemStack(sellingItem), rugtCount, sellingItemCount, 12, xpValue);
      }

      public ItemsForRugtsTrade(Item sellingItem, int rugtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(new ItemStack(sellingItem), rugtCount, sellingItemCount, maxUses, xpValue);
      }

      public ItemsForRugtsTrade(ItemStack sellingItem, int rugtCount, int sellingItemCount, int maxUses, int xpValue) {
         this(sellingItem, rugtCount, sellingItemCount, maxUses, xpValue, 0.05F);
      }

      public ItemsForRugtsTrade(ItemStack sellingItem, int rugtCount, int sellingItemCount, int maxUses, int xpValue, float priceMultiplier) {
         this.sellingItem = sellingItem;
         this.rugtCount = rugtCount;
         this.sellingItemCount = sellingItemCount;
         this.maxUses = maxUses;
         this.xpValue = xpValue;
         this.priceMultiplier = priceMultiplier;
      }

      public MerchantOffer getOffer(Entity trader, Random rand) {
         return new MerchantOffer(new ItemStack(isBurnableItemInit.RUGT.get(), this.rugtCount), new ItemStack(this.sellingItem.getItem(), this.sellingItemCount), this.maxUses, this.xpValue, this.priceMultiplier);
      }
   }

   static class ItemsForKirtsTrade implements ZurTrades.ITrade {
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

   static class SuspiciousStewForEmeraldTrade implements ZurTrades.ITrade {
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