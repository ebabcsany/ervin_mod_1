package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> VILTDROP_BLOCK = BLOCKS.register("viltdrop_block", () -> new ViltdropBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000.0f)
    ));
    public static final RegistryObject<Block> SRIUNK_BLOCK = BLOCKS.register("sriunk_block", () -> new SriunkBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(500.0f)
    ));
    public static final RegistryObject<Block> TRUGN = BLOCKS.register("trugn", () -> new Trugn(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100000.0f)
    ));
    public static final RegistryObject<Block> REGDEM_BLOCK = BLOCKS.register("regdem_block", () -> new RegdemBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> LEAT_BLOCK = BLOCKS.register("leat_block", () -> new LeatBlock(
            Block.Properties.create(Material.FIRE)
                    .harvestLevel(2)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(100.0f)
    ));

    public static final RegistryObject<Block> LEAT_BLOCK_CRAFTING_TABLE = BLOCKS.register("leat_block_crafting_table", () -> new Block(
            Block.Properties.create(Material.DRAGON_EGG)
                    .harvestLevel(0)
                    .harvestTool(ToolType.AXE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(50.0f)
    ));

}
