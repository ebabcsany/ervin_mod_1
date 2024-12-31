package com.babcsany.minecraft.ervin_mod_1.init.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.Fighiv;
import com.babcsany.minecraft.ervin_mod_1.block.ModPoweredRailBlock;
import com.babcsany.minecraft.ervin_mod_1.block.TargCropsBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.Firg;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.FirgSlab;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.FirgStairs;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.ModOreBlock;
import com.babcsany.minecraft.ervin_mod_1.block.tripwire.ModTripWireBlock;
import com.babcsany.minecraft.ervin_mod_1.block.tripwire.tripwire_hook.*;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.UnusedBlocks;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<Block> FRISZERN = BLOCKS.register("friszern", () -> new Friszern(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    //public static final RegistryObject<Block> CHAIN_FRISZERN = BLOCKS.register("chain_friszern", () -> new Friszern(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    //public static final RegistryObject<Block> REPEATING_FRISZERN = BLOCKS.register("repeater_friszern", () -> new Friszern(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final RegistryObject<Block> EXAMPLE_PORTAL_BLOCK = register("example_portal_block", () -> new Block(AbstractBlock.Properties.from(Blocks.BEDROCK)/*create(Material.PORTAL).doesNotBlockMovement().tickRandomly().hardnessAndResistance(-1.0F).sound(SoundType.GLASS).setLightLevel(LightValue -> 11)*/));
    public static final RegistryObject<Block> TARG_STAGE = register("crops/targ_stage", () -> new TargCropsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5F).doesNotBlockMovement().tickRandomly().sound(SoundType.CROP)));
    public static final RegistryObject<Block> FIRG = register("firg", () -> new Firg(Block.Properties.create(Material.ROCK).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0f)));
    public static final RegistryObject<Block> FIRG_SLAB = register("firg_slab", () -> BlockItemInit.createSlabBlock(Material.ROCK, 0, 10.0F, 15.0F, ToolType.PICKAXE));
    public static final RegistryObject<Block> FIRG_STAIRS = register("firg_stairs", () -> BlockItemInit.createStairsBlockFrom(FIRG));
    public static final RegistryObject<Block> ENDER_SRACKHT = register("ender_srackht", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(1).harvestTool(ToolType.PICKAXE).hardnessAndResistance(20.0f)));
    public static final RegistryObject<Block> ENDER_STAKRACH = register("ender_stakrach", () -> new Block(Block.Properties.create(Material.WOOD).setRequiresTool().harvestLevel(2).harvestTool(ToolType.AXE).hardnessAndResistance(40.0f)));
    public static final RegistryObject<Block> ENDER_SRAKTCAF = register("ender_sraktcaf", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(3).harvestTool(ToolType.SHOVEL).hardnessAndResistance(60.0f)));
    public static final RegistryObject<Block> ENDER_TRASKRACH = register("ender_traskrach", () -> new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(4).harvestTool(ToolType.HOE).hardnessAndResistance(80.0f)));
    public static final RegistryObject<Block> ENDER_TRASKCRAFTH = register("ender_traskcrafth", () -> new Block(Block.Properties.create(Material.ORGANIC).setRequiresTool().harvestLevel(5).hardnessAndResistance(100.0f)));
    public static final RegistryObject<Block> SCRAFTH = register("scrafth", () -> new Block(Block.Properties.create(Material.ROCK).harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(10.0f)));
    public static final RegistryObject<Block> VIRK_BLOCK = register("virk_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(5).harvestTool(ToolType.PICKAXE).hardnessAndResistance(650.0f)));
    //public static final RegistryObject<Block> JURK = BLOCKS.register("jurk", () -> new Block(AbstractBlock.Properties.create(MaterialInit.JURK).doesNotBlockMovement().tickRandomly().hardnessAndResistance(100.0F).setLightLevel(Value -> 4)));
    public static final RegistryObject<Block> TERAT_BLOCK = register("terat_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(32).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000.0f)));
    public static final RegistryObject<Block> GRITH_BLOCK = register("grith_block", () -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).setRequiresTool().harvestLevel(80).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000000000.0F).setLightLevel(Value -> 15)));
    public static final RegistryObject<Block> GRITH_SLAB = register("grith_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.SNOW).setRequiresTool().harvestLevel(78).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1000000000000000.0F,500000000000000.0F).setLightLevel(Value -> 15)));
    public static final RegistryObject<Block> GRITH_STAIRS = register("grith_stairs", () -> BlockItemInit.createStairsBlockFrom(GRITH_BLOCK));
    public static final RegistryObject<Block> ZUNK_BLOCK = register("zunk_block", () -> UnusedBlocks.setBlockRequiresTool(Material.ROCK, 1, 40.0F, ToolType.SHOVEL));
    public static final RegistryObject<Block> ZUNK_SLAB = register("zunk_slab", () -> BlockItemInit.createSlabBlock(Material.ROCK, 1, 30.0F, 50.0F, ToolType.SHOVEL));
    public static final RegistryObject<Block> ZUNK_STAIRS = register("zunk_stairs", () -> BlockItemInit.createStairsBlockFrom(ZUNK_BLOCK));
    public static final RegistryObject<Block> TNUZK_BLOCK = register("tnuzk_block", () -> UnusedBlocks.setBlockRequiresTool(Material.EARTH, 15, 100000.0F, ToolType.SHOVEL));
    public static final RegistryObject<Block> TNUZN = register("tnuzn", () -> UnusedBlocks.setBlockRequiresTool(Material.EARTH, 18, 20000000.0F, ToolType.SHOVEL));
    public static final RegistryObject<Block> FIGHIV = register("fighiv", () -> new Fighiv(Block.Properties.create(Material.ROCK).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(0.5F, 1000000000000.0F)));
    public static final RegistryObject<Block> GNRTHIRJ = register("gnrthirj", () -> new ModOreBlock(6, AbstractBlock.Properties.create(Material.BUBBLE_COLUMN).doesNotBlockMovement().noDrops()));
    public static final RegistryObject<Block> BLACK_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/black", () -> new BlackTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BLACK_TRIPWIRE = register("tripwires/black", () -> new ModTripWireBlock((ModTripWireHookBlock) BLACK_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BLUE_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/blue", () -> new BlueTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BLUE_TRIPWIRE = register("tripwires/blue", () -> new ModTripWireBlock((ModTripWireHookBlock) BLUE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BROWN_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/brown", () -> new BrownTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> BROWN_TRIPWIRE = register("tripwires/brown", () -> new ModTripWireBlock((ModTripWireHookBlock) BROWN_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> CYAN_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/cyan", () -> new CyanTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> CYAN_TRIPWIRE = register("tripwires/cyan", () -> new ModTripWireBlock((ModTripWireHookBlock) CYAN_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GRAY_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/gray", () -> new GrayTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GRAY_TRIPWIRE = register("tripwires/gray", () -> new ModTripWireBlock((ModTripWireHookBlock) GRAY_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GREEN_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/green", () -> new GrayTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GREEN_TRIPWIRE = register("tripwires/green", () -> new ModTripWireBlock((ModTripWireHookBlock) GREEN_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_BLUE_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/light_blue", () -> new GreenTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_BLUE_TRIPWIRE = register("tripwires/light_blue", () -> new ModTripWireBlock((ModTripWireHookBlock) LIGHT_BLUE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_BLUE1_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/light_blue1", () -> new LightBlueTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_BLUE1_TRIPWIRE = register("tripwires/light_blue1", () -> new ModTripWireBlock((ModTripWireHookBlock) LIGHT_BLUE1_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_GRAY_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/light_gray", () -> new LightGrayTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIGHT_GRAY_TRIPWIRE = register("tripwires/light_gray", () -> new ModTripWireBlock((ModTripWireHookBlock) LIGHT_GRAY_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIME_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/lime", () -> new LimeTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> LIME_TRIPWIRE = register("tripwires/lime", () -> new ModTripWireBlock((ModTripWireHookBlock) LIME_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> MAGENTA_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/magenta", () -> new MagentaTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> MAGENTA_TRIPWIRE = register("tripwires/magenta", () -> new ModTripWireBlock((ModTripWireHookBlock) MAGENTA_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> ORANGE_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/orange", () -> new OrangeTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> ORANGE_TRIPWIRE = register("tripwires/orange", () -> new ModTripWireBlock((ModTripWireHookBlock) ORANGE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> PINK_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/pink", () -> new PinkTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> PINK_TRIPWIRE = register("tripwires/pink", () -> new ModTripWireBlock((ModTripWireHookBlock) PINK_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> PURPLE_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/purple", () -> new PurpleTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> PURPLE_TRIPWIRE = register("tripwires/purple", () -> new ModTripWireBlock((ModTripWireHookBlock) PURPLE_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> RED_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/red", () -> new RedTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> RED_TRIPWIRE = register("tripwires/red", () -> new ModTripWireBlock((ModTripWireHookBlock) RED_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> YELLOW_TRIPWIRE_HOOK = registerBlockItem("tripwires/tripwire_hooks/yellow", () -> new YellowTripWireHook(Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> YELLOW_TRIPWIRE = register("tripwires/yellow", () -> new ModTripWireBlock((ModTripWireHookBlock) YELLOW_TRIPWIRE_HOOK.get(), Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement()));
    public static final RegistryObject<Block> GRINT_BLOCK = register("grint_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(100.0f)));
    public static final RegistryObject<Block> GRINT_SLAB = register("grint_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(4).harvestTool(ToolType.PICKAXE).hardnessAndResistance(120.0f)));
    public static final RegistryObject<Block> GRINT_STAIRS = register("grint_stairs", () -> BlockItemInit.createStairsBlockFrom(GRINT_BLOCK));
    public static final RegistryObject<Block> THUIRTH_RAIL = register("thuirth_rail", () -> new ModPoweredRailBlock(AbstractBlock.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement().hardnessAndResistance(436.5F).sound(SoundType.METAL), true));
    public static final RegistryObject<Block> THUFR = register("special/thufr", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().harvestLevel(119).hardnessAndResistance(2543624320164279125.5F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHARCOAL_BLOCK = register("charcoal_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5.0F, 6.0F)));
    public static final RegistryObject<Block> COAL_SLAB = register("coal_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.BLACK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> CHARCOAL_SLAB = register("charcoal_slab", () -> new SlabBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(0).harvestTool(ToolType.PICKAXE).hardnessAndResistance(6.0F, 6.0F)));
    public static final RegistryObject<Block> CHARCOAL_STAIRS = register("charcoal_stairs", () -> BlockItemInit.createStairsBlockFrom(CHARCOAL_BLOCK));
    public static final RegistryObject<Block> FI_RT_PLOCK = registerBlockItem("lc/blocks/fi_rt_plock", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5000000000.0F, 6.0F)));

    public static Block registerTripwireHook(String name) {
        return registerBlockItem("tripwires/tripwire_hooks/" + name, () -> createTripwireHook(() -> ModTripWireBlock.TRIP_WIRE)).get();
    }

    public static Block registerTripwire(String name, Supplier<Block> blockIn) {
        return ModTripWireBlock.TRIP_WIRE = registerBlockItem("tripwires/" + name, () -> createTripwire(blockIn)).get();
    }

    public static Block createTripwireHook(Supplier<Block> tripwire) {
        return new ModTripWireHookBlock(createTripwireProperties(), tripwire.get());
    }

    public static Block createTripwire(Supplier<Block> hook) {
        return new ModTripWireBlock((ModTripWireHookBlock) hook.get(), createTripwireProperties());
    }

    public static AbstractBlock.Properties createTripwireProperties() {
        return Block.Properties.create(Material.MISCELLANEOUS).doesNotBlockMovement();
    }

    public static RegistryObject<Block> registerBlockItem(String name, Supplier<Block> blockIn) {
        return UnusedBlockInit.defaultRegistryObject(BLOCKS, name, blockIn);
    }

    public static RegistryObject<Block> register(String name, Supplier<Block> blockIn) {
        return UnusedBlockInit.defaultRegistryObject(BLOCKS, name, blockIn);
    }
}
