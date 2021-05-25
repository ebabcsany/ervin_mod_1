package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtre1Entity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtreEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class TraderNirtre1TradeWithPlayerGoal extends Goal {
   private final TraderNirtre1Entity traderNirtre1;

   public TraderNirtre1TradeWithPlayerGoal(TraderNirtre1Entity traderNirtre1In) {
      this.traderNirtre1 = traderNirtre1In;
      this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.traderNirtre1.isAlive()) {
         return false;
      } else if (this.traderNirtre1.isInWater()) {
         return false;
      } else if (!this.traderNirtre1.isOnGround()) {
         return false;
      } else if (this.traderNirtre1.velocityChanged) {
         return false;
      } else {
         PlayerEntity playerentity = this.traderNirtre1.getCustomer();
         if (playerentity == null) {
            return false;
         } else if (this.traderNirtre1.getDistanceSq(playerentity) > 16.0D) {
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
      this.traderNirtre1.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.traderNirtre1.setCustomer(null);
   }
}