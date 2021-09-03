package com.babcsany.minecraft.ervin_mod_1.world;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.IBiomeMagnifier;

import java.util.OptionalLong;

public class ModDimensionType extends net.minecraft.world.DimensionType {
    public static final DimensionType OVERWORLD_TYPE = DimensionType.OVERWORLD_TYPE;
    public static final DimensionType NETHER_TYPE = DimensionType.NETHER_TYPE;
    public static final DimensionType END_TYPE = DimensionType.END_TYPE;
    public static final DimensionType field_241498_j_ = DimensionType.field_241498_j_;
    protected ModDimensionType(OptionalLong p_i241242_1_, boolean p_i241242_2_, boolean p_i241242_3_, boolean p_i241242_4_, boolean p_i241242_5_, boolean p_i241242_6_, boolean p_i241242_7_, boolean p_i241242_8_, boolean p_i241242_9_, boolean p_i241242_10_, int p_i241242_11_, ResourceLocation p_i241242_12_, float p_i241242_13_) {
        super(p_i241242_1_, p_i241242_2_, p_i241242_3_, p_i241242_4_, p_i241242_5_, p_i241242_6_, p_i241242_7_, p_i241242_8_, p_i241242_9_, p_i241242_10_, p_i241242_11_, p_i241242_12_, p_i241242_13_);
    }

    public ModDimensionType(OptionalLong p_i241243_1_, boolean p_i241243_2_, boolean p_i241243_3_, boolean p_i241243_4_, boolean p_i241243_5_, boolean p_i241243_6_, boolean p_i241243_7_, boolean p_i241243_8_, boolean p_i241243_9_, boolean p_i241243_10_, boolean p_i241243_11_, int p_i241243_12_, IBiomeMagnifier p_i241243_13_, ResourceLocation p_i241243_14_, float p_i241243_15_) {
        super(p_i241243_1_, p_i241243_2_, p_i241243_3_, p_i241243_4_, p_i241243_5_, p_i241243_6_, p_i241243_7_, p_i241243_8_, p_i241243_9_, p_i241243_10_, p_i241243_11_, p_i241243_12_, p_i241243_13_, p_i241243_14_, p_i241243_15_);
    }
}
