package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.from_sponge.Retrug;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.slabs.DamageOnWalkingSlabBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.stairs.DamageOnWalkingStairsBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.hot.Trurk;
import com.babcsany.minecraft.ervin_mod_1.block.crafting_table.LeatBlockCraftingTable;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ExampleTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModSaplingBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class isBurnableBlockItemInit {

    public static final DeferredRegister<Block> BURNABLE_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> FIRG_LEAVES = BURNABLE_BLOCKS.register("firg_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> FIRG_SAPLING = BURNABLE_BLOCKS.register("firg_sapling", () -> new ModSaplingBlock(FirgTree::new, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> EXAMPLE_SAPLING = BURNABLE_BLOCKS.register("example_sapling", () -> new ModSaplingBlock(ExampleTree::new, Block.Properties.create(Material.PLANTS).tickRandomly().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> TRUGN = BURNABLE_BLOCKS.register("trugn", () -> new Block(Block.Properties.create(Material.EARTH).setRequiresTool().harvestLevel(18).harvestTool(ToolType.SHOVEL).hardnessAndResistance(10000000.0f)));
    public static final RegistryObject<Block> TRUGK_BLOCK = BURNABLE_BLOCKS.register("trugk_block", () -> new Block(Block.Properties.create(Material.EARTH).setRequiresTool().harvestLevel(13).harvestTool(ToolType.SHOVEL).hardnessAndResistance(50000.0F)));
    public static final RegistryObject<Block> TNAGN = BURNABLE_BLOCKS.register("tnagn", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(36).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000.0f)));
    public static final RegistryObject<Block> TRAGN = BURNABLE_BLOCKS.register("tragn", () -> new DamageOnWalkingBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(36).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000.0f), 765275040000F));
    public static final RegistryObject<Block> TRAGK_BLOCK = BURNABLE_BLOCKS.register("tragk_block", () -> new DamageOnWalkingBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(26).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5000000.0f), 1224440064F));
    public static final RegistryObject<Block> TRAGK_SLAB = BURNABLE_BLOCKS.register("tragk_slab", () -> new DamageOnWalkingSlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(24).harvestTool(ToolType.PICKAXE).hardnessAndResistance(2500000.0f), 612220032F));
    public static final RegistryObject<Block> TRAGK_STAIRS = BURNABLE_BLOCKS.register("tragk_stairs", () -> new DamageOnWalkingStairsBlock(() -> TRAGK_BLOCK.get().getDefaultState(), Block.Properties.from(TRAGK_BLOCK.get()), 908330048F));
    public static final RegistryObject<Block> TRUZN = BURNABLE_BLOCKS.register("truzn", () -> new CompressedBlockOfGrass(Block.Properties.create(Material.ROCK, MaterialColor.GRASS).setRequiresTool().harvestLevel(27).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10000000.0f)));
    public static final RegistryObject<Block> TRUZK_BLOCK = BURNABLE_BLOCKS.register("truzk_block", () -> new CompressedBlockOfGrass(Block.Properties.create(Material.ROCK, MaterialColor.GRASS).setRequiresTool().harvestLevel(20).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500000.0F)));
    public static final RegistryObject<Block> TGURK_BLOCK = BURNABLE_BLOCKS.register("tgurk_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(46).harvestTool(ToolType.PICKAXE).hardnessAndResistance(29500000000.0F)));
    public static final RegistryObject<Block> TGURK_SLAB = BURNABLE_BLOCKS.register("tgurk_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(45).harvestTool(ToolType.PICKAXE).hardnessAndResistance(14950000000.0F)));
    public static final RegistryObject<Block> TGURN = BURNABLE_BLOCKS.register("tgurn", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(64).harvestTool(ToolType.PICKAXE).hardnessAndResistance(295000000000.0F)));
    public static final RegistryObject<Block> SRIUNK_BLOCK = BURNABLE_BLOCKS.register("sriunk_block", () -> new BlockWithDustColor(14406560, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(6).harvestTool(ToolType.PICKAXE).hardnessAndResistance(500.0f)));
    public static final RegistryObject<Block> SRIUNK_SLAB = BURNABLE_BLOCKS.register("sriunk_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(6).harvestTool(ToolType.PICKAXE).hardnessAndResistance(200.0F, 5000.0F)));
    public static final RegistryObject<Block> SRIUNK_STAIRS = BURNABLE_BLOCKS.register("sriunk_stairs", () -> new StairsBlock(() -> SRIUNK_BLOCK.get().getDefaultState(), Block.Properties.from(SRIUNK_BLOCK.get())));
    public static final RegistryObject<Block> SRIUNK_SLAB1 = BURNABLE_BLOCKS.register("sriunk_slab1", () -> new SriunkSlab1(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(5).harvestTool(ToolType.PICKAXE).hardnessAndResistance(100.0F, 2500.0F)));
    public static final RegistryObject<Block> SRIUNK_SLAB2 = BURNABLE_BLOCKS.register("sriunk_slab2", () -> new SriunkSlab2(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0F, 1500.0F)));
    public static final RegistryObject<Block> NIRK_BLOCK = BURNABLE_BLOCKS.register("nirk_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(20).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1562.0f)));
    public static final RegistryObject<Block> TBRUHV = BURNABLE_BLOCKS.register("tbruhv", () -> new BlockWithDustColor(1644825, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(90).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000000.0F).setLightLevel(Value -> -15)));
    public static final RegistryObject<Block> VILTDROP_BLOCK = BURNABLE_BLOCKS.register("viltdrop_block", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.RED).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000.0f)));
    public static final RegistryObject<Block> GARK_BLOCK = BURNABLE_BLOCKS.register("gark_block", () -> new DamageOnWalkingBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(12).hardnessAndResistance(2000.0f), 26244));
    public static final RegistryObject<Block> GARK_SLAB = BURNABLE_BLOCKS.register("gark_slab", () -> new DamageOnWalkingSlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(12).hardnessAndResistance(2000.0f, 2200.0f), 13122));
    public static final RegistryObject<Block> GARK_STAIRS = BURNABLE_BLOCKS.register("gark_stairs", () -> new DamageOnWalkingStairsBlock(() -> GARK_BLOCK.get().getDefaultState(), Block.Properties.from(GARK_BLOCK.get()), 19683));
    public static final RegistryObject<Block> RETRUG = BURNABLE_BLOCKS.register("retrug", () -> new Retrug(AbstractBlock.Properties.create(Material.SPONGE).harvestTool(ToolType.PICKAXE).hardnessAndResistance(600.0F)));
    public static final RegistryObject<Block> TRURK = BURNABLE_BLOCKS.register("trurk", () -> new Trurk(AbstractBlock.Properties.create(Material.SPONGE).harvestTool(ToolType.PICKAXE).hardnessAndResistance(600.0F)));
    public static final RegistryObject<Block> SRURG = BURNABLE_BLOCKS.register("srurg", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestLevel(15).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6450000.0F)));
    public static final RegistryObject<Block> VILKT_BLOCK = BURNABLE_BLOCKS.register("vilkt_block", () -> new ModOreBlock(0, 18, Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0f, 60)));
    public static final RegistryObject<Block> NIRTK = BURNABLE_BLOCKS.register("nirtk", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000000000000.0F)));
    public static final RegistryObject<Block> NIRTKB = BURNABLE_BLOCKS.register("nirtkb", () -> new SandBlock(14406560, AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).hardnessAndResistance(1000000000000000000.0F)));
    public static final RegistryObject<Block> TIRKS_BLOCK = BURNABLE_BLOCKS.register("tirks_block", () -> new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(80.0f)));
    public static final RegistryObject<Block> TIRSK_BLOCK = BURNABLE_BLOCKS.register("tirsk_block", () -> new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(140.0f)));
    public static final RegistryObject<Block> SHZ_BLOCK = BURNABLE_BLOCKS.register("shz_block", () -> new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6000000.0f).setLightLevel(Value -> 15)));
    public static final RegistryObject<Block> RUGK_BLOCK = BURNABLE_BLOCKS.register("rugk_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3590.0f)));
    public static final RegistryObject<Block> RUGK_SLAB = BURNABLE_BLOCKS.register("rugk_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(3590.0F, 3600.0F)));
    public static final RegistryObject<Block> RUGK_STAIRS = BURNABLE_BLOCKS.register("rugk_stairs", () -> new StairsBlock(() -> RUGK_BLOCK.get().getDefaultState(), Block.Properties.from(RUGK_BLOCK.get())));
    public static final RegistryObject<Block> EPKIN = BURNABLE_BLOCKS.register("epkin", () -> new BarrierBlock(Block.Properties.create(Material.BARRIER).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000.0f)));
    public static final RegistryObject<Block> EPKIH = BURNABLE_BLOCKS.register("epkih", () -> new Epkih(Block.Properties.create(Material.BARRIER).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000.0f)));
    public static final RegistryObject<Block> DRIOP = BURNABLE_BLOCKS.register("driop", () -> new Driop(Block.Properties.create(Material.BARRIER).doesNotBlockMovement().setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0f)));
    public static final RegistryObject<Block> IRTREW = BURNABLE_BLOCKS.register("irtrew", () -> new Irtrew(Block.Properties.create(Material.BARRIER).doesNotBlockMovement().harvestTool(ToolType.PICKAXE).harvestTool(ToolType.AXE).harvestTool(ToolType.SHOVEL).harvestTool(ToolType.HOE).hardnessAndResistance(20.0f)));
    public static final RegistryObject<Block> LEAT_BLOCK = BURNABLE_BLOCKS.register("leat_block", () -> new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestTool(ToolType.AXE).harvestTool(ToolType.PICKAXE).harvestTool(ToolType.SHOVEL).harvestTool(ToolType.HOE).hardnessAndResistance(100.0f)));
    public static final RegistryObject<Block> LEAT_BLOCK_CRAFTING_TABLE = BURNABLE_BLOCKS.register("leat_block_crafting_table", () -> new LeatBlockCraftingTable(Block.Properties.create(Material.ROCK, MaterialColor.GREEN).harvestTool(ToolType.AXE).harvestTool(ToolType.PICKAXE).harvestTool(ToolType.SHOVEL).harvestTool(ToolType.HOE).hardnessAndResistance(500.0f)));
    public static final RegistryObject<Block> CRAINT_BLOCK = BURNABLE_BLOCKS.register("craint_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000.0f)));
    public static final RegistryObject<Block> CRAINT_BLOCK_CRAFTING_TABLE = BURNABLE_BLOCKS.register("craint_block_crafting_table", () -> new CraintBlockCraftingTable(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(5).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10000.0f)));
    public static final RegistryObject<Block> NARIN_BLOCK = BURNABLE_BLOCKS.register("narin_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(5000.0f)));
    public static final RegistryObject<Block> NETHER_PORTAL = BURNABLE_BLOCKS.register("nether_portal", () -> new NetherPortalBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).doesNotBlockMovement().harvestTool(ToolType.PICKAXE).hardnessAndResistance(120000000.0F).setLightLevel(Value -> 15)));
    public static final RegistryObject<Block> HURVRUJ = BURNABLE_BLOCKS.register("hurvruj", () -> new Hurvruj(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().hardnessAndResistance(500000.0F, 12000000.0F).setLightLevel((blockState) -> Hurvruj.func_235565_a_(blockState, 15))));
    public static final RegistryObject<Block> CRASK = BURNABLE_BLOCKS.register("crask", () -> new Block(Block.Properties.create(Material.WOOL).setRequiresTool().hardnessAndResistance(100.0f)));
    public static final RegistryObject<Block> UUUUUUUUUUUUUUUUUUUUUUUU = BURNABLE_BLOCKS.register("uuuuuuuuuuuuuuuuuuuuuuuu", () -> new Tririj(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F)));

}
