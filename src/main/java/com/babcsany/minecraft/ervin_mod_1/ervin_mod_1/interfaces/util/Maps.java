package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.util;

import com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.interfaces.consumer.Map;
import net.minecraft.item.Item;

import java.util.LinkedHashMap;

public interface Maps {

    static <K, V> Map<Item, Integer> newLinkedHashMap() {
        return (Map<Item, Integer>) new LinkedHashMap<K, V>();
    }
}
