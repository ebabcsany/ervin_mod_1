package com.babcsany.minecraft.ervin_mod_1.entity.monster;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class ZurAttackGoal extends MeleeAttackGoal {
   private final ZurEntity zurEntity;
   private int raiseArmTicks;

   public ZurAttackGoal(ZurEntity zurEntity, double speedIn, boolean longMemoryIn) {
      super(zurEntity, speedIn, longMemoryIn);
      this.zurEntity = zurEntity;
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
      this.zurEntity.setAggroed(false);
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      super.tick();
      ++this.raiseArmTicks;
      if (this.raiseArmTicks >= 5 && this.attackTick < 10) {
         this.zurEntity.setAggroed(true);
      } else {
         this.zurEntity.setAggroed(false);
      }

   }
}