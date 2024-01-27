package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class ZurTradeWithPlayerGoal extends Goal {
   private final AbstractZurEntity zur;

   public ZurTradeWithPlayerGoal(AbstractZurEntity zur) {
      this.zur = zur;
      this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.zur.isAlive()) {
         return false;
      } else if (this.zur.isInWater()) {
         return false;
      } else if (!this.zur.isOnGround()) {
         return false;
      } else if (this.zur.velocityChanged) {
         return false;
      } else {
         PlayerEntity playerentity = this.zur.getCustomer();
         if (playerentity == null) {
            return false;
         } else if (this.zur.getDistanceSq(playerentity) > 16.0D) {
            return false;
         } else {
            return playerentity.openContainer != null;
         }
      }
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.zur.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.zur.setCustomer((PlayerEntity)null);
   }
}