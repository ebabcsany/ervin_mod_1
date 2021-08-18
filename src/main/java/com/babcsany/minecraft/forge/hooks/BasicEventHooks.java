package com.babcsany.minecraft.forge.hooks;

import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.forge.event.entity.player.PlayerEvent;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class BasicEventHooks {

    public static void firePlayerItemPickupEvent(PlayerEntity player, IcsvreEntity item, IcsvreStack clone)
    {
        MinecraftForge.EVENT_BUS.post(new PlayerEvent.IcsvrePickupEvent(player, item, clone));
    }
}
