package com.babcsany.minecraft.ervin_mod_1.init.block;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.init.MaterialInit;
import com.babcsany.minecraft.fluid.block.ModFlowingFluidBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//import static com.babcsany.minecraft.ervin_mod_1.init.fluid.FluidInit.JURK_FLUID;

public class FluidBlockInit {

    public static final DeferredRegister<Block> FLUID_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<ModFlowingFluidBlock> JURK_BLOCK = FLUID_BLOCKS.register("fluids/jurk_", () -> new ModFlowingFluidBlock(JURK_FLUID, AbstractBlock.Properties.create(MaterialInit.JURK, MaterialColor.MAGENTA).doesNotBlockMovement().hardnessAndResistance(100.0F).setLightLevel(Value -> 4).noDrops()));

}
