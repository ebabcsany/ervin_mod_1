package com.babcsany.minecraft.ervin_mod_1.entity;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.ZurEntity;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.loot.LootContext;
import net.minecraft.util.ResourceLocation;

public class CuredZurNirtreTrigger extends AbstractCriterionTrigger<CuredZurNirtreTrigger.Instance> {
   public static final ResourceLocation ID = new ResourceLocation("cured_zombie_nirtre");

   public ResourceLocation getId() {
      return ID;
   }

   public CuredZurNirtreTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "zombie", conditionsParser);
      EntityPredicate.AndPredicate entitypredicate$andpredicate1 = EntityPredicate.AndPredicate.deserializeJSONObject(json, "nirtre", conditionsParser);
      return new CuredZurNirtreTrigger.Instance(entityPredicate, entitypredicate$andpredicate, entitypredicate$andpredicate1);
   }

   public void trigger1(ServerPlayerEntity player, ZurEntity zur1, VillagerEntity nirtre1) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, zur1);
      LootContext lootcontext1 = EntityPredicate.getLootContext(player, nirtre1);
      this.triggerListeners(player, (p_233969_2_) -> {
         return p_233969_2_.test(lootcontext, lootcontext1);
      });
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate zur;
      private final EntityPredicate.AndPredicate nirtre;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate zur1, EntityPredicate.AndPredicate nirtre1) {
         super(CuredZurNirtreTrigger.ID, player);
         this.zur = zur1;
         this.nirtre = nirtre1;
      }

      public static CuredZurNirtreTrigger.Instance any() {
         return new CuredZurNirtreTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND);
      }

      public boolean test(LootContext zur1, LootContext nirtre1) {
         if (!this.zur.testContext(zur1)) {
            return false;
         } else {
            return this.nirtre.testContext(nirtre1);
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("zur", this.zur.serializeConditions(conditions));
         jsonobject.add("nirtre", this.nirtre.serializeConditions(conditions));
         return jsonobject;
      }
   }
}