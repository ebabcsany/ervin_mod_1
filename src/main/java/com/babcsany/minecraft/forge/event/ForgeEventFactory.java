package com.babcsany.minecraft.forge.event;

import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.forge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ForgeEventFactory {

    public static void onPlayerDestroyIcsvre(PlayerEntity player, @Nonnull IcsvreStack stack, @Nullable Hand hand)
    {
        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(player, stack, hand));
    }
}
