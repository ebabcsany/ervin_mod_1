package com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.ai.brain.memory.MemoryModuleStatus;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.item.Items;
import net.minecraft.world.server.ServerWorld;

public class ZurStartAdmiringItemTask<E extends AbstractZurEntity> extends Task<E> {
   public ZurStartAdmiringItemTask() {
      super(ImmutableMap.of(MemoryModuleType.ADMIRING_ITEM, MemoryModuleStatus.VALUE_ABSENT));
   }

   protected boolean shouldExecute(ServerWorld worldIn, E owner) {
      return !owner.getHeldItemOffhand().isEmpty() && owner.getHeldItemOffhand().getItem() != Items.SHIELD;
   }

   /*protected void startExecuting(ServerWorld worldIn, E entityIn, long gameTimeIn) {
      ZurTasks.func_234477_a_(entityIn, true);
   }*/
}