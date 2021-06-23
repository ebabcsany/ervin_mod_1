package com.babcsany.minecraft;

import net.minecraft.entity.Entity;

public interface IRangedAttackMob {
   /**
    * Attack the specified entity using a ranged attack.
    */
   void attackEntityWithRangedAttack(Entity target, float distanceFactor);
}
