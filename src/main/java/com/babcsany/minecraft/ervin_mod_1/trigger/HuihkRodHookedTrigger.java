package com.babcsany.minecraft.ervin_mod_1.trigger;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.HuihkEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.Objects;

public class HuihkRodHookedTrigger extends AbstractCriterionTrigger<HuihkRodHookedTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID, "huihk_rod_hooked");

   public HuihkRodHookedTrigger() {
   }

   public ResourceLocation getId() {
      return ID;
   }

   public HuihkRodHookedTrigger.Instance deserializeTrigger(JsonObject p_230241_1_, EntityPredicate.AndPredicate p_230241_2_, ConditionArrayParser p_230241_3_) {
      ItemPredicate lvt_4_1_ = ItemPredicate.deserialize(p_230241_1_.get("rod"));
      EntityPredicate.AndPredicate lvt_5_1_ = EntityPredicate.AndPredicate.deserializeJSONObject(p_230241_1_, "entity", p_230241_3_);
      ItemPredicate lvt_6_1_ = ItemPredicate.deserialize(p_230241_1_.get("item"));
      return new HuihkRodHookedTrigger.Instance(p_230241_2_, lvt_4_1_, lvt_5_1_, lvt_6_1_);
   }

   public void trigger(ServerPlayerEntity p_204820_1_, ItemStack p_204820_2_, HuihkEntity p_204820_3_, Collection<ItemStack> p_204820_4_) {
      LootContext lvt_5_1_ = EntityPredicate.getLootContext(p_204820_1_, p_204820_3_.func_234607_k_() != null ? Objects.requireNonNull(p_204820_3_.func_234607_k_()) : p_204820_3_);
      this.triggerListeners(p_204820_1_, (p_234658_3_) -> p_234658_3_.test(p_204820_2_, lvt_5_1_, p_204820_4_));
   }

   public static class Instance extends CriterionInstance {
      private final ItemPredicate rod;
      private final EntityPredicate.AndPredicate entity;
      private final ItemPredicate item;

      public Instance(EntityPredicate.AndPredicate p_i231592_1_, ItemPredicate p_i231592_2_, EntityPredicate.AndPredicate p_i231592_3_, ItemPredicate p_i231592_4_) {
         super(ID, p_i231592_1_);
         this.rod = p_i231592_2_;
         this.entity = p_i231592_3_;
         this.item = p_i231592_4_;
      }

      public static HuihkRodHookedTrigger.Instance create(ItemPredicate p_204829_0_, EntityPredicate p_204829_1_, ItemPredicate p_204829_2_) {
         return new HuihkRodHookedTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, p_204829_0_, EntityPredicate.AndPredicate.createAndFromEntityCondition(p_204829_1_), p_204829_2_);
      }

      public boolean test(ItemStack p_234659_1_, LootContext p_234659_2_, Collection<ItemStack> p_234659_3_) {
         if (!this.rod.test(p_234659_1_)) {
            return false;
         } else if (!this.entity.testContext(p_234659_2_)) {
            return false;
         } else {
            if (this.item != ItemPredicate.ANY) {
               boolean lvt_4_1_ = false;
               Entity lvt_5_1_ = p_234659_2_.get(LootParameters.THIS_ENTITY);
               if (lvt_5_1_ instanceof ItemEntity) {
                  ItemEntity lvt_6_1_ = (ItemEntity)lvt_5_1_;
                  if (this.item.test(lvt_6_1_.getItem())) {
                     lvt_4_1_ = true;
                  }
               }

               for (ItemStack lvt_7_1_ : p_234659_3_) {
                  if (this.item.test(lvt_7_1_)) {
                     lvt_4_1_ = true;
                     break;
                  }
               }

               return lvt_4_1_;
            }

            return true;
         }
      }

      public JsonObject serialize(ConditionArraySerializer p_230240_1_) {
         JsonObject lvt_2_1_ = super.serialize(p_230240_1_);
         lvt_2_1_.add("rod", this.rod.serialize());
         lvt_2_1_.add("entity", this.entity.serializeConditions(p_230240_1_));
         lvt_2_1_.add("item", this.item.serialize());
         return lvt_2_1_;
      }
   }
}