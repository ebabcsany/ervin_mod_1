package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.block.blocks.FirgPlanksStairs;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.FirtBlock;
import com.babcsany.minecraft.ervin_mod_1.init.init.MaterialInit;
import com.babcsany.minecraft.fluid.block.FlowingFluidBlock;
import com.babcsany.minecraft.fluid.block.ModFlowingFluidBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ToolType;

//import static com.babcsany.minecraft.ervin_mod_1.init.fluid.FluidInit.JURK_FLUID;

public class BlockInit {

    public static BlockInit BLOCKS;

    public static final Block JURK = register("ervin_mod_1:fluids/jurk", new FlowingFluidBlock(FluidInit_.JURK, AbstractBlock.Properties.create(Material.WATER, MaterialColor.MAGENTA).doesNotBlockMovement().hardnessAndResistance(100.0F).setLightLevel((Value) -> 15).noDrops()));
    public static final Block FIRG_PLANKS = register("ervin_mod_1:firg_planks", new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block FIRG_PLANKS_STAIRS = register("ervin_mod_1:firg_planks_stairs", new FirgPlanksStairs(FIRG_PLANKS.getDefaultState(), Block.Properties.from(FIRG_PLANKS)));
    public static final Block FIRG_PLANKS_DOOR = register("ervin_mod_1:firg_planks_door", new DoorBlock(AbstractBlock.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final Block FIRT_BLOCK = register("ervin_mod_1:firt_block", new FirtBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0F)));

    private static Block register(String key, Block blockIn) {
        return Registry.register(Registry.BLOCK, key, blockIn);
    }
    private static FlowingFluidBlock register(String key, FlowingFluidBlock blockIn) {
        return Registry.register(Registry.BLOCK, key, blockIn);
    }
}