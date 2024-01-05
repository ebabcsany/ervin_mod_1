package net.minecraft.world.biome;

import net.minecraft.util.registry.Registry;

public class BiomeInit {

    public static Biome register(int id, String key, Biome biome) {
        return Registry.register(Registry.BIOME, id, string(key), biome);
    }

    public static String string(String key) {
        String string = "ervin_mod_1:";
        return string + key;
    }
}
