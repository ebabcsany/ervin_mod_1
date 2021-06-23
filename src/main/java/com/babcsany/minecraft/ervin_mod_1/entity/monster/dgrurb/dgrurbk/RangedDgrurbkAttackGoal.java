package com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.dgrurbk;

import java.util.EnumSet;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import net.minecraft.entity.Entity;
import com.babcsany.minecraft.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.MathHelper;

public class RangedDgrurbkAttackGoal extends Goal {
   private final DgrurbMobEntity entityHost;
   private final IRangedAttackMob rangedAttackEntityHost;
   private Entity attackTarget;
   private int rangedAttackTime = -1;
   private final double entityMoveSpeed;
   private int seeTime;
   private final int attackIntervalMin;
   private final int maxRangedAttackTime;
   private final float attackRadius;
   private final float maxAttackDistance;

   public RangedDgrurbkAttackGoal(IRangedAttackMob attacker, double moveSpeed, int maxAttackTime, float maxAttackDistanceIn) {
      this(attacker, moveSpeed, maxAttackTime, maxAttackTime, maxAttackDistanceIn);
   }

   public RangedDgrurbkAttackGoal(IRangedAttackMob attacker, double moveSpeed, int p_i1650_4_, int maxAttackTime, float maxAttackDistanceIn) {
      if (!(attacker instanceof LivingEntity)) {
         throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
      } else {
         this.rangedAttackEntityHost = attacker;
         this.entityHost = (DgrurbMobEntity)attacker;
         this.entityMoveSpeed = moveSpeed;
         this.attackIntervalMin = p_i1650_4_;
         this.maxRangedAttackTime = maxAttackTime;
         this.attackRadius = maxAttackDistanceIn;
         this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
         this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
      }
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      Entity livingentity = this.entityHost.getAttackTarget();
      if (livingentity != null && livingentity.isAlive()) {
         this.attackTarget = livingentity;
         return true;
      } else {
         return false;
      }
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void resetTask() {
      this.attackTarget = null;
      this.seeTime = 0;
      this.rangedAttackTime = -1;
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      double d0 = this.entityHost.getDistanceSq(this.attackTarget.getPosX(), this.attackTarget.getPosY(), this.attackTarget.getPosZ());
      boolean flag = this.entityHost.getEntitySenses().canSee(this.attackTarget);
      if (flag) {
         ++this.seeTime;
      } else {
         this.seeTime = 0;
      }

      if (!(d0 > (double)this.maxAttackDistance) && this.seeTime >= 5) {
         this.entityHost.getNavigator().clearPath();
      } else {
         this.entityHost.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
      }

      this.entityHost.getLookController().setLookPositionWithEntity(this.attackTarget, 30.0F, 30.0F);
      if (--this.rangedAttackTime == 0) {
         if (!flag) {
            return;
         }

         float f = MathHelper.sqrt(d0) / this.attackRadius;
         float lvt_5_1_ = MathHelper.clamp(f, 0.1F, 1.0F);
         this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, lvt_5_1_);
         this.rangedAttackTime = MathHelper.floor(f * (float)(this.maxRangedAttackTime - this.attackIntervalMin) + (float)this.attackIntervalMin);
      } else if (this.rangedAttackTime < 0) {
         float f2 = MathHelper.sqrt(d0) / this.attackRadius;
         this.rangedAttackTime = MathHelper.floor(f2 * (float)(this.maxRangedAttackTime - this.attackIntervalMin) + (float)this.attackIntervalMin);
      }

   }
}
