package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.WanderingTraderNirtreEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;

public class WanderingTraderNirtreLookAtCustomerGoal extends LookAtGoal {
   private final WanderingTraderNirtreEntity wanderingTraderNirtre;

   public WanderingTraderNirtreLookAtCustomerGoal(WanderingTraderNirtreEntity wanderingTraderNirtreIn) {
      super(wanderingTraderNirtreIn, PlayerEntity.class, 80.0F);
      this.wanderingTraderNirtre = wanderingTraderNirtreIn;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.wanderingTraderNirtre.hasCustomer()) {
         this.closestEntity = this.wanderingTraderNirtre.getCustomer();
         return true;
      } else {
         return false;
      }
   }
}