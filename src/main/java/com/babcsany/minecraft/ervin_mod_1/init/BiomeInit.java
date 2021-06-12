package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.init.block.BlockInit;
import com.babcsany.minecraft.ervin_mod_1.world.biome.*;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.BiomeAmbience;
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
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
			Ervin_mod_1.MOD_ID);

	public static final RegistryObject<Biome> MIGV_BIOME = BIOMES
			.register("migv_biome",
					()-> new MigBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(10456252).setWaterFogColor(26762304).setFogColor(12538462).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("migv_surface",
															new MigBiomeSurfaceBuilder(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(Blocks.WATER.getDefaultState(),
															Blocks.GRASS.getDefaultState(),
															Blocks.CARVED_PUMPKIN.getDefaultState())))
									.category(Category.PLAINS).downfall(12.4f).depth(6.5f).parent(null)
									.func_235098_a_(ImmutableList.of(new Biome.Attributes(10.25F, -6.5F, 13.5F, 9.2F, 3.0F)))
					));
	public static final RegistryObject<Biome> THE_BHJUIG_BIOME = BIOMES
			.register("the_bhjuig_biome",
					()-> new TheBhjuigBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(28634578).setWaterFogColor(837428654).setFogColor(792356895).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("the_bhjuig_surface",
															new MigBiomeSurfaceBuilder(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(BlockItemInit.KALT_BLOCK.get().getDefaultState(),
															BlockItemInit.FIRT_BLOCK.get().getDefaultState(),
															BlockItemInit.EXAMPLE_BLOCK.get().getDefaultState())))
									.category(Category.PLAINS).downfall(4.0f).depth(2.5f).parent(null)
									.func_235098_a_(ImmutableList.of(new Biome.Attributes(10.25F, -6.5F, 13.5F, 9.2F, 3.0F)))
					));
	public static final RegistryObject<Biome> MIG_BIOME = BIOMES
			.register("mig_biome",
					() -> new MigBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(10456252).setWaterFogColor(26762304).setFogColor(12538462).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("mig_surface",
															new MigBiomeSurfaceBuilder(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(Blocks.WATER.getDefaultState(),
															Blocks.GRASS.getDefaultState(),
															Blocks.CARVED_PUMPKIN.getDefaultState())))
									.category(Category.PLAINS).downfall(12.4f).depth(6.5f).parent(null)
									.func_235098_a_(ImmutableList.of(new Biome.Attributes(10.25F, -6.5F, 13.5F, 9.2F, 3.0F)))
					));
	public static final RegistryObject<Biome> SRIUNK_VALLEY_BIOME = BIOMES
			.register("sriunk_valley_biome",
					() -> new SriunkValleyBiome(
							new Biome.Builder().precipitation(RainType.NONE).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(10456252).setWaterFogColor(26762304).setFogColor(12538462).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("sriunk_valley_surface",
															new SriunkValleySurfaceBuilder(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(BlockItemInit.END_PORTAL.get().getDefaultState(),
															isBurnableBlockItemInit.NETHER_PORTAL.get().getDefaultState(),
															BlockItemInit.DURT.get().getDefaultState())))
									.category(Category.PLAINS).downfall(12.4f).depth(6.5f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE0_BIOME = BIOMES
			.register("example0_biome",
					() -> new Example0Biome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(121.2f).temperature(5.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(46724639).setWaterFogColor(46769357).setFogColor(4253846).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("example0_surface",
															new ExampleBiomeSurfaceBuilder(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(isBurnableBlockItemInit.SRURG.get().getDefaultState(),
															isBurnableBlockItemInit.EPKIH.get().getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(5.5f).depth(12.12f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME6 = BIOMES
			.register("example_biome6",
					() -> new ExampleBiome6(
							new Biome.Builder().precipitation(RainType.NONE).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(10456252).setWaterFogColor(26762304).setFogColor(12538462).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("example_surface6",
															new ExampleBiomeSurfaceBuilder6(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(BlockItemInit.KALT_BLOCK.get().getDefaultState(),
															isBurnableBlockItemInit.NIRTKB.get().getDefaultState(),
															isBurnableBlockItemInit.NIRTK.get().getDefaultState())))
									.category(Category.PLAINS).downfall(12.4f).depth(6.5f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME = BIOMES
			.register("example_biome",
					() -> new ExampleBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(16724639).setWaterFogColor(16762304).setFogColor(1253846).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("example_surface",
															new ExampleBiomeSurfaceBuilder(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME0 = BIOMES
			.register("example_biome0",
					() -> new ExampleBiome0(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(16724639).setWaterFogColor(16762304).setFogColor(1253846).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("example_surface0",
															new ExampleBiomeSurfaceBuilder0(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME1 = BIOMES
			.register("example_biome1",
					() -> new ExampleBiome1(
							new Biome.Builder().precipitation(RainType.RAIN).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(4563891).setWaterFogColor(7543209).setFogColor(62529834).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("example_surface1",
															new ExampleBiomeSurfaceBuilder1(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.GRASS_BLOCK.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(5.5f).depth(12.12f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME2 = BIOMES
			.register("example_biome2",
					() -> new ExampleBiome2(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(16724639).setWaterFogColor(16762304).setFogColor(1253846).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("example_surface2",
															new ExampleBiomeSurfaceBuilder2(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME3 = BIOMES
			.register("example_biome3",
					() -> new ExampleBiome3(
							new Biome.Builder().precipitation(RainType.RAIN).scale(1000.0f).temperature(500.0f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(64895).setWaterFogColor(71263).setFogColor(824526).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("example_surface3",
															new ExampleBiomeSurfaceBuilder3(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(Blocks.BEDROCK.getDefaultState(),
															Blocks.OBSIDIAN.getDefaultState(),
															Blocks.CAVE_AIR.getDefaultState())))
									.category(Category.PLAINS).downfall(500.0f).depth(100.0f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME4 = BIOMES
			.register("example_biome4",
					() -> new ExampleBiome4(
							new Biome.Builder().precipitation(RainType.NONE).scale(10000.0f).temperature(50.0f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(34895).setWaterFogColor(131263).setFogColor(4562745).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("example_surface4",
															new ExampleBiomeSurfaceBuilder4(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.COARSE_DIRT.getDefaultState())))
									.category(Category.DESERT).downfall(50.0f).depth(10.0f).parent(null)
					));
	public static final RegistryObject<Biome> EXAMPLE_BIOME5 = BIOMES
			.register("example_biome5",
					() -> new ExampleBiome5(
							new Biome.Builder().precipitation(RainType.RAIN).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(16724639).setWaterFogColor(16762304).setFogColor(1253846).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("example_surface5",
															new ExampleBiomeSurfaceBuilder5(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState(),
															Blocks.DIRT.getDefaultState())))
									.category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> FIRG_BIOME = BIOMES
			.register("firg_biome",
					() -> new FirgBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(16777215).setWaterFogColor(16777210).setFogColor(1677241).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("firg_surface",
															new FirgBiomeSurfaceBuilder(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(BlockInit.FIRG.get().getDefaultState(),
															BlockInit.FIRG.get().getDefaultState(),
															BlockInit.FIRG.get().getDefaultState())))
									.category(Category.THEEND).downfall(0.5f).depth(0.12f).parent(null)
					));
	public static final RegistryObject<Biome> SCRAFTH_BIOME = BIOMES
			.register("scrafth_biome",
					() -> new ScrafthBiome(
							new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
									.func_235097_a_((new BiomeAmbience.Builder()).setWaterColor(16777215).setWaterFogColor(16777210).setFogColor(1677241).build())
									.surfaceBuilder(
											new ConfiguredSurfaceBuilder<>(
													register("scrafth_surface",
															new ScrafthBiomeSurfaceBuilder(
																	SurfaceBuilderConfig.field_237203_a_)),
													new SurfaceBuilderConfig(BlockInit.SCRAFTH.get().getDefaultState(),
															BlockInit.SCRAFTH.get().getDefaultState(),
															BlockInit.SCRAFTH.get().getDefaultState())))
									.category(Category.THEEND).downfall(0.5f).depth(0.12f).parent(null)
					));

	public static void registerBiomes() {
		registerBiomeWarm(THE_BHJUIG_BIOME.get(), Type.VOID, Type.RARE);
		registerBiomeCool(MIG_BIOME.get(), Type.OCEAN, Type.MIG, Type.OVERWORLD);
		registerBiomeCool1(MIGV_BIOME.get(), Type.OCEAN, Type.MIG, Type.HOT, Type.OVERWORLD);
		registerBiomeCool1(SRIUNK_VALLEY_BIOME.get(), Type.DEAD, Type.OVERWORLD);
		registerBiomeCool2(EXAMPLE0_BIOME.get(), Type.DEAD, Type.PLAINS);
		registerBiomeCool2(EXAMPLE_BIOME.get(), Type.DEAD, Type.PLAINS);
		registerBiomeDesert(EXAMPLE_BIOME1.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiomeIcy(EXAMPLE_BIOME0.get(), Type.PLAINS, Type.BEACH);
		registerBiomeWarm(EXAMPLE_BIOME2.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiomeWarm(EXAMPLE_BIOME3.get(), Type.PLAINS, Type.OVERWORLD);
		registerBiomeDesert(EXAMPLE_BIOME4.get(), Type.BEACH, Type.RARE, Type.OVERWORLD);
		registerBiomeCool(EXAMPLE_BIOME5.get(), Type.DEAD, Type.RARE, Type.OVERWORLD);
		registerBiomeCool(EXAMPLE_BIOME6.get(), Type.RARE, Type.VOID, Type.MODIFIED);
		registerBiomeCool2(FIRG_BIOME.get(), Type.getType("FIRG"), Type.HILLS, Type.END);
		registerBiomeCool1(SCRAFTH_BIOME.get(), Type.getType("SCRAFTH"), Type.HILLS, Type.END);
	}

	private static void registerBiomeCool(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 10000));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	private static void registerBiomeCool1(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100000));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	private static void registerBiomeCool2(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 1000000));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	private static void registerBiomeDesert(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 1000000));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	private static void registerBiomeIcy(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 1000000));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	private static void registerBiomeWarm(Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 1000000));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	@SuppressWarnings("deprecation")
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}
}
