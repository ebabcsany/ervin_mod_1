package com.babcsany.minecraft.ervin_mod_1.entity.trigger.hhij;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAgeableEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import com.google.gson.JsonObject;
import javax.annotation.Nullable;

import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ResourceLocation;

public class BredHhijTrigger extends AbstractCriterionTrigger<BredHhijTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID,"bred_hhij");

   public ResourceLocation getId() {
      return ID;
   }

   public BredHhijTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "parent", conditionsParser);
      EntityPredicate.AndPredicate entitypredicate$andpredicate1 = EntityPredicate.AndPredicate.deserializeJSONObject(json, "partner", conditionsParser);
      EntityPredicate.AndPredicate entitypredicate$andpredicate2 = EntityPredicate.AndPredicate.deserializeJSONObject(json, "child", conditionsParser);
      return new BredHhijTrigger.Instance(entityPredicate, entitypredicate$andpredicate, entitypredicate$andpredicate1, entitypredicate$andpredicate2);
   }

   public void trigger(ServerPlayerEntity player, HhijAnimalEntity parent1, HhijAnimalEntity parent2, @Nullable HhijAgeableEntity child) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, parent1);
      LootContext lootcontext1 = EntityPredicate.getLootContext(player, parent2);
      LootContext lootcontext2 = child != null ? EntityPredicate.getLootContext(player, child) : null;
      this.triggerListeners(player, (p_233510_3_) -> p_233510_3_.test(lootcontext, lootcontext1, lootcontext2));
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate parent;
      private final EntityPredicate.AndPredicate partner;
      private final EntityPredicate.AndPredicate child;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate parent, EntityPredicate.AndPredicate partner, EntityPredicate.AndPredicate child) {
         super(BredHhijTrigger.ID, player);
         this.parent = parent;
         this.partner = partner;
         this.child = child;
      }

      public static BredHhijTrigger.Instance any() {
         return new BredHhijTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND);
      }

      public static BredHhijTrigger.Instance forParent(EntityPredicate.Builder builder) {
         return new BredHhijTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.createAndFromEntityCondition(builder.build()));
      }

      public static BredHhijTrigger.Instance forAll(EntityPredicate parent, EntityPredicate partner, EntityPredicate child) {
         return new BredHhijTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.createAndFromEntityCondition(parent), EntityPredicate.AndPredicate.createAndFromEntityCondition(partner), EntityPredicate.AndPredicate.createAndFromEntityCondition(child));
      }

      public boolean test(LootContext parentContext, LootContext partnerContext, @Nullable LootContext childContext) {
         if (this.child == EntityPredicate.AndPredicate.ANY_AND || childContext != null && this.child.testContext(childContext)) {
            return this.parent.testContext(parentContext) && this.partner.testContext(partnerContext) || this.parent.testContext(partnerContext) && this.partner.testContext(parentContext);
         } else {
            return false;
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("parent", this.parent.serializeConditions(conditions));
         jsonobject.add("partner", this.partner.serializeConditions(conditions));
         jsonobject.add("child", this.child.serializeConditions(conditions));
         return jsonobject;
      }
   }
}