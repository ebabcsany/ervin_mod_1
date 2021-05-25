package com.babcsany.minecraft.ervin_mod_1.world.biome.provider;

import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.*;

public class ExampleBiomeProvider extends BiomeProvider {
    public static final Codec<ExampleBiomeProvider> exampleBiomeProviderCodec = RecordCodecBuilder.create((p_235302_0_) -> {
        return p_235302_0_.group(Codec.LONG.fieldOf("seed").stable().forGetter((p_235304_0_) -> {
            return p_235304_0_.field_235298_h_;
        }), Codec.BOOL.optionalFieldOf("legacy_biome_init_layer", Boolean.valueOf(false), Lifecycle.stable()).forGetter((p_235303_0_) -> {
            return p_235303_0_.field_235299_i_;
        }), Codec.BOOL.fieldOf("large_biomes").withDefault(false).stable().forGetter((p_235301_0_) -> {
            return p_235301_0_.field_235300_j_;
        })).apply(p_235302_0_, p_235302_0_.stable(ExampleBiomeProvider::new));
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
    private final long field_235298_h_;
    private final boolean field_235299_i_;
    private final boolean field_235300_j_;

    public ExampleBiomeProvider(long p_i231643_1_, boolean p_i231643_3_, boolean p_i231643_4_) {
        super(biomeList);
        this.field_235298_h_ = p_i231643_1_;
        this.field_235299_i_ = p_i231643_3_;
        this.field_235300_j_ = p_i231643_4_;
        this.genBiomes = LayerUtil.func_237215_a_(p_i231643_1_, p_i231643_3_, p_i231643_4_ ? 6 : 4, 4);
    }

    protected Codec<? extends BiomeProvider> func_230319_a_() {
        return exampleBiomeProviderCodec;
    }

    @OnlyIn(Dist.CLIENT)
    public BiomeProvider func_230320_a_(long p_230320_1_) {
        return new ExampleBiomeProvider(p_230320_1_, this.field_235299_i_, this.field_235300_j_);
    }

    public Biome getNoiseBiome(int x, int y, int z) {
        return this.genBiomes.func_215738_a(x, z);
    }
}
