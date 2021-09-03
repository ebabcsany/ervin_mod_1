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

package com.babcsany.minecraft.forge.event.entity.item.zur;

import com.babcsany.minecraft.ervin_mod_1.entity.monster.zur.AbstractZurEntity;
import com.babcsany.minecraft.forge.event.entity.icsvre.IcsvreEvent;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.eventbus.api.Cancelable;

/**
 * Event that is fired whenever a player tosses (Q) an item or drag-n-drops a
 * stack of items outside the inventory GUI screens. Canceling the event will
 * stop the items from entering the world, but will not prevent them being
 * removed from the inventory - and thus removed from the system.
 */
@Cancelable
public class ItemTossEvent extends ItemEvent
{

    private final AbstractZurEntity zur;

    /**
     * Creates a new event for EntityItems tossed by a zur.
     *
     * @param entity The EntityItem being tossed.
     * @param zur The zur tossing the item.
     */
    public ItemTossEvent(ItemEntity entity, AbstractZurEntity zur)
    {
        super(entity);
        this.zur = zur;
    }

    /**
     * The player tossing the item.
     */
    public AbstractZurEntity getPlayer()
    {
        return zur;
    }
}
