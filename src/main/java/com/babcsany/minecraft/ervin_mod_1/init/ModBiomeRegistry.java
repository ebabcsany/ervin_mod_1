package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiomeMaker;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;

public class ModBiomeRegistry {
    private static final Int2ObjectMap<RegistryKey<Biome>> idToKeyMap = new Int2ObjectArrayMap<>();
    public static final Biome MIGV = register(52, BiomeInit.MIGV, ModBiomeMaker.MIGV_BIOME);
    public static final Biome THE_BHJUIG = register(53, BiomeInit.THE_BHJUIG, ModBiomeMaker.BHJUIG_BIOME);
    public static final Biome MIG = register(54, BiomeInit.MIG, ModBiomeMaker.MIG_BIOME);
    public static final Biome SRIUNK_VALLEY = register(55, BiomeInit.SRIUNK_VALLEY, ModBiomeMaker.SRIUNK_VALLEY);
    public static final Biome EXAMPLE0_BIOME = register(56, BiomeInit.EXAMPLE0_BIOME, ModBiomeMaker.EXAMPLE0_BIOME);
    public static final Biome END_BIOME0 = register(57, BiomeInit.END_BIOME0, ModBiomeMaker.END_BIOME0);
    public static final Biome EXAMPLE_BIOME = register(58, BiomeInit.EXAMPLE_BIOME, ModBiomeMaker.EXAMPLE_BIOME);
    public static final Biome EXAMPLE_BIOME1 = register(59, BiomeInit.EXAMPLE_BIOME1, ModBiomeMaker.EXAMPLE_BIOME1);
    public static final Biome EXAMPLE_BIOME2 = register(60, BiomeInit.EXAMPLE_BIOME2, ModBiomeMaker.EXAMPLE_BIOME2);
    public static final Biome EXAMPLE_BIOME3 = register(61, BiomeInit.EXAMPLE_BIOME3, ModBiomeMaker.EXAMPLE_BIOME3);
    public static final Biome EXAMPLE_BIOME4 = register(62, BiomeInit.EXAMPLE_BIOME4, ModBiomeMaker.EXAMPLE_BIOME4);
    public static final Biome EXAMPLE_BIOME5 = register(63, BiomeInit.EXAMPLE_BIOME5, ModBiomeMaker.EXAMPLE_BIOME5);
    public static final Biome EXAMPLE_BIOME6 = register(64, BiomeInit.EXAMPLE_BIOME6, ModBiomeMaker.EXAMPLE_BIOME6);
    public static final Biome FIRG = register(65, BiomeInit.FIRG, ModBiomeMaker.FIRG);
    public static final Biome SCRAFTH = register(66, BiomeInit.SCRAFTH, ModBiomeMaker.SCRAFTH);
    public static final Biome TWUST = register(67, BiomeInit.TWUST, ModBiomeMaker.TWUST);
    public static final Biome MUHK = register(68, BiomeInit.MUHK, ModBiomeMaker.MUHK);
    public static final Biome BLOMUJN = register(69, BiomeInit.BLOMUJN, ModBiomeMaker.BLOMUJN);

    @Deprecated
    public static Biome register(int id, RegistryKey<Biome> key, Biome biome) {
        idToKeyMap.put(id, key);
        return WorldGenRegistries.register(WorldGenRegistries.BIOME, id, key, biome);
    }

    public static void register() {
        Ervin_mod_1.register(ModBiomeRegistry.class);
    }
}
