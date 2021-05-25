package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractNirtreEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;

public class NirtreLookAtCustomerGoal extends LookAtGoal {
   private final AbstractNirtreEntity nirtre;

   public NirtreLookAtCustomerGoal(AbstractNirtreEntity abstractNirtreEntityIn) {
      super(abstractNirtreEntityIn, PlayerEntity.class, 80.0F);
      this.nirtre = abstractNirtreEntityIn;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.nirtre.hasCustomer()) {
         this.closestEntity = this.nirtre.getCustomer();
         return true;
      } else {
         return false;
      }
   }
}