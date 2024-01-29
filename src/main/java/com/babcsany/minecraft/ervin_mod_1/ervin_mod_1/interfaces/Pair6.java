package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.biome.Biome;

public class Pair6<T, S, C, i, H, U> extends Pair<T, C> {

    private Biome biome;
    private Biome.Attributes biome_attributes;
    private static Pair6<?, ?, ?, ?, ?, ?> pair;
    private final T T;
    private final C C;

    public Pair6(final T T, final C C) {
        super(T, C);
        this.T = T;
        this.C = C;
    }

    public T getT() {
        return T;
    }

    public static Object setT() {
        return pair.getT();
    }

    public C getC() {
        return C;
    }

    public static Object setC() {
        return pair.getT();
    }

    public static <T, C> Pair6<T, ?, C, ?, ?, ?> of(final T T, final C C) {
        return new Pair6<>(T, C);
    }

    public static Biome.Attributes setT(Object o) {
        return pair.biome_attributes;
    }

    public static Biome setC(Object o) {
        return pair.biome;
    }
}
