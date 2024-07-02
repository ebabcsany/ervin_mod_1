package com.babcsany.minecraft.ervin_mod_1.init.minecraft.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.stairs.RedstoneStairs;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.block.Blocks.*;

public class MinecraftBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final Block SMOOTH_STONE_STAIRS = registerBlockItem("smooth_stone_stairs", new StairsBlock(SMOOTH_STONE::getDefaultState, Block.Properties.from(SMOOTH_STONE)));
    public static final Block COAL_STAIRS = register("coal_stairs", new StairsBlock(COAL_BLOCK::getDefaultState, Block.Properties.from(COAL_BLOCK)));
    public static final Block DIAMOND_STAIRS = registerBlockItem("diamond_stairs", new StairsBlock(DIAMOND_BLOCK::getDefaultState, Block.Properties.from(DIAMOND_BLOCK)));
    public static final Block DIRT_STAIRS = registerBlockItem("dirt_stairs", new StairsBlock(DIRT::getDefaultState, Block.Properties.from(DIRT)));
    public static final Block EMERALD_STAIRS = registerBlockItem("emerald_stairs", new StairsBlock(EMERALD_BLOCK::getDefaultState, Block.Properties.from(EMERALD_BLOCK)));
    public static final Block GOLD_STAIRS = registerBlockItem("gold_stairs", new StairsBlock(GOLD_BLOCK::getDefaultState, Block.Properties.from(GOLD_BLOCK)));
    public static final Block IRON_STAIRS = registerBlockItem("iron_stairs", new StairsBlock(IRON_BLOCK::getDefaultState, Block.Properties.from(IRON_BLOCK)));
    public static final Block LAPIS_STAIRS = registerBlockItem("lapis_stairs", new StairsBlock(LAPIS_BLOCK::getDefaultState, Block.Properties.from(LAPIS_BLOCK)));
    public static final Block REDSTONE_STAIRS = registerBlockItem("redstone_stairs", new RedstoneStairs(REDSTONE_BLOCK::getDefaultState, Block.Properties.from(REDSTONE_BLOCK)));
    public static final Block OBSIDIAN_STAIRS = registerBlockItem("obsidian_stairs", new StairsBlock(OBSIDIAN::getDefaultState, Block.Properties.from(OBSIDIAN)));

    public static Block register(String name, Block blockIn) {
        return UnusedBlocks.registerDefault(name, blockIn);
    }

    public static Block registerBlockItem(String name, Block blockIn) {
        return UnusedBlocks.registerBlockItem(name, blockIn);
    }
}
