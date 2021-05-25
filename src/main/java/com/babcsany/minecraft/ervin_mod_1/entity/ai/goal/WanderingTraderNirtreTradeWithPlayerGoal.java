package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class WanderingTraderNirtreTradeWithPlayerGoal extends Goal {
   private final WanderingTraderNirtreEntity wanderingTraderNirtre;

   public WanderingTraderNirtreTradeWithPlayerGoal(WanderingTraderNirtreEntity wanderingTraderNirtreIn) {
      this.wanderingTraderNirtre = wanderingTraderNirtreIn;
      this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.wanderingTraderNirtre.isAlive()) {
         return false;
      } else if (this.wanderingTraderNirtre.isInWater()) {
         return false;
      } else if (!this.wanderingTraderNirtre.isOnGround()) {
         return false;
      } else if (this.wanderingTraderNirtre.velocityChanged) {
         return false;
      } else {
         PlayerEntity playerentity = this.wanderingTraderNirtre.getCustomer();
         if (playerentity == null) {
            return false;
         } else if (this.wanderingTraderNirtre.getDistanceSq(playerentity) > 16.0D) {
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
      this.wanderingTraderNirtre.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.wanderingTraderNirtre.setCustomer(null);
   }
}