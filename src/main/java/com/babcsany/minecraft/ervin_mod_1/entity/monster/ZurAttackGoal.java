package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.monster.ZombieEntity;

public class ZurAttackGoal extends MeleeAttackGoal {
   private final ZurEntity zur;
   private int raiseArmTicks;

   public ZurAttackGoal(ZurEntity zombieIn, double speedIn, boolean longMemoryIn) {
      super(zombieIn, speedIn, longMemoryIn);
      this.zur = zombieIn;
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      super.startExecuting();
      this.raiseArmTicks = 0;
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      super.resetTask();
      this.zur.setAggroed(false);
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      super.tick();
      ++this.raiseArmTicks;
      if (this.raiseArmTicks >= 5 && this.func_234041_j_() < this.func_234042_k_() / 2) {
         this.zur.setAggroed(true);
      } else {
         this.zur.setAggroed(false);
      }

   }
}