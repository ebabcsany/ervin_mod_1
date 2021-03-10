package com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.thuvruj;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.ThuvrujEntity;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.ai.brain.BrainUtil;
import net.minecraft.entity.ai.brain.memory.MemoryModuleStatus;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.server.ServerWorld;

/*public class SwitchThuvrujJobTask extends Task<ThuvrujEntity> {

   public SwitchThuvrujJobTask() {
      super(ImmutableMap.of(MemoryModuleType.JOB_SITE, MemoryModuleStatus.VALUE_PRESENT, MemoryModuleType.MOBS, MemoryModuleStatus.VALUE_PRESENT));
   }

   protected void startExecuting(ServerWorld worldIn, ThuvrujEntity entityIn, long gameTimeIn) {
      GlobalPos globalpos = entityIn.getBrain().getMemory(MemoryModuleType.JOB_SITE).get();
   }

   private static ThuvrujEntity func_233932_a_(ThuvrujEntity p_233932_0_, ThuvrujEntity p_233932_1_) {
      ThuvrujEntity villagerentity;
      ThuvrujEntity villagerentity1;
      if (p_233932_0_.getXp() > p_233932_1_.getXp()) {
         villagerentity = p_233932_0_;
         villagerentity1 = p_233932_1_;
      } else {
         villagerentity = p_233932_1_;
         villagerentity1 = p_233932_0_;
      }

      villagerentity1.getBrain().removeMemory(MemoryModuleType.JOB_SITE);
      return villagerentity;
   }

   private boolean func_233931_a_(ThuvrujEntity p_233931_1_) {
      return p_233931_1_.getBrain().getMemory(MemoryModuleType.JOB_SITE).isPresent();
   }
}

 */
