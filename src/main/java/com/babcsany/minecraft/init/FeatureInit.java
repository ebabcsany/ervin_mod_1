package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeature;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeatureConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Ervin_mod_1.MOD_ID);

    public static final Feature<GenOreFeatureConfig> GEN_ORE = register(string("gen_ore"), new GenOreFeature(GenOreFeatureConfig.CODEC));
//    public static final RegistryObject<Feature<GenOreFeatureConfig>> GEN_ORE = FEATURES.register("gen_ore", () -> new GenOreFeature(GenOreFeatureConfig.deserialize));

    private static String string(String name) {
        String string = "ervin_mod_1:";
        return string + name;
    }

    private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
        return Registry.register(Registry.FEATURE, key, value);
    }
}
