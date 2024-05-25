package com.babcsany.minecraft.ervin_mod_1.world.gen;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Objects;

public class BiomeKeys {
    public static final ArrayList<RegistryKey<Biome>> BIOME_KEYS = new ArrayList<>(79);

    public static Biome get(RegistryKey<Biome> biomeRegistryKey) {
        return BiomeKeys.getBiomeWithKey(biomeRegistryKey.getLocation().getPath());
    }

    public static RegistryKey<Biome> get(Biome biome) {
        return makeKey(biome.delegate.name().getPath());
    }

    public static Biome getBiomeWithKey(String key) {
        return Objects.requireNonNull(ForgeRegistries.BIOMES.getValue(new ResourceLocation(key)));
    }

    public static RegistryKey<Biome> makeKey(String key) {
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(Ervin_mod_1.MOD_ID, key));
    }

    static {
        BIOME_KEYS.add(Biomes.OCEAN);
        BIOME_KEYS.add(Biomes.PLAINS);
        BIOME_KEYS.add(Biomes.DESERT);
        BIOME_KEYS.add(Biomes.MOUNTAINS);
        BIOME_KEYS.add(Biomes.FOREST);
        BIOME_KEYS.add(Biomes.TAIGA);
        BIOME_KEYS.add(Biomes.SWAMP);
        BIOME_KEYS.add(Biomes.RIVER);
        BIOME_KEYS.add(Biomes.NETHER_WASTES);
        BIOME_KEYS.add(Biomes.THE_END);
        BIOME_KEYS.add(Biomes.FROZEN_OCEAN);
        BIOME_KEYS.add(Biomes.FROZEN_RIVER);
        BIOME_KEYS.add(Biomes.SNOWY_TUNDRA);
        BIOME_KEYS.add(Biomes.SNOWY_MOUNTAINS);
        BIOME_KEYS.add(Biomes.MUSHROOM_FIELDS);
        BIOME_KEYS.add(Biomes.MUSHROOM_FIELD_SHORE);
        BIOME_KEYS.add(Biomes.BEACH);
        BIOME_KEYS.add(Biomes.DESERT_HILLS);
        BIOME_KEYS.add(Biomes.WOODED_HILLS);
        BIOME_KEYS.add(Biomes.TAIGA_HILLS);
        BIOME_KEYS.add(Biomes.MOUNTAIN_EDGE);
        BIOME_KEYS.add(Biomes.JUNGLE);
        BIOME_KEYS.add(Biomes.JUNGLE_HILLS);
        BIOME_KEYS.add(Biomes.JUNGLE_EDGE);
        BIOME_KEYS.add(Biomes.DEEP_OCEAN);
        BIOME_KEYS.add(Biomes.STONE_SHORE);
        BIOME_KEYS.add(Biomes.SNOWY_BEACH);
        BIOME_KEYS.add(Biomes.BIRCH_FOREST);
        BIOME_KEYS.add(Biomes.BIRCH_FOREST_HILLS);
        BIOME_KEYS.add(Biomes.DARK_FOREST);
        BIOME_KEYS.add(Biomes.SNOWY_TAIGA);
        BIOME_KEYS.add(Biomes.SNOWY_TAIGA_HILLS);
        BIOME_KEYS.add(Biomes.GIANT_TREE_TAIGA);
        BIOME_KEYS.add(Biomes.GIANT_TREE_TAIGA_HILLS);
        BIOME_KEYS.add(Biomes.WOODED_MOUNTAINS);
        BIOME_KEYS.add(Biomes.SAVANNA);
        BIOME_KEYS.add(Biomes.SAVANNA_PLATEAU);
        BIOME_KEYS.add(Biomes.BADLANDS);
        BIOME_KEYS.add(Biomes.WOODED_BADLANDS_PLATEAU);
        BIOME_KEYS.add(Biomes.BADLANDS_PLATEAU);
        BIOME_KEYS.add(Biomes.SMALL_END_ISLANDS);
        BIOME_KEYS.add(Biomes.END_MIDLANDS);
        BIOME_KEYS.add(Biomes.END_HIGHLANDS);
        BIOME_KEYS.add(Biomes.END_BARRENS);
        BIOME_KEYS.add(Biomes.WARM_OCEAN);
        BIOME_KEYS.add(Biomes.LUKEWARM_OCEAN);
        BIOME_KEYS.add(Biomes.COLD_OCEAN);
        BIOME_KEYS.add(Biomes.DEEP_WARM_OCEAN);
        BIOME_KEYS.add(Biomes.DEEP_LUKEWARM_OCEAN);
        BIOME_KEYS.add(Biomes.DEEP_COLD_OCEAN);
        BIOME_KEYS.add(Biomes.DEEP_FROZEN_OCEAN);
        BIOME_KEYS.add(Biomes.THE_VOID);
        BIOME_KEYS.add(Biomes.SUNFLOWER_PLAINS);
        BIOME_KEYS.add(Biomes.DESERT_LAKES);
        BIOME_KEYS.add(Biomes.GRAVELLY_MOUNTAINS);
        BIOME_KEYS.add(Biomes.FLOWER_FOREST);
        BIOME_KEYS.add(Biomes.TAIGA_MOUNTAINS);
        BIOME_KEYS.add(Biomes.SWAMP_HILLS);
        BIOME_KEYS.add(Biomes.ICE_SPIKES);
        BIOME_KEYS.add(Biomes.MODIFIED_JUNGLE);
        BIOME_KEYS.add(Biomes.MODIFIED_JUNGLE_EDGE);
        BIOME_KEYS.add(Biomes.TALL_BIRCH_FOREST);
        BIOME_KEYS.add(Biomes.TALL_BIRCH_HILLS);
        BIOME_KEYS.add(Biomes.DARK_FOREST_HILLS);
        BIOME_KEYS.add(Biomes.SNOWY_TAIGA_MOUNTAINS);
        BIOME_KEYS.add(Biomes.GIANT_SPRUCE_TAIGA);
        BIOME_KEYS.add(Biomes.GIANT_SPRUCE_TAIGA_HILLS);
        BIOME_KEYS.add(Biomes.MODIFIED_GRAVELLY_MOUNTAINS);
        BIOME_KEYS.add(Biomes.SHATTERED_SAVANNA);
        BIOME_KEYS.add(Biomes.SHATTERED_SAVANNA_PLATEAU);
        BIOME_KEYS.add(Biomes.ERODED_BADLANDS);
        BIOME_KEYS.add(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU);
        BIOME_KEYS.add(Biomes.MODIFIED_BADLANDS_PLATEAU);
        BIOME_KEYS.add(Biomes.BAMBOO_JUNGLE);
        BIOME_KEYS.add(Biomes.BAMBOO_JUNGLE_HILLS);
        BIOME_KEYS.add(Biomes.SOUL_SAND_VALLEY);
        BIOME_KEYS.add(Biomes.CRIMSON_FOREST);
        BIOME_KEYS.add(Biomes.WARPED_FOREST);
        BIOME_KEYS.add(Biomes.BASALT_DELTAS);
    }
}
