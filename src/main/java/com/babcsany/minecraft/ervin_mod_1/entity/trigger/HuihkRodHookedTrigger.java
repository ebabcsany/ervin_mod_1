package com.babcsany.minecraft.ervin_mod_1.entity.trigger;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.projectile.HuihkEntity;
import com.google.gson.JsonObject;
import java.util.Collection;

import net.minecraft.advancements.criterion.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.ResourceLocation;

public class HuihkRodHookedTrigger extends AbstractCriterionTrigger<HuihkRodHookedTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID,"huihk_rod_hooked");

   public ResourceLocation getId() {
      return ID;
   }

   public HuihkRodHookedTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("rod"));
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "entity", conditionsParser);
      ItemPredicate itempredicate1 = ItemPredicate.deserialize(json.get("item"));
      return new HuihkRodHookedTrigger.Instance(entityPredicate, itempredicate, entitypredicate$andpredicate, itempredicate1);
   }

   public void trigger(ServerPlayerEntity player, ItemStack rod, HuihkEntity entity, Collection<ItemStack> items) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, (Entity)(entity.func_234607_k_() != null ? entity.func_234607_k_() : entity));
      this.triggerListeners(player, (instance) -> {
         return instance.test(rod, lootcontext, items);
      });
   }

   public static class Instance extends CriterionInstance {
      private final ItemPredicate rod;
      private final EntityPredicate.AndPredicate entity;
      private final ItemPredicate item;

      public Instance(EntityPredicate.AndPredicate player, ItemPredicate rod, EntityPredicate.AndPredicate entity, ItemPredicate item) {
         super(HuihkRodHookedTrigger.ID, player);
         this.rod = rod;
         this.entity = entity;
         this.item = item;
      }

      public static HuihkRodHookedTrigger.Instance create(ItemPredicate rod, EntityPredicate bobber, ItemPredicate item) {
         return new HuihkRodHookedTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, rod, EntityPredicate.AndPredicate.createAndFromEntityCondition(bobber), item);
      }

      public boolean test(ItemStack rod, LootContext context, Collection<ItemStack> items) {
         if (!this.rod.test(rod)) {
            return false;
         } else if (!this.entity.testContext(context)) {
            return false;
         } else {
            if (this.item != ItemPredicate.ANY) {
               boolean flag = false;
               Entity entity = context.get(LootParameters.THIS_ENTITY);
               if (entity instanceof ItemEntity) {
                  ItemEntity itementity = (ItemEntity)entity;
                  if (this.item.test(itementity.getItem())) {
                     flag = true;
                  }
               }

               for(ItemStack itemstack : items) {
                  if (this.item.test(itemstack)) {
                     flag = true;
                     break;
                  }
               }

               if (!flag) {
                  return false;
               }
            }

            return true;
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("rod", this.rod.serialize());
         jsonobject.add("entity", this.entity.serializeConditions(conditions));
         jsonobject.add("item", this.item.serialize());
         return jsonobject;
      }
   }
}