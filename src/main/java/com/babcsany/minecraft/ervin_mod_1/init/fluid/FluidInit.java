package com.babcsany.minecraft.ervin_mod_1.init.fluid;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {

	//static ModFlowingFluid.Properties JURK_PROPERTIES = FluidPropertiesInit.JURK;

	public static final ResourceLocation JURK_STILL = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_still");
	public static final ResourceLocation JURK_FLOWING = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_flow");
	public static final ResourceLocation JURK_OVERLAY = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/fluid/jurk_overlay");
	public static final ResourceLocation MILK_STILL_RL = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/milk_still");
	public static final ResourceLocation MILK_FLOWING_RL = new ResourceLocation(Ervin_mod_1.MOD_ID,
			"block/milk_flowing");
	public static final ResourceLocation MILK_OVERLAY_RL = new ResourceLocation(Ervin_mod_1.MOD_ID,
			"block/milk_overlay");

	public static final DeferredRegister<Block> FLUID_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Ervin_mod_1.MOD_ID);

	//public static final RegistryObject<FlowingFluid> JURK_FLUID = FLUIDS.register("fluids/jurk_", () -> new ModFlowingFluid.Flowing(JURK_PROPERTIES));
/*
	public static final RegistryObject<FlowingFluid> MILK_FLUID = FLUIDS.register("milk_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.MILK_PROPERTIES));

	public static final RegistryObject<FlowingFluid> MILK_FLOWING = FLUIDS.register("milk_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.MILK_PROPERTIES));

	public static final RegistryObject<FlowingFluidBlock> MILK_BLOCK = FLUID_BLOCKS.register("milk",
			() -> new FlowingFluidBlock(FluidInit.MILK_FLUID, Block.Properties.create(Material.WATER)
					.doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));

	public static final ForgeFlowingFluid.Properties MILK_PROPERTIES = new ForgeFlowingFluid.Properties(
			MILK_FLUID, MILK_FLOWING,
			FluidAttributes.builder(MILK_STILL_RL, MILK_FLOWING_RL).density(5).luminosity(10).rarity(Rarity.RARE)
					.sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(MILK_OVERLAY_RL))
							.block(FluidInit.MILK_BLOCK);
*/
}
