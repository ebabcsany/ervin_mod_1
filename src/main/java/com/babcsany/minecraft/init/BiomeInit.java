package com.babcsany.minecraft.init;

import com.babcsany.minecraft.world.biome.MuhkBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.util.Collections;

public class BiomeInit extends net.minecraft.world.biome.BiomeInit {

    public static Biomes BIOMES;

    public static final Biome MUHK_BIOME = register(201,"muhk_biome", new MuhkBiome());
}
