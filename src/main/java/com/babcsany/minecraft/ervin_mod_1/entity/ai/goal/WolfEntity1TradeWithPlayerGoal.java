package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractNirtreEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class WolfEntity1TradeWithPlayerGoal extends Goal {
   private final AbstractNirtreEntity wolf1;

   public WolfEntity1TradeWithPlayerGoal(AbstractNirtreEntity wolf1) {
      this.wolf1 = wolf1;
      this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.wolf1.isAlive()) {
         return false;
      } else if (this.wolf1.isInWater()) {
         return false;
      } else if (!this.wolf1.isOnGround()) {
         return false;
      } else if (this.wolf1.velocityChanged) {
         return false;
      } else {
         PlayerEntity playerentity = this.wolf1.getCustomer();
         if (playerentity == null) {
            return false;
         } else if (this.wolf1.getDistanceSq(playerentity) > 16.0D) {
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
      this.wolf1.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.wolf1.setCustomer((PlayerEntity)null);
   }
}