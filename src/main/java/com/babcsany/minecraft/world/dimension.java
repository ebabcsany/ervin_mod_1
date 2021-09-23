package com.babcsany.minecraft.world;

import com.babcsany.minecraft.ervin_mod_1.init.DimensionInit;
import com.babcsany.minecraft.ervin_mod_1.init.DimensionTypeInit;
import com.babcsany.minecraft.ervin_mod_1.init.dimension.settings.ModDimensionSettings;
import com.babcsany.minecraft.ervin_mod_1.registry.ModRegistry;
import com.babcsany.minecraft.ervin_mod_1.world.dimension.biome_provider.ExampleBiomeProvider;
import com.babcsany.minecraft.ervin_mod_1.world.gen.ModNoiseChunkGenerator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Lifecycle;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.EndBiomeProvider;
import net.minecraft.world.biome.provider.NetherBiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class dimension {

    public static final RegistryKey<Dimension> OVERWORLD = Dimension.OVERWORLD;
    public static final RegistryKey<Dimension> THE_NETHER = Dimension.THE_NETHER;
    public static final RegistryKey<Dimension> THE_END = Dimension.THE_END;
    public static final LinkedHashSet<RegistryKey<Dimension>> DIMENSION_KEYS = Sets.newLinkedHashSet(ImmutableList.of(OVERWORLD, THE_NETHER, THE_END));
    public static final LinkedHashSet<RegistryKey<dimension>> MOD_DIMENSION_KEYS = Sets.newLinkedHashSet(ImmutableList.of());
    private Supplier<dimensionType> dimensionTypeSupplier;
    private static Supplier<dimensionType> dimensionTypeSupplier1;
    private ChunkGenerator chunkGenerator;
    private static BiomeProvider biomeProvider;
    private static ChunkGenerator chunkGenerator1;
    static RegistryKey<Dimension> dimensionRegistryKey;
    static SimpleRegistry<Dimension> dimensionSimpleRegistry;
    static SimpleRegistry<dimension> modDimensionSimpleRegistry;
    static long Long;
    static int Int;

    public dimension() {
        this(dimensionTypeSupplier1, chunkGenerator1);
        this.dimensionTypeSupplier = dimensionTypeSupplier1;
        this.chunkGenerator = chunkGenerator1;
    }

    public dimension(Supplier<dimensionType> dimensionTypeSupplier, ChunkGenerator chunkGenerator) {
        this.dimensionTypeSupplier = dimensionTypeSupplier;
        this.chunkGenerator = chunkGenerator;
    }

    public static void setDimensionTypeSupplier1(Supplier<dimensionType> dimensionTypeSupplier1) {
        dimension.dimensionTypeSupplier1 = dimensionTypeSupplier1;
    }

    public Supplier<dimensionType> getDimensionTypeSupplier() {
        return this.dimensionTypeSupplier;
    }

    public dimensionType getDimensionType() {
        return this.dimensionTypeSupplier.get();
    }

    public ChunkGenerator getChunkGenerator() {
        return this.chunkGenerator;
    }

    public static SimpleRegistry<Dimension> func_236062_a_(SimpleRegistry<Dimension> p_236062_0_) {
        SimpleRegistry<Dimension> simpleregistry = new SimpleRegistry<>(Registry.DIMENSION_KEY, Lifecycle.experimental());

        for(RegistryKey<Dimension> registrykey : DIMENSION_KEYS) {
            Dimension dimension = p_236062_0_.getValueForKey(registrykey);
            if (dimension != null) {
                simpleregistry.register(registrykey, dimension);
                if (p_236062_0_.func_239660_c_(registrykey)) {
                    simpleregistry.func_239662_d_(registrykey);
                }
            }
        }

        for(Map.Entry<RegistryKey<Dimension>, Dimension> entry : p_236062_0_.getEntries()) {
            RegistryKey<Dimension> registrykey1 = entry.getKey();
            if (!DIMENSION_KEYS.contains(registrykey1)) {
                simpleregistry.register(registrykey1, entry.getValue());
                if (p_236062_0_.func_239660_c_(registrykey1)) {
                    simpleregistry.func_239662_d_(registrykey1);
                }
            }
        }

        return simpleregistry;
    }

    public static SimpleRegistry<dimension> dimensionSimpleRegistry(SimpleRegistry<dimension> dimensionSimpleRegistry) {
        SimpleRegistry<dimension> simpleRegistry = new SimpleRegistry<>(ModRegistry.MOD_DIMENSION_KEY, Lifecycle.experimental());

        for(RegistryKey<dimension> registrykey : MOD_DIMENSION_KEYS) {
            dimension dimension = dimensionSimpleRegistry.getValueForKey(registrykey);
            if (dimension != null) {
                simpleRegistry.register(registrykey, dimension);
                if (dimensionSimpleRegistry.func_239660_c_(registrykey)) {
                    simpleRegistry.func_239662_d_(registrykey);
                }
            }
        }

        for(Map.Entry<RegistryKey<dimension>, dimension> entry : dimensionSimpleRegistry.getEntries()) {
            RegistryKey<dimension> registrykey1 = entry.getKey();
            if (!MOD_DIMENSION_KEYS.contains(registrykey1)) {
                simpleRegistry.register(registrykey1, entry.getValue());
                if (dimensionSimpleRegistry.func_239660_c_(registrykey1)) {
                    simpleRegistry.func_239662_d_(registrykey1);
                }
            }
        }

        return simpleRegistry;
    }

    public static void setDimension(int Int, RegistryKey<Dimension> dimensionRegistryKey, DimensionType dimensionType, DimensionSettings.Preset preset, boolean Boolean) {
        func_236060_a_(Long, dimensionSimpleRegistry);
    }

    public static boolean func_236060_a_(long Long, SimpleRegistry<Dimension> dimensionSimpleRegistry) {
        List<Map.Entry<RegistryKey<Dimension>, Dimension>> list = Lists.newArrayList(dimensionSimpleRegistry.getEntries());
        List<Map.Entry<RegistryKey<dimension>, dimension>> modList = Lists.newArrayList(modDimensionSimpleRegistry.getEntries());
        if (list.size() != DIMENSION_KEYS.size() || list.size() != MOD_DIMENSION_KEYS.size()) {
            return false;
        } else {
            Map.Entry<RegistryKey<Dimension>, Dimension> entry = list.get(0);
            Map.Entry<RegistryKey<Dimension>, Dimension> entry1 = list.get(1);
            Map.Entry<RegistryKey<Dimension>, Dimension> entry2 = list.get(2);
            Map.Entry<RegistryKey<dimension>, dimension> entry3 = modList.get(3);
            if (entry.getKey() == OVERWORLD && entry1.getKey() == THE_NETHER && entry2.getKey() == THE_END && entry3.getKey() == DimensionInit.EXAMPLE) {
                if (entry.getValue().getDimensionType() != dimensionType.OVERWORLD_TYPE && entry.getValue().getDimensionType() != dimensionType.field_241498_j_) {
                    return false;
                } else if (entry1.getValue().getDimensionType() != DimensionTypeInit.NETHER_TYPE) {
                    return false;
                } else if (entry2.getValue().getDimensionType() != DimensionTypeInit.END_TYPE) {
                    return false;
                } else if (entry3.getValue().getDimensionType() != DimensionTypeInit.EXAMPLE_TYPE) {
                    return false;
                } else if (entry1.getValue().getChunkGenerator() instanceof NoiseChunkGenerator && entry2.getValue().getChunkGenerator() instanceof ModNoiseChunkGenerator && entry3.getValue().getChunkGenerator() instanceof NoiseChunkGenerator) {
                    NoiseChunkGenerator noisechunkgenerator = (NoiseChunkGenerator)entry1.getValue().getChunkGenerator();
                    NoiseChunkGenerator noisechunkgenerator1 = (NoiseChunkGenerator) entry2.getValue().getChunkGenerator();
                    ModNoiseChunkGenerator noisechunkgenerator2 = (ModNoiseChunkGenerator)entry3.getValue().getChunkGenerator();
                    if (!noisechunkgenerator.func_236088_a_(Long, DimensionSettings.Preset.NETHER)) {
                        return false;
                    } else if (!noisechunkgenerator1.func_236088_a_(Long, DimensionSettings.Preset.END)) {
                        return false;
                    } else if (!noisechunkgenerator2.func_236088_a_(Long, ModDimensionSettings.Preset.EXAMPLE)) {
                        return false;
                    } else if (!(noisechunkgenerator.getBiomeProvider() instanceof NetherBiomeProvider)) {
                        return false;
                    } else if (!(noisechunkgenerator2.getBiomeProvider() instanceof ExampleBiomeProvider)) {
                        return false;
                    } else {
                        NetherBiomeProvider netherbiomeprovider = (NetherBiomeProvider)noisechunkgenerator.getBiomeProvider();
                        ExampleBiomeProvider exampleBiomeProvider = (ExampleBiomeProvider) noisechunkgenerator.getBiomeProvider();
                        if (!netherbiomeprovider.func_235280_b_(Long)) {
                            return false;
                        } else if (!exampleBiomeProvider.getBoolean(Long)) {
                            return false;
                        } else if (!(noisechunkgenerator1.getBiomeProvider() instanceof EndBiomeProvider)) {
                            return false;
                        } else if (!(noisechunkgenerator1.getBiomeProvider() instanceof ExampleBiomeProvider)) {
                            return false;
                        } else if (!(noisechunkgenerator2.getBiomeProvider() instanceof NetherBiomeProvider)) {
                            return false;
                        } else {
                            EndBiomeProvider endbiomeprovider = (EndBiomeProvider)noisechunkgenerator1.getBiomeProvider();
                            return endbiomeprovider.func_235318_b_(Long);
                        }
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public static <T> RegistryKey<T> registryKey(RegistryKey<Registry<T>> registryKey, String key) {
        return RegistryKey.func_240903_a_(registryKey, new ResourceLocation(string(key)));
    }

    public static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }
}
