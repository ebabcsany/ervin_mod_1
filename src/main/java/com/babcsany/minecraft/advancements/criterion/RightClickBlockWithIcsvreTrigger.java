package com.babcsany.minecraft.advancements.criterion;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.string.String_2;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.google.gson.JsonObject;
import net.minecraft.advancements.criterion.*;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.ConditionArrayParser;
import net.minecraft.loot.ConditionArraySerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class RightClickBlockWithIcsvreTrigger extends AbstractCriterionTrigger<RightClickBlockWithIcsvreTrigger.Instance> {
   private static final ResourceLocation ID = new ResourceLocation("ervin_mod_1:icsvre_used_on_block");

   public ResourceLocation getId() {
      return ID;
   }

   public RightClickBlockWithIcsvreTrigger.Instance deserializeTrigger(JsonObject json, EntityPredicate.AndPredicate entityPredicate, ConditionArrayParser conditionsParser) {
      LocationPredicate locationpredicate = LocationPredicate.deserialize(json.get("location"));
      IcsvrePredicate itempredicate = IcsvrePredicate.deserialize(json.get("icsvre"));
      return new RightClickBlockWithIcsvreTrigger.Instance(entityPredicate, locationpredicate, itempredicate);
   }

   public void test(ServerPlayerEntity player, BlockPos pos, IcsvreStack stack) {
      BlockState blockstate = player.getServerWorld().getBlockState(pos);
      this.triggerListeners(player, (instance) -> instance.test(blockstate, player.getServerWorld(), pos, stack));
   }

   public static class Instance extends CriterionInstance {
      private final LocationPredicate location;
      private final IcsvrePredicate stack;

      public Instance(EntityPredicate.AndPredicate player, LocationPredicate location, IcsvrePredicate stack) {
         super(RightClickBlockWithIcsvreTrigger.ID, player);
         this.location = location;
         this.stack = stack;
      }

      public static RightClickBlockWithIcsvreTrigger.Instance create(LocationPredicate.Builder locationBuilder, IcsvrePredicate.Builder stackBuilder) {
         return new RightClickBlockWithIcsvreTrigger.Instance(EntityPredicate.AndPredicate.ANY_AND, locationBuilder.build(), stackBuilder.build());
      }

      public boolean test(BlockState state, ServerWorld world, BlockPos pos, IcsvreStack stack) {
         return this.location.test(world, (double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) && this.stack.test(stack);
      }

      public JsonObject serialize(ConditionArraySerializer conditions) {
         JsonObject jsonobject = super.serialize(conditions);
         jsonobject.add("location", this.location.serialize());
         jsonobject.add("icsvre", this.stack.serialize());
         return jsonobject;
      }
   }
}
