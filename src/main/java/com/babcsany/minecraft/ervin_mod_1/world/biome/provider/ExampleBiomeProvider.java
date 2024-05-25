package com.babcsany.minecraft.ervin_mod_1.world.biome.provider;

import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ExampleBiomeProvider extends BiomeProvider {
    public static final Codec<ExampleBiomeProvider> CODEC = RecordCodecBuilder.create((builder) -> {
        return builder.group(Codec.LONG.fieldOf("seed").stable().forGetter((exampleBiomeProvider) -> {
            return exampleBiomeProvider.seed;
        }), Codec.BOOL.optionalFieldOf("legacy_biome_init_layer", Boolean.valueOf(false), Lifecycle.stable()).forGetter((exampleBiomeProvider) -> {
            return exampleBiomeProvider.legacyBiomes;
        }), Codec.BOOL.fieldOf("large_biomes").orElse(false).stable().forGetter((exampleBiomeProvider) -> {
            return exampleBiomeProvider.largeBiomes;
        }), RegistryLookupCodec.getLookUpCodec(Registry.BIOME_KEY).forGetter((exampleBiomeProvider) -> {
            return exampleBiomeProvider.lookupRegistry;
        })).apply(builder, builder.stable(ExampleBiomeProvider::new));
    });
    private final Layer genBiomes;
    private static final List<RegistryKey<Biome>> biomes = ImmutableList.of(
            BiomeInit.MIGV,
            BiomeInit.THE_BHJUIG,
            BiomeInit.MIG,
            BiomeInit.SRIUNK_VALLEY,
            BiomeInit.EXAMPLE0_BIOME,
            BiomeInit.END_BIOME0,
            BiomeInit.EXAMPLE_BIOME,
            BiomeInit.EXAMPLE_BIOME1,
            BiomeInit.EXAMPLE_BIOME2,
            BiomeInit.EXAMPLE_BIOME3,
            BiomeInit.EXAMPLE_BIOME4,
            BiomeInit.EXAMPLE_BIOME5,
            BiomeInit.EXAMPLE_BIOME6,
            BiomeInit.FIRG,
            BiomeInit.SCRAFTH,
            BiomeInit.TWUST,
            BiomeInit.MUHK,
            BiomeInit.BLOMUJN
    );
    private final long seed;
    private final boolean legacyBiomes;
    private final boolean largeBiomes;
    private final Registry<Biome> lookupRegistry;

    public ExampleBiomeProvider(long seed, boolean legacyBiomes, boolean largeBiomes, Registry<Biome> lookupRegistry) {
        super(biomes.stream().map((key) -> {
            return () -> {
                return lookupRegistry.getOrThrow(key);
            };
        }));
        this.seed = seed;
        this.legacyBiomes = legacyBiomes;
        this.largeBiomes = largeBiomes;
        this.lookupRegistry = lookupRegistry;
        this.genBiomes = LayerUtil.func_237215_a_(seed, legacyBiomes, largeBiomes ? 9 : 3, 6);
    }

    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return CODEC;
    }

    @OnlyIn(Dist.CLIENT)
    public BiomeProvider getBiomeProvider(long seed) {
        return new ExampleBiomeProvider(seed, this.legacyBiomes, this.largeBiomes, this.lookupRegistry);
    }

    public Biome getNoiseBiome(int x, int y, int z) {
        return this.genBiomes.func_242936_a(this.lookupRegistry, x, z);
    }
}
