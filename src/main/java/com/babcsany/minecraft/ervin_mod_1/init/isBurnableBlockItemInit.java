package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableBlockItemInit {

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
    public static final RegistryObject<Block> SRIUNK_SLAB = BURNABLE_BLOCKS.register("sriunk_slab", () -> new SriunkSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(6)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(200.0F, 5000.0F)
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
    public static final RegistryObject<Block> GRINT_BLOCK = BURNABLE_BLOCKS.register("grint_block", () -> new GrintBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> GRINT_SLAB = BURNABLE_BLOCKS.register("grint_slab", () -> new GrintSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(120.0f)
    ));
    public static final RegistryObject<Block> GRITH_BLOCK = BURNABLE_BLOCKS.register("grith_block", () -> new GrithBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(30)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000000.0F)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> VILTDROP_BLOCK = BURNABLE_BLOCKS.register("viltdrop_block", () -> new ViltdropBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000.0f)
    ));
    public static final RegistryObject<Block> GARK_BLOCK = BURNABLE_BLOCKS.register("gark_block", () -> new GarkBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(12)
                    .hardnessAndResistance(2000.0f)
    ));
    public static final RegistryObject<Block> GARK_SLAB = BURNABLE_BLOCKS.register("gark_slab", () -> new GarkSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(12)
                    .hardnessAndResistance(2000.0f, 2200.0f)
    ));
}
