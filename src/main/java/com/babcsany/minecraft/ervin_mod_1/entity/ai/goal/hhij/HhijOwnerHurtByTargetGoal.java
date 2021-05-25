package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.hhij;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijTameableEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.TargetGoal;

import java.util.EnumSet;

public class HhijOwnerHurtByTargetGoal extends TargetGoal {
   private final HhijTameableEntity tameable;
   private LivingEntity attacker;
   private int timestamp;

   public HhijOwnerHurtByTargetGoal(HhijTameableEntity theDefendingTameableIn) {
      super(theDefendingTameableIn, false);
      this.tameable = theDefendingTameableIn;
      this.setMutexFlags(EnumSet.of(Flag.TARGET));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.tameable.isTamed() && !this.tameable.func_233685_eM_()) {
         LivingEntity livingentity = this.tameable.getOwner();
         if (livingentity == null) {
            return false;
         } else {
            this.attacker = livingentity.getRevengeTarget();
            int i = livingentity.getRevengeTimer();
            return i != this.timestamp && this.isSuitableTarget(this.attacker, EntityPredicate.DEFAULT) && this.tameable.shouldAttackEntity(this.attacker, livingentity);
         }
      } else {
         return false;
      }
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.goalOwner.setAttackTarget(this.attacker);
      LivingEntity livingentity = this.tameable.getOwner();
      if (livingentity != null) {
         this.timestamp = livingentity.getRevengeTimer();
      }

      super.startExecuting();
   }
}