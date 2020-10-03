package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractNirtreEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class TradeWithPlayerGoal1 extends Goal {
   private final AbstractNirtreEntity nirtre;

   public TradeWithPlayerGoal1(AbstractNirtreEntity nirtre1) {
      this.nirtre = nirtre1;
      this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.nirtre.isAlive()) {
         return false;
      } else if (this.nirtre.isInWater()) {
         return false;
      } else if (!this.nirtre.isOnGround()) {
         return false;
      } else if (this.nirtre.velocityChanged) {
         return false;
      } else {
         PlayerEntity playerentity = this.nirtre.getCustomer();
         if (playerentity == null) {
            return false;
         } else if (this.nirtre.getDistanceSq(playerentity) > 16.0D) {
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
      this.nirtre.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.nirtre.setCustomer((PlayerEntity)null);
   }
}