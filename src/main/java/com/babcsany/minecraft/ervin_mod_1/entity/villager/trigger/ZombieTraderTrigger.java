package com.babcsany.minecraft.ervin_mod_1.entity.villager.trigger;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractZombieTraderEntity;
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

public class ZombieTraderTrigger extends AbstractCriterionTrigger<ZombieTraderTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID,"zombie_trader_trade");

   public ResourceLocation getId() {
      return ID;
   }

   public ZombieTraderTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "zombie_trader", conditionsParser);
      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
      return new ZombieTraderTrigger.Instance(entityPredicate, entitypredicate$andpredicate, itempredicate);
   }

   public void test(ServerPlayerEntity player, AbstractZombieTraderEntity zombie_trader, ItemStack stack) {
      LootContext lootcontext = EntityPredicate.getLootContext(player, zombie_trader);
      this.triggerListeners(player, (p_227267_2_) -> p_227267_2_.test(lootcontext, stack));
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate zombie_trader;
      private final ItemPredicate item;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate zombie_trader, ItemPredicate stack) {
         super(ZombieTraderTrigger.ID, player);
         this.zombie_trader = zombie_trader;
         this.item = stack;
      }

      public static ZombieTraderTrigger.Instance any() {
         return new ZombieTraderTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, ItemPredicate.ANY);
      }

      public boolean test(LootContext context, ItemStack stack) {
         if (!this.zombie_trader.testContext(context)) {
            return false;
         } else {
            return this.item.test(stack);
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("item", this.item.serialize());
         jsonobject.add("zombie_trader", this.zombie_trader.serializeConditions(conditions));
         return jsonobject;
      }
   }
}