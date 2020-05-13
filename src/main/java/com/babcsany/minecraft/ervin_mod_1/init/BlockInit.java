package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
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
            Block.Properties.create(Material.EARTH)
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
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100.0f)
    ));
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", () -> new RubyBlock(
            Block.Properties.create(Material.ROCK)
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(100.0f)
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
                    .hardnessAndResistance(10.0f)
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
    public static final RegistryObject<Block> FIRG = BLOCKS.register("firg", () -> new Block(
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
}
