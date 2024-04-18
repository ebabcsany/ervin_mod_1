package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ToolTypeInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;

public class UnusedBlocks {
    private static Block LAST_BLOCK;
    private static final ArrayList<String> BLOCK_PATHS = new ArrayList<>();
    private static final ArrayList<Block> BLOCKS = new ArrayList<>();

    private static Block unusedBlockRockRegistryObject(String name) {
        return unusedBlockRegistryObject(name, Material.ROCK);
    }

    public static Block unusedBlockRegistryObject(String name, Material material) {
        return registerDefault(name, new Block(AbstractBlock.Properties.create(material)));
    }

    public static Block setBlockRequiresTool(Material material, int harvestLevel, float hardnessAndResistanceIn, ToolType harvestTool, SoundType sound) {
        return new Block(requiresToolProperties(material, harvestLevel, hardnessAndResistanceIn, harvestTool, sound));
    }

    public static Block setBlockRequiresTool(Material material, int harvestLevel, float hardnessAndResistanceIn, ToolType harvestTool) {
        return new Block(requiresToolProperties(material, harvestLevel, hardnessAndResistanceIn, harvestTool));
    }

    public static Block setBlockRequiresTool(Material material, int harvestLevel, float hardnessIn, float resistanceIn, ToolType harvestTool, SoundType sound) {
        return new Block(requiresToolProperties(material, harvestLevel, hardnessIn, resistanceIn, harvestTool, sound));
    }

    public static Block setBlockRequiresTool(Material material, int harvestLevel, float hardnessIn, float resistanceIn, ToolType harvestTool) {
        return new Block(requiresToolProperties(material, harvestLevel, hardnessIn, resistanceIn, harvestTool));
    }

    public static AbstractBlock.Properties requiresToolProperties(Material material, int harvestLevel, float hardnessAndResistanceIn, ToolType harvestTool, SoundType sound) {
        return AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessAndResistanceIn).harvestTool(harvestTool).sound(sound);
    }

    public static AbstractBlock.Properties requiresToolProperties(Material material, int harvestLevel, float hardnessAndResistanceIn, ToolType harvestTool) {
        return AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessAndResistanceIn).harvestTool(harvestTool);
    }

    public static AbstractBlock.Properties requiresToolProperties(Material material, int harvestLevel, float hardnessIn, float resistanceIn, ToolType harvestTool, SoundType sound) {
        return AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(sound);
    }

    public static AbstractBlock.Properties requiresToolProperties(Material material, int harvestLevel, float hardnessIn, float resistanceIn, ToolType harvestTool) {
        return AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool);
    }

    public static <T extends Block> Block registerBlock(String name, T blockIn) {
        return registerDefault(name, register(name, blockIn));
    }

    public static <T extends Block> Block registerDefault(String name, T block) {
        return add(name, block);
    }

    public static Block register(String key, Block blockIn) {
        return Registry.register(registry(), Ervin_mod_1.getKey(key), blockIn);
    }

    @Deprecated
    public static DefaultedRegistry<Block> registry() {
        return Registry.BLOCK;
    }

    public static Block add(String name, Block block) {
        return addDefault(path(name), block);
    }

    public static Block addDefault(String path, Block block) {
        BLOCKS.add(block);
        BLOCK_PATHS.add(path);
        return LAST_BLOCK = block;
    }

    public static Block get(String name) {
        return getDefault(path(name));
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    public static Block getDefault(String path) {
        int index = BLOCK_PATHS.indexOf(path);
        return get(index);
    }

    public static Block get(int index) {
        return BLOCKS.get(index);
    }

    @Deprecated
    public static Block getLast() {
        return LAST_BLOCK;
    }

    public static void register() {
        Ervin_mod_1.register(UnusedBlocks.class);
    }

    static {
        registerBlock("air", new Block(Block.Properties.create(Material.AIR).doesNotBlockMovement().noDrops()));
        registerBlock("tgruhuft", setBlockRequiresTool(Material.CAKE, 4, 12354, 15365, ToolTypeInit.PHISK, SoundType.CHAIN));
    }
}
