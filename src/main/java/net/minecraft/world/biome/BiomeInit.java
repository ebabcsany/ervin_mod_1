package net.minecraft.world.biome;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class BiomeInit {

    public static Biome register(int id, String key, Biome biome) {
        Registry.register(Registry.BIOME, id, string(key), biome);
        if (biome.isMutation()) {
            Biome.MUTATION_TO_BASE_ID_MAP.put(biome, Registry.BIOME.getId(Registry.BIOME.getOrDefault(new ResourceLocation(biome.parent))));
        }

        return biome;
    }

    public static String string(String key) {
        String string = "ervin_mod_1:";
        return string + key;
    }
}
