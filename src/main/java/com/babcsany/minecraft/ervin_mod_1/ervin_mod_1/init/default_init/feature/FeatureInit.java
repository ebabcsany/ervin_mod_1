package com.babcsany.minecraft.ervin_mod_1.ervin_mod_1.init.default_init.feature;

import net.minecraft.world.gen.feature.Feature;

public class FeatureInit {

    public FeatureInit(Feature<?> features) {
        register(features);
    }

    public void register(Feature<?> features) {
        com.babcsany.minecraft.init.FeatureInit.FEATURES = features;
    }
}
