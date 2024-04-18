package com.babcsany.minecraft.ervin_mod_1.world.gen;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModBiomeGeneration {
    public static void generateBiomes() {

    }

    private static void addBiome(Biome biome, BiomeManager biomeManager) {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));


    }
}
