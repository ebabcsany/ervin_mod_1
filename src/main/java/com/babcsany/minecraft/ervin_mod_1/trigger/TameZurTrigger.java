package com.babcsany.minecraft.ervin_mod_1.trigger;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ResourceLocation;

public class TameZurTrigger extends AbstractCriterionTrigger<TameZurTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID,"tame_zur");

   public ResourceLocation getId() {
      return ID;
   }

   public TameZurTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "entity", conditionsParser);
      return new TameZurTrigger.Instance(entityPredicate, entitypredicate$andpredicate);
   }

   public void trigger(ServerPlayerEntity player, AbstractZurEntity entity) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, entity);
      this.triggerListeners(player, (p_227251_1_) -> {
         return p_227251_1_.test(lootcontext);
      });
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate entity;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate entity) {
         super(TameZurTrigger.ID, player);
         this.entity = entity;
      }

      public static TameZurTrigger.Instance any() {
         return new TameZurTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND);
      }

      public static TameZurTrigger.Instance create(EntityPredicate entityCondition) {
         return new TameZurTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.createAndFromEntityCondition(entityCondition));
      }

      public boolean test(LootContext context) {
         return this.entity.testContext(context);
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("entity", this.entity.serializeConditions(conditions));
         return jsonobject;
      }
   }
}