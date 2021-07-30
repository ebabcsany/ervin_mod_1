package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.entity.projectile.HuihkEntity;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.item.Item;

import javax.annotation.Nullable;

public class HuihkRodItem extends Item implements IVanishable {
   @Nullable
   public HuihkEntity huihk;
   public HuihkRodItem(Properties builder) {
      super(builder);
   }

   /**
    * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
    * {@link #onItemUse}.
    */
   /*public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
      ItemStack itemstack = playerIn.getHeldItem(handIn);
      if (this.huihk != null) {
         if (!worldIn.isRemote) {
            int i = this.huihk.handleHookRetraction(itemstack);
            itemstack.damageItem(i, playerIn, (p_220000_1_) -> {
               p_220000_1_.sendBreakAnimation(handIn);
            });
         }

         worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_FISHING_BOBBER_RETRIEVE, SoundCategory.NEUTRAL, 1.0F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
      } else {
         worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_FISHING_BOBBER_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
         if (!worldIn.isRemote) {
            int k = EnchantmentHelper.getFishingSpeedBonus(itemstack);
            int j = EnchantmentHelper.getFishingLuckBonus(itemstack);
            worldIn.addEntity(new HuihkEntity(worldIn, playerIn, j, k));
         }

         playerIn.addStat(Stats.ITEM_USED.get(this));
      }

      return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
   }*/

   /**
    * Return the enchantability factor of the item, most of the time is based on material.
    */
   public int getItemEnchantability() {
      return 1;
   }
}