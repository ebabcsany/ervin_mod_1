package com.babcsany.minecraft.ervin_mod_1.init.unused;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.item.ToolTypeInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UnusedBlockInit {

    private static final DeferredRegister<Block> UNUSED_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final DeferredRegister<Block> BLOCK_DEFERRED_REGISTER = UNUSED_BLOCKS;

    private RegistryObject<Block> BLOCKS;

    private void setUnusedBlocks() {
        setBlockFrom("air", Blocks.AIR);
        setBlockRequiresTool("tgruhuft", Material.AIR, 4, 12354, 15365, ToolTypeInit.PHISK, SoundType.CHAIN);
    }

    public final <T extends Block> RegistryObject<Block> getBlock(String name, T block) {
        return this.BLOCKS = BLOCK_DEFERRED_REGISTER.register(string(name), () -> block);
    }

    public final <T extends AbstractBlock> void setBlockFrom(String name, T abstractBlock) {
        getBlock(name, new Block(AbstractBlock.Properties.from(abstractBlock)));
    }

    public final void setBlockRequiresTool(String name, Material material, int harvestLevel, int hardnessIn, int resistanceIn, ToolType harvestTool, SoundType sound) {
        getBlock(name, new Block(AbstractBlock.Properties.create(material).setRequiresTool().harvestLevel(harvestLevel).hardnessAndResistance(hardnessIn, resistanceIn).harvestTool(harvestTool).sound(sound)));
    }

    public final RegistryObject<Block> getBLOCKS() {
        setUnusedBlocks();
        return this.BLOCKS;
    }

    public static String string(String name) {
        String modId = Ervin_mod_1.MOD_ID;
        String string = "unused";
        return modId + ':' + string + "/" + name;
    }
}
