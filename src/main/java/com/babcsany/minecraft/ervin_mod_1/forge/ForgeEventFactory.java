package com.babcsany.minecraft.ervin_mod_1.forge;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.Icsvre;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nonnull;

public class ForgeEventFactory {

    public static Event.Result canDgrurbEntityDespawn(DgrurbMobEntity entity)
    {
        LivingSpawnEvent.AllowDgrurbDespawn event = new LivingSpawnEvent.AllowDgrurbDespawn(entity);
        MinecraftForge.EVENT_BUS.post(event);
        return event.getResult();
    }

    public static int onIcsvreExpire(Icsvre entity, @Nonnull ItemStack item)
    {
        if (item.isEmpty()) return -1;
        ItemExpireEvent event = new ItemExpireEvent(entity, item.getItem().getEntityLifespan(item, entity.world));
        if (!MinecraftForge.EVENT_BUS.post(event)) return -1;
        return event.getExtraLife();
    }
}
