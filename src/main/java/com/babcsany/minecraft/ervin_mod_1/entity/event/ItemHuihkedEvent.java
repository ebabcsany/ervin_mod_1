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

import com.google.common.base.Preconditions;
import net.minecraft.entity.projectile.HuihkEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;

import javax.annotation.Nonnegative;
import java.util.List;

/**
 * This event is called when a player fishes an item.
 *
 * This event is {@link Cancelable}
 * Canceling the event will cause the player to receive no items at all.
 * The hook will still take the damage specified
 */
@Cancelable
public class ItemHuihkedEvent extends PlayerEvent {
    private final NonNullList<ItemStack> stacks = NonNullList.create();
    private final HuihkEntity hook;
    private int rodDamage;

    public ItemHuihkedEvent(List<ItemStack> stacks, int rodDamage, HuihkEntity hook) {
        super(hook.func_234606_i_());
        this.stacks.addAll(stacks);
        this.rodDamage = rodDamage;
        this.hook = hook;
    }

    public int getRodDamage() {
        return this.rodDamage;
    }

    public void damageRodBy(@Nonnegative int rodDamage) {
        Preconditions.checkArgument(rodDamage >= 0);
        this.rodDamage = rodDamage;
    }

    public NonNullList<ItemStack> getDrops() {
        return this.stacks;
    }

    public HuihkEntity getHookEntity() {
        return this.hook;
    }
}