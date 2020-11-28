package com.babcsany.minecraft.ervin_mod_1.entity.ai;

import com.babcsany.minecraft.ervin_mod_1.entity.AgeableEntity1;
import net.minecraft.entity.ai.goal.Goal;

import java.util.List;

public class FollowParentGoal1 extends Goal {
   private final AgeableEntity1 childMonster;
   private AgeableEntity1 parentMonster;
   private final double moveSpeed;
   private int delayCounter;

   public FollowParentGoal1(AgeableEntity1 monster, double speed) {
      this.childMonster = monster;
      this.moveSpeed = speed;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.childMonster.getGrowingAge() >= 0) {
         return false;
      } else {
         List<AgeableEntity1> list = this.childMonster.world.getEntitiesWithinAABB(this.childMonster.getClass(), this.childMonster.getBoundingBox().grow(8.0D, 4.0D, 8.0D));
         AgeableEntity1 monsterentity1 = null;
         double d0 = Double.MAX_VALUE;

         for(AgeableEntity1 monsterentity : list) {
            if (monsterentity1.getGrowingAge() >= 0) {
               double d1 = this.childMonster.getDistanceSq(monsterentity1);
               if (!(d1 > d0)) {
                  d0 = d1;
                  monsterentity1 = monsterentity;
               }
            }
         }

         if (monsterentity1 == null) {
            return false;
         } else if (d0 < 9.0D) {
            return false;
         } else {
            this.parentMonster = monsterentity1;
            return true;
         }
      }
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      if (this.childMonster.getGrowingAge() >= 0) {
         return false;
      } else if (!this.parentMonster.isAlive()) {
         return false;
      } else {
         double d0 = this.childMonster.getDistanceSq(this.parentMonster);
         return !(d0 < 9.0D) && !(d0 > 256.0D);
      }
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.delayCounter = 0;
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.parentMonster = null;
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      if (--this.delayCounter <= 0) {
         this.delayCounter = 10;
         this.childMonster.getNavigator().tryMoveToEntityLiving(this.parentMonster, this.moveSpeed);
      }
   }
}