package com.babcsany.minecraft.ervin_mod_1.init.unused.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ToolTypeInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.function.Supplier;

public class UnusedBlockInit {

    public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final int REGISTRY_OBJECTS_COUNT = 0;
    private static RegistryObject<Block> LAST_BLOCK;
    private static final ArrayList<String> BLOCK_PATHS = new ArrayList<>();
    private static ArrayList<RegistryObject<Block>> REGISTRY_OBJECTS = new ArrayList<>(REGISTRY_OBJECTS_COUNT);

    private static void registryObjects() {
        ArrayList<RegistryObject<Block>> registryObjectsArrayList = new ArrayList<>(REGISTRY_OBJECTS_COUNT);
        registryObjectsArrayList.add(registryObject("air", () -> new Block(Block.Properties.create(Material.AIR).doesNotBlockMovement().noDrops())));
        registryObjectsArrayList.add(registryObject("tgruhuft", () -> setBlockRequiresTool(Material.CAKE, 4, 12354, 15365, ToolTypeInit.PHISK, SoundType.CHAIN)));
        REGISTRY_OBJECTS = registryObjectsArrayList;
    }

    private static RegistryObject<Block> unusedBlockRockRegistryObject(String name) {
        return unusedBlockRegistryObject(name, Material.ROCK);
    }

    private static RegistryObject<Block> unusedBlockRegistryObject(String name, Material material) {
        return registryObject(name, () -> new Block(AbstractBlock.Properties.create(material)));
    }

    private static <T extends Block> RegistryObject<Block> register(String name, Supplier<T> supplier) {
        return registryObject(name, supplier);
    }

    private static <T extends Block> RegistryObject<Block> registryObject(String name, Supplier<T> supplier) {
        return registryObject(BLOCK_DEFERRED_REGISTER, name, supplier);
    }

    private static <T extends Block> RegistryObject<Block> registryObject(DeferredRegister<Block> deferredRegister, String name, Supplier<T> supplier) {
        String path = path(name);
        return defaultRegistryObject(deferredRegister, path, supplier);
    }

    private static <T extends Block> RegistryObject<Block> defaultRegistryObject(String name, Supplier<T> supplier) {
        return defaultRegistryObject(BLOCK_DEFERRED_REGISTER, name, supplier);
    }

    public static <T extends Block> RegistryObject<Block> defaultRegistryObject(DeferredRegister<Block> deferredRegister, String name, Supplier<T> supplier) {
        BLOCK_PATHS.add(name);
        return LAST_BLOCK = deferredRegister.register(name, supplier);
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

    private static AbstractBlock.Properties requiresToolProperties(Material material, int harvestLevel, float hardnessIn, float resistanceIn, ToolType harvestTool, SoundType sound) {
        return AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(sound);
    }

    public static AbstractBlock.Properties requiresToolProperties(Material material, int harvestLevel, float hardnessIn, float resistanceIn, ToolType harvestTool) {
        return AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool);
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    public static RegistryObject<Block> get(String name) {
        int index = BLOCK_PATHS.indexOf(path(name));
        return get(index);
    }

    public static RegistryObject<Block> get(int index) {
        return REGISTRY_OBJECTS.get(index);
    }

    public static RegistryObject<Block> getLast() {
        return LAST_BLOCK;
    }

    @Deprecated
    public static Block getBlock(String name) {
        return get(name).get();
    }

    public static Block getLastBlock() {
        return getLast().get();
    }
}
