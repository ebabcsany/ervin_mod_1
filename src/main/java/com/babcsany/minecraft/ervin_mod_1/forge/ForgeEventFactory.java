package com.babcsany.minecraft.ervin_mod_1.forge;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;

public class ForgeEventFactory {

    public static Event.Result canDgrurbEntityDespawn(DgrurbMobEntity entity)
    {
        LivingSpawnEvent.AllowDgrurbDespawn event = new LivingSpawnEvent.AllowDgrurbDespawn(entity);
        MinecraftForge.EVENT_BUS.post(event);
        return event.getResult();
    }
}
