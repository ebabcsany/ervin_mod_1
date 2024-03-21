package com.babcsany.minecraft.ervin_mod_1.mods.mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.biome.ModBiomeMaker;
import com.babcsany.minecraft.ervin_mod_1.world.biome.dictionary.BiomeDictionary;
import com.babcsany.minecraft.ervin_mod_1.world.biome.manager.BiomeManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
			Ervin_mod_1.MOD_ID);

	public static final RegistryObject<Biome> MIGT_BIOME = BIOMES.register("migt_biome", () -> ModBiomeMaker.MIG_BIOME);

	public static void registerBiomes() {
		registerBiomeCool1(MIGT_BIOME.get(), BiomeDictionary.Type.fromVanilla(Category.PLAINS), BiomeDictionary.Type.OVERWORLD);
	}

	private static void registerBiomeCool1(Biome biome, BiomeDictionary.Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100000));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
		BiomeProvider.CODEC.boxed();
	}

	@SuppressWarnings("deprecation")
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}
}
