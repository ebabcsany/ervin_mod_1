package com.babcsany.minecraft.ervin_mod_1.entity;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class BredAnimalsTrigger1 extends AbstractCriterionTrigger<BredAnimalsTrigger1.Instance> {
   private static final ResourceLocation ID = new ResourceLocation("bred_animals");

   public ResourceLocation getId() {
      return ID;
   }

   /**
    * Deserialize a ICriterionInstance of this trigger from the data in the JSON.
    */
   public BredAnimalsTrigger1.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
      EntityPredicate entitypredicate = EntityPredicate.deserialize(json.get("parent"));
      EntityPredicate entitypredicate1 = EntityPredicate.deserialize(json.get("partner"));
      EntityPredicate entitypredicate2 = EntityPredicate.deserialize(json.get("child"));
      return new BredAnimalsTrigger1.Instance(entitypredicate, entitypredicate1, entitypredicate2);
   }

   public void trigger(ServerPlayerEntity player, AnimalEntity1 parent1, @Nullable AnimalEntity1 parent2, @Nullable AgeableEntity1 child) {
      this.func_227070_a_(player.getAdvancements(), (p_226253_4_) -> {
         return p_226253_4_.test(player, parent1, parent2, child);
      });
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate parent;
      private final EntityPredicate partner;
      private final EntityPredicate child;

      public Instance(EntityPredicate parent, EntityPredicate partner, EntityPredicate child) {
         super(BredAnimalsTrigger1.ID);
         this.parent = parent;
         this.partner = partner;
         this.child = child;
      }

      public static BredAnimalsTrigger1.Instance any() {
         return new BredAnimalsTrigger1.Instance(EntityPredicate.ANY, EntityPredicate.ANY, EntityPredicate.ANY);
      }

      public static BredAnimalsTrigger1.Instance forParent(EntityPredicate.Builder p_203909_0_) {
         return new BredAnimalsTrigger1.Instance(p_203909_0_.build(), EntityPredicate.ANY, EntityPredicate.ANY);
      }

      public boolean test(ServerPlayerEntity player, AnimalEntity1 parent1In, @Nullable AnimalEntity1 parent2In, @Nullable AgeableEntity1 childIn) {
         if (!this.child.test(player, childIn)) {
            return false;
         } else {
            return this.parent.test(player, parent1In) && this.partner.test(player, parent2In) || this.parent.test(player, parent2In) && this.partner.test(player, parent1In);
         }
      }

      public JsonElement serialize() {
         JsonObject jsonobject = new JsonObject();
         jsonobject.add("parent", this.parent.serialize());
         jsonobject.add("partner", this.partner.serialize());
         jsonobject.add("child", this.child.serialize());
         return jsonobject;
      }
   }
}