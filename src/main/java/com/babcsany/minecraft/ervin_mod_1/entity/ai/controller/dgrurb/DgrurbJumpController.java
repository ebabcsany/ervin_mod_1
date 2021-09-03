package com.babcsany.minecraft.ervin_mod_1.entity.ai.controller.dgrurb;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import net.minecraft.entity.MobEntity;

public class DgrurbJumpController {
   private final DgrurbMobEntity mob;
   protected boolean isJumping;

   public DgrurbJumpController(DgrurbMobEntity mob) {
      this.mob = mob;
   }

   public void setJumping() {
      this.isJumping = true;
   }

   /**
    * Called to actually make the entity jump if isJumping is true.
    */
   public void tick() {
      this.mob.setJumping(this.isJumping);
      this.isJumping = false;
   }
}
