package com.babcsany.minecraft.forge.event;

import com.babcsany.minecraft.ervin_mod_1.item.item.stack.IcsvreStack;
import com.babcsany.minecraft.forge.event.entity.player.PlayerDestroyItemEvent;
import com.babcsany.minecraft.world.world;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ForgeEventFactory {

    public static void onPlayerDestroyIcsvre(PlayerEntity player, @Nonnull IcsvreStack stack, @Nullable Hand hand)
    {
        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(player, stack, hand));
    }

    public static boolean doSpecialSpawn(MobEntity entity, world world, float x, float y, float z, AbstractSpawner spawner, SpawnReason spawnReason)
    {
        return MinecraftForge.EVENT_BUS.post(new LivingSpawnEvent.SpecialSpawn_world(entity, world, x, y, z, spawner, spawnReason));
    }
}
