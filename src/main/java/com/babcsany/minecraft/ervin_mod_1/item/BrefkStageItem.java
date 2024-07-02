package com.babcsany.minecraft.ervin_mod_1.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
