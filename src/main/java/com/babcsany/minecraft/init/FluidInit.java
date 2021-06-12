package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.fluid.JurkFluid;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class FluidInit {

    //public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Ervin_mod_1.MOD_ID);

    public static final ResourceLocation JURK_STILL = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_still");
    public static final ResourceLocation JURK_FLOWING = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_flow");
    public static final ResourceLocation JURK_OVERLAY = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_overlay");
    //public static final FlowingFluid FLOWING_JURK = register("ervin_mod_1:flowing_jurk", new JurkFluid.Flowing());
    //public static final FlowingFluid JURK = register("ervin_mod_1:jurk", new JurkFluid.Source());

    public static final FlowingFluid MILK_FLUID = register("milk_fluid", new ForgeFlowingFluid.Source(com.babcsany.minecraft.ervin_mod_1.init.FluidInit.MILK_PROPERTIES));

    public static final FlowingFluid MILK_FLOWING = register("milk_flowing", new ForgeFlowingFluid.Flowing(com.babcsany.minecraft.ervin_mod_1.init.FluidInit.MILK_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MILK_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> MILK_FLUID, () -> MILK_FLOWING,
            FluidAttributes.builder(JURK_STILL, JURK_FLOWING).density(5).luminosity(10).rarity(Rarity.RARE)
                    .sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(JURK_OVERLAY))
            .block((Supplier<? extends FlowingFluidBlock>) BlockInit.FIRG_PLANKS);

    public static final Block MILK_BLOCK = register("milk", new FlowingFluidBlock(MILK_FLUID, Block.Properties.create(Material.WATER).doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));

    private static Block register(String key, Block blockIn) {
        return Registry.register(Registry.BLOCK, key, blockIn);
    }

    private static <T extends Fluid> T register(String key, T p_215710_1_) {
        return Registry.register(Registry.FLUID, key, p_215710_1_);
    }

    static {
        for(Fluid fluid : Registry.FLUID) {
            for(FluidState fluidstate : fluid.getStateContainer().getValidStates()) {
                Fluid.STATE_REGISTRY.add(fluidstate);
            }
        }

    }
}
