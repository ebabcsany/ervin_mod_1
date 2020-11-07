package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.Abstract$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractZombieTraderEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class ZombieTraderTradeWithPlayerGoal extends Goal {
   private final AbstractZombieTraderEntity zombieTrader;

   public ZombieTraderTradeWithPlayerGoal(AbstractZombieTraderEntity zombieTrader) {
      this.zombieTrader = zombieTrader;
      this.setMutexFlags(EnumSet.of(Flag.JUMP, Flag.MOVE));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (!this.zombieTrader.isAlive()) {
         return false;
      } else if (this.zombieTrader.isInWater()) {
         return false;
      } else if (!this.zombieTrader.isOnGround()) {
         return false;
      } else if (this.zombieTrader.velocityChanged) {
         return false;
      } else {
         PlayerEntity playerentity = this.zombieTrader.getCustomer();
         if (playerentity == null) {
            return false;
         } else if (this.zombieTrader.getDistanceSq(playerentity) > 16.0D) {
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
      this.zombieTrader.getNavigator().clearPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.zombieTrader.setCustomer((PlayerEntity)null);
   }
}