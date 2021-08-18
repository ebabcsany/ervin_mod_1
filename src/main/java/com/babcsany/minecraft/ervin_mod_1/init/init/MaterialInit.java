package com.babcsany.minecraft.ervin_mod_1.init.init;

import net.minecraft.block.material.Material;

public class MaterialInit {
    public static final Material AIR = (new Material.Builder(MaterialColorInit.AIR)).doesNotBlockMovement().notOpaque().flammable().notSolid().replaceable().build();
    public static final Material CRASK = (new Material.Builder(MaterialColorInit.CRASK)).doesNotBlockMovement().notOpaque().notSolid().replaceable().build();
    public static final Material WATER = (new Material.Builder(MaterialColorInit.WATER)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().replaceable().liquid().build();
    public static final Material JURK = (new Material.Builder(MaterialColorInit.MAGENTA)).doesNotBlockMovement().notOpaque().flammable().notSolid().replaceable().liquid().build();
    public static final Material ROCK = (new Material.Builder(MaterialColorInit.STONE)).build();
    public static final Material WOOD = (new Material.Builder(MaterialColorInit.WOOD)).flammable().build();
    public static final Material WOOL = (new Material.Builder(MaterialColorInit.WOOL)).flammable().build();
    public static final Material SAND = (new Material.Builder(MaterialColorInit.SAND)).build();

    public static Material[] material(Material... materials) {
        return materials;
    }

    public static final Material[] MATERIALS = material(AIR, CRASK, WATER, JURK, ROCK, WOOD, WOOL, SAND, Material.AIR, Material.STRUCTURE_VOID, Material.PORTAL, Material.CARPET, Material.PLANTS, Material.OCEAN_PLANT, Material.TALL_PLANTS, Material.SEA_GRASS, Material.WATER, Material.BUBBLE_COLUMN, Material.LAVA, Material.SNOW, Material.FIRE, Material.MISCELLANEOUS, Material.WEB, Material.REDSTONE_LIGHT, Material.CLAY, Material.EARTH, Material.ORGANIC, Material.PACKED_ICE, Material.SAND, Material.SPONGE, Material.SHULKER, Material.WOOD, Material.NETHER_WOOD, Material.BAMBOO_SAPLING, Material.BAMBOO, Material.WOOL, Material.TNT, Material.LEAVES, Material.GLASS, Material.ICE, Material.CACTUS, Material.ROCK, Material.IRON, Material.SNOW_BLOCK, Material.ANVIL, Material.BARRIER, Material.PISTON, Material.CORAL, Material.GOURD, Material.DRAGON_EGG, Material.CAKE);
}
