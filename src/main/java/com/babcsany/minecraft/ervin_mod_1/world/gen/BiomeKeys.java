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
    public static final ArrayList<RegistryKey<Biome>> BIOMES = new ArrayList<>(79);

    public static Biome get(RegistryKey<Biome> biomeRegistryKey) {
        return BiomeKeys.getBiomeWithKey(biomeRegistryKey.getRegistryName().getPath());
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


        BIOMES.add(get(getBiomeWithKey(Biomes.OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.PLAINS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DESERT.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.MOUNTAINS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.FOREST.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.TAIGA.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SWAMP.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.RIVER.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.NETHER_WASTES.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.THE_END.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.FROZEN_OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.FROZEN_RIVER.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SNOWY_TUNDRA.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SNOWY_MOUNTAINS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.MUSHROOM_FIELDS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.MUSHROOM_FIELD_SHORE.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.BEACH.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DESERT_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.WOODED_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.TAIGA_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.MOUNTAIN_EDGE.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.JUNGLE.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.JUNGLE_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.JUNGLE_EDGE.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DEEP_OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.STONE_SHORE.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SNOWY_BEACH.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.BIRCH_FOREST.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.BIRCH_FOREST_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DARK_FOREST.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SNOWY_TAIGA.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SNOWY_TAIGA_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.GIANT_TREE_TAIGA.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.GIANT_TREE_TAIGA_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.WOODED_MOUNTAINS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SAVANNA.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SAVANNA_PLATEAU.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.BADLANDS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.WOODED_BADLANDS_PLATEAU.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.BADLANDS_PLATEAU.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SMALL_END_ISLANDS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.END_MIDLANDS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.END_HIGHLANDS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.END_BARRENS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.WARM_OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.LUKEWARM_OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.COLD_OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DEEP_WARM_OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DEEP_LUKEWARM_OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DEEP_COLD_OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DEEP_FROZEN_OCEAN.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.THE_VOID.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SUNFLOWER_PLAINS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DESERT_LAKES.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.GRAVELLY_MOUNTAINS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.FLOWER_FOREST.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.TAIGA_MOUNTAINS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SWAMP_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.ICE_SPIKES.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.MODIFIED_JUNGLE.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.MODIFIED_JUNGLE_EDGE.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.TALL_BIRCH_FOREST.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.TALL_BIRCH_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.DARK_FOREST_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SNOWY_TAIGA_MOUNTAINS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.GIANT_SPRUCE_TAIGA.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.GIANT_SPRUCE_TAIGA_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.MODIFIED_GRAVELLY_MOUNTAINS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SHATTERED_SAVANNA.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SHATTERED_SAVANNA_PLATEAU.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.ERODED_BADLANDS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.MODIFIED_BADLANDS_PLATEAU.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.BAMBOO_JUNGLE.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.BAMBOO_JUNGLE_HILLS.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.SOUL_SAND_VALLEY.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.CRIMSON_FOREST.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.WARPED_FOREST.getRegistryName().getPath())));
        BIOMES.add(get(getBiomeWithKey(Biomes.BASALT_DELTAS.getRegistryName().getPath())));
    }
}
