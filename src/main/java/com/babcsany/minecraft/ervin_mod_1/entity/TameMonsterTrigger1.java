package com.babcsany.minecraft.ervin_mod_1.entity;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;

public class TameMonsterTrigger1 extends AbstractCriterionTrigger<TameMonsterTrigger1.Instance> {
   private static final ResourceLocation ID = new ResourceLocation("tame_monster");

   public ResourceLocation getId() {
      return ID;
   }

   /**
    * Deserialize a ICriterionInstance of this trigger from the data in the JSON.
    */
   public TameMonsterTrigger1.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
      EntityPredicate entitypredicate = EntityPredicate.deserialize(json.get("entity"));
      return new TameMonsterTrigger1.Instance(entitypredicate);
   }

   public void trigger(ServerPlayerEntity player, AgeableEntity1 entity) {
      this.func_227070_a_(player.getAdvancements(), (p_227251_2_) -> {
         return p_227251_2_.test(player, entity);
      });
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate entity;

      public Instance(EntityPredicate entity) {
         super(TameMonsterTrigger1.ID);
         this.entity = entity;
      }

      public static TameMonsterTrigger1.Instance any() {
         return new TameMonsterTrigger1.Instance(EntityPredicate.ANY);
      }

      public static TameMonsterTrigger1.Instance create(EntityPredicate p_215124_0_) {
         return new TameMonsterTrigger1.Instance(p_215124_0_);
      }

      public boolean test(ServerPlayerEntity player, AgeableEntity1 entity) {
         return this.entity.test(player, entity);
      }

      public JsonElement serialize() {
         JsonObject jsonobject = new JsonObject();
         jsonobject.add("entity", this.entity.serialize());
         return jsonobject;
      }
   }
}