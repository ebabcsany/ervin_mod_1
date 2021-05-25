package com.babcsany.minecraft.ervin_mod_1.init.init;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

public class MaterialInit {
    public static final Material AIR = (new Material.Builder(MaterialColorInit.AIR)).doesNotBlockMovement().notOpaque().flammable().notSolid().replaceable().build();
    public static final Material CRASK = (new Material.Builder(MaterialColorInit.CRASK)).doesNotBlockMovement().notOpaque().notSolid().replaceable().build();
    public static final Material WATER = (new Material.Builder(MaterialColorInit.WATER)).doesNotBlockMovement().notOpaque().notSolid().pushDestroys().replaceable().liquid().build();
    public static final Material JURK = (new Material.Builder(MaterialColorInit.AIR)).doesNotBlockMovement().notOpaque().flammable().notSolid().replaceable().liquid().build();
    public static final Material ROCK = (new Material.Builder(MaterialColorInit.STONE)).build();
    public static final Material WOOD = (new Material.Builder(MaterialColorInit.WOOD)).flammable().build();
    public static final Material WOOL = (new Material.Builder(MaterialColorInit.WOOL)).flammable().build();
    public static final Material SAND = (new Material.Builder(MaterialColorInit.SAND)).build();

}
