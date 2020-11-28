package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.biomes.*;
import com.babcsany.minecraft.ervin_mod_1.world.gen.surfacebuilders.SurfaceBuilderConfig1;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
			Ervin_mod_1.MOD_ID);

	/*public static final RegistryObject<Biome> MIG_BIOME = BIOMES
			.register("mig_biome",
					() -> new MigBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.waterColor(16724639).waterFogColor(16762304)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("mig_surface",
															new MigBiomeSurfaceBuilder(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)));

	public static void registerBiomes() {
		registerBiome(MIG_BIOME.get(), Type.PLAINS, Type.OVERWORLD);
	}

	private static void registerBiome(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	@SuppressWarnings("deprecation")
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}*/
	public static final RegistryObject<Biome> EXAMPLE_BIOME = BIOMES
			.register("example_biome",
					() -> new ExampleBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.waterColor(16724639).waterFogColor(16762304)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("example_surface",
															new ExampleBiomeSurfaceBuilder(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME0 = BIOMES
			.register("example_biome0",
					() -> new ExampleBiome0(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.waterColor(16724639).waterFogColor(16762304)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("example_surface0",
															new ExampleBiomeSurfaceBuilder0(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME1 = BIOMES
			.register("example_biome1",
					() -> new ExampleBiome1(
							new Biome.Builder().precipitation(RainType.RAIN).scale(1.2f).temperature(0.5f)
									.waterColor(4563891).waterFogColor(7543209)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("example_surface1",
															new ExampleBiomeSurfaceBuilder1(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.GRASS_BLOCK.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(5.5f).depth(12.12f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME2 = BIOMES
			.register("example_biome2",
					() -> new ExampleBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.waterColor(16724639).waterFogColor(16762304)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("example_surface2",
															new ExampleBiomeSurfaceBuilder(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME3 = BIOMES
			.register("example_biome3",
					() -> new ExampleBiome3(
							new Biome.Builder().precipitation(RainType.RAIN).scale(1000.0f).temperature(500.0f)
									.waterColor(64895).waterFogColor(71263)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("example_surface3",
															new ExampleBiomeSurfaceBuilder3(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.BEDROCK.getDefaultState(),
															Blocks.OBSIDIAN.getDefaultState(),
															Blocks.CAVE_AIR.getDefaultState())))
									.category(Category.PLAINS).downfall(500.0f).depth(100.0f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME4 = BIOMES
			.register("example_biome4",
					() -> new ExampleBiome4(
							new Biome.Builder().precipitation(RainType.NONE).scale(10000.0f).temperature(50.0f)
									.waterColor(34895).waterFogColor(131263)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("example_surface4",
															new ExampleBiomeSurfaceBuilder4(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.COARSE_DIRT.getDefaultState())))
									.category(Category.DESERT).downfall(50.0f).depth(10.0f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME5 = BIOMES
			.register("example_biome5",
					() -> new ExampleBiome5(
							new Biome.Builder().precipitation(RainType.RAIN).scale(1.2f).temperature(0.5f)
									.waterColor(16724639).waterFogColor(16762304)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("example_surface5",
															new ExampleBiomeSurfaceBuilder5(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> FIRG_BIOME = BIOMES
			.register("firg_biome",
					() -> new FirgBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.waterColor(16777215).waterFogColor(16777210)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("firg_surface",
															new FirgBiomeSurfaceBuilder(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(BlockInit.FIRG.get().getDefaultState(),
															BlockInit.FIRG.get().getDefaultState(),
															BlockInit.FIRG.get().getDefaultState())))
									.category(Category.THEEND).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> SCRAFTH_BIOME = BIOMES
			.register("scrafth_biome",
					() -> new ScrafthBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.waterColor(16777215).waterFogColor(16777210)
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
													register("scrafth_surface",
															new ScrafthBiomeSurfaceBuilder(
																	SurfaceBuilderConfig::deserialize)),
													new SurfaceBuilderConfig(BlockInit.SCRAFTH.get().getDefaultState(),
															BlockInit.SCRAFTH.get().getDefaultState(),
															BlockInit.SCRAFTH.get().getDefaultState())))
									.category(Category.THEEND).downfall(0.5f).depth(0.12f).parent(null)
					));

	public static void registerBiomes() {
		registerBiome(EXAMPLE_BIOME.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiome(EXAMPLE_BIOME1.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiome(EXAMPLE_BIOME0.get(), Type.PLAINS, Type.BEACH);
		registerBiome(EXAMPLE_BIOME2.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiome(EXAMPLE_BIOME3.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiome(EXAMPLE_BIOME4.get(), Type.BEACH, Type.RARE);
		registerBiome(EXAMPLE_BIOME5.get(), Type.DEAD, Type.RARE);
		registerBiome(FIRG_BIOME.get(), Type.END, Type.END);
		registerBiome(SCRAFTH_BIOME.get(), Type.END, Type.END);
	}

	private static void registerBiome(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100000));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	@SuppressWarnings("deprecation")
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}
}
