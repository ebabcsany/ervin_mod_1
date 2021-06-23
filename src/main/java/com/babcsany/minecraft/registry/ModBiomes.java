package com.babcsany.minecraft.registry;

import com.babcsany.minecraft.ervin_mod_1.registry.ModRegistry;
import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiome;
import com.babcsany.minecraft.mod_biomes.OceanBiome;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.*;

import java.util.Collections;

//@net.minecraftforge.registries.ObjectHolder("ervin_mod_1")
public class ModBiomes {


   //public static final ModBiome<?> OCEAN = register(0, "ervin_mod_1:ocean", new OceanBiome());
   //@net.minecraftforge.registries.ObjectHolder("ervin_mod_1:ocean")
   //public static final ModBiome<?> DEFAULT = OCEAN;

   /*private static <T extends Biome> ModBiome<?> register(int id, String key, ModBiome<?> biome) {
      Registry.register(ModRegistry.MOD_BIOME, id, key, biome);
      if (biome.isMutation()) {
         ModBiome.MUTATION_TO_BASE_ID_MAP.put(biome, ModRegistry.MOD_BIOME.getId(ModRegistry.MOD_BIOME.getOrDefault(new ResourceLocation(biome.parent))));
      }

      return biome;
   }*/

   /*static {
      Collections.addAll(ModBiome.BIOMES, OCEAN);
   }*/
}
