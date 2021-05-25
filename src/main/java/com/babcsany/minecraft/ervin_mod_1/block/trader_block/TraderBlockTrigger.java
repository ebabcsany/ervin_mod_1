package com.babcsany.minecraft.ervin_mod_1.block.trader_block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.AbstractTraderBlock;
import com.babcsany.minecraft.ervin_mod_1.loot.ModLootParameters;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.AbstractCriterionTrigger;
import net.minecraft.advancements.criterion.CriterionInstance;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.block.Block;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class TraderBlockTrigger extends AbstractCriterionTrigger<TraderBlockTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation(Ervin_mod_1.MOD_ID,"trader_block_trade");
   private BlockPos position;

   public ResourceLocation getId() {
      return ID;
   }

   public TraderBlockTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      EntityPredicate.AndPredicate entitypredicate$andpredicate = EntityPredicate.AndPredicate.deserializeJSONObject(json, "trader_block", conditionsParser);
      ItemPredicate itempredicate = ItemPredicate.deserialize(json.get("item"));
      return new TraderBlockTrigger.Instance(entityPredicate, entitypredicate$andpredicate, itempredicate);
   }

   public void test(ServerPlayerEntity player, AbstractTraderBlock traderBlock, ItemStack stack) {
      LootContext lootcontext = getLootContext(player, traderBlock);
      this.triggerListeners(player, (p_227267_2_) -> p_227267_2_.test(lootcontext, stack));
   }

   public LootContext getLootContext(ServerPlayerEntity player, Block block) {
      return (new LootContext.Builder(player.getServerWorld())).withParameter(ModLootParameters.THIS_BLOCK, block).withParameter(LootParameters.POSITION, getPosition()).withParameter(LootParameters.field_237457_g_, player.getPositionVec()).withRandom(player.getRNG()).build(LootParameterSets.field_237454_j_);
   }

   public BlockPos getPosition() {
      return position;
   }

   public static class Instance extends CriterionInstance {
      private final EntityPredicate.AndPredicate traderBlock;
      private final ItemPredicate item;

      public Instance(EntityPredicate.AndPredicate player, EntityPredicate.AndPredicate traderBlock, ItemPredicate stack) {
         super(TraderBlockTrigger.ID, player);
         this.traderBlock = traderBlock;
         this.item = stack;
      }

      public static TraderBlockTrigger.Instance any() {
         return new TraderBlockTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, EntityPredicate.AndPredicate.ANY_AND, ItemPredicate.ANY);
      }

      public boolean test(LootContext context, ItemStack stack) {
         if (!this.traderBlock.testContext(context)) {
            return false;
         } else {
            return this.item.test(stack);
         }
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("item", this.item.serialize());
         jsonobject.add("trader_block", this.traderBlock.serializeConditions(conditions));
         return jsonobject;
      }
   }
}