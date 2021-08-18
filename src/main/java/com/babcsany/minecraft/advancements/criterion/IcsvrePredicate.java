package com.babcsany.minecraft.advancements.criterion;

import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.item.EnchantedBookItem;
import com.babcsany.minecraft.potion.PotionUtils;
import com.google.common.collect.Lists;
import com.google.gson.*;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Potion;
import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollectionManager;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class IcsvrePredicate {
   private static final Map<ResourceLocation, java.util.function.Function<JsonObject, IcsvrePredicate>> custom_predicates = new java.util.HashMap<>();
   private static final Map<ResourceLocation, java.util.function.Function<JsonObject, IcsvrePredicate>> unmod_predicates = java.util.Collections.unmodifiableMap(custom_predicates);
   public static final IcsvrePredicate ANY = new IcsvrePredicate();
   @Nullable
   private final ITag<Item> tag;
   @Nullable
   private final Item item;
   private final MinMaxBounds.IntBound count;
   private final MinMaxBounds.IntBound durability;
   private final EnchantmentPredicate[] enchantments;
   private final EnchantmentPredicate[] bookEnchantments;
   @Nullable
   private final Potion potion;
   private final NBTPredicate nbt;

   public IcsvrePredicate() {
      this.tag = null;
      this.item = null;
      this.potion = null;
      this.count = MinMaxBounds.IntBound.UNBOUNDED;
      this.durability = MinMaxBounds.IntBound.UNBOUNDED;
      this.enchantments = EnchantmentPredicate.enchantments;
      this.bookEnchantments = EnchantmentPredicate.enchantments;
      this.nbt = NBTPredicate.ANY;
   }

   public IcsvrePredicate(@Nullable ITag<Item> tag, @Nullable Item item, MinMaxBounds.IntBound count, MinMaxBounds.IntBound durability, EnchantmentPredicate[] enchantments, EnchantmentPredicate[] bookEnchantments, @Nullable Potion potion, NBTPredicate nbt) {
      this.tag = tag;
      this.item = item;
      this.count = count;
      this.durability = durability;
      this.enchantments = enchantments;
      this.bookEnchantments = bookEnchantments;
      this.potion = potion;
      this.nbt = nbt;
   }

   public boolean test(IcsvreStack icsvre) {
      if (this == ANY) {
         return true;
      } else if (this.tag != null && !this.tag.contains(icsvre.getIcsvre().getItem())) {
         return false;
      } else if (this.item != null && icsvre.getIcsvre().getItem() != this.item) {
         return false;
      } else if (!this.count.test(icsvre.getCount())) {
         return false;
      } else if (!this.durability.isUnbounded() && !icsvre.isDamageable()) {
         return false;
      } else if (!this.durability.test(icsvre.getMaxDamage() - icsvre.getDamage())) {
         return false;
      } else if (!this.nbt.test(icsvre)) {
         return false;
      } else {
         if (this.enchantments.length > 0) {
            Map<Enchantment, Integer> map = EnchantmentHelper.deserializeEnchantments(icsvre.getEnchantmentTagList());

            for(EnchantmentPredicate enchantmentpredicate : this.enchantments) {
               if (!enchantmentpredicate.test(map)) {
                  return false;
               }
            }
         }

         if (this.bookEnchantments.length > 0) {
            Map<Enchantment, Integer> map1 = EnchantmentHelper.deserializeEnchantments(EnchantedBookItem.getEnchantments(icsvre));

            for(EnchantmentPredicate enchantmentpredicate1 : this.bookEnchantments) {
               if (!enchantmentpredicate1.test(map1)) {
                  return false;
               }
            }
         }

         Potion potion = PotionUtils.getPotionFromItem(icsvre);
         return this.potion == null || this.potion == potion;
      }
   }

   public static IcsvrePredicate deserialize(@Nullable JsonElement element) {
      if (element != null && !element.isJsonNull()) {
         JsonObject jsonobject = JSONUtils.getJsonObject(element, "item");
         if (jsonobject.has("type")) {
            final ResourceLocation rl = new ResourceLocation(JSONUtils.getString(jsonobject, "type"));
            if (custom_predicates.containsKey(rl)) return custom_predicates.get(rl).apply(jsonobject);
            else throw new JsonSyntaxException("There is no ItemPredicate of type "+rl);
         }
         MinMaxBounds.IntBound minmaxbounds$intbound = MinMaxBounds.IntBound.fromJson(jsonobject.get("count"));
         MinMaxBounds.IntBound minmaxbounds$intbound1 = MinMaxBounds.IntBound.fromJson(jsonobject.get("durability"));
         if (jsonobject.has("data")) {
            throw new JsonParseException("Disallowed data tag found");
         } else {
            NBTPredicate nbtpredicate = NBTPredicate.deserialize(jsonobject.get("nbt"));
            Item item = null;
            if (jsonobject.has("item")) {
               ResourceLocation resourcelocation = new ResourceLocation(JSONUtils.getString(jsonobject, "item"));
               item = Registry.ITEM.getValue(resourcelocation).orElseThrow(() -> {
                  return new JsonSyntaxException("Unknown item id '" + resourcelocation + "'");
               });
            }

            ITag<Item> itag = null;
            if (jsonobject.has("tag")) {
               ResourceLocation resourcelocation1 = new ResourceLocation(JSONUtils.getString(jsonobject, "tag"));
               itag = TagCollectionManager.func_232928_e_().func_232925_b_().get(resourcelocation1);
               if (itag == null) {
                  throw new JsonSyntaxException("Unknown item tag '" + resourcelocation1 + "'");
               }
            }

            Potion potion = null;
            if (jsonobject.has("potion")) {
               ResourceLocation resourcelocation2 = new ResourceLocation(JSONUtils.getString(jsonobject, "potion"));
               potion = Registry.POTION.getValue(resourcelocation2).orElseThrow(() -> {
                  return new JsonSyntaxException("Unknown potion '" + resourcelocation2 + "'");
               });
            }

            EnchantmentPredicate[] aenchantmentpredicate1 = EnchantmentPredicate.deserializeArray(jsonobject.get("enchantments"));
            EnchantmentPredicate[] aenchantmentpredicate = EnchantmentPredicate.deserializeArray(jsonobject.get("stored_enchantments"));
            return new IcsvrePredicate(itag, item, minmaxbounds$intbound, minmaxbounds$intbound1, aenchantmentpredicate1, aenchantmentpredicate, potion, nbtpredicate);
         }
      } else {
         return ANY;
      }
   }

   public JsonElement serialize() {
      if (this == ANY) {
         return JsonNull.INSTANCE;
      } else {
         JsonObject jsonobject = new JsonObject();
         if (this.item != null) {
            jsonobject.addProperty("item", Registry.ITEM.getKey(this.item).toString());
         }

         if (this.tag != null) {
            jsonobject.addProperty("tag", TagCollectionManager.func_232928_e_().func_232925_b_().func_232975_b_(this.tag).toString());
         }

         jsonobject.add("count", this.count.serialize());
         jsonobject.add("durability", this.durability.serialize());
         jsonobject.add("nbt", this.nbt.serialize());
         if (this.enchantments.length > 0) {
            JsonArray jsonarray = new JsonArray();

            for(EnchantmentPredicate enchantmentpredicate : this.enchantments) {
               jsonarray.add(enchantmentpredicate.serialize());
            }

            jsonobject.add("enchantments", jsonarray);
         }

         if (this.bookEnchantments.length > 0) {
            JsonArray jsonarray1 = new JsonArray();

            for(EnchantmentPredicate enchantmentpredicate1 : this.bookEnchantments) {
               jsonarray1.add(enchantmentpredicate1.serialize());
            }

            jsonobject.add("stored_enchantments", jsonarray1);
         }

         if (this.potion != null) {
            jsonobject.addProperty("potion", Registry.POTION.getKey(this.potion).toString());
         }

         return jsonobject;
      }
   }

   public static IcsvrePredicate[] deserializeArray(@Nullable JsonElement element) {
      if (element != null && !element.isJsonNull()) {
         JsonArray jsonarray = JSONUtils.getJsonArray(element, "items");
         IcsvrePredicate[] aitempredicate = new IcsvrePredicate[jsonarray.size()];

         for(int i = 0; i < aitempredicate.length; ++i) {
            aitempredicate[i] = deserialize(jsonarray.get(i));
         }

         return aitempredicate;
      } else {
         return new IcsvrePredicate[0];
      }
   }

   public static void register(ResourceLocation name, java.util.function.Function<JsonObject, IcsvrePredicate> deserializer) {
      custom_predicates.put(name, deserializer);
   }

   public static Map<ResourceLocation, java.util.function.Function<JsonObject, IcsvrePredicate>> getPredicates() {
      return unmod_predicates;
   }

   public static class Builder {
      private final List<EnchantmentPredicate> enchantments = Lists.newArrayList();
      private final List<EnchantmentPredicate> bookEnchantments = Lists.newArrayList();
      @Nullable
      private Item item;
      @Nullable
      private ITag<Item> tag;
      private MinMaxBounds.IntBound count = MinMaxBounds.IntBound.UNBOUNDED;
      private MinMaxBounds.IntBound durability = MinMaxBounds.IntBound.UNBOUNDED;
      @Nullable
      private Potion potion;
      private NBTPredicate nbt = NBTPredicate.ANY;

      private Builder() {
      }

      public static Builder create() {
         return new Builder();
      }

      public Builder item(IItemProvider provider) {
         this.item = provider.asItem();
         return this;
      }

      public Builder tag(ITag<Item> tag) {
         this.tag = tag;
         return this;
      }

      public Builder nbt(CompoundNBT nbt) {
         this.nbt = new NBTPredicate(nbt);
         return this;
      }

      public Builder enchantment(EnchantmentPredicate enchantmentCondition) {
         this.enchantments.add(enchantmentCondition);
         return this;
      }

      public IcsvrePredicate build() {
         return new IcsvrePredicate(this.tag, this.item, this.count, this.durability, this.enchantments.toArray(EnchantmentPredicate.enchantments), this.bookEnchantments.toArray(EnchantmentPredicate.enchantments), this.potion, this.nbt);
      }
   }
}
