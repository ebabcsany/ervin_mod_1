package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.hhij;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijTameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class HhijSitGoal extends Goal {
   private final HhijTameableEntity tameable;

   public HhijSitGoal(HhijTameableEntity entityIn) {
      this.tameable = entityIn;
      this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      return this.tameable.func_233685_eM_();
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.tameable.isTamed()) {
         return false;
      } else if (this.tameable.isInWaterOrBubbleColumn()) {
         return false;
      } else if (!this.tameable.isOnGround()) {
         return false;
      } else {
         LivingEntity livingentity = this.tameable.getOwner();
         if (livingentity == null) {
            return true;
         } else {
            return this.tameable.getDistanceSq(livingentity) < 144.0D && livingentity.getRevengeTarget() != null ? false : this.tameable.func_233685_eM_();
         }
      }
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.tameable.getNavigator().clearPath();
      this.tameable.func_233686_v_(true);
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.tameable.func_233686_v_(false);
   }
}