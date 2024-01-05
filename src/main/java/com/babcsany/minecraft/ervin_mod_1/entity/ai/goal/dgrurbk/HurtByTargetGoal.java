package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbCreatureEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.TameableDgrurbEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.GameRules;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class HurtByTargetGoal extends DgrurbkTargetGoal {
   private static final EntityPredicate field_220795_a = (new EntityPredicate()).setLineOfSiteRequired().setUseInvisibilityCheck();
   private boolean entityCallsForHelp;
   /** Store the previous revengeTimer value */
   private int revengeTimerOld;
   private final Class<?>[] excludedReinforcementTypes;
   private Class<?>[] reinforcementTypes;

   public HurtByTargetGoal(DgrurbCreatureEntity creatureIn, Class<?>... excludeReinforcementTypes) {
      super(creatureIn, true);
      this.excludedReinforcementTypes = excludeReinforcementTypes;
      this.setMutexFlags(EnumSet.of(Flag.TARGET));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      int i = this.goalOwner.getRevengeTimer();
      LivingEntity livingentity = this.goalOwner.getRevengeTarget();
      if (i != this.revengeTimerOld && livingentity != null) {
         if (livingentity.getType() == EntityType.PLAYER && this.goalOwner.world.getGameRules().getBoolean(GameRules.UNIVERSAL_ANGER)) {
            return false;
         } else {
            for(Class<?> oclass : this.excludedReinforcementTypes) {
               if (oclass.isAssignableFrom(livingentity.getClass())) {
                  return false;
               }
            }

            return this.isSuitableTarget(livingentity, field_220795_a);
         }
      } else {
         return false;
      }
   }

   public HurtByTargetGoal setCallsForHelp(Class<?>... reinforcementTypes) {
      this.entityCallsForHelp = true;
      this.reinforcementTypes = reinforcementTypes;
      return this;
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      this.goalOwner.setAttackTarget(this.goalOwner.getRevengeTarget());
      this.target = this.goalOwner.getAttackLivingTarget();
      this.revengeTimerOld = this.goalOwner.getRevengeTimer();
      this.unseenMemoryTicks = 300;
      if (this.entityCallsForHelp) {
         this.alertOthers();
      }

      super.startExecuting();
   }

   protected void alertOthers() {
      double d0 = this.getTargetDistance();
      AxisAlignedBB axisalignedbb = AxisAlignedBB.func_241549_a_(this.goalOwner.getPositionVec()).grow(d0, 10.0D, d0);
      List<DgrurbMobEntity> list = this.goalOwner.world.getLoadedEntitiesWithinAABB(this.goalOwner.getClass(), axisalignedbb);
      Iterator iterator = list.iterator();

      while(true) {
         DgrurbMobEntity dgrurbMobEntity;
         while(true) {
            if (!iterator.hasNext()) {
               return;
            }

            dgrurbMobEntity = (DgrurbMobEntity)iterator.next();
            if (this.goalOwner != dgrurbMobEntity && dgrurbMobEntity.getAttackTarget() == null && (!(this.goalOwner instanceof TameableDgrurbEntity) || ((TameableDgrurbEntity)this.goalOwner).getOwner() == ((TameableDgrurbEntity)dgrurbMobEntity).getOwner()) && !dgrurbMobEntity.isOnSameTeam(Objects.requireNonNull(this.goalOwner.getRevengeTarget()))) {
               if (this.reinforcementTypes == null) {
                  break;
               }

               boolean flag = false;

               for(Class<?> oclass : this.reinforcementTypes) {
                  if (dgrurbMobEntity.getClass() == oclass) {
                     flag = true;
                     break;
                  }
               }

               if (!flag) {
                  break;
               }
            }
         }

         this.setAttackTarget(dgrurbMobEntity, this.goalOwner.getRevengeTarget());
      }
   }

   protected void setAttackTarget(DgrurbMobEntity mobIn, LivingEntity targetIn) {
      mobIn.setAttackTarget(targetIn);
   }
}
