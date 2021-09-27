package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.AbstractModBlock;
import com.babcsany.minecraft.ervin_mod_1.block.FallingZurBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.slabs.ZurkSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.stairs.GurkStairs;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.slabs.ObsidianSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.slabs.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.slabs.GurkSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.slabs.RubySlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.stairs.RubyStairs;
import com.babcsany.minecraft.ervin_mod_1.block.furnace.BlackFurnace;
import com.babcsany.minecraft.ervin_mod_1.block.iron_ores.*;
import com.babcsany.minecraft.ervin_mod_1.block.stone.cobblestone.stairs.StairsBlock;
import com.babcsany.minecraft.ervin_mod_1.block.stone.stone_bricks.*;
import com.babcsany.minecraft.ervin_mod_1.init.sound.SoundInit;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FrimTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.JazzTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModSaplingBlock;
import com.babcsany.minecraft.init.BlockInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;
import java.util.function.Supplier;

import static net.minecraft.block.Blocks.*;

public class BlockItemInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block", Material.SAND, 0.5f, 15.0f, SoundType.SAND);
    public static final RegistryObject<Block> ZUR_BLOCK = BLOCKS.register("zur_block", () -> new FallingZurBlock(blockRegister(Material.SAND, 1.5f, 45.0f, SoundType.WOOD)));
    public static final RegistryObject<Block> TRADER_BLOCK = BLOCKS.register("trader_block", () -> new TraderBlock(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.SAND), AbstractModBlock.Properties.create(Material.ROCK).doesNotBlockMovement_().soundInit(SoundInit.WOIK)));
    public static final RegistryObject<Block> DEFERRED_BLOCK = register("deferred_block", Material.AIR);
    public static final RegistryObject<Block> JAZZ_LOG = BLOCKS.register("jazz_log", () -> new JazzLog(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> JAZZ_LEAVES = BLOCKS.register("jazz_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> JAZZ_SAPLING = BLOCKS.register("jazz_sapling", () -> new ModSaplingBlock(JazzTree::new, Block.Properties.from(OAK_SAPLING)));
    public static final RegistryObject<Block> REGDEM_BLOCK = register("regdem_block", Material.WOOD, 0, ToolType.AXE, 10.0f);
    public static final RegistryObject<Block> SRIUNK_ORE = registerRequiresTool("sriunk_ore", Material.ROCK, 3, ToolType.PICKAXE, 100.0f);
    public static final RegistryObject<Block> RUBY_BLOCK = registerRequiresTool("ruby_block", Material.IRON, 2, ToolType.PICKAXE, 8.0f);
    public static final RegistryObject<Block> AVTER_BLOCK = registerRequiresTool("avter_block", Material.ROCK, 5, ToolType.PICKAXE, 6000.0f);
    public static final RegistryObject<Block> FRIT_BLOCK = registerRequiresTool("frit_block", Material.ROCK, 1, ToolType.PICKAXE, 60.0f);
    public static final RegistryObject<Block> END_PORTAL = registerRequiresTool("end_portal", Material.ROCK, 13, ToolType.PICKAXE, 60.0f);
    public static final RegistryObject<Block> END_STONE_CISK = registerRequiresTool("end_stone_cisk", Material.ROCK, 1, ToolType.PICKAXE, 30.0f);
    public static final RegistryObject<Block> END_STONE_CRISK = registerRequiresTool("end_stone_crisk", Material.ROCK, 2, ToolType.PICKAXE, 45.0f);
    public static final RegistryObject<Block> END_SRACT = registerRequiresTool("end_sract", Material.ROCK, 0, ToolType.PICKAXE, 8.0f);
    public static final RegistryObject<Block> ENDER_SRACT = registerRequiresTool("ender_sract", Material.ROCK, 1, ToolType.PICKAXE, 9.0f);
    public static final RegistryObject<Block> ENDER_SACKT = registerRequiresTool("ender_sackt", Material.ROCK, 1, ToolType.PICKAXE, 10.0f);
    public static final RegistryObject<Block> ENDER_SACT = registerRequiresTool("ender_sact", Material.ROCK, 1, ToolType.PICKAXE, 12.0f);
    public static final RegistryObject<Block> ENDER_SRACKH = registerRequiresTool("ender_srackh", Material.ROCK, 1, ToolType.PICKAXE, 14.0f);
    public static final RegistryObject<Block> ENDER_SRACK = registerRequiresTool("ender_srack", Material.ROCK, 2, ToolType.PICKAXE, 16.0f);
    public static final RegistryObject<Block> END_SRACKT = registerRequiresTool("end_srackt", Material.ROCK, 2, ToolType.PICKAXE, 16.0f);
    public static final RegistryObject<Block> GRIRZT = registerGrirzt();
    public static final RegistryObject<Block> TRING = registerRequiresTool("tring", Material.ORGANIC, 1, ToolType.AXE, 60.0f);
    public static final RegistryObject<Block> PACK_BLOCK = registerRequiresTool("pack_block", Material.EARTH, 1, ToolType.SHOVEL, 40.0f);
    public static final RegistryObject<Block> KALT_BLOCK = registerOreBlock("kalt_block", Material.ROCK, 2, ToolType.PICKAXE, 60.0F, 5, 12);
    public static final RegistryObject<Block> URVI = registerRequiresTool("urvi", Material.ROCK, 0, ToolType.PICKAXE, 3.0F, 9.0F);
    public static final RegistryObject<Block> SURVI = registerRequiresTool("survi", Material.ROCK, 0, ToolType.PICKAXE, 2.0F, 9.0F);
    public static final RegistryObject<Block> SURV = registerRequiresTool("surv", Material.ROCK, 1, ToolType.PICKAXE, 4.0F, 10.0F);
    public static final RegistryObject<Block> SURT = registerRequiresTool("surt", Material.ROCK, 1, ToolType.PICKAXE, 5.0F, 12.0F);
    public static final RegistryObject<Block> BLACK_COBBLESTONE = registerCobblestoneRequiresTool("black_cobblestone");
    public static final RegistryObject<Block> BLUE_COBBLESTONE = registerCobblestoneRequiresTool("blue_cobblestone");
    public static final RegistryObject<Block> BROWN_COBBLESTONE = registerCobblestoneRequiresTool("brown_cobblestone");
    public static final RegistryObject<Block> CYAN_COBBLESTONE = registerCobblestoneRequiresTool("cyan_cobblestone");
    public static final RegistryObject<Block> GREEN_COBBLESTONE = registerCobblestoneRequiresTool("green_cobblestone");
    public static final RegistryObject<Block> LIGHT_BLUE_COBBLESTONE = registerCobblestoneRequiresTool("light_blue1_cobblestone");
    public static final RegistryObject<Block> LIGHT_BLUE1_COBBLESTONE = registerCobblestoneRequiresTool("light_blue_cobblestone");
    public static final RegistryObject<Block> LIGHT_GRAY_COBBLESTONE = registerCobblestoneRequiresTool("light_gray_cobblestone");
    public static final RegistryObject<Block> LIME_COBBLESTONE = registerCobblestoneRequiresTool("lime_cobblestone");
    public static final RegistryObject<Block> MAGENTA_COBBLESTONE = registerCobblestoneRequiresTool("magenta_cobblestone");
    public static final RegistryObject<Block> ORANGE_COBBLESTONE = registerCobblestoneRequiresTool("orange_cobblestone");
    public static final RegistryObject<Block> PINK_COBBLESTONE = registerCobblestoneRequiresTool("pink_cobblestone");
    public static final RegistryObject<Block> PURPLE_COBBLESTONE = registerCobblestoneRequiresTool("purple_cobblestone");
    public static final RegistryObject<Block> RED_COBBLESTONE = registerCobblestoneRequiresTool("red_cobblestone");
    public static final RegistryObject<Block> WHITE_COBBLESTONE = registerCobblestoneRequiresTool("white_cobblestone");
    public static final RegistryObject<Block> YELLOW_COBBLESTONE = registerCobblestoneRequiresTool("yellow_cobblestone");
    public static final RegistryObject<Block> ENDER_SRACKTH = registerRequiresTool("ender_srackth", Material.SPONGE, 1, ToolType.PICKAXE, 20.0f);
    public static final RegistryObject<Block> OAK_TURG = registerRequiresTool("oak_turg", Material.WOOD, 1, ToolType.AXE, 20.0F, SoundType.WOOD);
    public static final RegistryObject<Block> FIRG_TURG = registerRequiresTool("firg_turg", Material.WOOD, 1, ToolType.AXE, 20.0F, SoundType.WOOD);
    public static final RegistryObject<Block> FRIM_TURG = registerRequiresTool("frim_turg", Material.WOOD, 1, ToolType.AXE, 20.0F, SoundType.WOOD);
    public static final RegistryObject<Block> ENDER_TRASK = registerRequiresTool("ender_trask", Material.SPONGE, 6, 160.0f);
    public static final RegistryObject<Block> ACACIA_TURG = registerRequiresTool("acacia_turg", Material.SPONGE, 1, ToolType.AXE, 20.0F, SoundType.WOOD);
    public static final RegistryObject<Block> BIRCH_TURG = registerRequiresTool("birch_turg", Material.SPONGE, 1, ToolType.AXE, 20.0f, SoundType.WOOD);
    public static final RegistryObject<Block> DARK_OAK_TURG = registerRequiresTool("dark_oak_turg", Material.SPONGE, 1, ToolType.AXE, 20.0F, SoundType.WOOD);
    public static final RegistryObject<Block> JUNGLE_TURG = registerRequiresTool("jungle_turg", Material.SPONGE, 1, ToolType.AXE, 20.0F, SoundType.WOOD);
    public static final RegistryObject<Block> SPRUCE_TURG = registerRequiresTool("spruce_turg", Material.SPONGE, 1, ToolType.AXE, 20.0F, SoundType.WOOD);
    public static final RegistryObject<Block> TURG = registerRequiresTool("turg", Material.SPONGE, 1, ToolType.AXE, 20.0f, SoundType.WOOD);
    public static final RegistryObject<Block> L0 = registerRequiresToolLightValue("0", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> L1 = registerRequiresToolLightValue("1", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> L2 = registerRequiresToolLightValue("2", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> L3 = registerRequiresToolLightValue("3", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> L4 = registerRequiresToolLightValue("4", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> L5 = registerRequiresToolLightValue("5", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> L6 = registerRequiresToolLightValue("6", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> L7 = registerRequiresToolLightValue("7", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> L8 = registerRequiresToolLightValue("8", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> L9 = registerRequiresToolLightValue("9", Material.ORGANIC, 1000000000, 15);
    public static final RegistryObject<Block> AIR = BLOCKS.register("air", () -> new Air(Block.Properties.create(Material.AIR).doesNotBlockMovement().noDrops()));
    public static final RegistryObject<Block> TRINKS = BLOCKS.register("trinks", () -> new Trinks(Block.Properties.create(Material.ROCK).setRequiresTool().doesNotBlockMovement().setLightLevel(Value -> 15)));
    public static final RegistryObject<Block> DIRT1 = BLOCKS.register("dirt1", () -> new Dirt1(Block.Properties.create(Material.EARTH, MaterialColor.DIRT).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.GROUND)));
    public static final RegistryObject<Block> GNITH_BLOCK = BLOCKS.register("gnith_block", () -> new OreBlock1(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(200.0F, 5000.0F)));
    public static final RegistryObject<Block> DIAMOND_SLAB = BLOCKS.register("diamond_slab", () -> new DiamondSlab(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).sound(SoundType.METAL).setRequiresTool().harvestLevel(3).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> OBSIDIAN_SLAB = BLOCKS.register("obsidian_slab", () -> new ObsidianSlab(Block.Properties.from(OBSIDIAN)));
    public static final RegistryObject<Block> IRON_SLAB = BLOCKS.register("iron_slab", () -> new IronSlab(Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).sound(SoundType.METAL).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> GOLD_SLAB = BLOCKS.register("gold_slab", () -> new GoldSlab(Block.Properties.create(Material.IRON, MaterialColor.GOLD).sound(SoundType.METAL).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(4.0F, 6.0F)));
    public static final RegistryObject<Block> REDSTONE_SLAB = BLOCKS.register("redstone_slab", () -> new RedstoneSlab(Block.Properties.create(Material.IRON, MaterialColor.TNT).sound(SoundType.METAL).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> DIRT_SLAB = BLOCKS.register("dirt_slab", () -> new DirtSlab(Block.Properties.create(Material.EARTH, MaterialColor.DIRT).sound(SoundType.GROUND).harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(1.0F)));
    public static final RegistryObject<Block> LAPIS_SLAB = BLOCKS.register("lapis_slab", () -> new LapisSlab(Block.Properties.create(Material.IRON, MaterialColor.LAPIS).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> EMERALD_SLAB = BLOCKS.register("emerald_slab", () -> new EmeraldSlab(Block.Properties.create(Material.IRON, MaterialColor.EMERALD).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> RUBY_SLAB = BLOCKS.register("ruby_slab", () -> new RubySlab(Block.Properties.create(Material.IRON).setRequiresTool().harvestLevel(3).harvestTool(ToolType.PICKAXE).hardnessAndResistance(9.0F)));
    public static final RegistryObject<Block> RUBY_STAIRS = BLOCKS.register("ruby_stairs", () -> new RubyStairs(() -> RUBY_BLOCK.get().getDefaultState(), Block.Properties.from(RUBY_BLOCK.get())));
    public static final RegistryObject<Block> BLACK_STONE = registerStoneRequiresTool("black_stone");
    public static final RegistryObject<Block> BLUE_STONE = registerStoneRequiresTool("blue_stone");
    public static final RegistryObject<Block> BROWN_STONE = registerStoneRequiresTool("brown_stone");
    public static final RegistryObject<Block> CYAN_STONE = registerStoneRequiresTool("cyan_stone");
    public static final RegistryObject<Block> GREEN_STONE = registerStoneRequiresTool("green_stone");
    public static final RegistryObject<Block> LIGHT_BLUE_STONE = registerStoneRequiresTool("light_blue_stone");
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE = registerStoneRequiresTool("light_blue1_stone");
    public static final RegistryObject<Block> LIGHT_GRAY_STONE = registerStoneRequiresTool("light_gray_stone");
    public static final RegistryObject<Block> LIME_STONE = registerStoneRequiresTool("lime_stone");
    public static final RegistryObject<Block> MAGENTA_STONE = registerStoneRequiresTool("magenta_stone");
    public static final RegistryObject<Block> ORANGE_STONE = registerStoneRequiresTool("orange_stone");
    public static final RegistryObject<Block> PINK_STONE = registerStoneRequiresTool("pink_stone");
    public static final RegistryObject<Block> PURPLE_STONE = registerStoneRequiresTool("purple_stone");
    public static final RegistryObject<Block> RED_STONE = registerStoneRequiresTool("red_stone");
    public static final RegistryObject<Block> WHITE_STONE = registerStoneRequiresTool("white_stone");
    public static final RegistryObject<Block> YELLOW_STONE = registerStoneRequiresTool("yellow_stone");
    public static final RegistryObject<Block> BLACK_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("black_cobblestone_slab");
    public static final RegistryObject<Block> BLUE_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("blue_cobblestone_slab");
    public static final RegistryObject<Block> BROWN_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("brown_cobblestone_slab");
    public static final RegistryObject<Block> CYAN_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("cyan_cobblestone_slab");
    public static final RegistryObject<Block> GREEN_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("green_cobblestone_slab");
    public static final RegistryObject<Block> LIGHT_BLUE_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("light_blue_cobblestone_slab");
    public static final RegistryObject<Block> LIGHT_BLUE1_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("light_blue1_cobblestone_slab");
    public static final RegistryObject<Block> LIGHT_GRAY_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("light_gray_cobblestone_slab");
    public static final RegistryObject<Block> LIME_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("lime_cobblestone_slab");
    public static final RegistryObject<Block> MAGENTA_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("magenta_cobblestone_slab");
    public static final RegistryObject<Block> ORANGE_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("orange_cobblestone_slab");
    public static final RegistryObject<Block> PINK_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("pink_cobblestone_slab");
    public static final RegistryObject<Block> PURPLE_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("purple_cobblestone_slab");
    public static final RegistryObject<Block> RED_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("red_cobblestone_slab");
    public static final RegistryObject<Block> WHITE_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("white_cobblestone_slab");
    public static final RegistryObject<Block> YELLOW_COBBLESTONE_SLAB = registerCobblestoneSlabRequiresTool("yellow_cobblestone_slab");
    public static final RegistryObject<Block> BLACK_STONE_SLAB = registerStoneSlabRequiresTool("black_stone_slab");
    public static final RegistryObject<Block> BLUE_STONE_SLAB = registerStoneSlabRequiresTool("blue_stone_slab");
    public static final RegistryObject<Block> BROWN_STONE_SLAB = registerStoneSlabRequiresTool("brown_stone_slab");
    public static final RegistryObject<Block> CYAN_STONE_SLAB = registerStoneSlabRequiresTool("cyan_stone_slab");
    public static final RegistryObject<Block> GREEN_STONE_SLAB = registerStoneSlabRequiresTool("green_stone_slab");
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_SLAB = registerStoneSlabRequiresTool("light_blue_stone_slab");
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_SLAB = registerStoneSlabRequiresTool("light_blue1_stone_slab");
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_SLAB = registerStoneSlabRequiresTool("light_gray_stone_slab");
    public static final RegistryObject<Block> LIME_STONE_SLAB = registerStoneSlabRequiresTool("lime_stone_slab");
    public static final RegistryObject<Block> MAGENTA_STONE_SLAB = registerStoneSlabRequiresTool("magenta_stone_slab");
    public static final RegistryObject<Block> ORANGE_STONE_SLAB = registerStoneSlabRequiresTool("orange_stone_slab");
    public static final RegistryObject<Block> PINK_STONE_SLAB = registerStoneSlabRequiresTool("pink_stone_slab");
    public static final RegistryObject<Block> PURPLE_STONE_SLAB = registerStoneSlabRequiresTool("purple_stone_slab");
    public static final RegistryObject<Block> RED_STONE_SLAB = registerStoneSlabRequiresTool("red_stone_slab");
    public static final RegistryObject<Block> WHITE_STONE_SLAB = registerStoneSlabRequiresTool("white_stone_slab");
    public static final RegistryObject<Block> YELLOW_STONE_SLAB = registerStoneSlabRequiresTool("yellow_stone_slab");
    public static final RegistryObject<Block> GRITK_BLOCK = BLOCKS.register("gritk_block", () -> new GritkBlock(Block.Properties.create(Material.IRON).setRequiresTool().harvestLevel(0).setLightLevel(Value -> 15).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500000.0F, 1200000.0F)));
    public static final RegistryObject<Block> GURK_BLOCK = BLOCKS.register("gurk_block", () -> new GurkBlock(Block.Properties.create(Material.WATER).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(20.0f)));
    public static final RegistryObject<Block> GURK_SLAB = BLOCKS.register("gurk_slab", () -> new GurkSlab(Block.Properties.create(Material.WATER).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(20.0f, 22.0f)));
    public static final RegistryObject<Block> GURK_STAIRS = BLOCKS.register("gurk_stairs", () -> new GurkStairs(() -> GURK_BLOCK.get().getDefaultState(), Block.Properties.from(GURK_BLOCK.get())));
    public static final RegistryObject<Block> BLACK_SMOOTH_STONE = registerSmoothStoneRequiresTool("black_smooth_stone");
    public static final RegistryObject<Block> BLUE_SMOOTH_STONE = registerSmoothStoneRequiresTool("blue_smooth_stone");
    public static final RegistryObject<Block> BROWN_SMOOTH_STONE = registerSmoothStoneRequiresTool("brown_smooth_stone");
    public static final RegistryObject<Block> CYAN_SMOOTH_STONE = registerSmoothStoneRequiresTool("cyan_smooth_stone");
    public static final RegistryObject<Block> GREEN_SMOOTH_STONE = registerSmoothStoneRequiresTool("green_smooth_stone");
    public static final RegistryObject<Block> LIGHT_BLUE_SMOOTH_STONE = registerSmoothStoneRequiresTool("light_blue_smooth_stone");
    public static final RegistryObject<Block> LIGHT_BLUE1_SMOOTH_STONE = registerSmoothStoneRequiresTool("light_blue1_smooth_stone");
    public static final RegistryObject<Block> LIGHT_GRAY_SMOOTH_STONE = registerSmoothStoneRequiresTool("light_gray_smooth_stone");
    public static final RegistryObject<Block> LIME_SMOOTH_STONE = registerSmoothStoneRequiresTool("lime_smooth_stone");
    public static final RegistryObject<Block> MAGENTA_SMOOTH_STONE = registerSmoothStoneRequiresTool("magenta_smooth_stone");
    public static final RegistryObject<Block> ORANGE_SMOOTH_STONE = registerSmoothStoneRequiresTool("orange_smooth_stone");
    public static final RegistryObject<Block> PINK_SMOOTH_STONE = registerSmoothStoneRequiresTool("pink_smooth_stone");
    public static final RegistryObject<Block> PURPLE_SMOOTH_STONE = registerSmoothStoneRequiresTool("purple_smooth_stone");
    public static final RegistryObject<Block> RED_SMOOTH_STONE = registerSmoothStoneRequiresTool("red_smooth_stone");
    public static final RegistryObject<Block> WHITE_SMOOTH_STONE = registerSmoothStoneRequiresTool("white_smooth_stone");
    public static final RegistryObject<Block> YELLOW_SMOOTH_STONE = registerSmoothStoneRequiresTool("yellow_smooth_stone");
    public static final RegistryObject<Block> ENDER_SRACKHT_1 = registerRequiresTool("ender_srackht_1", Material.ROCK, 1, ToolType.PICKAXE, 20.0F);
    public static final RegistryObject<Block> ENDER_SRAKTCAF_1 = registerRequiresTool("ender_sraktcaf_1", Material.ROCK, 3, ToolType.SHOVEL, 60.0F);
    public static final RegistryObject<Block> ENDER_STAKRACH_1 = registerRequiresTool("ender_stakrach_1", Material.WOOD, 2, ToolType.AXE, 40.0F);
    public static final RegistryObject<Block> BLACK_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("black_smooth_stone_slab");
    public static final RegistryObject<Block> BLUE_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("blue_smooth_stone_slab");
    public static final RegistryObject<Block> BROWN_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("brown_smooth_stone_slab");
    public static final RegistryObject<Block> CYAN_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("cyan_smooth_stone_slab");
    public static final RegistryObject<Block> GREEN_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("green_smooth_stone_slab");
    public static final RegistryObject<Block> LIGHT_BLUE_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("light_blue_smooth_stone_slab");
    public static final RegistryObject<Block> LIGHT_BLUE1_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("light_blue1_smooth_stone_slab");
    public static final RegistryObject<Block> LIGHT_GRAY_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("light_gray_smooth_stone_slab");
    public static final RegistryObject<Block> LIME_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("lime_smooth_stone_slab");
    public static final RegistryObject<Block> MAGENTA_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("magenta_smooth_stone_slab");
    public static final RegistryObject<Block> ORANGE_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("orange_smooth_stone_slab");
    public static final RegistryObject<Block> PINK_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("pink_smooth_stone_slab");
    public static final RegistryObject<Block> PURPLE_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("purple_smooth_stone_slab");
    public static final RegistryObject<Block> RED_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("red_smooth_stone_slab");
    public static final RegistryObject<Block> WHITE_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("white_smooth_stone_slab");
    public static final RegistryObject<Block> YELLOW_SMOOTH_STONE_SLAB = registerSmoothStoneSlabRequiresTool("yellow_smooth_stone_slab");
    public static final RegistryObject<Block> ZURK_BLOCK = registerRequiresTool("zurk_block", Material.AIR, 2, ToolType.SHOVEL, 200.0F);
    public static final RegistryObject<Block> ZURK_STAIRS = registerStairsRequiresTool("zurk_stairs", ZURK_BLOCK, ZURK_BLOCK);
    public static final RegistryObject<Block> BLACK_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("black_cobblestone_stairs", BLACK_COBBLESTONE, BLACK_COBBLESTONE);
    public static final RegistryObject<Block> BLUE_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("blue_cobblestone_stairs", BLUE_COBBLESTONE, BLUE_COBBLESTONE);
    public static final RegistryObject<Block> BROWN_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("brown_cobblestone_stairs", BROWN_COBBLESTONE, BROWN_COBBLESTONE);
    public static final RegistryObject<Block> CYAN_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("cyan_cobblestone_stairs", CYAN_COBBLESTONE, CYAN_COBBLESTONE);
    public static final RegistryObject<Block> GREEN_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("green_cobblestone_stairs", GREEN_COBBLESTONE, GREEN_COBBLESTONE);
    public static final RegistryObject<Block> LIGHT_BLUE_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("light_blue_cobblestone_stairs", LIGHT_BLUE_COBBLESTONE, LIGHT_BLUE_COBBLESTONE);
    public static final RegistryObject<Block> LIGHT_BLUE1_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("light_blue1_cobblestone_stairs", LIGHT_BLUE1_COBBLESTONE, LIGHT_BLUE1_COBBLESTONE);
    public static final RegistryObject<Block> LIGHT_GRAY_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("light_gray_cobblestone_stairs", LIGHT_GRAY_COBBLESTONE, LIGHT_GRAY_COBBLESTONE);
    public static final RegistryObject<Block> LIME_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("lime_cobblestone_stairs", LIME_COBBLESTONE, LIME_COBBLESTONE);
    public static final RegistryObject<Block> MAGENTA_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("magenta_cobblestone_stairs", MAGENTA_COBBLESTONE, MAGENTA_COBBLESTONE);
    public static final RegistryObject<Block> ORANGE_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("orange_cobblestone_stairs", ORANGE_COBBLESTONE, ORANGE_COBBLESTONE);
    public static final RegistryObject<Block> PINK_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("pink_cobblestone_stairs", PINK_COBBLESTONE, PINK_COBBLESTONE);
    public static final RegistryObject<Block> PURPLE_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("purple_cobblestone_stairs", PURPLE_COBBLESTONE, PURPLE_COBBLESTONE);
    public static final RegistryObject<Block> RED_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("red_cobblestone_stairs", RED_COBBLESTONE, RED_COBBLESTONE);
    public static final RegistryObject<Block> WHITE_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("white_cobblestone_stairs", WHITE_COBBLESTONE, WHITE_COBBLESTONE);
    public static final RegistryObject<Block> YELLOW_COBBLESTONE_STAIRS = registerCobblestoneStairsRequiresTool("yellow_cobblestone_stairs", YELLOW_COBBLESTONE, YELLOW_COBBLESTONE);
    public static final RegistryObject<Block> BLACK_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("black_smooth_stone_stairs", BLACK_SMOOTH_STONE, BLACK_SMOOTH_STONE);
    public static final RegistryObject<Block> BLUE_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("blue_smooth_stone_stairs", BLUE_SMOOTH_STONE, BLUE_SMOOTH_STONE);
    public static final RegistryObject<Block> BROWN_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("brown_smooth_stone_stairs", BROWN_SMOOTH_STONE, BROWN_SMOOTH_STONE);
    public static final RegistryObject<Block> CYAN_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("cyan_smooth_stone_stairs", CYAN_SMOOTH_STONE, CYAN_SMOOTH_STONE);
    public static final RegistryObject<Block> GREEN_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("green_smooth_stone_stairs", GREEN_SMOOTH_STONE, GREEN_SMOOTH_STONE);
    public static final RegistryObject<Block> LIGHT_BLUE_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("light_blue_smooth_stone_stairs", LIGHT_BLUE_SMOOTH_STONE, LIGHT_BLUE_SMOOTH_STONE);
    public static final RegistryObject<Block> LIGHT_BLUE1_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("light_blue1_smooth_stone_stairs", LIGHT_BLUE1_SMOOTH_STONE, LIGHT_BLUE1_SMOOTH_STONE);
    public static final RegistryObject<Block> LIGHT_GRAY_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("light_gray_smooth_stone_stairs", LIGHT_GRAY_SMOOTH_STONE, LIGHT_GRAY_SMOOTH_STONE);
    public static final RegistryObject<Block> LIME_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("lime_smooth_stone_stairs", LIME_SMOOTH_STONE, LIME_SMOOTH_STONE);
    public static final RegistryObject<Block> MAGENTA_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("magenta_smooth_stone_stairs", MAGENTA_SMOOTH_STONE, MAGENTA_SMOOTH_STONE);
    public static final RegistryObject<Block> ORANGE_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("orange_smooth_stone_stairs", ORANGE_SMOOTH_STONE, ORANGE_SMOOTH_STONE);
    public static final RegistryObject<Block> PINK_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("pink_smooth_stone_stairs", PINK_SMOOTH_STONE, PINK_SMOOTH_STONE);
    public static final RegistryObject<Block> PURPLE_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("purple_smooth_stone_stairs", PURPLE_SMOOTH_STONE, PURPLE_SMOOTH_STONE);
    public static final RegistryObject<Block> RED_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("red_smooth_stone_stairs", RED_SMOOTH_STONE, RED_SMOOTH_STONE);
    public static final RegistryObject<Block> WHITE_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("white_smooth_stone_stairs", WHITE_SMOOTH_STONE, WHITE_SMOOTH_STONE);
    public static final RegistryObject<Block> YELLOW_SMOOTH_STONE_STAIRS = registerSmoothStoneStairsRequiresTool("yellow_smooth_stone_stairs", YELLOW_SMOOTH_STONE, YELLOW_SMOOTH_STONE);
    public static final RegistryObject<Block> BLACK_STONE_STAIRS = registerStoneStairsRequiresTool("black_stone_stairs", BLACK_STONE, BLACK_STONE);
    public static final RegistryObject<Block> BLUE_STONE_STAIRS = registerStoneStairsRequiresTool("blue_stone_stairs", BLUE_STONE, BLUE_STONE);
    public static final RegistryObject<Block> BROWN_STONE_STAIRS = registerStoneStairsRequiresTool("brown_stone_stairs", BROWN_STONE, BROWN_STONE);
    public static final RegistryObject<Block> CYAN_STONE_STAIRS = registerStoneStairsRequiresTool("cyan_stone_stairs", CYAN_STONE, CYAN_STONE);
    public static final RegistryObject<Block> GREEN_STONE_STAIRS = registerStoneStairsRequiresTool("green_stone_stairs", GREEN_STONE, GREEN_STONE);
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_STAIRS = registerStoneStairsRequiresTool("light_blue_stone_stairs", LIGHT_BLUE_STONE, LIGHT_BLUE_STONE);
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_STAIRS = registerStoneStairsRequiresTool("light_blue1_stone_stairs", LIGHT_BLUE1_STONE, LIGHT_BLUE1_STONE);
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_STAIRS = registerStoneStairsRequiresTool("light_gray_stone_stairs", LIGHT_GRAY_STONE, LIGHT_GRAY_STONE);
    public static final RegistryObject<Block> LIME_STONE_STAIRS = registerStoneStairsRequiresTool("lime_stone_stairs", LIME_STONE, LIME_STONE);
    public static final RegistryObject<Block> MAGENTA_STONE_STAIRS = registerStoneStairsRequiresTool("magenta_stone_stairs", MAGENTA_STONE, MAGENTA_STONE);
    public static final RegistryObject<Block> ORANGE_STONE_STAIRS = registerStoneStairsRequiresTool("orange_stone_stairs", ORANGE_STONE, ORANGE_STONE);
    public static final RegistryObject<Block> PINK_STONE_STAIRS = registerStoneStairsRequiresTool("pink_stone_stairs", PINK_STONE, PINK_STONE);
    public static final RegistryObject<Block> PURPLE_STONE_STAIRS = registerStoneStairsRequiresTool("purple_stone_stairs", PURPLE_STONE, PURPLE_STONE);
    public static final RegistryObject<Block> RED_STONE_STAIRS = registerStoneStairsRequiresTool("red_stone_stairs", RED_STONE, RED_STONE);
    public static final RegistryObject<Block> WHITE_STONE_STAIRS = registerStoneStairsRequiresTool("white_stone_stairs", WHITE_STONE, WHITE_STONE);
    public static final RegistryObject<Block> YELLOW_STONE_STAIRS = registerStoneStairsRequiresTool("yellow_stone_stairs", YELLOW_STONE, YELLOW_STONE);
    public static final RegistryObject<Block> FREIN_BLOCK = BLOCKS.register("frein_block", () -> new FreinBlock(Block.Properties.create(Material.CLAY).slipperiness(0.8F).sound(SoundType.SLIME).zeroHardnessAndResistance().notSolid().jumpFactor(6)));
    public static final RegistryObject<Block> GANK_BLOCK = BLOCKS.register("gank_block", () -> new GankBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(990.0F)));
    public static final RegistryObject<Block> GANK_STAIRS = BLOCKS.register("gank_stairs", () -> new GankStairs(() -> GANK_BLOCK.get().getDefaultState(), Block.Properties.from(GANK_BLOCK.get())));
    public static final RegistryObject<Block> FIRG_PRESSURE_PLATE = BLOCKS.register("firg_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.from(OAK_PRESSURE_PLATE).doesNotBlockMovement().harvestTool(ToolType.AXE).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FIRG_PLANKS_SLAB = BLOCKS.register("firg_planks_slab", () -> new FirgPlanksSlab(Block.Properties.create(Material.ORGANIC).harvestTool(ToolType.AXE).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FRIM_SLAB = BLOCKS.register("frim_planks_slab", () -> new FrimSlab(Block.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FRIM_PLANKS = BLOCKS.register("frim_planks", () -> new FrimPlanks(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FRIM_STAIRS = BLOCKS.register("frim_planks_stairs", () -> new FrimStairs(() -> FRIM_PLANKS.get().getDefaultState(), Block.Properties.from(FRIM_PLANKS.get())));
    public static final RegistryObject<Block> FRIM_PLANKS_DOOR = BLOCKS.register("frim_planks_door", FrimPlanksDoor::new);
    public static final RegistryObject<Block> GANK_SLAB = BLOCKS.register("gank_slab", () -> new GankSlab(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(990.0F, 1000.0F)));
    public static final RegistryObject<Block> ENDER_TRASK_1 = BLOCKS.register("ender_trask_1", () -> new EnderTrask1(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(6).hardnessAndResistance(160.0f)));
    public static final RegistryObject<Block> ENDER_TRASKCRAFTH_1 = BLOCKS.register("ender_traskcrafth_1", () -> new EnderTraskcrafth(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(5).hardnessAndResistance(100.0f)));
    public static final RegistryObject<Block> DURT = registerRequiresTool("durt/durt", Material.ROCK, 2, ToolType.PICKAXE, 30.0f, 440.0f);
    public static final RegistryObject<Block> DURTGURBF = registerRequiresTool("durt/gurbf", Material.ROCK, 2, ToolType.PICKAXE, 22.0f, 400.0f);
    public static final RegistryObject<Block> GRITK_BLOCK_1 = BLOCKS.register("gritk_block_1", () -> new GritkBlock1(Block.Properties.create(Material.IRON).setRequiresTool().harvestLevel(0).setLightLevel(Value -> 15).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500000.0F, 1200000.0F)));
    public static final RegistryObject<Block> FRIM_SAPLING = BLOCKS.register("frim_sapling", () -> new ModSaplingBlock(FrimTree::new, AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> LEAVES = BLOCKS.register("leaves", () -> new Leaves(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> FRIM_LEAVES = BLOCKS.register("frim_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> ZURK_SLAB = BLOCKS.register("zurk_slab", () -> new ZurkSlab(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(200.0F, 210.0F)));
    public static final RegistryObject<Block> ENDER_TRASKRACH_1 = BLOCKS.register("ender_traskrach_1", () -> new EnderTraskrach(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(4).hardnessAndResistance(80.0f)));
    public static final RegistryObject<Block> GRINTH_MUSHROOM = BLOCKS.register("grinth_mushroom", () -> new GrinthMushroom(Block.Properties.create(Material.PLANTS).zeroHardnessAndResistance().doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).setLightLevel(Value -> 1)));
    public static final RegistryObject<Block> RED_GRASS_BLOCK = BLOCKS.register("red_grass_block", () -> new RedGrassBlock(Block.Properties.create(Material.EARTH).tickRandomly().hardnessAndResistance(0.6F).sound(SoundType.PLANT)));
    public static final RegistryObject<Block> GRINTH_MUSHROOM_BLOCK = registerRequiresTool("grinth_mushroom_block", Material.WOOD, MaterialColor.GREEN, 0.2F, SoundType.WOOD);
    public static final RegistryObject<Block> BLACK_IRON_BLOCK = registerRequiresTool("iron_block/black_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> BLUE_IRON_BLOCK = registerRequiresTool("iron_block/blue_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> BROWN_IRON_BLOCK = registerRequiresTool("iron_block/brown_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> CYAN_IRON_BLOCK = registerRequiresTool("iron_block/cyan_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> GRAY_IRON_BLOCK = registerRequiresTool("iron_block/gray_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> GREEN_IRON_BLOCK = registerRequiresTool("iron_block/green_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> LIGHT_BLUE_IRON_BLOCK = registerRequiresTool("iron_block/light_blue_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> LIGHT_BLUE1_IRON_BLOCK = registerRequiresTool("iron_block/light_blue1_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> LIGHT_GRAY_IRON_BLOCK = registerRequiresTool("iron_block/light_gray_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> LIME_IRON_BLOCK = registerRequiresTool("iron_block/lime_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> MAGENTA_IRON_BLOCK = registerRequiresTool("iron_block/magenta_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> ORANGE_IRON_BLOCK = registerRequiresTool("iron_block/orange_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> PINK_IRON_BLOCK = registerRequiresTool("iron_block/pink_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> PURPLE_IRON_BLOCK = registerRequiresTool("iron_block/purple_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> RED_IRON_BLOCK = registerRequiresTool("iron_block/red_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> YELLOW_IRON_BLOCK = registerRequiresTool("iron_block/yellow_iron_block", Material.IRON, MaterialColor.IRON, 5.0F, 6.0F, SoundType.METAL);
    public static final RegistryObject<Block> BLACK_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/black_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_BLUE_IRON_ORE = BLOCKS.register("iron_ores/black_stone/blue_iron_ore", () -> new BlueIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_BROWN_IRON_ORE = BLOCKS.register("iron_ores/black_stone/brown_iron_ore", () -> new BrownIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_CYAN_IRON_ORE = BLOCKS.register("iron_ores/black_stone/cyan_iron_ore", () -> new CyanIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_GRAY_IRON_ORE = BLOCKS.register("iron_ores/black_stone/gray_iron_ore", () -> new GrayIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_GREEN_IRON_ORE = BLOCKS.register("iron_ores/black_stone/green_iron_ore", () -> new GreenIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_IRON_ORE = BLOCKS.register("iron_ores/black_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_LIGHT_BLUE1_IRON_ORE = BLOCKS.register("iron_ores/black_stone/light_blue1_iron_ore", () -> new LightBlue1IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_LIGHT_BLUE_IRON_ORE = BLOCKS.register("iron_ores/black_stone/light_blue_iron_ore", () -> new LightBlueIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_LIGHT_GRAY_IRON_ORE = BLOCKS.register("iron_ores/black_stone/light_gray_iron_ore", () -> new LightGrayIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_LIME_IRON_ORE = BLOCKS.register("iron_ores/black_stone/lime_iron_ore", () -> new LimeIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_MAGENTA_IRON_ORE = BLOCKS.register("iron_ores/black_stone/magenta_iron_ore", () -> new MagentaIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_ORANGE_IRON_ORE = BLOCKS.register("iron_ores/black_stone/orange_iron_ore", () -> new OrangeIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_PINK_IRON_ORE = BLOCKS.register("iron_ores/black_stone/pink_iron_ore", () -> new PinkIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_PURPLE_IRON_ORE = BLOCKS.register("iron_ores/black_stone/purple_iron_ore", () -> new PurpleIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_RED_IRON_ORE = BLOCKS.register("iron_ores/black_stone/red_iron_ore", () -> new RedIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLACK_STONE_YELLOW_IRON_ORE = BLOCKS.register("iron_ores/black_stone/yellow_iron_ore", () -> new YellowIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLUE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/blue_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLUE_STONE_BLUE_IRON_ORE = BLOCKS.register("iron_ores/blue_stone/blue_iron_ore", () -> new BlueIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BROWN_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/brown_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> CYAN_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/cyan_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GREEN_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/green_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/light_blue_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/light_blue1_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/light_gray_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LIME_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/lime_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> MAGENTA_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/magenta_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ORANGE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/orange_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> PINK_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/pink_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> PURPLE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/purple_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RED_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/red_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> WHITE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/white_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> YELLOW_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/yellow_stone/black_iron_ore", () -> new BlackIronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BLUE_STONE_IRON_ORE = BLOCKS.register("iron_ores/blue_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BROWN_STONE_IRON_ORE = BLOCKS.register("iron_ores/brown_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> CYAN_STONE_IRON_ORE = BLOCKS.register("iron_ores/cyan_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GREEN_STONE_IRON_ORE = BLOCKS.register("iron_ores/green_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_IRON_ORE = BLOCKS.register("iron_ores/light_blue_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_IRON_ORE = BLOCKS.register("iron_ores/light_blue1_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_IRON_ORE = BLOCKS.register("iron_ores/light_gray_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> LIME_STONE_IRON_ORE = BLOCKS.register("iron_ores/lime_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> MAGENTA_STONE_IRON_ORE = BLOCKS.register("iron_ores/magenta_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ORANGE_STONE_IRON_ORE = BLOCKS.register("iron_ores/orange_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> PINK_STONE_IRON_ORE = BLOCKS.register("iron_ores/pink_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> PURPLE_STONE_IRON_ORE = BLOCKS.register("iron_ores/purple_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RED_STONE_IRON_ORE = BLOCKS.register("iron_ores/red_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> WHITE_STONE_IRON_ORE = BLOCKS.register("iron_ores/white_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> YELLOW_STONE_IRON_ORE = BLOCKS.register("iron_ores/yellow_stone/iron_ore", () -> new IronOre(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(1).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> ACACIA_PLANKS1 = BLOCKS.register("acacia_planks1", () -> new AcaciaPlanks1(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_PLANKS1 = BLOCKS.register("birch_planks1", () -> new BirchPlanks1(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SAND).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_PLANKS1 = BLOCKS.register("dark_oak_planks1", () -> new DarkOakPlanks1(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_PLANKS1 = BLOCKS.register("jungle_planks1", () -> new JunglePlanks1(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OAK_PLANKS1 = BLOCKS.register("oak_planks1", () -> new OakPlanks1(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRUCE_PLANKS1 = BLOCKS.register("spruce_planks1", () -> new SprucePlanks1(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FIRG_PLANKS1 = BLOCKS.register("firg_planks1", () -> new FirgPlanks1(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FRIM_PLANKS1 = BLOCKS.register("frim_planks1", () -> new FrimPlanks1(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F, 3.0F).doesNotBlockMovement().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new OreBlock1(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(2).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BLACK_STONE_BRICKS = BLOCKS.register("stone/bricks/black_stone_bricks", () -> new BlackStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> BLUE_STONE_BRICKS = BLOCKS.register("stone/bricks/blue_stone_bricks", () -> new BlueStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> BROWN_STONE_BRICKS = BLOCKS.register("stone/bricks/brown_stone_bricks", () -> new BrownStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> CYAN_STONE_BRICKS = BLOCKS.register("stone/bricks/cyan_stone_bricks", () -> new CyanStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> GREEN_STONE_BRICKS = BLOCKS.register("stone/bricks/green_stone_bricks", () -> new GreenStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_BRICKS = BLOCKS.register("stone/bricks/light_blue1_stone_bricks", () -> new LightBlue1StoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_BRICKS = BLOCKS.register("stone/bricks/light_blue_stone_bricks", () -> new LightBlueStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_BRICKS = BLOCKS.register("stone/bricks/light_gray_stone_bricks", () -> new LightGrayStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> LIME_STONE_BRICKS = BLOCKS.register("stone/bricks/lime_stone_bricks", () -> new LimeStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> MAGENTA_STONE_BRICKS = BLOCKS.register("stone/bricks/magenta_stone_bricks", () -> new MagentaStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> ORANGE_STONE_BRICKS = BLOCKS.register("stone/bricks/orange_stone_bricks", () -> new OrangeStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> PINK_STONE_BRICKS = BLOCKS.register("stone/bricks/pink_stone_bricks", () -> new PinkStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> PURPLE_STONE_BRICKS = BLOCKS.register("stone/bricks/purple_stone_bricks", () -> new PurpleStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> RED_STONE_BRICKS = BLOCKS.register("stone/bricks/red_stone_bricks", () -> new RedStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> WHITE_STONE_BRICKS = BLOCKS.register("stone/bricks/white_stone_bricks", () -> new WhiteStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> YELLOW_STONE_BRICKS = BLOCKS.register("stone/bricks/yellow_stone_bricks", () -> new YellowStoneBricks(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F)));
    public static final RegistryObject<Block> BLACK_FURNACE = BLOCKS.register("furnaces/black_furnace", () -> new BlackFurnace(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> BLUE_FURNACE = BLOCKS.register("furnaces/blue_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> BROWN_FURNACE = BLOCKS.register("furnaces/brown_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> CYAN_FURNACE = BLOCKS.register("furnaces/cyan_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> GREEN_FURNACE = BLOCKS.register("furnaces/green_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> LIGHT_BLUE_FURNACE = BLOCKS.register("furnaces/light_blue_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> LIGHT_BLUE1_FURNACE = BLOCKS.register("furnaces/light_blue1_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> LIGHT_GRAY_FURNACE = BLOCKS.register("furnaces/light_gray_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> LIME_FURNACE = BLOCKS.register("furnaces/lime_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> MAGENTA_FURNACE = BLOCKS.register("furnaces/magenta_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> ORANGE_FURNACE = BLOCKS.register("furnaces/orange_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> PINK_FURNACE = BLOCKS.register("furnaces/pink_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> PURPLE_FURNACE = BLOCKS.register("furnaces/purple_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> RED_FURNACE = BLOCKS.register("furnaces/red_furnace", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> WHITE_FURNACE = BLOCKS.register("furnaces/white_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> YELLOW_FURNACE = BLOCKS.register("furnaces/yellow_furnace", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.5F).setLightLevel(Value -> 13)));
    public static final RegistryObject<Block> TRUMRUNT = BLOCKS.register("trumrunt", () -> new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.LIGHT_BLUE).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F).setLightLevel(Value -> 15)));

    private static RotatedPillarBlock createLogBlock(Material material, MaterialColor topColor, MaterialColor barkColor, int hardnessAndResistance, SoundType soundType) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(material, (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).hardnessAndResistance(hardnessAndResistance).sound(soundType));
    }

    private static RotatedPillarBlock createLogBlock(Material material, MaterialColor topColor, MaterialColor barkColor, int hardnessAndResistance, SoundInit soundInit) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(material, (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).hardnessAndResistance(hardnessAndResistance).sound(soundInit));
    }

    private static RotatedPillarBlock createLogBlock(Material material, MaterialColor topColor, MaterialColor barkColor, int hardness, int resistance, SoundType soundType) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(material, (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).hardnessAndResistance(hardness, resistance).sound(soundType));
    }

    private static RotatedPillarBlock createLogBlock(Material material, MaterialColor topColor, MaterialColor barkColor, int hardness, int resistance, SoundInit soundInit) {
        return new RotatedPillarBlock(AbstractBlock.Properties.create(material, (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor).hardnessAndResistance(hardness, resistance).sound(soundInit));
    }

    private static AbstractBlock.Properties create_LogBlock(MaterialColor topColor, MaterialColor barkColor, AbstractBlock.Properties properties) {
        return AbstractBlock.Properties.create(Material.WOOD, (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor);
    }

    private static AbstractBlock.Properties createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
        return AbstractBlock.Properties.create(Material.WOOD, (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor);
    }

    private static AbstractBlock.Properties createLogBlock(Material material, MaterialColor topColor, MaterialColor barkColor, AbstractBlock.Properties properties) {
        return AbstractBlock.Properties.create(material, (p_235431_2_) -> p_235431_2_.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor);
    }

    public static RegistryObject<Block> register(String name, Material material, MaterialColor materialColor, float hardnessIn, float resistanceIn, ToolType harvestTool, SoundType soundTypeIn) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material, materialColor).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(soundTypeIn)));
    }

    public static RegistryObject<Block> register(String name, Material material, MaterialColor materialColor, float hardnessIn, float resistanceIn, int lightValue) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material, materialColor).hardnessAndResistance(hardnessIn, resistanceIn).setLightLevel((Value) -> lightValue)));
    }

    public static RegistryObject<Block> register(String name, Material material, MaterialColor materialColor, float hardnessAndResistance, ToolType harvestTool, SoundType soundTypeIn) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material, materialColor).hardnessAndResistance(hardnessAndResistance).harvestTool(harvestTool).sound(soundTypeIn)));
    }

    public static RegistryObject<Block> register(String name, Material material, float hardnessIn, float resistanceIn, SoundType soundTypeIn) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).hardnessAndResistance(hardnessIn, resistanceIn).sound(soundTypeIn)));
    }

    public static RegistryObject<Block> register(String name, Material material, int harvestLevel, ToolType harvestTool, float hardnessAndResistance) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).harvestLevel(harvestLevel).harvestTool(harvestTool).hardnessAndResistance(hardnessAndResistance)));
    }

    public static RegistryObject<Block> register(String name, Material material, float hardnessAndResistance, SoundType soundTypeIn) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).hardnessAndResistance(hardnessAndResistance).sound(soundTypeIn)));
    }

    public static RegistryObject<Block> registerLightValue(String name, Material material, MaterialColor materialColor, float hardnessIn, float resistanceIn, int lightValue) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material, materialColor).hardnessAndResistance(hardnessIn, resistanceIn).setLightLevel((Value) -> lightValue)));
    }

    public static RegistryObject<Block> registerLightValue(String name, Material material, MaterialColor materialColor, float hardnessAndResistance, int lightValue) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material, materialColor).hardnessAndResistance(hardnessAndResistance, hardnessAndResistance).setLightLevel((Value) -> lightValue)));
    }

    public static RegistryObject<Block> register(String name, Material material) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material)));
    }

    public static RegistryObject<Block> registerIM(String name, Material material) {
        return BLOCKS.register(name, () -> new IM(AbstractBlock.Properties.create(material)));
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, int harvestLevel, ToolType harvestTool, float hardnessAndResistance) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).harvestTool(harvestTool).hardnessAndResistance(hardnessAndResistance, hardnessAndResistance)));
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, int harvestLevel, ToolType harvestTool, float hardnessAndResistance, SoundType sound) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).harvestTool(harvestTool).hardnessAndResistance(hardnessAndResistance, hardnessAndResistance).sound(sound)));
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, int harvestLevel, float hardnessAndRsistance) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessAndRsistance, hardnessAndRsistance)));
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, int harvestLevel, ToolType harvestTool, float hardnessIn, float resistanceIn) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).harvestTool(harvestTool).hardnessAndResistance(hardnessIn, resistanceIn)));
    }

    public static RegistryObject<Block> registerBlock(String name, AbstractBlock.Properties properties) {
        return BLOCKS.register(name, () -> new Block(properties));
    }

    public static RegistryObject<Block> registerGrirzt() {
        return BLOCKS.register("grirzt", () -> new Grirzt<>(AbstractBlock.Properties.create(Material.SPONGE).setRequiresTool().harvestLevel(17).harvestTool(ToolType.PICKAXE).hardnessAndResistance(160.0f)));
    }

    public static RegistryObject<Block> registerOreBlock(String name, Material material, int harvestLevel, ToolType harvestTool, float hardnessAndResistance, int minimumExp, int maximumExp) {
        return BLOCKS.register(name, () -> new Block(Block.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).harvestTool(harvestTool).hardnessAndResistance(hardnessAndResistance)) {

            public int getExperience(Random rand, Block oreBlock, int minimumExp, int maximumExp) {
                if (this == oreBlock) {
                    return MathHelper.nextInt(rand, minimumExp, maximumExp);
                } else {
                    return 0;
                }
            }

            public void spawnAdditionalDrops(BlockState state, World worldIn, BlockPos pos, ItemStack stack) {
                super.spawnAdditionalDrops(state, worldIn, pos, stack);
            }

            @Override
            public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
                return silktouch == 0 ? this.getExperience(RANDOM, this, minimumExp, maximumExp) : 0;
            }
        });
    }

    public static RegistryObject<Block> registerCobblestoneRequiresTool(String name) {
        return registerRequiresTool("stone/cobblestones/" + name, Material.ROCK, 0, ToolType.PICKAXE, 2.0F, 6.0F);
    }

    public static RegistryObject<Block> registerSlabRequiresTool(String name, Material material, int harvestLevel, ToolType harvestTool, float hardnessIn, float resistanceIn) {
        return BLOCKS.register(name, () -> new SlabBlock(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).harvestTool(harvestTool).hardnessAndResistance(hardnessIn, resistanceIn)));
    }

    public static RegistryObject<Block> registerStairsRequiresTool(String name, BlockState blockState, AbstractBlock abstractBlock) {
        return BLOCKS.register(name, () -> new StairsBlock(blockState, AbstractBlock.Properties.from(abstractBlock)));
    }

    public static RegistryObject<Block> register_StairsRequiresTool(String name, Supplier<BlockState> blockStateSupplier, Supplier<AbstractBlock.Properties> propertiesSupplier) {
        return BLOCKS.register(name, () -> new StairsBlock(blockStateSupplier.get(), propertiesSupplier.get()));
    }

    public static RegistryObject<Block> registerStoneRequiresTool(String name) {
        return registerRequiresTool("stone/stones/" + name, Material.ROCK, 0, ToolType.PICKAXE, 1.5F, 6.0F);
    }

    public static RegistryObject<Block> registerStoneSlabRequiresTool(String name) {
        return registerSlabRequiresTool("stone/slabs/" + name, Material.ROCK, 0, ToolType.PICKAXE, 2.0F, 6.0F);
    }

    public static RegistryObject<Block> registerStoneStairsRequiresTool(String name, Supplier<Block> blockState, Supplier<Block> block) {
        return registerStairsRequiresTool("stone/stairs" + name, blockState.get().getDefaultState(), block.get());
    }

    public static RegistryObject<Block> registerCobblestoneStairsRequiresTool(String name, Supplier<Block> blockState, Supplier<Block> block) {
        return registerStairsRequiresTool("stone/cobblestone/stairs/" + name, blockState.get().getDefaultState(), block.get());
    }

    public static RegistryObject<Block> registerStairsRequiresTool(String name, Supplier<Block> blockState, Supplier<Block> block) {
        return registerStairsRequiresTool(name, blockState.get().getDefaultState(), block.get());
    }

    public static RegistryObject<Block> registerSmoothStoneStairsRequiresTool(String name, Supplier<Block> blockState, Supplier<Block> block) {
        return registerStairsRequiresTool("stone/smoooth_stone/stairs/" + name, blockState.get().getDefaultState(), block.get());
    }

    public static RegistryObject<Block> registerSmoothStoneRequiresTool(String name) {
        return registerRequiresTool("stone/smooth_stones/" + name, Material.ROCK, 0, ToolType.PICKAXE, 1.5F, 6.0F);
    }

    public static RegistryObject<Block> registerSmoothStoneSlabRequiresTool(String name) {
        return registerSlabRequiresTool("stone/smooth_stone/slabs/" + name, Material.ROCK, 0, ToolType.PICKAXE, 2.0F, 6.0F);
    }

    public static RegistryObject<Block> registerCobblestoneSlabRequiresTool(String name) {
        return registerSlabRequiresTool("stone/cobblestone/slabs/" + name, Material.ROCK, 0, ToolType.PICKAXE, 2.0F, 6.0F);
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, int harvestLevel, ToolType harvestTool, float hardnessIn, float resistanceIn, SoundType sound) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).harvestTool(harvestTool).hardnessAndResistance(hardnessIn, resistanceIn).sound(sound)));
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, int harvestLevel, float hardnessIn, float resistanceIn) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn)));
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, ToolType harvestTool, float hardnessAndResistance) {
        return registerRequiresTool(name, material, harvestTool, hardnessAndResistance, hardnessAndResistance);
    }

    public static RegistryObject<Block> registerRequiresToolLightValue(String name, Material material, float hardnessAndResistance, int lightValue) {
        return registerRequiresToolLightValue(name, material, hardnessAndResistance, hardnessAndResistance, lightValue);
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, ToolType harvestTool, float hardnessIn, float resistanceIn) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestTool(harvestTool).hardnessAndResistance(hardnessIn, resistanceIn)));
    }

    public static RegistryObject<Block> registerRequiresToolLightValue(String name, Material material, float hardnessIn, float resistanceIn, int lightValue) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).setRequiresTool().hardnessAndResistance(hardnessIn, resistanceIn).setLightLevel((Value) -> lightValue)));
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, MaterialColor materialColor, float hardnessAndResistance, SoundType sound) {
        return registerRequiresTool(name, material, materialColor, hardnessAndResistance, hardnessAndResistance, sound);
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, MaterialColor materialColor, float hardnessIn, float resistanceIn, SoundType sound) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material, materialColor).setRequiresTool().hardnessAndResistance(hardnessIn, resistanceIn).sound(sound)));
    }

    public static RegistryObject<Block> registerBurningBlock(String name, AbstractBlock.Properties properties) {
        return BLOCKS.register(name, () -> new Block(properties) {
            @Override
            public boolean isBurning(BlockState state, IBlockReader world, BlockPos pos) {
                return super.isBurning(state, world, pos);
            }
        });
    }

    public static RegistryObject<Block> registerBurningBlock(String name, Material material) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material)) {
            @Override
            public boolean isBurning(BlockState state, IBlockReader world, BlockPos pos) {
                return super.isBurning(state, world, pos);
            }
        });
    }

    public static RegistryObject<Block> registerBurningBlockRequiresTool(String name, AbstractBlock.Properties properties) {
        return registerBurningBlock(name, properties.setRequiresTool());
    }

    public static RegistryObject<Block> registerBurningBlockRequiresTool(String name, Material material) {
        return registerBurningBlockRequiresTool(name, AbstractBlock.Properties.create(material));
    }

    public static AbstractBlock.Properties blockRegister(Material material, MaterialColor materialColor, float hardnessIn, float resistanceIn, ToolType harvestTool, SoundType soundTypeIn) {
        return AbstractBlock.Properties.create(material, materialColor).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(soundTypeIn);
    }

    public static AbstractBlock.Properties blockRegister(Material material, MaterialColor materialColor, float hardnessAndResistance, ToolType harvestTool, SoundType soundTypeIn) {
        return AbstractBlock.Properties.create(material, materialColor).hardnessAndResistance(hardnessAndResistance).harvestTool(harvestTool).sound(soundTypeIn);
    }

    public static AbstractBlock.Properties blockRegister(Material material, float hardnessIn, float resistanceIn, SoundType soundTypeIn) {
        return AbstractBlock.Properties.create(material).hardnessAndResistance(hardnessIn, resistanceIn).sound(soundTypeIn);
    }

    public static AbstractBlock.Properties blockRegister(Material material, float hardnessAndResistance, SoundType soundTypeIn) {
        return AbstractBlock.Properties.create(material).hardnessAndResistance(hardnessAndResistance).sound(soundTypeIn);
    }

    public static void blockRegister(Material material, float hardnessIn, float resistanceIn, ToolType harvestTool, SoundType soundTypeIn) {
        AbstractBlock.Properties.create(material).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(soundTypeIn);
    }

    public static void blockRegister(Material material, float hardnessAndResistance, ToolType harvestTool, SoundType soundTypeIn) {
        AbstractBlock.Properties.create(material).hardnessAndResistance(hardnessAndResistance).harvestTool(harvestTool).sound(soundTypeIn);
    }

    public static void rotatedPillarBlockregister(String name, Material material, MaterialColor materialColor, float hardnessIn, float resistanceIn, ToolType harvestTool, SoundType soundTypeIn) {
        BLOCKS.register(name, () -> new RotatedPillarBlock(AbstractBlock.Properties.create(material, materialColor).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(soundTypeIn)));
    }

    public static void rotatedPillarBlockregister(String name, Material material, MaterialColor materialColor, float hardnessAndResistance, ToolType harvestTool, SoundType soundTypeIn) {
        BLOCKS.register(name, () -> new RotatedPillarBlock(AbstractBlock.Properties.create(material, materialColor).hardnessAndResistance(hardnessAndResistance).harvestTool(harvestTool).sound(soundTypeIn)));
    }

    public static class Axe_Item extends AxeItem {
        public Axe_Item(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
            super(tier, attackDamageIn, attackSpeedIn, builder);
        }

        public static void block() {
            BLOCK_STRIPPING_MAP.put(BlockInit.FIRG_LOG, BlockInit.STRIPPED_FIRG_LOG);
            BLOCK_STRIPPING_MAP.put(BlockInit.FIRG_WOOD, BlockInit.STRIPPED_FIRG_WOOD);
            BLOCK_STRIPPING_MAP.put(BlockInit.FRIM_LOG, BlockInit.STRIPPED_FRIM_LOG);
            BLOCK_STRIPPING_MAP.put(BlockInit.FRIM_WOOD, BlockInit.STRIPPED_FRIM_WOOD);
        }
    }

    public static class IM<T> extends ModBlock {
        public Supplier<BlockState> defaultState;

        public IM(Properties properties) {
            super(properties);
        }

        public IM(String name, Material material, int harvestLevel, ToolType harvestTool, float hardnessAndResistance) {
            super(name, material, harvestLevel, harvestTool, hardnessAndResistance);
        }

        public final Supplier<BlockState> getSupplierDefaultState() {
            return defaultState;
        }
    }
}
