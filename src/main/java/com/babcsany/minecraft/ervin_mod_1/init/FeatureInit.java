package com.babcsany.minecraft.ervin_mod_1.init;

import com.babcsany.minecraft.ervin_mod_1.Ervin_mod_1;
import com.babcsany.minecraft.ervin_mod_1.world.feature.VoidStartPlatformFeature1;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.PillagerOutpostStructure;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureInit {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
            Ervin_mod_1.MOD_ID);

    //public static final RegistryObject<Feature<NoFeatureConfig>> PILLAGER_OUTPOST = FEATURES.register("pillager_outpost", () -> new PillagerOutpostStructure(NoFeatureConfig.field_236558_a_));
    //public static final RegistryObject<Feature<OreFeatureConfig1>> ORE = FEATURES.register("ore", new OreFeature1(OreFeatureConfig1::deserialize));
    public static final RegistryObject<Feature<NoFeatureConfig>> VOID_START_PLATFORM1 = FEATURES.register("void_start_platform1", () ->  new VoidStartPlatformFeature1(NoFeatureConfig.field_236558_a_));

}
