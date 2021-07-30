package com.babcsany.minecraft.ervin_mod_1.init.special;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.AbstractModBlock;
import com.babcsany.minecraft.ervin_mod_1.block.Mod_Block;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.special.Gtrziuzhizjkj;
import com.babcsany.minecraft.ervin_mod_1.init.init.MaterialInit;
import com.babcsany.minecraft.ervin_mod_1.init.sound.SoundInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SpecialBlockInit {

    public static final DeferredRegister<Block> SPECIAL_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> GTRZIUZHIZJKJ = SPECIAL_BLOCKS.register(string("gtrziuzhizjkj"), () -> new Gtrziuzhizjkj(Block.Properties.create(Material.ROCK, MaterialColor.MAGENTA).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5000.0F, 150000.0F).sound(SoundType.ROOT)));
    public static final RegistryObject<Block> TFJHU_1 = SPECIAL_BLOCKS.register(string("tfjhu/tfjhu_1"), () -> new Mod_Block(AbstractBlock.Properties.create(MaterialInit.ROCK), AbstractModBlock.Properties.create(MaterialInit.ROCK).soundInit(SoundInit.WOIK)));

    private static String string(String name) {
        String string = "special/";
        return string + name;
    }
}
