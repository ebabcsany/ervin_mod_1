package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.dimension.*;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Ervin_mod_1.MOD_ID);
	
	public static final RegistryObject<ModDimension> EXAMPLE_DIM = MOD_DIMENSIONS.register("example_dim", () -> new ExampleModDimension());
	public static final RegistryObject<ModDimension> EXAMPLE_DIM0 = MOD_DIMENSIONS.register("example_dim0", () -> new ExampleModDimension0());
	public static final RegistryObject<ModDimension> EXAMPLE_DIM1 = MOD_DIMENSIONS.register("example_dim1", () -> new ExampleModDimension1());
	public static final RegistryObject<ModDimension> EXAMPLE_DIM2 = MOD_DIMENSIONS.register("example_dim2", () -> new ExampleModDimension2());
	public static final RegistryObject<ModDimension> EXAMPLE_DIM3 = MOD_DIMENSIONS.register("example_dim3", () -> new ExampleModDimension3());
}
