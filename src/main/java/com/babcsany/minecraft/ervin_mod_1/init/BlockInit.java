package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.*;
import com.babcsany.minecraft.ervin_mod_1.block.iron_ores.BlackIronOre;
import com.babcsany.minecraft.ervin_mod_1.block.iron_ores.IronOre;
import com.babcsany.minecraft.ervin_mod_1.block.iron_ores.RedIronOre;
import com.babcsany.minecraft.ervin_mod_1.block.tripwires.*;
import com.babcsany.minecraft.ervin_mod_1.block.tripwires.tripwire_hooks.*;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FirgTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.FrimTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.JazzTree;
import com.babcsany.minecraft.ervin_mod_1.world.feature.ModSaplingBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.block.Blocks.OAK_SAPLING;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(
            Block.Properties.create(Material.SAND).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.SAND)
    ));
    public static final RegistryObject<Block> DEF_BLOCK = BLOCKS.register("def_block", () -> new Block(
            Block.Properties.create(Material.IRON)
    ));
    public static final RegistryObject<Block> JAZZ_LOG = BLOCKS.register("jazz_log", () -> new JazzLog(
            MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)
    ));
    public static final RegistryObject<Block> JAZZ_LEAVES = BLOCKS.register("jazz_leaves", () -> new LeavesBlock(
            Block.Properties.from(Blocks.OAK_LEAVES)
    ));
    public static final RegistryObject<Block> FIRG_LEAVES = BLOCKS.register("firg_leaves", () -> new FirgLeaves(
            Block.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F)
                    .tickRandomly()
                    .sound(SoundType.PLANT)
                    .notSolid()
    ));
    public static final RegistryObject<Block> JAZZ_SAPLING = BLOCKS.register("jazz_sapling", () -> new ModSaplingBlock(
            JazzTree::new, Block.Properties.from(OAK_SAPLING)
    ));
    public static final RegistryObject<Block> VILTDROP_BLOCK = BLOCKS.register("viltdrop_block", () -> new ViltdropBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000.0f)
    ));
    public static final RegistryObject<Block> REGDEM_BLOCK = BLOCKS.register("regdem_block", () -> new RegdemBlock(
            Block.Properties.create(Material.WOOD)
                    .harvestLevel(0)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> LEAT_BLOCK = BLOCKS.register("leat_block", () -> new LeatBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> LEAT_BLOCK_CRAFTING_TABLE = BLOCKS.register("leat_block_crafting_table", () -> new LeatBlockCraftingTable(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.AXE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(500.0f)
    ));
    public static final RegistryObject<Block> CRAINT_BLOCK = BLOCKS.register("craint_block", () -> new CraintBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000.0f)
    ));
    public static final RegistryObject<Block> CRAINT_BLOCK_CRAFTING_TABLE = BLOCKS.register("craint_block_crafting_table", () -> new CraintBlockCraftingTable(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10000.0f)
    ));
    public static final RegistryObject<Block> NARIN_BLOCK = BLOCKS.register("narin_block", () -> new NarinBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5000.0f)
    ));
    public static final RegistryObject<Block> SRIUNK_ORE = BLOCKS.register("sriunk_ore", () -> new OreBlock1(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new RubyBlock(
            Block.Properties.create(Material.IRON)
                    .setRequiresTool()
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(8.0f)
    ));
    public static final RegistryObject<Block> GRINT_BLOCK = BLOCKS.register("grint_block", () -> new GrintBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> RED_STONE = BLOCKS.register("stones/red_stone", () -> new RedStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> RED_COBBLESTONE = BLOCKS.register("red_cobblestone", () -> new RedCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 12.0F)
    ));
    public static final RegistryObject<Block> EPKIN = BLOCKS.register("epkin", () -> new Epkin(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000.0f)
    ));
    public static final RegistryObject<Block> RED_SMOOTH_STONE = BLOCKS.register("red_smooth_stone", () -> new RedSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000.0f)
    ));
    public static final RegistryObject<Block> RED_FURNACE = BLOCKS.register("red_furnace", () -> new FurnaceBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> AVTER_BLOCK = BLOCKS.register("avter_block", () -> new AvterBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(5)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6000.0f)
    ));
    public static final RegistryObject<Block> FIRG = BLOCKS.register("firg", () -> new Firg(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> FRIT_BLOCK = BLOCKS.register("frit_block", () -> new FritBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> END_PORTAL = BLOCKS.register("end_portal", () -> new EndPortal(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> SCRAFTH = BLOCKS.register("scrafth", () -> new Scrafth(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACKHT = BLOCKS.register("ender_srackht", () -> new EnderSrackht(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(20.0f)
    ));
    public static final RegistryObject<Block> END_STONE_CISK = BLOCKS.register("end_stone_cisk", () -> new EndStoneCisk(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(30.0f)
    ));
    public static final RegistryObject<Block> END_STONE_CRISK = BLOCKS.register("end_stone_crisk", () -> new EndStoneCrisk(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(45.0f)
    ));
    public static final RegistryObject<Block> END_SRACT = BLOCKS.register("end_sract", () -> new EndSract(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(8.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACT = BLOCKS.register("ender_sract", () -> new EnderSract(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(9.0f)
    ));
    public static final RegistryObject<Block> ENDER_SACKT = BLOCKS.register("ender_sackt", () -> new EnderSackt(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> ENDER_SACT = BLOCKS.register("ender_sact", () -> new EnderSact(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(12.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACKH = BLOCKS.register("ender_srackh", () -> new EnderSrackh(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(14.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACK = BLOCKS.register("ender_srack", () -> new EnderSrack(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(16.0f)
    ));
    public static final RegistryObject<Block> END_SRACKT = BLOCKS.register("end_srackt", () -> new EndSrackt(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(16.0f)
    ));
    public static final RegistryObject<Block> VIRK_BLOCK = BLOCKS.register("virk_block", () -> new VirkBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(5)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(650.0f)
    ));
    public static final RegistryObject<Block> FIRT_BLOCK = BLOCKS.register("firt_block", () -> new FirtBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> TRING = BLOCKS.register("tring", () -> new Tring(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> PACK_BLOCK = BLOCKS.register("pack_block", () -> new PackBlock(
            Block.Properties.create(Material.EARTH)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> TIRKS_BLOCK = BLOCKS.register("tirks_block", () -> new TirksBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> SHZ_BLOCK = BLOCKS.register("shz_block", () -> new ShzBlock(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6000000.0f)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> TIRSK_BLOCK = BLOCKS.register("tirsk_block", () -> new TirskBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> KALT_BLOCK = BLOCKS.register("kalt_block", () -> new KaltBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> VILKT_BLOCK = BLOCKS.register("vilkt_block", () -> new VilktBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f, 60)
    ));
    public static final RegistryObject<Block> URVI = BLOCKS.register("urvi", () -> new Urvi(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3.0F, 9.0F)
    ));
    public static final RegistryObject<Block> SURVI = BLOCKS.register("survi", () -> new Survi(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 9.0F)
    ));
    public static final RegistryObject<Block> SURV = BLOCKS.register("surv", () -> new Surv(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(4.0F, 10.0F)
    ));
    public static final RegistryObject<Block> SURT = BLOCKS.register("surt", () -> new Surt(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5.0F, 12.0F)
    ));
    public static final RegistryObject<Block> BLACK_COBBLESTONE = BLOCKS.register("cobblestones/black_cobblestone", () -> new BlackCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> BLUE_COBBLESTONE = BLOCKS.register("cobblestones/blue_cobblestone", () -> new BlueCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> BROWN_COBBLESTONE = BLOCKS.register("cobblestones/brown_cobblestone", () -> new BrownCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> CYAN_COBBLESTONE = BLOCKS.register("cobblestones/cyan_cobblestone", () -> new CyanCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> GREEN_COBBLESTONE = BLOCKS.register("cobblestones/green_cobblestone", () -> new GreenCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_COBBLESTONE = BLOCKS.register("cobblestones/light_blue1_cobblestone", () -> new LightBlue1Cobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_COBBLESTONE = BLOCKS.register("cobblestones/light_blue_cobblestone", () -> new LightBlueCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIME_COBBLESTONE = BLOCKS.register("cobblestones/lime_cobblestone", () -> new LimeCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> MAGENTA_COBBLESTONE = BLOCKS.register("cobblestones/magenta_cobblestone", () -> new MagentaCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> ORANGE_COBBLESTONE = BLOCKS.register("cobblestones/orange_cobblestone", () -> new OrangeCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> PINK_COBBLESTONE = BLOCKS.register("cobblestones/pink_cobblestone", () -> new PinkCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> PURPLE_COBBLESTONE = BLOCKS.register("cobblestones/purple_cobblestone", () -> new PurpleCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> WHITE_COBBLESTONE = BLOCKS.register("cobblestones/white_cobblestone", () -> new WhiteCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> YELLOW_COBBLESTONE = BLOCKS.register("cobblestones/yellow_cobblestone", () -> new YellowCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> NETHER_PORTAL = BLOCKS.register("nether_portal", () -> new NetherPortal(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .setLightLevel(Value -> 15)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(120.0F, 12.0F)
    ));
    public static final RegistryObject<Block> ENDER_STAKRACH = BLOCKS.register("ender_stakrach", () -> new EnderStakrach(
            Block.Properties.create(Material.WOOD)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(40.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACKTH = BLOCKS.register("ender_srackth", () -> new EnderSrackth(
            Block.Properties.create(Material.SPONGE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(20.0f)
    ));
    public static final RegistryObject<Block> OAK_TURG = BLOCKS.register("oak_turg", () -> new EnderSrackth(
            Block.Properties.create(Material.SPONGE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> ENDER_SRAKTCAF = BLOCKS.register("ender_sraktcaf", () -> new EnderSraktcaf(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(3)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> ENDER_TRASKRACH = BLOCKS.register("ender_traskrach", () -> new EnderTraskrach(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .hardnessAndResistance(80.0f)
    ));
    public static final RegistryObject<Block> ENDER_TRASKCRAFTH = BLOCKS.register("ender_traskcrafth", () -> new EnderTraskcrafth(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .harvestLevel(5)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> ENDER_TRASK = BLOCKS.register("ender_trask", () -> new EnderTrask(
            Block.Properties.create(Material.SPONGE)
                    .setRequiresTool()
                    .harvestLevel(6)
                    .hardnessAndResistance(160.0f)
    ));
    public static final RegistryObject<Block> ACACIA_TURG = BLOCKS.register("acacia_turg", () -> new AcaciaTurg(
            Block.Properties.create(Material.SPONGE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> BIRCH_TURG = BLOCKS.register("birch_turg", () -> new BirchTurg(
            Block.Properties.create(Material.SPONGE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> DARK_OAK_TURG = BLOCKS.register("dark_oak_turg", () -> new DarkOakTurg(
            Block.Properties.create(Material.SPONGE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> JUNGLE_TURG = BLOCKS.register("jungle_turg", () -> new JungleTurg(
            Block.Properties.create(Material.SPONGE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> SPRUCE_TURG = BLOCKS.register("spruce_turg", () -> new SpruceTurg(
            Block.Properties.create(Material.SPONGE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> TURG = BLOCKS.register("turg", () -> new Turg(
            Block.Properties.create(Material.SPONGE)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> CHARCOAL_BLOCK = BLOCKS.register("charcoal_block", () -> new CharcoalBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
    ));
    public static final RegistryObject<Block> L0 = BLOCKS.register("0", () -> new L0(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> L1 = BLOCKS.register("1", () -> new L1(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> L2 = BLOCKS.register("2", () -> new L2(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> L3 = BLOCKS.register("3", () -> new L3(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> L4 = BLOCKS.register("4", () -> new L4(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> L5 = BLOCKS.register("5", () -> new L5(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> L6 = BLOCKS.register("6", () -> new L6(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> L7 = BLOCKS.register("7", () -> new L7(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> L8 = BLOCKS.register("8", () -> new L8(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> L9 = BLOCKS.register("9", () -> new L9(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .hardnessAndResistance(1000000000)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> AIR = BLOCKS.register("air", () -> new Air(
            Block.Properties.create(Material.AIR)
                    .doesNotBlockMovement()
                    .noDrops()
    ));
    public static final RegistryObject<Block> TRINKS = BLOCKS.register("trinks", () -> new Trinks(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .doesNotBlockMovement()
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> DIRT1 = BLOCKS.register("dirt1", () -> new Dirt1(
            Block.Properties.create(Material.EARTH, MaterialColor.DIRT)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0.5F)
                    .sound(SoundType.GROUND)
    ));
    public static final RegistryObject<Block> GNITH_BLOCK = BLOCKS.register("gnith_block", () -> new GnithBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(200.0F, 5000.0F)
    ));
    public static final RegistryObject<Block> SRIUNK_SLAB = BLOCKS.register("sriunk_slab", () -> new SriunkSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(200.0F, 5000.0F)
    ));
    public static final RegistryObject<Block> DIAMOND_SLAB = BLOCKS.register("diamond_slab", () -> new DiamondSlab(
            Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).sound(SoundType.METAL)
                    .setRequiresTool()
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6.0F, 6.0F)
    ));
    public static final RegistryObject<Block> IRON_SLAB = BLOCKS.register("iron_slab", () -> new IronSlab(
            Block.Properties.create(Material.IRON, MaterialColor.DIAMOND).sound(SoundType.METAL)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6.0F, 6.0F)
    ));
    public static final RegistryObject<Block> GOLD_SLAB = BLOCKS.register("gold_slab", () -> new GoldSlab(
            Block.Properties.create(Material.IRON, MaterialColor.GOLD).sound(SoundType.METAL)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(4.0F, 6.0F)
    ));
    public static final RegistryObject<Block> REDSTONE_SLAB = BLOCKS.register("redstone_slab", () -> new Redstone_Slab(
            Block.Properties.create(Material.IRON, MaterialColor.TNT).sound(SoundType.METAL)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6.0F, 6.0F)
    ));
    public static final RegistryObject<Block> DIRT_SLAB = BLOCKS.register("dirt_slab", () -> new DirtSlab(
            Block.Properties.create(Material.EARTH, MaterialColor.DIRT).sound(SoundType.GROUND)
                    .harvestLevel(0)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(1.0F)
    ));
    public static final RegistryObject<Block> LAPIS_SLAB = BLOCKS.register("lapis_slab", () -> new LapisSlab(
            Block.Properties.create(Material.IRON, MaterialColor.LAPIS)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3.0F, 3.0F)
    ));
    public static final RegistryObject<Block> EMERALD_SLAB = BLOCKS.register("emerald_slab", () -> new EmeraldSlab(
            Block.Properties.create(Material.IRON, MaterialColor.EMERALD)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6.0F, 6.0F)
    ));
    public static final RegistryObject<Block> RUBY_SLAB = BLOCKS.register("ruby_slab", () -> new RubySlab(
            Block.Properties.create(Material.IRON)
                    .setRequiresTool()
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(9.0F)
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_COBBLESTONE = BLOCKS.register("light_gray_cobblestone", () -> new LightGrayCobblestone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 12.0F)
    ));
    public static final RegistryObject<Block> BLACK_STONE = BLOCKS.register("stones/black_stone", () -> new BlackStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> BLUE_STONE = BLOCKS.register("stones/blue_stone", () -> new BlueStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> BROWN_STONE = BLOCKS.register("stones/brown_stone", () -> new BrownStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> CYAN_STONE = BLOCKS.register("stones/cyan_stone", () -> new CyanStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> GREEN_STONE = BLOCKS.register("stones/green_stone", () -> new GreenStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_STONE = BLOCKS.register("stones/light_blue_stone", () -> new LightBlueStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE = BLOCKS.register("stones/light_blue1_stone", () -> new LightBlue1Stone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE = BLOCKS.register("stones/light_gray_stone", () -> new LightGrayStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> LIME_STONE = BLOCKS.register("stones/lime_stone", () -> new LimeStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> MAGENTA_STONE = BLOCKS.register("stones/magenta_stone", () -> new MagentaStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> ORANGE_STONE = BLOCKS.register("stones/orange_stone", () -> new OrangeStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> PINK_STONE = BLOCKS.register("stones/pink_stone", () -> new PinkStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> PURPLE_STONE = BLOCKS.register("stones/purple_stone", () -> new PurpleStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> WHITE_STONE = BLOCKS.register("stones/white_stone", () -> new WhiteStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> YELLOW_STONE = BLOCKS.register("stones/yellow_stone", () -> new YellowStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> BLACK_COBBLESTONE_SLAB = BLOCKS.register("black_cobblestone_slab", () -> new BlackCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> BLUE_COBBLESTONE_SLAB = BLOCKS.register("blue_cobblestone_slab", () -> new BlueCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> BROWN_COBBLESTONE_SLAB = BLOCKS.register("brown_cobblestone_slab", () -> new BrownCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> CYAN_COBBLESTONE_SLAB = BLOCKS.register("cyan_cobblestone_slab", () -> new CyanCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> GREEN_COBBLESTONE_SLAB = BLOCKS.register("green_cobblestone_slab", () -> new GreenCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_COBBLESTONE_SLAB = BLOCKS.register("light_blue_cobblestone_slab", () -> new LightBlueCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_COBBLESTONE_SLAB = BLOCKS.register("light_blue1_cobblestone_slab", () -> new LightBlue1CobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_COBBLESTONE_SLAB = BLOCKS.register("light_gray_cobblestone_slab", () -> new LightGrayCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIME_COBBLESTONE_SLAB = BLOCKS.register("lime_cobblestone_slab", () -> new LimeCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> MAGENTA_COBBLESTONE_SLAB = BLOCKS.register("magenta_cobblestone_slab", () -> new MagentaCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> ORANGE_COBBLESTONE_SLAB = BLOCKS.register("orange_cobblestone_slab", () -> new OrangeCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> PINK_COBBLESTONE_SLAB = BLOCKS.register("pink_cobblestone_slab", () -> new PinkCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> PURPLE_COBBLESTONE_SLAB = BLOCKS.register("purple_cobblestone_slab", () -> new PurpleCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> RED_COBBLESTONE_SLAB = BLOCKS.register("red_cobblestone_slab", () -> new RedCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> WHITE_COBBLESTONE_SLAB = BLOCKS.register("white_cobblestone_slab", () -> new WhiteCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> YELLOW_COBBLESTONE_SLAB = BLOCKS.register("yellow_cobblestone_slab", () -> new YellowCobblestoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> BLACK_STONE_SLAB = BLOCKS.register("black_stone_slab", () -> new BlackStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> BLUE_STONE_SLAB = BLOCKS.register("blue_stone_slab", () -> new BlueStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> BROWN_STONE_SLAB = BLOCKS.register("brown_stone_slab", () -> new BrownStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> CYAN_STONE_SLAB = BLOCKS.register("cyan_stone_slab", () -> new CyanStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> GREEN_STONE_SLAB = BLOCKS.register("green_stone_slab", () -> new GreenStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_SLAB = BLOCKS.register("light_blue_stone_slab", () -> new LightBlueStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_SLAB = BLOCKS.register("light_blue1_stone_slab", () -> new LightBlue1StoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_SLAB = BLOCKS.register("light_gray_stone_slab", () -> new LightGrayStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIME_STONE_SLAB = BLOCKS.register("lime_stone_slab", () -> new LimeStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> MAGENTA_STONE_SLAB = BLOCKS.register("magenta_stone_slab", () -> new MagentaStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> ORANGE_STONE_SLAB = BLOCKS.register("orange_stone_slab", () -> new OrangeStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> PINK_STONE_SLAB = BLOCKS.register("pink_stone_slab", () -> new PinkStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> PURPLE_STONE_SLAB = BLOCKS.register("purple_stone_slab", () -> new PurpleStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> RED_STONE_SLAB = BLOCKS.register("red_stone_slab", () -> new RedStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> WHITE_STONE_SLAB = BLOCKS.register("white_stone_slab", () -> new WhiteStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> YELLOW_STONE_SLAB = BLOCKS.register("yellow_stone_slab", () -> new YellowStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> GRITK_BLOCK = BLOCKS.register("gritk_block", () -> new GritkBlock(
            Block.Properties.create(Material.IRON)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .setLightLevel(Value -> 15)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(500000.0F, 1200000.0F)
    ));
    public static final RegistryObject<Block> COAL_SLAB = BLOCKS.register("coal_slab", () -> new CoalSlab(
            Block.Properties.create(Material.ROCK, MaterialColor.BLACK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6.0F, 6.0F)
    ));
    public static final RegistryObject<Block> CHARCOAL_SLAB = BLOCKS.register("charcoal_slab", () -> new CharcoalSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6.0F, 6.0F)
    ));
    public static final RegistryObject<Block> GRINT_SLAB = BLOCKS.register("grint_slab", () -> new GrintSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(120.0f)
    ));
    public static final RegistryObject<Block> GURK_BLOCK = BLOCKS.register("gurk_block", () -> new GurkBlock(
            Block.Properties.create(Material.EARTH)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(20.0f)
    ));
    public static final RegistryObject<Block> GURK_SLAB = BLOCKS.register("gurk_slab", () -> new GurkSlab(
            Block.Properties.create(Material.EARTH)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(20.0f, 22.0f)
    ));
    public static final RegistryObject<Block> GARK_BLOCK = BLOCKS.register("gark_block", () -> new GarkBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(12)
                    .hardnessAndResistance(2000.0f)
    ));
    public static final RegistryObject<Block> GARK_SLAB = BLOCKS.register("gark_slab", () -> new GarkSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(12)
                    .hardnessAndResistance(2000.0f, 2200.0f)
    ));
    public static final RegistryObject<Block> BLACK_SMOOTH_STONE = BLOCKS.register("black_smooth_stone", () -> new BlackSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> BLUE_SMOOTH_STONE = BLOCKS.register("blue_smooth_stone", () -> new BlueSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> BROWN_SMOOTH_STONE = BLOCKS.register("brown_smooth_stone", () -> new BrownSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> CYAN_SMOOTH_STONE = BLOCKS.register("cyan_smooth_stone", () -> new CyanSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> GREEN_SMOOTH_STONE = BLOCKS.register("green_smooth_stone", () -> new GreenSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_SMOOTH_STONE = BLOCKS.register("light_blue_smooth_stone", () -> new LightBlueSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_SMOOTH_STONE = BLOCKS.register("light_blue1_smooth_stone", () -> new LightBlue1SmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_SMOOTH_STONE = BLOCKS.register("light_gray_smooth_stone", () -> new LightGraySmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> LIME_SMOOTH_STONE = BLOCKS.register("lime_smooth_stone", () -> new LimeSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> MAGENTA_SMOOTH_STONE = BLOCKS.register("magenta_smooth_stone", () -> new MagentaSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> ORANGE_SMOOTH_STONE = BLOCKS.register("orange_smooth_stone", () -> new OrangeSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> PINK_SMOOTH_STONE = BLOCKS.register("pink_smooth_stone", () -> new PinkSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> PURPLE_SMOOTH_STONE = BLOCKS.register("purple_smooth_stone", () -> new PurpleSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> WHITE_SMOOTH_STONE = BLOCKS.register("white_smooth_stone", () -> new WhiteSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> YELLOW_SMOOTH_STONE = BLOCKS.register("yellow_smooth_stone", () -> new YellowSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> ENDER_SRACKHT1 = BLOCKS.register("ender_srackht_1", () -> new EnderSrackht1(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(20.0F)
    ));
    public static final RegistryObject<Block> ENDER_SRAKTCAF1 = BLOCKS.register("ender_sraktcaf_1", () -> new EnderSraktcaf1(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(3)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(60.0F)
    ));
    public static final RegistryObject<Block> ENDER_STAKRACH1 = BLOCKS.register("ender_stakrach_1", () -> new EnderStakrach1(
            Block.Properties.create(Material.WOOD)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(40.0F)
    ));
    public static final RegistryObject<Block> ENDER_TRASKCRAFTH1 = BLOCKS.register("ender_traskcrafth_1", () -> new EnderTraskcrafth1(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .harvestLevel(5)
                    .hardnessAndResistance(100.0F)
    ));
    public static final RegistryObject<Block> ENDER_TRASKRACH1 = BLOCKS.register("ender_traskrach_1", () -> new EnderTraskrach1(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .hardnessAndResistance(80.0F)
    ));
    public static final RegistryObject<Block> BLACK_SMOOTH_STONE_SLAB = BLOCKS.register("black_smooth_stone_slab", () -> new BlackSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> BLUE_SMOOTH_STONE_SLAB = BLOCKS.register("blue_smooth_stone_slab", () -> new BlueSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> BROWN_SMOOTH_STONE_SLAB = BLOCKS.register("brown_smooth_stone_slab", () -> new BrownSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> CYAN_SMOOTH_STONE_SLAB = BLOCKS.register("cyan_smooth_stone_slab", () -> new CyanSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> GREEN_SMOOTH_STONE_SLAB = BLOCKS.register("green_smooth_stone_slab", () -> new GreenSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_SMOOTH_STONE_SLAB = BLOCKS.register("light_blue_smooth_stone_slab", () -> new LightBlueSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_SMOOTH_STONE_SLAB = BLOCKS.register("light_blue1_smooth_stone_slab", () -> new LightBlue1SmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_SMOOTH_STONE_SLAB = BLOCKS.register("light_gray_smooth_stone_slab", () -> new LightGraySmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> LIME_SMOOTH_STONE_SLAB = BLOCKS.register("lime_smooth_stone_slab", () -> new LimeSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> MAGENTA_SMOOTH_STONE_SLAB = BLOCKS.register("magenta_smooth_stone_slab", () -> new MagentaSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> ORANGE_SMOOTH_STONE_SLAB = BLOCKS.register("orange_smooth_stone_slab", () -> new OrangeSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> PINK_SMOOTH_STONE_SLAB = BLOCKS.register("pink_smooth_stone_slab", () -> new PinkSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> PURPLE_SMOOTH_STONE_SLAB = BLOCKS.register("purple_smooth_stone_slab", () -> new PurpleSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> RED_SMOOTH_STONE_SLAB = BLOCKS.register("red_smooth_stone_slab", () -> new RedSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> WHITE_SMOOTH_STONE_SLAB = BLOCKS.register("white_smooth_stone_slab", () -> new WhiteSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> YELLOW_SMOOTH_STONE_SLAB = BLOCKS.register("yellow_smooth_stone_slab", () -> new YellowSmoothStoneSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F, 6.0F)
    ));
    public static final RegistryObject<Block> ZURK_BLOCK = BLOCKS.register("zurk_block", () -> new ZurkBlock(
            Block.Properties.create(Material.EARTH)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(200.0F)
    ));
    public static final RegistryObject<Block> ZUNK_BLOCK = BLOCKS.register("zunk_block", () -> new ZunkBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(40.0F)
    ));
    public static final RegistryObject<Block> BLACK_COBBLESTONE_STAIRS = BLOCKS.register("black_cobblestone_stairs", () -> new BlackCobblestoneStairs(
            () -> BLACK_COBBLESTONE.get().getDefaultState(), Block.Properties.from(BLACK_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> BLACK_SMOOTH_STONE_STAIRS = BLOCKS.register("black_smooth_stone_stairs", () -> new BlackSmoothStoneStairs(
            () -> BLACK_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(BLACK_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> BLACK_STONE_STAIRS = BLOCKS.register("black_stone_stairs", () -> new BlackStoneStairs(
            () -> BLACK_STONE.get().getDefaultState(), Block.Properties.from(BLACK_STONE.get())
    ));
    public static final RegistryObject<Block> BLUE_COBBLESTONE_STAIRS = BLOCKS.register("blue_cobblestone_stairs", () -> new BlueCobblestoneStairs(
            () -> BLUE_COBBLESTONE.get().getDefaultState(), Block.Properties.from(BLUE_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> BLUE_SMOOTH_STONE_STAIRS = BLOCKS.register("blue_smooth_stone_stairs", () -> new BlueSmoothStoneStairs(
            () -> BLUE_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(BLUE_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> BLUE_STONE_STAIRS = BLOCKS.register("blue_stone_stairs", () -> new BlueStoneStairs(
            () -> BLUE_STONE.get().getDefaultState(), Block.Properties.from(BLUE_STONE.get())
    ));
    public static final RegistryObject<Block> BROWN_COBBLESTONE_STAIRS = BLOCKS.register("brown_cobblestone_stairs", () -> new BrownCobblestoneStairs(
            () -> BROWN_COBBLESTONE.get().getDefaultState(), Block.Properties.from(BROWN_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> BROWN_SMOOTH_STONE_STAIRS = BLOCKS.register("brown_smooth_stone_stairs", () -> new BrownSmoothStoneStairs(
            () -> BROWN_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(BROWN_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> BROWN_STONE_STAIRS = BLOCKS.register("brown_stone_stairs", () -> new BrownStoneStairs(
            () -> BROWN_STONE.get().getDefaultState(), Block.Properties.from(BROWN_STONE.get())
    ));
    public static final RegistryObject<Block> CYAN_COBBLESTONE_STAIRS = BLOCKS.register("cyan_cobblestone_stairs", () -> new CyanCobblestoneStairs(
            () -> CYAN_COBBLESTONE.get().getDefaultState(), Block.Properties.from(CYAN_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> CYAN_SMOOTH_STONE_STAIRS = BLOCKS.register("cyan_smooth_stone_stairs", () -> new CyanSmoothStoneStairs(
            () -> CYAN_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(CYAN_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> CYAN_STONE_STAIRS = BLOCKS.register("cyan_stone_stairs", () -> new CyanStoneStairs(
            () -> CYAN_STONE.get().getDefaultState(), Block.Properties.from(CYAN_STONE.get())
    ));
    public static final RegistryObject<Block> GREEN_COBBLESTONE_STAIRS = BLOCKS.register("green_cobblestone_stairs", () -> new GreenCobblestoneStairs(
            () -> GREEN_COBBLESTONE.get().getDefaultState(), Block.Properties.from(GREEN_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> GREEN_SMOOTH_STONE_STAIRS = BLOCKS.register("green_smooth_stone_stairs", () -> new GreenSmoothStoneStairs(
            () -> GREEN_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(GREEN_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> GREEN_STONE_STAIRS = BLOCKS.register("green_stone_stairs", () -> new GreenStoneStairs(
            () -> GREEN_STONE.get().getDefaultState(), Block.Properties.from(GREEN_STONE.get())
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_COBBLESTONE_STAIRS = BLOCKS.register("light_blue_cobblestone_stairs", () -> new LightBlueCobblestoneStairs(
            () -> LIGHT_BLUE_COBBLESTONE.get().getDefaultState(), Block.Properties.from(LIGHT_BLUE_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_SMOOTH_STONE_STAIRS = BLOCKS.register("light_blue_smooth_stone_stairs", () -> new LightBlueSmoothStoneStairs(
            () -> LIGHT_BLUE_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(LIGHT_BLUE_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_STAIRS = BLOCKS.register("light_blue_stone_stairs", () -> new LightBlueStoneStairs(
            () -> LIGHT_BLUE_STONE.get().getDefaultState(), Block.Properties.from(LIGHT_BLUE_STONE.get())
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_COBBLESTONE_STAIRS = BLOCKS.register("light_blue1_cobblestone_stairs", () -> new LightBlue1CobblestoneStairs(
            () -> LIGHT_BLUE1_COBBLESTONE.get().getDefaultState(), Block.Properties.from(LIGHT_BLUE1_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_SMOOTH_STONE_STAIRS = BLOCKS.register("light_blue1_smooth_stone_stairs", () -> new LightBlue1SmoothStoneStairs(
            () -> LIGHT_BLUE1_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(LIGHT_BLUE1_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_STAIRS = BLOCKS.register("light_blue1_stone_stairs", () -> new LightBlue1StoneStairs(
            () -> LIGHT_BLUE1_STONE.get().getDefaultState(), Block.Properties.from(LIGHT_BLUE1_STONE.get())
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_COBBLESTONE_STAIRS = BLOCKS.register("light_gray_cobblestone_stairs", () -> new LightGrayCobblestoneStairs(
            () -> LIGHT_GRAY_COBBLESTONE.get().getDefaultState(), Block.Properties.from(LIGHT_GRAY_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_SMOOTH_STONE_STAIRS = BLOCKS.register("light_gray_smooth_stone_stairs", () -> new LightGraySmoothStoneStairs(
            () -> LIGHT_GRAY_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(LIGHT_GRAY_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_STAIRS = BLOCKS.register("light_gray_stone_stairs", () -> new LightGrayStoneStairs(
            () -> LIGHT_GRAY_STONE.get().getDefaultState(), Block.Properties.from(LIGHT_GRAY_STONE.get())
    ));
    public static final RegistryObject<Block> LIME_COBBLESTONE_STAIRS = BLOCKS.register("lime_cobblestone_stairs", () -> new LimeCobblestoneStairs(
            () -> LIME_COBBLESTONE.get().getDefaultState(), Block.Properties.from(LIME_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> LIME_SMOOTH_STONE_STAIRS = BLOCKS.register("lime_smooth_stone_stairs", () -> new LimeSmoothStoneStairs(
            () -> LIME_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(LIME_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> LIME_STONE_STAIRS = BLOCKS.register("lime_stone_stairs", () -> new LightGrayStoneStairs(
            () -> LIME_STONE.get().getDefaultState(), Block.Properties.from(LIME_STONE.get())
    ));
    public static final RegistryObject<Block> MAGENTA_COBBLESTONE_STAIRS = BLOCKS.register("magenta_cobblestone_stairs", () -> new MagentaCobblestoneStairs(
            () -> MAGENTA_COBBLESTONE.get().getDefaultState(), Block.Properties.from(MAGENTA_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> MAGENTA_SMOOTH_STONE_STAIRS = BLOCKS.register("magenta_smooth_stone_stairs", () -> new MagentaCobblestoneStairs(
            () -> MAGENTA_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(MAGENTA_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> MAGENTA_STONE_STAIRS = BLOCKS.register("magenta_stone_stairs", () -> new MagentaStoneStairs(
            () -> MAGENTA_STONE.get().getDefaultState(), Block.Properties.from(MAGENTA_STONE.get())
    ));
    public static final RegistryObject<Block> ORANGE_COBBLESTONE_STAIRS = BLOCKS.register("orange_cobblestone_stairs", () -> new OrangeCobblestoneStairs(
            () -> ORANGE_COBBLESTONE.get().getDefaultState(), Block.Properties.from(ORANGE_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> ORANGE_SMOOTH_STONE_STAIRS = BLOCKS.register("orange_smooth_stone_stairs", () -> new OrangeCobblestoneStairs(
            () -> ORANGE_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(ORANGE_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> ORANGE_STONE_STAIRS = BLOCKS.register("orange_stone_stairs", () -> new OrangeStoneStairs(
            () -> ORANGE_STONE.get().getDefaultState(), Block.Properties.from(ORANGE_STONE.get())
    ));
    public static final RegistryObject<Block> PINK_COBBLESTONE_STAIRS = BLOCKS.register("pink_cobblestone_stairs", () -> new PinkCobblestoneStairs(
            () -> PINK_COBBLESTONE.get().getDefaultState(), Block.Properties.from(PINK_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> PINK_SMOOTH_STONE_STAIRS = BLOCKS.register("pink_smooth_stone_stairs", () -> new PinkCobblestoneStairs(
            () -> PINK_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(PINK_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> PINK_STONE_STAIRS = BLOCKS.register("pink_stone_stairs", () -> new PinkStoneStairs(
            () -> PINK_STONE.get().getDefaultState(), Block.Properties.from(PINK_STONE.get())
    ));
    public static final RegistryObject<Block> PURPLE_COBBLESTONE_STAIRS = BLOCKS.register("purple_cobblestone_stairs", () -> new PurpleCobblestoneStairs(
            () -> PURPLE_COBBLESTONE.get().getDefaultState(), Block.Properties.from(PURPLE_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> PURPLE_SMOOTH_STONE_STAIRS = BLOCKS.register("purple_smooth_stone_stairs", () -> new PurpleCobblestoneStairs(
            () -> PURPLE_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(PURPLE_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> PURPLE_STONE_STAIRS = BLOCKS.register("purple_stone_stairs", () -> new PurpleStoneStairs(
            () -> PURPLE_STONE.get().getDefaultState(), Block.Properties.from(PURPLE_STONE.get())
    ));
    public static final RegistryObject<Block> RED_COBBLESTONE_STAIRS = BLOCKS.register("red_cobblestone_stairs", () -> new RedCobblestoneStairs(
            () -> RED_COBBLESTONE.get().getDefaultState(), Block.Properties.from(RED_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> RED_SMOOTH_STONE_STAIRS = BLOCKS.register("red_smooth_stone_stairs", () -> new RedCobblestoneStairs(
            () -> RED_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(RED_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> RED_STONE_STAIRS = BLOCKS.register("red_stone_stairs", () -> new RedStoneStairs(
            () -> RED_STONE.get().getDefaultState(), Block.Properties.from(RED_STONE.get())
    ));
    public static final RegistryObject<Block> WHITE_COBBLESTONE_STAIRS = BLOCKS.register("white_cobblestone_stairs", () -> new WhiteCobblestoneStairs(
            () -> WHITE_COBBLESTONE.get().getDefaultState(), Block.Properties.from(WHITE_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> WHITE_SMOOTH_STONE_STAIRS = BLOCKS.register("white_smooth_stone_stairs", () -> new WhiteCobblestoneStairs(
            () -> WHITE_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(WHITE_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> WHITE_STONE_STAIRS = BLOCKS.register("white_stone_stairs", () -> new WhiteStoneStairs(
            () -> WHITE_STONE.get().getDefaultState(), Block.Properties.from(WHITE_STONE.get())
    ));
    public static final RegistryObject<Block> YELLOW_COBBLESTONE_STAIRS = BLOCKS.register("yellow_cobblestone_stairs", () -> new YellowCobblestoneStairs(
            () -> YELLOW_COBBLESTONE.get().getDefaultState(), Block.Properties.from(YELLOW_COBBLESTONE.get())
    ));
    public static final RegistryObject<Block> YELLOW_SMOOTH_STONE_STAIRS = BLOCKS.register("yellow_smooth_stone_stairs", () -> new YellowCobblestoneStairs(
            () -> YELLOW_SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(YELLOW_SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> YELLOW_STONE_STAIRS = BLOCKS.register("yellow_stone_stairs", () -> new YellowStoneStairs(
            () -> YELLOW_STONE.get().getDefaultState(), Block.Properties.from(YELLOW_STONE.get())
    ));
    public static final RegistryObject<Block> SMOOTH_STONE = BLOCKS.register("smooth_stone", () -> new SmoothStone(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.5F, 6.0F)
    ));
    public static final RegistryObject<Block> SMOOTH_STONE_STAIRS = BLOCKS.register("smooth_stone_stairs", () -> new SmoothStoneStairs(
            () -> SMOOTH_STONE.get().getDefaultState(), Block.Properties.from(SMOOTH_STONE.get())
    ));
    public static final RegistryObject<Block> FREIN_BLOCK = BLOCKS.register("frein_block", () -> new FreinBlock(
            Block.Properties.create(Material.CLAY)
                    .slipperiness(1.0F)
                    .sound(SoundType.SLIME)
                    .zeroHardnessAndResistance()
                    .notSolid()
                    .jumpFactor(6)
    ));
    public static final RegistryObject<Block> GANK_BLOCK = BLOCKS.register("gank_block", () -> new GankBlock(
            AbstractBlock.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(990.0F)
    ));
    public static final RegistryObject<Block> FIRG_SAPLING = BLOCKS.register("firg_sapling", () -> new ModSaplingBlock(
            () -> new FirgTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)
    ));
    public static final RegistryObject<Block> FIRG_LOG = BLOCKS.register("firg_log", () -> new FirgLog(
            MaterialColor.WOOD, AbstractBlock.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0F)
            .sound(SoundType.WOOD)
    ));
    /*public static final RegistryObject<Block> FIRG_LEAVES = BLOCKS.register("firg_leaves", () -> new FirgLeaves(
            Block.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F)
                    .tickRandomly()
                    .sound(SoundType.PLANT)
                    .notSolid()
    ));*/
    public static final RegistryObject<Block> FIRG_PLANKS = BLOCKS.register("firg_planks", () -> new FirgPlanks(
            AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> FIRG_STAIRS = BLOCKS.register("firg_stairs", () -> new FirgStairs(
            () -> FIRG_PLANKS.get().getDefaultState(), Block.Properties.from(FIRG_PLANKS.get())
    ));
    public static final RegistryObject<Block> FIRG_SLAB = BLOCKS.register("firg_slab", () -> new FirgSlab(
            Block.Properties.create(Material.WOOD)
                    .harvestLevel(0)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> STRIPPED_FIRG_LOG = BLOCKS.register("stripped_firg_log", () -> new StrippedFirgLog(
            MaterialColor.WOOD, Block.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0F)
            .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> STRIPPED_FRIM_LOG = BLOCKS.register("stripped_frim_log", () -> new StrippedFrimLog(
            MaterialColor.WOOD, Block.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0F)
            .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> FIRG_WOOD = BLOCKS.register("firg_wood", () -> new FirgWood(
            Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> FRIM_WOOD = BLOCKS.register("frim_wood", () -> new StrippedFrimWood(
            Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> STRIPPED_FIRG_WOOD = BLOCKS.register("stripped_firg_wood", () -> new StrippedFirgWood(
            Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> STRIPPED_FRIM_WOOD = BLOCKS.register("stripped_frim_wood", () -> new StrippedFrimWood(
            Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> GANK_SLAB = BLOCKS.register("gank_slab", () -> new GankSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(990.0F, 1000.0F)
    ));
    /*public static final RegistryObject<Block> FIRG_DOOR = BLOCKS.register("firg_door", () -> new FirgDoor(
            Block.Properties.create(Material.WOOD, MaterialColor.WOOD)
            .hardnessAndResistance(3.0F)
            .sound(SoundType.WOOD)
            .notSolid()
    ));*/
    public static final RegistryObject<Block> ENDER_TRASK_1 = BLOCKS.register("ender_trask_1", () -> new EnderTrask1(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .harvestLevel(6)
                    .hardnessAndResistance(160.0f)
    ));
    public static final RegistryObject<Block> RUGK_BLOCK = BLOCKS.register("rugk_block", () -> new RugkBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3590.0f)
    ));
    /*public static final RegistryObject<Block> JURK = BLOCKS.register("jurk", () -> new JurkFlowingFluid(
            () -> ModFluids.JURK, Block.Properties.create(Material.WATER)
            .doesNotBlockMovement()
            .hardnessAndResistance(100.0F)
            .noDrops()
    ));*/
    public static final RegistryObject<Block> DURT = BLOCKS.register("durt", () -> new Durt(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(30.0f, 400.0f)
    ));
    /*public static final RegistryObject<Block> JURK = BLOCKS.register("jurk", () -> new Block(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .hardnessAndResistance(30.0f, 400.0f)
    ));*/
    public static final RegistryObject<Block> GRITK_BLOCK_1 = BLOCKS.register("gritk_block_1", () -> new GritkBlock1(
            Block.Properties.create(Material.IRON)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .setLightLevel(Value -> 15)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(500000.0F, 1200000.0F)
    ));
    public static final RegistryObject<Block> FRIM_LOG = BLOCKS.register("frim_log", () -> new FrimLog(
            MaterialColor.WOOD, Block.Properties.create(Material.WOOD)
            .hardnessAndResistance(2.0F)
            .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> FRIM_SAPLING = BLOCKS.register("frim_sapling", () -> new ModSaplingBlock(
            () -> new FrimTree(), AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)
    ));
    public static final RegistryObject<Block> LEAVES = BLOCKS.register("leaves", () -> new Leaves(
            Block.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F)
                    .tickRandomly()
                    .sound(SoundType.PLANT)
                    .notSolid()
    ));
    public static final RegistryObject<Block> FRIM_LEAVES = BLOCKS.register("frim_leaves", () -> new FrimLeaves(
            Block.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F)
                    .tickRandomly()
                    .sound(SoundType.PLANT)
                    .notSolid()
    ));
    public static final RegistryObject<Block> ZUNK_SLAB = BLOCKS.register("zunk_slab", () -> new ZunkSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(40.0F, 50.0F)
    ));
    public static final RegistryObject<Block> ZURK_SLAB = BLOCKS.register("zurk_slab", () -> new ZurkSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(200.0F, 210.0F)
    ));
    public static final RegistryObject<Block> RUGK_SLAB = BLOCKS.register("rugk_slab", () -> new RugkSlab(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3590.0F, 3600.0F)
    ));
    public static final RegistryObject<Block> BLACK_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/black_tripwire_hook", () -> new BlackTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> BLACK_TRIPWIRE = BLOCKS.register("tripwires/black_string", () -> new BlackTripWire(
            (BlackTripWireHook) BLACK_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> BLUE_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/blue_tripwire_hook", () -> new BlueTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> BLUE_TRIPWIRE = BLOCKS.register("tripwires/blue_string", () -> new BlueTripWire(
            (BlueTripWireHook) BLUE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> BROWN_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/brown_tripwire_hook", () -> new BrownTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> BROWN_TRIPWIRE = BLOCKS.register("tripwires/brown_string", () -> new BrownTripWire(
            (BrownTripWireHook) BROWN_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> CYAN_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/cyan_tripwire_hook", () -> new CyanTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> CYAN_TRIPWIRE = BLOCKS.register("tripwires/cyan_string", () -> new CyanTripWire(
            (CyanTripWireHook) CYAN_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> GRAY_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/gray_tripwire_hook", () -> new GrayTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> GRAY_TRIPWIRE = BLOCKS.register("tripwires/gray_string", () -> new GrayTripWire(
            (GrayTripWireHook) GRAY_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> GREEN_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/green_tripwire_hook", () -> new GreenTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> GREEN_TRIPWIRE = BLOCKS.register("tripwires/green_string", () -> new GreenTripWire(
            (GreenTripWireHook) GREEN_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/light_blue_tripwire_hook", () -> new LightBlueTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_TRIPWIRE = BLOCKS.register("tripwires/light_blue_string", () -> new LightBlueTripWire(
            (LightBlueTripWireHook) LIGHT_BLUE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/light_gray_tripwire_hook", () -> new LightGrayTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_TRIPWIRE = BLOCKS.register("tripwires/light_gray_string", () -> new LightGrayTripWire(
            (LightGrayTripWireHook) LIGHT_GRAY_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> LIME_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/lime_tripwire_hook", () -> new LimeTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> LIME_TRIPWIRE = BLOCKS.register("tripwires/lime_string", () -> new LimeTripWire(
            (LimeTripWireHook) LIME_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> MAGENTA_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/magenta_tripwire_hook", () -> new MagentaTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> MAGENTA_TRIPWIRE = BLOCKS.register("tripwires/magenta_string", () -> new MagentaTripWire(
            (MagentaTripWireHook) MAGENTA_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> ORANGE_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/orange_tripwire_hook", () -> new OrangeTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> ORANGE_TRIPWIRE = BLOCKS.register("tripwires/orange_string", () -> new OrangeTripWire(
            (OrangeTripWireHook) ORANGE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> PINK_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/pink_tripwire_hook", () -> new PinkTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> PINK_TRIPWIRE = BLOCKS.register("tripwires/pink_string", () -> new PinkTripWire(
            (PinkTripWireHook) PINK_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> PURPLE_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/purple_tripwire_hook", () -> new PurpleTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> PURPLE_TRIPWIRE = BLOCKS.register("tripwires/purple_string", () -> new PurpleTripWire(
            (PurpleTripWireHook) PURPLE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> RED_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/red_tripwire_hook", () -> new RedTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> RED_TRIPWIRE = BLOCKS.register("tripwires/red_string", () -> new RedTripWire(
            (RedTripWireHook) RED_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> YELLOW_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/yellow_tripwire_hook", () -> new YellowTripWireHook(
            Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> YELLOW_TRIPWIRE = BLOCKS.register("tripwires/yellow_string", () -> new YellowTripWire(
            (YellowTripWireHook) YELLOW_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()
    ));
    public static final RegistryObject<Block> GRINTH_MUSHROOM = BLOCKS.register("brown_mushroom", () -> new GrinthMushroom(
            Block.Properties.create(Material.PLANTS)
                    .zeroHardnessAndResistance()
                    .doesNotBlockMovement()
                    .tickRandomly()
                    .sound(SoundType.PLANT)
                    .setLightLevel(Value -> 1)
    ));
    public static final RegistryObject<Block> FRIM_PLANKS = BLOCKS.register("frim_planks", () -> new FrimPlanks(
            Block.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> DIAMOND_BLOCK = BLOCKS.register("diamond_block", () -> new DiamondBlock(
            Block.Properties.create(Material.IRON, MaterialColor.DIAMOND)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> DIAMOND_STAIRS = BLOCKS.register("diamond_stairs", () -> new DiamondStairs(
            () -> DIAMOND_BLOCK.get().getDefaultState(), Block.Properties.from(DIAMOND_BLOCK.get())
    ));
    public static final RegistryObject<Block> CRASK = BLOCKS.register("crask", () -> new Crask(
            Block.Properties.create(Material.WOOL)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> TARG_STAGE = BLOCKS.register("crops/targ_stage", () -> new TargCropsBlock(
            Block.Properties.create(Material.PLANTS)
                    .zeroHardnessAndResistance()
                    .doesNotBlockMovement()
                    .tickRandomly()
                    .sound(SoundType.CROP)
    ));
    /*public static final Block1 RUGK_SLAB = BLOCKS.register("rugk_slab", () -> new Block1(
   //         Block1.Properties.create(Material1.ROCK)
   //                 .harvestLevel1(4)
   //                 .harvestTool1(ToolType1.HOE)
   //                 .hardnessAndResistance1(3590.0F, 3600.0F)
    ));*/
    /*public static final RegistryObject<Block> MILK = BLOCKS.register("milk", () -> new FlowingFluidBlock1(
            () -> FluidInit.MILK_FLUID.get(), Block.Properties.create(Material.WATER)
            .doesNotBlockMovement()
            .hardnessAndResistance(100.0F)
            .noDrops()
    ));*/
    public static final RegistryObject<Block> GRITH_BLOCK = BLOCKS.register("grith_block", () -> new GrithBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(30)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000000.0F)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> TRUGK_BLOCK = BLOCKS.register("trugk_block", () -> new TrugkBlock(
            Block.Properties.create(Material.EARTH)
                    .setRequiresTool()
                    .harvestLevel(13)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(50000.0F)
    ));
    public static final RegistryObject<Block> EXAMPLE_PORTAL_BLOCK = BLOCKS.register("example_portal_block", () -> new ExamplePortalBlock(
            AbstractBlock.Properties.create(Material.PORTAL)
                    .doesNotBlockMovement()
                    .tickRandomly()
                    .hardnessAndResistance(-1.0F)
                    .sound(SoundType.GLASS)
                    .setLightLevel(LightValue -> 11)
    ));
    public static final RegistryObject<Block> RED_GRASS_BLOCK = BLOCKS.register("red_grass_block", () -> new RedGrassBlock(
            Block.Properties.create(Material.ORGANIC)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(0.6F)
                    .sound(SoundType.PLANT)
                    .tickRandomly()
    ));
    public static final RegistryObject<Block> GRINTH_MUSHROOM_BLOCK = BLOCKS.register("grinth_mushroom_block", () -> new HugeMushroomBlock(
            Block.Properties.create(Material.WOOD, MaterialColor.GREEN)
                    .setRequiresTool()
                    .hardnessAndResistance(0.2F)
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> BLACK_IRON_BLOCK = BLOCKS.register("iron_block/black_iron_block", () -> new BlackIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> BLUE_IRON_BLOCK = BLOCKS.register("iron_block/blue_iron_block", () -> new BlueIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> BROWN_IRON_BLOCK = BLOCKS.register("iron_block/brown_iron_block", () -> new BrownIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> CYAN_IRON_BLOCK = BLOCKS.register("iron_block/cyan_iron_block", () -> new CyanIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> GRAY_IRON_BLOCK = BLOCKS.register("iron_block/gray_iron_block", () -> new GrayIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> GREEN_IRON_BLOCK = BLOCKS.register("iron_block/green_iron_block", () -> new GreenIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_IRON_BLOCK = BLOCKS.register("iron_block/light_blue_iron_block", () -> new LightBlueIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_IRON_BLOCK = BLOCKS.register("iron_block/light_blue1_iron_block", () -> new LightBlue1IronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_IRON_BLOCK = BLOCKS.register("iron_block/light_gray_iron_block", () -> new LightGrayIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIME_IRON_BLOCK = BLOCKS.register("iron_block/lime_iron_block", () -> new LimeIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> MAGENTA_IRON_BLOCK = BLOCKS.register("iron_block/magenta_iron_block", () -> new MagentaIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> ORANGE_IRON_BLOCK = BLOCKS.register("iron_block/orange_iron_block", () -> new OrangeIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> PINK_IRON_BLOCK = BLOCKS.register("iron_block/pink_iron_block", () -> new PinkIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> PURPLE_IRON_BLOCK = BLOCKS.register("iron_block/purple_iron_block", () -> new PurpleIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> RED_IRON_BLOCK = BLOCKS.register("iron_block/red_iron_block", () -> new RedIronBlock(
            Block.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> YELLOW_IRON_BLOCK = BLOCKS.register("iron_block/yellow_iron_block", () -> new YellowIronBlock(
            AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON)
                    .setRequiresTool()
                    .hardnessAndResistance(5.0F, 6.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> BLACK_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/black_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> BLUE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/blue_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> BROWN_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/brown_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> CYAN_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/cyan_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> GREEN_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/green_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/light_blue_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/light_blue1_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/light_gray_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIME_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/lime_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> MAGENTA_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/magenta_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> ORANGE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/orange_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> PINK_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/pink_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> PURPLE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/purple_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> RED_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/red_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> WHITE_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/white_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> YELLOW_STONE_BLACK_IRON_ORE = BLOCKS.register("iron_ores/yellow_stone/black_iron_ore", () -> new BlackIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> BLACK_STONE_IRON_ORE = BLOCKS.register("iron_ores/black_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> BLUE_STONE_IRON_ORE = BLOCKS.register("iron_ores/blue_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> BROWN_STONE_IRON_ORE = BLOCKS.register("iron_ores/brown_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> CYAN_STONE_IRON_ORE = BLOCKS.register("iron_ores/cyan_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> GREEN_STONE_IRON_ORE = BLOCKS.register("iron_ores/green_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_STONE_IRON_ORE = BLOCKS.register("iron_ores/light_blue_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE1_STONE_IRON_ORE = BLOCKS.register("iron_ores/light_blue1_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_IRON_ORE = BLOCKS.register("iron_ores/light_gray_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> LIME_STONE_IRON_ORE = BLOCKS.register("iron_ores/lime_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> MAGENTA_STONE_IRON_ORE = BLOCKS.register("iron_ores/magenta_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> ORANGE_STONE_IRON_ORE = BLOCKS.register("iron_ores/orange_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> PINK_STONE_IRON_ORE = BLOCKS.register("iron_ores/pink_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> PURPLE_STONE_IRON_ORE = BLOCKS.register("iron_ores/purple_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> RED_STONE_IRON_ORE = BLOCKS.register("iron_ores/red_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> WHITE_STONE_IRON_ORE = BLOCKS.register("iron_ores/white_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> YELLOW_STONE_IRON_ORE = BLOCKS.register("iron_ores/yellow_stone/iron_ore", () -> new IronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> BLACK_STONE_RED_IRON_ORE = BLOCKS.register("iron_ores/black_stone/red_iron_ore", () -> new RedIronOre(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.METAL)
    ));
    public static final RegistryObject<Block> SRIUNK_SLAB1 = BLOCKS.register("sriunk_slab1", () -> new SriunkSlab1(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100.0F, 2500.0F)
    ));
    public static final RegistryObject<Block> NIRTK = BLOCKS.register("nirtk", () -> new Nirtk(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1.0F, 1000000000000000.0F)
    ));
    public static final RegistryObject<Block> NIRTKB = BLOCKS.register("nirtkb", () -> new Nirtkb(
            14406560, AbstractBlock.Properties.create(Material.SAND)
            .hardnessAndResistance(5.0F)
    ));
    public static final RegistryObject<Block> JURK = BLOCKS.register("fluid/jurk", () -> new FlowingFluidBlock(
            FluidInit.JURK, AbstractBlock.Properties.create(Material.WATER)
            .doesNotBlockMovement()
            .tickRandomly()
            .hardnessAndResistance(100.0F)
            .setLightLevel(Value -> 6)
            .noDrops()
    ));
    public static final RegistryObject<Block> ACACIA_PLANKS1 = BLOCKS.register("acacia_planks1", () -> new AcaciaPlanks1(
            AbstractBlock.Properties.create(Material.WOOD, MaterialColor.ADOBE)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .doesNotBlockMovement()
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> BIRCH_PLANKS1 = BLOCKS.register("birch_planks1", () -> new BirchPlanks1(
            AbstractBlock.Properties.create(Material.WOOD, MaterialColor.SAND)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .doesNotBlockMovement()
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> DARK_OAK_PLANKS1 = BLOCKS.register("dark_oak_planks1", () -> new DarkOakPlanks1(
            AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .doesNotBlockMovement()
                    .sound(SoundType.WOOD)
    ));
    /*public static final RegistryObject<Block> FIRG_PLANKS1 = BLOCKS.register("firg_planks1", () -> new FirgPlanks(
            Block.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
    ));*/
    public static final RegistryObject<Block> JUNGLE_PLANKS1 = BLOCKS.register("jungle_planks1", () -> new JunglePlanks1(
            AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .doesNotBlockMovement()
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> OAK_PLANKS1 = BLOCKS.register("oak_planks1", () -> new OakPlanks1(
            AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .doesNotBlockMovement()
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> SPRUCE_PLANKS1 = BLOCKS.register("spruce_planks1", () -> new SprucePlanks1(
            AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN)
                    .hardnessAndResistance(2.0F, 3.0F)
                    .doesNotBlockMovement()
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore", () -> new OreBlock1(
            AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .setRequiresTool()
                    .hardnessAndResistance(3.0F, 3.0F)
                    .sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> REUTRIEN = BLOCKS.register("reutrien", () -> new Reutrien(
            AbstractBlock.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .hardnessAndResistance(5000.0F)
                    .sound(SoundType.METAL)
                    .notSolid()
    ));
}
