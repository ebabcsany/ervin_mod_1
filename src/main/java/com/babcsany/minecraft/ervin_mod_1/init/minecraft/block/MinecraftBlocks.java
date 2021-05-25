package com.babcsany.minecraft.ervin_mod_1.init.minecraft.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.stairs.SmoothStoneStairs;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.stairs.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.stairs.RubyStairs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.block.Blocks.*;

public class MinecraftBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> SMOOTH_STONE_STAIRS = BLOCKS.register("smooth_stone_stairs", () -> new SmoothStoneStairs(SMOOTH_STONE.getDefaultState(), Block.Properties.from(SMOOTH_STONE)));
    public static final RegistryObject<Block> COAL_STAIRS = BLOCKS.register("coal_stairs", () -> new CoalStairs(COAL_BLOCK.getDefaultState(), Block.Properties.from(COAL_BLOCK)));
    public static final RegistryObject<Block> DIAMOND_STAIRS = BLOCKS.register("diamond_stairs", () -> new DiamondStairs(DIAMOND_BLOCK.getDefaultState(), Block.Properties.from(DIAMOND_BLOCK)));
    public static final RegistryObject<Block> DIRT_STAIRS = BLOCKS.register("dirt_stairs", () -> new DirtStairs(DIRT.getDefaultState(), Block.Properties.from(DIRT)));
    public static final RegistryObject<Block> EMERALD_STAIRS = BLOCKS.register("emerald_stairs", () -> new EmeraldStairs(EMERALD_BLOCK.getDefaultState(), Block.Properties.from(EMERALD_BLOCK)));
    public static final RegistryObject<Block> GOLD_STAIRS = BLOCKS.register("gold_stairs", () -> new GoldStairs(GOLD_BLOCK.getDefaultState(), Block.Properties.from(GOLD_BLOCK)));
    public static final RegistryObject<Block> IRON_STAIRS = BLOCKS.register("iron_stairs", () -> new IronStairs(IRON_BLOCK.getDefaultState(), Block.Properties.from(IRON_BLOCK)));
    public static final RegistryObject<Block> LAPIS_STAIRS = BLOCKS.register("lapis_stairs", () -> new LapisStairs(LAPIS_BLOCK.getDefaultState(), Block.Properties.from(LAPIS_BLOCK)));
    public static final RegistryObject<Block> REDSTONE_STAIRS = BLOCKS.register("redstone_stairs", () -> new RedstoneStairs(REDSTONE_BLOCK.getDefaultState(), Block.Properties.from(REDSTONE_BLOCK)));
    public static final RegistryObject<Block> OBSIDIAN_STAIRS = BLOCKS.register("obsidian_stairs", () -> new ObsidianStairs(OBSIDIAN.getDefaultState(), Block.Properties.from(OBSIDIAN)));
}
