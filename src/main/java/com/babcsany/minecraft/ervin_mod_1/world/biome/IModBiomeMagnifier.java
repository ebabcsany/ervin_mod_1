package com.babcsany.minecraft.ervin_mod_1.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraftforge.fml.RegistryObject;

public interface IModBiomeMagnifier extends net.minecraft.world.biome.IBiomeMagnifier {
   RegistryObject<Biome> getRegistryObjectBiome(long seed, int x, int y, int z, BiomeManager.IBiomeReader biomeReader);
}
