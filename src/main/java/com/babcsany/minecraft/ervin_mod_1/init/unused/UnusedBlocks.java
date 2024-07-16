package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.util.Cast;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;

public class UnusedBlocks {
    private static Block LAST_BLOCK;
    private static final ArrayList<String> BLOCK_PATHS = new ArrayList<>();
    private static final ArrayList<Block> BLOCKS = new ArrayList<>();

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

    private static AbstractBlock.Properties requiresToolProperties(Material material, int harvestLevel, float hardnessIn, float resistanceIn, ToolType harvestTool, SoundType sound) {
        return AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(sound);
    }

    public static AbstractBlock.Properties requiresToolProperties(Material material, int harvestLevel, float hardnessIn, float resistanceIn, ToolType harvestTool) {
        return AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool);
    }

    public static <T extends Block> Block registerBlock(String name, T blockIn) {
        return registerDefault(path(name), blockIn);
    }

    public static <T extends Block> Block registerDefault(String name, T blockIn) {
        addDefault(name, blockIn);
        return register(name, blockIn);
    }

    public static Block registerBlockItem(String name, Block blockIn) {
        return new Cast<BlockItem>().cast(UnusedBlockItems.registerDefault(name, blockIn)).getBlock();
    }

    private static Block register(String key, Block blockIn) {
        return registerDefault(Ervin_mod_1.getKey(key), blockIn);
    }

    public static Block registerDefault(ResourceLocation key, Block blockIn) {
        boolean notContains = !BLOCK_PATHS.contains(key.getPath()) && !BLOCKS.contains(blockIn);
        addDefault(key.getPath(), blockIn);
        return (Block) Registry.register(Registry.BLOCK, key.toString(), blockIn);
    }

    private static Block add(String name, Block block) {
        return addDefault(path(name), block);
    }

    private static Block addDefault(String path, Block block) {
        if (!BLOCK_PATHS.contains(path) && !BLOCKS.contains(block)) {
            BLOCKS.add(block);
            addPath(path);
            LAST_BLOCK = block;
        }
        return block;
    }

    public static Block get(String name) {
        return getDefault(path(name));
    }

    private static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    private static void addPath(String path) {
        if (!BLOCK_PATHS.contains(path)) {
            BLOCK_PATHS.add(path);
        }
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
        registerBlock("fs", setBlockRequiresTool(Material.GOURD, 4, 12354, 15365, ToolType.HOE, SoundType.GROUND));
    }
}
