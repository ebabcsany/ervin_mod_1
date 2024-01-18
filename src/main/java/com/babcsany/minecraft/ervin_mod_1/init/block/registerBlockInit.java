package com.babcsany.minecraft.ervin_mod_1.init.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.Fighiv;
import com.babcsany.minecraft.ervin_mod_1.block.PoweredRailBlock;
import com.babcsany.minecraft.ervin_mod_1.block.TargCropsBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.slabs.TragkSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.stairs.TragkStairs;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.slabs.CoalSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.slabs.CharcoalSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.slabs.ZunkSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.stairs.CharcoalStairs;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.stairs.ZunkStairs;
import com.babcsany.minecraft.ervin_mod_1.block.special.Thufr;
import com.babcsany.minecraft.ervin_mod_1.block.stone.cobblestone.stairs.StairsBlock;
import com.babcsany.minecraft.ervin_mod_1.block.tripwires.TripWireBlock;
import com.babcsany.minecraft.ervin_mod_1.block.tripwires.tripwire_hooks.TripWireHookBlock;
import com.babcsany.minecraft.ervin_mod_1.world.feature.JazzTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModSaplingBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.Tree;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static net.minecraft.block.Blocks.OAK_SAPLING;

public class registerBlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<Block> FRISZERN = BLOCKS.register("friszern", () -> new Friszern(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    //public static final RegistryObject<Block> CHAIN_FRISZERN = BLOCKS.register("chain_friszern", () -> new Friszern(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    //public static final RegistryObject<Block> REPEATING_FRISZERN = BLOCKS.register("repeater_friszern", () -> new Friszern(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final RegistryObject<Block> EXAMPLE_PORTAL_BLOCK = BLOCKS.register("example_portal_block", () -> new Block(AbstractBlock.Properties.from(Blocks.BEDROCK)));
    public static final RegistryObject<Block> TARG_STAGE = BLOCKS.register("crops/targ_stage", () -> new TargCropsBlock(Block.Properties.create(Material.PLANTS).zeroHardnessAndResistance().doesNotBlockMovement().tickRandomly().sound(SoundType.CROP)));
    public static final RegistryObject<Block> JAZZ_SAPLING = registerModSapling("jazz_sapling", JazzTree::new, OAK_SAPLING);
    public static final RegistryObject<Block> FIRG = BLOCKS.register("firg", () -> new Firg(Block.Properties.create(Material.ROCK).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0f)));
    public static final RegistryObject<Block> FIRG_SLAB = BLOCKS.register("firg_slab", () -> new FirgSlab(Block.Properties.create(Material.ROCK).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0F, 15.0F)));
    public static final RegistryObject<Block> FIRG_STAIRS = BLOCKS.register("firg_stairs", () -> new FirgStairs(() -> FIRG.get().getDefaultState(), Block.Properties.from(FIRG.get())));
    public static final RegistryObject<Block> ENDER_SRACKHT = BLOCKS.register("ender_srackht", () -> new EnderSrackht(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(20.0f)));
    public static final RegistryObject<Block> ENDER_STAKRACH = BLOCKS.register("ender_stakrach", () -> new EnderStakrach(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(2).harvestTool(ToolType.AXE).hardnessAndResistance(40.0f)));
    public static final RegistryObject<Block> ENDER_SRAKTCAF = BLOCKS.register("ender_sraktcaf", () -> new EnderSraktcaf(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(3).harvestTool(ToolType.SHOVEL).hardnessAndResistance(60.0f)));
    public static final RegistryObject<Block> ENDER_TRASKRACH = BLOCKS.register("ender_traskrach", () -> new EnderTraskrach(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(4).hardnessAndResistance(80.0f)));
    public static final RegistryObject<Block> ENDER_TRASKCRAFTH = BLOCKS.register("ender_traskcrafth", () -> new EnderTraskcrafth(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(5).hardnessAndResistance(100.0f)));
    public static final RegistryObject<Block> VIRK_BLOCK = BLOCKS.register("virk_block", () -> new VirkBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(5).harvestTool(ToolType.PICKAXE).hardnessAndResistance(650.0f)));
    //public static final RegistryObject<Block> JURK = BLOCKS.register("jurk", () -> new Block(AbstractBlock.Properties.create(MaterialInit.JURK).doesNotBlockMovement().tickRandomly().hardnessAndResistance(100.0F).setLightLevel(Value -> 4)));
    public static final RegistryObject<Block> TERAT_BLOCK = BLOCKS.register("terat_block", () -> new TeratBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(32).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000.0f)));
    public static final RegistryObject<Block> GRITH_BLOCK = BLOCKS.register("grith_block", () -> new GrithBlock(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).setRequiresTool().harvestLevel(80).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000000000.0F).setLightLevel(Value -> 15)));
    public static final RegistryObject<Block> GRITH_SLAB = BLOCKS.register("grith_slab", () -> new GrithSlab(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).setRequiresTool().harvestLevel(78).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000000000.0F,500000000000000.0F).setLightLevel(Value -> 15)));
    public static final RegistryObject<Block> GRITH_STAIRS = BLOCKS.register("grith_stairs", () -> new GrithStairs(() -> GRITH_BLOCK.get().getDefaultState(), Block.Properties.from(GRITH_BLOCK.get())));
    public static final RegistryObject<Block> ZUNK_BLOCK = BLOCKS.register("zunk_block", () -> new ZunkBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(40.0F)));
    public static final RegistryObject<Block> ZUNK_SLAB = BLOCKS.register("zunk_slab", () -> new ZunkSlab(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.SHOVEL).hardnessAndResistance(30.0F, 50.0F)));
    public static final RegistryObject<Block> ZUNK_STAIRS = BLOCKS.register("zunk_stairs", () -> new ZunkStairs(() -> ZUNK_BLOCK.get().getDefaultState(), Block.Properties.from(ZUNK_BLOCK.get())));
    public static final RegistryObject<Block> TNUZK_BLOCK = BLOCKS.register("tnuzk_block", () -> new TnuzkBlock(Block.Properties.create(Material.EARTH).setRequiresTool().harvestLevel(15).harvestTool(ToolType.SHOVEL).hardnessAndResistance(100000.0F)));
    public static final RegistryObject<Block> TNUZN = BLOCKS.register("tnuzn", () -> new Block(Block.Properties.create(Material.EARTH).setRequiresTool().harvestLevel(18).harvestTool(ToolType.SHOVEL).hardnessAndResistance(20000000.0f)));
    public static final RegistryObject<Block> FIGHIV = BLOCKS.register("fighiv", () -> new Fighiv(Block.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5F, 1000000000000.0F)));
    public static final RegistryObject<Block> GNRTHIRJ = BLOCKS.register("gnrthirj", () -> new BubbleColumnBlock(AbstractBlock.Properties.create(Material.BUBBLE_COLUMN).doesNotBlockMovement().noDrops()));
    public static final RegistryObject<TripWireHookBlock> BLACK_TRIPWIRE_HOOK = registerColoredTripWireHook("black");
    public static final RegistryObject<TripWireHookBlock> BLUE_TRIPWIRE_HOOK = registerColoredTripWireHook("blue");
    public static final RegistryObject<TripWireHookBlock> BROWN_TRIPWIRE_HOOK = registerColoredTripWireHook("brown");
    public static final RegistryObject<TripWireHookBlock> CYAN_TRIPWIRE_HOOK = registerColoredTripWireHook("cyan");
    public static final RegistryObject<TripWireHookBlock> GRAY_TRIPWIRE_HOOK = registerColoredTripWireHook("gray");
    public static final RegistryObject<TripWireHookBlock> GREEN_TRIPWIRE_HOOK = registerColoredTripWireHook("green");
    public static final RegistryObject<TripWireHookBlock> LIGHT_BLUE_TRIPWIRE_HOOK = registerColoredTripWireHook("light_blue");
    public static final RegistryObject<TripWireHookBlock> LIGHT_BLUE1_TRIPWIRE_HOOK = registerColoredTripWireHook("light_blue1");
    public static final RegistryObject<TripWireHookBlock> LIGHT_GRAY_TRIPWIRE_HOOK = registerColoredTripWireHook("light_gray");
    public static final RegistryObject<TripWireHookBlock> LIME_TRIPWIRE_HOOK = registerColoredTripWireHook("lime");
    public static final RegistryObject<TripWireHookBlock> MAGENTA_TRIPWIRE_HOOK = registerColoredTripWireHook("magenta");
    public static final RegistryObject<TripWireHookBlock> ORANGE_TRIPWIRE_HOOK = registerColoredTripWireHook("orange");
    public static final RegistryObject<TripWireHookBlock> PINK_TRIPWIRE_HOOK = registerColoredTripWireHook("pink");
    public static final RegistryObject<TripWireHookBlock> PURPLE_TRIPWIRE_HOOK = registerColoredTripWireHook("purple");
    public static final RegistryObject<TripWireHookBlock> RED_TRIPWIRE_HOOK = registerColoredTripWireHook("red");
    public static final RegistryObject<TripWireHookBlock> YELLOW_TRIPWIRE_HOOK = registerColoredTripWireHook("yellow");
    public static final RegistryObject<TripWireBlock> BLACK_TRIPWIRE = registerColoredTripWire("black", BLACK_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> BLUE_TRIPWIRE = registerColoredTripWire("blue", BLUE_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> BROWN_TRIPWIRE = registerColoredTripWire("brown", BROWN_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> CYAN_TRIPWIRE = registerColoredTripWire("cyan", CYAN_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> GRAY_TRIPWIRE = registerColoredTripWire("gray", GRAY_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> GREEN_TRIPWIRE = registerColoredTripWire("green", GREEN_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> LIGHT_BLUE_TRIPWIRE = registerColoredTripWire("light_blue", LIGHT_BLUE_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> LIGHT_BLUE1_TRIPWIRE = registerColoredTripWire("light_blue1", LIGHT_BLUE1_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> LIGHT_GRAY_TRIPWIRE = registerColoredTripWire("light_gray", LIGHT_GRAY_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> LIME_TRIPWIRE = registerColoredTripWire("lime", LIME_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> MAGENTA_TRIPWIRE = registerColoredTripWire("magenta", MAGENTA_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> ORANGE_TRIPWIRE = registerColoredTripWire("orange", ORANGE_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> PINK_TRIPWIRE = registerColoredTripWire("pink", PINK_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> PURPLE_TRIPWIRE = registerColoredTripWire("purple", PURPLE_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> RED_TRIPWIRE = registerColoredTripWire("red", RED_TRIPWIRE_HOOK);
    public static final RegistryObject<TripWireBlock> YELLOW_TRIPWIRE = registerColoredTripWire("yellow", YELLOW_TRIPWIRE_HOOK);
    public static final RegistryObject<Block> GRINT_BLOCK = BLOCKS.register("grint_block", () -> new GrintBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(100.0f)));
    public static final RegistryObject<Block> GRINT_SLAB = BLOCKS.register("grint_slab", () -> new GrintSlab(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(120.0f)));
    public static final RegistryObject<Block> GRINT_STAIRS = BLOCKS.register("grint_stairs", () -> new GrintStairs(() -> GRINT_BLOCK.get().getDefaultState(), Block.Properties.from(GRINT_BLOCK.get())));
    public static final RegistryObject<Block> THUIRTH_RAIL = BLOCKS.register("thuirth_rail", () -> new PoweredRailBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(436.5F).sound(SoundType.METAL), true));
    public static final RegistryObject<Block> THUFR = BLOCKS.register("special/thufr", () -> new Thufr(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).harvestLevel(138).hardnessAndResistance(3690527310400000000.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHARCOAL_BLOCK = BLOCKS.register("charcoal_block", () -> new CharcoalBlock(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5.0F, 6.0F)));
    public static final RegistryObject<Block> COAL_SLAB = BLOCKS.register("coal_slab", () -> new CoalSlab(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> CHARCOAL_SLAB = BLOCKS.register("charcoal_slab", () -> new CharcoalSlab(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> CHARCOAL_STAIRS = BLOCKS.register("charcoal_stairs", () -> new CharcoalStairs(() -> CHARCOAL_BLOCK.get().getDefaultState(), Block.Properties.from(CHARCOAL_BLOCK.get())));
    public static final RegistryObject<Block> TRAGN = BLOCKS.register("tragn", () -> new Tragn(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(36).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000.0f)));
    public static final RegistryObject<Block> TRAGK_BLOCK = BLOCKS.register("tragk_block", () -> new TragkBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(26).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5000000.0f)));
    public static final RegistryObject<Block> TRAGK_SLAB = BLOCKS.register("tragk_slab", () -> new TragkSlab(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(24).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2500000.0f)));
    public static final RegistryObject<Block> TRAGK_STAIRS = BLOCKS.register("tragk_stairs", () -> new TragkStairs(() -> TRAGK_BLOCK.get().getDefaultState(), Block.Properties.from(TRAGK_BLOCK.get())));
    public static final RegistryObject<Block> GARK_BLOCK = BLOCKS.register("gark_block", () -> new GarkBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(12).hardnessAndResistance(2000.0f)));
    public static final RegistryObject<Block> GARK_SLAB = BLOCKS.register("gark_slab", () -> new GarkSlab(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(12).hardnessAndResistance(2000.0f, 2200.0f)));
    public static final RegistryObject<Block> GARK_STAIRS = BLOCKS.register("gark_stairs", () -> new GarkStairs(() -> GARK_BLOCK.get().getDefaultState(), Block.Properties.from(GARK_BLOCK.get())));
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
    public static final RegistryObject<Block> BLACK_STONE_STAIRS = registerStoneStairsRequiresTool("black_stone_stairs", BLACK_STONE);
    public static final RegistryObject<Block> BLUE_STONE_STAIRS = registerStoneStairsRequiresTool("blue_stone_stairs", BLUE_STONE);
    public static final RegistryObject<Block> BROWN_STONE_STAIRS = registerStoneStairsRequiresTool("brown_stone_stairs", BROWN_STONE);
    public static final RegistryObject<Block> CYAN_STONE_STAIRS = registerStoneStairsRequiresTool("cyan_stone_stairs", CYAN_STONE);
    public static final RegistryObject<Block> GREEN_STONE_STAIRS = registerStoneStairsRequiresTool("green_stone_stairs", GREEN_STONE);
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_STAIRS = registerStoneStairsRequiresTool("light_blue_stone_stairs", LIGHT_BLUE_STONE);
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_STAIRS = registerStoneStairsRequiresTool("light_blue1_stone_stairs", LIGHT_BLUE1_STONE);
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_STAIRS = registerStoneStairsRequiresTool("light_gray_stone_stairs", LIGHT_GRAY_STONE);
    public static final RegistryObject<Block> LIME_STONE_STAIRS = registerStoneStairsRequiresTool("lime_stone_stairs", LIME_STONE);
    public static final RegistryObject<Block> MAGENTA_STONE_STAIRS = registerStoneStairsRequiresTool("magenta_stone_stairs", MAGENTA_STONE);
    public static final RegistryObject<Block> ORANGE_STONE_STAIRS = registerStoneStairsRequiresTool("orange_stone_stairs", ORANGE_STONE);
    public static final RegistryObject<Block> PINK_STONE_STAIRS = registerStoneStairsRequiresTool("pink_stone_stairs", PINK_STONE);
    public static final RegistryObject<Block> PURPLE_STONE_STAIRS = registerStoneStairsRequiresTool("purple_stone_stairs", PURPLE_STONE);
    public static final RegistryObject<Block> RED_STONE_STAIRS = registerStoneStairsRequiresTool("red_stone_stairs", RED_STONE);
    public static final RegistryObject<Block> WHITE_STONE_STAIRS = registerStoneStairsRequiresTool("white_stone_stairs", WHITE_STONE);
    public static final RegistryObject<Block> YELLOW_STONE_STAIRS = registerStoneStairsRequiresTool("yellow_stone_stairs", YELLOW_STONE);

    public static RegistryObject<TripWireBlock> registerColoredTripWire(String colorName, RegistryObject<TripWireHookBlock> blockSupplier) {
        return BLOCKS.register("tripwires/" + colorName + "_tripwire", () -> new TripWireBlock(blockSupplier.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    }

    public static RegistryObject<TripWireHookBlock> registerColoredTripWireHook(String colorName) {
        return BLOCKS.register("tripwires/tripwire_hooks/" + colorName + "_tripwire_hook", () -> new TripWireHookBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    }

    public static RegistryObject<Block> registerRequiresTool(String name, Material material, int harvestLevel, ToolType harvestTool, float hardnessIn, float resistanceIn) {
        return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).harvestTool(harvestTool).hardnessAndResistance(hardnessIn, resistanceIn)));
    }

    public static RegistryObject<Block> registerModSapling(String name, Supplier<Tree> treeSupplier, AbstractBlock abstractBlock) {
        return BLOCKS.register(name, () -> new ModSaplingBlock(treeSupplier, Block.Properties.from(abstractBlock)));
    }

    public static <T extends Block> RegistryObject<Block> registerStairsRequiresTool(String name, Supplier<T> blockSupplier) {
        return BLOCKS.register(name, () -> new StairsBlock(() -> blockSupplier.get().getDefaultState(), AbstractBlock.Properties.from(blockSupplier.get())));
    }

    public static RegistryObject<Block> registerStoneRequiresTool(String name) {
        return registerRequiresTool("stone/stones/" + name, Material.ROCK, 0, ToolType.PICKAXE, 1.5F, 6.0F);
    }

    public static <T extends Block> RegistryObject<Block> registerStoneStairsRequiresTool(String name, Supplier<T> blockSupplier) {
        return registerStairsRequiresTool("stone/stairs" + name, blockSupplier);
    }
}
