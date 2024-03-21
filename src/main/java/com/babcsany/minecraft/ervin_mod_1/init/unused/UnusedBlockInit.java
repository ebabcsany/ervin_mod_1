package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ToolTypeInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.function.Supplier;

public class UnusedBlockInit {

    public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final int REGISTRY_OBJECTS_COUNT = 2;
    private static RegistryObject<Block> LAST_BLOCK;
    private static final ArrayList<String> BLOCK_PATHS = new ArrayList<>(REGISTRY_OBJECTS_COUNT);
    private static final ArrayList<RegistryObject<Block>> REGISTRY_OBJECTS = registryObjects();

    private static ArrayList<RegistryObject<Block>> registryObjects() {
        ArrayList<RegistryObject<Block>> registryObjectsArrayList = new ArrayList<>(REGISTRY_OBJECTS_COUNT);
        registryObjectsArrayList.add(registryObject("air", () -> new Block(Block.Properties.create(Material.AIR).doesNotBlockMovement().noDrops())));
        registryObjectsArrayList.add(registryObject("tgruhuft", () -> setBlockRequiresTool(Material.CAKE, 4, 12354, 15365, ToolTypeInit.PHISK, SoundType.CHAIN)));
        return registryObjectsArrayList;
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

    public static <T extends Block> RegistryObject<Block> registryObject(DeferredRegister<Block> deferredRegister, String name, Supplier<T> supplier) {
        String path = path(name);
        BLOCK_PATHS.add(path);
        return LAST_BLOCK = deferredRegister.register(path, supplier);
    }

    public static Block setBlockRequiresTool(Material material, int harvestLevel, int hardnessIn, int resistanceIn, ToolType harvestTool, SoundType sound) {
        return new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(sound));
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
