package com.babcsany.minecraft.ervin_mod_1.world.biome.provider;

import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.*;

public class ExampleBiomeProvider extends BiomeProvider {
    public static final Codec<ExampleBiomeProvider> exampleBiomeProviderCodec = RecordCodecBuilder.create((builder) -> {
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
    private static final List<Biome> biomeList = ImmutableList.of(
            BiomeInit.EXAMPLE_BIOME.get()
            /*BiomeInit.EXAMPLE_BIOME0.get(),
            BiomeInit.EXAMPLE_BIOME1.get(),
            BiomeInit.EXAMPLE_BIOME2.get(),
            BiomeInit.EXAMPLE_BIOME3.get(),
            BiomeInit.EXAMPLE_BIOME4.get(),
            BiomeInit.EXAMPLE_BIOME5.get(),
            BiomeInit.EXAMPLE_BIOME6.get(),
            BiomeInit.FIRG_BIOME.get(),
            BiomeInit.MIG_BIOME.get(),
            BiomeInit.SCRAFTH_BIOME.get(),
            BiomeInit.SRIUNK_VALLEY_BIOME.get()*/
    );
    private final long seed;
    private final boolean legacyBiomes;
    private final boolean largeBiomes;
    private final Registry<Biome> lookupRegistry;

    public ExampleBiomeProvider(long p_i231643_1_, boolean p_i231643_3_, boolean p_i231643_4_, Registry<Biome> lookupRegistry) {
        super(biomeList);
        this.seed = p_i231643_1_;
        this.legacyBiomes = p_i231643_3_;
        this.largeBiomes = p_i231643_4_;
        this.lookupRegistry = lookupRegistry;
        this.genBiomes = LayerUtil.func_237215_a_(p_i231643_1_, p_i231643_3_, p_i231643_4_ ? 6 : 4, 4);
    }

    @Override
    protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
        return exampleBiomeProviderCodec;
    }

    @OnlyIn(Dist.CLIENT)
    public BiomeProvider func_230320_a_(long p_230320_1_) {
        return new ExampleBiomeProvider(p_230320_1_, this.legacyBiomes, this.largeBiomes, this.lookupRegistry);
    }

    public Biome getNoiseBiome(int x, int y, int z) {
        return this.genBiomes.func_242936_a(this.lookupRegistry, x, z);
    }

    @Override
    public BiomeProvider getBiomeProvider(long seed) {
        return null;
    }
}
