package com.babcsany.minecraft.ervin_mod_1.world.biome.manager;

import net.minecraft.world.biome.Biome;

import java.util.*;

public class BiomeManager {
    private static final ArrayList<Biome> BIOMES = new ArrayList<>();
    private static final ArrayList<BiomeType> BIOMES_TYPES = new ArrayList<>();
    private static final ArrayList<Integer> BIOMES_WEIGHTS = new ArrayList<>();

    public static void addBiome(BiomeType type, BiomeEntry entry) {
        addSimpleBiome(entry.biome);
        addSimpleType(type);
        addSimpleWeight(entry.weight);
    }

    public static void removeBiome(BiomeType type, BiomeEntry entry) {
        int biomeIndex = BIOMES.indexOf(entry.biome);
        if (type == BIOMES_TYPES.get(biomeIndex)) {
            removeSimpleBiome(biomeIndex);
            removeSimpleType(biomeIndex);
            removeSimpleWeight(biomeIndex);
        }
    }

    private static void removeSimpleBiome(int index) {
        BIOMES.remove(index);
    }

    private static void removeSimpleType(int index) {
        BIOMES_TYPES.remove(index);
    }

    private static void removeSimpleWeight(int index) {
        BIOMES_WEIGHTS.remove(index);
    }

    private static void addSimpleBiome(Biome biome) {
        if (!BIOMES.contains(biome)) {
            BIOMES.add(biome);
        }
    }

    private static void addSimpleType(BiomeType type) {
        BIOMES_TYPES.add(type);
    }

    private static void addSimpleWeight(int weight) {
        BIOMES_WEIGHTS.add(weight);
    }

    public static Collection<Biome> getBiomes() {
        return BIOMES;
    }

    public static Collection<BiomeType> getTypes() {
        return BIOMES_TYPES;
    }

    public static Collection<Integer> getWeights() {
        return BIOMES_WEIGHTS;
    }

    public static void addSpawnBiome(Biome biome) {
        biome.getRegistryName();
    }

    public static class BiomeEntry {
        private final Biome biome;
        private final int weight;

        public BiomeEntry(Biome biome, int weight) {
            this.biome = biome;
            this.weight = weight;
        }

        public Biome getBiome() {
            return biome;
        }

        public int getWeight() {
            return weight;
        }
    }

    public enum BiomeType {
        COOL,
        DESERT,
        ICY,
        WARM
    }
}
