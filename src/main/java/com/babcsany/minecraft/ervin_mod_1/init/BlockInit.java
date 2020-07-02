package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> VILTDROP_BLOCK = BLOCKS.register("viltdrop_block", () -> new ViltdropBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000.0f)
    ));
    public static final RegistryObject<Block> SRIUNK_BLOCK = BLOCKS.register("sriunk_block", () -> new SriunkBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(500.0f)
    ));
    public static final RegistryObject<Block> TRUGN = BLOCKS.register("trugn", () -> new Trugn(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10000000.0f)
    ));
    public static final RegistryObject<Block> REGDEM_BLOCK = BLOCKS.register("regdem_block", () -> new RegdemBlock(
            Block.Properties.create(Material.WOOD)
                    .harvestLevel(0)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> LEAT_BLOCK = BLOCKS.register("leat_block", () -> new LeatBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> LEAT_BLOCK_CRAFTING_TABLE = BLOCKS.register("leat_block_crafting_table", () -> new LeatBlockCraftingTable(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.AXE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(500.0f)
    ));
    public static final RegistryObject<Block> CRAINT_BLOCK = BLOCKS.register("craint_block", () -> new CraintBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000.0f)
    ));
    public static final RegistryObject<Block> CRAINT_BLOCK_CRAFTING_TABLE = BLOCKS.register("craint_block_crafting_table", () -> new CraintBlockCraftingTable(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10000.0f)
    ));
    public static final RegistryObject<Block> NARIN_BLOCK = BLOCKS.register("narin_block", () -> new NarinBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5000.0f)
    ));
    public static final RegistryObject<Block> TERAT_BLOCK = BLOCKS.register("terat_block", () -> new TeratBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(32)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000.0f)
    ));
    public static final RegistryObject<Block> SRIUNK_ORE = BLOCKS.register("sriunk_ore", () -> new SriunkOre(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> NIRK_BLOCK = BLOCKS.register("nirk_block", () -> new NirkBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(20)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1562.0f)
    ));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new RubyBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> GRINT_BLOCK = BLOCKS.register("grint_block", () -> new GrintBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> RED_STONE = BLOCKS.register("red_stone", () -> new RedStone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> RED_COBBLESTONE = BLOCKS.register("red_cobblestone", () -> new RedCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,12.0F)
    ));
    public static final RegistryObject<Block> EPKIN = BLOCKS.register("epkin", () -> new Epkin(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000.0f)
    ));
    public static final RegistryObject<Block> RED_SMOOTH_STONE = BLOCKS.register("red_smooth_stone", () -> new RedSmoothStone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000.0f)
    ));
    public static final RegistryObject<Block> RED_FURANCE = BLOCKS.register("red_furance", () -> new RedFurance(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> AVTER_BLOCK = BLOCKS.register("avter_block", () -> new AvterBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(5)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6000.0f)
    ));
    public static final RegistryObject<Block> FIRG = BLOCKS.register("firg", () -> new Firg(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> FRIT_BLOCK = BLOCKS.register("frit_block", () -> new FritBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> END_PORTAL = BLOCKS.register("end_portal", () -> new EndPortal(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> SCRAFTH = BLOCKS.register("scrafth", () -> new Scrafth(
            Block.Properties.create(Material.AIR)
                    .harvestLevel(0)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACKHT = BLOCKS.register("ender_srackht", () -> new EnderSrackht(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(20.0f)
    ));
    public static final RegistryObject<Block> END_STONE_CISK = BLOCKS.register("end_stone_cisk", () -> new EndStoneCisk(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(30.0f)
    ));
    public static final RegistryObject<Block> END_STONE_CRISK = BLOCKS.register("end_stone_crisk", () -> new EndStoneCrisk(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(45.0f)
    ));
    public static final RegistryObject<Block> END_SRACT = BLOCKS.register("end_sract", () -> new EndSract(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(8.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACT = BLOCKS.register("ender_sract", () -> new EnderSract(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(9.0f)
    ));
    public static final RegistryObject<Block> ENDER_SACKT = BLOCKS.register("ender_sackt", () -> new EnderSackt(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> ENDER_SACT = BLOCKS.register("ender_sact", () -> new EnderSact(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(12.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACKH = BLOCKS.register("ender_srackh", () -> new EnderSrackh(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(14.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACK = BLOCKS.register("ender_srack", () -> new EnderSrack(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(16.0f)
    ));
    public static final RegistryObject<Block> END_SRACKT = BLOCKS.register("end_srackt", () -> new EndSrackt(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(16.0f)
    ));
    public static final RegistryObject<Block> VIRK_BLOCK = BLOCKS.register("virk_block", () -> new VirkBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(5)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(650.0f)
    ));
    public static final RegistryObject<Block> FIRT_BLOCK = BLOCKS.register("firt_block", () -> new FirtBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> TRING = BLOCKS.register("tring", () -> new Tring(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> PACK_BLOCK = BLOCKS.register("pack_block", () -> new PackBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> TIRKS_BLOCK = BLOCKS.register("tirks_block", () -> new TirksBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> SHZ_BLOCK = BLOCKS.register("shz_block", () -> new ShzBlock(
            Block.Properties.create(Material.ORGANIC)
                    .hardnessAndResistance(6000000.0f)
                    .lightValue(15)
    ));
    public static final RegistryObject<Block> TIRSK_BLOCK = BLOCKS.register("tirsk_block", () -> new TirskBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> KALT_BLOCK = BLOCKS.register("kalt_block", () -> new KaltBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> VILKT_BLOCK = BLOCKS.register("vilkt_block", () -> new VilktBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(60.0f, 60)
    ));
    public static final RegistryObject<Block> URVI = BLOCKS.register("urvi", () -> new Urvi(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3.0F,9.0F)
    ));
    public static final RegistryObject<Block> SURVI = BLOCKS.register("survi", () -> new Survi(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,9.0F)
    ));
    public static final RegistryObject<Block> SURV = BLOCKS.register("surv", () -> new Surv(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(4.0F,10.0F)
    ));
    public static final RegistryObject<Block> SURT = BLOCKS.register("surt", () -> new Surt(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5.0F,12.0F)
    ));
    public static final RegistryObject<Block> BLACK_COBBLESTONE = BLOCKS.register("black_cobblestone", () -> new BlackCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5.0F,12.0F)
    ));
    public static final RegistryObject<Block> BLUE_COBBLESTONE = BLOCKS.register("blue_cobblestone", () -> new BlueCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,12.0F)
    ));
    public static final RegistryObject<Block> BROWN_COBBLESTONE = BLOCKS.register("brown_cobblestone", () -> new BrownCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5.0F,12.0F)
    ));
    public static final RegistryObject<Block> CYAN_COBBLESTONE = BLOCKS.register("cyan_cobblestone", () -> new CyanCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,12.0F)
    ));
    public static final RegistryObject<Block> GREEN_COBBLESTONE = BLOCKS.register("green_cobblestone", () -> new GreenCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5.0F,12.0F)
    ));
    public static final RegistryObject<Block> LIGHT_BLUE_COBBLESTONE = BLOCKS.register("light_blue_cobblestone", () -> new LightBlueCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,12.0F)
    ));
    public static final RegistryObject<Block> LIME_COBBLESTONE = BLOCKS.register("lime_cobblestone", () -> new LimeCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5.0F,12.0F)
    ));
    public static final RegistryObject<Block> MAGENTA_COBBLESTONE = BLOCKS.register("magenta_cobblestone", () -> new MagentaCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,12.0F)
    ));
    public static final RegistryObject<Block> ORANGE_COBBLESTONE = BLOCKS.register("orange_cobblestone", () -> new OrangeCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,12.0F)
    ));
    public static final RegistryObject<Block> PINK_COBBLESTONE = BLOCKS.register("pink_cobblestone", () -> new PinkCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5.0F,12.0F)
    ));
    public static final RegistryObject<Block> PURPLE_COBBLESTONE = BLOCKS.register("purple_cobblestone", () -> new PurpleCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,12.0F)
    ));
    public static final RegistryObject<Block> WHITE_COBBLESTONE = BLOCKS.register("white_cobblestone", () -> new WhiteCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(5.0F,12.0F)
    ));
    public static final RegistryObject<Block> YELLOW_COBBLESTONE = BLOCKS.register("yellow_cobblestone", () -> new YellowCobblestone(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,12.0F)
    ));
    public static final RegistryObject<Block> NETHER_PORTAL = BLOCKS.register("nether_portal", () -> new NetherPortal(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(2.0F,12.0F)
    ));
    public static final RegistryObject<Block> ENDER_STAKRACH = BLOCKS.register("ender_stakrach", () -> new EnderStakrach(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(2)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(40.0f)
    ));
    public static final RegistryObject<Block> ENDER_SRACKTH = BLOCKS.register("ender_srackth", () -> new EnderSrackth(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(20.0f)
    ));
    public static final RegistryObject<Block> OAK_TURG = BLOCKS.register("oak_turg", () -> new EnderSrackth(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> ENDER_SRAKTCAF = BLOCKS.register("ender_sraktcaf", () -> new EnderSraktcaf(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(3)
                    .harvestTool(ToolType.SHOVEL)
                    .hardnessAndResistance(60.0f)
    ));
    public static final RegistryObject<Block> ENDER_TRASKRACH = BLOCKS.register("ender_traskrach", () -> new EnderTraskrach(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(4)
                    .hardnessAndResistance(80.0f)
    ));
    public static final RegistryObject<Block> ENDER_TRASKCRAFTH = BLOCKS.register("ender_traskcrafth", () -> new EnderTraskcrafth(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(5)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> ENDER_TRASK = BLOCKS.register("ender_trask", () -> new EnderTrask(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(6)
                    .hardnessAndResistance(160.0f)
    ));
    public static final RegistryObject<Block> VILKT_BLOCK_2 = BLOCKS.register("vilkt_block_2", () -> new VilktBlock2(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(6)
                    .hardnessAndResistance(160.0f)
    ));
    /*public static final RegistryObject<Block> SRIUNK_STAIRS = BLOCKS.register("sriunk_stairs", new StairsBlock(
            SRIUNK_BLOCK. Block.Properties.from(SRIUNK_BLOCK)
    ));*/
    public static final RegistryObject<Block> ACACIA_TURG = BLOCKS.register("acacia_turg", () -> new AcaciaTurg(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> BIRCH_TURG = BLOCKS.register("birch_turg", () -> new BirchTurg(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> DARK_OAK_TURG = BLOCKS.register("dark_oak_turg", () -> new DarkOakTurg(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> JUNGLE_TURG = BLOCKS.register("jungle_turg", () -> new JungleTurg(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> SPRUCE_TURG = BLOCKS.register("spruce_turg", () -> new SpruceTurg(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
    public static final RegistryObject<Block> TURG = BLOCKS.register("turg", () -> new Turg(
            Block.Properties.create(Material.SPONGE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(20.0f).sound(SoundType.WOOD)
    ));
}
