package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.slabs.RedstoneSlab;
import com.babcsany.minecraft.ervin_mod_1.block.ores.IronOre;
import com.babcsany.minecraft.ervin_mod_1.init.sound.SoundInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FrimTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.JazzTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModSaplingBlock;
import com.babcsany.minecraft.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.*;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Function;

import static net.minecraft.block.Blocks.OAK_SAPLING;
import static net.minecraft.block.Blocks.OBSIDIAN;

public class BlockItemInit {

//    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final Block EXAMPLE_BLOCK;
    //public static final RegistryObject<Block> ZUR_BLOCK = BLOCKS.register("zur_block", () -> new FallingBlock(Block.Properties.create(Material.SAND).hardnessAndResistance(1.5f, 45.0f).sound(SoundType.WOOD)));
    public static final Block DEFERRED_BLOCK;
    public static final Block JAZZ_LOG;
    public static final Block JAZZ_LEAVES;
    public static final Block JAZZ_SAPLING;
    public static final Block REGDEM_BLOCK;
    public static final Block SRIUNK_ORE;
    public static final Block RUBY_BLOCK;
    public static final Block RED_COBBLESTONE;
    public static final Block AVTER_BLOCK = registerBlockItem("avter_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(5).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6000.0f)));
    public static final Block FRIT_BLOCK = registerBlockItem("frit_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0f)));
//    public static final Block END_PORTAL = registerBlockItem("end_portal", new EndPortalBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(13).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0f)));
    public static final Block END_STONE_CISK = registerBlockItem("end_stone_cisk", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(30.0f)));
    public static final Block END_STONE_CRISK = registerBlockItem("end_stone_crisk", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(45.0f)));
    public static final Block END_SRACT = registerBlockItem("end_sract", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(8.0f)));
    public static final Block ENDER_SRACT = registerBlockItem("ender_sract", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(9.0f)));
    public static final Block ENDER_SACKT = registerBlockItem("ender_sackt", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0f)));
    public static final Block ENDER_SACT = registerBlockItem("ender_sact", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(12.0f)));
    public static final Block ENDER_SRACKH = registerBlockItem("ender_srackh", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(14.0f)));
    public static final Block ENDER_SRACK = registerBlockItem("ender_srack", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(16.0f)));
    public static final Block END_SRACKT = registerBlockItem("end_srackt", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(16.0f)));
    public static final Block GRIRZT = registerBlockItem("grirzt", new Grirzt(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(17).harvestTool(ToolType.PICKAXE).hardnessAndResistance(160.0f)));
    public static final Block TRING = registerBlockItem("tring", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(60.0f)));
    public static final Block PACK_BLOCK = registerBlockItem("pack_block", new Block(Block.Properties.create(Material.EARTH).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(40.0f)));
    public static final Block KALT_BLOCK = registerBlockItem("kalt_block", new ModOreBlock(5, 12, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0f)));
    public static final Block URVI = registerBlockItem("urvi", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 9.0F)));
    public static final Block SURVI = registerBlockItem("survi", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 9.0F)));
    public static final Block SURV = registerBlockItem("surv", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(4.0F, 10.0F)));
    public static final Block SURT = registerBlockItem("surt", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5.0F, 12.0F)));
    public static final Block BLACK_COBBLESTONE = registerCobblestone("black");
    public static final Block BLUE_COBBLESTONE = registerCobblestone("blue");
    public static final Block BROWN_COBBLESTONE = registerCobblestone("brown");
    public static final Block CYAN_COBBLESTONE = registerCobblestone("cyan");
    public static final Block GREEN_COBBLESTONE = registerCobblestone("green");
    public static final Block LIGHT_BLUE_COBBLESTONE = registerCobblestone("light_blue1");
    public static final Block LIGHT_BLUE1_COBBLESTONE = registerCobblestone("light_blue");
    public static final Block LIGHT_GRAY_COBBLESTONE = registerCobblestone("light_gray");
    public static final Block LIME_COBBLESTONE = registerCobblestone("lime");
    public static final Block MAGENTA_COBBLESTONE = registerCobblestone("magenta");
    public static final Block ORANGE_COBBLESTONE = registerCobblestone("orange");
    public static final Block PINK_COBBLESTONE = registerCobblestone("pink");
    public static final Block PURPLE_COBBLESTONE = registerCobblestone("purple");
    public static final Block WHITE_COBBLESTONE = registerCobblestone("white");
    public static final Block YELLOW_COBBLESTONE = registerCobblestone("yellow");
    public static final Block ENDER_SRACKTH = registerBlockItem("ender_srackth", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(20.0f)));
    public static final Block OAK_TURG = registerBlockItem("oak_turg", new Block(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block FIRG_TURG = registerBlockItem("firg_turg", new Block(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block FRIM_TURG = registerBlockItem("frim_turg", new Block(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block ENDER_TRASK = registerBlockItem("ender_trask", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(6).hardnessAndResistance(160.0f)));
    public static final Block ACACIA_TURG = registerBlockItem("acacia_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block BIRCH_TURG = registerBlockItem("birch_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block DARK_OAK_TURG = registerBlockItem("dark_oak_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block JUNGLE_TURG = registerBlockItem("jungle_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block SPRUCE_TURG = registerBlockItem("spruce_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block TURG = registerBlockItem("turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block L0 = registerNumBlockItem("0");
    public static final Block L1 = registerNumBlockItem("1");
    public static final Block L2 = registerNumBlockItem("2");
    public static final Block L3 = registerNumBlockItem("3");
    public static final Block L4 = registerNumBlockItem("4");
    public static final Block L5 = registerNumBlockItem("5");
    public static final Block L6 = registerNumBlockItem("6");
    public static final Block L7 = registerNumBlockItem("7");
    public static final Block L8 = registerNumBlockItem("8");
    public static final Block L9 = registerNumBlockItem("9");
    public static final Block TRINKS = registerBlockItem("trinks", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().doesNotBlockMovement().setLightLevel(Value -> 15)));
    public static final Block DIRT1 = registerBlockItem("dirt1", new AmbientOcclusionLightBlock(Block.Properties.create(Material.EARTH, MaterialColor.DIRT).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.GROUND), 1));
    public static final Block GNITH_BLOCK = registerBlockItem("gnith_block", new ModOreBlock(2, 9, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(200.0F, 5000.0F)));
    public static final Block DIAMOND_SLAB = registerBlockItem("diamond_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).sound(SoundType.METAL).setRequiresTool().harvestLevel(3).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final Block OBSIDIAN_SLAB = registerBlockItem("obsidian_slab", new SlabBlock(Block.Properties.from(OBSIDIAN)));
    public static final Block IRON_SLAB = registerBlockItem("iron_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).sound(SoundType.METAL).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final Block GOLD_SLAB = registerBlockItem("gold_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.GOLD).sound(SoundType.METAL).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(4.0F, 6.0F)));
    public static final Block REDSTONE_SLAB = registerBlockItem("redstone_slab", new RedstoneSlab(Block.Properties.create(Material.IRON, MaterialColor.TNT).sound(SoundType.METAL).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final Block DIRT_SLAB = registerBlockItem("dirt_slab", new SlabBlock(Block.Properties.create(Material.EARTH, MaterialColor.DIRT).sound(SoundType.GROUND).harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(1.0F)));
    public static final Block LAPIS_SLAB = registerBlockItem("lapis_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.LAPIS).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));
    public static final Block EMERALD_SLAB = registerBlockItem("emerald_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.EMERALD).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final Block RUBY_SLAB;
    public static final Block RUBY_STAIRS;
    public static final Block BLACK_STONE = registerStone("black");
    public static final Block BLUE_STONE = registerStone("blue");
    public static final Block BROWN_STONE = registerStone("brown");
    public static final Block CYAN_STONE = registerStone("cyan");
    public static final Block GREEN_STONE = registerStone("green");
    public static final Block LIGHT_BLUE_STONE = registerStone("light_blue");
    public static final Block LIGHT_BLUE1_STONE = registerStone("light_blue1");
    public static final Block LIGHT_GRAY_STONE = registerStone("light_gray");
    public static final Block LIME_STONE = registerStone("lime");
    public static final Block MAGENTA_STONE = registerStone("magenta");
    public static final Block ORANGE_STONE = registerStone("orange");
    public static final Block PINK_STONE = registerStone("pink");
    public static final Block PURPLE_STONE = registerStone("purple");
    public static final Block RED_STONE = registerStone("red");
    public static final Block WHITE_STONE = registerStone("white");
    public static final Block YELLOW_STONE = registerStone("yellow");
    public static final Block BLACK_COBBLESTONE_SLAB = registerCobblestoneSlab("black");
    public static final Block BLUE_COBBLESTONE_SLAB = registerCobblestoneSlab("blue");
    public static final Block BROWN_COBBLESTONE_SLAB = registerCobblestoneSlab("brown");
    public static final Block CYAN_COBBLESTONE_SLAB = registerCobblestoneSlab("cyan");
    public static final Block GREEN_COBBLESTONE_SLAB = registerCobblestoneSlab("green");
    public static final Block LIGHT_BLUE_COBBLESTONE_SLAB = registerCobblestoneSlab("light_blue");
    public static final Block LIGHT_BLUE1_COBBLESTONE_SLAB = registerCobblestoneSlab("light_blue1");
    public static final Block LIGHT_GRAY_COBBLESTONE_SLAB = registerCobblestoneSlab("light_gray");
    public static final Block LIME_COBBLESTONE_SLAB = registerCobblestoneSlab("lime");
    public static final Block MAGENTA_COBBLESTONE_SLAB = registerCobblestoneSlab("magenta");
    public static final Block ORANGE_COBBLESTONE_SLAB = registerCobblestoneSlab("orange");
    public static final Block PINK_COBBLESTONE_SLAB = registerCobblestoneSlab("pink");
    public static final Block PURPLE_COBBLESTONE_SLAB = registerCobblestoneSlab("purple");
    public static final Block RED_COBBLESTONE_SLAB = registerCobblestoneSlab("red");
    public static final Block WHITE_COBBLESTONE_SLAB = registerCobblestoneSlab("white");
    public static final Block YELLOW_COBBLESTONE_SLAB = registerCobblestoneSlab("yellow");
    public static final Block BLACK_STONE_SLAB = registerStoneSlab("black");
    public static final Block BLUE_STONE_SLAB = registerStoneSlab("blue");
    public static final Block BROWN_STONE_SLAB = registerStoneSlab("brown");
    public static final Block CYAN_STONE_SLAB = registerStoneSlab("cyan");
    public static final Block GREEN_STONE_SLAB = registerStoneSlab("green");
    public static final Block LIGHT_BLUE_STONE_SLAB = registerStoneSlab("light_blue");
    public static final Block LIGHT_BLUE1_STONE_SLAB = registerStoneSlab("light_blue1");
    public static final Block LIGHT_GRAY_STONE_SLAB = registerStoneSlab("light_gray");
    public static final Block LIME_STONE_SLAB = registerStoneSlab("lime");
    public static final Block MAGENTA_STONE_SLAB = registerStoneSlab("magenta");
    public static final Block ORANGE_STONE_SLAB = registerStoneSlab("orange");
    public static final Block PINK_STONE_SLAB = registerStoneSlab("pink");
    public static final Block PURPLE_STONE_SLAB = registerStoneSlab("purple");
    public static final Block RED_STONE_SLAB = registerStoneSlab("red");
    public static final Block WHITE_STONE_SLAB = registerStoneSlab("white");
    public static final Block YELLOW_STONE_SLAB = registerStoneSlab("yellow");
    public static final Block GRITK_BLOCK = registerBlockItem("gritk_block", new LBlock(Block.Properties.create(Material.IRON).setRequiresTool().harvestLevel(0).setLightLevel(Value -> 15).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500000.0F, 1200000.0F)));
    public static final Block GURK_BLOCK = registerBlockItem("gurk_block", new Block(Block.Properties.create(Material.WATER).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(20.0f)));
    public static final Block GURK_SLAB = registerBlockItem("gurk_slab", new SlabBlock(Block.Properties.create(Material.WATER).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(20.0f, 22.0f)));
    public static final Block GURK_STAIRS = registerBlockItem("gurk_stairs", createStairsBlockFrom(GURK_BLOCK));
    public static final Block BLACK_SMOOTH_STONE = registerSmoothStone("black");
    public static final Block BLUE_SMOOTH_STONE = registerSmoothStone("blue");
    public static final Block BROWN_SMOOTH_STONE = registerSmoothStone("brown");
    public static final Block CYAN_SMOOTH_STONE = registerSmoothStone("cyan");
    public static final Block GREEN_SMOOTH_STONE = registerSmoothStone("green");
    public static final Block LIGHT_BLUE_SMOOTH_STONE = registerSmoothStone("light_blue");
    public static final Block LIGHT_BLUE1_SMOOTH_STONE = registerSmoothStone("light_blue1");
    public static final Block LIGHT_GRAY_SMOOTH_STONE = registerSmoothStone("light_gray");
    public static final Block LIME_SMOOTH_STONE = registerSmoothStone("lime");
    public static final Block MAGENTA_SMOOTH_STONE = registerSmoothStone("magenta");
    public static final Block ORANGE_SMOOTH_STONE = registerSmoothStone("orange");
    public static final Block PINK_SMOOTH_STONE = registerSmoothStone("pink");
    public static final Block PURPLE_SMOOTH_STONE = registerSmoothStone("purple");
    public static final Block RED_SMOOTH_STONE = registerSmoothStone("red");
    public static final Block WHITE_SMOOTH_STONE = registerSmoothStone("white");
    public static final Block YELLOW_SMOOTH_STONE = registerSmoothStone("yellow");
    public static final Block ENDER_SRACKHT_1 = registerBlockItem("ender_srackht_1", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(20.0F)));
    public static final Block ENDER_SRAKTCAF_1 = registerBlockItem("ender_sraktcaf_1", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(3).harvestTool(ToolType.SHOVEL).hardnessAndResistance(60.0F)));
    public static final Block ENDER_STAKRACH_1 = registerBlockItem("ender_stakrach_1", new Block(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(2).harvestTool(ToolType.AXE).hardnessAndResistance(40.0F)));
    public static final Block BLACK_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/black_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block BLUE_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/blue_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block BROWN_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/brown_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block CYAN_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/cyan_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block GREEN_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/green_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block LIGHT_BLUE_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/light_blue_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block LIGHT_BLUE1_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/light_blue1_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block LIGHT_GRAY_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/light_gray_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block LIME_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/lime_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block MAGENTA_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/magenta_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block ORANGE_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/orange_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block PINK_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/pink_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block PURPLE_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/purple_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block RED_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/red_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block WHITE_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/white_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block YELLOW_SMOOTH_STONE_SLAB = registerBlockItem("stone/smooth_stone/slabs/yellow_smooth_stone_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final Block ZURK_BLOCK = registerBlockItem("zurk_block", new Block(Block.Properties.create(Material.AIR).setRequiresTool().harvestLevel(2).harvestTool(ToolType.SHOVEL).hardnessAndResistance(200.0F)));
    public static final Block ZURK_STAIRS = registerBlockItem("zurk_stairs", createStairsBlockFrom(ZURK_BLOCK.getBlock()));
    public static final Block BLACK_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/black_cobblestone_stairs", createStairsBlockFrom(BLACK_COBBLESTONE.getBlock()));
    public static final Block BLACK_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/black_smooth_stone_stairs", createStairsBlockFrom(BLACK_SMOOTH_STONE.getBlock()));
    public static final Block BLACK_STONE_STAIRS = registerBlockItem("stone/stairs/black_stone_stairs", createStairsBlockFrom(BLACK_STONE.getBlock()));
    public static final Block BLUE_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/blue_cobblestone_stairs", createStairsBlockFrom(BLUE_COBBLESTONE.getBlock()));
    public static final Block BLUE_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/blue_smooth_stone_stairs", createStairsBlockFrom(BLUE_SMOOTH_STONE.getBlock()));
    public static final Block BLUE_STONE_STAIRS = registerBlockItem("stone/stairs/blue_stone_stairs", createStairsBlockFrom(BLUE_STONE.getBlock()));
    public static final Block BROWN_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/brown_cobblestone_stairs", createStairsBlockFrom(BROWN_COBBLESTONE.getBlock()));
    public static final Block BROWN_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/brown_smooth_stone_stairs", createStairsBlockFrom(BROWN_SMOOTH_STONE.getBlock()));
    public static final Block BROWN_STONE_STAIRS = registerBlockItem("stone/stairs/brown_stone_stairs", createStairsBlockFrom(BROWN_STONE.getBlock()));
    public static final Block CYAN_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/cyan_cobblestone_stairs", createStairsBlockFrom(CYAN_COBBLESTONE.getBlock()));
    public static final Block CYAN_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/cyan_smooth_stone_stairs", createStairsBlockFrom(CYAN_SMOOTH_STONE.getBlock()));
    public static final Block CYAN_STONE_STAIRS = registerBlockItem("stone/stairs/cyan_stone_stairs", createStairsBlockFrom(CYAN_STONE.getBlock()));
    public static final Block GREEN_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/green_cobblestone_stairs", createStairsBlockFrom(GREEN_COBBLESTONE.getBlock()));
    public static final Block GREEN_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/green_smooth_stone_stairs", createStairsBlockFrom(GREEN_SMOOTH_STONE.getBlock()));
    public static final Block GREEN_STONE_STAIRS = registerBlockItem("stone/stairs/green_stone_stairs", createStairsBlockFrom(GREEN_STONE.getBlock()));
    public static final Block LIGHT_BLUE_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/light_blue_cobblestone_stairs", createStairsBlockFrom(LIGHT_BLUE_COBBLESTONE.getBlock()));
    public static final Block LIGHT_BLUE_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/light_blue_smooth_stone_stairs", createStairsBlockFrom(LIGHT_BLUE_SMOOTH_STONE.getBlock()));
    public static final Block LIGHT_BLUE_STONE_STAIRS = registerBlockItem("stone/stairs/light_blue_stone_stairs", createStairsBlockFrom(LIGHT_BLUE_STONE.getBlock()));
    public static final Block LIGHT_BLUE1_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/light_blue1_cobblestone_stairs", createStairsBlockFrom(LIGHT_BLUE1_COBBLESTONE.getBlock()));
    public static final Block LIGHT_BLUE1_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/light_blue1_smooth_stone_stairs", createStairsBlockFrom(LIGHT_BLUE1_SMOOTH_STONE.getBlock()));
    public static final Block LIGHT_BLUE1_STONE_STAIRS = registerBlockItem("stone/stairs/light_blue1_stone_stairs", createStairsBlockFrom(LIGHT_BLUE1_STONE.getBlock()));
    public static final Block LIGHT_GRAY_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/light_gray_cobblestone_stairs", createStairsBlockFrom(LIGHT_GRAY_COBBLESTONE.getBlock()));
    public static final Block LIGHT_GRAY_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/light_gray_smooth_stone_stairs", createStairsBlockFrom(LIGHT_GRAY_SMOOTH_STONE.getBlock()));
    public static final Block LIGHT_GRAY_STONE_STAIRS = registerBlockItem("stone/stairs/light_gray_stone_stairs", createStairsBlockFrom(LIGHT_GRAY_STONE.getBlock()));
    public static final Block LIME_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/lime_cobblestone_stairs", createStairsBlockFrom(LIME_COBBLESTONE.getBlock()));
    public static final Block LIME_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/lime_smooth_stone_stairs", createStairsBlockFrom(LIME_SMOOTH_STONE.getBlock()));
    public static final Block LIME_STONE_STAIRS = registerBlockItem("stone/stairs/lime_stone_stairs", createStairsBlockFrom(LIME_STONE.getBlock()));
    public static final Block MAGENTA_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/magenta_cobblestone_stairs", createStairsBlockFrom(MAGENTA_COBBLESTONE.getBlock()));
    public static final Block MAGENTA_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/magenta_smooth_stone_stairs", createStairsBlockFrom(MAGENTA_SMOOTH_STONE.getBlock()));
    public static final Block MAGENTA_STONE_STAIRS = registerBlockItem("stone/stairs/magenta_stone_stairs", createStairsBlockFrom(MAGENTA_STONE.getBlock()));
    public static final Block ORANGE_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/orange_cobblestone_stairs", createStairsBlockFrom(ORANGE_COBBLESTONE.getBlock()));
    public static final Block ORANGE_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/orange_smooth_stone_stairs", createStairsBlockFrom(ORANGE_SMOOTH_STONE.getBlock()));
    public static final Block ORANGE_STONE_STAIRS = registerBlockItem("stone/stairs/orange_stone_stairs", createStairsBlockFrom(ORANGE_STONE.getBlock()));
    public static final Block PINK_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/pink_cobblestone_stairs", createStairsBlockFrom(PINK_COBBLESTONE.getBlock()));
    public static final Block PINK_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/pink_smooth_stone_stairs", createStairsBlockFrom(PINK_SMOOTH_STONE.getBlock()));
    public static final Block PINK_STONE_STAIRS = registerBlockItem("stone/stairs/pink_stone_stairs", createStairsBlockFrom(PINK_STONE.getBlock()));
    public static final Block PURPLE_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/purple_cobblestone_stairs", createStairsBlockFrom(PURPLE_COBBLESTONE.getBlock()));
    public static final Block PURPLE_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/purple_smooth_stone_stairs", createStairsBlockFrom(PURPLE_SMOOTH_STONE.getBlock()));
    public static final Block PURPLE_STONE_STAIRS = registerBlockItem("stone/stairs/purple_stone_stairs", createStairsBlockFrom(PURPLE_STONE.getBlock()));
    public static final Block RED_COBBLESTONE_STAIRS;
    public static final Block RED_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/red_smooth_stone_stairs", createStairsBlockFrom(RED_SMOOTH_STONE.getBlock()));
    public static final Block RED_STONE_STAIRS = registerBlockItem("stone/stairs/red_stone_stairs", createStairsBlockFrom(RED_STONE.getBlock()));
    public static final Block WHITE_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/white_cobblestone_stairs", createStairsBlockFrom(WHITE_COBBLESTONE.getBlock()));
    public static final Block WHITE_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/white_smooth_stone_stairs", createStairsBlockFrom(WHITE_SMOOTH_STONE.getBlock()));
    public static final Block WHITE_STONE_STAIRS = registerBlockItem("stone/stairs/white_stone_stairs", createStairsBlockFrom(WHITE_STONE.getBlock()));
    public static final Block YELLOW_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/yellow_cobblestone_stairs", createStairsBlockFrom(YELLOW_COBBLESTONE.getBlock()));
    public static final Block YELLOW_SMOOTH_STONE_STAIRS = registerBlockItem("stone/smooth_stone/stairs/yellow_smooth_stone_stairs", createStairsBlockFrom(YELLOW_SMOOTH_STONE.getBlock()));
    public static final Block YELLOW_STONE_STAIRS = registerBlockItem("stone/stairs/yellow_stone_stairs", createStairsBlockFrom(YELLOW_STONE.getBlock()));
    public static final Block FREIN_BLOCK = registerBlockItem("frein_block", new FreinBlock(Block.Properties.create(Material.CLAY).slipperiness(0.8F).sound(SoundType.SLIME).zeroHardnessAndResistance().notSolid().jumpFactor(6)));
    public static final Block GANK_BLOCK = registerBlockItem("gank_block", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(990.0F)));
    public static final Block GANK_STAIRS = registerBlockItem("gank_stairs", createStairsBlockFrom(GANK_BLOCK.getBlock()));
    public static final Block FIRG_LOG = registerBlockItem("firg_log", createLogBlock(MaterialColor.SAND, MaterialColor.WOOD, Material.ORGANIC, ToolType.AXE, 2.0F, SoundType.WOOD));
    public static final Block FIRG_PRESSURE_PLATE = registerBlockItem("firg_pressure_plate", createPressurePlateBlock(BlockInit.FIRG_PLANKS));
    public static final Block FIRG_PLANKS_SLAB = registerBlockItem("firg_planks_slab", new SlabBlock(Block.Properties.create(Material.ORGANIC).harvestTool(ToolType.AXE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block FRIM_PLANKS_SLAB = registerBlockItem("frim_planks_slab", new SlabBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final Block FRIM_PLANKS = registerBlockItem("frim_planks", new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final Block FRIM_STAIRS = registerBlockItem("frim_planks_stairs", new StairsBlock(FRIM_PLANKS.getBlock()::getDefaultState, Block.Properties.from(FRIM_PLANKS.getBlock())));
    public static final Block FRIM_PLANKS_DOOR = registerBlockItem("frim_planks_door", new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).variableOpacity().notSolid()));
    public static final Block STRIPPED_FIRG_LOG = registerBlockItem("stripped_firg_log", createLogBlock(MaterialColor.SAND, MaterialColor.WOOD, Material.ORGANIC, ToolType.AXE, 2.0F, SoundType.WOOD));
    public static final Block STRIPPED_FRIM_LOG = registerBlockItem("stripped_frim_log", createLogBlock(MaterialColor.RED, MaterialColor.RED_TERRACOTTA, Material.ORGANIC, ToolType.AXE, 2.0F, SoundType.WOOD));
    public static final Block FIRG_WOOD = registerBlockItem("firg_wood", new RotatedPillarBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final Block FRIM_WOOD = registerBlockItem("frim_wood", new RotatedPillarBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.ADOBE).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final Block STRIPPED_FIRG_WOOD = registerBlockItem("stripped_firg_wood", new ColoredRotatedPillarBlock(MaterialColor.WOOD, Block.Properties.create(Material.ORGANIC).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final Block STRIPPED_FRIM_WOOD = registerBlockItem("stripped_frim_wood", new ColoredRotatedPillarBlock(MaterialColor.WOOD, Block.Properties.create(Material.ORGANIC).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final Block GANK_SLAB = registerBlockItem("gank_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(990.0F, 1000.0F)));
    public static final Block ENDER_TRASK_1 = registerBlockItem("ender_trask_1", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(6).hardnessAndResistance(160.0f)));
    public static final Block ENDER_TRASKCRAFTH_1 = registerBlockItem("ender_traskcrafth_1", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(5).hardnessAndResistance(100.0f)));
    public static final Block DURT = registerBlockItem("durt/durt", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(30.0f, 440.0f)));
    public static final Block DURT_GURBF = registerBlockItem("durt/gurbf", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(22.0f, 400.0f)));
    public static final Block GRITK_BLOCK_1 = registerBlockItem("gritk_block_1", new Block(Block.Properties.create(Material.IRON).setRequiresTool().harvestLevel(0).setLightLevel(Value -> 15).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500000.0F, 1200000.0F)));
    public static final Block FRIM_LOG = registerBlockItem("frim_log", createLogBlock(MaterialColor.WOOD, MaterialColor.RED, UnusedBlocks.requiresToolProperties(Material.ORGANIC, 0, 2.0F, ToolType.AXE, SoundType.WOOD)));
    public static final Block FRIM_SAPLING = registerBlockItem("frim_sapling", new ModSaplingBlock(FrimTree::new, AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
    public static final Block LEAVES = registerBlockItem("leaves", new Leaves(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final Block FRIM_LEAVES = registerBlockItem("frim_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final Block ZURK_SLAB = registerBlockItem("zurk_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(200.0F, 210.0F)));
    public static final Block ENDER_TRASKRACH_1 = registerBlockItem("ender_traskrach_1", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(4).hardnessAndResistance(80.0f)));
    public static final Block GRINTH_MUSHROOM = registerBlockItem("grinth_mushroom", new GrinthMushroom(Block.Properties.create(Material.PLANTS).zeroHardnessAndResistance().doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).setLightLevel(Value -> 1)));
    public static final Block RED_GRASS_BLOCK = registerBlockItem("red_grass_block", new GrassBlock(Block.Properties.create(Material.EARTH).tickRandomly().hardnessAndResistance(0.6F).sound(SoundType.PLANT)));
    public static final Block GRINTH_MUSHROOM_BLOCK = registerBlockItem("grinth_mushroom_block", new HugeMushroomBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN).setRequiresTool().hardnessAndResistance(0.2F).sound(SoundType.WOOD)));
    public static final Block BLACK_IRON_BLOCK = registerBlockItem("iron_block/black_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block BLUE_IRON_BLOCK = registerBlockItem("iron_block/blue_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block BROWN_IRON_BLOCK = registerBlockItem("iron_block/brown_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block CYAN_IRON_BLOCK = registerBlockItem("iron_block/cyan_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block GRAY_IRON_BLOCK = registerBlockItem("iron_block/gray_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block GREEN_IRON_BLOCK = registerBlockItem("iron_block/green_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_BLUE_IRON_BLOCK = registerBlockItem("iron_block/light_blue_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_BLUE1_IRON_BLOCK = registerBlockItem("iron_block/light_blue1_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_GRAY_IRON_BLOCK = registerBlockItem("iron_block/light_gray_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block LIME_IRON_BLOCK = registerBlockItem("iron_block/lime_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block MAGENTA_IRON_BLOCK = registerBlockItem("iron_block/magenta_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block ORANGE_IRON_BLOCK = registerBlockItem("iron_block/orange_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block PINK_IRON_BLOCK = registerBlockItem("iron_block/pink_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block PURPLE_IRON_BLOCK = registerBlockItem("iron_block/purple_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block RED_IRON_BLOCK = registerBlockItem("iron_block/red_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block YELLOW_IRON_BLOCK = registerBlockItem("iron_block/yellow_iron_block", new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block STONE_BLACK_IRON_ORE = registerIronOre("", "black");
    public static final Block BLACK_STONE_BLACK_IRON_ORE = registerIronOre("black", "black");
    public static final Block BLACK_STONE_BLUE_IRON_ORE = registerIronOre("black", "blue");
    public static final Block BLACK_STONE_BROWN_IRON_ORE = registerIronOre("black", "brown");
    public static final Block BLACK_STONE_CYAN_IRON_ORE = registerIronOre("black", "cyan");
    public static final Block BLACK_STONE_GRAY_IRON_ORE = registerIronOre("black", "gray");
    public static final Block BLACK_STONE_GREEN_IRON_ORE = registerIronOre("black", "green");
    public static final Block BLACK_STONE_LIGHT_BLUE1_IRON_ORE = registerIronOre("black", "light_blue1");
    public static final Block BLACK_STONE_LIGHT_BLUE_IRON_ORE = registerIronOre("black", "light_blue");
    public static final Block BLACK_STONE_LIGHT_GRAY_IRON_ORE = registerIronOre("black", "light_gray");
    public static final Block BLACK_STONE_LIME_IRON_ORE = registerIronOre("black", "lime");
    public static final Block BLACK_STONE_MAGENTA_IRON_ORE = registerIronOre("black", "magenta");
    public static final Block BLACK_STONE_ORANGE_IRON_ORE = registerIronOre("black", "orange");
    public static final Block BLACK_STONE_PINK_IRON_ORE = registerIronOre("black", "pink");
    public static final Block BLACK_STONE_PURPLE_IRON_ORE = registerIronOre("black", "purple");
    public static final Block BLACK_STONE_RED_IRON_ORE = registerIronOre("black", "red");
    public static final Block BLACK_STONE_YELLOW_IRON_ORE = registerIronOre("black", "yellow");
    public static final Block BLUE_STONE_BLUE_IRON_ORE = registerIronOre("blue", "blue");
    public static final Block BLUE_STONE_BLACK_IRON_ORE = registerIronOre("blue", "black");
    public static final Block BROWN_STONE_BLACK_IRON_ORE = registerIronOre("brown", "black");
    public static final Block CYAN_STONE_BLACK_IRON_ORE = registerIronOre("cyan", "black");
    public static final Block GREEN_STONE_BLACK_IRON_ORE = registerIronOre("green", "black");
    public static final Block LIGHT_BLUE_STONE_BLACK_IRON_ORE = registerIronOre("light_blue", "black");
    public static final Block LIGHT_BLUE1_STONE_BLACK_IRON_ORE = registerIronOre("light_blue1", "black");
    public static final Block LIGHT_GRAY_STONE_BLACK_IRON_ORE = registerIronOre("light_gray", "black");
    public static final Block LIME_STONE_BLACK_IRON_ORE = registerIronOre("lime", "black");
    public static final Block MAGENTA_STONE_BLACK_IRON_ORE = registerIronOre("magenta", "black");
    public static final Block ORANGE_STONE_BLACK_IRON_ORE = registerIronOre("orange", "black");
    public static final Block PINK_STONE_BLACK_IRON_ORE = registerIronOre("pink", "black");
    public static final Block PURPLE_STONE_BLACK_IRON_ORE = registerIronOre("purple", "black");
    public static final Block RED_STONE_BLACK_IRON_ORE = registerIronOre("red", "black");
    public static final Block WHITE_STONE_BLACK_IRON_ORE = registerIronOre("white", "black");
    public static final Block YELLOW_STONE_BLACK_IRON_ORE = registerIronOre("yellow", "black");
    public static final Block BLACK_STONE_IRON_ORE = registerIronOre("black", "");
    public static final Block BLUE_STONE_IRON_ORE = registerIronOre("blue", "");
    public static final Block BROWN_STONE_IRON_ORE = registerIronOre("brown", "");
    public static final Block CYAN_STONE_IRON_ORE = registerIronOre("cyan", "");
    public static final Block GREEN_STONE_IRON_ORE = registerIronOre("green", "");
    public static final Block LIGHT_BLUE_STONE_IRON_ORE = registerIronOre("light_blue", "");
    public static final Block LIGHT_BLUE1_STONE_IRON_ORE = registerIronOre("light_blue1", "");
    public static final Block LIGHT_GRAY_STONE_IRON_ORE = registerIronOre("light_gray", "");
    public static final Block LIME_STONE_IRON_ORE = registerIronOre("lime", "");
    public static final Block MAGENTA_STONE_IRON_ORE = registerIronOre("magenta", "");
    public static final Block ORANGE_STONE_IRON_ORE = registerIronOre("orange", "");
    public static final Block PINK_STONE_IRON_ORE = registerIronOre("pink", "");
    public static final Block PURPLE_STONE_IRON_ORE = registerIronOre("purple", "");
    public static final Block RED_STONE_IRON_ORE = registerIronOre("red", "");
    public static final Block WHITE_STONE_IRON_ORE = registerIronOre("white", "");
    public static final Block YELLOW_STONE_IRON_ORE = registerIronOre("yellow", "");
    public static final Block ACACIA_PLANKS1 = registerBlockItem("acacia_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block BIRCH_PLANKS1 = registerBlockItem("birch_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block DARK_OAK_PLANKS1 = registerBlockItem("dark_oak_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block JUNGLE_PLANKS1 = registerBlockItem("jungle_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block OAK_PLANKS1 = registerBlockItem("oak_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block SPRUCE_PLANKS1 = registerBlockItem("spruce_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block FIRG_PLANKS1 = registerBlockItem("firg_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block FRIM_PLANKS1 = registerBlockItem("frim_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block RUBY_ORE = registerBlockItem("ruby_ore", new ModOreBlock(3, 7, AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block BLACK_STONE_BRICKS = registerStoneBricks("black");
    public static final Block BLUE_STONE_BRICKS = registerStoneBricks("blue");
    public static final Block BROWN_STONE_BRICKS = registerStoneBricks("brown");
    public static final Block CYAN_STONE_BRICKS = registerStoneBricks("cyan");
    public static final Block GREEN_STONE_BRICKS = registerStoneBricks("green");
    public static final Block LIGHT_BLUE1_STONE_BRICKS = registerStoneBricks("light_blue1");
    public static final Block LIGHT_BLUE_STONE_BRICKS = registerStoneBricks("light_blue");
    public static final Block LIGHT_GRAY_STONE_BRICKS = registerStoneBricks("light_gray");
    public static final Block LIME_STONE_BRICKS = registerStoneBricks("lime");
    public static final Block MAGENTA_STONE_BRICKS = registerStoneBricks("magenta");
    public static final Block ORANGE_STONE_BRICKS = registerStoneBricks("orange");
    public static final Block PINK_STONE_BRICKS = registerStoneBricks("pink");
    public static final Block PURPLE_STONE_BRICKS = registerStoneBricks("purple");
    public static final Block RED_STONE_BRICKS = registerStoneBricks("red");
    public static final Block WHITE_STONE_BRICKS = registerStoneBricks("white");
    public static final Block YELLOW_STONE_BRICKS = registerStoneBricks("yellow");
    public static final Block BLACK_FURNACE = registerBlockItem("furnaces/black_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block BLUE_FURNACE = registerBlockItem("furnaces/blue_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block BROWN_FURNACE = registerBlockItem("furnaces/brown_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block CYAN_FURNACE = registerBlockItem("furnaces/cyan_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block GREEN_FURNACE = registerBlockItem("furnaces/green_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block LIGHT_BLUE_FURNACE = registerBlockItem("furnaces/light_blue_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block LIGHT_BLUE1_FURNACE = registerBlockItem("furnaces/light_blue1_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block LIGHT_GRAY_FURNACE = registerBlockItem("furnaces/light_gray_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block LIME_FURNACE = registerBlockItem("furnaces/lime_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block MAGENTA_FURNACE = registerBlockItem("furnaces/magenta_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block ORANGE_FURNACE = registerBlockItem("furnaces/orange_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block PINK_FURNACE = registerBlockItem("furnaces/pink_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block PURPLE_FURNACE = registerBlockItem("furnaces/purple_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block RED_FURNACE = registerBlockItem("furnaces/red_furnace", new FurnaceBlock(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block WHITE_FURNACE = registerBlockItem("furnaces/white_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block YELLOW_FURNACE = registerBlockItem("furnaces/yellow_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block TRUMRUNT = registerBlockItem("trumrunt", new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.LIGHT_BLUE).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F).setLightLevel(Value -> 15)));

    public static Block create(AbstractBlock.Properties properties) {
        return new Block(properties);
    }

    public static SlabBlock createSlabBlock(Material material, int harvestLevel, float hardnessAndResistance, ToolType toolType) {
        return new SlabBlock(UnusedBlocks.requiresToolProperties(material, harvestLevel, hardnessAndResistance, toolType));
    }

    public static SlabBlock createSlabBlock(Material material, int harvestLevel, float hardnessIn, float resistanceIn, ToolType toolType) {
        return new SlabBlock(UnusedBlocks.requiresToolProperties(material, harvestLevel, hardnessIn, resistanceIn, toolType));
    }

    public static StairsBlock createStairsBlockFrom(Block fromBlock) {
        return new StairsBlock(fromBlock::getDefaultState, Block.Properties.from(fromBlock));
    }

    public static PressurePlateBlock createPressurePlateBlock(Block fromColor) {
        return createPressurePlateBlock(fromColor, 0.5F);
    }

    public static PressurePlateBlock createPressurePlateBlock(Block fromColor, float hardnessAndResistance) {
        return createPressurePlateBlock(fromColor, hardnessAndResistance, hardnessAndResistance);
    }

    public static PressurePlateBlock createPressurePlateBlock(Block fromColor, float hardness, float resistance) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.create(Material.WOOD, fromColor.getMaterialColor()).doesNotBlockMovement().hardnessAndResistance(hardness, resistance).sound(SoundType.WOOD));
    }

    private static RotatedPillarBlock createLogBlock(Material material, MaterialColor topColor, MaterialColor barkColor, int hardnessAndResistance, SoundType soundType) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(material, (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).hardnessAndResistance(hardnessAndResistance).sound(soundType));
    }

    private static RotatedPillarBlock createLogBlock(Material material, MaterialColor topColor, MaterialColor barkColor, int hardnessAndResistance, SoundInit soundInit) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(material, (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).hardnessAndResistance(hardnessAndResistance).sound(soundInit));
    }

    public static ColoredRotatedPillarBlock createLogBlock(MaterialColor verticalColor, MaterialColor materialColor, Material material, ToolType toolType, float hardnessAndResistance, SoundType soundType) {
        return createLogBlock(verticalColor, materialColor, AbstractBlock.Properties.create(material).harvestTool(toolType).hardnessAndResistance(hardnessAndResistance).sound(soundType));
    }

    private static ColoredRotatedPillarBlock createLogBlock(MaterialColor verticalColor, MaterialColor materialColor, AbstractBlock.Properties properties) {
        return new ColoredRotatedPillarBlock(verticalColor, materialColor, properties);
    }

    private static AbstractBlock.Properties createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
        return AbstractBlock.Properties.create(Material.WOOD, (state) -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor);
    }

    private static AbstractBlock.Properties createLogBlock(Material material, MaterialColor topColor, MaterialColor barkColor, AbstractBlock.Properties properties) {
        return AbstractBlock.Properties.create(material, (state) -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor);
    }

    static class Axe_Item extends AxeItem {
        public Axe_Item(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }

        public static void block() {
            BLOCK_STRIPPING_MAP.put(BlockItemInit.FIRG_LOG.getBlock(), BlockItemInit.STRIPPED_FIRG_LOG.getBlock());
            BLOCK_STRIPPING_MAP.put(BlockItemInit.FIRG_WOOD.getBlock(), BlockItemInit.STRIPPED_FIRG_WOOD.getBlock());
            BLOCK_STRIPPING_MAP.put(BlockItemInit.FRIM_LOG.getBlock(), BlockItemInit.STRIPPED_FRIM_LOG.getBlock());
            BLOCK_STRIPPING_MAP.put(BlockItemInit.FRIM_WOOD.getBlock(), BlockItemInit.STRIPPED_FRIM_WOOD.getBlock());
        }
    }

    public static Block registerStoneBricks(String name) {
        return register("stone/bricks/" + name, createStoneBricks());
    }

    public static Block registerCobblestone(String name) {
        return registerStone("cobblestones", name, createCobblestone());
    }

    public static Block registerCobblestoneSlab(String name) {
        return registerStoneSlab("cobblestone", name, createCobblestoneSlab());
    }

    public static Block registerSmoothStone(String name) {
        return registerStone("smooth_stones", name, createSmoothStone());
    }

    public static Block registerStoneSlab(String name) {
        return registerStone("slabs", name, createStoneSlab());
    }

    public static Block registerStoneSlab(String type, String name, Block stone) {
        return registerStone(type + "/slabs", name, stone);
    }

    public static Block registerStone(String name) {
        return registerStone("stones", name, createStone());
    }

    public static Block registerStone(String type, String name, Block stone) {
        return registerBlockItem("stone/" + type + "/" + name, stone);
    }

    public static Block registerNumBlockItem(String name) {
        return registerBlockItem(name, createNumBlock());
    }

    public static Block registerIronOre(String stone, String ironOre) {
        stone = stone.isEmpty() ? "stone/" : stone + "_stone/";
        ironOre = ironOre.isEmpty() ? "iron_ore/" : ironOre + "_iron_ore/";
        return registerBlockItem("iron_ores/" + stone + ironOre, createIronOre());
    }

    public static Block createStoneBricks() {
        return createStone();
    }

    public static Block createSmoothStone() {
        return createCobblestone();
    }

    public static Block createStone() {
        return UnusedBlocks.setBlockRequiresTool(Material.ROCK, 0, 1.5F, 6.0F, ToolType.PICKAXE);
    }

    public static Block createCobblestoneSlab() {
        return createCobblestone();
    }

    public static Block createStoneSlab() {
        return createCobblestone();
    }

    public static Block createCobblestone() {
        return UnusedBlocks.setBlockRequiresTool(Material.ROCK, 0, 2.0F, 6.0F, ToolType.PICKAXE);
    }

    public static Block createNumBlock() {
        return new LBlock(Block.Properties.create(Material.ORGANIC).setRequiresTool().hardnessAndResistance(1000000000).setLightLevel(Value -> 15));
    }

    public static Block createIronOre() {
        return create(createIronOreProperties());
    }

    public static AbstractBlock.Properties createIronOreProperties() {
        return AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL);
    }

    public static AbstractBlock.Properties createProperties(Material material) {
        return AbstractBlock.Properties.create(material);
    }

    public static AbstractBlock.Properties createProperties(Material material, DyeColor color) {
        return AbstractBlock.Properties.create(material, color);
    }

    public static AbstractBlock.Properties createProperties(Material material, Function<BlockState, MaterialColor> stateColorFunction) {
        return AbstractBlock.Properties.create(material, stateColorFunction);
    }

    public static AbstractBlock.Properties createProperties(Material material, MaterialColor mapColorIn) {
        return AbstractBlock.Properties.create(material, mapColorIn);
    }

    public static AbstractBlock.Properties fromProperties(AbstractBlock blockIn) {
        return AbstractBlock.Properties.from(blockIn);
    }

    public static ColoredRotatedPillarBlock createLogBlockFrom(MaterialColor verticalColor, MaterialColor materialColor, Block blockIn) {
        return new ColoredRotatedPillarBlock(verticalColor, materialColor, fromProperties(blockIn));
    }

    public static AbstractBlock.Properties createProperties(Material material, float hardnessIn, float resistanceIn) {
        return createProperties(material).hardnessAndResistance(hardnessIn, resistanceIn);
    }

    public static AbstractBlock.Properties createProperties(Material material, DyeColor color, float hardnessIn, float resistanceIn) {
        return createProperties(material, color).hardnessAndResistance(hardnessIn, resistanceIn);
    }

    public static AbstractBlock.Properties createProperties(Material material, Function<BlockState, MaterialColor> stateColorFunction, float hardnessIn, float resistanceIn) {
        return createProperties(material, stateColorFunction).hardnessAndResistance(hardnessIn, resistanceIn);
    }

    public static AbstractBlock.Properties createProperties(Material material, MaterialColor mapColorIn, float hardnessIn, float resistanceIn) {
        return createProperties(material, mapColorIn).hardnessAndResistance(hardnessIn, resistanceIn);
    }

    public static AbstractBlock.Properties fromProperties(AbstractBlock blockIn, float hardnessIn, float resistanceIn) {
        return fromProperties(blockIn).hardnessAndResistance(hardnessIn, resistanceIn);
    }

    public static AbstractBlock.Properties createProperties(Material material, float hardnessAndResistanceIn) {
        return createProperties(material).hardnessAndResistance(hardnessAndResistanceIn);
    }

    public static AbstractBlock.Properties createProperties(Material material, DyeColor color, float hardnessAndResistanceIn) {
        return createProperties(material, color).hardnessAndResistance(hardnessAndResistanceIn);
    }

    public static AbstractBlock.Properties createProperties(Material material, Function<BlockState, MaterialColor> stateColorFunction, float hardnessAndResistanceIn) {
        return createProperties(material, stateColorFunction).hardnessAndResistance(hardnessAndResistanceIn);
    }

    public static AbstractBlock.Properties createProperties(Material material, MaterialColor mapColorIn, float hardnessAndResistanceIn) {
        return createProperties(material, mapColorIn).hardnessAndResistance(hardnessAndResistanceIn);
    }

    public static AbstractBlock.Properties fromProperties(AbstractBlock blockIn, float hardnessAndResistanceIn) {
        return fromProperties(blockIn).hardnessAndResistance(hardnessAndResistanceIn);
    }

    public static Block create(Material material) {
        return create(createProperties(material));
    }

    public static Block create(Material material, DyeColor color) {
        return create(createProperties(material, color));
    }

    public static Block create(Material material, Function<BlockState, MaterialColor> stateColorFunction) {
        return create(createProperties(material, stateColorFunction));
    }

    public static Block create(Material material, MaterialColor mapColorIn) {
        return create(createProperties(material, mapColorIn));
    }

    public static Block create(AbstractBlock blockIn) {
        return create(fromProperties(blockIn));
    }

    public static Block create(Material material, float hardnessIn, float resistanceIn) {
        return create(createProperties(material, hardnessIn, resistanceIn));
    }

    public static Block create(Material material, DyeColor color, float hardnessIn, float resistanceIn) {
        return create(createProperties(material, color, hardnessIn, resistanceIn));
    }

    public static Block create(Material material, Function<BlockState, MaterialColor> stateColorFunction, float hardnessIn, float resistanceIn) {
        return create(createProperties(material, stateColorFunction, hardnessIn, resistanceIn));
    }

    public static Block create(Material material, MaterialColor mapColorIn, float hardnessIn, float resistanceIn) {
        return create(createProperties(material, mapColorIn, hardnessIn, resistanceIn));
    }

    public static Block create(AbstractBlock blockIn, float hardnessIn, float resistanceIn) {
        return create(fromProperties(blockIn, hardnessIn, resistanceIn));
    }

    public static Block create(Material material, int harvestLevel, ToolType harvestTool, float hardnessAndResistanceIn) {
        return create(createProperties(material, hardnessAndResistanceIn).harvestLevel(harvestLevel).harvestTool(harvestTool));
    }

    public static Block create(Material material, int harvestLevel, ToolType harvestTool, DyeColor color, float hardnessAndResistanceIn) {
        return create(createProperties(material, color, hardnessAndResistanceIn).harvestLevel(harvestLevel).harvestTool(harvestTool));
    }

    public static Block create(Material material, int harvestLevel, ToolType harvestTool, Function<BlockState, MaterialColor> stateColorFunction, float hardnessAndResistanceIn) {
        return create(createProperties(material, stateColorFunction, hardnessAndResistanceIn).harvestLevel(harvestLevel).harvestTool(harvestTool));
    }

    public static Block create(Material material, int harvestLevel, ToolType harvestTool, MaterialColor mapColorIn, float hardnessAndResistanceIn) {
        return create(createProperties(material, mapColorIn, hardnessAndResistanceIn).harvestLevel(harvestLevel).harvestTool(harvestTool));
    }

    public static Block create(AbstractBlock blockIn, int harvestLevel, ToolType harvestTool, float hardnessAndResistanceIn) {
        return create(fromProperties(blockIn, hardnessAndResistanceIn).harvestLevel(harvestLevel).harvestTool(harvestTool));
    }

    public static Block create(Material material, float hardnessIn, float resistanceIn, SoundType sound) {
        return create(createProperties(material, hardnessIn, resistanceIn).sound(sound));
    }

    public static Block create(Material material, DyeColor color, float hardnessIn, float resistanceIn, SoundType sound) {
        return create(createProperties(material, color, hardnessIn, resistanceIn).sound(sound));
    }

    public static Block create(Material material, Function<BlockState, MaterialColor> stateColorFunction, float hardnessIn, float resistanceIn, SoundType sound) {
        return create(createProperties(material, stateColorFunction, hardnessIn, resistanceIn).sound(sound));
    }

    public static Block create(Material material, MaterialColor mapColorIn, float hardnessIn, float resistanceIn, SoundType sound) {
        return create(createProperties(material, mapColorIn, hardnessIn, resistanceIn).sound(sound));
    }

    public static Block create(AbstractBlock blockIn, float hardnessIn, float resistanceIn, SoundType sound) {
        return create(fromProperties(blockIn, hardnessIn, resistanceIn).sound(sound));
    }

    public static Block create() {
        return create(Material.ORGANIC);
    }

    public static Block register(String name, Block blockIn) {
        return UnusedBlocks.registerDefault(name, blockIn);
    }

    public static Block registerBlockItem(String name, Block blockIn) {
        return UnusedBlocks.registerBlockItem(name, blockIn);
    }

    public static BlockItem registerBlockItem(String name, Block blockIn, Item.Properties properties) {
        return new Cast<BlockItem>().cast(UnusedBlockItems.registerDefault(name, blockIn, properties));
    }

    public static void register() {
        Ervin_mod_1.register(BlockItemInit.class);
    }

    static {
//        Axe_Item.block();
        EXAMPLE_BLOCK = registerBlockItem("example_block", create(Material.SAND, 0.5F, 15.0F, SoundType.SAND));
        DEFERRED_BLOCK = registerBlockItem("deferred_block", create(Material.AIR));
        JAZZ_LOG = registerBlockItem("jazz_log", createLogBlockFrom(MaterialColor.WOOD, MaterialColor.PINK, Blocks.OAK_LOG));
        JAZZ_LEAVES = registerBlockItem("jazz_leaves", new LeavesBlock(fromProperties(Blocks.OAK_LEAVES)));
        JAZZ_SAPLING = registerBlockItem("jazz_sapling", new ModSaplingBlock(JazzTree::new, fromProperties(OAK_SAPLING)));
        REGDEM_BLOCK = registerBlockItem("regdem_block", create(Material.WOOD, 0, ToolType.AXE, 10.0f));
        SRIUNK_ORE = registerBlockItem("sriunk_ore", new ModOreBlock(1, 5, UnusedBlocks.requiresToolProperties(Material.ROCK, 3, 100.0F, ToolType.PICKAXE)));
        RUBY_BLOCK = registerBlockItem("ruby_block", UnusedBlocks.setBlockRequiresTool(Material.IRON, 2, 8.0f, ToolType.PICKAXE));
        RUBY_SLAB = registerBlockItem("ruby_slab", createSlabBlock(Material.IRON, 3, 9.0F, ToolType.PICKAXE));
        RUBY_STAIRS = registerBlockItem("ruby_stairs", createStairsBlockFrom(RUBY_BLOCK));
        RED_COBBLESTONE = registerBlockItem("stone/cobblestones/red_cobblestone", UnusedBlocks.setBlockRequiresTool(Material.ROCK, 0, 2.0F, 6.0F, ToolType.PICKAXE));
        RED_COBBLESTONE_STAIRS = registerBlockItem("stone/cobblestone/stairs/red_cobblestone_stairs", createStairsBlockFrom(RED_COBBLESTONE));
    }
}
