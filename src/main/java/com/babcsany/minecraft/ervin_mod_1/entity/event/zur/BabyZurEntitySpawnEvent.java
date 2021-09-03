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

package com.babcsany.minecraft.ervin_mod_1.entity.event.zur;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.AbstractkZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.AnimalDgrurbEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbAgeableEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.dgrurb.DgrurbMobEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AgeableZurEntity;
import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AnimalZurEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nullable;

/* *
 * BabyEntitySpawnEvent is fired just before a baby entity is about to be spawned. <br>
 * Parents will have disengaged their relationship. {@link @Cancelable} <br>
 * It is possible to change the child completely by using {@link #setChild(EntityAgeable)} <br>
 * This event is fired from {@link EntityAIMate#spawnBaby()} and {@link EntityAIVillagerMate#giveBirth()} <br>
 * <br>
 * {@link #parentA} contains the initiating parent entity.<br>
 * {@link #parentB} contains the secondary parent entity.<br>
 * {@link #causedByPlayer} contains the player responsible for the breading (if applicable).<br>
 * {@link #child} contains the child that will be spawned.<br>
 * <br>
 * This event is {@link Cancelable}.<br>
 * If this event is canceled, the child Entity is not added to the world, and the parents <br>
 * will no longer attempt to mate.
 * <br>
 * This event does not have a result. {@link HasResult}<br>
 * <br>
 * This event is fired on the {@link MinecraftForge#EVENT_BUS}.
 **/
@Cancelable
public class BabyZurEntitySpawnEvent extends net.minecraftforge.eventbus.api.Event
{
    private final LivingEntity parentA;
    private final LivingEntity parentB;
    private final PlayerEntity causedByPlayer;
    private AgeableZurEntity child;

    public BabyZurEntitySpawnEvent(LivingEntity parentA, LivingEntity parentB, @Nullable AgeableZurEntity proposedChild)
    {
        //causedByPlayer calculated here to simplify the patch.
        PlayerEntity causedByPlayer = null;
        if (parentA instanceof AnimalZurEntity) {
            causedByPlayer = ((AnimalZurEntity)parentA).getLoveCause();
        }

        if (causedByPlayer == null && parentB instanceof AnimalZurEntity)
        {
            causedByPlayer = ((AnimalZurEntity)parentB).getLoveCause();
        }

        this.parentA = parentA;
        this.parentB = parentB;
        this.causedByPlayer = causedByPlayer;
        this.child = proposedChild;
    }

    public LivingEntity getParentA()
    {
        return parentA;
    }

    public LivingEntity getParentB()
    {
        return parentB;
    }

    @Nullable
    public PlayerEntity getCausedByPlayer()
    {
        return causedByPlayer;
    }

    @Nullable
    public AgeableZurEntity getChild()
    {
        return child;
    }

    public void setChild(AgeableZurEntity proposedChild)
    {
        child = proposedChild;
    }
}