package com.babcsany.minecraft.ervin_mod_1.entity.trigger.hhij;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.AnimalDgrurbEntity;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ResourceLocation;

public class TameHhijAnimalTrigger extends AbstractCriterionTrigger<TameHhijAnimalTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID,"tame_hhij_animal");

   public ResourceLocation getId() {
      return ID;
   }

   public TameHhijAnimalTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "entity", conditionsParser);
      return new TameHhijAnimalTrigger.Instance(entityPredicate, entitypredicate$andpredicate);
   }

   public void trigger(ServerPlayerEntity player, HhijAnimalEntity entity) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, entity);
      this.triggerListeners(player, (p_227251_1_) -> p_227251_1_.test(lootcontext));
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate entity;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate entity) {
         super(TameHhijAnimalTrigger.ID, player);
         this.entity = entity;
      }

      public static TameHhijAnimalTrigger.Instance any() {
         return new TameHhijAnimalTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND);
      }

      public static TameHhijAnimalTrigger.Instance create(EntityPredicate entityCondition) {
         return new TameHhijAnimalTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.createAndFromEntityCondition(entityCondition));
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