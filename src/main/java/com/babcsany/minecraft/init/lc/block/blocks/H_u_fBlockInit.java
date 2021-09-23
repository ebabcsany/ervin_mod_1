package com.babcsany.minecraft.init.lc.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.block.blocks.Tririj;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.registry.Registry;

public class H_u_fBlockInit {

    public static Blocks H_U_F_BLOCKS;

    public static Block H_U_F_BLOCK;

    public static Block UUUUUUUUUUUUUUUUUUUUUUUU = register("uuuuuuuuuuuuuuuuuuuuuuuu", new Tririj(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F)));

    private static Block register(String key, Block blockIn) {
        return Registry.register(Registry.BLOCK, string(key), blockIn);
    }

    private static String string(String name) {
        String string = "ervin_mod_1:lc/block/blocks/hﬂuﬂf_block/";
        return string + name;
    }

    static {
        H_U_F_BLOCK = UUUUUUUUUUUUUUUUUUUUUUUU;
    }
}
