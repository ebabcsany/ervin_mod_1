package com.babcsany.minecraft.ervin_mod_1.entity.merchant.result_slot.trader_block;

import com.babcsany.minecraft.ervin_mod_1.entity.merchant.trader_block.IMerchant;
import com.babcsany.minecraft.ervin_mod_1.inventory.merchant.trader_block.TraderBlockInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.stats.Stats;

public class TraderBlockResultSlot extends Slot {
   private final TraderBlockInventory merchantInventory;
   private final PlayerEntity player;
   private int removeCount;
   private final IMerchant merchant;

   public TraderBlockResultSlot(PlayerEntity player, IMerchant merchant, TraderBlockInventory merchantInventory, int slotIndex, int xPosition, int yPosition) {
      super(merchantInventory, slotIndex, xPosition, yPosition);
      this.player = player;
      this.merchant = merchant;
      this.merchantInventory = merchantInventory;
   }

   /**
    * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
    */
   public boolean isItemValid(ItemStack stack) {
      return false;
   }

   /**
    * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new stack.
    */
   public ItemStack decrStackSize(int amount) {
      if (this.getHasStack()) {
         this.removeCount += Math.min(amount, this.getStack().getCount());
      }

      return super.decrStackSize(amount);
   }

   /**
    * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
    * internal count then calls onCrafting(item).
    */
   protected void onCrafting(ItemStack stack, int amount) {
      this.removeCount += amount;
      this.onCrafting(stack);
   }

   /**
    * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
    */
   protected void onCrafting(ItemStack stack) {
      stack.onCrafting(this.player.world, this.player, this.removeCount);
      this.removeCount = 0;
   }

   public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack) {
      this.onCrafting(stack);
      MerchantOffer merchantoffer = this.merchantInventory.func_214025_g();
      if (merchantoffer != null) {
         ItemStack itemstack = this.merchantInventory.getStackInSlot(0);
         ItemStack itemstack1 = this.merchantInventory.getStackInSlot(1);
         if (merchantoffer.doTransaction(itemstack, itemstack1) || merchantoffer.doTransaction(itemstack1, itemstack)) {
            this.merchant.onTrade(merchantoffer);
            thePlayer.addStat(Stats.TRADED_WITH_VILLAGER);
            this.merchantInventory.setInventorySlotContents(0, itemstack);
            this.merchantInventory.setInventorySlotContents(1, itemstack1);
         }

         this.merchant.setXP(this.merchant.getXp() + merchantoffer.getGivenExp());
      }

      return stack;
   }
}