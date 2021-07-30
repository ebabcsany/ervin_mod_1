package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.function.Predicate;

public class NearestAttackableDgrurbkTargetGoal<T extends Entity> extends DgrurbkTargetGoal {
   protected final Class<T> targetClass;
   protected final int targetChance;
   protected Entity nearestTarget;
   /** This filter is applied to the Entity search. Only matching entities will be targeted. */
   protected EntityPredicate targetEntitySelector;

   public NearestAttackableDgrurbkTargetGoal(DgrurbMobEntity goalOwnerIn, Class<T> targetClassIn, boolean checkSight) {
      this(goalOwnerIn, targetClassIn, checkSight, false);
   }

   public NearestAttackableDgrurbkTargetGoal(DgrurbMobEntity goalOwnerIn, Class<T> targetClassIn, boolean checkSight, boolean nearbyOnlyIn) {
      this(goalOwnerIn, targetClassIn, 10, checkSight, nearbyOnlyIn, null);
   }

   public NearestAttackableDgrurbkTargetGoal(DgrurbMobEntity goalOwnerIn, Class<T> targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, @Nullable Predicate<LivingEntity> targetPredicate) {
      super(goalOwnerIn, checkSight, nearbyOnlyIn);
      this.targetClass = targetClassIn;
      this.targetChance = targetChanceIn;
      this.setMutexFlags(EnumSet.of(Flag.TARGET));
      this.targetEntitySelector = (new EntityPredicate()).setDistance(this.getTargetDistance()).setCustomPredicate(targetPredicate);
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.targetChance > 0 && this.goalOwner.getRNG().nextInt(this.targetChance) != 0) {
         return false;
      } else {
         this.findNearestTarget();
         return this.nearestTarget != null;
      }
   }

   protected AxisAlignedBB getTargetableArea(double targetDistance) {
      return this.goalOwner.getBoundingBox().grow(targetDistance, 4.0D, targetDistance);
   }

   protected void findNearestTarget() {
      if (this.targetClass != PlayerEntity.class && this.targetClass != ServerPlayerEntity.class) {
         this.nearestTarget = this.goalOwner.world.func_225318_c(this.targetClass, this.targetEntitySelector, this.goalOwner, this.goalOwner.getPosX(), this.goalOwner.getPosYEye(), this.goalOwner.getPosZ(), this.getTargetableArea(this.getTargetDistance()));
      } else {
         this.nearestTarget = this.goalOwner.world.getClosestPlayer(this.targetEntitySelector, this.goalOwner, this.goalOwner.getPosX(), this.goalOwner.getPosYEye(), this.goalOwner.getPosZ());
      }

   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.goalOwner.setAttackTarget(this.nearestTarget);
      super.startExecuting();
   }

   public void setNearestTarget(@Nullable Entity target) {
      this.nearestTarget = target;
   }
}