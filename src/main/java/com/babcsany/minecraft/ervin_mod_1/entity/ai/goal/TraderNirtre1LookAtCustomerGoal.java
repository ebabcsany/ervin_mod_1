package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.TraderNirtre1Entity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;

public class TraderNirtre1LookAtCustomerGoal extends LookAtGoal {
   private final TraderNirtre1Entity traderNirtre1;

   public TraderNirtre1LookAtCustomerGoal(TraderNirtre1Entity traderNirtre1In) {
      super(traderNirtre1In, PlayerEntity.class, 80.0F);
      this.traderNirtre1 = traderNirtre1In;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.traderNirtre1.hasCustomer()) {
         this.closestEntity = this.traderNirtre1.getCustomer();
         return true;
      } else {
         return false;
      }
   }
}