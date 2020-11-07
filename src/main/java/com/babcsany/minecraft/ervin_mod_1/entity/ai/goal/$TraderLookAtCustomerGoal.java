package com.babcsany.minecraft.ervin_mod_1.entity.ai.goal;

import com.babcsany.minecraft.ervin_mod_1.entity.villager.Abstract$TraderEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.villager.AbstractNirtreEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;

public class $TraderLookAtCustomerGoal extends LookAtGoal {
   private final Abstract$TraderEntity $_trader;

   public $TraderLookAtCustomerGoal(Abstract$TraderEntity abstract$TraderEntityIn) {
      super(abstract$TraderEntityIn, PlayerEntity.class, 80.0F);
      this.$_trader = abstract$TraderEntityIn;
   }

   /**
    * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
    * method as well.
    */
   public boolean shouldExecute() {
      if (this.$_trader.hasCustomer()) {
         this.closestEntity = this.$_trader.getCustomer();
         return true;
      } else {
         return false;
      }
   }
}