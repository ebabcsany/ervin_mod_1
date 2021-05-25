package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class IMolaBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> ZIUZOTKO = BLOCKS.register("ziuzotko", () -> new Block(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3.0F, 6.0F)
    ));
    public static final RegistryObject<Block> UZGZOHIIAHO_RDRLKLJOHOJYS = BLOCKS.register("uzgzohiiaho_rdrlkljohojys", () -> new Block(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3.0F, 6.0F)
    ));
}
