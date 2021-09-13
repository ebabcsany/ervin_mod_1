package com.babcsany.minecraft.init.lc.block;

import com.babcsany.minecraft.forge.common.ModToolType;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.util.registry.Registry;

public class LcBlockInit {

    public static Blocks LC_BLOCKS;

    public static final Block FI_RT_PLOCK = register("lc/blocks/fi°rt_plock", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(20).harvestTool(ModToolType.TUKT).hardnessAndResistance(600.0F)));

    private static Block register(String key, Block blockIn) {
        return Registry.register(Registry.BLOCK, string(key), blockIn);
    }

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }
}
