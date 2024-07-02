package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.entity.projectile.Huihk1;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class Huihk1RodItem extends FishingRodItem {
    public Huihk1RodItem(Properties builder) {
        super(builder);
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     * {@link #onItemUse}.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (playerIn.fishingBobber != null) {
            if (playerIn.fishingBobber instanceof Huihk1) {
                Huihk1 huihk1 = (Huihk1) playerIn.fishingBobber;
                int i = huihk1.handleHookRetraction(itemstack);
                itemstack.damageItem(i, playerIn, (player) -> player.sendBreakAnimation(handIn));
            }

            worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_FISHING_BOBBER_RETRIEVE, SoundCategory.NEUTRAL, 1.0F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        } else {
            worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_FISHING_BOBBER_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            if (!worldIn.isRemote) {
                int k = EnchantmentHelper.getFishingSpeedBonus(itemstack);
                int j = EnchantmentHelper.getFishingLuckBonus(itemstack);
                worldIn.addEntity(new Huihk1(playerIn, worldIn, j, k));
            }

            playerIn.addStat(Stats.ITEM_USED.get(this));
        }

        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability() {
        return 17;
    }
}