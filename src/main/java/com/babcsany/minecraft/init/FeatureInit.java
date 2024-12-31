package com.babcsany.minecraft.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.GenOreFeature;
import com.babcsany.minecraft.ervin_mod_1.world.gen.feature.config.GenOreFeatureConfig;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Ervin_mod_1.MOD_ID);

    public static final RegistryObject<Feature<GenOreFeatureConfig>> GEN_ORE = FEATURES.register("gen_ore", () -> new GenOreFeature(GenOreFeatureConfig.CODEC));
    public static final RegistryObject<Feature<OreFeatureConfig>> GEN_1ORE = FEATURES.register("gen_1ore", () -> new OreFeature(OreFeatureConfig.CODEC));
//    public static final RegistryObject<Feature<GenOreFeatureConfig>> GEN_ORE = FEATURES.register("gen_ore", () -> new GenOreFeature(GenOreFeatureConfig.deserialize));

    public static <C extends IFeatureConfig, F extends Feature<C>> F register(String name, F value) {
        return registerDefault(string(name), value);
    }

    private static String string(String key) {
        return Ervin_mod_1.identifier(key);
    }

    @Deprecated
    private static <C extends IFeatureConfig, F extends Feature<C>> F registerDefault(String key, F value) {
        return Registry.register(Registry.FEATURE, key, value);
    }

    public static void register() {
        Ervin_mod_1.register(FeatureInit.class);
    }
}
