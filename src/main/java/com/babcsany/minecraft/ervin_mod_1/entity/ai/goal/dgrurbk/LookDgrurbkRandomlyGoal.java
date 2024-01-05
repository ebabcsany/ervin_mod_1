package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class LookDgrurbkRandomlyGoal extends Goal {
   private final DgrurbMobEntity idleEntity;
   private double lookX;
   private double lookZ;
   private int idleTime;

   public LookDgrurbkRandomlyGoal(DgrurbMobEntity entityIn) {
      this.idleEntity = entityIn;
      this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      return this.idleEntity.getRNG().nextFloat() < 0.02F;
   }

   /**
    * Returns whether an in-progress EntityAIBase should continue executing
    */
   public boolean shouldContinueExecuting() {
      return this.idleTime >= 0;
   }

   /**
    * Execute a one shot task or start executing a continuous task
    */
   public void startExecuting() {
      double d0 = (Math.PI * 2D) * this.idleEntity.getRNG().nextDouble();
      this.lookX = Math.cos(d0);
      this.lookZ = Math.sin(d0);
      this.idleTime = 20 + this.idleEntity.getRNG().nextInt(20);
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      --this.idleTime;
      this.idleEntity.getLookController().setLookPosition(this.idleEntity.getPosX() + this.lookX, this.idleEntity.getPosYEye(), this.idleEntity.getPosZ() + this.lookZ);
   }
}
