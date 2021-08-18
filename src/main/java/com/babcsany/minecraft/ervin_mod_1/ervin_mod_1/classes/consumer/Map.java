package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.classes.consumer;

import java.util.Collection;
import java.util.Set;

public class Map<K, V> implements java.util.Map<K, V> {
    @Override
    public native int size();

    @Override
    public native boolean isEmpty();

    @Override
    public native boolean containsKey(Object key);

    @Override
    public native boolean containsValue(Object value);

    @Override
    public native V get(Object key);

    @Override
    public V put(K key, V value) {
        return value;
    }

    @Override
    public native V remove(Object key);

    @Override
    public native void putAll(java.util.Map m);

    @Override
    public native void clear();

    @Override
    public native Set<K> keySet();

    @Override
    public native Collection<V> values();

    @Override
    public native Set<java.util.Map.Entry<K, V>> entrySet();
}
