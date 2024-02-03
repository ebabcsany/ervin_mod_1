package com.babcsany.minecraft.ervin_mod_1.item;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.consumer.consumers.Consumer_1;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class BrefkStageItem extends Item {
    private final Item containerItem;

    public BrefkStageItem(Properties properties, Item containerItem) {
        super(properties);
        this.containerItem = containerItem;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity living) {

        if (living instanceof PlayerEntity && !((PlayerEntity)living).abilities.isCreativeMode) {
            stack.shrink(1);
        }

        return stack.isEmpty() ? new ItemStack(this.containerItem) : stack;
    }
}
