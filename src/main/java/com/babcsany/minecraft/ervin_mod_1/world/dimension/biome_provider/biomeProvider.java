package com.babcsany.minecraft.ervin_mod_1.world.dimension.biome_provider;

import com.mojang.serialization.Codec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.List;

public abstract class biomeProvider extends BiomeProvider {
    public Codec<? extends BiomeProvider> BiomeProvider = this.func_230319_a_();
    protected biomeProvider(List<Biome> p_i231634_1_) {
        super(p_i231634_1_);
    }
}
