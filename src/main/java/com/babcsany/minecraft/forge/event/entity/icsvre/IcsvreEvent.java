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

package com.babcsany.minecraft.forge.event.entity.icsvre;

import com.babcsany.minecraft.ervin_mod_1.item.entity.icsvre.IcsvreEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraftforge.event.entity.EntityEvent;

/**
 * Base class for all IcsvreEntity events. Contains a reference to the
 * EntityItem of interest. For most EntityItem events, there's little to no
 * additional useful data from the firing method that isn't already contained
 * within the IcsvreEntity instance.
 */
public class IcsvreEvent extends EntityEvent
{
    private final IcsvreEntity entityItem;

    /**
     * Creates a new event for an IcsvreEntity.
     *
     * @param itemEntity The IcsvreEntity for this event
     */
    public IcsvreEvent(IcsvreEntity itemEntity)
    {
        super(itemEntity);
        this.entityItem = itemEntity;
    }

    /**
     * The relevant IcsvreEntity for this event, already cast for you.
     */
    public IcsvreEntity getEntityItem()
    {
        return entityItem;
    }
}
