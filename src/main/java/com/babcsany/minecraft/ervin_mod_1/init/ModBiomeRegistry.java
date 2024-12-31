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
//    public static final Biome MIGV = register(52, BiomeInit.MIGV, ModBiomeMaker.MIGV_BIOME.get());
//    public static final Biome THE_BHJUIG = register(53, BiomeInit.THE_BHJUIG, ModBiomeMaker.BHJUIG_BIOME.get());
//    public static final Biome MIG = register(54, BiomeInit.MIG, ModBiomeMaker.MIG_BIOME.get());
//    public static final Biome SRIUNK_VALLEY = register(55, BiomeInit.SRIUNK_VALLEY, ModBiomeMaker.SRIUNK_VALLEY.get());
//    public static final Biome END_BIOME0 = register(57, BiomeInit.END_BIOME0, ModBiomeMaker.END_BIOME0.get());
//    public static final Biome MUHK = register(68, BiomeInit.MUHK, ModBiomeMaker.MUHK.get());
//    public static final Biome BLOMUJN = register(69, BiomeInit.BLOMUJN, ModBiomeMaker.BLOMUJN.get());
//    public static final Biome EXAMPLE0_BIOME = register(70, BiomeInit.EXAMPLE0_BIOME, ModBiomeMaker.EXAMPLE0_BIOME.get());
//    public static final Biome EXAMPLE_BIOME = register(71, BiomeInit.EXAMPLE_BIOME, ModBiomeMaker.EXAMPLE_BIOME.get());
//    public static final Biome EXAMPLE_BIOME1 = register(72, BiomeInit.EXAMPLE_BIOME1, ModBiomeMaker.EXAMPLE_BIOME1.get());
//    public static final Biome EXAMPLE_BIOME2 = register(73, BiomeInit.EXAMPLE_BIOME2, ModBiomeMaker.EXAMPLE_BIOME2.get());
//    public static final Biome EXAMPLE_BIOME3 = register(74, BiomeInit.EXAMPLE_BIOME3, ModBiomeMaker.EXAMPLE_BIOME3.get());
//    public static final Biome EXAMPLE_BIOME4 = register(75, BiomeInit.EXAMPLE_BIOME4, ModBiomeMaker.EXAMPLE_BIOME4.get());
//    public static final Biome EXAMPLE_BIOME5 = register(76, BiomeInit.EXAMPLE_BIOME5, ModBiomeMaker.EXAMPLE_BIOME5.get());
//    public static final Biome EXAMPLE_BIOME6 = register(77, BiomeInit.EXAMPLE_BIOME6, ModBiomeMaker.EXAMPLE_BIOME6.get());
//    public static final Biome FIRG = register(78, BiomeInit.FIRG, ModBiomeMaker.FIRG.get());
//    public static final Biome SCRAFTH = register(79, BiomeInit.SCRAFTH, ModBiomeMaker.SCRAFTH.get());
//    public static final Biome TWUST = register(80, BiomeInit.TWUST, ModBiomeMaker.TWUST.get());

    @Deprecated
    public static Biome register(int id, RegistryKey<Biome> key, Biome biome) {
        idToKeyMap.put(id, key);
        return WorldGenRegistries.register(WorldGenRegistries.BIOME, id, key, biome);
    }

    public static void register() {
        Ervin_mod_1.register(ModBiomeRegistry.class);
    }
}
