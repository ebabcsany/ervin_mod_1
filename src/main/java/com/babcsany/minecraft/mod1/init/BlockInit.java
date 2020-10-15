package com.babcsany.minecraft.mod1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.mod1.block.Mod1ViltdropBlock;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.*;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> VILTDROP_BLOCK = BLOCKS.register("viltdrop_block", () -> new Mod1ViltdropBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(4)
                    .harvestTool(ToolType.HOE)
                    .hardnessAndResistance(1000.0f)
    ));
}
