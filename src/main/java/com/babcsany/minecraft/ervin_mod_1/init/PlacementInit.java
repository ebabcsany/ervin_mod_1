package com.babcsany.minecraft.ervin_mod_1.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NetherMagma;
import net.minecraft.world.gen.placement.Placement;

public class PlacementInit {

    public static final Placement<FrequencyConfig> MAGMA = register("magma", new NetherMagma(FrequencyConfig.field_236971_a_));

    private static <T extends IPlacementConfig, G extends Placement<T>> G register(String key, G p_214999_1_) {
        return Registry.register(Registry.DECORATOR, key, p_214999_1_);
    }
}
