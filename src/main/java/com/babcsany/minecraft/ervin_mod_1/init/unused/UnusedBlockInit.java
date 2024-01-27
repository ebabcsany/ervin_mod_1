package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ToolTypeInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class UnusedBlockInit {

    public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);
    private static final ArrayList<RegistryObject<Block>> UNUSED_BLOCKS = new ArrayList<>();
    private static RegistryObject<Block> LAST_BLOCK;
    private static final ArrayList<String> UNUSED_BLOCKS_PATHS = new ArrayList<>();

    public static void setUnusedBlocks() {
        BLOCK_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
        getBlock("air", new Block(Block.Properties.create(Material.AIR).doesNotBlockMovement().noDrops()));
        setBlockRequiresTool("tgruhuft", Material.CAKE, 4, 12354, 15365, ToolTypeInit.PHISK, SoundType.CHAIN);
    }

    public static <T extends Block> RegistryObject<Block> getBlock(String name, T block) {
        final RegistryObject<Block> lastBlock = BLOCK_DEFERRED_REGISTER.register(path(name), () -> block);
        LAST_BLOCK = lastBlock;
        UNUSED_BLOCKS.add(lastBlock);
        UNUSED_BLOCKS_PATHS.add(lastBlock.getId().getPath());
        return lastBlock;
    }

    public static <T extends AbstractBlock> void setBlockFrom(String name, T abstractBlock) {
        getBlock(name, new Block(AbstractBlock.Properties.from(abstractBlock)));
    }

    public static void setBlockRequiresTool(String name, Material material, int harvestLevel, int hardnessIn, int resistanceIn, ToolType harvestTool, SoundType sound) {
        getBlock(name, new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(sound)));
    }

    public static String path(String name) {
        String string = "unused";
        return string + "/" + name;
    }

    public static Block getBlock(String name) {
        return get(name).get();
    }

    public static RegistryObject<Block> get(String name) {
        int index = UNUSED_BLOCKS_PATHS.indexOf(path(name));
        return get(index);
    }

    public static RegistryObject<Block> get(int index) {
        return UNUSED_BLOCKS.get(index);
    }

    public static Block getLastBlock() {
        return LAST_BLOCK.get();
    }
}
