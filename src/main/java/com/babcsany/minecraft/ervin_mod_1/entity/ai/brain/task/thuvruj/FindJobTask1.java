package com.babcsany.minecraft.ervin_mod_1.entity.ai.brain.task.thuvruj;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.ThuvrujEntity;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.ai.brain.BrainUtil;
import net.minecraft.entity.ai.brain.memory.MemoryModuleStatus;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.Task;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.network.DebugPacketSender;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.server.ServerWorld;

import java.util.Optional;

/*public class FindJobTask1 extends Task<ThuvrujEntity> {
   private final float field_234017_b_;

   public FindJobTask1(float p_i231545_1_) {
      super(ImmutableMap.of(MemoryModuleType.POTENTIAL_JOB_SITE, MemoryModuleStatus.VALUE_PRESENT, MemoryModuleType.JOB_SITE, MemoryModuleStatus.VALUE_ABSENT, MemoryModuleType.MOBS, MemoryModuleStatus.VALUE_PRESENT));
      this.field_234017_b_ = p_i231545_1_;
   }

   protected void startExecuting(ServerWorld worldIn, ThuvrujEntity entityIn, long gameTimeIn) {
      BlockPos blockpos = entityIn.getBrain().getMemory(MemoryModuleType.POTENTIAL_JOB_SITE).get().getPos();
   }

   private void func_234022_a_(ServerWorld p_234022_1_, ThuvrujEntity p_234022_2_, VillagerEntity p_234022_3_, BlockPos p_234022_4_, boolean p_234022_5_) {
      this.func_234019_a_(p_234022_2_);
      if (!p_234022_5_) {
         BrainUtil.func_233866_a_(p_234022_3_, p_234022_4_, this.field_234017_b_, 1);
         p_234022_3_.getBrain().setMemory(MemoryModuleType.POTENTIAL_JOB_SITE, GlobalPos.func_239648_a_(p_234022_1_.func_234923_W_(), p_234022_4_));
         DebugPacketSender.func_218801_c(p_234022_1_, p_234022_4_);
      }

   }

   private boolean func_234020_a_(ThuvrujEntity p_234020_1_, BlockPos p_234020_2_, PointOfInterestType p_234020_3_) {
      Path path = p_234020_1_.getNavigator().getPathToPos(p_234020_2_, p_234020_3_.getValidRange());
      return path != null && path.reachesTarget();
   }

   private void func_234019_a_(ThuvrujEntity p_234019_1_) {
      p_234019_1_.getBrain().removeMemory(MemoryModuleType.WALK_TARGET);
      p_234019_1_.getBrain().removeMemory(MemoryModuleType.LOOK_TARGET);
      p_234019_1_.getBrain().removeMemory(MemoryModuleType.POTENTIAL_JOB_SITE);
   }
}

 */
