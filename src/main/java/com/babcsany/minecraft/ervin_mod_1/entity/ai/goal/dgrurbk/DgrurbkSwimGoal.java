package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal.dgrurbk;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.tags.FluidTags;

import java.util.EnumSet;

public class DgrurbkSwimGoal extends Goal {
   private final DgrurbMobEntity entity;

   public DgrurbkSwimGoal(DgrurbMobEntity entityIn) {
      this.entity = entityIn;
      this.setMutexFlags(EnumSet.of(Flag.JUMP));
      entityIn.getNavigator().setCanSwim(true);
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      return this.entity.isInWater() && this.entity.func_233571_b_(FluidTags.WATER) > this.entity.func_233579_cu_() || this.entity.isInLava();
   }

   /**
    * Keep ticking a continuous task that has already been started
    */
   public void tick() {
      if (this.entity.getRNG().nextFloat() < 0.8F) {
         this.entity.getJumpController().setJumping();
      }

   }
}
