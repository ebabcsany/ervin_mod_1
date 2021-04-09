package com.babcsany.minecraft.ervin_mod_1.init.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.ExamplePortalBlock;
import com.babcsany.minecraft.ervin_mod_1.block.TargCropsBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.*;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.TeratBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.burnable.VirkBlock;
import com.babcsany.minecraft.ervin_mod_1.fluid.JurkFlowingFluid;
import com.babcsany.minecraft.ervin_mod_1.init.BlockItemInit;
import com.babcsany.minecraft.ervin_mod_1.init.isBurnableBlockItemInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> EXAMPLE_PORTAL_BLOCK = BLOCKS.register("example_portal_block", () -> new ExamplePortalBlock(
            AbstractBlock.Properties.from(Blocks.NETHER_PORTAL)/*create(Material.PORTAL)*/
                    /*.doesNotBlockMovement()
                    .tickRandomly()
                    .hardnessAndResistance(-1.0F)
                    .sound(SoundType.GLASS)
                    .setLightLevel(LightValue -> 11)*/
    ));
    public static final RegistryObject<Block> TARG_STAGE = BLOCKS.register("crops/targ_stage", () -> new TargCropsBlock(
            Block.Properties.create(Material.PLANTS)
                    .zeroHardnessAndResistance()
                    .doesNotBlockMovement()
                    .tickRandomly()
                    .sound(SoundType.CROP)
    ));
    public static final RegistryObject<Block> FIRG = BLOCKS.register("firg", () -> new Firg(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> FIRG_SLAB = BLOCKS.register("firg_slab", () -> new FirgSlab(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0F, 15.0F)
    ));
    public static final RegistryObject<Block> FIRG_STAIRS = BLOCKS.register("firg_stairs", () -> new FirgStairs(
            () -> FIRG.get().getDefaultState(), Block.Properties.from(FIRG.get())
    ));
    public static final RegistryObject<Block> ENDER_SRACKHT = BLOCKS.register("ender_srackht", () -> new EnderSrackht(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(20.0f)
    ));
    public static final RegistryObject<Block> ENDER_STAKRACH = BLOCKS.register("ender_stakrach", () -> new EnderStakrach(
            Block.Properties.create(Material.WOOD)
                    .setRequiresTool()
                    .harvestLevel(2)
                    .harvestTool(ToolType.AXE)
                    .hardnessAndResistance(40.0f)
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
    public static final RegistryObject<Block> SCRAFTH = BLOCKS.register("scrafth", () -> new Scrafth(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(10.0f)
    ));
    public static final RegistryObject<Block> VIRK_BLOCK = BLOCKS.register("virk_block", () -> new VirkBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(5)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(650.0f)
    ));
    /*public static final RegistryObject<Block> JURK = BLOCKS.register("fluid/jurk", () -> new JurkFlowingFluid(
            isBurnableBlockItemInit.NARIN_BLOCK.get(), AbstractBlock.Properties.create(Material.ROCK)
            .doesNotBlockMovement()
            .tickRandomly()
            .hardnessAndResistance(100.0F)
            .setLightLevel(Value -> 4)
            .noDrops()
    ));*/
    public static final RegistryObject<Block> TERAT_BLOCK = BLOCKS.register("terat_block", () -> new TeratBlock(
            Block.Properties.create(Material.ROCK)
                    .setRequiresTool()
                    .harvestLevel(32)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000.0f)
    ));
    public static final RegistryObject<Block> GRITH_BLOCK = BLOCKS.register("grith_block", () -> new GrithBlock(
            Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .setRequiresTool()
                    .harvestLevel(80)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000000000000.0F)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> GRITH_SLAB = BLOCKS.register("grith_slab", () -> new GrithSlab(
            Block.Properties.create(Material.ROCK, MaterialColor.SNOW)
                    .setRequiresTool()
                    .harvestLevel(78)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(1000000000000000.0F,500000000000000.0F)
                    .setLightLevel(Value -> 15)
    ));
    public static final RegistryObject<Block> GRITH_STAIRS = BLOCKS.register("grith_stairs", () -> new GrithStairs(
            () -> GRITH_BLOCK.get().getDefaultState(), Block.Properties.from(GRITH_BLOCK.get())
    ));
}
