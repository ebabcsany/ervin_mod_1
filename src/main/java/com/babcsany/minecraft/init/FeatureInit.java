package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.world.feature.VoidStartPlatformFeature1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeature;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class FeatureInit {

    public static FeatureInit FEATURES;

    public static final Feature<GenOreFeatureConfig> GEN_ORE = register("ervin_mod_1:gen_ore", new GenOreFeature(GenOreFeatureConfig.field_236566_a_));
    public static final Feature<NoFeatureConfig> VOID_START_PLATFORM1 = register("ervin_mod_1:void_start_platform1", new VoidStartPlatformFeature1(NoFeatureConfig.field_236558_a_));


    private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
        return Registry.register(Registry.FEATURE, key, value);
    }
}
