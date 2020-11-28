/*
 * Minecraft Forge
 * Copyright (c) 2016-2019.
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

package com.babcsany.minecraft.ervin_mod_1.item;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.regex.Pattern;

public final class ToolType1
{
    private static final Pattern VALID_NAME = Pattern.compile("[^a-z_]"); //Only a-z and _ are allowed, meaning names must be lower case. And use _ to separate words.
    private static final Map<String, ToolType1> values = Maps.newHashMap();

    public static final ToolType1 AXE = get("axe");
    public static final ToolType1 PICKAXE = get("pickaxe");
    public static final ToolType1 SHOVEL = get("shovel");
    public static final ToolType1 HOE = get("hoe");


    public static ToolType1 get(String name)
    {
        if (VALID_NAME.matcher(name).find())
            throw new IllegalArgumentException("ToolType1.create() called with invalid name: " + name);
        return values.computeIfAbsent(name, k -> new ToolType1(name));
    }

    private final String name;

    private ToolType1(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}