package com.babcsany.minecraft.ervin_mod_1.world.biome.provider;

import com.babcsany.minecraft.ervin_mod_1.init.BiomeInit;
import com.babcsany.minecraft.ervin_mod_1.world.dimension.ExampleBiomeProviderSettings;
import com.babcsany.minecraft.ervin_mod_1.world.dimension.VoronoiGenerator;
import com.mojang.serialization.Codec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.*;

public class ExampleBiomeProvider extends BiomeProvider {

	private static final List<Biome> biomeList = new List<Biome>(/*BiomeInit.EXAMPLE_BIOME.get(), Biomes.BEACH*/) {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Biome> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Biome biome) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Biome> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Biome> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Biome get(int index) {
            return null;
        }

        @Override
        public Biome set(int index, Biome element) {
            return null;
        }

        @Override
        public void add(int index, Biome element) {

        }

        @Override
        public Biome remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Biome> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Biome> listIterator(int index) {
            return null;
        }

        @Override
        public List<Biome> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
	private Random rand;
	private final double biomeSize = 320.0D;
	private VoronoiGenerator biomeNoise;

	public ExampleBiomeProvider(ExampleBiomeProviderSettings settings) {
		super(biomeList);
		rand = new Random();
		this.biomeNoise = new VoronoiGenerator();
		this.biomeNoise.setSeed((int) settings.hashCode());
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return getBiome(new LinkedList<Biome>(biomeList),
				biomeNoise.getValue((double) x / biomeSize, (double) y / biomeSize, (double) z / biomeSize));
	}

	public Biome getBiome(List<Biome> biomeList, double noiseVal) {
		for (int i = biomeList.size(); i >= 0; i--) {
			if (noiseVal > (2.0f / biomeList.size()) * i - 1)
				return biomeList.get(i);
		}
		return biomeList.get(biomeList.size() - 1);
	}

	@Override
	protected Codec<? extends BiomeProvider> func_230319_a_() {
		return null;
	}

	@Override
	public BiomeProvider func_230320_a_(long p_230320_1_) {
		return null;
	}
}
