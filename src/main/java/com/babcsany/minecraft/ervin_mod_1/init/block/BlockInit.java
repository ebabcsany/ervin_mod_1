package com.babcsany.minecraft.ervin_mod_1.init.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.Fighiv;
import com.babcsany.minecraft.ervin_mod_1.block.PoweredRailBlock;
import com.babcsany.minecraft.ervin_mod_1.block.TargCropsBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.TeratBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.TnuzkBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.VirkBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.minecraft.slabs.CoalSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.slabs.CharcoalSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.slabs.ZunkSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.stairs.CharcoalStairs;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.stairs.ZunkStairs;
import com.babcsany.minecraft.ervin_mod_1.block.tripwires.*;
import com.babcsany.minecraft.ervin_mod_1.block.tripwires.tripwire_hooks.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<Block> FRISZERN = BLOCKS.register("friszern", () -> new Friszern(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    //public static final RegistryObject<Block> CHAIN_FRISZERN = BLOCKS.register("chain_friszern", () -> new Friszern(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    //public static final RegistryObject<Block> REPEATING_FRISZERN = BLOCKS.register("repeater_friszern", () -> new Friszern(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final RegistryObject<Block> EXAMPLE_PORTAL_BLOCK = BLOCKS.register("example_portal_block", () -> new Block(AbstractBlock.Properties.from(Blocks.BEDROCK)/*create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).setLightLevel(LightValue -> 11)*/));
    public static final RegistryObject<Block> TARG_STAGE = BLOCKS.register("crops/targ_stage", () -> new TargCropsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().tickRandomly().sound(SoundType.CROP)));
    public static final RegistryObject<Block> FIRG = BLOCKS.register("firg", () -> new Firg(Block.Properties.create(Material.ROCK).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0f)));
    public static final RegistryObject<Block> FIRG_SLAB = BLOCKS.register("firg_slab", () -> new FirgSlab(Block.Properties.create(Material.ROCK).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0F, 15.0F)));
    public static final RegistryObject<Block> FIRG_STAIRS = BLOCKS.register("firg_stairs", () -> new FirgStairs(() -> FIRG.get().getDefaultState(), Block.Properties.from(FIRG.get())));
    public static final RegistryObject<Block> ENDER_SRACKHT = BLOCKS.register("ender_srackht", () -> new EnderSrackht(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(20.0f)));
    public static final RegistryObject<Block> ENDER_STAKRACH = BLOCKS.register("ender_stakrach", () -> new EnderStakrach(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(2).harvestTool(ToolType.AXE).hardnessAndResistance(40.0f)));
    public static final RegistryObject<Block> ENDER_SRAKTCAF = BLOCKS.register("ender_sraktcaf", () -> new EnderSraktcaf(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(3).harvestTool(ToolType.SHOVEL).hardnessAndResistance(60.0f)));
    public static final RegistryObject<Block> ENDER_TRASKRACH = BLOCKS.register("ender_traskrach", () -> new EnderTraskrach(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(4).hardnessAndResistance(80.0f)));
    public static final RegistryObject<Block> ENDER_TRASKCRAFTH = BLOCKS.register("ender_traskcrafth", () -> new EnderTraskcrafth(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(5).hardnessAndResistance(100.0f)));
    public static final RegistryObject<Block> SCRAFTH = BLOCKS.register("scrafth", () -> new Scrafth(Block.Properties.create(Material.ROCK).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0f)));
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
    public static final RegistryObject<Block> BLACK_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/black_tripwire_hook", () -> new BlackTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BLACK_TRIPWIRE = BLOCKS.register("tripwires/black_tripwire", () -> new BlackTripWire((BlackTripWireHook) BLACK_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BLUE_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/blue_tripwire_hook", () -> new BlueTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BLUE_TRIPWIRE = BLOCKS.register("tripwires/blue_tripwire", () -> new BlueTripWire((BlueTripWireHook) BLUE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BROWN_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/brown_tripwire_hook", () -> new BrownTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BROWN_TRIPWIRE = BLOCKS.register("tripwires/brown_tripwire", () -> new BrownTripWire((BrownTripWireHook) BROWN_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> CYAN_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/cyan_tripwire_hook", () -> new CyanTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> CYAN_TRIPWIRE = BLOCKS.register("tripwires/cyan_tripwire", () -> new CyanTripWire((CyanTripWireHook) CYAN_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GRAY_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/gray_tripwire_hook", () -> new GrayTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GRAY_TRIPWIRE = BLOCKS.register("tripwires/gray_tripwire", () -> new GrayTripWire((GrayTripWireHook) GRAY_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GREEN_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/green_tripwire_hook", () -> new GreenTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GREEN_TRIPWIRE = BLOCKS.register("tripwires/green_tripwire", () -> new GreenTripWire((GreenTripWireHook) GREEN_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_BLUE_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/light_blue_tripwire_hook", () -> new LightBlueTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_BLUE_TRIPWIRE = BLOCKS.register("tripwires/light_blue_tripwire", () -> new LightBlueTripWire((LightBlueTripWireHook) LIGHT_BLUE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_BLUE1_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/light_blue1_tripwire_hook", () -> new LightBlue1TripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_BLUE1_TRIPWIRE = BLOCKS.register("tripwires/light_blue1_tripwire", () -> new LightBlue1TripWire((LightBlue1TripWireHook) LIGHT_BLUE1_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_GRAY_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/light_gray_tripwire_hook", () -> new LightGrayTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_GRAY_TRIPWIRE = BLOCKS.register("tripwires/light_gray_tripwire", () -> new LightGrayTripWire((LightGrayTripWireHook) LIGHT_GRAY_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIME_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/lime_tripwire_hook", () -> new LimeTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIME_TRIPWIRE = BLOCKS.register("tripwires/lime_tripwire", () -> new LimeTripWire((LimeTripWireHook) LIME_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> MAGENTA_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/magenta_tripwire_hook", () -> new MagentaTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> MAGENTA_TRIPWIRE = BLOCKS.register("tripwires/magenta_tripwire", () -> new MagentaTripWire((MagentaTripWireHook) MAGENTA_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> ORANGE_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/orange_tripwire_hook", () -> new OrangeTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> ORANGE_TRIPWIRE = BLOCKS.register("tripwires/orange_tripwire", () -> new OrangeTripWire((OrangeTripWireHook) ORANGE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> PINK_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/pink_tripwire_hook", () -> new PinkTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> PINK_TRIPWIRE = BLOCKS.register("tripwires/pink_tripwire", () -> new PinkTripWire((PinkTripWireHook) PINK_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> PURPLE_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/purple_tripwire_hook", () -> new PurpleTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> PURPLE_TRIPWIRE = BLOCKS.register("tripwires/purple_tripwire", () -> new PurpleTripWire((PurpleTripWireHook) PURPLE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> RED_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/red_tripwire_hook", () -> new RedTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> RED_TRIPWIRE = BLOCKS.register("tripwires/red_tripwire", () -> new RedTripWire((RedTripWireHook) RED_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> YELLOW_TRIPWIRE_HOOK = BLOCKS.register("tripwires/tripwire_hooks/yellow_tripwire_hook", () -> new YellowTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> YELLOW_TRIPWIRE = BLOCKS.register("tripwires/yellow_tripwire", () -> new YellowTripWire((YellowTripWireHook) YELLOW_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GRINT_BLOCK = BLOCKS.register("grint_block", () -> new GrintBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(100.0f)));
    public static final RegistryObject<Block> GRINT_SLAB = BLOCKS.register("grint_slab", () -> new GrintSlab(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(120.0f)));
    public static final RegistryObject<Block> GRINT_STAIRS = BLOCKS.register("grint_stairs", () -> new GrintStairs(() -> GRINT_BLOCK.get().getDefaultState(), Block.Properties.from(GRINT_BLOCK.get())));
    public static final RegistryObject<Block> THUIRTH_RAIL = BLOCKS.register("thuirth_rail", () -> new PoweredRailBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(436.5F).sound(SoundType.METAL), true));
    public static final RegistryObject<Block> THUFR = BLOCKS.register("special/thufr", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(2543624320.5F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHARCOAL_BLOCK = BLOCKS.register("charcoal_block", () -> new CharcoalBlock(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5.0F, 6.0F)));
    public static final RegistryObject<Block> COAL_SLAB = BLOCKS.register("coal_slab", () -> new CoalSlab(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> CHARCOAL_SLAB = BLOCKS.register("charcoal_slab", () -> new CharcoalSlab(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> CHARCOAL_STAIRS = BLOCKS.register("charcoal_stairs", () -> new CharcoalStairs(() -> CHARCOAL_BLOCK.get().getDefaultState(), Block.Properties.from(CHARCOAL_BLOCK.get())));
    public static final RegistryObject<Block> FI_RT_PLOCK = BLOCKS.register("lc/blocks/fi_rt_plock", () -> new Fi_rt_plock(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5000000000.0F, 6.0F)));
}
