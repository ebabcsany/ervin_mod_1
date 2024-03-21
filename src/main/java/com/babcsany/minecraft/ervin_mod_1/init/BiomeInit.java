package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.biome.*;
import com.babcsany.minecraft.ervin_mod_1.world.biome.biomes.ExampleBiome4;
import com.babcsany.minecraft.ervin_mod_1.world.biome.biomes.ExampleBiome5;
import com.babcsany.minecraft.ervin_mod_1.world.biome.biomes.ExampleBiome6;
import com.babcsany.minecraft.ervin_mod_1.world.biome.dictionary.BiomeDictionary;
import com.babcsany.minecraft.ervin_mod_1.world.biome.dictionary.BiomeDictionary.Type;
import com.babcsany.minecraft.ervin_mod_1.world.biome.manager.BiomeManager;
import com.babcsany.minecraft.ervin_mod_1.world.biome.surface_builders.ExampleBiomeSurfaceBuilder4;
import com.babcsany.minecraft.ervin_mod_1.world.biome.surface_builders.ExampleBiomeSurfaceBuilder5;
import com.babcsany.minecraft.ervin_mod_1.world.biome.surface_builders.ExampleBiomeSurfaceBuilder6;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.provider.EndBiomeProvider;
import net.minecraft.world.gen.SimplexNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BiomeInit {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Biome> RIFT_BIOME = BIOMES.register("rift_biome", () -> ModBiomeMaker.RIFT_BIOME);
    public static final RegistryObject<Biome> MIGV = BIOMES.register("migv_biome", () -> ModBiomeMaker.MIGV_BIOME);
    public static final RegistryObject<Biome> THE_BHJUIG = BIOMES.register("the_bhjuig_biome", () -> ModBiomeMaker.BHJUIG_BIOME);
    public static final RegistryObject<Biome> MIG = BIOMES.register("mig_biome", () -> ModBiomeMaker.MIG_BIOME);
    public static final RegistryObject<Biome> SRIUNK_VALLEY = BIOMES.register("sriunk_valley_biome", () -> ModBiomeMaker.SRIUNK_VALLEY_BIOME);
    public static final RegistryObject<Biome> EXAMPLE0 = BIOMES.register("example0_biome", () -> ModBiomeMaker.EXAMPLE0_BIOME);
    public static final RegistryObject<Biome> END_BIOME0 = BIOMES.register("end0_biome", () -> ModBiomeMaker.END0_BIOME);
    public static final RegistryObject<Biome> EXAMPLE_BIOME = BIOMES.register("example_biome", () -> ModBiomeMaker.EXAMPLE_BIOME);
    public static final RegistryObject<Biome> EXAMPLE_BIOME1 = BIOMES.register("example_biome1", () -> ModBiomeMaker.EXAMPLE_BIOME1);
    public static final RegistryObject<Biome> EXAMPLE_BIOME2 = BIOMES.register("example_biome2", () -> ModBiomeMaker.EXAMPLE_BIOME2);
    public static final RegistryObject<Biome> EXAMPLE_BIOME3 = BIOMES.register("example_biome3", () -> ModBiomeMaker.EXAMPLE_BIOME3);
    public static final RegistryObject<Biome> EXAMPLE_BIOME4 = BIOMES.register("example_biome4", () -> ModBiomeMaker.EXAMPLE_BIOME4);
    public static final RegistryObject<Biome> EXAMPLE_BIOME5 = BIOMES.register("example_biome5", () -> ModBiomeMaker.EXAMPLE_BIOME5);
    public static final RegistryObject<Biome> EXAMPLE_BIOME6 = BIOMES.register("example_biome6", () -> ModBiomeMaker.EXAMPLE_BIOME6);
    public static final RegistryObject<Biome> FIRG = BIOMES.register("firg", () -> ModBiomeMaker.FIRG_BIOME);
    public static final RegistryObject<Biome> SCRAFTH = BIOMES.register("scrafth", () -> ModBiomeMaker.SCRAFTH_BIOME);
    public static final RegistryObject<Biome> TWUST = BIOMES.register("twust", () -> ModBiomeMaker.TWUST_BIOME);
    private static final RegistryObject<Biome> MUHK = BIOMES.register("muhk", () -> ModBiomeMaker.MUHK_BIOME);
    private static final RegistryObject<Biome> BLOMUJN = BIOMES.register("blomujn", () -> ModBiomeMaker.MUHK_BIOME);

    private static RegistryKey<Biome> makeKey(String key) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(key));
    }

    public static void registerBiomes() {
        List<BiomeManager.BiomeEntry> list = new ArrayList<>();

        EndBiomeProvider.getRandomNoise(new SimplexNoiseGenerator(new Random(7546325664442138745L)), 45348, 5468217);
        EndBiomeProvider.getRandomNoise(new SimplexNoiseGenerator(new Random(8336725817605470826L)), 546374, 1284526);
        EndBiomeProvider.getRandomNoise(new SimplexNoiseGenerator(new Random(6886536535475794231L)), 6785, 6789148);

        list.add(new BiomeManager.BiomeEntry(BiomeInit.MIG.get(), 10));
        list.add(new BiomeManager.BiomeEntry(BiomeInit.MIGV.get(), 10));
        list.add(new BiomeManager.BiomeEntry(BiomeInit.TWUST.get(), 10));
        registerBiomeWarm_weight_10(THE_BHJUIG.get(), Type.RARE, Type.VOID);
        registerBiomeWarm_weight_10(MIG.get(), Type.OCEAN, Type.RARE, Type.OVERWORLD);
        registerBiomeWarm_weight_10(MIGV.get(), Type.OCEAN, Type.RARE, Type.HOT, Type.OVERWORLD);
        registerBiomeWarm_weight_10(TWUST.get(), Type.DRY, Type.LUSH, Type.DENSE, Type.HILLS, Type.VOID, Type.RARE, Type.MODIFIED, Type.WATER, Type.MAGICAL, Type.BEACH, Type.CONIFEROUS, Type.DEAD, Type.MESA, Type.MOUNTAIN, Type.MUSHROOM, Type.PLAINS, Type.PLATEAU, Type.SANDY, Type.SAVANNA, Type.SNOWY, Type.SPARSE, Type.SPOOKY, Type.SWAMP, Type.WASTELAND, Type.WET, Type.OVERWORLD);
        registerBiomeCool_weight_10(SRIUNK_VALLEY.get(), Type.DEAD, Type.OVERWORLD);
        registerBiomeCool_weight_10(EXAMPLE0.get(), Type.COLD, Type.PLAINS, Type.CONIFEROUS);
        registerBiomeWarm_weight_10(EXAMPLE_BIOME.get(), Type.LUSH, Type.PLAINS);
        registerBiomeDesert_weight_10(EXAMPLE_BIOME1.get(), Type.PLAINS, Type.OVERWORLD);
        registerBiomeEnd_weight_10(END_BIOME0.get(), Type.END);
        registerBiomeWarm_weight_10(EXAMPLE_BIOME2.get(), Type.PLAINS, Type.HOT, Type.OVERWORLD, Type.DRY);
        registerBiomeWarm_weight_10(EXAMPLE_BIOME3.get(), Type.DENSE, Type.HOT, Type.OVERWORLD, Type.DENSE);
        registerBiomeDesert_weight_10(EXAMPLE_BIOME4.get(), Type.BEACH, Type.RARE, Type.OVERWORLD);
        registerBiomeCool_weight_10(EXAMPLE_BIOME5.get(), Type.DEAD, Type.RARE, Type.OVERWORLD);
        registerBiomeCool_weight_10(EXAMPLE_BIOME6.get(), Type.RARE, Type.VOID, Type.MODIFIED);
        registerBiomeCool_weight_10(FIRG.get(), Type.FIRG, Type.HILLS, Type.END);
        registerBiomeCool_weight_10(SCRAFTH.get(), Type.SCRAFTH, Type.HILLS, Type.END);
    }

    private static void registerBiomeEnd_weight_10(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.removeBiome(Arrays.stream(BiomeManager.BiomeType.values()).iterator().next(), new BiomeManager.BiomeEntry(biome, 10));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeCool_weight_10(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 10));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeCool_weight_100(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeCool_weight_1000(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 1000));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeCool_weight_10000(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 10000));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeDesert_weight_10(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 10));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeDesert_weight_100(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 100));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeDesert_weight_1000(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 1000));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeDesert_weight_10000(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 10000));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeIcy_weight_10(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 10));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeIcy_weight_100(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 100));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeIcy_weight_1000(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 1000));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeIcy_weight_10000(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 10000));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeWarm_weight_10(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 10));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeWarm_weight_100(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 100));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeWarm_weight_1000(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 1000));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerBiomeWarm_weight_10000(Biome biome, Type... types) {
        // the line below will make it spawn in the overworld
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 10000));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return Registry.register(Registry.SURFACE_BUILDER, key, builderIn);
    }
}
