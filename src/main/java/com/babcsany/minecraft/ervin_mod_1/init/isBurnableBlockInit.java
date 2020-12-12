package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableBlockInit {

    public static final DeferredRegister<Block> BURNABLE_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> TRUGN = BURNABLE_BLOCKS.register("trugn", () -> new Trugn(
            Block.Properties.create(Material.EARTH)
                    .setRequiresTool()
                    .harvestLevel(18)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(10000000.0f)
    ));
    public static final RegistryObject<Block> SRIUNK_BLOCK = BURNABLE_BLOCKS.register("sriunk_block", () -> new SriunkBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(6)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(500.0f)
    ));
    public static final RegistryObject<Block> SRIUNK_STAIRS = BURNABLE_BLOCKS.register("sriunk_stairs", () -> new SriunkStairs(
            () -> SRIUNK_BLOCK.get().getDefaultState(), Block.Properties.from(SRIUNK_BLOCK.get())
    ));
    public static final RegistryObject<Block> TERAT_BLOCK = BURNABLE_BLOCKS.register("terat_block", () -> new TeratBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(32)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000.0f)
    ));
    public static final RegistryObject<Block> NIRK_BLOCK = BURNABLE_BLOCKS.register("nirk_block", () -> new NirkBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(20)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1562.0f)
    ));
}
