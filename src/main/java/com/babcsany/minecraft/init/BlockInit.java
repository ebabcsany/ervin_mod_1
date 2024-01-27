package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.FirgPlanksStairs;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.FirtBlock;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.Tririj;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static BlockInit BLOCKS;
    public static final DeferredRegister<Block> REGISTER_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> FRISZERN = REGISTER_BLOCKS.register("friszern", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final RegistryObject<Block> CHAIN_FRISZERN = REGISTER_BLOCKS.register("chain_friszern", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final RegistryObject<Block> REPEATING_FRISZERN = REGISTER_BLOCKS.register("repeating_friszern", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLACK_TERRACOTTA).setRequiresTool().hardnessAndResistance(3600000.0F)));
    public static final RegistryObject<Block> JURK = REGISTER_BLOCKS.register("fluids/jurk", () -> new Block(AbstractBlock.Properties.create(Material.WATER, MaterialColor.MAGENTA).doesNotBlockMovement().hardnessAndResistance(100.0F).setLightLevel((Value) -> 15)));
    public static final RegistryObject<Block> FIRG_PLANKS = REGISTER_BLOCKS.register("firg_planks", () -> new Block(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FIRG_PLANKS_STAIRS = REGISTER_BLOCKS.register("firg_planks_stairs", () -> new FirgPlanksStairs(FIRG_PLANKS.get().getDefaultState(), Block.Properties.from(FIRG_PLANKS.get())));
    public static final RegistryObject<Block> FIRG_PLANKS_DOOR = REGISTER_BLOCKS.register("firg_planks_door", () -> new DoorBlock(AbstractBlock.Properties.create(Material.ORGANIC).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid()));
    public static final RegistryObject<Block> FIRT_BLOCK = REGISTER_BLOCKS.register("firt_block", () -> new FirtBlock(Block.Properties.create(Material.ROCK).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).hardnessAndResistance(60.0F)));
    public static final RegistryObject<Block> REUTRIEN = REGISTER_BLOCKS.register("reutrien", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(5.0F).sound(SoundType.METAL).notSolid()));
    public static final RegistryObject<Block> TRIRIJ = REGISTER_BLOCKS.register("tririj", () -> new Tririj(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.RED_TERRACOTTA).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F)));

    private static Block register(String key, Block blockIn) {
        return Registry.register(Registry.BLOCK, string(key), blockIn);
    }

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }
}
