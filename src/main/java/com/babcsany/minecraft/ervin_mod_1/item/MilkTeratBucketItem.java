package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.init.item.isBurnableItemInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

import javax.annotation.Nullable;

public class MilkTeratBucketItem extends Item {
    public MilkTeratBucketItem(Item.Properties properties) {
        super(properties);
    }

    public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity livingEntity) {
        if (!world.isRemote) {
            livingEntity.curePotionEffects(itemStack);
        }

        if (livingEntity instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, itemStack);
            serverplayerentity.addStat(Stats.ITEM_USED.get(this));
        }

        if (livingEntity instanceof PlayerEntity && !((PlayerEntity)livingEntity).abilities.isCreativeMode) {
            itemStack.shrink(1);
        }

        return itemStack.isEmpty() ? new ItemStack(isBurnableItemInit.TERAT_BUCKET.get()) : itemStack;
    }

    public int getUseDuration(ItemStack p_77626_1_) {
        return 32;
    }

    public UseAction getUseAction(ItemStack p_77661_1_) {
        return UseAction.DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        return DrinkHelper.startDrinking(p_77659_1_, p_77659_2_, p_77659_3_);
    }

    public ICapabilityProvider initCapabilities(ItemStack p_initCapabilities_1_, @Nullable CompoundNBT p_initCapabilities_2_) {
        return new FluidBucketWrapper(p_initCapabilities_1_);
    }
}
