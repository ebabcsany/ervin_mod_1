package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.Tririj;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static BlockInit BLOCKS;

    public static final Block FRISZERN = registerBlockItem("friszern", new CommandBlockBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final Block CHAIN_FRISZERN = registerBlockItem("chain_friszern", new CommandBlockBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final Block REPEATING_FRISZERN = registerBlockItem("repeating_friszern", new CommandBlockBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final Block JURK = register("fluids/jurk", new Block(AbstractBlock.Properties.create(Material.WATER, MaterialColor.MAGENTA).doesNotBlockMovement().hardnessAndResistance(100.0F).setLightLevel((Value) -> 7)));
    public static final Block FIRG_PLANKS = register("firg_planks", new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block FIRG_PLANKS_STAIRS = register("firg_planks_stairs", new StairsBlock(FIRG_PLANKS.getBlock()::getDefaultState, Block.Properties.from(FIRG_PLANKS.getBlock())));
    public static final Block FIRG_PLANKS_DOOR = register("firg_planks_door", new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).variableOpacity().notSolid()));
    public static final Block FIRT_BLOCK = register("firt_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0F)));
    public static final Block REUTRIEN = register("reutrien", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5.0F).sound(SoundType.METAL).notSolid()));
    public static final Block TRIRIJ = register("tririj", new Tririj(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F)));

    public static Block registerBlockItem(String key, Block blockIn) {
        return UnusedBlocks.registerBlockItem(key, blockIn);
    }

    @Deprecated
    public static Block register(String key, Block blockIn) {
        return UnusedBlocks.registerDefault(key, blockIn);
    }

    public static void register() {
        Ervin_mod_1.register(BlockInit.class);
    }
}
