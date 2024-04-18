package com.babcsany.minecraft.ervin_mod_1.world.biome.manager;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import com.babcsany.minecraft.ervin_mod_1.world.gen.Biomes;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.spawner.WanderingTraderSpawner;
import net.minecraft.world.storage.SaveFormat;
import net.minecraftforge.event.entity.living.LootingLevelEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Function;

public class BiomeManager {
    private static final ArrayList<Biome> BIOMES = new ArrayList<>();
    private static final ArrayList<BiomeType> BIOMES_TYPES = new ArrayList<>();
    private static final ArrayList<Integer> BIOMES_WEIGHTS = new ArrayList<>();

    public static void addBiome(BiomeType type, BiomeEntry entry) {
        addSimpleBiome(entry.biome);
        addSimpleType(type);
        addSimpleWeight(entry.itemWeight);
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

    private static TrackedList<BiomeEntry>[] biomes = setupBiomes();
    public static List<Biome> oceanBiomes = new ArrayList<>();

    public BiomeManager() {
    }

    private static TrackedList<BiomeEntry>[] setupBiomes() {
        TrackedList<BiomeEntry>[] currentBiomes = new TrackedList[BiomeManager.BiomeType.values().length];
        List<BiomeEntry> list = new ArrayList();
        list.add(new BiomeEntry(Biomes.FOREST, 10));
        list.add(new BiomeEntry(Biomes.DARK_FOREST, 10));
        list.add(new BiomeEntry(Biomes.MOUNTAINS, 10));
        list.add(new BiomeEntry(Biomes.PLAINS, 10));
        list.add(new BiomeEntry(Biomes.BIRCH_FOREST, 10));
        list.add(new BiomeEntry(Biomes.SWAMP, 10));
        currentBiomes[BiomeManager.BiomeType.WARM.ordinal()] = new TrackedList<>(list);
        list.clear();
        list.add(new BiomeEntry(Biomes.FOREST, 10));
        list.add(new BiomeEntry(Biomes.MOUNTAINS, 10));
        list.add(new BiomeEntry(Biomes.TAIGA, 10));
        list.add(new BiomeEntry(Biomes.PLAINS, 10));
        currentBiomes[BiomeManager.BiomeType.COOL.ordinal()] = new TrackedList<>(list);
        list.clear();
        list.add(new BiomeEntry(Biomes.SNOWY_TUNDRA, 30));
        list.add(new BiomeEntry(Biomes.SNOWY_TAIGA, 10));
        currentBiomes[BiomeManager.BiomeType.ICY.ordinal()] = new TrackedList<>(list);
        list.clear();
        currentBiomes[BiomeManager.BiomeType.DESERT.ordinal()] = new TrackedList<>(list);
        return currentBiomes;
    }

    public static void addSpawnBiome(Biome biome) {
        BiomeProvider.CODEC.orElse(new BiomeProvider(new ArrayList<>(Collections.singleton(biome))) {
            @Override
            protected Codec<? extends BiomeProvider> getBiomeProviderCodec() {
                return CODEC;
            }

            @Override
            public BiomeProvider getBiomeProvider(long seed) {
                return this;
            }

            @Override
            public Biome getNoiseBiome(int x, int y, int z) {
                return biome;
            }
        });
        net.minecraft.world.biome.BiomeManager.getHashedSeed(20L);
    }

    @Nullable
    public static ImmutableList<BiomeEntry> getBiomes(BiomeType type) {
        int idx = type.ordinal();
        List<BiomeEntry> list = idx >= biomes.length ? null : biomes[idx];
        return list != null ? ImmutableList.copyOf(list) : null;
    }

    public static boolean isTypeListModded(BiomeType type) {
        int idx = type.ordinal();
        TrackedList<BiomeEntry> list = idx > biomes.length ? null : biomes[idx];
        return list != null ? list.isModded() : false;
    }

    static {
        oceanBiomes.add(Biomes.OCEAN);
        oceanBiomes.add(Biomes.DEEP_OCEAN);
        oceanBiomes.add(Biomes.FROZEN_OCEAN);
    }

    private static class TrackedList<E> extends ArrayList<E> {
        private static final long serialVersionUID = 1L;
        private boolean isModded = false;

        public TrackedList(Collection<? extends E> c) {
            super(c);
        }

        public E set(int index, E element) {
            this.isModded = true;
            return super.set(index, element);
        }

        public boolean add(E e) {
            this.isModded = true;
            return super.add(e);
        }

        public void add(int index, E element) {
            this.isModded = true;
            super.add(index, element);
        }

        public E remove(int index) {
            this.isModded = true;
            return super.remove(index);
        }

        public boolean remove(Object o) {
            this.isModded = true;
            return super.remove(o);
        }

        public void clear() {
            this.isModded = true;
            super.clear();
        }

        public boolean addAll(Collection<? extends E> c) {
            this.isModded = true;
            return super.addAll(c);
        }

        public boolean addAll(int index, Collection<? extends E> c) {
            this.isModded = true;
            return super.addAll(index, c);
        }

        public boolean removeAll(Collection<?> c) {
            this.isModded = true;
            return super.removeAll(c);
        }

        public boolean retainAll(Collection<?> c) {
            this.isModded = true;
            return super.retainAll(c);
        }

        public boolean isModded() {
            return this.isModded;
        }
    }

    public static class BiomeEntry extends WeightedRandom.Item {
        public final Biome biome;

        public BiomeEntry(Biome biome, int weight) {
            super(weight);
            this.biome = biome;
        }
    }

    public static enum BiomeType {
        DESERT,
        WARM,
        COOL,
        ICY;

        private BiomeType() {
        }

        public static BiomeType create(String name) {
            return null;
        }
    }
}
