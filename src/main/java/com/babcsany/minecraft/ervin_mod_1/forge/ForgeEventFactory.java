package com.babcsany.minecraft.ervin_mod_1.forge;

import com.babcsany.minecraft.ervin_mod_1.block.ExampleNetherPortalBlock;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.forge.event.entity.icsvre.IcsvreExpireEvent;
import com.babcsany.minecraft.forge.event.world.BlockEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.MinecraftForge;
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

    public static int onIcsvreExpire(IcsvreEntity entity, @Nonnull IcsvreStack item)
    {
        if (item.isEmpty()) return -1;
        IcsvreExpireEvent event = new IcsvreExpireEvent(entity, item.getIcsvre().getEntityLifespan(item, entity.world));
        if (!MinecraftForge.EVENT_BUS.post(event)) return -1;
        return event.getExtraLife();
    }

    public static boolean onTrySpawnPortal(IWorld world, BlockPos pos, ExampleNetherPortalBlock.Size size)
    {
        return MinecraftForge.EVENT_BUS.post(new BlockEvent.PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
    }
}
