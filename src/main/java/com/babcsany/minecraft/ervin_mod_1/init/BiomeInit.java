package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.biome.*;
import com.babcsany.minecraft.ervin_mod_1.world.biome.dictionary.BiomeDictionary;
import com.babcsany.minecraft.ervin_mod_1.world.biome.dictionary.BiomeDictionary.Type;
import com.babcsany.minecraft.ervin_mod_1.world.biome.manager.BiomeManager;
import com.babcsany.minecraft.ervin_mod_1.world.gen.BiomeKeys;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.EndBiomeProvider;
import net.minecraft.world.gen.SimplexNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
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
    public static final RegistryKey<Biome> MIGV = makeKey("migv");
    public static final RegistryKey<Biome> THE_BHJUIG = makeKey("the_bhjuig");
    public static final RegistryKey<Biome> MIG = makeKey("mig");
    public static final RegistryKey<Biome> SRIUNK_VALLEY = makeKey("sriunk_valley");
    public static final RegistryKey<Biome> EXAMPLE0_BIOME = makeKey("example0_biome");
    public static final RegistryKey<Biome> END_BIOME0 = makeKey("end_biome0");
    public static final RegistryKey<Biome> EXAMPLE_BIOME = makeKey("example_biome");
    public static final RegistryKey<Biome> EXAMPLE_BIOME1 = makeKey("example_biome1");
    public static final RegistryKey<Biome> EXAMPLE_BIOME2 = makeKey("example_biome2");
    public static final RegistryKey<Biome> EXAMPLE_BIOME3 = makeKey("example_biome3");
    public static final RegistryKey<Biome> EXAMPLE_BIOME4 = makeKey("example_biome4");
    public static final RegistryKey<Biome> EXAMPLE_BIOME5 = makeKey("example_biome5");
    public static final RegistryKey<Biome> EXAMPLE_BIOME6 = makeKey("example_biome6");
    public static final RegistryKey<Biome> FIRG = makeKey("firg");
    public static final RegistryKey<Biome> SCRAFTH = makeKey("scrafth");
    public static final RegistryKey<Biome> TWUST = makeKey("twust");
    public static final RegistryKey<Biome> MUHK = makeKey("muhk");
    public static final RegistryKey<Biome> BLOMUJN = makeKey("blomujn");

    public static RegistryKey<Biome> makeKey(String key) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID, key));
    }

    public static void registerBiomes() {
        List<BiomeManager.BiomeEntry> list = new ArrayList<>();

        EndBiomeProvider.getRandomNoise(new SimplexNoiseGenerator(new Random(7546325664442138745L)), 45348, 5468217);
        EndBiomeProvider.getRandomNoise(new SimplexNoiseGenerator(new Random(8336725817605470826L)), 546374, 1284526);
        EndBiomeProvider.getRandomNoise(new SimplexNoiseGenerator(new Random(6886536535475794231L)), 6785, 6789148);


//        list.add(new BiomeManager.BiomeEntry(BiomeInit.MIG, 10));
//        list.add(new BiomeManager.BiomeEntry(BiomeInit.MIGV, 10));
//        list.add(new BiomeManager.BiomeEntry(BiomeInit.TWUST, 10));
//        registerBiomeWarm_weight_10(THE_BHJUIG, Type.RARE, Type.VOID);
//        registerBiomeWarm_weight_10(MIG, Type.OCEAN, Type.RARE, Type.OVERWORLD);
//        registerBiomeWarm_weight_10(MIGV, Type.OCEAN, Type.RARE, Type.HOT, Type.OVERWORLD);
//        registerBiomeWarm_weight_10(TWUST, Type.DRY, Type.LUSH, Type.DENSE, Type.HILLS, Type.VOID, Type.RARE, Type.MODIFIED, Type.WATER, Type.MAGICAL, Type.BEACH, Type.CONIFEROUS, Type.DEAD, Type.MESA, Type.MOUNTAIN, Type.MUSHROOM, Type.PLAINS, Type.PLATEAU, Type.SANDY, Type.SAVANNA, Type.SNOWY, Type.SPARSE, Type.SPOOKY, Type.SWAMP, Type.WASTELAND, Type.WET, Type.OVERWORLD);
//        registerBiomeCool_weight_10(SRIUNK_VALLEY, Type.DEAD, Type.OVERWORLD);
//        registerBiomeCool_weight_10(EXAMPLE0_BIOME, Type.COLD, Type.PLAINS, Type.CONIFEROUS);
//        registerBiomeWarm_weight_10(EXAMPLE_BIOME, Type.LUSH, Type.PLAINS);
//        registerBiomeDesert_weight_10(EXAMPLE_BIOME1, Type.PLAINS, Type.OVERWORLD);
//        registerBiomeEnd_weight_10(END_BIOME0, Type.END);
//        registerBiomeWarm_weight_10(EXAMPLE_BIOME2, Type.PLAINS, Type.HOT, Type.OVERWORLD, Type.DRY);
//        registerBiomeWarm_weight_10(EXAMPLE_BIOME3, Type.DENSE, Type.HOT, Type.OVERWORLD, Type.DENSE);
//        registerBiomeDesert_weight_10(EXAMPLE_BIOME4, Type.BEACH, Type.RARE, Type.OVERWORLD);
//        registerBiomeCool_weight_10(EXAMPLE_BIOME5, Type.DEAD, Type.RARE, Type.OVERWORLD);
//        registerBiomeCool_weight_10(EXAMPLE_BIOME6, Type.RARE, Type.VOID, Type.MODIFIED);
//        registerBiomeCool_weight_10(FIRG, Type.FIRG, Type.HILLS, Type.END);
//        registerBiomeCool_weight_10(SCRAFTH, Type.SCRAFTH, Type.HILLS, Type.END);
    }

    private static void registerBiomeEnd_weight_10(RegistryKey<Biome> biome, Type... types) {
        registerBiomeEnd_weight_10(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeCool_weight_10(RegistryKey<Biome> biome, Type... types) {
        registerBiomeCool_weight_10(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeCool_weight_100(RegistryKey<Biome> biome, Type... types) {
        registerBiomeCool_weight_100(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeCool_weight_1000(RegistryKey<Biome> biome, Type... types) {
        registerBiomeCool_weight_1000(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeCool_weight_10000(RegistryKey<Biome> biome, Type... types) {
        registerBiomeCool_weight_10000(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeDesert_weight_10(RegistryKey<Biome> biome, Type... types) {
        registerBiomeDesert_weight_10(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeDesert_weight_100(RegistryKey<Biome> biome, Type... types) {
        registerBiomeDesert_weight_100(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeDesert_weight_1000(RegistryKey<Biome> biome, Type... types) {
        registerBiomeDesert_weight_1000(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeDesert_weight_10000(RegistryKey<Biome> biome, Type... types) {
        registerBiomeDesert_weight_10000(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeIcy_weight_10(RegistryKey<Biome> biome, Type... types) {
        registerBiomeIcy_weight_10(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeIcy_weight_100(RegistryKey<Biome> biome, Type... types) {
        registerBiomeIcy_weight_100(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeIcy_weight_1000(RegistryKey<Biome> biome, Type... types) {
        registerBiomeIcy_weight_1000(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeIcy_weight_10000(RegistryKey<Biome> biome, Type... types) {
        registerBiomeIcy_weight_10000(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeWarm_weight_10(RegistryKey<Biome> biome, Type... types) {
        registerBiomeWarm_weight_10(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeWarm_weight_100(RegistryKey<Biome> biome, Type... types) {
        registerBiomeWarm_weight_100(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeWarm_weight_1000(RegistryKey<Biome> biome, Type... types) {
        registerBiomeWarm_weight_1000(BiomeKeys.get(biome), types);
    }

    private static void registerBiomeWarm_weight_10000(RegistryKey<Biome> biome, Type... types) {
        registerBiomeWarm_weight_10000(BiomeKeys.get(biome), types);
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

    public static void register() {
        Ervin_mod_1.register(BiomeInit.class);
    }
}
