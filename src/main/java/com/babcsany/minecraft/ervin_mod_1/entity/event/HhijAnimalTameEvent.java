/*
 * Minecraft Forge
 * Copyright (c) 2016-2020.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package com.babcsany.minecraft.ervin_mod_1.entity.event;

import com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijAnimalEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Cancelable;

/**
 * This event is fired when an {@link HhijAnimalEntity} is tamed. <br>
 * It is fired via {@link com.babcsany.minecraft.ervin_mod_1.entity.animal.hhij.HhijEntity#onAnimalTame(HhijAnimalEntity, PlayerEntity)}.
 * Forge fires this event for applicable vanilla animals, mods need to fire it themselves.
 * This event is {@link Cancelable}. If canceled, taming the animal will fail.
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.
 */
@Cancelable
public class HhijAnimalTameEvent extends LivingEvent
{
    private final HhijAnimalEntity animal;
    private final PlayerEntity tamer;

    public HhijAnimalTameEvent(HhijAnimalEntity animal, PlayerEntity tamer)
    {
        super(animal);
        this.animal = animal;
        this.tamer = tamer;
    }

    public HhijAnimalEntity getAnimal()
    {
        return animal;
    }

    public PlayerEntity getTamer()
    {
        return tamer;
    }
}