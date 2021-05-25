package com.babcsany.minecraft.ervin_mod_1.entity.villager.trigger;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractTraderNirtre1Entity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractTraderNirtreEntity;
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

public class TraderNirtre1TradeTrigger extends AbstractCriterionTrigger<TraderNirtre1TradeTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID,"trader_nirtre1_trade");

   public ResourceLocation getId() {
      return ID;
   }

   public TraderNirtre1TradeTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "nirtre", conditionsParser);
      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
      return new TraderNirtre1TradeTrigger.Instance(entityPredicate, entitypredicate$andpredicate, itempredicate);
   }

   public void test(ServerPlayerEntity player, AbstractTraderNirtre1Entity nirtre, ItemStack stack) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, nirtre);
      this.triggerListeners(player, (p_227267_2_) -> p_227267_2_.test(lootcontext, stack));
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate nirtre;
      private final ItemPredicate item;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate villager, ItemPredicate stack) {
         super(TraderNirtre1TradeTrigger.ID, player);
         this.nirtre = villager;
         this.item = stack;
      }

      public static TraderNirtre1TradeTrigger.Instance any() {
         return new TraderNirtre1TradeTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, ItemPredicate.ANY);
      }

      public boolean test(LootContext context, ItemStack stack) {
         if (!this.nirtre.testContext(context)) {
            return false;
         } else {
            return this.item.test(stack);
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("item", this.item.serialize());
         jsonobject.add("nirtre", this.nirtre.serializeConditions(conditions));
         return jsonobject;
      }
   }
}