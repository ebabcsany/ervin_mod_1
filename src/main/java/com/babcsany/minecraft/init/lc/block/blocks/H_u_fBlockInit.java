package com.babcsany.minecraft.init.lc.block.blocks;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.block.blocks.Tririj;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class H_u_fBlockInit {

    public static final DeferredRegister<Block> H_U_F_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Block> UUUUUUUUUUUUUUUUUUUUUUUU = H_U_F_BLOCKS.register("uuuuuuuuuuuuuuuuuuuuuuuu", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).setRequiresTool().tickRandomly().hardnessAndResistance(5000000.0F)));

}
