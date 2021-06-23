package com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk.Dgrurbk;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;

public class DgrurbkAttackGoal extends MeleeDgrurbkAttackGoal {
   private final Dgrurbk dgrurbk;
   private int raiseArmTicks;

   public DgrurbkAttackGoal(Dgrurbk dgrurbkIn, double speedIn, boolean longMemoryIn) {
      super(dgrurbkIn, speedIn, longMemoryIn);
      this.dgrurbk = dgrurbkIn;
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
      this.dgrurbk.setAggroed(false);
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      super.tick();
      ++this.raiseArmTicks;
      if (this.raiseArmTicks >= 5 && this.func_234041_j_() < this.func_234042_k_() / 2) {
         this.dgrurbk.setAggroed(true);
      } else {
         this.dgrurbk.setAggroed(false);
      }

   }
}