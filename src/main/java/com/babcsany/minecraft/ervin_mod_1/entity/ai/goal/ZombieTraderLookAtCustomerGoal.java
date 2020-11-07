package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.Abstract$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractZombieTraderEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;

public class ZombieTraderLookAtCustomerGoal extends LookAtGoal {
   private final AbstractZombieTraderEntity zombieTrader;

   public ZombieTraderLookAtCustomerGoal(AbstractZombieTraderEntity abstractZombieTraderEntityIn) {
      super(abstractZombieTraderEntityIn, PlayerEntity.class, 20.0F);
      this.zombieTrader = abstractZombieTraderEntityIn;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.zombieTrader.hasCustomer()) {
         this.closestEntity = this.zombieTrader.getCustomer();
         return true;
      } else {
         return false;
      }
   }
}