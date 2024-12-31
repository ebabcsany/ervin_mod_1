package com.babcsany.minecraft.ervin_mod_1.trigger;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.Huihk;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.*;

public class HuihkRodHookedTrigger extends AbstractCriterionTrigger<HuihkRodHookedTrigger.Instance> {
   private final Map<PlayerAdvancements, Set<Listener<Instance>>> triggerListeners = Maps.newIdentityHashMap();
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID, "huihk_rod_hooked");

   public ResourceLocation getId() {
      return ID;
   }

   public HuihkRodHookedTrigger.Instance deserializeTrigger(JsonObject p_230241_1_, EntityPredicate.AndPredicate p_230241_2_, ConditionArrayParser p_230241_3_) {
      ItemPredicate lvt_4_1_ = ItemPredicate.deserialize(p_230241_1_.get("rod"));
      EntityPredicate.AndPredicate lvt_5_1_ = EntityPredicate.AndPredicate.deserializeJSONObject(p_230241_1_, "entity", p_230241_3_);
      ItemPredicate lvt_6_1_ = ItemPredicate.deserialize(p_230241_1_.get("item"));
      return new HuihkRodHookedTrigger.Instance(p_230241_2_, lvt_4_1_, lvt_5_1_, lvt_6_1_);
   }

   public void trigger(ServerPlayerEntity serverPlayer, ItemStack rod, Huihk huihk, Collection<ItemStack> stacks) {
      Entity caughtEntity = huihk;//.getCaughtEntity() != null ? Objects.requireNonNull(huihk.getCaughtEntity()) : huihk;
      LootContext lootContext = EntityPredicate.getLootContext(serverPlayer, caughtEntity);
      this.triggerListeners(serverPlayer, (instance) -> instance.test(rod, lootContext, stacks));
   }

   public static class Instance extends CriterionInstance {
      private final ItemPredicate rod;
      private final EntityPredicate.AndPredicate entity;
      private final ItemPredicate item;
      private final EntityPredicate.AndPredicate playerCondition;

      public Instance(EntityPredicate.AndPredicate playerCondition, ItemPredicate rod, EntityPredicate.AndPredicate entity, ItemPredicate item) {
         super(ID, playerCondition);
         this.rod = rod;
         this.entity = entity;
         this.item = item;
         this.playerCondition = playerCondition;
      }

      public static HuihkRodHookedTrigger.Instance create(ItemPredicate p_204829_0_, EntityPredicate p_204829_1_, ItemPredicate p_204829_2_) {
         return new HuihkRodHookedTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, p_204829_0_, EntityPredicate.AndPredicate.createAndFromEntityCondition(p_204829_1_), p_204829_2_);
      }

      public boolean test(ItemStack rod, LootContext context, Collection<ItemStack> stacks) {
         if (!this.rod.test(rod)) {
            return false;
         } else if (!this.entity.testContext(context)) {
            return false;
         } else {
            if (this.item != ItemPredicate.ANY) {
               boolean isTesting = false;
               Entity loot = context.get(LootParameters.THIS_ENTITY);
               if (loot instanceof ItemEntity) {
                  ItemEntity itemEntity = (ItemEntity)loot;
                  if (this.item.test(itemEntity.getItem())) {
                     isTesting = true;
                  }
               }

               for (ItemStack stack : stacks) {
                  if (this.item.test(stack)) {
                     isTesting = true;
                     break;
                  }
               }

               return isTesting;
            }

            return true;
         }
      }

      protected EntityPredicate.AndPredicate getPlayerCondition() {
         return this.playerCondition;
      }

      public JsonObject serialize(ConditionArraySerializer serializer) {
         JsonObject jsonObject = super.serialize(serializer);
         jsonObject.add("rod", this.rod.serialize());
         jsonObject.add("entity", this.entity.serializeConditions(serializer));
         jsonObject.add("item", this.item.serialize());
         return jsonObject;
      }
   }
}