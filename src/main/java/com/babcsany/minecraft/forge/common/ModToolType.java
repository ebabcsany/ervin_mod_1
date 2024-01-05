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

package com.babcsany.minecraft.forge.common;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraftforge.common.ToolType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class ModToolType
{

    public static final ToolType TUKT = get("tukt");

    /**
     * Gets the ToolType for the specified name, or creates a new one if none for that name does yet exist.
     * This method can be called during parallel loading
     */
    public static ToolType get(String name)
    {
        return ToolType.get(name);
    }

    public static String string(String name) {
        String string = "ervin_mof_1:";
        return string + name;
    }
}
