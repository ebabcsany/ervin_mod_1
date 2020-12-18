package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.ExamplePortalBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> EXAMPLE_PORTAL_BLOCK = BLOCKS.register("example_portal_block", () -> new ExamplePortalBlock(
            AbstractBlock.Properties.create(Material.PORTAL)
                    .doesNotBlockMovement()
                    .tickRandomly()
                    .hardnessAndResistance(-1.0F)
                    .sound(SoundType.GLASS)
                    .setLightLevel(LightValue -> 11)
    ));
}
