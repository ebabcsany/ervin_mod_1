package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractNirtreEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class $TraderTradeWithPlayerGoal extends Goal {
   private final AbstractNirtreEntity $_trader;

   public $TraderTradeWithPlayerGoal(AbstractNirtreEntity $_trader) {
      this.$_trader = $_trader;
      this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.$_trader.isAlive()) {
         return false;
      } else if (this.$_trader.isInWater()) {
         return false;
      } else if (!this.$_trader.isOnGround()) {
         return false;
      } else if (this.$_trader.velocityChanged) {
         return false;
      } else {
         PlayerEntity playerentity = this.$_trader.getCustomer();
         if (playerentity == null) {
            return false;
         } else if (this.$_trader.getDistanceSq(playerentity) > 16.0D) {
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
      this.$_trader.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.$_trader.setCustomer((PlayerEntity)null);
   }
}