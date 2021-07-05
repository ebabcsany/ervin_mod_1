package com.babcsany.minecraft.init;

import com.babcsany.minecraft.block.FlowingFluidBlockg;
import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.FirgPlanksStairs;
import com.babcsany.minecraft.fluid.block.FlowingFluidBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static BlockInit BLOCKS;

    public static final Block JURK = register("ervin_mod_1:fluids/jurk", new FlowingFluidBlock(FluidInit.JURK, AbstractBlock.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0F).setLightLevel((blockState) -> 4).noDrops()));
    public static final Block FIRG_PLANKS = register("ervin_mod_1:firg_planks", new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block FIRG_PLANKS_STAIRS = register("ervin_mod_1:firg_planks_stairs", new FirgPlanksStairs(FIRG_PLANKS.getDefaultState(), Block.Properties.from(FIRG_PLANKS)));
    public static final Block FIRG_PLANKS_DOOR = register("ervin_mod_1:firg_planks_door", new DoorBlock(AbstractBlock.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));


    private static Block register(String key, Block blockIn) {
        return Registry.register(Registry.BLOCK, key, blockIn);
    }
}
