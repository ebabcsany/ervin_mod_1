package com.babcsany.minecraft.ervin_mod_1.init.unused.l;

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

    private static final ArrayList<String> PATHS = new ArrayList<>(2);
    private static final ArrayList<RegistryObject<Block>> REGISTRY_OBJECTS = registryObjects();

    private static ArrayList<RegistryObject<Block>> registryObjects() {
        ArrayList<RegistryObject<Block>> registryObjectsArrayList = new ArrayList<>(2);
        registryObjectsArrayList.add(registryObject("air", () -> new Block(Block.Properties.create(Material.AIR).doesNotBlockMovement().noDrops())));
        registryObjectsArrayList.add(registryObject("tgruhuft", () -> setBlockRequiresTool(Material.CAKE, 4, 12354, 15365, ToolTypeInit.PHISK, SoundType.CHAIN)));
        return registryObjectsArrayList;
    }

    private static RegistryObject<Block> registryObject(String name, Supplier<Block> supplier) {
        String path = path(name);
        PATHS.add(path);
        return BLOCK_DEFERRED_REGISTER.register(path, supplier);
    }

    public static Block setBlockRequiresTool(Material material, int harvestLevel, int hardnessIn, int resistanceIn, ToolType harvestTool, SoundType sound) {
        return new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(sound));
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    @Deprecated
    public static Block getBlock(String name) {
        return get(name).get();
    }

    public static RegistryObject<Block> get(String name) {
        int index = PATHS.indexOf(path(name));
        return get(index);
    }

    public static RegistryObject<Block> get(int index) {
        return REGISTRY_OBJECTS.get(index);
    }
}
