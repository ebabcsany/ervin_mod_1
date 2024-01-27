package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

import javax.annotation.Nullable;

public class BrefkStageItem extends Item {
    private final Item containerItem;

    public BrefkStageItem(Properties properties, Item containerItem) {
        super(properties);
        this.containerItem = containerItem;
    }

    public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity livingEntity) {
        if (!world.isRemote) {
            livingEntity.curePotionEffects(itemStack);
        }

        if (livingEntity instanceof PlayerEntity && !((PlayerEntity)livingEntity).abilities.isCreativeMode) {
            itemStack.shrink(1);
        }

        return itemStack.isEmpty() ? new ItemStack(this.containerItem) : itemStack;
    }

    public int getUseDuration(ItemStack p_77626_1_) {
        return 32;
    }

    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        return DrinkHelper.func_234707_a_(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    public ICapabilityProvider initCapabilities(ItemStack p_initCapabilities_1_, @Nullable CompoundNBT p_initCapabilities_2_) {
        return new FluidBucketWrapper(p_initCapabilities_1_);
    }
}
