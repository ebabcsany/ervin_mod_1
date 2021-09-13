/*
 * Minecraft Forge
 * Copyright (c) 2016-2020.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package com.babcsany.minecraft.ervin_mod_1.world.minecraft;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

import static com.babcsany.minecraft.ervin_mod_1.world.minecraft.ModBiomeDictionary.ModType.*;

public class ModBiomeDictionary
{
    private static final boolean DEBUG = false;
    private static final Logger LOGGER = LogManager.getLogger();

    public static final class ModType
    {

        private static final Map<String, ModType> byName = new HashMap<String, ModType>();
        private static Collection<ModType> allTypes = Collections.unmodifiableCollection(byName.values());
        private static Collection<ModType> allTypes1 = Collections.unmodifiableCollection(byName.values());

        /*Temperature-based tags. Specifying neither implies a biome is temperate*/
        public static final ModType HOT = new ModType("HOT");
        public static final ModType COLD = new ModType("COLD");

        /*Tags specifying the amount of vegetation a biome has. Specifying neither implies a biome to have moderate amounts*/
        public static final ModType SPARSE = new ModType("SPARSE");
        public static final ModType DENSE = new ModType("DENSE");

        /*Tags specifying how moist a biome is. Specifying neither implies the biome as having moderate humidity*/
        public static final ModType WET = new ModType("WET");
        public static final ModType DRY = new ModType("DRY");

        /*Tree-based tags, SAVANNA refers to dry, desert-like trees (Such as Acacia), CONIFEROUS refers to snowy trees (Such as Spruce) and JUNGLE refers to jungle trees.
         * Specifying no tag implies a biome has temperate trees (Such as Oak)*/
        public static final ModType SAVANNA = new ModType("SAVANNA");
        public static final ModType CONIFEROUS = new ModType("CONIFEROUS");
        public static final ModType JUNGLE = new ModType("JUNGLE");

        /*Tags specifying the nature of a biome*/
        public static final ModType SPOOKY = new ModType("SPOOKY");
        public static final ModType DEAD = new ModType("DEAD");
        public static final ModType LUSH = new ModType("LUSH");
        public static final ModType MUSHROOM = new ModType("MUSHROOM");
        public static final ModType MAGICAL = new ModType("MAGICAL");
        public static final ModType RARE = new ModType("RARE");
        public static final ModType PLATEAU = new ModType("PLATEAU");
        public static final ModType MODIFIED = new ModType("MODIFIED");
        public static final ModType MIG = new ModType("MIG");

        public static final ModType OCEAN = new ModType("OCEAN");
        public static final ModType RIVER = new ModType("RIVER");
        /**
         * A general tag for all water-based biomes. Shown as present if OCEAN or RIVER are.
         **/
        public static final ModType WATER = new ModType("WATER", OCEAN, RIVER);

        /*Generic types which a biome can be*/
        public static final ModType MESA = new ModType("MESA");
        public static final ModType FOREST = new ModType("FOREST");
        public static final ModType PLAINS = new ModType("PLAINS");
        public static final ModType MOUNTAIN = new ModType("MOUNTAIN");
        public static final ModType HILLS = new ModType("HILLS");
        public static final ModType SWAMP = new ModType("SWAMP");
        public static final ModType SANDY = new ModType("SANDY");
        public static final ModType SNOWY = new ModType("SNOWY");
        public static final ModType WASTELAND = new ModType("WASTELAND");
        public static final ModType BEACH = new ModType("BEACH");
        public static final ModType VOID = new ModType("VOID");

        /*Tags specifying the dimension a biome generates in. Specifying none implies a biome that generates in a modded dimension*/
        public static final ModType OVERWORLD = new ModType("OVERWORLD");
        public static final ModType NETHER = new ModType("NETHER");
        public static final ModType END = new ModType("END");

        private final String name;
        private final List<ModType> subTypes;
        private final Set<Biome> biomes = new HashSet<Biome>();
        private final Set<Biome> biomesUn = Collections.unmodifiableSet(biomes);

        private ModType(String name, ModType... subTypes)
        {
            this.name = name;
            this.subTypes = ImmutableList.copyOf(subTypes);

            byName.put(name, this);
        }

        /**
         * Gets the name for this type.
         */
        public String getName()
        {
            return name;
        }

        public String toString()
        {
            return name;
        }

        /**
         * Retrieves a Type instance by name,
         * if one does not exist already it creates one.
         * This can be used as intermediate measure for modders to
         * add their own Biome types.
         * <p>
         * There are <i>no</i> naming conventions besides:
         * <ul><li><b>Must</b> be all upper case (enforced by name.toUpper())</li>
         * <li><b>No</b> Special characters. {Unenforced, just don't be a pain, if it becomes a issue I WILL
         * make this RTE with no worry about backwards compatibility}</li></ul>
         * <p>
         * Note: For performance sake, the return value of this function SHOULD be cached.
         * Two calls with the same name SHOULD return the same value.
         *
         * @param name The name of this Type
         * @return An instance of Type for this name.
         */
        public static ModType getType(String name, ModType... subTypes)
        {
            name = name.toUpperCase();
            ModType t = byName.get(name);
            if (t == null)
            {
                t = new ModType(name, subTypes);
            }
            return t;
        }

        /**
         * @return An unmodifiable collection of all current biome types.
         */
        public static Collection<ModType> getAll()
        {
            return allTypes1;
        }

        @Nullable
        public static ModType fromVanilla(Biome.Category category)
        {
            if (category == Biome.Category.NONE)
                return null;
            if (category == Biome.Category.THEEND)
                return VOID;
            return getType(category.name());
        }
    }

    private static final Map<ResourceLocation, BiomeInfo> biomeInfoMap = new HashMap<ResourceLocation, BiomeInfo>();

    private static class BiomeInfo
    {

        private final Set<ModType> types = new HashSet<ModType>();
        private final Set<ModType> typesUn = Collections.unmodifiableSet(this.types);

    }

    static
    {
        registerVanillaBiomes();
    }

    /**
     * Adds the given types to the biome.
     *
     */
    public static void addTypes(Biome biome, ModType... types)
    {
        Preconditions.checkArgument(ForgeRegistries.BIOMES.containsValue(biome), "Cannot add types to unregistered biome %s", biome);

        Collection<ModType> supertypes = listSupertypes(types);
        Collections.addAll(supertypes, types);

        for (ModType type : supertypes)
        {
            type.biomes.add(biome);
        }

        BiomeInfo biomeInfo = getBiomeInfo(biome);
        Collections.addAll(biomeInfo.types, types);
        biomeInfo.types.addAll(supertypes);
    }

    /**
     * Gets the set of biomes that have the given type.
     *
     */
    @Nonnull
    public static Set<Biome> getBiomes(ModType type)
    {
        return type.biomesUn;
    }

    /**
     * Gets the set of types that have been added to the given biome.
     *
     * @return
     */
    @Nonnull
    public static Set<ModType> getTypes(Biome biome)
    {
        ensureHasTypes(biome);
        return getBiomeInfo(biome).typesUn;
    }

    /**
     * Checks if the two given biomes have types in common.
     *
     * @return returns true if a common type is found, false otherwise
     */
    public static boolean areSimilar(Biome biomeA, Biome biomeB)
    {
        for (ModType type : getTypes(biomeA))
        {
            if (getTypes(biomeB).contains(type))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if the given type has been added to the given biome.
     *
     */
    public static boolean hasType(Biome biome, ModType type)
    {
        return getTypes(biome).contains(type);
    }

    /**
     * Checks if any type has been added to the given biome.
     *
     */
    public static boolean hasAnyType(Biome biome)
    {
        return !getBiomeInfo(biome).types.isEmpty();
    }

    /**
     * Automatically adds appropriate types to a given biome based on certain heuristics.
     * If a biome's types are requested and no types have been added to the biome so far, the biome's types
     * will be determined and added using this method.
     *
     */
    public static void makeBestGuess(Biome biome)
    {
        ModType type = ModType.fromVanilla(biome.getCategory());
        if (type != null)
        {
            ModBiomeDictionary.addTypes(biome, type);
        }

        if (biome.getDownfall() > 0.85f)
        {
            ModBiomeDictionary.addTypes(biome, WET);
        }

        if (biome.getDownfall() < 0.15f)
        {
            ModBiomeDictionary.addTypes(biome, DRY);
        }

        if (biome.getDefaultTemperature() > 0.85f)
        {
            ModBiomeDictionary.addTypes(biome, HOT);
        }

        if (biome.getDefaultTemperature() < 0.15f)
        {
            ModBiomeDictionary.addTypes(biome, COLD);
        }

        if (biome.isHighHumidity() && biome.getDepth() < 0.0F && (biome.getScale() <= 0.3F && biome.getScale() >= 0.0F))
        {
            ModBiomeDictionary.addTypes(biome, SWAMP);
        }

        if (biome.getDepth() <= -0.5F)
        {
            if (biome.getScale() == 0.0F)
            {
                ModBiomeDictionary.addTypes(biome, RIVER);
            }
            else
            {
                ModBiomeDictionary.addTypes(biome, OCEAN);
            }
        }

        if (biome.getScale() >= 0.4F && biome.getScale() < 1.5F)
        {
            ModBiomeDictionary.addTypes(biome, HILLS);
        }

        if (biome.getScale() >= 1.5F)
        {
            ModBiomeDictionary.addTypes(biome, MOUNTAIN);
        }
    }

    //Internal implementation
    private static BiomeInfo getBiomeInfo(Biome biome)
    {
        return biomeInfoMap.computeIfAbsent(biome.getRegistryName(), k -> new BiomeInfo());
    }

    /**
     * Ensure that at least one type has been added to the given biome.
     */
    static void ensureHasTypes(Biome biome)
    {
        if (!hasAnyType(biome))
        {
            makeBestGuess(biome);
            LOGGER.warn("No types have been added to Biome {}, types have been assigned on a best-effort guess: {}", biome.getRegistryName(), !getBiomeInfo(biome).types.isEmpty() ? getBiomeInfo(biome).types : "could not guess types");
        }
    }

    private static Collection<ModType> listSupertypes(ModType... types)
    {
        Set<ModType> supertypes = new HashSet<ModType>();
        Deque<ModType> next = new ArrayDeque<ModType>();
        Collections.addAll(next, types);

        while (!next.isEmpty())
        {
            ModType type = next.remove();

            for (ModType sType : ModType.byName.values())
            {
                if (sType.subTypes.contains(type) && supertypes.add(sType))
                    next.add(sType);
            }
        }

        return supertypes;
    }

    private static void registerVanillaBiomes()
    {
		addTypes(Biomes.OCEAN, OCEAN, OVERWORLD);
		addTypes(Biomes.PLAINS, PLAINS, OVERWORLD);
		addTypes(Biomes.DESERT, HOT, DRY, SANDY, OVERWORLD);
		addTypes(Biomes.MOUNTAINS, MOUNTAIN, HILLS, OVERWORLD);
		addTypes(Biomes.FOREST, FOREST, OVERWORLD);
		addTypes(Biomes.TAIGA, COLD, CONIFEROUS, FOREST, OVERWORLD);
		addTypes(Biomes.SWAMP, WET, SWAMP, OVERWORLD);
		addTypes(Biomes.RIVER, RIVER, OVERWORLD);
		addTypes(Biomes.NETHER_WASTES, HOT, DRY, NETHER);
		addTypes(Biomes.THE_END, COLD, DRY, END);
		addTypes(Biomes.FROZEN_OCEAN, COLD, OCEAN, SNOWY, OVERWORLD);
		addTypes(Biomes.FROZEN_RIVER, COLD, RIVER, SNOWY, OVERWORLD);
		addTypes(Biomes.SNOWY_TUNDRA, COLD, SNOWY, WASTELAND, OVERWORLD);
		addTypes(Biomes.SNOWY_MOUNTAINS, COLD, SNOWY, MOUNTAIN, OVERWORLD);
		addTypes(Biomes.MUSHROOM_FIELDS, MUSHROOM, RARE, OVERWORLD);
		addTypes(Biomes.MUSHROOM_FIELD_SHORE, MUSHROOM, BEACH, RARE, OVERWORLD);
		addTypes(Biomes.BEACH, BEACH, OVERWORLD);
		addTypes(Biomes.DESERT_HILLS, HOT, DRY, SANDY, HILLS, OVERWORLD);
		addTypes(Biomes.WOODED_HILLS, FOREST, HILLS, OVERWORLD);
		addTypes(Biomes.TAIGA_HILLS, COLD, CONIFEROUS, FOREST, HILLS, OVERWORLD);
		addTypes(Biomes.MOUNTAIN_EDGE, MOUNTAIN, OVERWORLD);
		addTypes(Biomes.JUNGLE, HOT, WET, DENSE, JUNGLE, OVERWORLD);
		addTypes(Biomes.JUNGLE_HILLS, HOT, WET, DENSE, JUNGLE, HILLS, OVERWORLD);
		addTypes(Biomes.JUNGLE_EDGE, HOT, WET, JUNGLE, FOREST, RARE, OVERWORLD);
		addTypes(Biomes.DEEP_OCEAN, OCEAN, OVERWORLD);
		addTypes(Biomes.STONE_SHORE, BEACH, OVERWORLD);
		addTypes(Biomes.SNOWY_BEACH, COLD, BEACH, SNOWY, OVERWORLD);
		addTypes(Biomes.BIRCH_FOREST, FOREST, OVERWORLD);
		addTypes(Biomes.BIRCH_FOREST_HILLS, FOREST, HILLS, OVERWORLD);
		addTypes(Biomes.DARK_FOREST, SPOOKY, DENSE, FOREST, OVERWORLD);
		addTypes(Biomes.SNOWY_TAIGA, COLD, CONIFEROUS, FOREST, SNOWY, OVERWORLD);
		addTypes(Biomes.SNOWY_TAIGA_HILLS, COLD, CONIFEROUS, FOREST, SNOWY, HILLS, OVERWORLD);
		addTypes(Biomes.GIANT_TREE_TAIGA, COLD, CONIFEROUS, FOREST, OVERWORLD);
		addTypes(Biomes.GIANT_TREE_TAIGA_HILLS, COLD, CONIFEROUS, FOREST, HILLS, OVERWORLD);
		addTypes(Biomes.WOODED_MOUNTAINS, MOUNTAIN, FOREST, SPARSE, OVERWORLD);
		addTypes(Biomes.SAVANNA, HOT, SAVANNA, PLAINS, SPARSE, OVERWORLD);
		addTypes(Biomes.SAVANNA_PLATEAU, HOT, SAVANNA, PLAINS, SPARSE, RARE, OVERWORLD, PLATEAU);
		addTypes(Biomes.BADLANDS, MESA, SANDY, DRY, OVERWORLD);
		addTypes(Biomes.WOODED_BADLANDS_PLATEAU, MESA, SANDY, DRY, SPARSE, OVERWORLD, PLATEAU);
		addTypes(Biomes.BADLANDS_PLATEAU, MESA, SANDY, DRY, OVERWORLD, PLATEAU);
		addTypes(Biomes.SMALL_END_ISLANDS, END);
		addTypes(Biomes.END_MIDLANDS, END);
		addTypes(Biomes.END_HIGHLANDS, END);
		addTypes(Biomes.END_BARRENS, END);
		addTypes(Biomes.WARM_OCEAN, OCEAN, HOT, OVERWORLD);
		addTypes(Biomes.LUKEWARM_OCEAN, OCEAN, OVERWORLD);
		addTypes(Biomes.COLD_OCEAN, OCEAN, COLD, OVERWORLD);
		addTypes(Biomes.DEEP_WARM_OCEAN, OCEAN, HOT, OVERWORLD);
		addTypes(Biomes.DEEP_LUKEWARM_OCEAN, OCEAN, OVERWORLD);
		addTypes(Biomes.DEEP_COLD_OCEAN, OCEAN, COLD, OVERWORLD);
		addTypes(Biomes.DEEP_FROZEN_OCEAN, OCEAN, COLD, OVERWORLD);
		addTypes(Biomes.THE_VOID, VOID);
		addTypes(Biomes.SUNFLOWER_PLAINS, PLAINS, RARE, OVERWORLD);
		addTypes(Biomes.DESERT_LAKES, HOT, DRY, SANDY, RARE, OVERWORLD);
		addTypes(Biomes.GRAVELLY_MOUNTAINS, MOUNTAIN, SPARSE, RARE, OVERWORLD);
		addTypes(Biomes.FLOWER_FOREST, FOREST, HILLS, RARE, OVERWORLD);
		addTypes(Biomes.TAIGA_MOUNTAINS, COLD, CONIFEROUS, FOREST, MOUNTAIN, RARE, OVERWORLD);
		addTypes(Biomes.SWAMP_HILLS, WET, SWAMP, HILLS, RARE, OVERWORLD);
		addTypes(Biomes.ICE_SPIKES, COLD, SNOWY, HILLS, RARE, OVERWORLD);
		addTypes(Biomes.MODIFIED_JUNGLE, HOT, WET, DENSE, JUNGLE, MOUNTAIN, RARE, OVERWORLD, MODIFIED);
		addTypes(Biomes.MODIFIED_JUNGLE_EDGE, HOT, SPARSE, JUNGLE, HILLS, RARE, OVERWORLD, MODIFIED);
		addTypes(Biomes.TALL_BIRCH_FOREST, FOREST, DENSE, HILLS, RARE, OVERWORLD);
		addTypes(Biomes.TALL_BIRCH_HILLS, FOREST, DENSE, MOUNTAIN, RARE, OVERWORLD);
		addTypes(Biomes.DARK_FOREST_HILLS, SPOOKY, DENSE, FOREST, MOUNTAIN, RARE, OVERWORLD);
		addTypes(Biomes.SNOWY_TAIGA_MOUNTAINS, COLD, CONIFEROUS, FOREST, SNOWY, MOUNTAIN, RARE, OVERWORLD);
		addTypes(Biomes.GIANT_SPRUCE_TAIGA, DENSE, FOREST, RARE, OVERWORLD);
		addTypes(Biomes.GIANT_SPRUCE_TAIGA_HILLS, DENSE, FOREST, HILLS, RARE, OVERWORLD);
		addTypes(Biomes.MODIFIED_GRAVELLY_MOUNTAINS, MOUNTAIN, SPARSE, RARE, OVERWORLD, MODIFIED);
		addTypes(Biomes.SHATTERED_SAVANNA, HOT, DRY, SPARSE, SAVANNA, MOUNTAIN, RARE, OVERWORLD);
		addTypes(Biomes.SHATTERED_SAVANNA_PLATEAU, HOT, DRY, SPARSE, SAVANNA, HILLS, RARE, OVERWORLD, PLATEAU);
		addTypes(Biomes.ERODED_BADLANDS, HOT, DRY, SPARSE, MOUNTAIN, RARE, OVERWORLD);
		addTypes(Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, HOT, DRY, SPARSE, HILLS, RARE, OVERWORLD, PLATEAU, MODIFIED);
		addTypes(Biomes.MODIFIED_BADLANDS_PLATEAU, HOT, DRY, SPARSE, MOUNTAIN, RARE, OVERWORLD, PLATEAU, MODIFIED);

        if (DEBUG)
        {
            StringBuilder buf = new StringBuilder();
            buf.append("BiomeDictionary:\n");
            ModType.byName.forEach((name, type) -> buf.append("    ").append(type.name).append(": ").append(type.biomes.stream().map(b -> b.getRegistryName().toString()).collect(Collectors.joining(", "))).append('\n'));
            LOGGER.debug(buf.toString());
        }
    }
}