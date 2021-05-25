package com.babcsany.minecraft.ervin_mod_1.entity.trigger;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.AbstractZurEntity_1;
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

public class ZurTrigger_1 extends AbstractCriterionTrigger<ZurTrigger_1.Instance> {
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID,"zur_trade");

   public ResourceLocation getId() {
      return ID;
   }

   public Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "zur", conditionsParser);
      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
      return new Instance(entityPredicate, entitypredicate$andpredicate, itempredicate);
   }

   public void test(ServerPlayerEntity player, AbstractZurEntity_1 zur, ItemStack stack) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, zur);
      this.triggerListeners(player, (p_227267_2_) -> {
         return p_227267_2_.test(lootcontext, stack);
      });
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate zur;
      private final ItemPredicate item;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate zur, ItemPredicate stack) {
         super(ZurTrigger_1.ID, player);
         this.zur = zur;
         this.item = stack;
      }

      public static Instance any() {
         return new Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, ItemPredicate.ANY);
      }

      public boolean test(LootContext context, ItemStack stack) {
         if (!this.zur.testContext(context)) {
            return false;
         } else {
            return this.item.test(stack);
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("item", this.item.serialize());
         jsonobject.add("zur", this.zur.serializeConditions(conditions));
         return jsonobject;
      }
   }
}