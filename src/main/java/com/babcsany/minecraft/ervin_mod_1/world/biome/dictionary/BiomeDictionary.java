package com.babcsany.minecraft.ervin_mod_1.world.biome.dictionary;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;
import java.util.*;

public class BiomeDictionary {
    private static final Map<Biome, Type> biomeTypeMap = new HashMap<>();
    private static final Collection<Type> TYPES = Collections.unmodifiableCollection(biomeTypeMap.values());

    public static void addTypes(Biome biome, Type... subTypes) {
        for (Type subType : subTypes) {
            biomeTypeMap.put(biome, subType);
        }
    }

    public static Collection<Type> getTypes() {
        return TYPES;
    }

    public static final class Type
    {

        private static final Map<String, Type> byName = new HashMap<>();
        private static Collection<Type> allTypes = Collections.unmodifiableCollection(byName.values());

        public static final Type MIG = new Type("MIG");

        /*Tags specifying the dimension a biome generates in. Specifying none implies a biome that generates in a modded dimension*/
        public static final Type OVERWORLD = new Type("OVERWORLD");
        public static final Type NETHER = new Type("NETHER");
        public static final Type END = new Type("END");
        public static final Type OCEAN = new Type("OCEAN");
        public static final Type PLAINS = new Type("PLAINS");
        public static final Type DEAD = new Type("DEAD");
        public static final Type DENSE = new Type("DENSE");
        public static final Type HILLS = new Type("HILLS");
        public static final Type MOUNTAIN = new Type("MOUNTAIN");
        public static final Type BEACH = new Type("BEACH");
        public static final Type PLATEAU = new Type("PLATEAU");
        public static final Type SANDY = new Type("SANDY");
        public static final Type SAVANNA = new Type("SAVANNA");
        public static final Type SNOWY = new Type("SNOWY");
        public static final Type SPARSE = new Type("SPARSE");
        public static final Type SWAMP = new Type("SWAMP");
        public static final Type SPOOKY = new Type("SPOOKY");
        public static final Type WASTELAND = new Type("WASTELAND");
        public static final Type WET = new Type("WET");
        public static final Type VOID = new Type("VOID");
        public static final Type WATER = new Type("WATER");
        public static final Type MESA = new Type("MESA");
        public static final Type HOT = new Type("HOT");
        public static final Type DRY = new Type("DRY");
        public static final Type COLD = new Type("COLD");
        public static final Type LUSH = new Type("LUSH");
        public static final Type MODIFIED = new Type("MODIFIED");
        public static final Type CONIFEROUS = new Type("CONIFEROUS");
        public static final Type MAGICAL = new Type("MAGICAL");
        public static final Type MUSHROOM = new Type("MUSHROOM");
        public static final Type RARE = new Type("RARE");
        public static final Type FIRG = new Type("FIRG", Type.fromVanilla(Biome.Category.THEEND));
        public static final Type SCRAFTH = new Type("SCRAFTH");

        private final String name;
        private final List<Type> subTypes;
        private final Set<Biome> biomes = new HashSet<Biome>();
        private final Set<Biome> biomesUn = Collections.unmodifiableSet(biomes);

        public Type(String name, Type... subTypes)
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
        public static Type getType(String name, Type... subTypes)
        {
            name = name.toUpperCase();
            Type t = byName.get(name);
            if (t == null)
            {
                t = new Type(name, subTypes);
            }
            return t;
        }

        /**
         * @return An unmodifiable collection of all current biome types.
         */
        public static Collection<Type> getAll()
        {
            return allTypes;
        }

        @Nullable
        public static Type fromVanilla(Biome.Category category)
        {
            if (category == Biome.Category.NONE)
                return null;
            if (category == Biome.Category.THEEND)
                return MIG;
            return getType(category.name());
        }
    }
}
