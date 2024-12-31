package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.Tririj;
import com.babcsany.minecraft.ervin_mod_1.block.fluid.JurkBlock;
import com.babcsany.minecraft.ervin_mod_1.init.FluidInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockInit;
import com.babcsany.minecraft.ervin_mod_1.init.unused.init.UnusedBlockItemInit;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);
    public static BlockInit BLOCKS;

    public static final RegistryObject<BlockItem> FRISZERN = registerBlockItem("friszern", new CommandBlockBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final RegistryObject<BlockItem> CHAIN_FRISZERN = registerBlockItem("chain_friszern", new CommandBlockBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final RegistryObject<BlockItem> REPEATING_FRISZERN = registerBlockItem("repeating_friszern", new CommandBlockBlock(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final RegistryObject<Block> JURK = DEFERRED_REGISTER.register("fluids/jurk", () -> new JurkBlock(FluidInit.JURK, AbstractBlock.Properties.create(Material.WATER, MaterialColor.MAGENTA).doesNotBlockMovement().hardnessAndResistance(100.0F).setLightLevel((Value) -> 7)));
    public static final RegistryObject<Block> FIRG_PLANKS = DEFERRED_REGISTER.register("firg_planks", () -> new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FIRG_PLANKS_STAIRS = DEFERRED_REGISTER.register("firg_planks_stairs", () -> new StairsBlock(FIRG_PLANKS.get()::getDefaultState, Block.Properties.from(FIRG_PLANKS.get())));
    public static final RegistryObject<Block> FIRG_PLANKS_DOOR = DEFERRED_REGISTER.register("firg_planks_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).variableOpacity().notSolid()));
    public static final RegistryObject<Block> FIRT_BLOCK = DEFERRED_REGISTER.register("firt_block", () -> new Block(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0F)));
    public static final RegistryObject<Block> REUTRIEN = DEFERRED_REGISTER.register("reutrien", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5.0F).sound(SoundType.METAL).notSolid()));
    public static final RegistryObject<Block> TRIRIJ = DEFERRED_REGISTER.register("tririj", () -> new Tririj(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F)));

    public static RegistryObject<BlockItem> registerBlockItem(String key, Block blockIn) {
        return UnusedBlockItemInit.registryObject(UnusedBlockItemInit.BLOCK_ITEM_DEFERRED_REGISTER, key, () -> new BlockItem(blockIn, new Item.Properties()));
    }

    @Deprecated
    public static RegistryObject<Block> register(String key, Block blockIn) {
        return UnusedBlockInit.defaultRegistryObject(DEFERRED_REGISTER, key, () -> blockIn);
    }

    public static void register() {
        Ervin_mod_1.register(BlockInit.class);
    }
}
