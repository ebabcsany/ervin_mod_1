package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.biome;

import net.minecraft.world.biome.Biomes;

public class BiomeInit {

    public BiomeInit(Biomes biomes) {
        register(biomes);
    }

    public void register(Biomes biomes) {
        com.babcsany.minecraft.init.BiomeInit.BIOMES = biomes;
    }
}
