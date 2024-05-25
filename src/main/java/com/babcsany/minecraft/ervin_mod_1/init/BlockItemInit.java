package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.slabs.RedstoneSlab;
import com.babcsany.minecraft.ervin_mod_1.block.ores.IronOre;
import com.babcsany.minecraft.ervin_mod_1.init.sound.SoundInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;

import static net.minecraft.block.Blocks.OAK_SAPLING;
import static net.minecraft.block.Blocks.OBSIDIAN;

public class BlockItemInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

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
    public static final Block RED_SMOOTH_STONE = registerSmoothStone("red");
    public static final Block AVTER_BLOCK = register("avter_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(5).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6000.0f)));
    public static final Block FRIT_BLOCK = register("frit_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0f)));
    public static final Block END_PORTAL = register("end_portal", new EndPortalBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(13).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0f)));
    public static final Block END_STONE_CISK = register("end_stone_cisk", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(30.0f)));
    public static final Block END_STONE_CRISK = register("end_stone_crisk", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(45.0f)));
    public static final Block END_SRACT = register("end_sract", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(8.0f)));
    public static final Block ENDER_SRACT = register("ender_sract", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(9.0f)));
    public static final Block ENDER_SACKT = register("ender_sackt", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0f)));
    public static final Block ENDER_SACT = register("ender_sact", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(12.0f)));
    public static final Block ENDER_SRACKH = register("ender_srackh", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(14.0f)));
    public static final Block ENDER_SRACK = register("ender_srack", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(16.0f)));
//    public static final Block END_SRACKT = register("end_srackt", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(16.0f)));
    public static final Block GRIRZT = register("grirzt", new Grirzt(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(17).harvestTool(ToolType.PICKAXE).hardnessAndResistance(160.0f)));
    public static final Block TRING = register("tring", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(60.0f)));
    public static final Block PACK_BLOCK = register("pack_block", new Block(Block.Properties.create(Material.EARTH).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(40.0f)));
    public static final Block KALT_BLOCK = register("kalt_block", new ModOreBlock(5, 12, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0f)));
    public static final Block URVI = register("urvi", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 9.0F)));
    public static final Block SURVI = register("survi", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 9.0F)));
    public static final Block SURV = register("surv", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(4.0F, 10.0F)));
    public static final Block SURT = register("surt", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5.0F, 12.0F)));
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
    public static final BlockItem ENDER_SRACKTH = registerBlockItem("ender_srackth", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(20.0f)));
    public static final Block OAK_TURG = register("oak_turg", new Block(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block FIRG_TURG = register("firg_turg", new Block(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block FRIM_TURG = register("frim_turg", new Block(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block ENDER_TRASK = register("ender_trask", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(6).hardnessAndResistance(160.0f)));
    public static final Block ACACIA_TURG = register("acacia_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block BIRCH_TURG = register("birch_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block DARK_OAK_TURG = register("dark_oak_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block JUNGLE_TURG = register("jungle_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block SPRUCE_TURG = register("spruce_turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block TURG = register("turg", new Block(Block.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(1).harvestTool(ToolType.AXE).hardnessAndResistance(20.0f).sound(SoundType.WOOD)));
    public static final Block L0 = registerNumBlock("0");
    public static final Block L1 = registerNumBlock("1");
    public static final Block L2 = registerNumBlock("2");
    public static final Block L3 = registerNumBlock("3");
    public static final Block L4 = registerNumBlock("4");
    public static final Block L5 = registerNumBlock("5");
    public static final Block L6 = registerNumBlock("6");
    public static final Block L7 = registerNumBlock("7");
    public static final Block L8 = registerNumBlock("8");
    public static final Block L9 = registerNumBlock("9");
    public static final Block TRINKS = register("trinks", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().doesNotBlockMovement().setLightLevel(Value -> 15)));
    public static final Block DIRT1 = register("dirt1", new AmbientOcclusionLightBlock(Block.Properties.create(Material.EARTH, MaterialColor.DIRT).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.GROUND), 1));
    public static final Block GNITH_BLOCK = register("gnith_block", new ModOreBlock(2, 9, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(200.0F, 5000.0F)));
    public static final Block DIAMOND_SLAB = register("diamond_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).sound(SoundType.METAL).setRequiresTool().harvestLevel(3).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final Block OBSIDIAN_SLAB = register("obsidian_slab", new SlabBlock(Block.Properties.from(OBSIDIAN)));
    public static final Block IRON_SLAB = register("iron_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).sound(SoundType.METAL).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final Block GOLD_SLAB = register("gold_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.GOLD).sound(SoundType.METAL).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(4.0F, 6.0F)));
    public static final Block REDSTONE_SLAB = register("redstone_slab", new RedstoneSlab(Block.Properties.create(Material.IRON, MaterialColor.TNT).sound(SoundType.METAL).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final Block DIRT_SLAB = register("dirt_slab", new SlabBlock(Block.Properties.create(Material.EARTH, MaterialColor.DIRT).sound(SoundType.GROUND).harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(1.0F)));
    public static final Block LAPIS_SLAB = register("lapis_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.LAPIS).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));
    public static final Block EMERALD_SLAB = register("emerald_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.EMERALD).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
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
    public static final Block GRITK_BLOCK = register("gritk_block", new LBlock(Block.Properties.create(Material.IRON).setRequiresTool().harvestLevel(0).setLightLevel(Value -> 15).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500000.0F, 1200000.0F)));
    public static final Block GURK_BLOCK = register("gurk_block", new Block(Block.Properties.create(Material.WATER).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(20.0f)));
    public static final Block GURK_SLAB = register("gurk_slab", new SlabBlock(Block.Properties.create(Material.WATER).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(20.0f, 22.0f)));
    public static final Block GURK_STAIRS = register("gurk_stairs", createStairsBlockFrom(GURK_BLOCK));
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
    public static final Block WHITE_SMOOTH_STONE = registerSmoothStone("white");
    public static final Block YELLOW_SMOOTH_STONE = registerSmoothStone("yellow");
    public static final RegistryObject<Block> ENDER_SRACKHT_1 = BLOCKS.register("ender_srackht_1", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(20.0F)));
    public static final RegistryObject<Block> ENDER_SRAKTCAF_1 = BLOCKS.register("ender_sraktcaf_1", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(3).harvestTool(ToolType.SHOVEL).hardnessAndResistance(60.0F)));
    public static final RegistryObject<Block> ENDER_STAKRACH_1 = BLOCKS.register("ender_stakrach_1", () -> new Block(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(2).harvestTool(ToolType.AXE).hardnessAndResistance(40.0F)));
    public static final RegistryObject<Block> BLACK_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/black_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> BLUE_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/blue_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> BROWN_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/brown_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> CYAN_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/cyan_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> GREEN_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/green_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> LIGHT_BLUE_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/light_blue_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> LIGHT_BLUE1_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/light_blue1_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> LIGHT_GRAY_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/light_gray_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> LIME_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/lime_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> MAGENTA_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/magenta_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> ORANGE_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/orange_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> PINK_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/pink_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> PURPLE_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/purple_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> RED_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/red_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> WHITE_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/white_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> YELLOW_SMOOTH_STONE_SLAB = BLOCKS.register("stone/smooth_stone/slabs/yellow_smooth_stone_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> ZURK_BLOCK = BLOCKS.register("zurk_block", () -> new Block(Block.Properties.create(Material.AIR).setRequiresTool().harvestLevel(2).harvestTool(ToolType.SHOVEL).hardnessAndResistance(200.0F)));
    public static final RegistryObject<Block> ZURK_STAIRS = BLOCKS.register("zurk_stairs", () -> createStairsBlockFrom(ZURK_BLOCK.get()));
    public static final RegistryObject<Block> BLACK_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/black_cobblestone_stairs", () -> createStairsBlockFrom(BLACK_COBBLESTONE));
    public static final RegistryObject<Block> BLACK_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/black_smooth_stone_stairs", () -> createStairsBlockFrom(BLACK_SMOOTH_STONE));
    public static final RegistryObject<Block> BLACK_STONE_STAIRS = BLOCKS.register("stone/stairs/black_stone_stairs", () -> createStairsBlockFrom(BLACK_STONE));
    public static final RegistryObject<Block> BLUE_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/blue_cobblestone_stairs", () -> createStairsBlockFrom(BLUE_COBBLESTONE));
    public static final RegistryObject<Block> BLUE_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/blue_smooth_stone_stairs", () -> createStairsBlockFrom(BLUE_SMOOTH_STONE));
    public static final RegistryObject<Block> BLUE_STONE_STAIRS = BLOCKS.register("stone/stairs/blue_stone_stairs", () -> createStairsBlockFrom(BLUE_STONE));
    public static final RegistryObject<Block> BROWN_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/brown_cobblestone_stairs", () -> createStairsBlockFrom(BROWN_COBBLESTONE));
    public static final RegistryObject<Block> BROWN_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/brown_smooth_stone_stairs", () -> createStairsBlockFrom(BROWN_SMOOTH_STONE));
    public static final RegistryObject<Block> BROWN_STONE_STAIRS = BLOCKS.register("stone/stairs/brown_stone_stairs", () -> createStairsBlockFrom(BROWN_STONE));
    public static final RegistryObject<Block> CYAN_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/cyan_cobblestone_stairs", () -> createStairsBlockFrom(CYAN_COBBLESTONE));
    public static final RegistryObject<Block> CYAN_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/cyan_smooth_stone_stairs", () -> createStairsBlockFrom(CYAN_SMOOTH_STONE));
    public static final RegistryObject<Block> CYAN_STONE_STAIRS = BLOCKS.register("stone/stairs/cyan_stone_stairs", () -> createStairsBlockFrom(CYAN_STONE));
    public static final RegistryObject<Block> GREEN_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/green_cobblestone_stairs", () -> createStairsBlockFrom(GREEN_COBBLESTONE));
    public static final RegistryObject<Block> GREEN_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/green_smooth_stone_stairs", () -> createStairsBlockFrom(GREEN_SMOOTH_STONE));
    public static final RegistryObject<Block> GREEN_STONE_STAIRS = BLOCKS.register("stone/stairs/green_stone_stairs", () -> createStairsBlockFrom(GREEN_STONE));
    public static final RegistryObject<Block> LIGHT_BLUE_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/light_blue_cobblestone_stairs", () -> createStairsBlockFrom(LIGHT_BLUE_COBBLESTONE));
    public static final RegistryObject<Block> LIGHT_BLUE_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/light_blue_smooth_stone_stairs", () -> createStairsBlockFrom(LIGHT_BLUE_SMOOTH_STONE));
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_STAIRS = BLOCKS.register("stone/stairs/light_blue_stone_stairs", () -> createStairsBlockFrom(LIGHT_BLUE_STONE));
    public static final RegistryObject<Block> LIGHT_BLUE1_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/light_blue1_cobblestone_stairs", () -> createStairsBlockFrom(LIGHT_BLUE1_COBBLESTONE));
    public static final RegistryObject<Block> LIGHT_BLUE1_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/light_blue1_smooth_stone_stairs", () -> createStairsBlockFrom(LIGHT_BLUE1_SMOOTH_STONE));
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_STAIRS = BLOCKS.register("stone/stairs/light_blue1_stone_stairs", () -> createStairsBlockFrom(LIGHT_BLUE1_STONE));
    public static final RegistryObject<Block> LIGHT_GRAY_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/light_gray_cobblestone_stairs", () -> createStairsBlockFrom(LIGHT_GRAY_COBBLESTONE));
    public static final RegistryObject<Block> LIGHT_GRAY_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/light_gray_smooth_stone_stairs", () -> createStairsBlockFrom(LIGHT_GRAY_SMOOTH_STONE));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_STAIRS = BLOCKS.register("stone/stairs/light_gray_stone_stairs", () -> createStairsBlockFrom(LIGHT_GRAY_STONE));
    public static final RegistryObject<Block> LIME_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/lime_cobblestone_stairs", () -> createStairsBlockFrom(LIME_COBBLESTONE));
    public static final RegistryObject<Block> LIME_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/lime_smooth_stone_stairs", () -> createStairsBlockFrom(LIME_SMOOTH_STONE));
    public static final RegistryObject<Block> LIME_STONE_STAIRS = BLOCKS.register("stone/stairs/lime_stone_stairs", () -> createStairsBlockFrom(LIME_STONE));
    public static final RegistryObject<Block> MAGENTA_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/magenta_cobblestone_stairs", () -> createStairsBlockFrom(MAGENTA_COBBLESTONE));
    public static final RegistryObject<Block> MAGENTA_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/magenta_smooth_stone_stairs", () -> createStairsBlockFrom(MAGENTA_SMOOTH_STONE));
    public static final RegistryObject<Block> MAGENTA_STONE_STAIRS = BLOCKS.register("stone/stairs/magenta_stone_stairs", () -> createStairsBlockFrom(MAGENTA_STONE));
    public static final RegistryObject<Block> ORANGE_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/orange_cobblestone_stairs", () -> createStairsBlockFrom(ORANGE_COBBLESTONE));
    public static final RegistryObject<Block> ORANGE_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/orange_smooth_stone_stairs", () -> createStairsBlockFrom(ORANGE_SMOOTH_STONE));
    public static final RegistryObject<Block> ORANGE_STONE_STAIRS = BLOCKS.register("stone/stairs/orange_stone_stairs", () -> createStairsBlockFrom(ORANGE_STONE));
    public static final RegistryObject<Block> PINK_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/pink_cobblestone_stairs", () -> createStairsBlockFrom(PINK_COBBLESTONE));
    public static final RegistryObject<Block> PINK_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/pink_smooth_stone_stairs", () -> createStairsBlockFrom(PINK_SMOOTH_STONE));
    public static final RegistryObject<Block> PINK_STONE_STAIRS = BLOCKS.register("stone/stairs/pink_stone_stairs", () -> createStairsBlockFrom(PINK_STONE));
    public static final RegistryObject<Block> PURPLE_COBBLESTONE_STAIRS = BLOCKS.register("stone/cobblestone/stairs/purple_cobblestone_stairs", () -> createStairsBlockFrom(PURPLE_COBBLESTONE));
    public static final RegistryObject<Block> PURPLE_SMOOTH_STONE_STAIRS = BLOCKS.register("stone/smooth_stone/stairs/purple_smooth_stone_stairs", () -> createStairsBlockFrom(PURPLE_SMOOTH_STONE));
    public static final RegistryObject<Block> PURPLE_STONE_STAIRS = BLOCKS.register("stone/stairs/purple_stone_stairs", () -> createStairsBlockFrom(PURPLE_STONE));
    public static final Block RED_COBBLESTONE_STAIRS;
    public static final Block RED_SMOOTH_STONE_STAIRS = register("stone/smooth_stone/stairs/red_smooth_stone_stairs", createStairsBlockFrom(RED_SMOOTH_STONE));
    public static final Block RED_STONE_STAIRS = register("stone/stairs/red_stone_stairs", createStairsBlockFrom(RED_STONE));
    public static final Block WHITE_COBBLESTONE_STAIRS = register("stone/cobblestone/stairs/white_cobblestone_stairs", createStairsBlockFrom(WHITE_COBBLESTONE));
    public static final Block WHITE_SMOOTH_STONE_STAIRS = register("stone/smooth_stone/stairs/white_smooth_stone_stairs", createStairsBlockFrom(WHITE_SMOOTH_STONE));
    public static final Block WHITE_STONE_STAIRS = register("stone/stairs/white_stone_stairs", createStairsBlockFrom(WHITE_STONE));
    public static final Block YELLOW_COBBLESTONE_STAIRS = register("stone/cobblestone/stairs/yellow_cobblestone_stairs", createStairsBlockFrom(YELLOW_COBBLESTONE));
    public static final Block YELLOW_SMOOTH_STONE_STAIRS = register("stone/smooth_stone/stairs/yellow_smooth_stone_stairs", createStairsBlockFrom(YELLOW_SMOOTH_STONE));
    public static final Block YELLOW_STONE_STAIRS = register("stone/stairs/yellow_stone_stairs", createStairsBlockFrom(YELLOW_STONE));
    public static final Block FREIN_BLOCK = register("frein_block", new FreinBlock(Block.Properties.create(Material.CLAY).slipperiness(0.8F).sound(SoundType.SLIME).zeroHardnessAndResistance().notSolid().jumpFactor(6)));
    public static final Block GANK_BLOCK = register("gank_block", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(990.0F)));
    public static final Block GANK_STAIRS = register("gank_stairs", createStairsBlockFrom(GANK_BLOCK));
    public static final Block FIRG_LOG = register("firg_log", createLogBlock(MaterialColor.SAND, MaterialColor.WOOD, Material.ORGANIC, ToolType.AXE, 2.0F, SoundType.WOOD));
    public static final Block FIRG_PRESSURE_PLATE = register("firg_pressure_plate", createPressurePlateBlock(BlockInit.FIRG_PLANKS));
    public static final Block FIRG_PLANKS_SLAB = register("firg_planks_slab", new SlabBlock(Block.Properties.create(Material.ORGANIC).harvestTool(ToolType.AXE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block FRIM_PLANKS_SLAB = register("frim_planks_slab", new SlabBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final Block FRIM_PLANKS = register("frim_planks", new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final Block FRIM_STAIRS = register("frim_planks_stairs", new StairsBlock(FRIM_PLANKS::getDefaultState, Block.Properties.from(FRIM_PLANKS)));
    public static final Block FRIM_PLANKS_DOOR = register("frim_planks_door", new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).variableOpacity().notSolid()));
    public static final Block STRIPPED_FIRG_LOG = register("stripped_firg_log", createLogBlock(MaterialColor.SAND, MaterialColor.WOOD, Material.ORGANIC, ToolType.AXE, 2.0F, SoundType.WOOD));
    public static final Block STRIPPED_FRIM_LOG = register("stripped_frim_log", createLogBlock(MaterialColor.RED, MaterialColor.RED_TERRACOTTA, Material.ORGANIC, ToolType.AXE, 2.0F, SoundType.WOOD));
    public static final Block FIRG_WOOD = register("firg_wood", new RotatedPillarBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final Block FRIM_WOOD = register("frim_wood", new RotatedPillarBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.ADOBE).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final Block STRIPPED_FIRG_WOOD = register("stripped_firg_wood", new ColoredRotatedPillarBlock(MaterialColor.WOOD, Block.Properties.create(Material.ORGANIC).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final Block STRIPPED_FRIM_WOOD = register("stripped_frim_wood", new ColoredRotatedPillarBlock(MaterialColor.WOOD, Block.Properties.create(Material.ORGANIC).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
    public static final Block GANK_SLAB = register("gank_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(990.0F, 1000.0F)));
    public static final Block ENDER_TRASK_1 = register("ender_trask_1", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(6).hardnessAndResistance(160.0f)));
    public static final Block ENDER_TRASKCRAFTH_1 = register("ender_traskcrafth_1", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(5).hardnessAndResistance(100.0f)));
    public static final Block DURT = register("durt/durt", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(30.0f, 440.0f)));
    public static final Block DURT_GURBF = register("durt/gurbf", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(22.0f, 400.0f)));
    public static final Block GRITK_BLOCK_1 = register("gritk_block_1", new Block(Block.Properties.create(Material.IRON).setRequiresTool().harvestLevel(0).setLightLevel(Value -> 15).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500000.0F, 1200000.0F)));
    public static final Block FRIM_LOG = register("frim_log", createLogBlock(MaterialColor.WOOD, MaterialColor.RED, UnusedBlocks.requiresToolProperties(Material.ORGANIC, 0, 2.0F, ToolType.AXE, SoundType.WOOD)));
    public static final Block FRIM_SAPLING = register("frim_sapling", new ModSaplingBlock(FrimTree::new, AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
    public static final Block LEAVES = register("leaves", new Leaves(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final Block FRIM_LEAVES = register("frim_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final Block ZURK_SLAB = register("zurk_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(200.0F, 210.0F)));
    public static final Block ENDER_TRASKRACH_1 = register("ender_traskrach_1", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(4).hardnessAndResistance(80.0f)));
    public static final Block GRINTH_MUSHROOM = register("grinth_mushroom", new GrinthMushroom(Block.Properties.create(Material.PLANTS).zeroHardnessAndResistance().doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).setLightLevel(Value -> 1)));
    public static final Block RED_GRASS_BLOCK = register("red_grass_block", new GrassBlock(Block.Properties.create(Material.EARTH).tickRandomly().hardnessAndResistance(0.6F).sound(SoundType.PLANT)));
    public static final Block GRINTH_MUSHROOM_BLOCK = register("grinth_mushroom_block", new HugeMushroomBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN).setRequiresTool().hardnessAndResistance(0.2F).sound(SoundType.WOOD)));
    public static final Block BLACK_IRON_BLOCK = register("iron_block/black_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block BLUE_IRON_BLOCK = register("iron_block/blue_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block BROWN_IRON_BLOCK = register("iron_block/brown_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block CYAN_IRON_BLOCK = register("iron_block/cyan_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block GRAY_IRON_BLOCK = register("iron_block/gray_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block GREEN_IRON_BLOCK = register("iron_block/green_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_BLUE_IRON_BLOCK = register("iron_block/light_blue_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_BLUE1_IRON_BLOCK = register("iron_block/light_blue1_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_GRAY_IRON_BLOCK = register("iron_block/light_gray_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block LIME_IRON_BLOCK = register("iron_block/lime_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block MAGENTA_IRON_BLOCK = register("iron_block/magenta_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block ORANGE_IRON_BLOCK = register("iron_block/orange_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block PINK_IRON_BLOCK = register("iron_block/pink_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block PURPLE_IRON_BLOCK = register("iron_block/purple_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block RED_IRON_BLOCK = register("iron_block/red_iron_block", new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block YELLOW_IRON_BLOCK = register("iron_block/yellow_iron_block", new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final Block STONE_BLACK_IRON_ORE = register("iron_ores/stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_BLACK_IRON_ORE = register("iron_ores/black_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_BLUE_IRON_ORE = register("iron_ores/black_stone/blue_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_BROWN_IRON_ORE = register("iron_ores/black_stone/brown_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_CYAN_IRON_ORE = register("iron_ores/black_stone/cyan_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_GRAY_IRON_ORE = register("iron_ores/black_stone/gray_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_GREEN_IRON_ORE = register("iron_ores/black_stone/green_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_IRON_ORE = register("iron_ores/black_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_LIGHT_BLUE1_IRON_ORE = register("iron_ores/black_stone/light_blue1_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_LIGHT_BLUE_IRON_ORE = register("iron_ores/black_stone/light_blue_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_LIGHT_GRAY_IRON_ORE = register("iron_ores/black_stone/light_gray_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_LIME_IRON_ORE = register("iron_ores/black_stone/lime_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_MAGENTA_IRON_ORE = register("iron_ores/black_stone/magenta_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_ORANGE_IRON_ORE = register("iron_ores/black_stone/orange_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_PINK_IRON_ORE = register("iron_ores/black_stone/pink_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_PURPLE_IRON_ORE = register("iron_ores/black_stone/purple_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_RED_IRON_ORE = register("iron_ores/black_stone/red_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLACK_STONE_YELLOW_IRON_ORE = register("iron_ores/black_stone/yellow_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLUE_STONE_BLACK_IRON_ORE = register("iron_ores/blue_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLUE_STONE_BLUE_IRON_ORE = register("iron_ores/blue_stone/blue_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BROWN_STONE_BLACK_IRON_ORE = register("iron_ores/brown_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block CYAN_STONE_BLACK_IRON_ORE = register("iron_ores/cyan_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block GREEN_STONE_BLACK_IRON_ORE = register("iron_ores/green_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_BLUE_STONE_BLACK_IRON_ORE = register("iron_ores/light_blue_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_BLUE1_STONE_BLACK_IRON_ORE = register("iron_ores/light_blue1_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_GRAY_STONE_BLACK_IRON_ORE = register("iron_ores/light_gray_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block LIME_STONE_BLACK_IRON_ORE = register("iron_ores/lime_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block MAGENTA_STONE_BLACK_IRON_ORE = register("iron_ores/magenta_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block ORANGE_STONE_BLACK_IRON_ORE = register("iron_ores/orange_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block PINK_STONE_BLACK_IRON_ORE = register("iron_ores/pink_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block PURPLE_STONE_BLACK_IRON_ORE = register("iron_ores/purple_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block RED_STONE_BLACK_IRON_ORE = register("iron_ores/red_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block WHITE_STONE_BLACK_IRON_ORE = register("iron_ores/white_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block YELLOW_STONE_BLACK_IRON_ORE = register("iron_ores/yellow_stone/black_iron_ore", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BLUE_STONE_IRON_ORE = register("iron_ores/blue_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BROWN_STONE_IRON_ORE = register("iron_ores/brown_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block CYAN_STONE_IRON_ORE = register("iron_ores/cyan_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block GREEN_STONE_IRON_ORE = register("iron_ores/green_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_BLUE_STONE_IRON_ORE = register("iron_ores/light_blue_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_BLUE1_STONE_IRON_ORE = register("iron_ores/light_blue1_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block LIGHT_GRAY_STONE_IRON_ORE = register("iron_ores/light_gray_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block LIME_STONE_IRON_ORE = register("iron_ores/lime_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block MAGENTA_STONE_IRON_ORE = register("iron_ores/magenta_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block ORANGE_STONE_IRON_ORE = register("iron_ores/orange_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block PINK_STONE_IRON_ORE = register("iron_ores/pink_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block PURPLE_STONE_IRON_ORE = register("iron_ores/purple_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block RED_STONE_IRON_ORE = register("iron_ores/red_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block WHITE_STONE_IRON_ORE = register("iron_ores/white_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block YELLOW_STONE_IRON_ORE = register("iron_ores/yellow_stone/iron_ore", new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block ACACIA_PLANKS1 = register("acacia_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block BIRCH_PLANKS1 = register("birch_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block DARK_OAK_PLANKS1 = register("dark_oak_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block JUNGLE_PLANKS1 = register("jungle_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block OAK_PLANKS1 = register("oak_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block SPRUCE_PLANKS1 = register("spruce_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block FIRG_PLANKS1 = register("firg_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block FRIM_PLANKS1 = register("frim_planks1", new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final Block RUBY_ORE = register("ruby_ore", new ModOreBlock(3, 7, AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block BLACK_STONE_BRICKS = register("stone/bricks/black_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block BLUE_STONE_BRICKS = register("stone/bricks/blue_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block BROWN_STONE_BRICKS = register("stone/bricks/brown_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block CYAN_STONE_BRICKS = register("stone/bricks/cyan_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block GREEN_STONE_BRICKS = register("stone/bricks/green_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block LIGHT_BLUE1_STONE_BRICKS = register("stone/bricks/light_blue1_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block LIGHT_BLUE_STONE_BRICKS = register("stone/bricks/light_blue_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block LIGHT_GRAY_STONE_BRICKS = register("stone/bricks/light_gray_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block LIME_STONE_BRICKS = register("stone/bricks/lime_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block MAGENTA_STONE_BRICKS = register("stone/bricks/magenta_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block ORANGE_STONE_BRICKS = register("stone/bricks/orange_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block PINK_STONE_BRICKS = register("stone/bricks/pink_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block PURPLE_STONE_BRICKS = register("stone/bricks/purple_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block RED_STONE_BRICKS = register("stone/bricks/red_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block WHITE_STONE_BRICKS = register("stone/bricks/white_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block YELLOW_STONE_BRICKS = register("stone/bricks/yellow_stone_bricks", new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final Block BLACK_FURNACE = register("furnaces/black_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block BLUE_FURNACE = register("furnaces/blue_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block BROWN_FURNACE = register("furnaces/brown_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block CYAN_FURNACE = register("furnaces/cyan_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block GREEN_FURNACE = register("furnaces/green_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block LIGHT_BLUE_FURNACE = register("furnaces/light_blue_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block LIGHT_BLUE1_FURNACE = register("furnaces/light_blue1_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block LIGHT_GRAY_FURNACE = register("furnaces/light_gray_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block LIME_FURNACE = register("furnaces/lime_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block MAGENTA_FURNACE = register("furnaces/magenta_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block ORANGE_FURNACE = register("furnaces/orange_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block PINK_FURNACE = register("furnaces/pink_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block PURPLE_FURNACE = register("furnaces/purple_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block RED_FURNACE = register("furnaces/red_furnace", new FurnaceBlock(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block WHITE_FURNACE = register("furnaces/white_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block YELLOW_FURNACE = register("furnaces/yellow_furnace", new FurnaceBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final Block TRUMRUNT = register("trumrunt", new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.LIGHT_BLUE).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F).setLightLevel(Value -> 15)));

    public static Block create(AbstractBlock.Properties properties) {
        return new Block(properties);
    }

    public static SlabBlock createSlabBlock(Material material, int harvestLevel, float hardnessAndResistance, ToolType toolType) {
        return new SlabBlock(UnusedBlocks.requiresToolProperties(material, harvestLevel, hardnessAndResistance, toolType));
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
        return AbstractBlock.Properties.create(Material.WOOD, (p_235431_2_) -> p_235431_2_.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor);
    }

    private static AbstractBlock.Properties createLogBlock(Material material, MaterialColor topColor, MaterialColor barkColor, AbstractBlock.Properties properties) {
        return AbstractBlock.Properties.create(material, (p_235431_2_) -> p_235431_2_.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor);
    }

    static class Axe_Item extends AxeItem {
        public Axe_Item(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }

        public static void block() {
            BLOCK_STRIPPING_MAP.put(BlockItemInit.FIRG_LOG, BlockItemInit.STRIPPED_FIRG_LOG);
            BLOCK_STRIPPING_MAP.put(BlockItemInit.FIRG_WOOD, BlockItemInit.STRIPPED_FIRG_WOOD);
            BLOCK_STRIPPING_MAP.put(BlockItemInit.FRIM_LOG, BlockItemInit.STRIPPED_FRIM_LOG);
            BLOCK_STRIPPING_MAP.put(BlockItemInit.FRIM_WOOD, BlockItemInit.STRIPPED_FRIM_WOOD);
        }
    }

    public static Block registerStoneBricks(String name) {
        return register("stone/bricks/" + name + "_stone_brick_slab", createStoneBricks());
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
        return register("stone/" + type + "/" + name, stone);
    }

    public static Block registerNumBlock(String name) {
        return register(name, createNumBlock());
    }

    public static Block createStoneBricks() {
        return createStone();
    }

    public static Block createSmoothStone() {
        return createCobblestone();
    }

    public static Block createStone() {
        return new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F));
    }

    public static Block createCobblestoneSlab() {
        return createCobblestone();
    }

    public static Block createStoneSlab() {
        return createCobblestone();
    }

    public static Block createCobblestone() {
        return new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2.0F, 6.0F));
    }

    public static Block createNumBlock() {
        return new LBlock(Block.Properties.create(Material.ORGANIC).setRequiresTool().hardnessAndResistance(1000000000).setLightLevel(Value -> 15));
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
        return UnusedBlocks.registerBlock(name, blockIn);
    }

    public static BlockItem registerBlockItem(String name, Block blockIn) {
        return UnusedBlockItems.registerDefault(name, blockIn);
    }

    public static BlockItem registerBlockItem(String name, Block blockIn, Item.Properties properties) {
        return UnusedBlockItems.registerDefault(name, blockIn, properties);
    }

    static {
//        Axe_Item.block();
        EXAMPLE_BLOCK = register("example_block", create(Material.SAND, 0.5F, 15.0F, SoundType.SAND));
        DEFERRED_BLOCK = register("deferred_block", create(Material.AIR));
        JAZZ_LOG = register("jazz_log", createLogBlockFrom(MaterialColor.WOOD, MaterialColor.PINK, Blocks.OAK_LOG));
        JAZZ_LEAVES = register("jazz_leaves", new LeavesBlock(fromProperties(Blocks.OAK_LEAVES)));
        JAZZ_SAPLING = register("jazz_sapling", new ModSaplingBlock(JazzTree::new, fromProperties(OAK_SAPLING)));
        REGDEM_BLOCK = register("regdem_block", create(Material.WOOD, 0, ToolType.AXE, 10.0f));
        SRIUNK_ORE = register("sriunk_ore", new ModOreBlock(1, 5, UnusedBlocks.requiresToolProperties(Material.ROCK, 3, 100.0F, ToolType.PICKAXE)));
        RUBY_BLOCK = register("ruby_block", UnusedBlocks.setBlockRequiresTool(Material.IRON, 2, 8.0f, ToolType.PICKAXE));
        RUBY_SLAB = register("ruby_slab", createSlabBlock(Material.IRON, 3, 9.0F, ToolType.PICKAXE));
        RUBY_STAIRS = register("ruby_stairs", createStairsBlockFrom(RUBY_BLOCK));
        RED_COBBLESTONE = register("stone/cobblestones/red_cobblestone", UnusedBlocks.setBlockRequiresTool(Material.ROCK, 0, 2.0F, 6.0F, ToolType.PICKAXE));
        RED_COBBLESTONE_STAIRS = register("stone/cobblestone/stairs/red_cobblestone_stairs", createStairsBlockFrom(RED_COBBLESTONE));
    }
}
