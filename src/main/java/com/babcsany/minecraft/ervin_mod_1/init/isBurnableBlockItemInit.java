package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.from_sponge.Retrug;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.slabs.DamageOnWalkingSlabBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.stairs.DamageOnWalkingStairsBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.hot.Trurk;
import com.babcsany.minecraft.ervin_mod_1.block.crafting_table.LeatBlockCraftingTable;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlockItems;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModSaplingBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class isBurnableBlockItemInit {
    public static final Block FIRG_LEAVES = UnusedBlocks.registerBlockItem("firg_leaves", new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final Block FIRG_SAPLING = UnusedBlocks.registerBlockItem("firg_sapling", new ModSaplingBlock(FirgTree::new, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
    public static final Block EXAMPLE_SAPLING = UnusedBlocks.registerBlockItem("example_sapling", new ModSaplingBlock(ExampleTree::new, Block.Properties.create(Material.PLANTS).tickRandomly().sound(SoundType.PLANT)));
    public static final Block TRUGN = UnusedBlocks.registerBlockItem("trugn", new Block(Block.Properties.create(Material.EARTH).setRequiresTool().harvestLevel(18).harvestTool(ToolType.SHOVEL).hardnessAndResistance(10000000.0f)));
    public static final Block TRUGK_BLOCK = UnusedBlocks.registerBlockItem("trugk_block", new Block(Block.Properties.create(Material.EARTH).setRequiresTool().harvestLevel(13).harvestTool(ToolType.SHOVEL).hardnessAndResistance(50000.0F)));
    public static final Block TNAGN = UnusedBlocks.registerBlockItem("tnagn", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(36).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000.0f)));
    public static final Block TRAGN = UnusedBlocks.registerDefault("tragn", new DamageOnWalkingBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(36).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000.0f), 765275040000F));
    public static final Block TRAGK_BLOCK = UnusedBlocks.registerDefault("tragk_block", new DamageOnWalkingBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(26).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5000000.0f), 1224440064F));
    public static final Block TRAGK_SLAB = UnusedBlocks.registerDefault("tragk_slab", new DamageOnWalkingSlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(24).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2500000.0f), 612220032F));
    public static final Block TRAGK_STAIRS = UnusedBlocks.registerDefault("tragk_stairs", new DamageOnWalkingStairsBlock(TRAGK_BLOCK::getDefaultState, Block.Properties.from(TRAGK_BLOCK), 908330048F));
    public static final Block TRUZN = UnusedBlocks.registerDefault("truzn", new CompressedBlockOfGrass(Block.Properties.create(Material.ROCK, MaterialColor.GRASS).setRequiresTool().harvestLevel(27).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10000000.0f)));
    public static final Block TRUZK_BLOCK = UnusedBlocks.registerBlockItem("truzk_block", new CompressedBlockOfGrass(Block.Properties.create(Material.ROCK, MaterialColor.GRASS).setRequiresTool().harvestLevel(20).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500000.0F)));
    public static final Block TGURK_BLOCK = UnusedBlocks.registerBlockItem("tgurk_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(46).harvestTool(ToolType.PICKAXE).hardnessAndResistance(29500000000.0F)));
    public static final Block TGURK_SLAB = UnusedBlocks.registerBlockItem("tgurk_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(45).harvestTool(ToolType.PICKAXE).hardnessAndResistance(14950000000.0F)));
    public static final Block TGURN = UnusedBlocks.registerBlockItem("tgurn", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(64).harvestTool(ToolType.PICKAXE).hardnessAndResistance(295000000000.0F)));
    public static final Block SRIUNK_BLOCK = UnusedBlocks.registerBlockItem("sriunk_block", new BlockWithDustColor(14406560, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(6).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500.0f)));
    public static final Block SRIUNK_SLAB = UnusedBlocks.registerBlockItem("sriunk_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(6).harvestTool(ToolType.PICKAXE).hardnessAndResistance(200.0F, 5000.0F)));
    public static final Block SRIUNK_STAIRS = UnusedBlocks.registerBlockItem("sriunk_stairs", new StairsBlock(SRIUNK_BLOCK::getDefaultState, Block.Properties.from(SRIUNK_BLOCK)));
    public static final Block SRIUNK_SLAB1 = UnusedBlocks.registerBlockItem("sriunk_slab1", new SriunkSlab1(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(5).harvestTool(ToolType.PICKAXE).hardnessAndResistance(100.0F, 2500.0F)));
    public static final Block SRIUNK_SLAB2 = UnusedBlocks.registerBlockItem("sriunk_slab2", new SriunkSlab2(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0F, 1500.0F)));
    public static final Block NIRK_BLOCK = UnusedBlocks.registerBlockItem("nirk_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(20).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1562.0f)));
    public static final Block TBRUHV = UnusedBlocks.registerBlockItem("tbruhv", new BlockWithDustColor(1644825, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(90).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000000.0F).setLightLevel(Value -> -15)));
    public static final Block VILTDROP_BLOCK = UnusedBlocks.registerBlockItem("viltdrop_block", new Block(Block.Properties.create(Material.ROCK, MaterialColor.RED).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000.0f)));
    public static final Block GARK_BLOCK = UnusedBlocks.registerDefault("gark_block", new DamageOnWalkingBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(12).hardnessAndResistance(2000.0f), 26244));
    public static final Block GARK_SLAB = UnusedBlocks.registerDefault("gark_slab", new DamageOnWalkingSlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(12).hardnessAndResistance(2000.0f, 2200.0f), 13122));
    public static final Block GARK_STAIRS = UnusedBlocks.registerDefault("gark_stairs", new DamageOnWalkingStairsBlock(GARK_BLOCK::getDefaultState, Block.Properties.from(GARK_BLOCK), 19683));
    public static final Block RETRUG = UnusedBlocks.registerBlockItem("retrug", new Retrug(AbstractBlock.Properties.create(Material.SPONGE).harvestTool(ToolType.PICKAXE).hardnessAndResistance(600.0F)));
    public static final Block TRURK = UnusedBlocks.registerBlockItem("trurk", new Trurk(AbstractBlock.Properties.create(Material.SPONGE).harvestTool(ToolType.PICKAXE).hardnessAndResistance(600.0F)));
    public static final Block SRURG = UnusedBlocks.registerBlockItem("srurg", new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(15).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6450000.0F)));
    public static final Block VILKT_BLOCK = UnusedBlocks.registerBlockItem("vilkt_block", new ModOreBlock(0, 18, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0f, 60)));
    public static final Block NIRTK = UnusedBlocks.registerBlockItem("nirtk", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000000000000.0F)));
    public static final Block NIRTKB = UnusedBlocks.registerBlockItem("nirtkb", new SandBlock(14406560, AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).hardnessAndResistance(1000000000000000000.0F)));
    public static final BlockItem TIRKS_BLOCK = registerBlockItem("tirks_block", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(80.0f)));
    public static final BlockItem TIRSK_BLOCK = registerBlockItem("tirsk_block", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(140.0f)));
    public static final Block SHZ_BLOCK = register("shz_block", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6000000.0f).setLightLevel(Value -> 15)));
    public static final Block RUGK_BLOCK = register("rugk_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3590.0f)));
    public static final Block RUGK_SLAB = register("rugk_slab", new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3590.0F, 3600.0F)));
    public static final Block RUGK_STAIRS = register("rugk_stairs", new StairsBlock(RUGK_BLOCK::getDefaultState, Block.Properties.from(RUGK_BLOCK)));
    public static final Block EPKIH = UnusedBlocks.registerDefault("epkih", new Epkih(Block.Properties.create(Material.BARRIER).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000.0f)));
    public static final Block DRIOP = register("driop", new Driop(Block.Properties.create(Material.BARRIER).doesNotBlockMovement().setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0f)));
    public static final Block IRTREW = register("irtrew", new Irtrew(Block.Properties.create(Material.BARRIER).doesNotBlockMovement().harvestTool(ToolType.PICKAXE).harvestTool(ToolType.AXE).harvestTool(ToolType.SHOVEL).harvestTool(ToolType.HOE).hardnessAndResistance(20.0f)));
    public static final BlockItem LEAT_BLOCK = registerBlockItem("leat_block", new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestTool(ToolType.AXE).harvestTool(ToolType.PICKAXE).harvestTool(ToolType.SHOVEL).harvestTool(ToolType.HOE).hardnessAndResistance(100.0f)));
    public static final BlockItem LEAT_BLOCK_CRAFTING_TABLE = registerBlockItem("leat_block_crafting_table", new LeatBlockCraftingTable(Block.Properties.create(Material.ROCK, MaterialColor.GREEN).harvestTool(ToolType.AXE).harvestTool(ToolType.PICKAXE).harvestTool(ToolType.SHOVEL).harvestTool(ToolType.HOE).hardnessAndResistance(500.0f)));
    public static final Block CRAINT_BLOCK = UnusedBlocks.registerBlockItem("craint_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000.0f)));
    public static final Block CRAINT_BLOCK_CRAFTING_TABLE = UnusedBlocks.registerBlockItem("craint_block_crafting_table", new CraintBlockCraftingTable(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(5).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10000.0f)));
    public static final Block NARIN_BLOCK = UnusedBlocks.registerBlockItem("narin_block", new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5000.0f)));
    public static final Block NETHER_PORTAL = register("nether_portal", new NetherPortalBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).doesNotBlockMovement().harvestTool(ToolType.PICKAXE).hardnessAndResistance(120000000.0F).setLightLevel(Value -> 15)));
    public static final Block HURVRUJ = registerBlockItem("hurvruj", new Hurvruj(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().hardnessAndResistance(500000.0F, 12000000.0F).setLightLevel((blockState) -> Hurvruj.lightState(blockState, 15))), new Item.Properties().isImmuneToFire());
    public static final Block CRASK = UnusedBlocks.registerBlockItem("crask", new Block(Block.Properties.create(Material.WOOL).setRequiresTool().hardnessAndResistance(100.0f)));
    public static final Block UUUUUUUUUUUUUUUUUUUUUUUU = UnusedBlocks.registerBlockItem("uuuuuuuuuuuuuuuuuuuuuuuu", new Tririj(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F)));

    public static Block register(String name, Block block) {
        return UnusedBlocks.registerDefault(name, block);
    }

    public static BlockItem registerBlockItem(String name, Block block) {
        return new Cast<BlockItem>().cast(UnusedBlockItems.registerDefault(name, block));
    }

    public static Block registerBlockItem(String name, Block block, Item.Properties properties) {
        return new Cast<BlockItem>().cast(UnusedBlockItems.registerDefault(name, block, properties)).getBlock();
    }

    public static void register() {
        Ervin_mod_1.register(isBurnableBlockItemInit.class);
    }
}
