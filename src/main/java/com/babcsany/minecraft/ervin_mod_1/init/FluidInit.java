package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {

	public static final ResourceLocation MILK_STILL_RL = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/milk_still");
	public static final ResourceLocation MILK_FLOWING_RL = new ResourceLocation(Ervin_mod_1.MOD_ID,
			"block/milk_flowing");
	public static final ResourceLocation MILK_OVERLAY_RL = new ResourceLocation(Ervin_mod_1.MOD_ID,
			"block/milk_overlay");
	public static final ResourceLocation JURK_STILL_RL = new ResourceLocation(Ervin_mod_1.MOD_ID, "block/jurk_still");
	public static final ResourceLocation JURK_FLOWING_RL = new ResourceLocation(Ervin_mod_1.MOD_ID,
			"block/jurk_flowing");
	public static final ResourceLocation JURK_OVERLAY_RL = new ResourceLocation(Ervin_mod_1.MOD_ID,
			"block/jurk_overlay");

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ervin_mod_1.MOD_ID);
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
			Ervin_mod_1.MOD_ID);

	public static final RegistryObject<FlowingFluid> FLOWING_JURK = FLUIDS.register("flowing_jurk", () -> new WaterFluid.Flowing());
	public static final RegistryObject<FlowingFluid> JURK = FLUIDS.register("jurk", () -> new WaterFluid.Source());

	public static final RegistryObject<FlowingFluid> MILK_FLUID = FLUIDS.register("milk_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.MILK_PROPERTIES));

	public static final RegistryObject<FlowingFluid> MILK_FLOWING = FLUIDS.register("milk_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.MILK_PROPERTIES));

	public static final RegistryObject<FlowingFluidBlock> MILK_BLOCK = BLOCKS.register("milk",
			() -> new FlowingFluidBlock(() -> FluidInit.MILK_FLUID.get(), Block.Properties.create(Material.WATER)
					.doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));

	public static final ForgeFlowingFluid.Properties MILK_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> MILK_FLUID.get(), () -> MILK_FLOWING.get(),
			FluidAttributes.builder(MILK_STILL_RL, MILK_FLOWING_RL).density(5).luminosity(10).rarity(Rarity.RARE)
					.sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(MILK_OVERLAY_RL))
							.block(() -> FluidInit.MILK_BLOCK.get());

	/*public static final RegistryObject<FlowingFluid> JURK_FLUID = FLUIDS.register("jurk_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.JURK_PROPERTIES));

	public static final RegistryObject<FlowingFluid> JURK_FLOWING = FLUIDS.register("jurk_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.JURK_PROPERTIES));

	public static final RegistryObject<FlowingFluidBlock> JURK_BLOCK = BLOCKS.register("jurk",
			() -> new FlowingFluidBlock(FluidInit.JURK_FLUID, Block.Properties.create(Material.WATER)
					.doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));

	public static final ForgeFlowingFluid.Properties JURK_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> JURK_FLUID.get(), () -> JURK_FLOWING.get(),
			FluidAttributes.builder(JURK_STILL_RL, JURK_FLOWING_RL).density(5).luminosity(10).rarity(Rarity.RARE)
					.sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(JURK_OVERLAY_RL))
			.block(() -> FluidInit.JURK_BLOCK.get());*/

	/*public static final RegistryObject<FlowingFluid> JURK_FLUID1 = FLUIDS.register("jurk_fluid",
			() -> new ForgeFlowingFluid1.Source(FluidInit.JURK_PROPERTIES1));

	public static final RegistryObject<FlowingFluid> JURK_FLOWING1 = FLUIDS.register("jurk_flowing",
			() -> new ForgeFlowingFluid1.Flowing(FluidInit.JURK_PROPERTIES1));

	public static final ForgeFlowingFluid1.Properties JURK_PROPERTIES1 = new ForgeFlowingFluid1.Properties(
			() -> JURK_FLUID1.get(), () -> JURK_FLOWING1.get(),
			FluidAttributes.builder(JURK_STILL_RL, JURK_FLOWING_RL).density(5).luminosity(10).rarity(Rarity.RARE)
					.sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(JURK_OVERLAY_RL))
			.block1(() -> FluidInit.JURK_BLOCK1.get());

	public static final RegistryObject<FlowingFluidBlock1> JURK_BLOCK1 = BLOCKS.register("jurk",
			() -> new FlowingFluidBlock1(FluidInit.JURK_FLUID1, Block.Properties.create(Material.WATER)
					.doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));*/

}
