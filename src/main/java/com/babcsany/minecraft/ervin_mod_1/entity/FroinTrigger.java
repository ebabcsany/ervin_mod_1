package com.babcsany.minecraft.ervin_mod_1.entity;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.Abstract$TraderEntity;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ResourceLocation;

public class FroinTrigger extends AbstractCriterionTrigger<FroinTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation("froin_trade");

   public ResourceLocation getId() {
      return ID;
   }

   public FroinTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "$_trader", conditionsParser);
      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
      return new FroinTrigger.Instance(entityPredicate, entitypredicate$andpredicate, itempredicate);
   }

   public void test(ServerPlayerEntity player, Abstract$TraderEntity $_trader, ItemStack stack) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, $_trader);
      this.triggerListeners(player, (p_227267_2_) -> {
         return p_227267_2_.test(lootcontext, stack);
      });
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate $_trader;
      private final ItemPredicate item;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate $_trader, ItemPredicate stack) {
         super(FroinTrigger.ID, player);
         this.$_trader = $_trader;
         this.item = stack;
      }

      public static FroinTrigger.Instance any() {
         return new FroinTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, ItemPredicate.ANY);
      }

      public boolean test(LootContext context, ItemStack stack) {
         if (!this.$_trader.testContext(context)) {
            return false;
         } else {
            return this.item.test(stack);
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("item", this.item.serialize());
         jsonobject.add("$_trader", this.$_trader.serializeConditions(conditions));
         return jsonobject;
      }
   }
}